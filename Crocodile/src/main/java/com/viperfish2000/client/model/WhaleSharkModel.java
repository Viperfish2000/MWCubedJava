package com.viperfish2000.client.model;

import org.apache.logging.log4j.LogManager;

import com.google.common.collect.ImmutableList;
import com.viperfish2000.entity.ReefSharkEntity;
import com.viperfish2000.entity.WhaleSharkEntity;

import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

/**
 * Peeper.tcn - TechneToTabulaImporter Created using Tabula 4.1.1
 */
public class WhaleSharkModel<T extends WhaleSharkEntity> extends SegmentedModel<T> {
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
	private final ModelRenderer fintail;

	public WhaleSharkModel() {
		textureWidth = 128;
		textureHeight = 128;

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 21.0F, -1.0F);
		body.setTextureOffset(0, 0).addBox(-4.5F, -5.0F, -9.0F, 8.0F, 8.0F, 18.0F, 0.0F, false);

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, -1.0F, -10.0F);
		body.addChild(head);
		

		topjaw = new ModelRenderer(this);
		topjaw.setRotationPoint(0.0F, -3.5F, -2.5F);
		head.addChild(topjaw);
		setRotationAngle(topjaw, 0.1745F, 0.0F, 0.0F);
		topjaw.setTextureOffset(34, 0).addBox(-6.5F, -0.2727F, -8.512F, 12.0F, 2.0F, 12.0F, 0.0F, false);

		bone4 = new ModelRenderer(this);
		bone4.setRotationPoint(0.0F, 6.1224F, -2.1401F);
		topjaw.addChild(bone4);
		setRotationAngle(bone4, -0.0873F, 0.0F, 0.0F);
		bone4.setTextureOffset(28, 28).addBox(-7.0F, -5.0343F, -6.8098F, 13.0F, 2.0F, 12.0F, 0.0F, false);

		jaw = new ModelRenderer(this);
		jaw.setRotationPoint(-0.5F, 0.75F, -3.75F);
		head.addChild(jaw);
		setRotationAngle(jaw, -0.2618F, 0.0F, 0.0F);
		jaw.setTextureOffset(33, 42).addBox(-5.5F, -1.7943F, -5.7759F, 11.0F, 4.0F, 11.0F, 0.0F, false);

		tail = new ModelRenderer(this);
		tail.setRotationPoint(-0.75F, -1.0F, 7.5F);
		body.addChild(tail);
		tail.setTextureOffset(0, 26).addBox(-2.75F, -3.25F, 0.5F, 6.0F, 5.0F, 16.0F, 0.0F, false);

		bone6 = new ModelRenderer(this);
		bone6.setRotationPoint(0.25F, -1.0F, 13.5F);
		tail.addChild(bone6);
		setRotationAngle(bone6, -0.6109F, 0.0F, 0.0F);
		bone6.setTextureOffset(28, 28).addBox(-0.5F, -3.172F, -5.2119F, 1.0F, 5.0F, 5.0F, 0.0F, false);

		tail2 = new ModelRenderer(this);
		tail2.setRotationPoint(0.25F, -1.0F, 15.5F);
		tail.addChild(tail2);
		tail2.setTextureOffset(43, 17).addBox(-1.5F, -1.5F, -2.0F, 3.0F, 2.0F, 9.0F, 0.0F, false);

		bone2 = new ModelRenderer(this);
		bone2.setRotationPoint(0.5F, -13.0F, -14.0F);
		tail2.addChild(bone2);
		setRotationAngle(bone2, -0.8727F, 0.0F, 0.0F);
		bone2.setTextureOffset(0, 64).addBox(-0.75F, -10.0F, 22.0F, 1.0F, 4.0F, 9.0F, 0.0F, false);

		bone = new ModelRenderer(this);
		bone.setRotationPoint(0.5F, 17.0F, -9.0F);
		tail2.addChild(bone);
		setRotationAngle(bone, 0.9599F, 0.0F, 0.0F);
		bone.setTextureOffset(0, 47).addBox(-1.1434F, 1.3111F, 22.6205F, 2.0F, 4.0F, 13.0F, 0.0F, false);

		antfin = new ModelRenderer(this);
		antfin.setRotationPoint(0.75F, 8.25F, -4.25F);
		tail.addChild(antfin);
		setRotationAngle(antfin, -0.4363F, 0.0F, 0.0F);
		antfin.setTextureOffset(0, 26).addBox(1.25F, -10.3102F, -0.3248F, 1.0F, 2.0F, 6.0F, 0.0F, false);

		antfin2 = new ModelRenderer(this);
		antfin2.setRotationPoint(-2.25F, 8.25F, -4.25F);
		tail.addChild(antfin2);
		setRotationAngle(antfin2, -0.4363F, 0.0F, 0.0F);
		antfin2.setTextureOffset(0, 34).addBox(-0.25F, -10.3102F, 0.6752F, 1.0F, 2.0F, 5.0F, 0.0F, false);

		antfin3 = new ModelRenderer(this);
		antfin3.setRotationPoint(-0.75F, 6.75F, 1.75F);
		tail.addChild(antfin3);
		setRotationAngle(antfin3, -0.4363F, 0.0F, 0.0F);
		antfin3.setTextureOffset(8, 0).addBox(0.5F, -11.456F, 8.8646F, 1.0F, 2.0F, 4.0F, 0.0F, false);

		bone3 = new ModelRenderer(this);
		bone3.setRotationPoint(-4.0F, -1.0F, 7.0F);
		body.addChild(bone3);
		setRotationAngle(bone3, -0.8727F, 0.0F, 0.8727F);
		bone3.setTextureOffset(43, 57).addBox(1.1749F, 10.0586F, -8.601F, 1.0F, 5.0F, 11.0F, 0.0F, false);

		bone5 = new ModelRenderer(this);
		bone5.setRotationPoint(3.0F, -1.0F, 7.0F);
		body.addChild(bone5);
		setRotationAngle(bone5, -0.8727F, 0.0F, -0.8727F);
		bone5.setTextureOffset(43, 57).addBox(-2.1749F, 10.0586F, -8.601F, 1.0F, 5.0F, 11.0F, 0.0F, true);

		fintail = new ModelRenderer(this);
		fintail.setRotationPoint(0.0F, 5.0F, 0.75F);
		body.addChild(fintail);
		setRotationAngle(fintail, -0.6109F, 0.0F, 0.0F);
		fintail.setTextureOffset(0, 0).addBox(-1.0F, -15.7057F, -4.2766F, 1.0F, 7.0F, 6.0F, 0.0F, false);
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
		 * if (((ReefSharkEntity)entityIn).isAttacking()) { this.lowerjaw.rotateAngleX =
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
		//	this.jaw.rotateAngleX =-0.1745F * (i - (j/2)) / (j/2) + 0.9F * (j - i) / (j/2);
		} else if (i > 0) {
	//	this.jaw.rotateAngleX = (0.9F * i) / (j/2) + -0.1745F * ((j/2) - i) / (j/2);
		}
		// this.ironGolemLeftArm.rotateAngleX = -2.0F + 1.5F *
		// this.triangleWave((float)i - partialTick, 10.0F);
		else {
		//	this.jaw.rotateAngleX = -0.1745F + 0.2F * this.triangleWave(limbSwing, 70.0F);
		}
	}

	public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch) {
		this.body.rotateAngleX = headPitch * ((float) Math.PI / 180F);
		this.body.rotateAngleY = netHeadYaw * ((float) Math.PI / 180F);

		if (entityIn instanceof WhaleSharkEntity) {
			WhaleSharkEntity ReefSharkEntity = (WhaleSharkEntity) entityIn;
			int i = ReefSharkEntity.getAttackTimer();
			if (ReefSharkEntity.getMotion().x != 0.0D || ReefSharkEntity.getMotion().z != 0.0D) {
				this.body.rotateAngleY += -0.05F + -0.05F * MathHelper.cos(ageInTicks * 0.1F);
				this.tail.rotateAngleY = -0.2F * MathHelper.cos(ageInTicks * 0.1F);
				this.tail2.rotateAngleY = -0.2F * MathHelper.cos(ageInTicks * 0.1F);
				
				this.head.rotateAngleY = -0.1F * MathHelper.cos(ageInTicks * 0.1F);
			
			}
			else {
				this.body.rotateAngleY += -0.02F + -0.02F * MathHelper.cos(ageInTicks * 0.05F);
				this.tail.rotateAngleY = -0.2F * MathHelper.cos(ageInTicks * 0.05F);
				this.tail2.rotateAngleY = -0.2F * MathHelper.cos(ageInTicks * 0.05F);
				
				this.head.rotateAngleY = -0.1F * MathHelper.cos(ageInTicks * 0.05F);
			}

		}

	}

	private float triangleWave(float p_78172_1_, float p_78172_2_) {
		return (Math.abs(p_78172_1_ % p_78172_2_ - p_78172_2_ * 0.5F) - p_78172_2_ * 0.25F) / (p_78172_2_ * 0.25F);
	}

}
