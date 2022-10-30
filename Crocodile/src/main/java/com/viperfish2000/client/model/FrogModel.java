package com.viperfish2000.client.model;

import org.apache.logging.log4j.LogManager;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.viperfish2000.entity.FrogEntity;

import net.minecraft.client.renderer.entity.model.QuadrupedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

// Made with Blockbench 3.5.4
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

public class FrogModel<T extends FrogEntity> extends QuadrupedModel<T> {

	private final ModelRenderer bone4;
	private final ModelRenderer bone5;
	private final ModelRenderer bone7;
	private final ModelRenderer bone8;
	private final ModelRenderer head;
	private final ModelRenderer bone12;
	private final ModelRenderer throat;
	private final ModelRenderer bone10;
	private final ModelRenderer bone11;

	public FrogModel() {
		super(12, 0.0F, true, 16.0F, 4.0F, 2.25F, 2.0F, 24);
		textureWidth = 64;
		textureHeight = 64;

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 23.5F, 0.0F);
		setRotationAngle(body, -0.1745F, 0.0F, 0.0F);
		body.setTextureOffset(0, 0).addBox(-4.5F, -5.9981F, -2.7936F, 8.0F, 5.0F, 10.0F, 0.0F, false);

		legBackLeft = new ModelRenderer(this);
		legBackLeft.setRotationPoint(3.5F, -2.8794F, 7.983F);
		body.addChild(legBackLeft);
		setRotationAngle(legBackLeft, 0.1745F, 0.0F, 0.0F);
		legBackLeft.setTextureOffset(0, 25).addBox(-1.5F, -1.5833F, -4.4177F, 3.0F, 3.0F, 6.0F, 0.0F, false);

		bone4 = new ModelRenderer(this);
		bone4.setRotationPoint(1.0F, 0.7538F, -3.6639F);
		legBackLeft.addChild(bone4);
		setRotationAngle(bone4, 3.1416F, 0.0F, 0.0F);
		bone4.setTextureOffset(18, 26).addBox(-2.0F, -1.2986F, -4.6339F, 2.0F, 2.0F, 4.0F, 0.0F, false);

		bone5 = new ModelRenderer(this);
		bone5.setRotationPoint(-2.0F, -0.7847F, -2.453F);
		bone4.addChild(bone5);
		setRotationAngle(bone5, 3.1416F, 0.0F, 0.0F);
		bone5.setTextureOffset(17, 18).addBox(-1.25F, -0.1854F, -6.9957F, 4.0F, 1.0F, 7.0F, 0.0F, false);

		legBackRight = new ModelRenderer(this);
		legBackRight.setRotationPoint(-4.5F, -2.8794F, 7.983F);
		body.addChild(legBackRight);
		setRotationAngle(legBackRight, 0.1745F, 0.0F, 0.0F);
		legBackRight.setTextureOffset(0, 25).addBox(-1.5F, -1.5833F, -4.4177F, 3.0F, 3.0F, 6.0F, 0.0F, true);

		bone7 = new ModelRenderer(this);
		bone7.setRotationPoint(1.0F, 0.7538F, -3.6639F);
		legBackRight.addChild(bone7);
		setRotationAngle(bone7, 3.1416F, 0.0F, 0.0F);
		bone7.setTextureOffset(18, 26).addBox(-2.0F, -1.2986F, -4.6339F, 2.0F, 2.0F, 4.0F, 0.0F, false);

		bone8 = new ModelRenderer(this);
		bone8.setRotationPoint(-2.0F, -0.7847F, -2.453F);
		bone7.addChild(bone8);
		setRotationAngle(bone8, 3.1416F, 0.0F, 0.0F);
		bone8.setTextureOffset(17, 18).addBox(-1.0F, -0.1854F, -6.9957F, 4.0F, 1.0F, 7.0F, 0.0F, true);

		legFrontLeft = new ModelRenderer(this);
		legFrontLeft.setRotationPoint(3.25F, -2.1853F, -2.2415F);
		body.addChild(legFrontLeft);
		setRotationAngle(legFrontLeft, 1.1345F, -0.4363F, 0.4363F);
		legFrontLeft.setTextureOffset(26, 0).addBox(-1.0886F, -0.6654F, -3.9714F, 2.0F, 1.0F, 4.0F, 0.0F, false);

