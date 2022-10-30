package com.viperfish2000.world.biome;

import java.util.Random;
import java.util.function.Function;

import com.mojang.datafixers.Dynamic;
import com.viperfish2000.block.BlockList;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.SharedSeedRandom;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.PerlinNoiseGenerator;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

public class SafeShallowsSurfaceBuilder extends SurfaceBuilder<SurfaceBuilderConfig> {
	private static final BlockState WATER = Blocks.WATER.getDefaultState();
	private static final BlockState ROCK = Blocks.STONE.getDefaultState();
	private static final BlockState SAFE_SHALLOWS_ROCK = Blocks.STONE.getDefaultState();

	/** noiseAt ranges from -1 to 1 **/
	PerlinNoiseGenerator noiseGen = new PerlinNoiseGenerator(new SharedSeedRandom(1234L), 0, 0); // TODO: Is this
																									// implementation of
																									// the seed naive?
	/* Boundary Smoothing Code */
	private static IChunk chunk;
	private static int[][] distances = new int[16][16];
	private static boolean[][] isBiome = new boolean[16][16];
	
	/* Constants */
	private static int borderSmoothingLength = 2; // The length of the smoothing between plateaus 
	private static int biomeSmoothingLength = 13; // The length of the smoothing between biomes
	private static double scalingFactor = 19.0; // The smaller the number, the smaller the plateaus
	private static double percentageTop = 1.3; // The larger the number, the higher the biome gets
	private static double percentageBottom = 0.1; // The smaller the number, the deeper the biome gets
	private static int safeShallowsRockHeight = 3; // Height of safe shallows rock layer underneath sand
	
	public SafeShallowsSurfaceBuilder(Function<Dynamic<?>, ? extends SurfaceBuilderConfig> p_i51313_1_) {
		super(p_i51313_1_);
	}

	private double getNoise(int x, int z) {
		return (int) (PerlinNoise.noise(x / scalingFactor, z / scalingFactor) * 5) / 5.0;
	}

	private void setupDistances() {
		for (int x = 0; x < 16; x++) {
			for (int z = 0; z < 16; z++) {
				if (!isBiome[x][z]) {
					setupRecur(x, z, biomeSmoothingLength);
				}
			}
		}
	}

	private void setupRecur(int x, int z, int distance) {
		distances[x][z] = distance--;
		if (distance <= 0)
			return;
		if (x > 0 && distances[x - 1][z] < distance)
			setupRecur(x - 1, z, distance);
		if (x < 15 && distances[x + 1][z] < distance)
			setupRecur(x + 1, z, distance);
		if (z > 0 && distances[x][z - 1] < distance)
			setupRecur(x, z - 1, distance);
		if (z < 15 && distances[x][z + 1] < distance)
			setupRecur(x, z + 1, distance);
	}

	public void buildSurface(Random random, IChunk chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise, BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, SurfaceBuilderConfig config) {
		// Null Case
		if(chunk == null)
			chunk = chunkIn;
		
		// Reset all chunk variables
		if(x >> 4 != chunk.getPos().x || z >> 4 != chunk.getPos().z) {
			
			// Build the distance array
			setupDistances();
			
			// Build the surface for all loaded chunks
			for(int xIndex = 0; xIndex < 16; xIndex++) {
				for(int zIndex = 0; zIndex < 16; zIndex++) {
					if(isBiome[xIndex][zIndex])
						buildSurface(chunk, xIndex + chunk.getPos().getXStart(), zIndex + chunk.getPos().getZStart());
				}
			}
			
			chunk = chunkIn;
			distances = new int[16][16];
			isBiome = new boolean[16][16];
		}
		
		int xScaled = x & 15;
		int zScaled = z & 15;
		isBiome[xScaled][zScaled] = true;
	}
	
