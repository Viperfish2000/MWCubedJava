package com.viperfish2000.client.model;

import org.apache.logging.log4j.LogManager;

import com.google.common.collect.ImmutableList;
import com.viperfish2000.entity.LanternSharkEntity;

import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

/**
 * Peeper.tcn - TechneToTabulaImporter Created using Tabula 4.1.1
 */
public class LanternSharkModel<T extends Entity> extends SegmentedModel<T> {
	private final ModelRenderer body;
	private final ModelRenderer head;
	private final ModelRenderer topjaw;
	private final ModelRenderer bone4;
	private final ModelRenderer jaw;
	private final ModelRenderer tail;
	private final ModelRenderer bone6;
	private final ModelRenderer tail2;
	private final ModelRenderer bone2;
	private final ModelRenderer bone;
	private final ModelRenderer antfin;
	private final ModelRenderer antfin2;
	private final ModelRenderer antfin3;
	private final ModelRenderer bone3;
	private final ModelRenderer bone5;
	private final ModelRenderer bone7;
	private final ModelRenderer fintail;

	public LanternSharkModel() {
		textureWidth = 64;
		textureHeight = 64;

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 22.0F, 0.0F);
		body.setTextureOffset(0, 0).addBox(-3.0F, -3.0F, -6.0F, 5.0F, 5.0F, 12.0F, 0.0F, false);

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, 0.0F, -5.0F);
		body.addChild(head);
		

		topjaw = new ModelRenderer(this);
		topjaw.setRotationPoint(0.0F, -2.5F, -1.5F);
		head.addChild(topjaw);
		setRotationAngle(topjaw, 0.0873F, 0.0F, 0.0F);
		topjaw.setTextureOffset(19, 17).addBox(-2.5F, -0.5F, -9.2412F, 4.0F, 2.0F, 9.0F, 0.02F, false);

		bone4 = new ModelRenderer(this);
		bone4.setRotationPoint(0.0F, 1.5372F, -0.0927F);
		topjaw.addChild(bone4);
		setRotationAngle(bone4, -0.1745F, 0.0F, 0.0F);
		bone4.setTextureOffset(0, 17).addBox(-2.5F, -0.2105F, -8.9034F, 4.0F, 2.0F, 11.0F, 0.0F, false);

		jaw = new ModelRenderer(this);
		jaw.setRotationPoint(-0.5F, 0.5F, -1.75F);
		head.addChild(jaw);
		jaw.setTextureOffset(23, 28).addBox(-2.0F, -0.249F, -6.0218F, 4.0F, 1.0F, 7.0F, -0.01F, false);

		tail = new ModelRenderer(this);
		tail.setRotationPoint(-0.5F, -1.25F, 4.5F);
		body.addChild(tail);
		tail.setTextureOffset(22, 0).addBox(-2.0F, -1.25F, 0.5F, 4.0F, 3.0F, 8.0F, 0.0F, false);

		bone6 = new ModelRenderer(this);
		bone6.setRotationPoint(0.0F, 0.5F, 6.5F);
		tail.addChild(bone6);
		setRotationAngle(bone6, -0.6109F, 0.0F, 0.0F);
		bone6.setTextureOffset(0, 17).addBox(-0.5F, -3.9096F, -2.2868F, 1.0F, 4.0F, 4.0F, 0.0F, false);

		tail2 = new ModelRenderer(this);
		tail2.setRotationPoint(0.0F, 0.0F, 7.5F);
		tail.addChild(tail2);
		tail2.setTextureOffset(10, 30).addBox(-1.5F, -0.5F, 0.0F, 3.0F, 2.0F, 6.0F, 0.0F, false);

		bone2 = new ModelRenderer(this);
		bone2.setRotationPoint(0.5F, -12.0F, -16.0F);
		tail2.addChild(bone2);
		setRotationAngle(bone2, -0.8727F, 0.0F, 0.0F);
		bone2.setTextureOffset(36, 36).addBox(-1.0F, -10.0F, 23.0F, 1.0F, 3.0F, 4.0F, 0.0F, false);

		bone = new ModelRenderer(this);
		bone.setRotationPoint(0.5F, 0.0F, 5.0F);
		tail2.addChild(bone);
		setRotationAngle(bone, 0.6109F, 0.0F, 0.0F);
		bone.setTextureOffset(0, 30).addBox(-1.1434F, -0.4709F, -0.3014F, 1.0F, 2.0F, 8.0F, 0.0F, false);

		antfin = new ModelRenderer(this);
		antfin.setRotationPoint(0.5F, 10.25F, -11.25F);
		tail.addChild(antfin);
		setRotationAngle(antfin, -0.4363F, 0.0F, 0.0F);
		antfin.setTextureOffset(36, 18).addBox(0.25F, -12.846F, 7.1131F, 1.0F, 2.0F, 3.0F, 0.0F, false);

		antfin2 = new ModelRenderer(this);
		antfin2.setRotationPoint(-2.5F, 10.25F, -11.25F);
		tail.addChild(antfin2);
		setRotationAngle(antfin2, -0.4363F, 0.0F, 0.0F);
		antfin2.setTextureOffset(38, 0).addBox(0.75F, -12.846F, 7.1131F, 1.0F, 2.0F, 3.0F, 0.0F, false);

		antfin3 = new ModelRenderer(this);
		antfin3.setRotationPoint(-1.0F, 8.75F, -5.25F);
		tail.addChild(antfin3);
		setRotationAngle(antfin3, -0.4363F, 0.0F, 0.0F);
		

		bone3 = new ModelRenderer(this);
		bone3.setRotationPoint(-4.0F, 1.0F, -3.0F);
		body.addChild(bone3);
		setRotationAngle(bone3, -0.8727F, 0.0F, 0.8727F);
		

		bone5 = new ModelRenderer(this);
		bone5.setRotationPoint(2.0F, -0.75F, -4.5F);
		body.addChild(bone5);
		setRotationAngle(bone5, -0.7854F, 0.0F, -0.6109F);
		bone5.setTextureOffset(36, 11).addBox(-1.0566F, -1.2085F, -0.1066F, 1.0F, 3.0F, 4.0F, 0.0F, false);

		bone7 = new ModelRenderer(this);
		bone7.setRotationPoint(-3.0F, -0.75F, -4.5F);
		body.addChild(bone7);
		setRotationAngle(bone7, -0.7854F, 0.0F, 0.6109F);
		bone7.setTextureOffset(36, 11).addBox(-0.0566F, -1.2085F, -0.1066F, 1.0F, 3.0F, 4.0F, 0.0F, false);

		fintail = new ModelRenderer(this);
		fintail.setRotationPoint(0.0F, 7.0F, -9.25F);
		body.addChild(fintail);
		setRotationAngle(fintail, -0.6109F, 0.0F, 0.0F);
		fintail.setTextureOffset(0, 17).addBox(-1.0F, -16.1808F, 0.5736F, 1.0F, 5.0F, 4.0F, 0.0F, false);
	}
	public Iterable<ModelRenderer> getParts() {
		return ImmutableList.of(this.body);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	@Override
	public void setLivingAnimations(T entityIn, float limbSwing, float limbSwingAmount, float partialTick) {
		// this.rightArmPose = ModelBiped.ArmPose.EMPTY;
		// this.leftArmPose = ModelBiped.ArmPose.EMPTY;
		/**
		 * if (((LanternSharkEntity)entityIn).isAttacking()) { this.lowerjaw.rotateAngleX =
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
		int i = ((LanternSharkEntity) entityIn).getAttackTimer();
		float j = ((LanternSharkEntity) entityIn).attackTime;
		LogManager.getLogger().info("test " + jaw.rotateAngleX);
		if (i > (j/2)) {
			this.jaw.rotateAngleX =-0.001F * (i - (j/2)) / (j/2) + 0.9F * (j - i) / (j/2);
		} else if (i > 0) {
			this.jaw.rotateAngleX = (0.9F * i) / (j/2) + -0.001F * ((j/2) - i) / (j/2);
		}
		// this.ironGolemLeftArm.rotateAngleX = -2.0F + 1.5F *
		// this.triangleWave((float)i - partialTick, 10.0F);
		else {
			this.jaw.rotateAngleX = -0.001F + 0.2F * this.triangleWave(limbSwing, 70.0F);
		}
	}

	public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch) {
		this.body.rotateAngleX = headPitch * ((float) Math.PI / 180F);
		this.body.rotateAngleY = netHeadYaw * ((float) Math.PI / 180F);

		if (entityIn instanceof LanternSharkEntity) {
			LanternSharkEntity LanternSharkEntity = (LanternSharkEntity) entityIn;
			int i = LanternSharkEntity.getAttackTimer();
			if (LanternSharkEntity.getMotion().x != 0.0D || LanternSharkEntity.getMotion().z != 0.0D) {
				this.body.rotateAngleY += -0.05F + -0.05F * MathHelper.cos(ageInTicks * 0.4F);
				this.tail.rotateAngleY = -0.2F * MathHelper.cos(ageInTicks * 0.4F);
				this.tail2.rotateAngleY = -0.2F * MathHelper.cos(ageInTicks * 0.4F);
				
				this.head.rotateAngleY = -0.1F * MathHelper.cos(ageInTicks * 0.4F);
			
			}
			else {
				this.body.rotateAngleY += -0.02F + -0.02F * MathHelper.cos(ageInTicks * 0.1F);
				this.tail.rotateAngleY = -0.1F * MathHelper.cos(ageInTicks * 0.1F);
				this.tail2.rotateAngleY = -0.1F * MathHelper.cos(ageInTicks * 0.1F);
				
				this.head.rotateAngleY = -0.05F * MathHelper.cos(ageInTicks * 0.1F);
			}

		}

	}

	private float triangleWave(float p_78172_1_, float p_78172_2_) {
		return (Math.abs(p_78172_1_ % p_78172_2_ - p_78172_2_ * 0.5F) - p_78172_2_ * 0.25F) / (p_78172_2_ * 0.25F);
	}

}