		legFrontRight = new ModelRenderer(this);
		legFrontRight.setRotationPoint(-4.75F, -2.1853F, -2.2415F);
		body.addChild(legFrontRight);
		setRotationAngle(legFrontRight, 1.2217F, 0.1745F, -0.5236F);
		legFrontRight.setTextureOffset(26, 0).addBox(-1.0886F, -0.6654F, -3.9714F, 2.0F, 1.0F, 4.0F, 0.0F, false);

		head = new ModelRenderer(this);
		head.setRotationPoint(-1.0F, 19.7415F, -0.9353F);
		setRotationAngle(head, -0.4363F, 0.0F, 0.0F);
		head.setTextureOffset(0, 15).addBox(-2.0F, -1.9022F, -5.7605F, 5.0F, 2.0F, 7.0F, 0.0F, false);

		bone12 = new ModelRenderer(this);
		bone12.setRotationPoint(1.0F, 0.25F, -1.0F);
		head.addChild(bone12);

		throat = new ModelRenderer(this);
		throat.setRotationPoint(1.0F, 0.0F, -1.0F);
		bone12.addChild(throat);
		throat.setTextureOffset(1, 38).addBox(-4.0F, -0.1522F, -3.7605F, 5.0F, 1.0F, 7.0F, 0.0F, false);

