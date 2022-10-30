package com.viperfish2000.entity;

import java.util.List;

import com.google.common.base.CaseFormat;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.viperfish2000.crocodile.Crocodile;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.item.BoatEntity;
import net.minecraft.entity.passive.WolfEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.registries.ForgeRegistries;

@EventBusSubscriber(modid = "crocodile", bus = EventBusSubscriber.Bus.MOD)
public class CrocodileEntities {
    private static List<EntityType> entities = Lists.newArrayList();
    private static List<Item> spawnEggs = Lists.newArrayList();

    public static final EntityType<CrocodileEntity> CROCODILE = createEntity(CrocodileEntity.class, CrocodileEntity::new, 1.65F, 0.96F, 0x335917, 0x1f360e);
   // public static final EntityType<WolfEntity> WOLF = createEntity(WolfEntity.class, WolfEntity::new, 1.65F, 0.96F, 0x335917, 0x1f360e);
    public static final EntityType<ReefSharkEntity> REEF_SHARK = createEntity(ReefSharkEntity.class, ReefSharkEntity::new, 1.1F, 0.9F, 0x335917, 0x1f360e);
    public static final EntityType<HammerheadEntity> HAMMERHEAD = createEntity(HammerheadEntity.class, HammerheadEntity::new, 1.6F, 1.3F, 0x335917, 0x1f360e);
    public static final EntityType<WhaleSharkEntity> WHALE_SHARK = createEntity(WhaleSharkEntity.class, WhaleSharkEntity::new, 5.0F, 3.5F, 0x335917, 0x1f360e);
    public static final EntityType<ThresherEntity> THRESHER_SHARK = createEntity(ThresherEntity.class, ThresherEntity::new, 1.2F, 0.5F, 0x335917, 0x1f360e);
    public static final EntityType<LanternSharkEntity> LANTERN_SHARK = createEntity(LanternSharkEntity.class, LanternSharkEntity::new, 0.8F, 0.8F, 0x335917, 0x1f360e);
    public static final EntityType<OrcaEntity> ORCA = createEntity(OrcaEntity.class, OrcaEntity::new, 2.8F, 2.8F, 0x335917, 0x1f360e);
    public static final EntityType<NarwhalEntity> NARWHAL = createEntity(NarwhalEntity.class, NarwhalEntity::new, 1.6F, 2.8F, 0x335917, 0x1f360e);
    public static final EntityType<RedPandaEntity> RED_PANDA = createEntity(RedPandaEntity.class, RedPandaEntity::new, 1F, 1F, 0x335917, 0x1f360e);
    public static final EntityType<OstrichHorseEntity> OSTRICH_HORSE = createEntity(OstrichHorseEntity.class, OstrichHorseEntity::new, 2.0F, 2.0F, 0x335917, 0x1f360e);
    public static EntityType<? extends BoatEntity> BOAT; //  public static final EntityType<? extends BoatEntity> BOAT= createEntity(net.minecraft.entity.item.BoatEntity.class, net.minecraft.entity.item.BoatEntity::new, 2.0F, 2.0F, 0x335917, 0x1f360e);
    public static EntityType<? extends ChestBoatEntity> CHEST_BOAT;
    public static final EntityType<FrogEntity> FROG = createEntity(FrogEntity.class, FrogEntity::new, 0.5F, 0.5F, 0x335917, 0x1f360e);
    public static final EntityType<MegalodonEntity> MEGALODON = createEntity(MegalodonEntity.class, MegalodonEntity::new, 6.0F, 1.5F, 0x335917, 0x1f360e);
    public static final EntityType<GoatEntity> GOAT = createEntity(GoatEntity.class, GoatEntity::new, 1.0F, 1.3F, 0x335917, 0x1f360e);
    public static final EntityType<WolfEntity> PLATYPUS = createEntity(WolfEntity.class, WolfEntity::new, 0.65F, 0.76F, 0x335917, 0x1f360e);
    public static final EntityType<PolarBearDogEntity> BEAR_DOG = createEntity(PolarBearDogEntity.class, PolarBearDogEntity::new,1.4F, 1.4F, 0x335917, 0x1f360e);
    public static final EntityType<OtterPenguinEntity> OTTER_PENGUIN = createEntity(OtterPenguinEntity.class, OtterPenguinEntity::new,0.8F, 1.2F, 0x335917, 0x1f360e);
    public static final EntityType<FireFerretEntity> FIRE_FERRET = createEntity(FireFerretEntity.class, FireFerretEntity::new, 1F, 1F, 0x335917, 0x1f360e);
    public static final EntityType<CrewmateEntity> CREWMATE = createEntity(CrewmateEntity.class, CrewmateEntity::new, 1F, 1F, 0x335917, 0x1f360e);
    public static final EntityType<RiverDolphinEntity> RIVER_DOLPHIN = createEntity(RiverDolphinEntity.class, RiverDolphinEntity::new, 1.8F, 1.8F, 0x335917, 0x1f360e);
    
    
    
    
    
    
    
    
    
