package com.viperfish2000.client.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.passive.WolfEntity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class PlatypusModel<T extends WolfEntity> extends EntityModel<T> {
	private final ModelRenderer platypus1;
	private final ModelRenderer tail1;
	private final ModelRenderer head1;
	private final ModelRenderer hair;
	private final ModelRenderer legBackRight;
	private final ModelRenderer legBackLeft;
	private final ModelRenderer legFrontRight;
	private final ModelRenderer legFrontLeft;
	private final ModelRenderer platypus2;
	private final ModelRenderer taill;
	private final ModelRenderer head2;
	private final ModelRenderer eeeeeye;
	private final ModelRenderer eyeee;
	private final ModelRenderer legRight;
	private final ModelRenderer legLeft;
	private final ModelRenderer armRight;
	private final ModelRenderer armLeft;
	private boolean isStanding = true;
	public PlatypusModel() {
		textureWidth = 64;
		textureHeight = 64;

		platypus1 = new ModelRenderer(this);
		platypus1.setRotationPoint(0.0F, 21.75F, 6.25F);
		platypus1.setTextureOffset(0, 0).addBox(-2.0F, -5.25F, -9.0F, 5.0F, 5.0F, 8.0F, 0.0F, false);
		platypus1.setTextureOffset(0, 51).addBox(-2.0F, -5.25F, -2.0F, 5.0F, 5.0F, 1.0F, 0.0F, false);

		tail1 = new ModelRenderer(this);
		tail1.setRotationPoint(0.0F, -3.0F, -0.75F);
		platypus1.addChild(tail1);
		tail1.setTextureOffset(0, 13).addBox(-2.0F, -0.116F, -0.25F, 5.0F, 1.0F, 9.0F, 0.0F, false);

		head1 = new ModelRenderer(this);
		head1.setRotationPoint(0.0F, -2.75F, -11.5F);
		platypus1.addChild(head1);
		head1.setTextureOffset(21, 8).addBox(-2.0F, -2.5F, -2.5F, 5.0F, 5.0F, 5.0F, 0.0F, true);
		head1.setTextureOffset(0, 39).addBox(-4.5F, -2.5F, -5.0F, 10.0F, 0.0F, 10.0F, 0.0F, true);
		head1.setTextureOffset(0, 32).addBox(-2.0F, -4.5F, -2.75F, 5.0F, 2.0F, 5.0F, 0.0F, true);
		head1.setTextureOffset(21, 18).addBox(-2.5F, -1.75F, -2.75F, 2.0F, 2.0F, 2.0F, 0.0F, true);
		head1.setTextureOffset(21, 18).addBox(1.5F, -1.75F, -2.75F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		head1.setTextureOffset(48, 0).addBox(-2.0F, 1.0F, -5.5F, 5.0F, 1.0F, 3.0F, 0.0F, false);

		hair = new ModelRenderer(this);
		hair.setRotationPoint(-0.5F, -1.5F, -2.75F);
		head1.addChild(hair);
		setRotationAngle(hair, 0.3491F, 0.0F, 0.0F);
		hair.setTextureOffset(0, 9).addBox(1.0F, -3.8794F, -0.316F, 0.0F, 5.0F, 4.0F, 0.0F, false);

		legBackRight = new ModelRenderer(this);
		legBackRight.setRotationPoint(-1.25F, -1.75F, -1.75F);
		platypus1.addChild(legBackRight);
		legBackRight.setTextureOffset(16, 0).addBox(-1.0F, 4.0F, -3.0F, 2.0F, 0.0F, 2.0F, 0.0F, false);
		legBackRight.setTextureOffset(0, 0).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, true);

		legBackLeft = new ModelRenderer(this);
		legBackLeft.setRotationPoint(2.5F, -1.75F, -1.75F);
		platypus1.addChild(legBackLeft);
		legBackLeft.setTextureOffset(16, 0).addBox(-1.0F, 4.0F, -3.0F, 2.0F, 0.0F, 2.0F, 0.0F, true);
		legBackLeft.setTextureOffset(0, 0).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, true);

		legFrontRight = new ModelRenderer(this);
		legFrontRight.setRotationPoint(-1.25F, 0.25F, -10.0F);
		platypus1.addChild(legFrontRight);
		legFrontRight.setTextureOffset(0, 0).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, true);
		legFrontRight.setTextureOffset(24, 25).addBox(-1.0F, 2.0F, -1.0F, 2.0F, 3.0F, 2.0F, 0.0F, true);

		legFrontLeft = new ModelRenderer(this);
		legFrontLeft.setRotationPoint(2.25F, 0.25F, -9.75F);
		platypus1.addChild(legFrontLeft);
		legFrontLeft.setTextureOffset(0, 0).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);
		legFrontLeft.setTextureOffset(24, 25).addBox(-1.0F, 2.0F, -1.0F, 2.0F, 3.0F, 2.0F, 0.0F, false);
		
		platypus2 = new ModelRenderer(this);
		platypus2.setRotationPoint(0.0F, 20.75F, -3.0F);
		setRotationAngle(platypus2, -1.5708F, 0.0F, 0.0F);
		platypus2.setTextureOffset(0, 0).addBox(-2.0F, -5.25F, -9.0F, 5.0F, 5.0F, 8.0F, 0.0F, false);
		platypus2.setTextureOffset(0, 51).addBox(-2.0F, -5.25F, -1.0F, 5.0F, 5.0F, 1.0F, 0.0F, false);

		taill = new ModelRenderer(this);
		taill.setRotationPoint(0.0F, -5.0F, -0.75F);
		platypus2.addChild(taill);
		setRotationAngle(taill, 2.0944F, 0.0F, 0.0F);
		taill.setTextureOffset(0, 13).addBox(-2.0F, -0.25F, 0.2679F, 5.0F, 1.0F, 9.0F, 0.0F, false);

		head2 = new ModelRenderer(this);
		head2.setRotationPoint(0.0F, -2.75F, -11.5F);
		platypus2.addChild(head2);
		setRotationAngle(head2, 1.5708F, 0.0F, 0.0F);
		head2.setTextureOffset(21, 8).addBox(-2.0F, -2.5F, -2.5F, 5.0F, 5.0F, 5.0F, 0.0F, true);
		head2.setTextureOffset(0, 39).addBox(-4.5F, -2.5F, -5.0F, 10.0F, 0.0F, 10.0F, 0.0F, true);
		head2.setTextureOffset(0, 32).addBox(-2.0F, -4.5F, -2.5F, 5.0F, 2.0F, 5.0F, 0.0F, true);
		head2.setTextureOffset(29, 18).addBox(-2.5F, -1.75F, -2.75F, 2.0F, 2.0F, 2.0F, 0.0F, true);
		head2.setTextureOffset(29, 18).addBox(1.5F, -1.75F, -2.75F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		head2.setTextureOffset(48, 0).addBox(-2.0F, 1.0F, -5.5F, 5.0F, 1.0F, 3.0F, 0.0F, false);

		eeeeeye = new ModelRenderer(this);
		eeeeeye.setRotationPoint(1.75F, 4.0F, -3.75F);
		head2.addChild(eeeeeye);
		setRotationAngle(eeeeeye, 0.0F, 0.7854F, 0.0F);
		eeeeeye.setTextureOffset(21, 18).addBox(-1.7803F, -6.0F, -0.0303F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		eyeee = new ModelRenderer(this);
		eyeee.setRotationPoint(-1.25F, 4.0F, -3.75F);
		head2.addChild(eyeee);
		setRotationAngle(eyeee, 0.0F, 0.7854F, 0.0F);
		eyeee.setTextureOffset(21, 18).addBox(-1.7803F, -6.0F, -0.0303F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		legRight = new ModelRenderer(this);
		legRight.setRotationPoint(-2.0F, -2.75F, -1.0F);
		platypus2.addChild(legRight);
		setRotationAngle(legRight, 1.5708F, 0.0F, 0.0F);
		legRight.setTextureOffset(16, 0).addBox(-1.0F, 4.0F, -3.0F, 2.0F, 0.0F, 2.0F, 0.0F, false);
		legRight.setTextureOffset(0, 0).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, true);

		legLeft = new ModelRenderer(this);
		legLeft.setRotationPoint(3.0F, -2.75F, -1.0F);
		platypus2.addChild(legLeft);
		setRotationAngle(legLeft, 1.5708F, 0.0F, 0.0F);
		legLeft.setTextureOffset(16, 0).addBox(-1.0F, 4.0F, -3.0F, 2.0F, 0.0F, 2.0F, 0.0F, true);
		legLeft.setTextureOffset(0, 0).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, true);

		armRight = new ModelRenderer(this);
		armRight.setRotationPoint(-3.0F, -2.75F, -7.0F);
		platypus2.addChild(armRight);
		setRotationAngle(armRight, 1.5708F, 0.0F, 0.0F);
		armRight.setTextureOffset(0, 0).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, true);
		armRight.setTextureOffset(24, 25).addBox(-1.0F, 2.0F, -1.0F, 2.0F, 3.0F, 2.0F, 0.0F, true);

		armLeft = new ModelRenderer(this);
		armLeft.setRotationPoint(4.0F, -2.75F, -7.0F);
		platypus2.addChild(armLeft);
		setRotationAngle(armLeft, 1.5708F, 0.0F, 0.0F);
		armLeft.setTextureOffset(0, 0).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);
		armLeft.setTextureOffset(24, 25).addBox(-1.0F, 2.0F, -1.0F, 2.0F, 3.0F, 2.0F, 0.0F, false);
	}


	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
	public void setLivingAnimations(T entityIn, float limbSwing, float limbSwingAmount, float partialTick) {

			this.legBackRight.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
			this.legBackLeft.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F
					* limbSwingAmount;
			this.legFrontRight.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F
					* limbSwingAmount;
			this.legFrontLeft.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
			
			
			this.armRight.rotateAngleX = 1.5708F+ MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F
					* limbSwingAmount;
			this.armLeft.rotateAngleX = 1.5708F + MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
			this.legLeft.rotateAngleX =1.5708F+  MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
			this.legRight.rotateAngleX = 1.5708F+MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F
					* limbSwingAmount;
			if (entityIn.isTamed()) {
				this.platypus1.showModel = false;
				this.platypus2.showModel = true;
				  
			}
			else {
				this.platypus1.showModel = true;
				  this.platypus2.showModel = false;
			}
			
}


	@Override
	public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn,
			float red, float green, float blue, float alpha) {
		platypus1.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
		platypus2.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
		
	}


	@Override
	public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch) {
		this.head2.rotateAngleX = 1.5708F+ headPitch * ((float) Math.PI / 180F);
		this.head2.rotateAngleZ = netHeadYaw * ((float) Math.PI / 180F);
	}
}