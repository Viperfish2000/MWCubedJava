package com.viperfish2000.client.model;

import com.google.common.collect.ImmutableList;

import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

// Made with Blockbench 3.5.4
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports


public class OrcaModel<T extends Entity> extends SegmentedModel<T> {
	private final ModelRenderer body;
	private final ModelRenderer head;
	private final ModelRenderer nose;
	private final ModelRenderer tail;
	private final ModelRenderer tail_fin;
	private final ModelRenderer left_fin;
	private final ModelRenderer right_fin;
	private final ModelRenderer back_fin;
	private final ModelRenderer bone;

	public OrcaModel() {
		textureWidth = 128;
		textureHeight = 128;

		textureWidth = 128;
		textureHeight = 128;

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 24.0F, -3.0F);
		body.setTextureOffset(0, 0).addBox(-6.0F, -9.0F, -9.0F, 12.0F, 10.0F, 26.0F, 0.0F, false);

		head = new ModelRenderer(this);
		head.setRotationPoint(-0.25F, 0.0F, -9.0F);
		body.addChild(head);
		head.setTextureOffset(50, 0).addBox(-4.75F, -9.0F, -10.0F, 10.0F, 8.0F, 10.0F, 0.0F, false);

		bone = new ModelRenderer(this);
		bone.setRotationPoint(0.25F, -1.5436F, -1.0019F);
		head.addChild(bone);
		setRotationAngle(bone, 0.0873F, 0.0F, 0.0F);
		bone.setTextureOffset(76, 50).addBox(-5.0F, 0.5F, -9.0F, 10.0F, 2.0F, 10.0F, 0.0F, false);

		nose = new ModelRenderer(this);
		nose.setRotationPoint(0.0F, 0.0F, -8.0F);
		head.addChild(nose);
		

		tail = new ModelRenderer(this);
		tail.setRotationPoint(0.0F, -2.5F, 17.25F);
		body.addChild(tail);
		tail.setTextureOffset(0, 38).addBox(-4.0F, -4.5F, -2.0F, 8.0F, 7.0F, 21.0F, 0.0F, false);

		tail_fin = new ModelRenderer(this);
		tail_fin.setRotationPoint(0.0F, -0.6755F, 15.7205F);
		tail.addChild(tail_fin);
		tail_fin.setTextureOffset(37, 38).addBox(-10.0F, -1.0624F, 1.4359F, 20.0F, 1.0F, 9.0F, 0.0F, false);

		back_fin = new ModelRenderer(this);
		back_fin.setRotationPoint(0.0F, -9.75F, 5.0F);
		body.addChild(back_fin);
		setRotationAngle(back_fin, 1.0472F, 0.0F, 0.0F);
		back_fin.setTextureOffset(0, 66).addBox(-0.5F, -0.125F, -1.5825F, 1.0F, 6.0F, 14.0F, 0.0F, false);

		left_fin = new ModelRenderer(this);
		left_fin.setRotationPoint(3.0F, -2.0F, -2.25F);
		body.addChild(left_fin);
		setRotationAngle(left_fin, 0.9599F, 0.0F, 1.8675F);
		left_fin.setTextureOffset(60, 62).addBox(-0.6578F, -9.415F, 0.8361F, 1.0F, 9.0F, 13.0F, 0.0F, false);

		right_fin = new ModelRenderer(this);
		right_fin.setRotationPoint(-6.5F, -2.0F, -3.0F);
		body.addChild(right_fin);
		setRotationAngle(right_fin, 0.9599F, 0.0F, -1.8675F);
		right_fin.setTextureOffset(60, 62).addBox(-1.0F, -7.0F, -1.5F, 1.0F, 9.0F, 13.0F, 0.0F, true);
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