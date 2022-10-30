package com.viperfish2000.client.renderer;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.viperfish2000.client.model.ThresherModel;
import com.viperfish2000.entity.ThresherEntity;

import net.minecraft.client.renderer.Vector3f;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.IRenderFactory;

@OnlyIn(Dist.CLIENT)
public class ThresherSharkRenderer extends MobRenderer<ThresherEntity, ThresherModel<ThresherEntity>> {
	private static final ResourceLocation PEEPER_LOCATION = new ResourceLocation(com.viperfish2000.crocodile.Crocodile.MODID,
			"textures/entity/thresher_shark.png");

	public ThresherSharkRenderer(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new ThresherModel<>(), 0.7F);
	}

   /**
    * Returns the location of an entity's texture.
    */
   public ResourceLocation getEntityTexture(ThresherEntity entity) {
      return PEEPER_LOCATION;
   }
	protected void applyRotations(ThresherEntity entityLiving, MatrixStack matrixStackIn, float ageInTicks,
			float rotationYaw, float partialTicks) {
		super.applyRotations(entityLiving, matrixStackIn, ageInTicks, rotationYaw, partialTicks);

		if (!entityLiving.isInWater()) {
			
		}
		matrixStackIn.scale(1.6F, 1.6F, 1.6F);

	//	matrixStackIn.rotate(Vector3f.YP.rotationDegrees(f2));
		matrixStackIn.translate(0.0D, 0.5, (double) -0.4F);
		  if (!((double)entityLiving.limbSwingAmount < 0.01D)) {
		         float f = 13.0F;
		         float f1 = entityLiving.limbSwing - entityLiving.limbSwingAmount * (1.0F - partialTicks) + 6.0F;
		         float f2 = (Math.abs(f1 % 13.0F - 6.5F) - 3.25F) / 3.25F;
		     //    matrixStackIn.rotate(Vector3f.ZP.rotationDegrees(6.5F * f2));

	}
	}

	public static class RenderFactory implements IRenderFactory<ThresherEntity> {

		@Override
		public EntityRenderer<? super ThresherEntity> createRenderFor(EntityRendererManager manager) {

			return new ThresherSharkRenderer(manager);
		}

	}
}