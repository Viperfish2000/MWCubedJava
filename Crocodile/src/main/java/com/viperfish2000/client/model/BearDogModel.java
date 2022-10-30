package com.viperfish2000.client.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.viperfish2000.entity.PolarBearDogEntity;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class BearDogModel<T extends PolarBearDogEntity> extends EntityModel<T> {
	private final ModelRenderer body;
	private final ModelRenderer reigns;
	private final ModelRenderer head;
	private final ModelRenderer bone;
	private final ModelRenderer bone2;
	private final ModelRenderer legBackRight;
	private final ModelRenderer legBackLeft;
	private final ModelRenderer legFrontRight;
	private final ModelRenderer legFrontLeft;
	private final ModelRenderer tail;
	private final ModelRenderer saddle;
	private final ModelRenderer Saddles[];
	private final ModelRenderer Reigns[];
	private final ModelRenderer body1;
	private final ModelRenderer head1;
	private final ModelRenderer boneA;
	private final ModelRenderer bone2A;
	private final ModelRenderer legBackRight1;
	private final ModelRenderer legBackLeft1;
	private final ModelRenderer legFrontRight1;
	private final ModelRenderer legFrontLeft1;
	private final ModelRenderer tail1;
	private final ModelRenderer saddle1;
	private final ModelRenderer reigns1;
	private final ModelRenderer Saddles1[];
	private final ModelRenderer Reigns1[];
	public BearDogModel() {
		textureWidth = 128;
		textureHeight = 64;

		body = new ModelRenderer(this);
		body.setRotationPoint(-2.0F, 10.0F, -3.0F);
		setRotationAngle(body, 1.5708F, 0.0F, 0.0F);
		body.setTextureOffset(7, 22).addBox(-3.0F, 1.0F, -6.0F, 10.0F, 12.0F, 8.0F, 0.0F, false);
		body.setTextureOffset(39, 0).addBox(-4.0F, -10.0F, -7.0F, 12.0F, 11.0F, 10.0F, 0.0F, false);

		reigns = new ModelRenderer(this);
		reigns.setRotationPoint(0.0F, 22.0F, 27.0F);
		setRotationAngle(reigns, 1.5708F, 0.0F, 0.0F);
		reigns.setTextureOffset(86, 42).addBox(-5.75F, -29.0F, 4.5F, 11.0F, 12.0F, 10.0F, 0.0F, false);
		reigns.setTextureOffset(80, 12).addBox(-6.5F, -40.5F, 4.5F, 13.0F, 12.0F, 11.0F, 0.0F, false);
		
		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, 12.5F, -16.0F);
		head.setTextureOffset(0, 0).addBox(-3.5F, -3.5F, -3.0F, 7.0F, 5.0F, 7.0F, 0.0F, false);
		head.setTextureOffset(2, 44).addBox(-2.0F, -1.5F, -6.0F, 4.0F, 3.0F, 3.0F, 0.0F, false);

		bone = new ModelRenderer(this);
		bone.setRotationPoint(3.5F, -3.0F, -0.5F);
		head.addChild(bone);
		setRotationAngle(bone, 0.0F, -1.5708F, 2.618F);
		bone.setTextureOffset(25, 0).addBox(-2.0F, -2.6816F, -0.6898F, 3.0F, 3.0F, 1.0F, 0.0F, true);

		bone2 = new ModelRenderer(this);
		bone2.setRotationPoint(-2.25F, -2.0F, -0.5F);
		head.addChild(bone2);
		setRotationAngle(bone2, 0.0F, -1.5708F, -2.618F);
		bone2.setTextureOffset(25, 0).addBox(-2.0F, -2.3401F, -2.0313F, 3.0F, 3.0F, 1.0F, 0.0F, false);

		legBackRight = new ModelRenderer(this);
		legBackRight.setRotationPoint(-4.5F, 14.0F, 8.0F);
		legBackRight.setTextureOffset(56, 27).addBox(-0.25F, 0.0F, -1.75F, 3.0F, 10.0F, 3.0F, 0.0F, false);

		legBackLeft = new ModelRenderer(this);
		legBackLeft.setRotationPoint(4.5F, 14.0F, 8.0F);
		legBackLeft.setTextureOffset(56, 27).addBox(-2.75F, 0.0F, -2.0F, 3.0F, 10.0F, 3.0F, 0.0F, false);

		legFrontRight = new ModelRenderer(this);
		legFrontRight.setRotationPoint(-5.5F, 14.0F, -9.5F);
		legFrontRight.setTextureOffset(50, 40).addBox(-1.0F, 0.0F, -3.25F, 4.0F, 10.0F, 6.0F, 0.0F, false);

		legFrontLeft = new ModelRenderer(this);
		legFrontLeft.setRotationPoint(6.5F, 14.0F, -9.5F);
		legFrontLeft.setTextureOffset(50, 40).addBox(-4.0F, 0.0F, -3.25F, 4.0F, 10.0F, 6.0F, 0.0F, false);

		tail = new ModelRenderer(this);
		tail.setRotationPoint(0.0F, 10.0F, 8.0F);
		setRotationAngle(tail, 0.6109F, 0.0F, 0.0F);
		tail.setTextureOffset(72, 44).addBox(-1.5F, 0.0F, -2.0F, 3.0F, 13.0F, 4.0F, 0.0F, true);

		saddle = new ModelRenderer(this);
		saddle.setRotationPoint(-2.0F, 7.5F, -4.0F);
		setRotationAngle(saddle, -0.0698F, 0.0F, 0.0F);
		saddle.setTextureOffset(21, 52).addBox(-2.5F, -1.0F, -5.0F, 9.0F, 1.0F, 11.0F, 0.0F, false);
		saddle.setTextureOffset(0, 61).addBox(-1.5F, -2.0F, -5.0F, 7.0F, 1.0F, 2.0F, 0.0F, false);
		saddle.setTextureOffset(0, 57).addBox(-1.5F, -2.0F, 4.0F, 7.0F, 1.0F, 2.0F, 0.0F, false);
		
	      this.Saddles = new ModelRenderer[]{saddle};
	      this.Reigns = new ModelRenderer[]{reigns};
	      body1 = new ModelRenderer(this);
			body1.setRotationPoint(-2.0F, 10.0F, -3.0F);
			setRotationAngle(body1, 0.9599F, 0.0F, 0.0F);
			body1.setTextureOffset(7, 22).addBox(-3.0F, 2.1472F, -7.6383F, 10.0F, 12.0F, 8.0F, 0.0F, false);
			body1.setTextureOffset(39, 0).addBox(-4.0F, -8.8528F, -8.6383F, 12.0F, 11.0F, 10.0F, 0.0F, false);

			head1 = new ModelRenderer(this);
			head1.setRotationPoint(0.0F, 7.5F, -16.0F);
			head1.setTextureOffset(0, 0).addBox(-3.5F, -3.5F, -3.0F, 7.0F, 5.0F, 7.0F, 0.0F, false);
			head1.setTextureOffset(2, 44).addBox(-2.0F, -1.5F, -6.0F, 4.0F, 3.0F, 3.0F, 0.0F, false);

			boneA = new ModelRenderer(this);
			boneA.setRotationPoint(3.5F, -3.0F, -0.5F);
			head1.addChild(boneA);
			setRotationAngle(boneA, 0.0F, -1.5708F, 2.618F);
			boneA.setTextureOffset(25, 0).addBox(-2.0F, -2.6816F, -0.6898F, 3.0F, 3.0F, 1.0F, 0.0F, true);

			bone2A = new ModelRenderer(this);
			bone2A.setRotationPoint(-2.25F, -2.0F, -0.5F);
			head1.addChild(bone2A);
			setRotationAngle(bone2A, 0.0F, -1.5708F, -2.618F);
			bone2A.setTextureOffset(25, 0).addBox(-2.0F, -2.3401F, -2.0313F, 3.0F, 3.0F, 1.0F, 0.0F, false);

			legBackRight1 = new ModelRenderer(this);
			legBackRight1.setRotationPoint(-4.5F, 22.75F, 5.0F);
			setRotationAngle(legBackRight1, -1.5708F, 0.0F, 0.0F);
			legBackRight1.setTextureOffset(56, 27).addBox(-0.25F, 0.0F, -1.75F, 3.0F, 10.0F, 3.0F, 0.0F, false);

			legBackLeft1 = new ModelRenderer(this);
			legBackLeft1.setRotationPoint(4.5F, 23.0F, 5.0F);
			setRotationAngle(legBackLeft1, -1.5708F, 0.0F, 0.0F);
			legBackLeft1.setTextureOffset(56, 27).addBox(-2.75F, 0.0F, -2.0F, 3.0F, 10.0F, 3.0F, 0.0F, false);

			legFrontRight1 = new ModelRenderer(this);
			legFrontRight1.setRotationPoint(-5.5F, 14.0F, -9.5F);
			legFrontRight1.setTextureOffset(50, 40).addBox(0.0F, 0.0F, -3.25F, 4.0F, 10.0F, 6.0F, 0.0F, false);

			legFrontLeft1 = new ModelRenderer(this);
			legFrontLeft1.setRotationPoint(6.5F, 14.0F, -9.5F);
			legFrontLeft1.setTextureOffset(50, 40).addBox(-5.0F, 0.0F, -3.25F, 4.0F, 10.0F, 6.0F, 0.0F, false);

			tail1 = new ModelRenderer(this);
			tail1.setRotationPoint(0.0F, 19.0F, 6.0F);
			setRotationAngle(tail1, 2.5307F, 0.0F, 0.0F);
			tail1.setTextureOffset(72, 44).addBox(-1.5F, 0.0F, -2.0F, 3.0F, 13.0F, 4.0F, 0.0F, true);

			saddle1 = new ModelRenderer(this);
			saddle1.setRotationPoint(-2.0F, 7.5F, -2.0F);
			setRotationAngle(saddle1, -0.6807F, 0.0F, 0.0F);
			saddle1.setTextureOffset(21, 52).addBox(-2.5F, 0.5543F, -3.7414F, 9.0F, 1.0F, 11.0F, 0.0F, false);
			saddle1.setTextureOffset(0, 61).addBox(-1.5F, -0.4457F, -3.7414F, 7.0F, 1.0F, 2.0F, 0.0F, false);
			saddle1.setTextureOffset(0, 57).addBox(-1.5F, -0.4457F, 5.2586F, 7.0F, 1.0F, 2.0F, 0.0F, false);

			reigns1 = new ModelRenderer(this);
			reigns1.setRotationPoint(0.0F, 24.0F, 15.0F);
			setRotationAngle(reigns1, 0.9599F, 0.0F, 0.0F);
			reigns1.setTextureOffset(86, 42).addBox(-5.75F, -20.3964F, -7.7873F, 11.0F, 12.0F, 10.0F, 0.0F, false);
			reigns1.setTextureOffset(80, 12).addBox(-6.5F, -31.8964F, -7.7873F, 13.0F, 12.0F, 11.0F, 0.0F, false);

		      this.Saddles1 = new ModelRenderer[]{saddle1};
		      this.Reigns1 = new ModelRenderer[]{reigns1};
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
		if (!entityIn.isSitting()) {
	   		boolean flag = entityIn.isHorseSaddled();
	      boolean flag1 = entityIn.isBeingRidden();
	      if (!entityIn.isSitting()) {
	      for(ModelRenderer modelrenderer : this.Saddles) {
	         modelrenderer.showModel = flag;
	      }

	      for(ModelRenderer modelrenderer : this.Reigns) {
	    	  modelrenderer.showModel = flag;
	      }
	      }
	     
		this.head.rotateAngleX = headPitch * ((float) Math.PI / 180F);
		this.head.rotateAngleY = netHeadYaw * ((float) Math.PI / 180F);
		this.legBackRight.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.1F * limbSwingAmount;
        this.legBackLeft.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.1F * limbSwingAmount;
        this.legFrontRight.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.1F * limbSwingAmount;
        this.legFrontLeft.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.1F * limbSwingAmount;
        this.head.showModel = true;
     	 this.body.showModel = true;
    	 this.legFrontLeft.showModel = true;
    	 this.legFrontRight.showModel = true;
    	 this.legBackLeft.showModel = true;
    	 this.legBackRight.showModel = true;
    	
    	 this.tail.showModel = true;
		 this.body1.showModel = false;
    	 this.legFrontLeft1.showModel = false;
    	 this.legFrontRight1.showModel = false;
    	 this.legBackLeft1.showModel = false;
    	 this.legBackRight1.showModel = false;
      	 this.reigns1.showModel = false;
    	 this.saddle1.showModel = false;
    	 this.head1.showModel = false;
    	 this.tail1.showModel = false;}
        if (entityIn.isSitting()) {
      		boolean flag = entityIn.isHorseSaddled();
  	      boolean flag1 = entityIn.isBeingRidden();
        	 for(ModelRenderer modelrenderer : this.Saddles1) {
		         modelrenderer.showModel = flag;
		      }

		      for(ModelRenderer modelrenderer : this.Reigns1) {
		    	  modelrenderer.showModel = flag;
		      }
        	this.head.showModel=false;
        	 this.body.showModel = false;
        	 this.legFrontLeft.showModel = false;
        	 this.legFrontRight.showModel = false;
        	 this.legBackLeft.showModel = false;
        	 this.legBackRight.showModel = false;
        	 this.reigns.showModel = false;
        	 this.saddle.showModel = false;
        	 this.tail.showModel = false;
     		this.head1.rotateAngleX = headPitch * ((float) Math.PI / 180F);
    		this.head1.rotateAngleY = netHeadYaw * ((float) Math.PI / 180F);
    		this.head1.showModel=true;
    		 this.body1.showModel = true;
        	 this.legFrontLeft1.showModel = true;
        	 this.legFrontRight1.showModel = true;
        	 this.legBackLeft1.showModel = true;
        	 this.legBackRight1.showModel = true;

        	 this.tail1.showModel = true;
        
        }
   }





   public void setLivingAnimations(T entityIn, float limbSwing, float limbSwingAmount, float partialTick) {
      super.setLivingAnimations(entityIn, limbSwing, limbSwingAmount, partialTick);
     
		

				
		
		
   }
   public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}


