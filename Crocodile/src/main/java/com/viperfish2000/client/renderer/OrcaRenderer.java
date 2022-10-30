package com.viperfish2000.client.renderer;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.viperfish2000.client.model.OrcaModel;
import com.viperfish2000.entity.OrcaEntity;
import com.viperfish2000.entity.WhaleSharkEntity;

import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.IRenderFactory;

@OnlyIn(Dist.CLIENT)
public class OrcaRenderer extends MobRenderer<OrcaEntity, OrcaModel<OrcaEntity>> {
	private static final ResourceLocation PEEPER_LOCATION = new ResourceLocation(
			com.viperfish2000.crocodile.Crocodile.MODID, "textures/entity/orca.png");

	public OrcaRenderer(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new OrcaModel<>(), 0.7F);
		// this.addLayer(new DolphinCarriedItemLayer(this));
	}

	/**
	 * Returns the location of an entity's texture.
	 */
	public ResourceLocation getEntityTexture(OrcaEntity entity) {
		return PEEPER_LOCATION;
	}

	protected void applyRotations(OrcaEntity entityLiving, MatrixStack matrixStackIn, float ageInTicks,
			float rotationYaw, float partialTicks) {
		super.applyRotations(entityLiving, matrixStackIn, ageInTicks, rotationYaw, partialTicks);
	
		if (entityLiving.isChild()) {
			matrixStackIn.scale(1.0F, 1.0F, 1.0F);
		}
		else {
			matrixStackIn.scale(2.75F, 2.75F, 2.75F);
		}
	
}
	public static class RenderFactory implements IRenderFactory<OrcaEntity> {

		@Override
		public EntityRenderer<? super OrcaEntity> createRenderFor(EntityRendererManager manager) {

			return new OrcaRenderer(manager);
		}

	}
}