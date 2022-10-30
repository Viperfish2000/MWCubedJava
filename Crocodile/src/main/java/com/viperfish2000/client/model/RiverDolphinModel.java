package com.viperfish2000.client.model;

import com.google.common.collect.ImmutableList;

import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

// Made with Blockbench 3.5.4
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports


public class RiverDolphinModel<T extends Entity> extends SegmentedModel<T> {
	private final ModelRenderer body;
	private final ModelRenderer head;
	private final ModelRenderer nose;
	private final ModelRenderer tail;
	private final ModelRenderer tail_fin;
	private final ModelRenderer back_fin;
	private final ModelRenderer left_fin;
	private final ModelRenderer right_fin;

	public RiverDolphinModel() {
		textureWidth = 64;
		textureHeight = 64;

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 24.0F, -3.0F);
		body.setTextureOffset(22, 0).addBox(-4.0F, -7.0F, 0.0F, 8.0F, 7.0F, 13.0F, 0.0F, false);

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, -4.0F, 0.0F);
		body.addChild(head);
		head.setTextureOffset(0, 1).addBox(-3.0F, -3.0F, -4.0F, 6.0F, 6.0F, 4.0F, 0.0F, false);

		nose = new ModelRenderer(this);
		nose.setRotationPoint(0.0F, 2.5F, -9.0F);
		head.addChild(nose);
		nose.setTextureOffset(0, 49).addBox(-1.0F, -2.25F, -2.0F, 2.0F, 2.0F, 7.0F, 0.0F, false);

		tail = new ModelRenderer(this);
		tail.setRotationPoint(0.0F, -2.5F, 14.0F);
		body.addChild(tail);
		tail.setTextureOffset(0, 19).addBox(-2.0F, -3.5F, -1.0F, 4.0F, 5.0F, 11.0F, 0.0F, false);

		tail_fin = new ModelRenderer(this);
		tail_fin.setRotationPoint(0.0F, 0.0F, 9.0F);
		tail.addChild(tail_fin);
		tail_fin.setTextureOffset(19, 20).addBox(-5.0F, -1.5F, -1.0F, 10.0F, 1.0F, 6.0F, 0.0F, false);

		back_fin = new ModelRenderer(this);
		back_fin.setRotationPoint(0.0F, -6.0F, 10.25F);
		body.addChild(back_fin);
		setRotationAngle(back_fin, 0.3055F, 0.0F, 0.0F);
		back_fin.setTextureOffset(0, 35).addBox(-1.0F, -0.7519F, -2.0946F, 2.0F, 5.0F, 7.0F, 0.0F, false);

		left_fin = new ModelRenderer(this);
		left_fin.setRotationPoint(3.0F, -2.0F, 5.0F);
		body.addChild(left_fin);
		setRotationAngle(left_fin, 0.9599F, 0.0F, 2.2166F);
		left_fin.setTextureOffset(46, 27).addBox(-0.2924F, -4.5485F, -0.7167F, 1.0F, 5.0F, 8.0F, 0.0F, false);

		right_fin = new ModelRenderer(this);
		right_fin.setRotationPoint(-4.0F, -2.0F, 5.0F);
		body.addChild(right_fin);
		setRotationAngle(right_fin, 0.9599F, 0.0F, -2.3038F);
		right_fin.setTextureOffset(46, 27).addBox(-1.0F, -4.0F, -1.5F, 1.0F, 5.0F, 8.0F, 0.0F, true);
	
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
			this.head.rotateAngleX = headPitch * ((float) Math.PI / 180F);
			this.head.rotateAngleY = netHeadYaw * ((float) Math.PI / 180F);
	      if (Entity.horizontalMag(entityIn.getMotion()) > 1.0E-7D) {
	         this.body.rotateAngleX += -0.05F + -0.05F * MathHelper.cos(ageInTicks * 0.3F);
	         this.tail.rotateAngleX = -0.1F * MathHelper.cos(ageInTicks * 0.3F);
	         this.tail_fin.rotateAngleX = -0.2F * MathHelper.cos(ageInTicks * 0.3F);
	      }

	   }
}