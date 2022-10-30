package com.viperfish2000.item;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class EmeraldArmorItem extends ArmorItem {
	public EmeraldArmorItem(IArmorMaterial material, EquipmentSlotType equipmentSlot, Item.Properties properties) {
		super(material, equipmentSlot, properties);
	}

	@OnlyIn(Dist.CLIENT)
	public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
		super.inventoryTick(stack, worldIn, entityIn, itemSlot, isSelected);
		int counter = 0;
		for (ItemStack s : entityIn.getArmorInventoryList()) {
			// Added worldIn.isRemote() to handle strange behavior with alternating sides
		
			if (!worldIn.isRemote && (s.getItem() == ItemList.EMERALD_HELMET || s.getItem() == ItemList.EMERALD_CHESTPLATE || s.getItem() == ItemList.EMERALD_BOOTS || s.getItem() == ItemList.EMERALD_LEGGINGS)) 
			{
				counter++;
			}
		}
		if (counter == 4) {
			((PlayerEntity) entityIn).addPotionEffect(new EffectInstance(Effects.HERO_OF_THE_VILLAGE, 60, 0, false, false));
			
		}
	}
}
