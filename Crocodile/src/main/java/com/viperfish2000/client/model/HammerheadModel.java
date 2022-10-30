package com.viperfish2000.client.model;

import org.apache.logging.log4j.LogManager;

import com.google.common.collect.ImmutableList;
import com.viperfish2000.entity.HammerheadEntity;
import com.viperfish2000.entity.HammerheadEntity;

import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

/**
 * Peeper.tcn - TechneToTabulaImporter Created using Tabula 4.1.1
 */
public class HammerheadModel<T extends HammerheadEntity> extends SegmentedModel<T> {
	private final ModelRenderer body;
	private final ModelRenderer head;
	private final ModelRenderer topjaw;
	private final ModelRenderer bone7;
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
	private final ModelRenderer fintail;

	public HammerheadModel() {
		textureWidth = 64;
		textureHeight = 64;

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 29.0F, 0.0F);
		body.setTextureOffset(0, 0).addBox(-4.0F, -12.0F, -7.0F, 7.0F, 7.0F, 13.0F, 0.0F, false);
		body.setTextureOffset(0, 0).addBox(-1.0F, -1.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, -7.75F, -6.0F);
		body.addChild(head);
		

		topjaw = new ModelRenderer(this);
		topjaw.setRotationPoint(0.1736F, -2.75F, -1.5152F);
		head.addChild(topjaw);
		

		bone7 = new ModelRenderer(this);
		bone7.setRotationPoint(-0.75F, 1.2803F, -2.8283F);
		topjaw.addChild(bone7);
		setRotationAngle(bone7, 0.1745F, 0.0F, 0.0F);
		bone7.setTextureOffset(20, 20).addBox(-3.0F, -1.0F, -5.0F, 6.0F, 2.0F, 10.0F, 0.0F, false);

		bone4 = new ModelRenderer(this);
		bone4.setRotationPoint(0.0F, 6.0353F, -2.1363F);
		topjaw.addChild(bone4);
		bone4.setTextureOffset(5, 44).addBox(-4.0F, -4.7853F, -5.788F, 6.0F, 3.0F, 9.0F, 0.0F, false);
		bone4.setTextureOffset(0, 59).addBox(-8.1736F, -3.5F, -8.5F, 15.0F, 1.0F, 4.0F, 0.0F, false);

		jaw = new ModelRenderer(this);
		jaw.setRotationPoint(-0.5F, 1.5F, -5.0F);
		head.addChild(jaw);
		setRotationAngle(jaw, 0.0873F, 0.0F, 0.0F);
		jaw.setTextureOffset(2, 32).addBox(-1.75F, -1.2605F, -3.9668F, 4.0F, 1.0F, 4.0F, 0.0F, false);

		tail = new ModelRenderer(this);
		tail.setRotationPoint(0.0F, -8.0F, 3.0F);
		body.addChild(tail);
		setRotationAngle(tail, 0.0F, 0.0F, 0.0873F);
		tail.setTextureOffset(27, 0).addBox(-3.0F, -3.25F, 3.0F, 5.0F, 5.0F, 8.0F, 0.0F, false);

		bone6 = new ModelRenderer(this);
		bone6.setRotationPoint(-0.5F, -1.5F, 8.0F);
		tail.addChild(bone6);
		setRotationAngle(bone6, -0.6109F, 0.0F, 0.0F);
		bone6.setTextureOffset(40, 13).addBox(-0.5F, -4.5075F, 0.867F, 1.0F, 4.0F, 3.0F, 0.0F, false);

		tail2 = new ModelRenderer(this);
		tail2.setRotationPoint(0.0F, 0.0F, 10.0F);
		tail.addChild(tail2);
		tail2.setTextureOffset(42, 21).addBox(-2.0F, -2.5F, 1.0F, 3.0F, 3.0F, 6.0F, 0.0F, false);

		bone2 = new ModelRenderer(this);
		bone2.setRotationPoint(-0.5F, 0.5F, 8.5F);
		tail2.addChild(bone2);
		setRotationAngle(bone2, -1.0472F, 0.0F, 0.0F);
		bone2.setTextureOffset(0, 0).addBox(-0.5F, -1.5F, -2.5F, 1.0F, 3.0F, 5.0F, 0.0F, false);

