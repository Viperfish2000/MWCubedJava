package com.viperfish2000.client.model;

import org.apache.logging.log4j.LogManager;

import com.google.common.collect.ImmutableList;
import com.viperfish2000.entity.ThresherEntity;

import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

/**
 * Peeper.tcn - TechneToTabulaImporter Created using Tabula 4.1.1
 */
public class ThresherModel<T extends ThresherEntity> extends SegmentedModel<T> {
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
	private final ModelRenderer bone7;
	private final ModelRenderer antfin2;
	private final ModelRenderer antfin4;
	private final ModelRenderer antfin3;
	private final ModelRenderer bone3;
	private final ModelRenderer bone5;
	private final ModelRenderer fintail;

	public ThresherModel() {
		textureWidth = 64;
		textureHeight = 64;

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 15.0F, 0.0F);
		body.setTextureOffset(1, 0).addBox(-3.5F, -3.0F, -6.0F, 6.0F, 6.0F, 12.0F, 0.0F, false);

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, 1.0F, -3.0F);
		body.addChild(head);
		

		topjaw = new ModelRenderer(this);
		topjaw.setRotationPoint(0.0F, -3.5F, -2.5F);
		head.addChild(topjaw);
		setRotationAngle(topjaw, 0.0873F, 0.0F, 0.0F);
		topjaw.setTextureOffset(22, 21).addBox(-2.5F, -0.5F, -9.2412F, 4.0F, 2.0F, 9.0F, 0.0F, false);

		bone4 = new ModelRenderer(this);
		bone4.setRotationPoint(0.0F, 6.0353F, -3.1363F);
		topjaw.addChild(bone4);
		setRotationAngle(bone4, -0.2618F, 0.0F, 0.0F);
		bone4.setTextureOffset(1, 47).addBox(-3.0F, -4.7853F, -6.788F, 5.0F, 2.0F, 10.0F, 0.0F, false);

		jaw = new ModelRenderer(this);
		jaw.setRotationPoint(-0.5F, 0.75F, -2.75F);
		head.addChild(jaw);
		setRotationAngle(jaw, -0.0873F, 0.0F, 0.0F);
		jaw.setTextureOffset(17, 38).addBox(-2.0F, -0.4483F, -7.1907F, 4.0F, 1.0F, 8.0F, 0.0F, false);

		tail = new ModelRenderer(this);
		tail.setRotationPoint(0.0F, 1.0F, 3.0F);
		body.addChild(tail);
		tail.setTextureOffset(26, 0).addBox(-3.0F, -3.25F, 3.0F, 5.0F, 4.0F, 8.0F, 0.0F, false);

		bone6 = new ModelRenderer(this);
		bone6.setRotationPoint(-0.5F, 1.0F, 8.0F);
		tail.addChild(bone6);
		setRotationAngle(bone6, -0.4363F, 0.0F, 0.0F);
		bone6.setTextureOffset(38, 12).addBox(-0.5F, -4.6398F, -2.6221F, 1.0F, 2.0F, 4.0F, 0.0F, false);

		tail2 = new ModelRenderer(this);
		tail2.setRotationPoint(0.0F, 0.0F, 7.0F);
		tail.addChild(tail2);
		tail2.setTextureOffset(24, 32).addBox(-2.0F, -2.5F, 4.0F, 3.0F, 2.0F, 3.0F, 0.0F, false);

		bone2 = new ModelRenderer(this);
		bone2.setRotationPoint(0.0F, -14.0F, -14.0F);
		tail2.addChild(bone2);
		setRotationAngle(bone2, -0.8727F, 0.0F, 0.0F);
		bone2.setTextureOffset(0, 0).addBox(-1.0F, -10.0F, 23.0F, 1.0F, 3.0F, 5.0F, 0.0F, false);

		bone = new ModelRenderer(this);
		bone.setRotationPoint(0.0F, -1.0F, 7.5F);
		tail2.addChild(bone);
		setRotationAngle(bone, 0.6109F, 0.0F, 0.0F);
		bone.setTextureOffset(28, 45).addBox(-1.1434F, -1.8636F, -0.0558F, 1.0F, 2.0F, 16.0F, 0.0F, false);

		bone7 = new ModelRenderer(this);
		bone7.setRotationPoint(0.0F, -1.1748F, 15.3236F);
		bone.addChild(bone7);
		setRotationAngle(bone7, -0.0873F, 0.0F, 0.0F);
		bone7.setTextureOffset(34, 51).addBox(-1.1434F, -0.5682F, 0.5751F, 1.0F, 2.0F, 10.0F, 0.0F, false);

		antfin2 = new ModelRenderer(this);
		antfin2.setRotationPoint(1.0F, 0.75F, 3.25F);
		tail.addChild(antfin2);
		setRotationAngle(antfin2, -0.7854F, 0.0F, -1.0472F);
		antfin2.setTextureOffset(29, 24).addBox(-0.5F, -0.5546F, -1.4993F, 1.0F, 2.0F, 6.0F, 0.0F, true);

		antfin4 = new ModelRenderer(this);
		antfin4.setRotationPoint(-2.0F, 0.75F, 3.25F);
		tail.addChild(antfin4);
		setRotationAngle(antfin4, -0.7854F, 0.0F, 1.0472F);
		antfin4.setTextureOffset(29, 24).addBox(-0.5F, -0.5546F, -1.4993F, 1.0F, 2.0F, 6.0F, 0.0F, true);

		antfin3 = new ModelRenderer(this);
		antfin3.setRotationPoint(-1.5F, -3.25F, -4.75F);
		tail.addChild(antfin3);
		setRotationAngle(antfin3, -1.1345F, 0.0F, 0.0F);
		antfin3.setTextureOffset(40, 38).addBox(0.5F, -12.529F, 6.0107F, 1.0F, 2.0F, 4.0F, 0.0F, false);

		bone3 = new ModelRenderer(this);
		bone3.setRotationPoint(-4.0F, 1.0F, -3.0F);
		body.addChild(bone3);
		setRotationAngle(bone3, -0.8727F, 0.0F, 0.8727F);
		bone3.setTextureOffset(0, 37).addBox(1.0516F, 0.4284F, -0.6812F, 1.0F, 3.0F, 7.0F, 0.0F, false);

		bone5 = new ModelRenderer(this);
		bone5.setRotationPoint(3.0F, 1.0F, -3.0F);
		body.addChild(bone5);
		setRotationAngle(bone5, -0.8727F, 0.0F, -0.8727F);
		bone5.setTextureOffset(0, 37).addBox(-1.8909F, 0.5515F, -0.5345F, 1.0F, 3.0F, 7.0F, 0.0F, true);

		fintail = new ModelRenderer(this);
		fintail.setRotationPoint(-0.5F, -3.75F, 1.75F);
		body.addChild(fintail);
		setRotationAngle(fintail, -0.4363F, 0.0F, 0.0F);
		fintail.setTextureOffset(39, 13).addBox(-0.5F, -3.0F, -2.0F, 1.0F, 6.0F, 3.0F, 0.0F, false);
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
		 * if (((ThresherEntity)entityIn).isAttacking()) { this.lowerjaw.rotateAngleX =
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
		int i = entityIn.getAttackTimer();
		float j = entityIn.attackTime;
		LogManager.getLogger().info("test " + jaw.rotateAngleX);
		if (i > (j/2)) {
			this.jaw.rotateAngleX =-0.0873F * (i - (j/2)) / (j/2) + 0.9F * (j - i) / (j/2);
		} else if (i > 0) {
			this.jaw.rotateAngleX = (0.9F * i) / (j/2) + -0.0873F * ((j/2) - i) / (j/2);
		}
		// this.ironGolemLeftArm.rotateAngleX = -2.0F + 1.5F *
		// this.triangleWave((float)i - partialTick, 10.0F);
		else {
			this.jaw.rotateAngleX = -0.0873F + 0.2F * this.triangleWave(limbSwing, 70.0F);
		}
	}

	public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch) {
		this.body.rotateAngleX = headPitch * ((float) Math.PI / 180F);
		this.body.rotateAngleY = netHeadYaw * ((float) Math.PI / 180F);

		if (entityIn instanceof ThresherEntity) {
			ThresherEntity ThresherEntity = (ThresherEntity) entityIn;
			int i = ThresherEntity.getAttackTimer();
			if (ThresherEntity.getMotion().x != 0.0D || ThresherEntity.getMotion().z != 0.0D) {
				this.body.rotateAngleY += -0.05F + -0.05F * MathHelper.cos(ageInTicks * 0.3F);
			//	this.tail.rotateAngleY = -0.2F * MathHelper.cos(ageInTicks * 0.3F);
				this.tail2.rotateAngleY = -0.2F * MathHelper.cos(ageInTicks * 0.4F);
				
				this.head.rotateAngleY = -0.1F * MathHelper.cos(ageInTicks * 0.4F);
			
			}
			else {
				this.body.rotateAngleY += -0.02F + -0.02F * MathHelper.cos(ageInTicks * 0.1F);
			//	this.tail.rotateAngleY = -0.1F * MathHelper.cos(ageInTicks * 0.1F);
				this.tail2.rotateAngleY = -0.1F * MathHelper.cos(ageInTicks * 0.1F);
				
				this.head.rotateAngleY = -0.05F * MathHelper.cos(ageInTicks * 0.1F);
			}

		}

	}

	private float triangleWave(float p_78172_1_, float p_78172_2_) {
		return (Math.abs(p_78172_1_ % p_78172_2_ - p_78172_2_ * 0.5F) - p_78172_2_ * 0.25F) / (p_78172_2_ * 0.25F);
	}

}
