package com.viperfish2000.client.model;

import org.apache.logging.log4j.LogManager;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.viperfish2000.entity.CrocodileEntity;

import net.minecraft.client.renderer.entity.model.QuadrupedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

// Made with Blockbench 3.5.4
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

public class CrocodileModel<T extends Entity> extends QuadrupedModel<T> {

	private final ModelRenderer jawUpper;
	private final ModelRenderer bone19;
	private final ModelRenderer bone18;
	private final ModelRenderer jawLower;
	private final ModelRenderer bone15;
	private final ModelRenderer bone16;
	private final ModelRenderer bone17;
	private final ModelRenderer bone12;
	private final ModelRenderer bone11;
	private final ModelRenderer bone13;
	private final ModelRenderer tail;
	private final ModelRenderer tail1;
	private final ModelRenderer tail2;

	public CrocodileModel() {
		super(12, 0.0F, true, 16.0F, 4.0F, 2.25F, 2.0F, 24);
		textureWidth = 128;
		textureHeight = 128;

		headModel = new ModelRenderer(this);
		headModel.setRotationPoint(0.0F, 16.0F, -23.0F);

		headModel.setTextureOffset(63, 77).addBox(-6.0F, -5.0354F, -3.9479F, 12.0F, 9.0F, 8.0F, 0.0F, false);
		headModel.setTextureOffset(17, 20).addBox(2.0F, -6.7862F, -6.2229F, 2.0F, 3.0F, 3.0F, 0.0F, true);
		headModel.setTextureOffset(17, 20).addBox(-4.0F, -6.7862F, -6.2229F, 2.0F, 3.0F, 3.0F, 0.0F, false);
		headModel.setTextureOffset(22, 27).addBox(-5.0F, -5.9607F, -0.2259F, 2.0F, 1.0F, 2.0F, 0.0F, false);
		headModel.setTextureOffset(22, 27).addBox(-1.0F, -5.9607F, -0.2259F, 2.0F, 1.0F, 2.0F, 0.0F, false);
		headModel.setTextureOffset(22, 27).addBox(3.0F, -5.9607F, -0.2259F, 2.0F, 1.0F, 2.0F, 0.0F, false);

		jawUpper = new ModelRenderer(this);
		jawUpper.setRotationPoint(0.0F, -2.175F, -3.9492F);
		headModel.addChild(jawUpper);
		jawUpper.setTextureOffset(0, 70).addBox(-4.5F, -2.016F, -15.0552F, 9.0F, 4.0F, 15.0F, 0.0F, false);
		jawUpper.setTextureOffset(0, 17).addBox(-3.0F, -3.9657F, -14.9657F, 6.0F, 2.0F, 4.0F, 0.0F, false);

		bone19 = new ModelRenderer(this);
		bone19.setRotationPoint(4.5F, 1.75F, -6.0537F);
		jawUpper.addChild(bone19);
		setRotationAngle(bone19, 0.0F, 0.0F, 2.9671F);
		bone19.setTextureOffset(100, 91).addBox(0.0F, -1.8604F, -8.9451F, 0.0F, 2.0F, 14.0F, 0.0F, true);

		bone18 = new ModelRenderer(this);
		bone18.setRotationPoint(-4.5F, 1.75F, -6.0537F);
		jawUpper.addChild(bone18);
		setRotationAngle(bone18, 0.0F, 0.0F, -2.9671F);
		bone18.setTextureOffset(100, 91).addBox(0.0F, -1.8604F, -8.9451F, 0.0F, 2.0F, 14.0F, 0.0F, true);

		jawLower = new ModelRenderer(this);
		jawLower.setRotationPoint(-4.0F, 0.5241F, -5.0029F);
		headModel.addChild(jawLower);
		jawLower.setTextureOffset(80, 53).addBox(-0.5F, -0.8094F, -4.9451F, 9.0F, 3.0F, 7.0F, 0.0F, false);
		jawLower.setTextureOffset(80, 41).addBox(0.0F, -0.8094F, -13.9451F, 8.0F, 3.0F, 9.0F, 0.0F, false);

		bone15 = new ModelRenderer(this);
		bone15.setRotationPoint(0.5F, -0.949F, -5.0F);
		jawLower.addChild(bone15);
		bone15.setTextureOffset(67, 86).addBox(0.0F, -1.8604F, -8.9451F, 0.0F, 2.0F, 14.0F, 0.0F, false);

		bone16 = new ModelRenderer(this);
		bone16.setRotationPoint(7.0F, -1.0F, -6.0F);
		jawLower.addChild(bone16);
		bone16.setTextureOffset(67, 86).addBox(0.5F, -1.8094F, -7.9451F, 0.0F, 2.0F, 14.0F, 0.0F, true);

		bone17 = new ModelRenderer(this);
		bone17.setRotationPoint(5.0F, -1.0F, -14.0F);
		jawLower.addChild(bone17);
		setRotationAngle(bone17, 0.0698F, 0.0F, 0.0F);
		bone17.setTextureOffset(67, 102).addBox(-5.5F, -1.8094F, 0.0549F, 9.0F, 2.0F, 0.0F, 0.0F, true);

		legBackRight = new ModelRenderer(this);
		legBackRight.setRotationPoint(-10.0F, 17.0F, 5.0F);
		legBackRight.setTextureOffset(0, 0).addBox(-3.0F, -3.0F, -3.0F, 6.0F, 10.0F, 7.0F, 0.0F, false);

		legBackLeft = new ModelRenderer(this);
		legBackLeft.setRotationPoint(10.0F, 17.0F, 5.0F);
		legBackLeft.setTextureOffset(0, 0).addBox(-3.0F, -3.0F, -3.0F, 6.0F, 10.0F, 7.0F, 0.0F, true);

		legFrontRight = new ModelRenderer(this);
		legFrontRight.setRotationPoint(-10.0F, 17.0F, -15.0F);
		legFrontRight.setTextureOffset(0, 89).addBox(-2.0F, -2.0F, -3.0F, 5.0F, 9.0F, 6.0F, 0.0F, false);

		legFrontLeft = new ModelRenderer(this);
		legFrontLeft.setRotationPoint(10.0F, 17.0F, -15.0F);
		legFrontLeft.setTextureOffset(0, 89).addBox(-3.0F, -2.0F, -3.0F, 5.0F, 9.0F, 6.0F, 0.0F, true);

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 22.0F, 0.0F);
		body.setTextureOffset(0, 0).addBox(-8.0F, -12.0F, -20.0F, 16.0F, 10.0F, 31.0F, 0.0F, false);

