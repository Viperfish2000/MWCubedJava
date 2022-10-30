package com.viperfish2000.client.model;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.QuadrupedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

// Made with Blockbench 3.5.4
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

public class GoatModel<T extends Entity> extends QuadrupedModel<T> {

	private final ModelRenderer bodyback;
	private final ModelRenderer tail;
	private final ModelRenderer bone4;
	private final ModelRenderer bone5;
	private final ModelRenderer bone2;
	private final ModelRenderer bone3;

	public GoatModel() {
		super(12, 0.0F, true, 16.0F, 4.0F, 2.25F, 2.0F, 24);
		textureWidth = 64;
		textureHeight = 64;

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 5.0F, 2.0F);
		setRotationAngle(body, 1.5708F, 0.0F, 0.0F);
		body.setTextureOffset(0, 0).addBox(-5.5F, -11.0F, -15.0F, 11.0F, 8.0F, 12.0F, 0.0F, false);

		bodyback = new ModelRenderer(this);
		bodyback.setRotationPoint(0.0F, -6.0F, -12.0F);
		body.addChild(bodyback);
		bodyback.setTextureOffset(0, 20).addBox(-4.5F, 3.0F, -2.0F, 9.0F, 7.0F, 10.0F, 0.0F, false);
		bodyback.setTextureOffset(0, 20).addBox(-4.5F, -4.0F, -2.0F, 9.0F, 7.0F, 10.0F, 0.0F, false);

		legBackLeft = new ModelRenderer(this);
		legBackLeft.setRotationPoint(2.75F, 8.25F, 2.0F);
		bodyback.addChild(legBackLeft);
		setRotationAngle(legBackLeft, -1.5708F, 0.0F, 0.0F);
		legBackLeft.setTextureOffset(0, 47).addBox(-2.0F, 3.0F, -1.0F, 3.0F, 6.0F, 3.0F, 0.0F, false);
		legBackLeft.setTextureOffset(32, 45).addBox(-2.5F, 1.0F, -1.5F, 4.0F, 6.0F, 4.0F, 0.0F, false);

		legBackRight = new ModelRenderer(this);
		legBackRight.setRotationPoint(-1.5F, 8.25F, 2.0F);
		bodyback.addChild(legBackRight);
		setRotationAngle(legBackRight, -1.5708F, 0.0F, 0.0F);
		legBackRight.setTextureOffset(0, 47).addBox(-2.0F, 3.0F, -1.0F, 3.0F, 6.0F, 3.0F, 0.0F, false);
		legBackRight.setTextureOffset(32, 45).addBox(-2.5F, 1.0F, -1.5F, 4.0F, 6.0F, 4.0F, 0.0F, false);

		tail = new ModelRenderer(this);
		tail.setRotationPoint(0.0F, 9.5F, 3.0F);
		bodyback.addChild(tail);
		setRotationAngle(tail, 0.6981F, 0.0F, 0.0F);
		tail.setTextureOffset(34, 0).addBox(-1.5F, -0.866F, -3.5F, 4.0F, 4.0F, 6.0F, 0.0F, false);

		headModel = new ModelRenderer(this);
		headModel.setRotationPoint(0.0F, 6.5F, -8.5F);
		setRotationAngle(headModel, 0.6981F, 0.0F, 0.0F);
		headModel.setTextureOffset(29, 29).addBox(-3.0F, -3.1399F, -8.05F, 6.0F, 7.0F, 9.0F, 0.0F, false);
		headModel.setTextureOffset(12, 37).addBox(3.0F, -3.1399F, -0.3F, 3.0F, 3.0F, 1.0F, 0.0F, false);
		headModel.setTextureOffset(12, 37).addBox(-6.0F, -3.1399F, -0.3F, 3.0F, 3.0F, 1.0F, 0.0F, true);

