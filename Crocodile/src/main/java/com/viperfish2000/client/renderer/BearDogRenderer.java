package com.viperfish2000.client.renderer;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.viperfish2000.client.model.BearDogModel;
import com.viperfish2000.crocodile.Crocodile;
import com.viperfish2000.entity.PolarBearDogEntity;

import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.IRenderFactory;

@OnlyIn(Dist.CLIENT)
public class BearDogRenderer extends MobRenderer<PolarBearDogEntity,BearDogModel<PolarBearDogEntity>> {
	private static final ResourceLocation PEEPER_LOCATION = new ResourceLocation(Crocodile.MODID,
			"textures/entity/bear_dog.png");

	public BearDogRenderer(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new BearDogModel<>(), 1.0F);
		// this.addLayer(new CrocodileLayer<>(this));
	}

	/**
	 * Returns the location of an entity's texture.
	 */
	public ResourceLocation getEntityTexture(PolarBearDogEntity entity) {

		return PEEPER_LOCATION;

	}

	protected void applyRotations(PolarBearDogEntity entityLiving, MatrixStack matrixStackIn, float ageInTicks,
			float rotationYaw, float partialTicks) {
		super.applyRotations(entityLiving, matrixStackIn, ageInTicks, rotationYaw, partialTicks);

		matrixStackIn.translate(0.0F, 0.0F, 0.0F);
		matrixStackIn.scale(1.3F, 1.3F, 1.3F);

		}
	

	public static class RenderFactory implements IRenderFactory<PolarBearDogEntity> {

		@Override
		public EntityRenderer<? super PolarBearDogEntity> createRenderFor(EntityRendererManager manager) {

			return new BearDogRenderer(manager);
		}

	}
}
