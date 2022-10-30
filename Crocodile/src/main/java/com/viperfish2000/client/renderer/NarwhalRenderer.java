package com.viperfish2000.client.renderer;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.viperfish2000.client.model.NarwhalModel;
import com.viperfish2000.entity.NarwhalEntity;
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
public class NarwhalRenderer extends MobRenderer<NarwhalEntity, NarwhalModel<NarwhalEntity>> {
	private static final ResourceLocation PEEPER_LOCATION = new ResourceLocation(com.viperfish2000.crocodile.Crocodile.MODID,
			"textures/entity/narwhal.png");
	
	public NarwhalRenderer(EntityRendererManager renderManagerIn) {
		      super(renderManagerIn, new NarwhalModel<>(), 0.7F);
		     // this.addLayer(new DolphinCarriedItemLayer(this));
		   }
	protected void applyRotations(NarwhalEntity entityLiving, MatrixStack matrixStackIn, float ageInTicks,
			float rotationYaw, float partialTicks) {
		super.applyRotations(entityLiving, matrixStackIn, ageInTicks, rotationYaw, partialTicks);
		matrixStackIn.scale(2.5F, 2.5F, 2.5F);
		}
	

   /**
    * Returns the location of an entity's texture.
    */
   public ResourceLocation getEntityTexture(NarwhalEntity entity) {
      return PEEPER_LOCATION;
   }


	public static class RenderFactory implements IRenderFactory<NarwhalEntity> {

		@Override
		public EntityRenderer<? super NarwhalEntity> createRenderFor(EntityRendererManager manager) {

			return new NarwhalRenderer(manager);
		}

	}
}