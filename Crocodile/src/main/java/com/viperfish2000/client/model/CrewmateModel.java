package com.viperfish2000.client.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.viperfish2000.entity.CrewmateEntity;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.passive.WolfEntity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class CrewmateModel<T extends CrewmateEntity> extends EntityModel<T> {
	private final ModelRenderer standing;
	private final ModelRenderer LeftLeg;
	private final ModelRenderer RightLeg;
	private final ModelRenderer Body;
	private final ModelRenderer sitting;
	private final ModelRenderer Body1;
	private final ModelRenderer RightLeg1;
	private final ModelRenderer LeftLeg1;
	private boolean isStanding = true;
	public CrewmateModel() {
		textureWidth = 64;
		textureHeight = 64;
//Standing
		standing = new ModelRenderer(this);
		standing.setRotationPoint(0.0F, 0.0F, 0.0F);
		

		LeftLeg = new ModelRenderer(this);
		LeftLeg.setRotationPoint(1.65F, 19.0F, 1.0F);
		standing.addChild(LeftLeg);
		LeftLeg.setTextureOffset(16, 48).addBox(-0.65F, 0.0F, -2.0F, 3.0F, 5.0F, 4.0F, 0.0F, false);

		RightLeg = new ModelRenderer(this);
		RightLeg.setRotationPoint(-2.15F, 19.0F, 1.0F);
		standing.addChild(RightLeg);
		RightLeg.setTextureOffset(0, 16).addBox(-1.85F, 0.0F, -2.0F, 3.0F, 5.0F, 4.0F, 0.0F, false);

		Body = new ModelRenderer(this);
		Body.setRotationPoint(0.0F, 8.0F, 0.0F);
		standing.addChild(Body);
		Body.setTextureOffset(18, 17).addBox(-4.0F, 2.0F, -1.0F, 8.0F, 9.0F, 4.0F, 0.0F, false);
		Body.setTextureOffset(21, 7).addBox(-2.25F, 2.5F, -3.5F, 5.0F, 5.0F, 3.0F, 0.0F, false);
		Body.setTextureOffset(45, 36).addBox(-3.0F, 4.0F, 3.0F, 6.0F, 7.0F, 3.0F, 0.0F, false);
	
//Sitting
		sitting = new ModelRenderer(this);
		sitting.setRotationPoint(0.0F, 24.0F, 0.0F);
		

		Body1 = new ModelRenderer(this);
		Body1.setRotationPoint(0.0F, -11.0F, 0.0F);
		sitting.addChild(Body1);
		Body1.setTextureOffset(18, 17).addBox(-4.0F, 2.0F, -1.0F, 8.0F, 9.0F, 4.0F, 0.0F, false);
		Body1.setTextureOffset(21, 7).addBox(-2.5F, 2.5F, -3.5F, 5.0F, 5.0F, 3.0F, 0.0F, false);
		Body1.setTextureOffset(45, 36).addBox(-3.0F, 4.75F, 3.0F, 6.0F, 7.0F, 3.0F, 0.0F, false);

		RightLeg1 = new ModelRenderer(this);
		RightLeg1.setRotationPoint(-2.15F, -1.0F, 2.0F);
		sitting.addChild(RightLeg1);
		setRotationAngle(RightLeg1, -1.5708F, 0.0873F, 0.0F);
		RightLeg1.setTextureOffset(0, 16).addBox(-1.85F, 0.0F, -1.0F, 3.0F, 5.0F, 4.0F, 0.0F, false);

		LeftLeg1 = new ModelRenderer(this);
		LeftLeg1.setRotationPoint(1.65F, -1.0F, 1.0F);
		sitting.addChild(LeftLeg1);
		setRotationAngle(LeftLeg1, -1.5708F, -0.0873F, 0.0F);
		LeftLeg1.setTextureOffset(16, 48).addBox(-0.5628F, -0.9962F, -1.0F, 3.0F, 5.0F, 4.0F, 0.0F, false);
		
	}


	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
	public void setLivingAnimations(T entityIn, float limbSwing, float limbSwingAmount, float partialTick) {

	
			this.LeftLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
			this.RightLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F
					* limbSwingAmount;
			if (entityIn.isSitting()) {
				this.standing.showModel = false;
				this.sitting.showModel = true;
				  
			}
			else {
				this.standing.showModel = true;
				  this.sitting.showModel = false;
			}
			
}


	@Override
	public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn,
			float red, float green, float blue, float alpha) {
		sitting.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
		standing.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
		
	}


	@Override
	public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch) {
		// TODO Auto-generated method stub
		
	}
}