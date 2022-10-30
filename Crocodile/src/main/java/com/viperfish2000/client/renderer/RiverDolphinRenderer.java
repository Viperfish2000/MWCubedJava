package com.viperfish2000.client.renderer;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.viperfish2000.client.model.RiverDolphinModel;
import com.viperfish2000.entity.RiverDolphinEntity;
import com.viperfish2000.entity.OrcaEntity;

import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.DolphinCarriedItemLayer;
import net.minecraft.client.renderer.entity.model.DolphinModel;
import net.minecraft.entity.passive.DolphinEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.IRenderFactory;

@OnlyIn(Dist.CLIENT)
public class RiverDolphinRenderer extends MobRenderer<RiverDolphinEntity, RiverDolphinModel<RiverDolphinEntity>> {
	private static final ResourceLocation PEEPER_LOCATION = new ResourceLocation(com.viperfish2000.crocodile.Crocodile.MODID,
			"textures/entity/river_dolphin.png");
	
	public RiverDolphinRenderer(EntityRendererManager renderManagerIn) {
		      super(renderManagerIn, new RiverDolphinModel<>(), 0.7F);
		     // this.addLayer(new DolphinCarriedItemLayer(this));
		   }
	protected void applyRotations(RiverDolphinEntity entityLiving, MatrixStack matrixStackIn, float ageInTicks,
			float rotationYaw, float partialTicks) {
		super.applyRotations(entityLiving, matrixStackIn, ageInTicks, rotationYaw, partialTicks);
		matrixStackIn.scale(1.5F, 1.5F, 1.5F);
		}
	

   /**
    * Returns the location of an entity's texture.
    */
   public ResourceLocation getEntityTexture(RiverDolphinEntity entity) {
      return PEEPER_LOCATION;
   }


	public static class RenderFactory implements IRenderFactory<RiverDolphinEntity> {

		@Override
		public EntityRenderer<? super RiverDolphinEntity> createRenderFor(EntityRendererManager manager) {

			return new RiverDolphinRenderer(manager);
		}

	}
}