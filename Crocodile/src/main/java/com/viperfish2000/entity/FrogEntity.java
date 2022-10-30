package com.viperfish2000.entity;

import java.util.EnumSet;

import org.apache.logging.log4j.LogManager;

import net.minecraft.block.BlockState;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.controller.MovementController;
import net.minecraft.entity.ai.goal.BreedGoal;
import net.minecraft.entity.ai.goal.FollowParentGoal;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.PanicGoal;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.TemptGoal;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class FrogEntity extends AnimalEntity {
	private int jumpTime;
	private int jumpTimePositive;
	private int jumpTimeNegative;
	private boolean wasOnGround;
	public static final int jumpLength = 20;
	private static final Ingredient TEMPTATION_ITEMS = Ingredient.fromItems(Items.SPIDER_EYE);

	public FrogEntity(EntityType<? extends FrogEntity> type, World worldIn) {
		super(type, worldIn);
		this.moveController = new FrogEntity.MoveHelperController(this);
	}

	protected void registerGoals() {
		this.goalSelector.addGoal(0, new SwimGoal(this));
		this.goalSelector.addGoal(1, new PanicGoal(this, 2.0D));
		this.goalSelector.addGoal(1, new BreedGoal(this, 1.0D));
		this.goalSelector.addGoal(1, new TemptGoal(this, 1.25D, Ingredient.fromItems(Items.SPIDER_EYE), false));
		this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.25D));
		this.goalSelector.addGoal(5, new RandomWalkingGoal(this, 1.0D));
		this.goalSelector.addGoal(5, new FrogEntity.HopGoal(this));
		this.goalSelector.addGoal(6, new LookAtGoal(this, PlayerEntity.class, 6.0F));
		this.goalSelector.addGoal(7, new LookRandomlyGoal(this));
		this.goalSelector.addGoal(4, new FrogEntity.FaceRandomGoal(this));

	}

	protected void registerAttributes() {
		super.registerAttributes();
		this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(5.0D);
		this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue((double) 0.2F);
		
	}

	protected SoundEvent getAmbientSound() {
		return null;
	}

	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return SoundEvents.ENTITY_SLIME_HURT;
	}

	/**
	 * Checks if the parameter is an item which this animal can be fed to breed it
	 * (wheat, carrots or seeds depending on the animal type)
	 */
	public boolean isBreedingItem(ItemStack stack) {
		return TEMPTATION_ITEMS.test(stack);
	}

	protected SoundEvent getDeathSound() {
		return SoundEvents.ENTITY_SLIME_DEATH;
	}

	protected void playStepSound(BlockPos pos, BlockState blockIn) {
		this.playSound(SoundEvents.ENTITY_COW_STEP, 0.15F, 1.0F);
	}

	/**
	 * Returns the volume for the sounds this mob makes.
	 */
	protected float getSoundVolume() {
		return 0.4F;
	}

	protected float getWaterSlowDown() {
		return 0.98F;
	}

	protected int getJumpDelay() {
		return this.rand.nextInt(15) + 10;
	}

	public void writeAdditional(CompoundNBT compound) {
		super.writeAdditional(compound);
	
		compound.putBoolean("wasOnGround", this.wasOnGround);
	}

	/**
	 * (abstract) Protected helper method to read subclass entity data from NBT.
	 */
	public void readAdditional(CompoundNBT compound) {
		int i = compound.getInt("Size");
		if (i < 0) {
			i = 0;
		}

		super.readAdditional(compound);
		this.wasOnGround = compound.getBoolean("wasOnGround");
	}

	@OnlyIn(Dist.CLIENT)
	public int getJumpTimer() {
		// this.jumpTime = (int) this.getMotion().getY();
		// LogManager.getLogger().info("test " + this.jumpTime);
		return this.jumpTime;

	}

	@OnlyIn(Dist.CLIENT)
	public int getJumpTimerPositive() {
		// this.jumpTime = (int) this.getMotion().getY();
		LogManager.getLogger().info("pos " + this.jumpTimePositive);
		return this.jumpTimePositive;

	}

	@OnlyIn(Dist.CLIENT)
	public int getJumpTimerNegative() {
		// this.jumpTime = (int) this.getMotion().getY();
		LogManager.getLogger().info("neg " + this.jumpTimeNegative);
		return this.jumpTimeNegative;

	}

	public void tick() {
		super.tick();
		if (this.getMotion().getY() > 0) {

			--this.jumpTimePositive;

			// this.jumpTimeNegative = jumpLength;
			if (this.jumpTimePositive < 0) {
				this.jumpTimeNegative = 0;
			}
		}
		if (this.getMotion().getY() < 0) {
			--this.jumpTimeNegative;
			// this.jumpTimePositive = this.jumpLength;
			if (this.jumpTimeNegative < 0) {
				this.jumpTimeNegative = 0;
			}
		}
	
	   }

	

	public FrogEntity createChild(AgeableEntity ageable) {
		return CrocodileEntities.FROG.create(this.world);
	}

	static class FaceRandomGoal extends Goal {
		private final FrogEntity slime;
		private float chosenDegrees;
		private int nextRandomizeTime;

		public FaceRandomGoal(FrogEntity slimeIn) {
			this.slime = slimeIn;
			this.setMutexFlags(EnumSet.of(Goal.Flag.LOOK));
		}

		/**
		 * Returns whether execution should begin. You can also read and cache any state
		 * necessary for execution in this method as well.
		 */
		public boolean shouldExecute() {
			return this.slime.getAttackTarget() == null
					&& (this.slime.onGround || this.slime.isInWater() || this.slime.isInLava()
							|| this.slime.isPotionActive(Effects.LEVITATION))
					&& this.slime.getMoveHelper() instanceof FrogEntity.MoveHelperController;
		}

		/**
		 * Keep ticking a continuous task that has already been started
		 */
		public void tick() {
			if (--this.nextRandomizeTime <= 0) {
				this.nextRandomizeTime = 40 + this.slime.getRNG().nextInt(60);
				this.chosenDegrees = (float) this.slime.getRNG().nextInt(360);
			}

			((FrogEntity.MoveHelperController) this.slime.getMoveHelper()).setDirection(this.chosenDegrees, false);
		}
	}

	static class HopGoal extends Goal {
		private final FrogEntity slime;

		public HopGoal(FrogEntity slimeIn) {
			this.slime = slimeIn;
			this.setMutexFlags(EnumSet.of(Goal.Flag.JUMP, Goal.Flag.MOVE));
		}

		/**
		 * Returns whether execution should begin. You can also read and cache any state
		 * necessary for execution in this method as well.
		 */
		public boolean shouldExecute() {
			return !this.slime.isPassenger();
		}

		/**
		 * Keep ticking a continuous task that has already been started
		 */
		public void tick() {
			((FrogEntity.MoveHelperController) this.slime.getMoveHelper()).setSpeed(1.0D);
		}
	}

	static class MoveHelperController extends MovementController {
		private float yRot;
		private int jumpDelay;
		private final FrogEntity slime;
		private boolean isAggressive;

		public MoveHelperController(FrogEntity slimeIn) {
			super(slimeIn);
			this.slime = slimeIn;
			this.yRot = 180.0F * slimeIn.rotationYaw / (float) Math.PI;
		}

		public void setDirection(float yRotIn, boolean aggressive) {
			this.yRot = yRotIn;
			this.isAggressive = aggressive;
		}

		public void setSpeed(double speedIn) {
			this.speed = speedIn;
			this.action = MovementController.Action.MOVE_TO;
		}

		public void tick() {
			this.mob.rotationYaw = this.limitAngle(this.mob.rotationYaw, this.yRot, 90.0F);
			this.mob.rotationYawHead = this.mob.rotationYaw;
			this.mob.renderYawOffset = this.mob.rotationYaw;
			if (this.action != MovementController.Action.MOVE_TO) {
				this.mob.setMoveForward(0.0F);
			} else {
				this.action = MovementController.Action.WAIT;
				if (this.mob.onGround) {
					this.mob.setAIMoveSpeed((float) (this.speed
							* this.mob.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getValue()));
					if (this.jumpDelay-- <= 0) {
						this.jumpDelay = this.slime.getJumpDelay();
						if (this.isAggressive) {
							this.jumpDelay /= 3;
						}

						this.slime.getJumpController().setJumping();

					} else {

						this.slime.moveStrafing = 0.0F;
						this.slime.moveForward = 0.0F;
						this.mob.setAIMoveSpeed(0.0F);
					}
				}

				else {
					this.mob.setAIMoveSpeed((float) (this.speed
							* this.mob.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getValue()));
				}

			}
		}
	}
}