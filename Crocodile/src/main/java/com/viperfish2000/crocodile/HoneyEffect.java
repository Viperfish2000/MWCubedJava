package com.viperfish2000.crocodile;

import com.viperfish2000.effect.EffectList;

import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;

public class HoneyEffect extends Effect {
    public HoneyEffect(EffectType typeIn, int liquidColorIn) {
		super(typeIn, liquidColorIn);
		// TODO Auto-generated constructor stub
	}

    public void performEffect(LivingEntity entityLivingBaseIn, int amplifier) {
    if (this == EffectList.FROZEN) {
           entityLivingBaseIn.attackEntityFrom(DamageSource.WITHER, 1.0F);
        } 
    //16757310
     }
    public boolean isReady(int duration, int amplifier) {
        if (this == EffectList.FROZEN) {
           int k = 50 >> amplifier;
           if (k > 0) {
              return duration % k == 0;
           } else {
              return true;
           }}
		return false;
    }
    
  }
