package com.viperfish2000.client.renderer;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.viperfish2000.client.model.FrogModel;
import com.viperfish2000.crocodile.Crocodile;
import com.viperfish2000.entity.FrogEntity;

import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.IRenderFactory;

@OnlyIn(Dist.CLIENT)
public class FrogRenderer extends MobRenderer<FrogEntity, FrogModel<FrogEntity>> {
	private static final ResourceLocation PEEPER_LOCATION = new ResourceLocation(Crocodile.MODID,
			"textures/entity/frog.png");
	private static final ResourceLocation CHILD = new ResourceLocation(Crocodile.MODID, "textures/entity/frog.png");

	public FrogRenderer(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new FrogModel<>(), 0.3F);

	}

	/**
	 * Returns the location of an entity's texture.
	 */
	public ResourceLocation getEntityTexture(FrogEntity entity) {

		if (entity.isChild()) {
			return CHILD;
		} else {
			return PEEPER_LOCATION;
		}

	}

	protected void preRenderCallback(FrogEntity entitylivingbaseIn, MatrixStack matrixStackIn, float partialTickTime) {
		if (!entitylivingbaseIn.isChild()) {
			matrixStackIn.scale(0.8F, 0.8F, 0.8F);
		} else {

			matrixStackIn.scale(0.5F, 0.5F, 0.5F);
		}

	}

	protected void applyRotations(FrogEntity entityLiving, MatrixStack matrixStackIn, float ageInTicks,
			float rotationYaw, float partialTicks) {
		super.applyRotations(entityLiving, matrixStackIn, ageInTicks, rotationYaw, partialTicks);
	}

	public static class RenderFactory implements IRenderFactory<FrogEntity> {

		@Override
		public EntityRenderer<? super FrogEntity> createRenderFor(EntityRendererManager manager) {

			return new FrogRenderer(manager);
		}

	}
}