		bone = new ModelRenderer(this);
		bone.setRotationPoint(0.0F, -7.0F, 3.0F);
		tail2.addChild(bone);
		setRotationAngle(bone, 0.5236F, 0.0F, 0.0F);
		bone.setTextureOffset(12, 32).addBox(-1.1434F, 5.0493F, 0.4364F, 1.0F, 2.0F, 10.0F, 0.0F, false);

		antfin = new ModelRenderer(this);
		antfin.setRotationPoint(0.0F, 8.25F, -9.75F);
		tail.addChild(antfin);
		setRotationAngle(antfin, -0.4363F, 0.0F, 0.0F);
		antfin.setTextureOffset(40, 32).addBox(0.5F, -12.846F, 7.1131F, 1.0F, 2.0F, 4.0F, 0.0F, false);

		antfin2 = new ModelRenderer(this);
		antfin2.setRotationPoint(-3.0F, 8.25F, -9.75F);
		tail.addChild(antfin2);
		setRotationAngle(antfin2, -0.4363F, 0.0F, 0.0F);
		antfin2.setTextureOffset(40, 32).addBox(0.5F, -12.846F, 7.1131F, 1.0F, 2.0F, 4.0F, 0.0F, true);

		antfin3 = new ModelRenderer(this);
		antfin3.setRotationPoint(-1.5F, 6.75F, -3.75F);
		tail.addChild(antfin3);
		setRotationAngle(antfin3, -0.4363F, 0.0F, 0.0F);
		antfin3.setTextureOffset(40, 38).addBox(0.5F, -13.0115F, 9.2426F, 1.0F, 2.0F, 4.0F, 0.0F, false);

		bone3 = new ModelRenderer(this);
		bone3.setRotationPoint(-4.0F, -8.0F, -3.0F);
		body.addChild(bone3);
		setRotationAngle(bone3, -0.8727F, 0.0F, 0.8727F);
		bone3.setTextureOffset(0, 38).addBox(-0.234F, 0.4132F, 0.4924F, 1.0F, 3.0F, 6.0F, 0.0F, false);

		bone5 = new ModelRenderer(this);
		bone5.setRotationPoint(3.0F, -8.0F, -3.0F);
		body.addChild(bone5);
		setRotationAngle(bone5, -0.8727F, 0.0F, -0.8727F);
		bone5.setTextureOffset(0, 38).addBox(-0.766F, 0.4132F, 0.4924F, 1.0F, 3.0F, 6.0F, 0.0F, true);

		fintail = new ModelRenderer(this);
		fintail.setRotationPoint(0.0F, -2.0F, -8.25F);
		body.addChild(fintail);
		setRotationAngle(fintail, -0.5236F, 0.0F, 0.0F);
		fintail.setTextureOffset(54, 0).addBox(-1.0F, -19.8528F, -1.6383F, 1.0F, 9.0F, 4.0F, 0.0F, false);
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
		 * if (((HammerheadEntity)entityIn).isAttacking()) { this.lowerjaw.rotateAngleX =
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

		if (entityIn instanceof HammerheadEntity) {
			HammerheadEntity HammerheadEntity = (HammerheadEntity) entityIn;
			int i = HammerheadEntity.getAttackTimer();
			if (HammerheadEntity.getMotion().x != 0.0D || HammerheadEntity.getMotion().z != 0.0D) {
				this.body.rotateAngleY += -0.05F + -0.05F * MathHelper.cos(ageInTicks * 0.2F);
				this.tail.rotateAngleY = -0.2F * MathHelper.cos(ageInTicks * 0.2F);
				this.tail2.rotateAngleY = -0.2F * MathHelper.cos(ageInTicks * 0.2F);
				
				this.head.rotateAngleY = -0.1F * MathHelper.cos(ageInTicks * 0.2F);
			
			}
			else {
				this.body.rotateAngleY += -0.02F + -0.02F * MathHelper.cos(ageInTicks * 0.05F);
				this.tail.rotateAngleY = -0.1F * MathHelper.cos(ageInTicks * 0.05F);
				this.tail2.rotateAngleY = -0.1F * MathHelper.cos(ageInTicks * 0.05F);
				
				this.head.rotateAngleY = -0.05F * MathHelper.cos(ageInTicks * 0.05F);
			}

		}

	}

	private float triangleWave(float p_78172_1_, float p_78172_2_) {
		return (Math.abs(p_78172_1_ % p_78172_2_ - p_78172_2_ * 0.5F) - p_78172_2_ * 0.25F) / (p_78172_2_ * 0.25F);
	}

}
