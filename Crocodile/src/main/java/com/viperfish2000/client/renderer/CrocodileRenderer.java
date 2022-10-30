package com.viperfish2000.client.renderer;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.viperfish2000.client.model.CrocodileModel;
import com.viperfish2000.crocodile.Crocodile;
import com.viperfish2000.entity.CrocodileEntity;

import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.entity.passive.BatEntity;
import net.minecraft.entity.passive.BeeEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.IRenderFactory;

@OnlyIn(Dist.CLIENT)
public class CrocodileRenderer extends MobRenderer<CrocodileEntity, CrocodileModel<CrocodileEntity>> {
	private static final ResourceLocation PEEPER_LOCATION = new ResourceLocation(Crocodile.MODID,
			"textures/entity/crocodile.png");
	private static final ResourceLocation CHILD = new ResourceLocation(Crocodile.MODID,
			"textures/entity/crocodile_baby.png");
	public CrocodileRenderer(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new CrocodileModel<>(), 1.0F);
	//	  this.addLayer(new CrocodileLayer<>(this));
	}

   /**
    * Returns the location of an entity's texture.
    */
   public ResourceLocation getEntityTexture(CrocodileEntity entity) {
	
		      if (entity.isChild()) {
		         return CHILD;
		      } else {
		         return PEEPER_LOCATION;
		      }
		   
   }
   protected void preRenderCallback(CrocodileEntity entitylivingbaseIn, MatrixStack matrixStackIn, float partialTickTime) {
	     if (!entitylivingbaseIn.isChild()) {
	    	  matrixStackIn.scale(1F, 1F, 1F);
	      } else {
	    	  
	    	  matrixStackIn.scale(0.75F, 0.75F, 0.75F);
	      }
	   
	   }
	protected void applyRotations(CrocodileEntity entityLiving, MatrixStack matrixStackIn, float ageInTicks,
			float rotationYaw, float partialTicks) {
		super.applyRotations(entityLiving, matrixStackIn, ageInTicks, rotationYaw, partialTicks);	
	}

	public static class RenderFactory implements IRenderFactory<CrocodileEntity> {

		@Override
		public EntityRenderer<? super CrocodileEntity> createRenderFor(EntityRendererManager manager) {

			return new CrocodileRenderer(manager);
		}

	}
}
