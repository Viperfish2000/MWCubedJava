package com.viperfish2000.client.renderer;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.viperfish2000.client.model.PlatypusModel;
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
public class PlatypusRenderer extends MobRenderer<WolfEntity, PlatypusModel<WolfEntity>> {
   private static final ResourceLocation WOLF_TEXTURES = new ResourceLocation(Crocodile.MODID, "textures/entity/perry1.png");
   private static final ResourceLocation TAMED_WOLF_TEXTURES= new ResourceLocation(Crocodile.MODID,
			"textures/entity/perry_standing.png");
   private static final ResourceLocation ANGRY_WOLF_TEXTURES = new ResourceLocation(Crocodile.MODID, "textures/entity/perry1.png");

   public PlatypusRenderer(EntityRendererManager renderManagerIn) {
      super(renderManagerIn, new PlatypusModel<>(), 0.35F);
     ;
   }

   /**
    * Defines what float the third param in setRotationAngles of ModelBase is
    */
   protected float handleRotationFloat(WolfEntity livingBase, float partialTicks) {
      return livingBase.getTailRotation();
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

			return new PlatypusRenderer(manager);
		}

	}
}