		tail = new ModelRenderer(this);
		tail.setRotationPoint(0.0F, -7.0F, 10.0F);
		body.addChild(tail);
		tail.setTextureOffset(0, 41).addBox(-6.0F, -4.0F, 0.0F, 12.0F, 9.0F, 20.0F, 0.0F, false);
		tail.setTextureOffset(33, 61).addBox(4.0F, -7.0F, 1.0F, 0.0F, 3.0F, 19.0F, 0.0F, true);
		tail.setTextureOffset(33, 61).addBox(-4.0F, -7.0F, 1.0F, 0.0F, 3.0F, 19.0F, 0.0F, false);

		tail1 = new ModelRenderer(this);
		tail1.setRotationPoint(0.0F, 1.0F, 19.0F);
		tail.addChild(tail1);
		tail1.setTextureOffset(44, 50).addBox(-4.0F, -3.0F, 1.0F, 8.0F, 7.0F, 20.0F, 0.0F, false);
		tail1.setTextureOffset(88, 105).addBox(-3.0F, -6.0F, 1.0F, 0.0F, 3.0F, 20.0F, 0.0F, false);
		tail1.setTextureOffset(88, 105).addBox(3.0F, -6.0F, 1.0F, 0.0F, 3.0F, 20.0F, 0.0F, true);

		tail2 = new ModelRenderer(this);
		tail2.setRotationPoint(0.0F, 1.0F, 21.0F);
		tail1.addChild(tail2);
		tail2.setTextureOffset(63, 0).addBox(-1.5F, -3.0F, -1.0F, 3.0F, 6.0F, 21.0F, 0.0F, false);
		tail2.setTextureOffset(0, 105).addBox(0.0F, -6.0F, 0.0F, 0.0F, 3.0F, 20.0F, 0.0F, false);

