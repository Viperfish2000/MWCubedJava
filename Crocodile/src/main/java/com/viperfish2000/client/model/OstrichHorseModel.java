package com.viperfish2000.client.model;

import com.google.common.collect.ImmutableList;
import com.viperfish2000.entity.OstrichHorseEntity;

import net.minecraft.client.renderer.entity.model.AgeableModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.passive.horse.AbstractHorseEntity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class OstrichHorseModel<T extends AbstractHorseEntity> extends AgeableModel<T> {
	private final ModelRenderer Body;
	private final ModelRenderer Neck;
	private final ModelRenderer Mane;
	private final ModelRenderer Head;
	private final ModelRenderer LMouth;
	private final ModelRenderer UMouth;
	private final ModelRenderer bone;
	private final ModelRenderer Ear2;
	private final ModelRenderer Ear1;
	private final ModelRenderer SaddleMouthLine;
	private final ModelRenderer HeadSaddle;
	private final ModelRenderer SaddleMouthLineR;
	private final ModelRenderer wing1;
	private final ModelRenderer wing2;
	private final ModelRenderer TailA;
	private final ModelRenderer TailB;
	private final ModelRenderer TailC;
	private final ModelRenderer LegRA;
	private final ModelRenderer LegRB;
	private final ModelRenderer LegRC;
	private final ModelRenderer LegLA;
	private final ModelRenderer LegLB;
	private final ModelRenderer LegLC;
	private final ModelRenderer Bag1;
	private final ModelRenderer Bag2;
	private final ModelRenderer Saddle;
	private final ModelRenderer SaddleR;
	private final ModelRenderer SaddleR2;
	private final ModelRenderer SaddleL;
	private final ModelRenderer SaddleL2;
	private final ModelRenderer SaddleC;
	private final ModelRenderer SaddleB;
	private final ModelRenderer Saddles[];
	private final ModelRenderer Reigns[];
	public OstrichHorseModel() {
		textureWidth = 128;
		textureHeight = 128;

		Body = new ModelRenderer(this);
		Body.setRotationPoint(0.0F, 10.0F, 9.0F);
		setRotationAngle(Body, -0.1745F, 0.0F, 0.0F);
		Body.setTextureOffset(8, 41).addBox(-4.25F, -9.4489F, -13.3882F, 8.0F, 9.0F, 17.0F, 0.0F, false);
		Neck = new ModelRenderer(this);
		Neck.setRotationPoint(0.0F, 1.9653F, -1.4387F);
		Neck.setTextureOffset(2, 15).addBox(-2.05F, -11.6682F, -3.924F, 4.0F, 14.0F, 5.0F, 0.0F, false);

		Mane = new ModelRenderer(this);
		Mane.setRotationPoint(0.0F, -1.8682F, -4.924F);
		Neck.addChild(Mane);
		Mane.setTextureOffset(58, 0).addBox(-1.0F, -11.4128F, 4.0038F, 2.0F, 11.0F, 4.0F, 0.0F, false);

		Head = new ModelRenderer(this);
		Head.setRotationPoint(0.0F, -10.926F, -1.3512F);
		Neck.addChild(Head);
		setRotationAngle(Head, 0.0873F, 0.0F, 0.0F);
		Head.setTextureOffset(0, 0).addBox(-2.5F, -3.0F, -4.5F, 5.0F, 5.0F, 7.0F, 0.0F, false);

		LMouth = new ModelRenderer(this);
		LMouth.setRotationPoint(0.0F, 1.0119F, -4.5947F);
		Head.addChild(LMouth);
		setRotationAngle(LMouth, -0.2618F, 0.0F, 0.0F);
		LMouth.setTextureOffset(59, 41).addBox(-1.0F, -1.75F, -4.5F, 2.0F, 2.0F, 5.0F, 0.0F, false);

		UMouth = new ModelRenderer(this);
		UMouth.setRotationPoint(0.0F, -0.6028F, -3.8362F);
		Head.addChild(UMouth);
		UMouth.setTextureOffset(44, 29).addBox(-1.5F, -2.0F, -6.0F, 3.0F, 3.0F, 6.0F, 0.0F, false);

		bone = new ModelRenderer(this);
		bone.setRotationPoint(-0.5F, -1.3178F, -5.6242F);
		UMouth.addChild(bone);
		setRotationAngle(bone, 1.1345F, 0.0F, 0.0F);
		bone.setTextureOffset(44, 42).addBox(-0.5F, -0.685F, -2.529F, 2.0F, 2.0F, 3.0F, 0.0F, false);

		Ear2 = new ModelRenderer(this);
		Ear2.setRotationPoint(0.0F, 7.0F, -3.0F);
		Head.addChild(Ear2);
		Ear2.setTextureOffset(0, 0).addBox(-2.45F, -12.0F, 4.0F, 2.0F, 3.0F, 1.0F, 0.0F, false);

		Ear1 = new ModelRenderer(this);
		Ear1.setRotationPoint(0.0F, 7.0F, -3.0F);
		Head.addChild(Ear1);
		Ear1.setTextureOffset(0, 0).addBox(0.45F, -12.0F, 4.0F, 2.0F, 3.0F, 1.0F, 0.0F, true);

		SaddleMouthLine = new ModelRenderer(this);
		SaddleMouthLine.setRotationPoint(0.0F, 6.2653F, 0.0757F);
		Head.addChild(SaddleMouthLine);
		setRotationAngle(SaddleMouthLine, -0.2618F, 0.0F, 0.0F);
		SaddleMouthLine.setTextureOffset(44, 10).addBox(2.6F, -6.0F, -6.0F, 0.0F, 3.0F, 16.0F, 0.0F, false);

		HeadSaddle = new ModelRenderer(this);
		HeadSaddle.setRotationPoint(0.0F, 7.0F, -3.0F);
		Head.addChild(HeadSaddle);
		HeadSaddle.setTextureOffset(80, 12).addBox(-2.5F, -10.0128F, -6.0038F, 5.0F, 5.0F, 12.0F, 0.05F, false);

		SaddleMouthLineR = new ModelRenderer(this);
		SaddleMouthLineR.setRotationPoint(0.0F, 5.2691F, 0.1629F);
		Head.addChild(SaddleMouthLineR);
		setRotationAngle(SaddleMouthLineR, -0.3491F, 0.0F, 0.0F);
		SaddleMouthLineR.setTextureOffset(44, 5).addBox(-2.6F, -6.0F, -6.0F, 0.0F, 3.0F, 16.0F, 0.0F, false);


		wing1 = new ModelRenderer(this);
		wing1.setRotationPoint(0.5F, -4.6718F, -8.971F);
		Body.addChild(wing1);
		setRotationAngle(wing1, 0.2618F, 0.0F, 0.0F);
		wing1.setTextureOffset(68, 48).addBox(-6.0F, -3.3941F, -0.7118F, 2.0F, 6.0F, 15.0F, 0.0F, false);

		wing2 = new ModelRenderer(this);
		wing2.setRotationPoint(8.5F, -4.6718F, -8.971F);
		Body.addChild(wing2);
		setRotationAngle(wing2, 0.2618F, 0.0F, 0.0F);
		wing2.setTextureOffset(68, 48).addBox(-6.0F, -3.3941F, -0.7118F, 2.0F, 6.0F, 15.0F, 0.0F, true);

		TailA = new ModelRenderer(this);
		TailA.setRotationPoint(0.0F, -7.9006F, 2.6973F);
		Body.addChild(TailA);
		setRotationAngle(TailA, -0.8727F, 0.0F, 0.0F);
		TailA.setTextureOffset(44, 0).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 3.0F, 0.0F, false);

		TailB = new ModelRenderer(this);
		TailB.setRotationPoint(0.0F, 0.0F, 0.0F);
		TailA.addChild(TailB);
		setRotationAngle(TailB, -0.0873F, 0.0F, 0.0F);
		TailB.setTextureOffset(38, 7).addBox(-1.5F, -2.0F, 3.0F, 3.0F, 4.0F, 7.0F, 0.0F, false);

		TailC = new ModelRenderer(this);
		TailC.setRotationPoint(0.0F, 0.0F, 0.0F);
		TailB.addChild(TailC);
		setRotationAngle(TailC, -0.2677F, 0.0F, 0.0F);
		TailC.setTextureOffset(24, 3).addBox(-1.5F, -4.5F, 9.0F, 3.0F, 4.0F, 7.0F, 0.0F, false);

		LegRA = new ModelRenderer(this);
		LegRA.setRotationPoint(-5.5F, -2.2762F, -3.0034F);
		Body.addChild(LegRA);
		setRotationAngle(LegRA, 0.3491F, 0.0F, 0.0F);
		LegRA.setTextureOffset(78, 29).addBox(-1.85F, -2.0F, -2.6F, 4.0F, 9.0F, 5.0F, 0.0F, false);

		LegRB = new ModelRenderer(this);
		LegRB.setRotationPoint(0.0F, 6.0426F, 0.4763F);
		LegRA.addChild(LegRB);
		setRotationAngle(LegRB, -0.5236F, 0.0F, 0.0F);
		LegRB.setTextureOffset(116, 0).addBox(-1.1F, -1.0F, -1.6F, 3.0F, 13.0F, 3.0F, 0.0F, false);

		LegRC = new ModelRenderer(this);
		LegRC.setRotationPoint(0.0F, 11.5F, 0.0F);
		LegRB.addChild(LegRC);
		//setRotationAngle(LegRC, 0.4363F, 0.0F, 0.0F);
		LegRC.setTextureOffset(106, 43).addBox(-1.6F, -0.7911F, -5.1774F, 4.0F, 2.0F, 7.0F, 0.0F, false);

		LegLA = new ModelRenderer(this);
		LegLA.setRotationPoint(3.5F, -2.2762F, -3.0034F);
		Body.addChild(LegLA);
		setRotationAngle(LegLA, 0.3491F, 0.0F, 0.0F);
		LegLA.setTextureOffset(96, 29).addBox(-1.85F, -2.0F, -2.6F, 4.0F, 9.0F, 5.0F, 0.0F, false);

		LegLB = new ModelRenderer(this);
		LegLB.setRotationPoint(0.0F, 6.0426F, 0.4763F);
		LegLA.addChild(LegLB);
		setRotationAngle(LegLB, -0.5236F, 0.0F, 0.0F);
		LegLB.setTextureOffset(116, 0).addBox(-1.1F, -1.0F, -1.6F, 3.0F, 13.0F, 3.0F, 0.0F, true);

		LegLC = new ModelRenderer(this);
		LegLC.setRotationPoint(0.0F, 11.5F, 0.0F);
		LegLB.addChild(LegLC);
		//setRotationAngle(LegLC, 0.4363F, 0.0F, 0.0F);
		LegLC.setTextureOffset(106, 43).addBox(-1.6F, -0.7911F, -5.1774F, 4.0F, 2.0F, 7.0F, 0.0F, true);

		Bag1 = new ModelRenderer(this);
		Bag1.setRotationPoint(-7.5F, -8.0F, 1.0F);
		Body.addChild(Bag1);
		setRotationAngle(Bag1, 0.0F, 1.5708F, 0.0F);
		Bag1.setTextureOffset(0, 34).addBox(-2.0152F, 0.1736F, 0.0F, 8.0F, 8.0F, 3.0F, 0.0F, false);

		Bag2 = new ModelRenderer(this);
		Bag2.setRotationPoint(4.5F, -8.0F, 1.0F);
		Body.addChild(Bag2);
		setRotationAngle(Bag2, 0.0F, 1.5708F, 0.0F);
		Bag2.setTextureOffset(0, 47).addBox(-2.0152F, 0.1736F, -1.0F, 8.0F, 8.0F, 3.0F, 0.0F, false);

		Saddle = new ModelRenderer(this);
		Saddle.setRotationPoint(-0.25F, -10.5009F, -4.2963F);
		Body.addChild(Saddle);
		setRotationAngle(Saddle, 0.0873F, 0.0F, 0.0F);
		Saddle.setTextureOffset(80, 0).addBox(-5.0F, 0.0F, -3.0F, 10.0F, 3.0F, 8.0F, 0.0F, false);

		SaddleR = new ModelRenderer(this);
		SaddleR.setRotationPoint(-5.0F, 0.7829F, 1.231F);
		Saddle.addChild(SaddleR);
		setRotationAngle(SaddleR, 0.0873F, 0.0F, 0.0F);
		SaddleR.setTextureOffset(80, 0).addBox(-0.5F, -0.1736F, 0.4848F, 1.0F, 6.0F, 1.0F, 0.0F, false);

		SaddleR2 = new ModelRenderer(this);
		SaddleR2.setRotationPoint(0.0F, -0.4199F, 0.9414F);
		SaddleR.addChild(SaddleR2);
		SaddleR2.setTextureOffset(74, 4).addBox(-0.5F, 6.0F, -1.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);

		SaddleL = new ModelRenderer(this);
		SaddleL.setRotationPoint(5.0F, 0.7829F, 1.231F);
		Saddle.addChild(SaddleL);
		setRotationAngle(SaddleL, 0.0873F, 0.0F, 0.0F);
		SaddleL.setTextureOffset(80, 0).addBox(-0.5F, -0.1736F, 0.4848F, 1.0F, 6.0F, 1.0F, 0.0F, false);

		SaddleL2 = new ModelRenderer(this);
		SaddleL2.setRotationPoint(0.0F, -0.4199F, 0.9414F);
		SaddleL.addChild(SaddleL2);
		SaddleL2.setTextureOffset(74, 4).addBox(-0.5F, 6.0F, -1.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);

		SaddleC = new ModelRenderer(this);
		SaddleC.setRotationPoint(0.0F, 0.0F, 0.0F);
		Saddle.addChild(SaddleC);
		SaddleC.setTextureOffset(80, 9).addBox(-4.0F, -1.0F, 3.0F, 8.0F, 1.0F, 2.0F, 0.0F, false);

		SaddleB = new ModelRenderer(this);
		SaddleB.setRotationPoint(0.0F, 0.0F, 0.0F);
		Saddle.addChild(SaddleB);
		SaddleB.setTextureOffset(106, 9).addBox(-1.5F, -1.0F, -3.0F, 3.0F, 1.0F, 2.0F, 0.0F, false);
		
	      this.Saddles = new ModelRenderer[]{Saddle,HeadSaddle};
	      this.Reigns = new ModelRenderer[]{SaddleMouthLineR,SaddleMouthLine};
	}


   protected void func_199047_a(ModelRenderer p_199047_1_) {
      ModelRenderer modelrenderer = new ModelRenderer(this, 19, 16);
      modelrenderer.addBox(0.55F, -13.0F, 4.0F, 2.0F, 3.0F, 1.0F, -0.001F);
      ModelRenderer modelrenderer1 = new ModelRenderer(this, 19, 16);
      modelrenderer1.addBox(-2.55F, -13.0F, 4.0F, 2.0F, 3.0F, 1.0F, -0.001F);
      p_199047_1_.addChild(modelrenderer);
      p_199047_1_.addChild(modelrenderer1);
   }

   /**
    * Sets this entity's model rotation angles
    */
   public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	   		boolean flag = entityIn.isHorseSaddled();
	      boolean flag1 = entityIn.isBeingRidden();

	      for(ModelRenderer modelrenderer : this.Saddles) {
	         modelrenderer.showModel = flag;
	      }

	      for(ModelRenderer modelrenderer1 : this.Reigns) {
	         modelrenderer1.showModel = flag1 && flag;
	      }
		this.Head.rotateAngleX = headPitch * ((float) Math.PI / 180F);
		this.Head.rotateAngleY = netHeadYaw * ((float) Math.PI / 180F);
		  if (((OstrichHorseEntity) entityIn).hasChest()) {
		         this.Bag1.showModel = true;
		         this.Bag2.showModel = true;
		      } else {
		         this.Bag1.showModel = false;
		         this.Bag2.showModel = false;
		      }
   }



   protected Iterable<ModelRenderer> getBodyParts() {
      return ImmutableList.of(this.Body);
   }

   public void setLivingAnimations(T entityIn, float limbSwing, float limbSwingAmount, float partialTick) {
      super.setLivingAnimations(entityIn, limbSwing, limbSwingAmount, partialTick);

		
		this.LegRA.rotateAngleX =0.3491F+ MathHelper.cos(limbSwing * 0.3F)  * 0.85F * limbSwingAmount;
		this.LegLA.rotateAngleX =0.3491F+ MathHelper.cos(limbSwing * 0.3F + (2/2)*(float) Math.PI) * 0.85F * limbSwingAmount;
		
		this.LegRB.rotateAngleX =-0.5236F+ MathHelper.cos(limbSwing * 0.3F+ (1/2)*(float) Math.PI) *  0.5F * limbSwingAmount;
		this.LegLB.rotateAngleX =-0.5236F+ MathHelper.cos(limbSwing * 0.3F + (3/2)*(float) Math.PI) * 0.5F * limbSwingAmount;
		
		this.LegLC.rotateAngleX =0.436332F+MathHelper.cos(limbSwing * 0.3F )  * 1.5F * limbSwingAmount;
		this.LegRC.rotateAngleX =0.436332F+MathHelper.cos(limbSwing * 0.3F + (2/2)*(float) Math.PI) * 1.5F * limbSwingAmount;
				
		
		
   }
   public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}


@Override
protected Iterable<ModelRenderer> getHeadParts() {
	// TODO Auto-generated method stub
	return ImmutableList.of(this.Neck);
}
}