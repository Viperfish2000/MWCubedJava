package com.viperfish2000.client.model;

import com.google.common.collect.ImmutableList;

import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

// Made with Blockbench 3.5.4
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports


public class NarwhalModel<T extends Entity> extends SegmentedModel<T> {
	private final ModelRenderer body;
	private final ModelRenderer head;
	private final ModelRenderer nose;
	private final ModelRenderer tail;
	private final ModelRenderer tail_fin;
	private final ModelRenderer left_fin;
	private final ModelRenderer right_fin;

	public NarwhalModel() {
		textureWidth = 128;
		textureHeight = 128;

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 24.0F, -3.0F);
		body.setTextureOffset(0, 24).addBox(-3.0F, -7.0F, -5.0F, 7.0F, 7.0F, 13.0F, 0.0F, false);
		body.setTextureOffset(26, 0).addBox(-2.5F, -6.0F, 8.0F, 6.0F, 6.0F, 9.0F, 0.0F, false);

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, 0.0F, 0.0F);
		body.addChild(head);
		head.setTextureOffset(32, 36).addBox(-3.0F, -7.0F, -13.0F, 7.0F, 7.0F, 8.0F, 0.0F, false);

		nose = new ModelRenderer(this);
		nose.setRotationPoint(0.0F, 0.0F, -17.0F);
		head.addChild(nose);
		nose.setTextureOffset(0, 51).addBox(0.0F, -2.0F, -18.0F, 1.0F, 1.0F, 22.0F, 0.0F, false);

		tail = new ModelRenderer(this);
		tail.setRotationPoint(0.5F, -2.5F, 16.0F);
		body.addChild(tail);
		tail.setTextureOffset(38, 15).addBox(-2.0F, -2.5F, 1.0F, 4.0F, 5.0F, 10.0F, 0.0F, false);

		tail_fin = new ModelRenderer(this);
		tail_fin.setRotationPoint(0.0F, 0.5F, 9.0F);
		tail.addChild(tail_fin);
		tail_fin.setTextureOffset(1, 45).addBox(-5.0F, -0.9499F, 0.9487F, 10.0F, 1.0F, 5.0F, 0.0F, false);

		left_fin = new ModelRenderer(this);
		left_fin.setRotationPoint(6.0F, -2.0F, 5.0F);
		body.addChild(left_fin);
		setRotationAngle(left_fin, 0.9599F, 0.0F, 1.8675F);
		left_fin.setTextureOffset(7, 7).addBox(1.25F, -7.8617F, -6.3528F, 1.0F, 3.0F, 5.0F, 0.0F, false);

		right_fin = new ModelRenderer(this);
		right_fin.setRotationPoint(-3.0F, -2.0F, 5.0F);
		body.addChild(right_fin);
		setRotationAngle(right_fin, 0.9599F, 0.0F, -1.8675F);
		right_fin.setTextureOffset(7, 7).addBox(-1.3408F, -8.9198F, -4.704F, 1.0F, 3.0F, 5.0F, 0.0F, true);
	}


	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
	  public Iterable<ModelRenderer> getParts() {
	      return ImmutableList.of(this.body);
	   }

	   /**
	    * Sets this entity's model rotation angles
	    */
	   public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	      this.body.rotateAngleX = headPitch * ((float)Math.PI / 180F);
	      this.body.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);
	      if (Entity.horizontalMag(entityIn.getMotion()) > 1.0E-7D) {
	         this.body.rotateAngleX += -0.05F + -0.05F * MathHelper.cos(ageInTicks * 0.3F);
	         this.tail.rotateAngleX = -0.1F * MathHelper.cos(ageInTicks * 0.3F);
	         this.tail_fin.rotateAngleX = -0.2F * MathHelper.cos(ageInTicks * 0.3F);
	      }

	   }
}