		bone10 = new ModelRenderer(this);
		bone10.setRotationPoint(2.75F, -1.75F, -2.5F);
		head.addChild(bone10);
		setRotationAngle(bone10, 0.0F, 0.6109F, 0.0F);
		bone10.setTextureOffset(0, 4).addBox(-0.6653F, -1.2617F, -1.5801F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		bone11 = new ModelRenderer(this);
		bone11.setRotationPoint(-2.0F, -1.75F, -2.5F);
		head.addChild(bone11);
		setRotationAngle(bone11, 0.0F, -0.6109F, 0.0F);
		bone11.setTextureOffset(0, 4).addBox(-1.13F, -1.2617F, -1.7235F, 2.0F, 2.0F, 2.0F, 0.0F, true);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	@Override
	protected Iterable<ModelRenderer> getBodyParts() {
		return ImmutableList.of(this.body);
	}

	protected Iterable<ModelRenderer> getHeadParts() {
		return ImmutableList.of(this.head);
	}

	@Override
	public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch) {
		super.setRotationAngles((T) entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
		float f = ageInTicks - (float) entityIn.ticksExisted;
		// float f1 = entityIn.getStandingAnimationScale(f);
		// f1 = f1 * f1;
		// float f2 = 1.0F - f1;
		setRotationAngle(legFrontLeft, 1.1345F, -0.4363F, 0.4363F);
		// setRotationAngle(legFrontRight, 1.2217F, 0.1745F, -0.5236F);

		this.body.rotateAngleX = -0.1745F;
		this.head.rotateAngleX = headPitch * ((float) Math.PI / 180F);
		this.head.rotateAngleY = netHeadYaw * ((float) Math.PI / 180F);

		this.legBackRight.rotateAngleX = 0.1745F;
		this.legBackLeft.rotateAngleX = 0.1745F;
	//	this.legFrontRight.rotateAngleX = 1.2217F;
		// this.legFrontLeft.rotateAngleX = 1.1345F;

		setRotationAngle(bone5, 3.1416F, 0.0F, 0.0F);
		setRotationAngle(bone4, 3.1416F, 0.0F, 0.0F);
		setRotationAngle(bone7, 3.1416F, 0.0F, 0.0F);
		setRotationAngle(bone8, 3.1416F, 0.0F, 0.0F);

		this.legBackRight.rotateAngleY = 0;
		this.legBackRight.rotateAngleZ = 0;
		this.legBackLeft.rotateAngleY = 0;
		this.legBackLeft.rotateAngleZ = 0;

		if (!entityIn.onGround) {
			textureWidth = 64;
			textureHeight = 64;

			setRotationAngle(legBackLeft, 2.4435F, 0.3491F, 0.0F);
			setRotationAngle(bone4, 0.6981F, 0.0F, 0.0F);
			setRotationAngle(bone5, -0.6981F, 0.0F, 0.0F);
			setRotationAngle(legBackRight, 2.4435F, -0.3491F, 0.0F);
			setRotationAngle(bone7, 0.6981F, 0.0F, 0.0F);
			setRotationAngle(bone8, -0.6981F, 0.0F, 0.0F);
			setRotationAngle(legFrontLeft, 0.0F, -0.6981F, 0.1745F);
			setRotationAngle(legFrontRight, 1.2217F, 0.6981F, 0.0F);
			setRotationAngle(bone10, 0.0F, 0.6109F, 0.0F);
			setRotationAngle(bone11, 0.0F, -0.6109F, 0.0F);
		}

		/**
		 * int i = entityIn.getJumpTimerPositive(); int k =
		 * entityIn.getJumpTimerNegative(); float j = entityIn.jumpLength; //
		 * LogManager.getLogger().info("test " + this.legFrontRight.rotateAngleX); if (i
		 * > 0) { float x1 = 1.2217F; float x2 = 0; this.legFrontLeft.rotateAngleX = x1
		 * * (i - (j / 2)) / (j / 2) + x2 * (j - i) / (j / 2); float y1 = 0.1745F; float
		 * y2 = -0.6981F; this.legFrontLeft.rotateAngleY = y1 * (i - (j / 2)) / (j / 2)
		 * + y2 * (j - i) / (j / 2); float z1 = -0.5236F; float z2 = 0.1745F;
		 * this.legFrontLeft.rotateAngleZ = z1 * (i - (j / 2)) / (j / 2) + z2 * (j - i)
		 * / (j / 2); if (k > 0) {
		 * 
		 * this.legFrontLeft.rotateAngleX = (x2 * i) / (j / 2) + x1 * ((j / 2) - i) / (j
		 * / 2);
		 * 
		 * this.legFrontLeft.rotateAngleY = (y2 * i) / (j / 2) + y1 * ((j / 2) - i) / (j
		 * / 2);
		 * 
		 * this.legFrontLeft.rotateAngleZ = (z2 * i) / (j / 2) + z1 * ((j / 2) - i) / (j
		 * / 2); } } else if (k > 0) { float x1 = 1.2217F; float x2 = 0;
		 * this.legFrontLeft.rotateAngleX = (x2 * i) / (j / 2) + x1 * ((j / 2) - i) / (j
		 * / 2); float y1 = 0.1745F; float y2 = -0.6981F; this.legFrontLeft.rotateAngleY
		 * = (y2 * i) / (j / 2) + y1 * ((j / 2) - i) / (j / 2); float z1 = -0.5236F;
		 * float z2 = 0.1745F; this.legFrontLeft.rotateAngleZ = (z2 * i) / (j / 2) + z1
		 * * ((j / 2) - i) / (j / 2); }
		 **/

		if (entityIn.isInWater()) {
			this.legBackRight.rotateAngleX = 3.0543F + MathHelper.cos(limbSwing * 0.6662F) * 0.9F * limbSwingAmount;
			this.legBackLeft.rotateAngleX = 3.0543F
					+ -MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.9F * limbSwingAmount;
			// setRotationAngle(leftBackLeg, -3.0543F, 0.0F, 1.5708F);

			this.legBackRight.rotateAngleY = 0;
			this.legBackRight.rotateAngleZ = -1.5708F;
			this.legBackLeft.rotateAngleY = 0;
			this.legBackLeft.rotateAngleZ = 1.5708F;

			this.bone7.rotateAngleX = 0.6981F + MathHelper.cos(limbSwing * 0.6662F) * -0.9F * limbSwingAmount;
			this.bone4.rotateAngleX = 0.6981F
					+ -MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * -0.9F * limbSwingAmount;

			this.bone8.rotateAngleX = -0.8727F + MathHelper.cos(limbSwing * 0.6662F) * 0.9F * limbSwingAmount;
			this.bone5.rotateAngleX = -0.8727F
					+ -MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.9F * limbSwingAmount;

			setRotationAngle(legFrontLeft, 2.7925F, -0.4363F, -0.4363F);
			setRotationAngle(legFrontRight, 2.4435F, 0.1745F, -0.5236F);

		}

	}
}
