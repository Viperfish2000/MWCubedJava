package com.viperfish2000.client.renderer;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.viperfish2000.client.model.OstrichHorseModel;
import com.viperfish2000.crocodile.Crocodile;
import com.viperfish2000.entity.LanternSharkEntity;
import com.viperfish2000.entity.OstrichHorseEntity;

import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.IRenderFactory;

@OnlyIn(Dist.CLIENT)
public class OstrichHorseRenderer extends MobRenderer<OstrichHorseEntity, OstrichHorseModel<OstrichHorseEntity>> {
	private static final ResourceLocation PEEPER_LOCATION = new ResourceLocation(Crocodile.MODID,
			"textures/entity/ostrich_horse.png");

	public OstrichHorseRenderer(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new OstrichHorseModel<>(), 1.0F);
		// this.addLayer(new CrocodileLayer<>(this));
	}

	/**
	 * Returns the location of an entity's texture.
	 */
	public ResourceLocation getEntityTexture(OstrichHorseEntity entity) {

		return PEEPER_LOCATION;

	}

	protected void applyRotations(OstrichHorseEntity entityLiving, MatrixStack matrixStackIn, float ageInTicks,
			float rotationYaw, float partialTicks) {
		super.applyRotations(entityLiving, matrixStackIn, ageInTicks, rotationYaw, partialTicks);

		matrixStackIn.translate(0.0F, 0.0F, -0.70F);


		}
	

	public static class RenderFactory implements IRenderFactory<OstrichHorseEntity> {

		@Override
		public EntityRenderer<? super OstrichHorseEntity> createRenderFor(EntityRendererManager manager) {

			return new OstrichHorseRenderer(manager);
		}

	}
}
