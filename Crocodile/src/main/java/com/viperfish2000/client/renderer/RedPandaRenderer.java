package com.viperfish2000.client.renderer;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.viperfish2000.client.model.CrocodileModel;
import com.viperfish2000.client.model.RedPandaModel;
import com.viperfish2000.crocodile.Crocodile;
import com.viperfish2000.entity.RedPandaEntity;

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
public class RedPandaRenderer extends MobRenderer<RedPandaEntity, RedPandaModel<RedPandaEntity>> {
	private static final ResourceLocation PEEPER_LOCATION = new ResourceLocation(Crocodile.MODID,
			"textures/entity/red_panda.png");
	private static final ResourceLocation CHILD = new ResourceLocation(Crocodile.MODID,
			"textures/entity/red_panda_sleeping.png");

	public RedPandaRenderer(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new RedPandaModel<>(), 1.0F);
		// this.addLayer(new CrocodileLayer<>(this));
	}

	/**
	 * Returns the location of an entity's texture.
	 */
	public ResourceLocation getEntityTexture(RedPandaEntity entity) {

		if (entity.isSleeping()) {
			return CHILD;
		} else {
			return PEEPER_LOCATION;
		}

	}

	

	protected void applyRotations(RedPandaEntity entityLiving, MatrixStack matrixStackIn, float ageInTicks,
			float rotationYaw, float partialTicks) {
		super.applyRotations(entityLiving, matrixStackIn, ageInTicks, rotationYaw, partialTicks);
	}

	public static class RenderFactory implements IRenderFactory<RedPandaEntity> {

		@Override
		public EntityRenderer<? super RedPandaEntity> createRenderFor(EntityRendererManager manager) {

			return new RedPandaRenderer(manager);
		}

	}
}
