package com.viperfish2000.client.renderer;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.viperfish2000.crocodile.Crocodile;
import com.viperfish2000.entity.FrozenSlimeEntity;

import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.SlimeModel;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.IRenderFactory;

@OnlyIn(Dist.CLIENT)
public class FrozenSlimeRenderer extends MobRenderer<FrozenSlimeEntity, SlimeModel<FrozenSlimeEntity>> {
	   private static final ResourceLocation SLIME_TEXTURES = new ResourceLocation(Crocodile.MODID,"textures/entity/honey_slime.png");

	   public FrozenSlimeRenderer(EntityRendererManager renderManagerIn) {
	      super(renderManagerIn, new SlimeModel<>(16), 0.25F);
	      this.addLayer(new GelLayer<>(this));
	   }

	   public void render(FrozenSlimeEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
	      this.shadowSize = 0.25F * (float)entityIn.getSlimeSize();
	      super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
	   }

	   protected void preRenderCallback(FrozenSlimeEntity entitylivingbaseIn, MatrixStack matrixStackIn, float partialTickTime) {
	      float f = 0.999F;
	      matrixStackIn.scale(0.999F, 0.999F, 0.999F);
	      matrixStackIn.translate(0.0D, (double)0.001F, 0.0D);
	      float f1 = (float)entitylivingbaseIn.getSlimeSize();
	      float f2 = MathHelper.lerp(partialTickTime, entitylivingbaseIn.prevSquishFactor, entitylivingbaseIn.squishFactor) / (f1 * 0.5F + 1.0F);
	      float f3 = 1.0F / (f2 + 1.0F);
	      matrixStackIn.scale(f3 * f1, 1.0F / f3 * f1, f3 * f1);
	   }

	   /**
	    * Returns the location of an entity's texture.
	    */
	   public ResourceLocation getEntityTexture(FrozenSlimeEntity entity) {
	      return SLIME_TEXTURES;
	   }


		public static class RenderFactory implements IRenderFactory<FrozenSlimeEntity> {

			@Override
			public EntityRenderer<? super FrozenSlimeEntity> createRenderFor(EntityRendererManager manager) {

				return new FrozenSlimeRenderer(manager);
			}

		}
}
