package com.viperfish2000.client.renderer;

import com.viperfish2000.client.model.CrocodileModel;
import com.viperfish2000.crocodile.Crocodile;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.layers.AbstractEyesLayer;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class CrocodileLayer<T extends Entity, M extends CrocodileModel<T>> extends AbstractEyesLayer<T, M> {
   private static final RenderType RENDER_TYPE = RenderType.getEyes( new ResourceLocation(Crocodile.MODID,
			"textures/entity/crocodile_overlay.png"));

	public CrocodileLayer(IEntityRenderer<T, M> rendererIn) {
      super(rendererIn);
   }

   public RenderType getRenderType() {
      return RENDER_TYPE;
   }
}