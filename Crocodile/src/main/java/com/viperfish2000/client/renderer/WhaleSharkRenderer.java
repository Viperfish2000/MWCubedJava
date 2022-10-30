package com.viperfish2000.client.renderer;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.viperfish2000.client.model.WhaleSharkModel;
import com.viperfish2000.entity.WhaleSharkEntity;

import net.minecraft.client.renderer.Vector3f;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.IRenderFactory;

@OnlyIn(Dist.CLIENT)
public class WhaleSharkRenderer extends MobRenderer<WhaleSharkEntity, WhaleSharkModel<WhaleSharkEntity>> {
	private static final ResourceLocation PEEPER_LOCATION = new ResourceLocation(com.viperfish2000.crocodile.Crocodile.MODID,
			"textures/entity/whale_shark.png");

	public WhaleSharkRenderer(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new WhaleSharkModel<>(), 0.7F);
	}

   /**
    * Returns the location of an entity's texture.
    */
   public ResourceLocation getEntityTexture(WhaleSharkEntity entity) {
      return PEEPER_LOCATION;
   }
	protected void applyRotations(WhaleSharkEntity entityLiving, MatrixStack matrixStackIn, float ageInTicks,
			float rotationYaw, float partialTicks) {
		super.applyRotations(entityLiving, matrixStackIn, ageInTicks, rotationYaw, partialTicks);

		if (!entityLiving.isInWater()) {
			
		}
		matrixStackIn.scale(4.0F, 4.0F, 4.0F);

	//	matrixStackIn.rotate(Vector3f.YP.rotationDegrees(f2));
		matrixStackIn.translate(0.0D, 0, (double) -0.4F);
		  if (!((double)entityLiving.limbSwingAmount < 0.01D)) {
		         float f = 13.0F;
		         float f1 = entityLiving.limbSwing - entityLiving.limbSwingAmount * (1.0F - partialTicks) + 6.0F;
		         float f2 = (Math.abs(f1 % 13.0F - 6.5F) - 3.25F) / 3.25F;
		     //    matrixStackIn.rotate(Vector3f.ZP.rotationDegrees(6.5F * f2));

	}
	}

	public static class RenderFactory implements IRenderFactory<WhaleSharkEntity> {

		@Override
		public EntityRenderer<? super WhaleSharkEntity> createRenderFor(EntityRendererManager manager) {

			return new WhaleSharkRenderer(manager);
		}

	}
}