package com.viperfish2000.entity;

import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.horse.AbstractChestedHorseEntity;
import net.minecraft.entity.passive.horse.AbstractHorseEntity;
import net.minecraft.entity.passive.horse.HorseEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;

public class OstrichHorseEntity extends AbstractChestedHorseEntity {
   public OstrichHorseEntity(EntityType<? extends OstrichHorseEntity> p_i50239_1_, World p_i50239_2_) {
      super(p_i50239_1_, p_i50239_2_);
   }

   protected SoundEvent getAmbientSound() {
      super.getAmbientSound();
      return SoundEvents.ENTITY_DONKEY_AMBIENT;
   }

   protected SoundEvent getDeathSound() {
      super.getDeathSound();
      return SoundEvents.ENTITY_DONKEY_DEATH;
   }

   protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
      super.getHurtSound(damageSourceIn);
      return SoundEvents.ENTITY_DONKEY_HURT;
   }
   protected boolean canMate() {
	      return !this.isBeingRidden() && !this.isPassenger() && this.isTame() && !this.isChild() && this.getHealth() >= this.getMaxHealth() && this.isInLove();
	   }
   /**
    * Returns true if the mob is currently able to mate with the specified mob.
    */
   public boolean canMateWith(AnimalEntity otherAnimal) {
      if (otherAnimal == this) {
         return false;
      } else if (!(otherAnimal instanceof OstrichHorseEntity) && !(otherAnimal instanceof HorseEntity)) {
         return false;
      } else {
         return this.canMate();
      }
   }

   public AgeableEntity createChild(AgeableEntity ageable) {
      EntityType<? extends AbstractHorseEntity> entitytype = ageable instanceof HorseEntity ? EntityType.MULE : EntityType.DONKEY;
      AbstractHorseEntity abstracthorseentity = entitytype.create(this.world);
      this.setOffspringAttributes(ageable, abstracthorseentity);
      return abstracthorseentity;
   }
}