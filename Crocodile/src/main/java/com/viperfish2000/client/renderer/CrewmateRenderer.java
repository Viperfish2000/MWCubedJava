package com.viperfish2000.client.renderer;

import com.viperfish2000.client.model.CrewmateModel;
import com.viperfish2000.entity.CrewmateEntity;

import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.IRenderFactory;

@OnlyIn(Dist.CLIENT)
public class CrewmateRenderer extends MobRenderer<CrewmateEntity, CrewmateModel<CrewmateEntity>> {
   private static final ResourceLocation CREWMATE_RED = new ResourceLocation(com.viperfish2000.crocodile.Crocodile.MODID,"textures/entity/crewmate/crewmate_red.png");
   private static final ResourceLocation CREWMATE_ORANGE = new ResourceLocation(com.viperfish2000.crocodile.Crocodile.MODID,"textures/entity/crewmate/crewmate_carrot.png");
   private static final ResourceLocation CREWMATE_YELLOW = new ResourceLocation(com.viperfish2000.crocodile.Crocodile.MODID,"textures/entity/crewmate/crewmate_yellow.png");
   private static final ResourceLocation CREWMATE_GREEN = new ResourceLocation(com.viperfish2000.crocodile.Crocodile.MODID,"textures/entity/crewmate/crewmate_green.png");
   private static final ResourceLocation CREWMATE_BLUE = new ResourceLocation(com.viperfish2000.crocodile.Crocodile.MODID,"textures/entity/crewmate/crewmate_blue.png");
   private static final ResourceLocation CREWMATE_PURPLE = new ResourceLocation(com.viperfish2000.crocodile.Crocodile.MODID,"textures/entity/crewmate/crewmate_purple.png");
   private static final ResourceLocation CREWMATE_CYAN = new ResourceLocation(com.viperfish2000.crocodile.Crocodile.MODID,"textures/entity/crewmate/crewmate_cyan.png");
   private static final ResourceLocation CREWMATE_BLACK = new ResourceLocation(com.viperfish2000.crocodile.Crocodile.MODID,"textures/entity/crewmate/crewmate_black.png");
   private static final ResourceLocation CREWMATE_WHITE = new ResourceLocation(com.viperfish2000.crocodile.Crocodile.MODID,"textures/entity/crewmate/crewmate_white.png");
   private static final ResourceLocation CREWMATE_LIME = new ResourceLocation(com.viperfish2000.crocodile.Crocodile.MODID,"textures/entity/crewmate/crewmate_lime.png");
   private static final ResourceLocation CREWMATE_BROWN = new ResourceLocation(com.viperfish2000.crocodile.Crocodile.MODID,"textures/entity/crewmate/crewmate_brown.png");
   private static final ResourceLocation CREWMATE_PINK = new ResourceLocation(com.viperfish2000.crocodile.Crocodile.MODID,"textures/entity/crewmate/crewmate_pink.png");
   
   
   public CrewmateRenderer(EntityRendererManager renderManagerIn) {
      super(renderManagerIn, new CrewmateModel<>(), 0.5F);
    
   }

   /**
    * Defines what float the third param in setRotationAngles of ModelBase is
    */
   protected float handleRotationFloat(CrewmateEntity livingBase, float partialTicks) {
      return livingBase.getTailRotation();
   }

 

   /**
    * Returns the location of an entity's texture.
    */
   public ResourceLocation getEntityTexture(CrewmateEntity entity) {
	      String s = TextFormatting.getTextWithoutFormattingCodes(entity.getName().getString());
	
	         switch(entity.getCrewmateType()) {
	         case 0:
	         default:
	            return CREWMATE_RED;
	         case 1:
	            return CREWMATE_ORANGE;
	         case 2:
	            return CREWMATE_YELLOW;
	         case 3:
	        	 return CREWMATE_GREEN;
	         case 4:
	        	 return CREWMATE_BLUE;
	         case 5:
	        	 return CREWMATE_PURPLE;
	         case 6:
	        	 return CREWMATE_CYAN;
	         case 7:
	        	 return CREWMATE_BLACK;
	         case 8:
	        	 return CREWMATE_WHITE;
	         case 9:
	        	 return CREWMATE_PINK;
	         case 10:
	        	 return CREWMATE_LIME;
	         case 11:
	        	 return CREWMATE_BROWN;
	        
	         }
	      }

	public static class RenderFactory implements IRenderFactory<CrewmateEntity> {

		@Override
		public EntityRenderer<? super CrewmateEntity> createRenderFor(EntityRendererManager manager) {

			return new CrewmateRenderer(manager);
		}

	}

	
}
