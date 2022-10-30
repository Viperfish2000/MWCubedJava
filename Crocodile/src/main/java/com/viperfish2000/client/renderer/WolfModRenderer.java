package com.viperfish2000.client.renderer;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.viperfish2000.client.model.WolfModModel;
import com.viperfish2000.crocodile.Crocodile;

import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.entity.passive.WolfEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.IRenderFactory;

@OnlyIn(Dist.CLIENT)
public class WolfModRenderer extends MobRenderer<WolfEntity, WolfModModel<WolfEntity>> {
   private static final ResourceLocation WOLF_TEXTURES = new ResourceLocation("textures/entity/wolf/wolf.png");
   private static final ResourceLocation TAMED_WOLF_TEXTURES= new ResourceLocation(Crocodile.MODID,
			"textures/entity/wolf_tame.png");
   private static final ResourceLocation ANGRY_WOLF_TEXTURES = new ResourceLocation("textures/entity/wolf/wolf_angry.png");

   public WolfModRenderer(EntityRendererManager renderManagerIn) {
      super(renderManagerIn, new WolfModModel<>(), 0.5F);
      this.addLayer(new WolfModLayer(this));
   }

   /**
    * Defines what float the third param in setRotationAngles of ModelBase is
    */
   protected float handleRotationFloat(WolfEntity livingBase, float partialTicks) {
      return livingBase.getTailRotation();
   }

   public void render(WolfEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
      if (entityIn.isWolfWet()) {
         float f = entityIn.getBrightness() * entityIn.getShadingWhileWet(partialTicks);
         this.entityModel.setTint(f, f, f);
      }

      super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
      if (entityIn.isWolfWet()) {
         this.entityModel.setTint(1.0F, 1.0F, 1.0F);
      }

   }

   /**
    * Returns the location of an entity's texture.
    */
   public ResourceLocation getEntityTexture(WolfEntity entity) {
      if (entity.isTamed()) {
         return TAMED_WOLF_TEXTURES;
      } else {
         return entity.isAngry() ? ANGRY_WOLF_TEXTURES : WOLF_TEXTURES;
      }
   }


	public static class RenderFactory implements IRenderFactory<WolfEntity> {

		@Override
		public EntityRenderer<? super WolfEntity> createRenderFor(EntityRendererManager manager) {

			return new WolfModRenderer(manager);
		}

	}
}
