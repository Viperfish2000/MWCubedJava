package com.viperfish2000.crocodile;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.viperfish2000.block.BlockList;
import com.viperfish2000.client.renderer.BearDogRenderer;
import com.viperfish2000.client.renderer.ChestBoatRenderer;
import com.viperfish2000.client.renderer.CrewmateRenderer;
import com.viperfish2000.client.renderer.CrocodileRenderer;
import com.viperfish2000.client.renderer.FrogRenderer;
import com.viperfish2000.client.renderer.FrozenSlimeRenderer;
import com.viperfish2000.client.renderer.GoatRenderer;
import com.viperfish2000.client.renderer.HammerheadRenderer;
import com.viperfish2000.client.renderer.HoneySlimeRenderer;
import com.viperfish2000.client.renderer.LanternSharkRenderer;
import com.viperfish2000.client.renderer.MegalodonRenderer;
import com.viperfish2000.client.renderer.NarwhalRenderer;
import com.viperfish2000.client.renderer.OrcaRenderer;
import com.viperfish2000.client.renderer.OstrichHorseRenderer;
import com.viperfish2000.client.renderer.OtterPenguinRenderer;
import com.viperfish2000.client.renderer.PlatypusRenderer;
import com.viperfish2000.client.renderer.RedPandaRenderer;
import com.viperfish2000.client.renderer.ReefSharkRenderer;
import com.viperfish2000.client.renderer.RiverDolphinRenderer;
import com.viperfish2000.client.renderer.ThresherSharkRenderer;
import com.viperfish2000.client.renderer.WhaleSharkRenderer;
import com.viperfish2000.entity.CrocodileEntities;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.client.renderer.entity.BoatRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Crocodile.MODID)
public class Crocodile {

	public static final String MODID = "crocodile";
	
	private static final Logger LOGGER = LogManager.getLogger();
	
	/* Main Crocodile constructor */
	public Crocodile() {
		LOGGER.info("Welcome to Crocodile!");
		
		// Register the methods for preinitialization and client setup
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onClientSetup);
		
		// Register this class for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(ModEventSubscriber.class);
	}
	
	/* In charge of preinitialization */
	private void setup(final FMLCommonSetupEvent event) {
		LOGGER.info("Loading Crocodile preinitialization.");
    }

	/* In charge of client initialization */
    private void onClientSetup(final FMLClientSetupEvent event) {
        RenderingRegistry.registerEntityRenderingHandler(CrocodileEntities.CROCODILE, manager -> new CrocodileRenderer(manager));
        //RenderingRegistry.registerEntityRenderingHandler(CrocodileEntities.WOLF, manager -> new WolfModRenderer(manager));
        RenderingRegistry.registerEntityRenderingHandler(CrocodileEntities.REEF_SHARK, manager -> new ReefSharkRenderer(manager));
        RenderingRegistry.registerEntityRenderingHandler(CrocodileEntities.LANTERN_SHARK, manager -> new LanternSharkRenderer(manager));
        RenderingRegistry.registerEntityRenderingHandler(CrocodileEntities.WHALE_SHARK, manager -> new WhaleSharkRenderer(manager));
        RenderingRegistry.registerEntityRenderingHandler(CrocodileEntities.THRESHER_SHARK, manager -> new ThresherSharkRenderer(manager));
        RenderingRegistry.registerEntityRenderingHandler(CrocodileEntities.HAMMERHEAD, manager -> new HammerheadRenderer(manager));
        RenderingRegistry.registerEntityRenderingHandler(CrocodileEntities.ORCA, manager -> new OrcaRenderer(manager));
        RenderingRegistry.registerEntityRenderingHandler(CrocodileEntities.NARWHAL, manager -> new NarwhalRenderer(manager));
        RenderingRegistry.registerEntityRenderingHandler(CrocodileEntities.RED_PANDA, manager -> new RedPandaRenderer(manager));
        RenderingRegistry.registerEntityRenderingHandler(CrocodileEntities.OSTRICH_HORSE, manager -> new OstrichHorseRenderer(manager));
        RenderingRegistry.registerEntityRenderingHandler(CrocodileEntities.BOAT, manager -> new BoatRenderer(manager));
        RenderingRegistry.registerEntityRenderingHandler(CrocodileEntities.CHEST_BOAT, manager -> new ChestBoatRenderer(manager));
        RenderingRegistry.registerEntityRenderingHandler(CrocodileEntities.MEGALODON, manager -> new MegalodonRenderer(manager));
        RenderingRegistry.registerEntityRenderingHandler(CrocodileEntities.GOAT, manager -> new GoatRenderer(manager));
        RenderingRegistry.registerEntityRenderingHandler(CrocodileEntities.PLATYPUS, manager -> new PlatypusRenderer(manager));
        RenderingRegistry.registerEntityRenderingHandler(CrocodileEntities.FROG, manager -> new FrogRenderer(manager));
        RenderingRegistry.registerEntityRenderingHandler(CrocodileEntities.BEAR_DOG, manager -> new BearDogRenderer(manager));
        RenderingRegistry.registerEntityRenderingHandler(CrocodileEntities.OTTER_PENGUIN, manager -> new OtterPenguinRenderer(manager));
        RenderingRegistry.registerEntityRenderingHandler(CrocodileEntities.CREWMATE, manager -> new CrewmateRenderer(manager));
        RenderingRegistry.registerEntityRenderingHandler(CrocodileEntities.HONEY_SLIME, manager -> new HoneySlimeRenderer(manager));
        RenderingRegistry.registerEntityRenderingHandler(CrocodileEntities.FROZEN_SLIME, manager -> new FrozenSlimeRenderer(manager));
        RenderingRegistry.registerEntityRenderingHandler(CrocodileEntities.RIVER_DOLPHIN, manager -> new RiverDolphinRenderer(manager));
        
        
    	RenderTypeLookup.setRenderLayer(BlockList.ROSE, RenderType.getCutoutMipped());
    	RenderTypeLookup.setRenderLayer(BlockList.CYAN_ROSE, RenderType.getCutoutMipped());
    	RenderTypeLookup.setRenderLayer(BlockList.GLASS_SLAB, RenderType.getCutoutMipped());
    	RenderTypeLookup.setRenderLayer(BlockList.GLASS_STAIRS, RenderType.getCutoutMipped());
        LOGGER.info("Loading Crocodile client functionality.");
    }
    
    // Double layer render lookup
    public static boolean getDoubleLayer(RenderType layerToCheck) {
    	return layerToCheck == RenderType.getCutoutMipped() || layerToCheck == RenderType.getCutout();
    }
    
	/* In charge of server initialization */
    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
		LOGGER.info("Loading Crocodile server functionality.");
		
		// Load custom commands
	
	}
	
	public static ResourceLocation location(String name) {
		return new ResourceLocation(MODID, name);
	}
}