		bone12 = new ModelRenderer(this);
		bone12.setRotationPoint(-5.0F, -11.0F, -18.0F);
		body.addChild(bone12);
		bone12.setTextureOffset(22, 27).addBox(0.0F, -2.0F, 0.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);
		bone12.setTextureOffset(22, 27).addBox(0.0F, -2.0F, 24.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);
		bone12.setTextureOffset(22, 27).addBox(0.0F, -2.0F, 12.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);
		bone12.setTextureOffset(22, 27).addBox(0.0F, -2.0F, 20.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);
		bone12.setTextureOffset(22, 27).addBox(0.0F, -2.0F, 8.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);
		bone12.setTextureOffset(22, 27).addBox(0.0F, -2.0F, 16.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);
		bone12.setTextureOffset(22, 27).addBox(0.0F, -2.0F, 4.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);
		bone12.setTextureOffset(22, 27).addBox(0.0F, -2.0F, 0.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);

		bone11 = new ModelRenderer(this);
		bone11.setRotationPoint(-1.0F, -11.0F, -18.0F);
		body.addChild(bone11);
		bone11.setTextureOffset(22, 27).addBox(0.0F, -2.0F, 0.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);
		bone11.setTextureOffset(22, 27).addBox(0.0F, -2.0F, 24.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);
		bone11.setTextureOffset(22, 27).addBox(0.0F, -2.0F, 12.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);
		bone11.setTextureOffset(22, 27).addBox(0.0F, -2.0F, 20.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);
		bone11.setTextureOffset(22, 27).addBox(0.0F, -2.0F, 8.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);
		bone11.setTextureOffset(22, 27).addBox(0.0F, -2.0F, 16.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);
		bone11.setTextureOffset(22, 27).addBox(0.0F, -2.0F, 4.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);
		bone11.setTextureOffset(22, 27).addBox(0.0F, -2.0F, 0.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);

