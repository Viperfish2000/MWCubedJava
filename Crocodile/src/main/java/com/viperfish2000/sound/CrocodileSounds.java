package com.viperfish2000.sound;


import com.google.common.collect.Lists;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.registries.ObjectHolder;

import net.minecraftforge.fml.common.registry.GameRegistry;
import java.util.List;
@EventBusSubscriber(modid = "crocodile", bus = EventBusSubscriber.Bus.MOD)
@ObjectHolder("crocodile")
public class CrocodileSounds {
    private static List<SoundEvent> sounds = Lists.newArrayList();
    public static final SoundEvent ENTITY_CROCODILE_WARNING = createSound("entity.crocodile.warning");
    public static final SoundEvent ENTITY_CROCODILE_AMBIENT = createSound("entity.crocodile.ambient");
    public static final SoundEvent ENTITY_CROCODILE_BABY_AMBIENT = createSound("entity.crocodile.ambient_baby");
    public static final SoundEvent ENTITY_CROCODILE_HURT = createSound("entity.crocodile.hurt");
    public static final SoundEvent ENTITY_CROCODILE_ATTACK = createSound("entity.crocodile.attack");
 //   public static final SoundEvent ENTITY_CROCODILE_WARNING = createSound("peeper.ambient");
	public static final SoundEvent ENTITY_CROCODILE_DEATH = createSound("entity.crocodile.death");
    
    
    private static SoundEvent createSound(String name) {
        ResourceLocation resourceLocation = new ResourceLocation("crocodile", name);
        SoundEvent sound = new SoundEvent(resourceLocation);
        sound.setRegistryName(resourceLocation);
        sounds.add(sound);
        return sound;
    }

    @SubscribeEvent
    public static void registerSound(RegistryEvent.Register<SoundEvent> event) {
        for (SoundEvent sound : sounds) {
            event.getRegistry().register(sound);
        }
    }
}