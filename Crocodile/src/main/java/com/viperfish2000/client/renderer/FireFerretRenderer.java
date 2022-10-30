package com.viperfish2000.client.renderer;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.viperfish2000.client.model.CrocodileModel;
import com.viperfish2000.client.model.FireFerretModel;
import com.viperfish2000.crocodile.Crocodile;
import com.viperfish2000.entity.FireFerretEntity;

import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.entity.monster.SlimeEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.IRenderFactory;

@OnlyIn(Dist.CLIENT)
public class FireFerretRenderer extends MobRenderer<FireFerretEntity, FireFerretModel<FireFerretEntity>> {
	private static final ResourceLocation PEEPER_LOCATION = new ResourceLocation(Crocodile.MODID,
			"textures/entity/fire_ferret.png");
	private static final ResourceLocation CHILD = new ResourceLocation(Crocodile.MODID,
			"textures/entity/fire_ferret.png");

	public FireFerretRenderer(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new FireFerretModel<>(), 1.0F);
		// this.addLayer(new CrocodileLayer<>(this));
	}

	/**
	 * Returns the location of an entity's texture.
	 */
	public ResourceLocation getEntityTexture(FireFerretEntity entity) {

		if (entity.isSleeping()) {
			return CHILD;
		} else {
			return PEEPER_LOCATION;
		}

	}

	

	protected void applyRotations(FireFerretEntity entityLiving, MatrixStack matrixStackIn, float ageInTicks,
			float rotationYaw, float partialTicks) {
		super.applyRotations(entityLiving, matrixStackIn, ageInTicks, rotationYaw, partialTicks);
	}

	public static class RenderFactory implements IRenderFactory<FireFerretEntity> {

		@Override
		public EntityRenderer<? super FireFerretEntity> createRenderFor(EntityRendererManager manager) {

			return new FireFerretRenderer(manager);
		}

	}
}