	public void buildSurface(IChunk chunkIn, int x, int z) {

		// General Setup
		int xScaled = x & 15;
		int zScaled = z & 15;
		BlockPos.Mutable blockpos$mutable = new BlockPos.Mutable().setPos(xScaled, 255, zScaled);

		double noise = getNoise(x, z);
		
		// Adjust the noise based on the neighbors
		for(int xOffset = 0; xOffset <= borderSmoothingLength / 2; xOffset++) {
			for(int zOffset = borderSmoothingLength / 2 - xOffset; zOffset >= 0; zOffset--) {
				noise = (noise + getNoise(x - xOffset, z - zOffset)) / 2;
				noise = (noise + getNoise(x + xOffset, z - zOffset)) / 2;
				noise = (noise + getNoise(x - xOffset, z + zOffset)) / 2;
				noise = (noise + getNoise(x + xOffset, z + zOffset)) / 2;
			}
		}
		
		// Turn the noise into the height fraction
		double heightFraction = (percentageTop - percentageBottom) / 2 * (noise - 1) + percentageTop;
		
		// Adjust the height fraction based on biome boundaries
		heightFraction = (float) distances[xScaled][zScaled] / biomeSmoothingLength + (float) (biomeSmoothingLength - distances[xScaled][zScaled]) / biomeSmoothingLength * heightFraction;

		// Determine the sand height
		int y = 255;
		int sandHeight = -1;
		for (; y >= 0; blockpos$mutable.setY(--y)) {
			BlockState block = chunkIn.getBlockState(blockpos$mutable);
			if (block != AIR && block != WATER) {
				sandHeight = y;
				break;
			}
		}

		// Recalibrate the sand height
		sandHeight = (int) (sandHeight * heightFraction);

		// Set water until the sand
		for (; y > sandHeight; blockpos$mutable.setY(--y)) {
			if (y <= 62)
				chunkIn.setBlockState(blockpos$mutable, WATER, false);
			else
				chunkIn.setBlockState(blockpos$mutable, AIR, false);
		}
		for (; y < sandHeight; blockpos$mutable.setY(++y)) {
			if (y <= 62)
				chunkIn.setBlockState(blockpos$mutable, WATER, false);
			else
				chunkIn.setBlockState(blockpos$mutable, AIR, false);
		}
		
		// Re-check the height again (in case we are now within a cave or a ravine)
		while(chunkIn.getFluidState(blockpos$mutable).isTagged(FluidTags.WATER) || chunkIn.getBlockState(blockpos$mutable) == AIR)
			blockpos$mutable.setY(++y);
			
		// Set the sand and the rock
		if(y > 105) {
			chunkIn.setBlockState(blockpos$mutable.up(2), Blocks.SNOW_BLOCK.getDefaultState(), false);
			chunkIn.setBlockState(blockpos$mutable.up(), BlockList.SNOWY_STONE.getDefaultState(), false);
			chunkIn.setBlockState(blockpos$mutable, Blocks.STONE.getDefaultState(), false);
		}
		else if(y == 105) {
			chunkIn.setBlockState(blockpos$mutable.up(2), Blocks.SNOW_BLOCK.getDefaultState(), false);
			chunkIn.setBlockState(blockpos$mutable.up(), BlockList.SNOWY_STONE.getDefaultState(), false);
			chunkIn.setBlockState(blockpos$mutable, Blocks.STONE.getDefaultState(), false);
		}
		else if(y > 62 && y < 105) {
			chunkIn.setBlockState(blockpos$mutable.up(), Blocks.GRASS_BLOCK.getDefaultState(), false);
			chunkIn.setBlockState(blockpos$mutable, Blocks.STONE.getDefaultState(), false);
		}
		else if (y == 62) {
			chunkIn.setBlockState(blockpos$mutable.up(), Blocks.STONE.getDefaultState(), false);
			chunkIn.setBlockState(blockpos$mutable, SAFE_SHALLOWS_ROCK, false);
		} else {
			chunkIn.setBlockState(blockpos$mutable.up(), SAND, false);
			chunkIn.setBlockState(blockpos$mutable, SAFE_SHALLOWS_ROCK, false);
		}
		for (blockpos$mutable.setY(--y); y >= sandHeight - safeShallowsRockHeight; blockpos$mutable.setY(--y)) {
			BlockState block = chunkIn.getBlockState(blockpos$mutable);
			if (block != WATER && block != AIR) {
				if(y > 62)
					chunkIn.setBlockState(blockpos$mutable, STONE, false);
				else
					chunkIn.setBlockState(blockpos$mutable, SAFE_SHALLOWS_ROCK, false);
			}
			else {
				break;
			}
		}

		boolean prevInWater = false;
		int setRockTimer = 0;

		// Set the remaining of the blocks!
		for (; y >= 0; blockpos$mutable.setY(--y)) {
			BlockState block = chunkIn.getBlockState(blockpos$mutable);

			if (block == WATER) {
				prevInWater = true;
				setRockTimer = 0;
			} else if (block != AIR) {
				if (setRockTimer > 0) {
					chunkIn.setBlockState(blockpos$mutable, SAFE_SHALLOWS_ROCK, false);
					setRockTimer--;
				} else if (prevInWater) // Deal with the surface sand case, and set the five layers below to safe
										// shallows rock
				{
					chunkIn.setBlockState(blockpos$mutable, SAND, false);
					setRockTimer = safeShallowsRockHeight;
				} else if (block == STONE) { // Set all stone to our custom stone
					chunkIn.setBlockState(blockpos$mutable, ROCK, false);
				}
				prevInWater = false;
			}
		}
		
		/* TESTING */
		blockpos$mutable.setY((int) (30 * heightFraction + 70));
	//chunkIn.setBlockState(blockpos$mutable, Blocks.RED_STAINED_GLASS.getDefaultState(), false);
	}
}