		bone4 = new ModelRenderer(this);
		bone4.setRotationPoint(1.5F, 1.8893F, 0.8016F);
		headModel.addChild(bone4);
		setRotationAngle(bone4, 0.8727F, 0.0F, 0.0F);
		bone4.setTextureOffset(13, 42).addBox(-4.51F, -5.5163F, -1.6293F, 0.0F, 3.0F, 3.0F, 0.0F, false);
		bone4.setTextureOffset(13, 42).addBox(1.51F, -5.5163F, -1.6293F, 0.0F, 3.0F, 3.0F, 0.0F, false);

		bone5 = new ModelRenderer(this);
		bone5.setRotationPoint(1.5F, 1.8893F, 0.8016F);
		headModel.addChild(bone5);
		setRotationAngle(bone5, 0.8727F, 0.0F, 0.0F);
		bone5.setTextureOffset(46, 15).addBox(-3.49F, -5.7663F, -9.6293F, 4.0F, 1.0F, 3.0F, 0.0F, false);

		bone2 = new ModelRenderer(this);
		bone2.setRotationPoint(1.25F, -3.1107F, -0.1984F);
		headModel.addChild(bone2);
		setRotationAngle(bone2, -0.6981F, 0.0F, 0.0F);
		bone2.setTextureOffset(50, 26).addBox(-0.5F, -5.033F, -0.7645F, 2.0F, 6.0F, 2.0F, 0.0F, true);

		bone3 = new ModelRenderer(this);
		bone3.setRotationPoint(-1.25F, -3.1107F, -0.1984F);
		headModel.addChild(bone3);
		setRotationAngle(bone3, -0.6981F, 0.0F, 0.0F);
		bone3.setTextureOffset(50, 26).addBox(-1.5F, -5.033F, -0.7645F, 2.0F, 6.0F, 2.0F, 0.0F, false);

		legFrontRight = new ModelRenderer(this);
		legFrontRight.setRotationPoint(-2.75F, 15.0F, -6.0F);
		legFrontRight.setTextureOffset(0, 47).addBox(-1.0F, 3.0F, -1.0F, 3.0F, 6.0F, 3.0F, 0.0F, true);
		legFrontRight.setTextureOffset(32, 45).addBox(-1.5F, 1.0F, -1.5F, 4.0F, 6.0F, 4.0F, 0.0F, true);

		legFrontLeft = new ModelRenderer(this);
		legFrontLeft.setRotationPoint(2.75F, 15.0F, -6.0F);
		legFrontLeft.setTextureOffset(0, 47).addBox(-2.0F, 3.0F, -1.0F, 3.0F, 6.0F, 3.0F, 0.0F, false);
		legFrontLeft.setTextureOffset(32, 45).addBox(-2.5F, 1.0F, -1.5F, 4.0F, 6.0F, 4.0F, 0.0F, false);

	}

	@Override
	public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netheadModelYaw, float headModelPitch) {

		super.setRotationAngles((T) entityIn, limbSwing, limbSwingAmount, ageInTicks, netheadModelYaw, headModelPitch);
		this.headModel.rotateAngleX = 0.6981F + headModelPitch * ((float)Math.PI / 180F);
	      this.headModel.rotateAngleY = netheadModelYaw * ((float)Math.PI / 180F);
		this.legBackRight.rotateAngleX = -1.5708F + MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.legBackLeft.rotateAngleX = -1.5708F + MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;

	}

	protected Iterable<ModelRenderer> getHeadParts() {
		return ImmutableList.of(this.headModel);
	}

	protected Iterable<ModelRenderer> getBodyParts() {
		return ImmutableList.of(this.body, this.legBackRight, this.legBackLeft, this.legFrontRight, this.legFrontLeft);
	}
	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		body.render(matrixStack, buffer, packedLight, packedOverlay);
		headModel.render(matrixStack, buffer, packedLight, packedOverlay);
		legFrontRight.render(matrixStack, buffer, packedLight, packedOverlay);
		legFrontLeft.render(matrixStack, buffer, packedLight, packedOverlay);
	}
	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

}