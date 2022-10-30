package com.viperfish2000.client.model;

import org.apache.logging.log4j.LogManager;

import com.google.common.collect.ImmutableList;
import com.viperfish2000.entity.MegalodonEntity;

import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

/**
 * Peeper.tcn - TechneToTabulaImporter Created using Tabula 4.1.1
 */
public class MegalodonModel<T extends MegalodonEntity> extends SegmentedModel<T> {
	private final ModelRenderer body;
	private final ModelRenderer head;
	private final ModelRenderer topjaw;
	private final ModelRenderer bone4;
	private final ModelRenderer jaw;
	private final ModelRenderer tail;
	private final ModelRenderer bone6;
	private final ModelRenderer tail2;
	private final ModelRenderer antfin3;
	private final ModelRenderer bone2;
	private final ModelRenderer bone8;
	private final ModelRenderer bone9;
	private final ModelRenderer bone;
	private final ModelRenderer bone7;
	private final ModelRenderer antfin;
	private final ModelRenderer antfin2;
	private final ModelRenderer bone3;
	private final ModelRenderer bone5;
	private final ModelRenderer fintail;

	public MegalodonModel() {
		textureWidth = 64;
		textureHeight = 64;

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 24.0F, 0.0F);
		body.setTextureOffset(0, 0).addBox(-4.0F, -13.0F, -6.0F, 7.0F, 8.0F, 12.0F, 0.0F, false);

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, -8.5F, -7.0F);
		body.addChild(head);
		setRotationAngle(head, 0.1745F, 0.0F, 0.0F);
		

		topjaw = new ModelRenderer(this);
		topjaw.setRotationPoint(0.0F, -3.5F, -2.5F);
		head.addChild(topjaw);
		setRotationAngle(topjaw, -0.1745F, 0.0F, 0.0F);
		topjaw.setTextureOffset(0, 32).addBox(-3.5F, -1.0F, 0.5F, 6.0F, 7.0F, 4.0F, 0.0F, false);
		topjaw.setTextureOffset(23, 23).addBox(-3.5F, 0.0341F, -9.2412F, 6.0F, 2.0F, 9.0F, 0.0F, false);
		topjaw.setTextureOffset(0, 61).addBox(-3.5F, 0.0341F, -0.2412F, 6.0F, 2.0F, 1.0F, 0.0F, false);
		topjaw.setTextureOffset(0, 54).addBox(-3.5F, 2.0341F, -2.5F, 6.0F, 2.0F, 3.0F, 0.0F, false);

		bone4 = new ModelRenderer(this);
		bone4.setRotationPoint(0.0F, 6.0353F, -3.1363F);
		topjaw.addChild(bone4);
		setRotationAngle(bone4, -0.2618F, 0.0F, 0.0F);
		bone4.setTextureOffset(0, 20).addBox(-3.25F, -4.0429F, -6.8637F, 6.0F, 2.0F, 10.0F, 0.0F, false);
		bone4.setTextureOffset(0, 20).addBox(-3.75F, -4.0353F, -6.788F, 6.0F, 2.0F, 10.0F, 0.0F, true);
		bone4.setTextureOffset(0, 51).addBox(-3.25F, -2.8026F, -1.7574F, 6.0F, 2.0F, 0.0F, 0.0F, false);

		jaw = new ModelRenderer(this);
		jaw.setRotationPoint(-0.5F, 0.75F, -3.0F);
		head.addChild(jaw);
		setRotationAngle(jaw, -0.0873F, 0.0F, 0.0F);
		jaw.setTextureOffset(32, 14).addBox(-2.5F, 0.5F, -5.0F, 5.0F, 1.0F, 6.0F, 0.0F, false);
		jaw.setTextureOffset(12, 46).addBox(2.4F, -0.0635F, -5.7036F, 0.0F, 1.0F, 6.0F, 0.0F, false);
		jaw.setTextureOffset(12, 46).addBox(-2.4F, -0.0635F, -5.7036F, 0.0F, 1.0F, 6.0F, 0.0F, false);
		jaw.setTextureOffset(0, 53).addBox(-2.5F, -0.422F, -4.4916F, 5.0F, 1.0F, 0.0F, 0.0F, false);

		tail = new ModelRenderer(this);
		tail.setRotationPoint(0.0F, -8.0F, 4.0F);
		body.addChild(tail);
		tail.setTextureOffset(20, 34).addBox(-3.5F, -4.25F, 1.0F, 6.0F, 7.0F, 3.0F, 0.0F, false);
		tail.setTextureOffset(26, 0).addBox(-3.0F, -3.25F, 3.0F, 5.0F, 5.0F, 6.0F, 0.0F, false);

		bone6 = new ModelRenderer(this);
		bone6.setRotationPoint(-0.5F, -1.5F, 6.0F);
		tail.addChild(bone6);
		setRotationAngle(bone6, -0.6109F, 0.0F, 0.0F);
		bone6.setTextureOffset(32, 48).addBox(-0.5F, -3.5F, 0.0F, 1.0F, 5.0F, 2.0F, 0.0F, false);

		tail2 = new ModelRenderer(this);
		tail2.setRotationPoint(0.0F, 0.0F, 8.0F);
		tail.addChild(tail2);
		tail2.setTextureOffset(0, 43).addBox(-2.0F, -2.5F, 0.0F, 3.0F, 3.0F, 4.0F, 0.0F, false);
		tail2.setTextureOffset(0, 8).addBox(-1.5F, -1.75F, 4.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		antfin3 = new ModelRenderer(this);
		antfin3.setRotationPoint(-1.5F, 6.75F, -13.75F);
		tail2.addChild(antfin3);
		setRotationAngle(antfin3, -0.4363F, 0.0F, 0.0F);
		antfin3.setTextureOffset(14, 43).addBox(0.5F, -12.7743F, 8.0194F, 1.0F, 2.0F, 4.0F, 0.0F, false);

		bone2 = new ModelRenderer(this);
		bone2.setRotationPoint(0.0F, -14.0F, -17.0F);
		tail2.addChild(bone2);
		setRotationAngle(bone2, -0.8727F, 0.0F, 0.0F);
		bone2.setTextureOffset(42, 0).addBox(-1.0F, -10.9409F, 28.1623F, 1.0F, 2.0F, 3.0F, 0.0F, false);
		bone2.setTextureOffset(0, 20).addBox(-1.0F, -11.5321F, 24.2856F, 1.0F, 3.0F, 4.0F, 0.0F, false);

		bone8 = new ModelRenderer(this);
		bone8.setRotationPoint(0.0F, -7.0F, 28.0F);
		bone2.addChild(bone8);
		setRotationAngle(bone8, 0.4363F, 0.0F, 0.0F);
		

		bone9 = new ModelRenderer(this);
		bone9.setRotationPoint(0.0F, -9.2981F, 29.9284F);
		bone2.addChild(bone9);
		setRotationAngle(bone9, 0.6981F, 0.0F, 0.0F);
		

		bone = new ModelRenderer(this);
		bone.setRotationPoint(0.0F, 16.0F, -12.0F);
		tail2.addChild(bone);
		setRotationAngle(bone, 0.9599F, 0.0F, 0.0F);
		bone.setTextureOffset(44, 27).addBox(-0.8934F, 4.7686F, 31.3413F, 1.0F, 2.0F, 3.0F, 0.0F, false);
		bone.setTextureOffset(42, 5).addBox(-0.8934F, 4.7686F, 25.3413F, 1.0F, 3.0F, 6.0F, 0.0F, false);

		bone7 = new ModelRenderer(this);
		bone7.setRotationPoint(0.0F, 1.3187F, 29.3887F);
		bone.addChild(bone7);
		setRotationAngle(bone7, -0.1745F, 0.0F, 0.0F);
		

		antfin = new ModelRenderer(this);
		antfin.setRotationPoint(0.0F, 8.25F, -11.75F);
		tail.addChild(antfin);
		setRotationAngle(antfin, -0.4363F, 0.0F, 0.0F);
		antfin.setTextureOffset(22, 22).addBox(0.5F, -13.6607F, 10.0433F, 1.0F, 2.0F, 4.0F, 0.0F, false);

		antfin2 = new ModelRenderer(this);
		antfin2.setRotationPoint(-3.0F, 8.25F, -11.75F);
		tail.addChild(antfin2);
		setRotationAngle(antfin2, -0.4363F, 0.0F, 0.0F);
		antfin2.setTextureOffset(24, 44).addBox(0.5F, -13.6607F, 10.0433F, 1.0F, 2.0F, 4.0F, 0.0F, false);

		bone3 = new ModelRenderer(this);
		bone3.setRotationPoint(-3.0F, -8.0F, -3.0F);
		body.addChild(bone3);
		setRotationAngle(bone3, -0.8727F, 0.0F, 0.8727F);
		bone3.setTextureOffset(40, 34).addBox(0.4088F, -0.0792F, -0.0944F, 1.0F, 4.0F, 6.0F, 0.0F, true);
		bone3.setTextureOffset(44, 21).addBox(0.4088F, 0.9208F, 5.9056F, 1.0F, 3.0F, 3.0F, 0.0F, true);

		bone5 = new ModelRenderer(this);
		bone5.setRotationPoint(3.0F, -8.0F, -3.0F);
		body.addChild(bone5);
		setRotationAngle(bone5, -0.8727F, 0.0F, -0.8727F);
		bone5.setTextureOffset(44, 21).addBox(-2.0516F, 0.4284F, 5.3188F, 1.0F, 3.0F, 3.0F, 0.0F, false);
		bone5.setTextureOffset(40, 34).addBox(-2.0516F, -0.5716F, -0.6812F, 1.0F, 4.0F, 6.0F, 0.0F, false);

		fintail = new ModelRenderer(this);
		fintail.setRotationPoint(0.0F, -2.0F, -9.25F);
		body.addChild(fintail);
		setRotationAngle(fintail, -0.6109F, 0.0F, 0.0F);
		fintail.setTextureOffset(26, 0).addBox(-1.0F, -19.8192F, -0.5736F, 1.0F, 3.0F, 2.0F, 0.0F, false);
		fintail.setTextureOffset(38, 48).addBox(-1.0F, -17.8192F, -1.5736F, 1.0F, 6.0F, 1.0F, 0.0F, false);
		fintail.setTextureOffset(0, 0).addBox(-1.0F, -16.8192F, -0.5736F, 1.0F, 4.0F, 4.0F, 0.0F, false);
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
		 * if (((MegalodonEntity)entityIn).isAttacking()) { this.lowerjaw.rotateAngleX =
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
			this.jaw.rotateAngleX =-0.174533F * (i - (j/2)) / (j/2) + 0.9F * (j - i) / (j/2);
		} else if (i > 0) {
			this.jaw.rotateAngleX = (0.9F * i) / (j/2) + -0.174533F * ((j/2) - i) / (j/2);
		}
		// this.ironGolemLeftArm.rotateAngleX = -2.0F + 1.5F *
		// this.triangleWave((float)i - partialTick, 10.0F);
		else {
			this.jaw.rotateAngleX =-0.174533F + 0.2F * this.triangleWave(limbSwing, 70.0F);
		}
	}

	public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch) {
		this.body.rotateAngleX = headPitch * ((float) Math.PI / 180F);
		this.body.rotateAngleY = netHeadYaw * ((float) Math.PI / 180F);

		if (entityIn instanceof MegalodonEntity) {
			MegalodonEntity MegalodonEntity = (MegalodonEntity) entityIn;
			int i = MegalodonEntity.getAttackTimer();
			if (MegalodonEntity.getMotion().x != 0.0D || MegalodonEntity.getMotion().z != 0.0D) {
		//		this.body.rotateAngleY += -0.05F + -0.05F * MathHelper.cos(ageInTicks * 0.3F);
				this.tail.rotateAngleY = -0.2F * MathHelper.cos(ageInTicks * 0.3F);
				this.tail2.rotateAngleY = -0.2F * MathHelper.cos(ageInTicks * 0.3F);
				
				this.head.rotateAngleY = -0.1F * MathHelper.cos(ageInTicks * 0.3F);
			
			}
			else {
		//		this.body.rotateAngleY += -0.02F + -0.02F * MathHelper.cos(ageInTicks * 0.1F);
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