@Override
public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay,
		float red, float green, float blue, float alpha) {
	body.render(matrixStack, buffer, packedLight, packedOverlay);
	head.render(matrixStack, buffer, packedLight, packedOverlay);
	legBackRight.render(matrixStack, buffer, packedLight, packedOverlay);
	legBackLeft.render(matrixStack, buffer, packedLight, packedOverlay);
	legFrontRight.render(matrixStack, buffer, packedLight, packedOverlay);
	legFrontLeft.render(matrixStack, buffer, packedLight, packedOverlay);
	tail.render(matrixStack, buffer, packedLight, packedOverlay);
	saddle.render(matrixStack, buffer, packedLight, packedOverlay);
	reigns.render(matrixStack, buffer, packedLight, packedOverlay);
	body1.render(matrixStack, buffer, packedLight, packedOverlay);
	head1.render(matrixStack, buffer, packedLight, packedOverlay);
	legBackRight1.render(matrixStack, buffer, packedLight, packedOverlay);
	legBackLeft1.render(matrixStack, buffer, packedLight, packedOverlay);
	legFrontRight1.render(matrixStack, buffer, packedLight, packedOverlay);
	legFrontLeft1.render(matrixStack, buffer, packedLight, packedOverlay);
	tail1.render(matrixStack, buffer, packedLight, packedOverlay);
	saddle1.render(matrixStack, buffer, packedLight, packedOverlay);
	reigns1.render(matrixStack, buffer, packedLight, packedOverlay);
	
}


}