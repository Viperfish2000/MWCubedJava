package com.viperfish2000.client.model;

import com.google.common.collect.ImmutableList;
import com.viperfish2000.entity.RedPandaEntity;

import net.minecraft.client.renderer.entity.model.AgeableModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RedPandaModel<T extends RedPandaEntity> extends AgeableModel<T> {
	public final ModelRenderer head;
	// private final ModelRenderer rightEar;
	// private final ModelRenderer leftEar;
	// private final ModelRenderer snout;
	private final ModelRenderer body;
	private final ModelRenderer legBackRight;
	private final ModelRenderer legBackLeft;
	private final ModelRenderer legFrontRight;
	private final ModelRenderer legFrontLeft;
	private final ModelRenderer tail;
	private float field_217125_n;

	public RedPandaModel() {
		super(true, 8.0F, 3.35F);
		textureWidth = 64;
		textureHeight = 64;

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 16.0F, 0.0F);
		// setRotationAngle(body, 1.5708F, 0.0F, 0.0F);
		body.setTextureOffset(0, 0).addBox(-4.0F, -3.0F, -4.0F, 8.0F, 13.0F, 6.0F, 0.0F, false);

		head = new ModelRenderer(this);
		head.setRotationPoint(-0.25F, 15.25F, -3.0F);
		head.setTextureOffset(0, 19).addBox(-2.75F, -1.0F, -6.0F, 6.0F, 5.0F, 6.0F, 0.0F, false);
		head.setTextureOffset(12, 34).addBox(-4.0F, -2.0F, -5.0F, 3.0F, 3.0F, 1.0F, 0.0F, true);
		head.setTextureOffset(12, 34).addBox(1.5F, -2.0F, -5.0F, 3.0F, 3.0F, 1.0F, 0.0F, false);
		head.setTextureOffset(12, 30).addBox(-1.25F, 1.75F, -7.5F, 3.0F, 2.0F, 2.0F, 0.0F, false);

		legBackRight = new ModelRenderer(this);
		legBackRight.setRotationPoint(-3.0F, 19.0F, 7.0F);
		legBackRight.setTextureOffset(25, 16).addBox(0F, 0.0F, -1.0F, 3.0F, 5.0F, 3.0F, 0.0F, false);

		legBackLeft = new ModelRenderer(this);
		legBackLeft.setRotationPoint(2.0F, 19.0F, 7.0F);
		legBackLeft.setTextureOffset(25, 16).addBox(-1F, 0.0F, -1.0F, 3.0F, 5.0F, 3.0F, 0.0F, false);

		legFrontRight = new ModelRenderer(this);
		legFrontRight.setRotationPoint(-3.0F, 19.0F, -1.0F);
		legFrontRight.setTextureOffset(25, 16).addBox(-1F, 0.0F, -1.0F, 3.0F, 5.0F, 3.0F, 0.0F, true);

		legFrontLeft = new ModelRenderer(this);
		legFrontLeft.setRotationPoint(2.0F, 19.0F, -1.0F);
		legFrontLeft.setTextureOffset(25, 16).addBox(-1F, 0.0F, -1.0F, 3.0F, 5.0F, 3.0F, 0.0F, false);

		tail = new ModelRenderer(this);
		tail.setRotationPoint(0.0F, 15.25F, 8.0F);
		// setRotationAngle(tail, 1.5708F, 0.0F, 0.0F);
		tail.setTextureOffset(24, 24).addBox(-1.0F, 1.0F, -2.25F, 3.0F, 13.0F, 3.0F, 0.0F, true);
	}

	public void setLivingAnimations(T entityIn, float limbSwing, float limbSwingAmount, float partialTick) {
		tail.setRotationPoint(0.0F, 15.25F, 8.0F);
		setRotationAngle(tail, 1.5708F - 0.05235988F, 0.0F, 0.0F);
		
		this.legBackRight.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.legBackLeft.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
		this.legFrontRight.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F
				* limbSwingAmount;
		this.legFrontLeft.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		
		head.setRotationPoint(-0.25F, 15.25F, -3.0F);
		this.head.rotateAngleY = 0.0F;
		this.head.rotateAngleZ = entityIn.func_213475_v(partialTick);
		
		this.legBackRight.showModel = true;
		this.legBackLeft.showModel = true;
		this.legFrontRight.showModel = true;
		this.legFrontLeft.showModel = true;
		
		body.setRotationPoint(0.0F, 16.0F, 0.0F);
		this.body.rotateAngleZ = 0.0F;
		this.body.rotateAngleX = ((float) Math.PI / 2F);
		
		
		if (entityIn.isCrouching()) {
			this.body.rotateAngleX = 1.6755161F;
			float f = entityIn.func_213503_w(partialTick);
			this.body.setRotationPoint(0.0F, 16.0F + entityIn.func_213503_w(partialTick), -6.0F);
			this.head.setRotationPoint(-1.0F, 16.5F + f, -3.0F);
			this.head.rotateAngleY = 0.0F;
		} else if (entityIn.isSleeping()) {
			
			body.setRotationPoint(0.0F, 23.0F, 0.0F);
			setRotationAngle(body, 1.4835F, 0.0F, -1.6581F);
			tail.setRotationPoint(4.0F, 21.75F, 11.0F);
			this.tail.rotateAngleX = 1.5708F;
			this.tail.rotateAngleY = 2.7925F;
			if (this.isChild) {
				this.tail.rotateAngleX = -2.1816616F;
				head.setRotationPoint(-1.25F, 18.5F, -3.25F);
			}

			this.head.setRotationPoint(1.0F, 19.49F, -3.0F);
			setRotationAngle(head, -0.1745F, -1.1345F, 0.4363F);
			
			this.legBackRight.showModel = false;
			this.legBackLeft.showModel = false;
			this.legFrontRight.showModel = false;
			this.legFrontLeft.showModel = false;
			
		} /**else if (entityIn.isSitting()) {
			this.body.rotateAngleX = ((float) Math.PI / 6F);
			this.body.setRotationPoint(0.0F, 9.0F, -3.0F);
			this.tail.rotateAngleX = ((float) Math.PI / 4F);
			this.tail.setRotationPoint(-4.0F, 15.0F, -2.0F);

			this.head.setRotationPoint(-1.0F, 10.0F, -0.25F);
			this.head.rotateAngleX = 0.0F;
			this.head.rotateAngleY = 0.0F;
			if (this.isChild) {
				this.head.setRotationPoint(-1.0F, 13.0F, -3.75F);
			}

			this.legBackRight.rotateAngleX = -1.3089969F;
		//	this.legBackRight.setRotationPoint(-5.0F, 21.5F, 6.75F);
			this.legBackLeft.rotateAngleX = -1.3089969F;
		//	this.legBackLeft.setRotationPoint(-1.0F, 21.5F, 6.75F);
			this.legFrontRight.rotateAngleX = -0.2617994F;
			this.legFrontLeft.rotateAngleX = -0.2617994F;
		}
	**/
	}

	protected Iterable<ModelRenderer> getHeadParts() {
		return ImmutableList.of(this.head);
	}

	protected Iterable<ModelRenderer> getBodyParts() {
		return ImmutableList.of(this.body, this.legBackRight, this.legBackLeft, this.legFrontRight, this.legFrontLeft,
				this.tail);
	}

	/**
	 * Sets this entity's model rotation angles
	 */
	public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch) {
		if (!entityIn.isSleeping() && !entityIn.isStuck() && !entityIn.isCrouching()) {
			this.head.rotateAngleX = headPitch * ((float) Math.PI / 180F);
			this.head.rotateAngleY = netHeadYaw * ((float) Math.PI / 180F);
		}

		if (entityIn.isSleeping()) {
			this.head.rotateAngleX = -0.26179938F;
			this.head.rotateAngleY = -1.6581F;
			this.head.rotateAngleZ = MathHelper.cos(ageInTicks * 0.027F) / 22.0F;
			
			
			//setRotationAngle(head, -0.1745F, -1.6581F, 0.4363F);
		}

		if (entityIn.isCrouching()) {
			float f = MathHelper.cos(ageInTicks) * 0.01F;
			this.body.rotateAngleY = f;
			this.legBackRight.rotateAngleZ = f;
			this.legBackLeft.rotateAngleZ = f;
			this.legFrontRight.rotateAngleZ = f / 2.0F;
			this.legFrontLeft.rotateAngleZ = f / 2.0F;
		}

		if (entityIn.isStuck()) {
			float f1 = 0.1F;
			this.field_217125_n += 0.67F;
			this.legBackRight.rotateAngleX = MathHelper.cos(this.field_217125_n * 0.4662F) * 0.1F;
			this.legBackLeft.rotateAngleX = MathHelper.cos(this.field_217125_n * 0.4662F + (float) Math.PI) * 0.1F;
			this.legFrontRight.rotateAngleX = MathHelper.cos(this.field_217125_n * 0.4662F + (float) Math.PI) * 0.1F;
			this.legFrontLeft.rotateAngleX = MathHelper.cos(this.field_217125_n * 0.4662F) * 0.1F;
		}
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}