		bone13 = new ModelRenderer(this);
		bone13.setRotationPoint(3.0F, -11.0F, -18.0F);
		body.addChild(bone13);
		bone13.setTextureOffset(22, 27).addBox(0.0F, -2.0F, 0.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);
		bone13.setTextureOffset(22, 27).addBox(0.0F, -2.0F, 24.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);
		bone13.setTextureOffset(22, 27).addBox(0.0F, -2.0F, 12.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);
		bone13.setTextureOffset(22, 27).addBox(0.0F, -2.0F, 20.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);
		bone13.setTextureOffset(22, 27).addBox(0.0F, -2.0F, 8.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);
		bone13.setTextureOffset(22, 27).addBox(0.0F, -2.0F, 16.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);
		bone13.setTextureOffset(22, 27).addBox(0.0F, -2.0F, 4.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);
		bone13.setTextureOffset(22, 27).addBox(0.0F, -2.0F, 0.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);

	}

	@Override
	public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch) {
		super.setRotationAngles((T) entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
		float f = ageInTicks - (float) entityIn.ticksExisted;
		// float f1 = entityIn.getStandingAnimationScale(f);
		// f1 = f1 * f1;
		// float f2 = 1.0F - f1;
		this.body.rotateAngleX = 0 /*** -((float)Math.PI / 2F) **/
		;
		this.headModel.rotateAngleX = headPitch * ((float) Math.PI / 180F);
		this.headModel.rotateAngleY = netHeadYaw * ((float) Math.PI / 180F);

		this.legBackRight.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.legBackLeft.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
		this.legFrontRight.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F
				* limbSwingAmount;
		this.legFrontLeft.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		// this.body.rotationPointY = 9.0F * f2 + 11.0F * f1;
		// this.legFrontRight.rotationPointY = 14.0F * f2 - 6.0F * f1;
		// this.legFrontRight.rotationPointZ = -8.0F * f2 - 4.0F * f1;
		// this.legFrontRight.rotateAngleX -= 1 * (float)Math.PI * 0.45F;
		// this.legFrontLeft.rotationPointY = this.legFrontRight.rotationPointY;
		// this.legFrontLeft.rotationPointZ = this.legFrontRight.rotationPointZ;
		// this.legFrontLeft.rotateAngleX -= 1 * (float)Math.PI * 0.45F;

		if (entityIn.isInWater() && !entityIn.onGround) {
			this.legBackRight.rotateAngleX = -0.0174533F + MathHelper.cos(limbSwing * 0.6662F) * 0.4F * limbSwingAmount;
			this.legBackLeft.rotateAngleX = -0.0174533F
					+ -MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.4F * limbSwingAmount;
			this.legFrontRight.rotateAngleX = -0.0174533F
					+ -MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.4F * limbSwingAmount;
			this.legFrontLeft.rotateAngleX = -0.0174533F + MathHelper.cos(limbSwing * 0.6662F) * 0.4F * limbSwingAmount;
		}

		if (this.isChild) {
			// this.headModel.rotationPointY = 10.0F * f2 - 9.0F * f1;
			// this.headModel.rotationPointZ = -16.0F * f2 - 7.0F * f1;
		} else {
			// this.headModel.rotationPointY = 10.0F * f2 - 14.0F * f1;
			// this.headModel.rotationPointZ = -16.0F * f2 - 3.0F * f1;
		}

		this.headModel.rotateAngleX += 1 * (float) Math.PI * 0.045F;

		if (entityIn instanceof CrocodileEntity) {
			CrocodileEntity CrocodileEntity = (CrocodileEntity) entityIn;

			if (CrocodileEntity.getMotion().x != 0.0D || CrocodileEntity.getMotion().z != 0.0D) {

				this.tail.rotateAngleY = -0.05F * MathHelper.cos(ageInTicks * 0.2F);
				this.tail1.rotateAngleY = -0.05F * MathHelper.cos(ageInTicks * 0.2F);
				this.tail2.rotateAngleY = -0.05F * MathHelper.cos(ageInTicks * 0.2F);
				if (entityIn.isInWater() && !entityIn.onGround) {
					this.tail.rotateAngleY = -0.1F * MathHelper.cos(ageInTicks * 0.2F);
					this.tail1.rotateAngleY = -0.1F * MathHelper.cos(ageInTicks * 0.2F);
					this.tail2.rotateAngleY = -0.1F * MathHelper.cos(ageInTicks * 0.2F);
				}
			}

		}
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {

	//	bone12.render(matrixStack, buffer, packedLight, packedOverlay);
	//	bone11.render(matrixStack, buffer, packedLight, packedOverlay);
	//	bone13.render(matrixStack, buffer, packedLight, packedOverlay);
		super.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

//	@Override
	public void setLivingAnimations(CrocodileEntity entityIn, float limbSwing, float limbSwingAmount,
			float partialTick) {
		// this.rightArmPose = ModelBiped.ArmPose.EMPTY;
		// this.leftArmPose = ModelBiped.ArmPose.EMPTY;
		/**
		 * if (((StalkerEntity)entityIn).isAttacking()) { this.lowerjaw.rotateAngleX =
		 * 0.666F; } else { this.lowerjaw.rotateAngleX = 0.125F; }
		 **/
		/**
		 * int i = entityIn.getAttackTimer(); if (i > 0) { this.lowerjaw.rotateAngleX =
		 * -2F + 1.5F * this.triangleWave((float)i - partialTickTime, 10.0F); //
		 * this.ironGolemLeftArm.rotateAngleX = -2.0F + 1.5F *
		 * this.triangleWave((float)i - partialTick, 10.0F); } else {
		 * this.lowerjaw.rotateAngleX = 0.125F + 0.025F * this.triangleWave(limbSwing,
		 * 70.0F);
		 * 
		 * 
		 * 
		 * } super.setLivingAnimations(entityIn, limbSwing, limbSwingAmount,
		 * partialTickTime);
		 **/
		int i = entityIn.getAttackTimers();
		float j = entityIn.attackTime;
		LogManager.getLogger().info("test " + jawLower.rotateAngleX);
		if (i > (j / 2)) {
			this.jawLower.rotateAngleX = 0.025F * (i - (j / 2)) / (j / 2) + 0.9F * (j - i) / (j / 2);
		} else if (i > 0) {
			this.jawLower.rotateAngleX = 0.052F;
		}
		// this.ironGolemLeftArm.rotateAngleX = -2.0F + 1.5F *
		// this.triangleWave((float)i - partialTick, 10.0F);
		else {
			// this.jawLower.rotateAngleX = 0.025F + 0.1F * this.triangleWave(limbSwing,
			// 70.0F);
		}
	}
}