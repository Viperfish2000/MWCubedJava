package com.viperfish2000.world.biome;

import java.util.Collections;

import com.viperfish2000.crocodile.Crocodile;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
//@ObjectHolder(Voyage.MODID)
public class MinenauticaBiomes {

	public static Biome alps;

	@SubscribeEvent
	public static void registerBiomes(final RegistryEvent.Register<Biome> event) {

		// Before registering the biomes, register all needed helper instances
		registerSurfaceBuilderInstances();
		IForgeRegistry<Biome> reg = event.getRegistry();
		alps = registery(reg, new SafeShallowsBiome(), "alps", 10, false, false, BiomeType.COOL, Type.FOREST, Type.OVERWORLD);
	}

	private static Biome registery(IForgeRegistry<Biome> reg, Biome biome, String name, int weight, boolean canSpawn, boolean oceanBiome,
			BiomeType managerType, Type... dictTypes) {
		reg.register(biome.setRegistryName(Crocodile.location(name)));
		
		BiomeManager.addBiome(managerType, new BiomeManager.BiomeEntry(biome, weight));
		if (oceanBiome)
			BiomeManager.oceanBiomes.add(biome);
		Collections.addAll(Biome.BIOMES, biome);
				
		if (canSpawn)
			BiomeManager.addSpawnBiome(biome);
		
		BiomeDictionary.addTypes(biome, dictTypes);
		return biome;
	}

	// A static instance of the SurfaceBuilder class for each biome will be
	// initialized and stored below
	public static SurfaceBuilder<SurfaceBuilderConfig> safe_shallows_surface_builder;
	
	/*
	 * Register the instances of the SurfaceBuilders so that they aren't initalized
	 * in the biomes to null
	 */
	public static void registerSurfaceBuilderInstances() {
		safe_shallows_surface_builder = new SafeShallowsSurfaceBuilder(SurfaceBuilderConfig::deserialize);
	}

	/*
	 * Note that this happens after the biomes register (why we need to register the
	 * instances seperatly)
	 */
	@SubscribeEvent
	public static void registerSurfaceBuilders(final RegistryEvent.Register<SurfaceBuilder<?>> event) {
		IForgeRegistry<SurfaceBuilder<?>> reg = event.getRegistry();
		reg.register(
				safe_shallows_surface_builder.setRegistryName(Crocodile.location("safe_shallows_surface_builder")));
	}
	

}
