package com.viperfish2000.client.renderer;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.viperfish2000.client.model.GoatModel;
import com.viperfish2000.crocodile.Crocodile;
import com.viperfish2000.entity.GoatEntity;

import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.IRenderFactory;

@OnlyIn(Dist.CLIENT)
public class GoatRenderer extends MobRenderer<GoatEntity, GoatModel<GoatEntity>> {
	private static final ResourceLocation PEEPER_LOCATION = new ResourceLocation(Crocodile.MODID,
			"textures/entity/goat.png");
	
	public GoatRenderer(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new GoatModel<>(), 1.0F);
	
	}

   /**
    * Returns the location of an entity's texture.
    */
   public ResourceLocation getEntityTexture(GoatEntity entity) {
	
		return PEEPER_LOCATION;
		   
   }
   protected void preRenderCallback(GoatEntity entitylivingbaseIn, MatrixStack matrixStackIn, float partialTickTime) {
	   /**
	   if (!entitylivingbaseIn.isChild()) {
	    	  matrixStackIn.scale(1F, 1F, 1F);
	      } else {
	    	  
	    	  matrixStackIn.scale(0.75F, 0.75F, 0.75F);
	      }
	   **/
	   }
	protected void applyRotations(GoatEntity entityLiving, MatrixStack matrixStackIn, float ageInTicks,
			float rotationYaw, float partialTicks) {
		super.applyRotations(entityLiving, matrixStackIn, ageInTicks, rotationYaw, partialTicks);	
	}

	public static class RenderFactory implements IRenderFactory<GoatEntity> {

		@Override
		public EntityRenderer<? super GoatEntity> createRenderFor(EntityRendererManager manager) {

			return new GoatRenderer(manager);
		}

	}
}
