package com.viperfish2000.client.renderer;


import net.minecraft.client.renderer.RenderState;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.renderer.vertex.VertexFormat;
import net.minecraft.util.ResourceLocation;

public class RenderTypeMod extends RenderType{
	
	   public static RenderType getOverlay(ResourceLocation locationIn) {
		      RenderState.TextureState renderstate$texturestate = new RenderState.TextureState(locationIn, false, false);
		      return makeType("overlay", DefaultVertexFormats.ENTITY, 7, 256, false, true, RenderType.State.getBuilder().texture(renderstate$texturestate).transparency(NO_TRANSPARENCY).diffuseLighting(DIFFUSE_LIGHTING_ENABLED).alpha(DEFAULT_ALPHA).overlay(OVERLAY_ENABLED).build(false));
		   }
	   public static RenderType getTranslucentGlowing(ResourceLocation locationIn, boolean p_230168_1_) {
		      RenderType.State rendertype$state = RenderType.State.getBuilder().texture(new RenderState.TextureState(locationIn, false, false)).transparency(TRANSLUCENT_TRANSPARENCY).alpha(DEFAULT_ALPHA).cull(CULL_DISABLED).overlay(OVERLAY_ENABLED).build(p_230168_1_);
		      return makeType("entity_translucent_glowing", DefaultVertexFormats.ENTITY, 7, 256, true, true, rendertype$state);
		   }


	public RenderTypeMod(String nameIn, VertexFormat formatIn, int drawModeIn, int bufferSizeIn, boolean useDelegateIn,
			boolean needsSortingIn, Runnable setupTaskIn, Runnable clearTaskIn) {
		super(nameIn, formatIn, drawModeIn, bufferSizeIn, useDelegateIn, needsSortingIn, setupTaskIn, clearTaskIn);
		// TODO Auto-generated constructor stub
	}

}