    public static final EntityType<HoneySlimeEntity> HONEY_SLIME = createEntity(HoneySlimeEntity.class, HoneySlimeEntity::new, 1F, 1F, 0xd76f18, 0xff9116);
    
    public static final EntityType<FrozenSlimeEntity> FROZEN_SLIME = createEntity(FrozenSlimeEntity.class, FrozenSlimeEntity::new, 1F, 1F, 0xd76f18, 0xff9116);

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public static final EntityType<RadiationSlimeEntity> RADIATION_SLIME  = createEntity(RadiationSlimeEntity.class, ::new, 1F, 1F, 0xd76f18, 0xff9116);

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    private static <T extends Entity> EntityType<T> createEntity(Class<T> entityClass, EntityType.IFactory<T> factory, float width, float height, int eggPrimary, int eggSecondary) {
        ResourceLocation location = new ResourceLocation("crocodile", classToString(entityClass));
        EntityType<T> entity = EntityType.Builder.create(factory, EntityClassification.CREATURE).size(width, height).setTrackingRange(64).setUpdateInterval(1).build(location.toString());
        entity.setRegistryName(location);
        entities.add(entity);
        Item spawnEgg = new SpawnEggItem(entity, eggPrimary, eggSecondary, (new Item.Properties()).group(ItemGroup.MISC));
        spawnEgg.setRegistryName(new ResourceLocation("crocodile", classToString(entityClass) + "_spawn_egg"));
       spawnEggs.add(spawnEgg);

        return entity;
    }
    
    private static String classToString(Class<? extends Entity> entityClass) {
        return CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, entityClass.getSimpleName()).replace("_entity", "");
    }

    @SubscribeEvent(priority = EventPriority.LOWEST)
    public static void registerPenguins(RegistryEvent.Register<EntityType<?>> event) {
        for (EntityType entity : entities) {
            Preconditions.checkNotNull(entity.getRegistryName(), "registryName");
            event.getRegistry().register(entity);
        }
    }

    @SubscribeEvent
    public static void registerSpawnEggs(RegistryEvent.Register<Item> event) {
        for (Item spawnEgg : spawnEggs) {
            Preconditions.checkNotNull(spawnEgg.getRegistryName(), "registryName");
            event.getRegistry().register(spawnEgg);
        }
    }

    public static void addSpawn() {
      
    }
    @SubscribeEvent
    public static void registerEntities(RegistryEvent.Register<EntityType<?>> event)
    {
        CrocodileEntities.BOAT = EntityType.Builder.<ModBoatEntity>create(ModBoatEntity::new, EntityClassification.MISC).setTrackingRange(80).setUpdateInterval(3).setShouldReceiveVelocityUpdates(true).size(1.375f, 0.5625f).setCustomClientFactory(ModBoatEntity::new).build(Crocodile.MODID + ":boat");
        CrocodileEntities.BOAT.setRegistryName("boat");
        ForgeRegistries.ENTITIES.register(CrocodileEntities.BOAT);
        CrocodileEntities.CHEST_BOAT = EntityType.Builder.<ChestBoatEntity>create(ChestBoatEntity::new, EntityClassification.MISC).setTrackingRange(80).setUpdateInterval(3).setShouldReceiveVelocityUpdates(true).size(1.375f, 0.5625f).setCustomClientFactory(ChestBoatEntity::new).build(Crocodile.MODID + ":chest_boat");
        CrocodileEntities.CHEST_BOAT.setRegistryName("chest_boat");
        ForgeRegistries.ENTITIES.register(CrocodileEntities.CHEST_BOAT);
    }

    public static <T extends Entity> EntityType<T> createEntity(EntityType.IFactory<T> factory, EntityClassification classification, String name, int trackingRange, int updateFrequency, boolean sendsVelocityUpdates)
    {
        ResourceLocation location = new ResourceLocation("crocodile", name);
        EntityType<T> type = EntityType.Builder.<T>create(factory, classification).setTrackingRange(trackingRange).setUpdateInterval(updateFrequency).setShouldReceiveVelocityUpdates(sendsVelocityUpdates).build(location.toString());
        type.setRegistryName(name);
        ForgeRegistries.ENTITIES.register(type);
        return type;
    }

  
}