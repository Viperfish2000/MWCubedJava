package com.viperfish2000.crocodile;

import com.viperfish2000.block.BlockList;
import com.viperfish2000.block.ModStairsBlock;
import com.viperfish2000.effect.EffectList;
import com.viperfish2000.enchantment.EnchantmentList;
import com.viperfish2000.enchantment.MagmaWalkerEnchantment;
import com.viperfish2000.item.ArmorMaterialList;
import com.viperfish2000.item.EmeraldArmorItem;
import com.viperfish2000.item.EmeraldSwordItem;
import com.viperfish2000.item.ItemTierMod;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FlowerBlock;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.FrostWalkerEnchantment;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.AxeItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;
import net.minecraft.potion.Effects;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.registries.IForgeRegistryEntry;

@EventBusSubscriber(modid = Crocodile.MODID, bus = EventBusSubscriber.Bus.MOD)
public class ModEventSubscriber {
	
	@SubscribeEvent
	public static void onRegisterItems(RegistryEvent.Register<Item> event) {
		
		// Initialize the items
		event.getRegistry().registerAll(
				setup (new EmeraldArmorItem(ArmorMaterialList.emerald, EquipmentSlotType.HEAD, new Item.Properties().group(ItemGroup.COMBAT)),"emerald_helmet"),
				setup (new EmeraldArmorItem(ArmorMaterialList.emerald, EquipmentSlotType.CHEST, new Item.Properties().group(ItemGroup.COMBAT)),"emerald_chestplate"),
				setup (new EmeraldArmorItem(ArmorMaterialList.emerald, EquipmentSlotType.LEGS, new Item.Properties().group(ItemGroup.COMBAT)),"emerald_leggings"),
				setup (new EmeraldArmorItem(ArmorMaterialList.emerald, EquipmentSlotType.FEET, new Item.Properties().group(ItemGroup.COMBAT)),"emerald_boots"),
				setup (new EmeraldSwordItem(ItemTierMod.EMERALD, 2, -2.4F, new Item.Properties().group(ItemGroup.COMBAT)),"emerald_sword"),
				setup (new ShovelItem(ItemTierMod.EMERALD, 1.5F, -3.0F, (new Item.Properties()).group(ItemGroup.TOOLS)),"emerald_shovel"),
				setup (new PickaxeItem(ItemTierMod.EMERALD, 1, -2.8F, (new Item.Properties()).group(ItemGroup.TOOLS)),"emerald_pickaxe"),
				setup (new AxeItem(ItemTierMod.EMERALD, 6.0F, -3.0F, (new Item.Properties()).group(ItemGroup.TOOLS)),"emerald_axe"),
				setup (new HoeItem(ItemTierMod.EMERALD, -1.0F, (new Item.Properties()).group(ItemGroup.TOOLS)), "emerald_hoe" ));
		
		// Initialize the block items
		event.getRegistry().registerAll(
				setup(new BlockItem(BlockList.SNOWY_STONE, new Item.Properties()), "snowy_stone"),	
				setup(new BlockItem(BlockList.DIRT_STAIRS, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)), "dirt_stairs"),
				setup(new BlockItem(BlockList.DIRT_SLAB, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)), "dirt_slab"),
				setup(new BlockItem(BlockList.ROSE, new Item.Properties().group(ItemGroup.DECORATIONS)), "rose"),
				setup(new BlockItem(BlockList.CYAN_ROSE, new Item.Properties().group(ItemGroup.DECORATIONS)), "cyan_rose"),
				setup(new BlockItem(BlockList.GLASS_SLAB, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)), "glass_slab"),
				setup(new BlockItem(BlockList.GLASS_STAIRS, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)), "glass_stairs")
				);
	}
	
	@SubscribeEvent
	public static void onRegisterBlocks(RegistryEvent.Register<Block> event) {
		
		// Initialize the blocks
		event.getRegistry().registerAll(
				setup(new Block(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F)),"snowy_stone"),
				setup(new FlowerBlock(Effects.REGENERATION, 9, Block.Properties.create(Material.PLANTS).doesNotBlockMovement().hardnessAndResistance(0F, 0F).sound(SoundType.PLANT)),"rose"),
				setup(new SlabBlock(Block.Properties.from(Blocks.DIRT)),"dirt_slab"),
				setup(new ModStairsBlock(Blocks.DIRT.getDefaultState(), Block.Properties.from(Blocks.DIRT)),"dirt_stairs"),
				setup(new FlowerBlock(Effects.REGENERATION, 9, Block.Properties.create(Material.PLANTS).doesNotBlockMovement().hardnessAndResistance(0F, 0F).sound(SoundType.PLANT)),"cyan_rose"),
				setup(new SlabBlock(Block.Properties.from(Blocks.GLASS)),"glass_slab"),
				setup(new ModStairsBlock(Blocks.DIRT.getDefaultState(), Block.Properties.from(Blocks.GLASS)),"glass_stairs")	
				);
	}
	
	
	@SubscribeEvent
	public static void onRegisterEffects(RegistryEvent.Register<Effect> event) {
		
		// Initialize the blocks
		event.getRegistry().registerAll(
				EffectList.HONEY = new HoneyEffect(EffectType.HARMFUL, 16757310).addAttributesModifier(SharedMonsterAttributes.ATTACK_SPEED, "55FCED67-E92A-486E-9800-B47F202C4386", (double)-0.1F, AttributeModifier.Operation.MULTIPLY_TOTAL).addAttributesModifier(SharedMonsterAttributes.MOVEMENT_SPEED, "7107DE5E-7CE8-4030-940E-514C1F160890", (double)-0.15F, AttributeModifier.Operation.MULTIPLY_TOTAL).setRegistryName(new ResourceLocation(Crocodile.MODID, "honey_effect")),
				EffectList.RADIATION = new HoneyEffect(EffectType.HARMFUL, 3139864).addAttributesModifier(SharedMonsterAttributes.ATTACK_SPEED, "55FCED67-E92A-486E-9800-B47F202C4386", (double)-0.1F, AttributeModifier.Operation.MULTIPLY_TOTAL).addAttributesModifier(SharedMonsterAttributes.MOVEMENT_SPEED, "7107DE5E-7CE8-4030-940E-514C1F160890", (double)-0.15F, AttributeModifier.Operation.MULTIPLY_TOTAL).setRegistryName(new ResourceLocation(Crocodile.MODID, "radiation_effect")),
						
				EffectList.FROZEN = new HoneyEffect(EffectType.HARMFUL, 16757310).addAttributesModifier(SharedMonsterAttributes.MOVEMENT_SPEED, "7107DE5E-7CE8-4030-940E-514C1F160890", (double)-0.9F, AttributeModifier.Operation.MULTIPLY_TOTAL).setRegistryName(new ResourceLocation(Crocodile.MODID, "frozen_effect"))
				
			
				);
	}
	
	@SubscribeEvent
	public static void onRegisterEnchantments(RegistryEvent.Register<Enchantment> event) {
		
		// Initialize the blocks
		event.getRegistry().registerAll(
			
				EnchantmentList.MAGMA_WALKER = new MagmaWalkerEnchantment(Enchantment.Rarity.RARE, EquipmentSlotType.FEET).setRegistryName(new ResourceLocation(Crocodile.MODID, "magma_walker" ))
				 	
				);
	}
	public static <T extends IForgeRegistryEntry<T>> T setup(final T entry, final String name) {
		return setup(entry, new ResourceLocation(Crocodile.MODID, name));
	}

	public static <T extends IForgeRegistryEntry<T>> T setup(final T entry, final ResourceLocation registryName) {
		entry.setRegistryName(registryName);
		return entry;
	}
	

}