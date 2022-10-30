package com.viperfish2000.client.renderer;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.viperfish2000.client.model.OtterPenguinModel;
import com.viperfish2000.crocodile.Crocodile;
import com.viperfish2000.entity.OtterPenguinEntity;

import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.IRenderFactory;

@OnlyIn(Dist.CLIENT)
public class OtterPenguinRenderer extends MobRenderer<OtterPenguinEntity,OtterPenguinModel<OtterPenguinEntity>> {
	private static final ResourceLocation PEEPER_LOCATION = new ResourceLocation(Crocodile.MODID,
			"textures/entity/otter_penguin.png");
	private static final ResourceLocation CHICK = new ResourceLocation(Crocodile.MODID,
			"textures/entity/otter_penguin_chick.png");
	public OtterPenguinRenderer(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new OtterPenguinModel<>(), 0.5F);
		// this.addLayer(new CrocodileLayer<>(this));
	}

	/**
	 * Returns the location of an entity's texture.
	 */
	public ResourceLocation getEntityTexture(OtterPenguinEntity entity) {
		if (entity.isChild()) {
			return CHICK;
		}
		else {
		return PEEPER_LOCATION;
		}

	}

	protected void applyRotations(OtterPenguinEntity entityLiving, MatrixStack matrixStackIn, float ageInTicks,
			float rotationYaw, float partialTicks) {
		super.applyRotations(entityLiving, matrixStackIn, ageInTicks, rotationYaw, partialTicks);

		matrixStackIn.translate(0.0F, 0.0F, 0.0F);
	
		if (entityLiving.isInWater()){
			matrixStackIn.translate(0.0F, -0.25F, 0.0F);
			
		}
		if (!entityLiving.isChild()) {
			matrixStackIn.scale(1.0F, 1.0F, 1.0F);
		}
		else {
			matrixStackIn.scale(0.6F, 0.6F, 0.6F);
		}

		}
	

	public static class RenderFactory implements IRenderFactory<OtterPenguinEntity> {

		@Override
		public EntityRenderer<? super OtterPenguinEntity> createRenderFor(EntityRendererManager manager) {

			return new OtterPenguinRenderer(manager);
		}

	}
}
