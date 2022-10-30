package com.viperfish2000.client.renderer;




import com.viperfish2000.crocodile.Crocodile;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.layers.AbstractEyesLayer;
import net.minecraft.client.renderer.entity.model.SlimeModel;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class SlimeBodyLayer<T extends Entity, M extends SlimeModel<T>> extends AbstractEyesLayer<T, M> {
   private static final RenderType RENDER_TYPE =  RenderTypeMod.getOverlay( new ResourceLocation(Crocodile.MODID,
			"textures/entity/radiation_slime_body.png"));

	public SlimeBodyLayer(IEntityRenderer<T, M> rendererIn) {
      super(rendererIn);
   }

   public RenderType getRenderType() {
      return RENDER_TYPE;
   }
}