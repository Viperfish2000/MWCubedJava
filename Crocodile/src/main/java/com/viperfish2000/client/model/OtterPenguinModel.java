package com.viperfish2000.client.model;


import javax.annotation.Nonnull;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.viperfish2000.entity.OtterPenguinEntity;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class OtterPenguinModel<T extends OtterPenguinEntity> extends EntityModel<T> {
	private final ModelRenderer body;
	private final ModelRenderer rightleg;
	private final ModelRenderer leftleg;
	private final ModelRenderer tail;
	private final ModelRenderer leftwingtop;
	private final ModelRenderer leftwingbottom;
	private final ModelRenderer rightwingtop;
	private final ModelRenderer rightwingbottom;
	private final ModelRenderer head;

    public OtterPenguinModel() {
    	textureWidth = 64;
		textureHeight = 64;

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 14.75F, 0.0F);
		body.setTextureOffset(0, 0).addBox(-3.5F, -6.0F, -3.0F, 7.0F, 13.0F, 5.0F, 0.0F, false);

		rightleg = new ModelRenderer(this);
		rightleg.setRotationPoint(-2.0F, 5.0F, -1.0F);
		body.addChild(rightleg);
		rightleg.setTextureOffset(30, 34).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 3.0F, 2.0F, 0.0F, true);
		rightleg.setTextureOffset(26, 30).addBox(-1.5F, 3.0F, -2.25F, 3.0F, 1.0F, 3.0F, 0.0F, true);

		leftleg = new ModelRenderer(this);
		leftleg.setRotationPoint(2.0F, 5.0F, -1.0F);
		body.addChild(leftleg);
		leftleg.setTextureOffset(30, 34).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 3.0F, 2.0F, 0.0F, false);
		leftleg.setTextureOffset(26, 30).addBox(-1.5F, 3.0F, -2.25F, 3.0F, 1.0F, 3.0F, 0.0F, false);

		tail = new ModelRenderer(this);
		tail.setRotationPoint(-0.5F, 4.5F, 2.0F);
		body.addChild(tail);
		setRotationAngle(tail, -0.5236F, 0.0F, 0.0F);
		tail.setTextureOffset(16, 22).addBox(-2.0F, 0.0F, 0.0F, 5.0F, 2.0F, 6.0F, 0.0F, false);

		leftwingtop = new ModelRenderer(this);
		leftwingtop.setRotationPoint(4.0F, -4.0F, -1.25F);
		body.addChild(leftwingtop);
		setRotationAngle(leftwingtop, 0.2618F, 0.0873F, -0.1745F);
		leftwingtop.setTextureOffset(0, 27).addBox(-0.5F, -1.0F, -1.25F, 1.0F, 8.0F, 4.0F, 0.0F, true);

		leftwingbottom = new ModelRenderer(this);
		leftwingbottom.setRotationPoint(3.5F, 0.25F, -1.25F);
		body.addChild(leftwingbottom);
		setRotationAngle(leftwingbottom, 0.2618F, 0.0F, -0.0873F);
		leftwingbottom.setTextureOffset(0, 27).addBox(-0.5F, -1.0F, -1.25F, 1.0F, 8.0F, 4.0F, 0.0F, true);

		rightwingtop = new ModelRenderer(this);
		rightwingtop.setRotationPoint(-4.0F, -4.0F, -1.25F);
		body.addChild(rightwingtop);
		setRotationAngle(rightwingtop, 0.2618F, 0.0F, 0.1745F);
		rightwingtop.setTextureOffset(0, 27).addBox(-0.5F, -1.0F, -1.25F, 1.0F, 8.0F, 4.0F, 0.0F, false);

		rightwingbottom = new ModelRenderer(this);
		rightwingbottom.setRotationPoint(-3.5F, 0.25F, -1.25F);
		body.addChild(rightwingbottom);
		setRotationAngle(rightwingbottom, 0.2618F, 0.0F, 0.0873F);
		rightwingbottom.setTextureOffset(0, 27).addBox(-0.5F, -1.0F, -1.25F, 1.0F, 8.0F, 4.0F, 0.0F, false);

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, -7.75F, -0.5F);
		body.addChild(head);
		head.setTextureOffset(19, 13).addBox(-2.5F, -2.25F, -3.0F, 5.0F, 4.0F, 5.0F, 0.0F, false);
		head.setTextureOffset(19, 0).addBox(-1.0F, 0.0F, -3.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);
    }


	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		body.render(matrixStack, buffer, packedLight, packedOverlay);
	}

    private void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }

    @Override
    public void setRotationAngles(@Nonnull OtterPenguinEntity penguin, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
    	this.body.rotateAngleX = 0;
    	this.head.rotateAngleX = headPitch * 0.017453292F;
        this.head.rotateAngleY = netHeadYaw * 0.017453292F;
        this.head.rotateAngleZ = 0;
        this.head.rotateAngleZ = (MathHelper.cos(limbSwing * 1.3324F) * 1.4F * limbSwingAmount) / 6;
        this.body.rotateAngleZ = (MathHelper.cos(limbSwing * 1.3324F) * 1.4F * limbSwingAmount) / 6;
        this.rightleg.rotateAngleX = MathHelper.cos(limbSwing * 1.3324F) * 1.2F * limbSwingAmount;
        this.leftleg.rotateAngleX = MathHelper.cos(limbSwing * 1.3324F + (float) Math.PI) * 1.2F * limbSwingAmount;
        
        this.rightwingtop.rotateAngleZ = 0.1745F + (MathHelper.cos(penguin.rotationFlipper) * limbSwingAmount);
        this.rightwingbottom.rotateAngleZ = 0.1745F + (MathHelper.cos(penguin.rotationFlipper) * limbSwingAmount);
        this.leftwingtop.rotateAngleZ = -0.1745F + (MathHelper.cos((float) penguin.rotationFlipper + (float) Math.PI) * limbSwingAmount);
        this.leftwingbottom.rotateAngleZ = -0.1745F + (MathHelper.cos((float) penguin.rotationFlipper + (float) Math.PI) * limbSwingAmount);
        this.rightwingtop.rotateAngleX =  0.2618F;
        this.rightwingtop.rotateAngleY = 0;
        this.rightwingbottom.rotateAngleX =  0.2618F;
        this.rightwingbottom.rotateAngleY = 0;
        this.leftwingtop.rotateAngleX =  0.2618F;
        this.leftwingtop.rotateAngleY = 0;
        this.leftwingbottom.rotateAngleX =  0.2618F;
        this.leftwingbottom.rotateAngleY = 0;
        
        this.tail.rotateAngleX = -0.5236F;
        this.tail.rotateAngleY = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        
        
        if (penguin.isInWater()){
        this.body.rotateAngleX =  1.5708F;	
        this.body.rotateAngleY =  0F;	
        this.body.rotateAngleZ =  0F;	
    	this.head.rotateAngleX = -1.5708F+headPitch * 0.017453292F;
        this.head.rotateAngleY =0F;
        this.head.rotateAngleZ = netHeadYaw * 0.017453292F;
        setRotationAngle(tail, -1.4835F, 0.0F, 0.0F);
        setRotationAngle(rightwingtop, 1.6581F, 1.5708F, -3.1416F);
        
        this.rightwingtop.rotateAngleY = 1.5708F + MathHelper.cos(limbSwing * 0.6662F * 0.6F + (float)Math.PI) * limbSwingAmount;
        this.rightwingtop.rotateAngleX = 1.6581F;
        this.rightwingtop.rotateAngleZ = -3.1416F;
        this.rightwingbottom.rotateAngleY = 1.5708F + -(MathHelper.cos(limbSwing * 0.6662F * 0.6F + (float)Math.PI)  * limbSwingAmount);
        this.rightwingbottom.rotateAngleX = 1.6581F;
        this.rightwingbottom.rotateAngleZ = -3.1416F;
        
    
        this.leftwingtop.rotateAngleY = -1.5708F +-( MathHelper.cos(limbSwing * 0.6662F * 0.6F) * limbSwingAmount);
        this.leftwingtop.rotateAngleX = -1.4835F;
        this.leftwingtop.rotateAngleZ = 0;
        this.leftwingbottom.rotateAngleY =-1.5708F +  MathHelper.cos(limbSwing * 0.6662F * 0.6F) * limbSwingAmount;
        this.leftwingbottom.rotateAngleX = -1.4835F;
        this.leftwingbottom.rotateAngleZ = 0;
        
        
        }
    }
}