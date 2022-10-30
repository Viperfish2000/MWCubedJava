package com.viperfish2000.entity;

import java.util.UUID;
import java.util.function.Predicate;

import javax.annotation.Nullable;

import net.minecraft.block.BlockState;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntitySize;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.Pose;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.ai.attributes.RangedAttribute;
import net.minecraft.entity.ai.goal.BegGoal;
import net.minecraft.entity.ai.goal.BreedGoal;
import net.minecraft.entity.ai.goal.FollowOwnerGoal;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.goal.LeapAtTargetGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.NonTamedTargetGoal;
import net.minecraft.entity.ai.goal.OwnerHurtByTargetGoal;
import net.minecraft.entity.ai.goal.OwnerHurtTargetGoal;
import net.minecraft.entity.ai.goal.SitGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.monster.AbstractSkeletonEntity;
import net.minecraft.entity.monster.CreeperEntity;
import net.minecraft.entity.monster.GhastEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.passive.TurtleEntity;
import net.minecraft.entity.passive.WolfEntity;
import net.minecraft.entity.passive.horse.LlamaEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.IInventoryChangedListener;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.DyeColor;
import net.minecraft.item.DyeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class BearDogEntity extends TameableEntity implements IInventoryChangedListener {
	private static final DataParameter<Boolean> BEGGING = EntityDataManager.createKey(BearDogEntity.class,
			DataSerializers.BOOLEAN);
	protected static final IAttribute JUMP_STRENGTH = (new RangedAttribute((IAttribute) null, "horse.jumpStrength",
			0.7D, 0.0D, 2.0D)).setDescription("Jump Strength").setShouldWatch(true);
	private static final DataParameter<Byte> STATUS = EntityDataManager.createKey(BearDogEntity.class,
			DataSerializers.BYTE);

	public static final Predicate<LivingEntity> TARGET_ENTITIES = (p_213440_0_) -> {
		EntityType<?> entitytype = p_213440_0_.getType();
		return entitytype == EntityType.SHEEP || entitytype == EntityType.RABBIT || entitytype == EntityType.FOX;
	};
	private float headRotationCourse;
	private float headRotationCourseOld;
	private boolean isWet;
	private boolean isShaking;
	private float timeWolfIsShaking;
	private float prevTimeWolfIsShaking;
	private int eatingCounter;
	private int openMouthCounter;
	private int jumpRearingCounter;
	public int tailCounter;
	public int sprintCounter;
	protected boolean horseJumping;
	protected Inventory horseChest;
	/**
	 * The higher this value, the more likely the horse is to be tamed next time a
	 * player rides it.
	 */
	protected int temper;
	protected float jumpPower;
	private boolean allowStandSliding;
	private float headLean;
	private float prevHeadLean;
	private float rearingAmount;
	private float prevRearingAmount;
	private float mouthOpenness;
	private float prevMouthOpenness;
	protected boolean canGallop = true;
	/** Used to determine the sound that the horse should make when it steps */
	protected int gallopTime;

	public BearDogEntity(EntityType<? extends BearDogEntity> type, World worldIn) {
		super(type, worldIn);
		this.setTamed(false);
		this.initHorseChest();
	}

	protected void registerGoals() {
		this.sitGoal = new SitGoal(this);
		this.goalSelector.addGoal(1, new SwimGoal(this));
		this.goalSelector.addGoal(2, this.sitGoal);
		this.goalSelector.addGoal(3, new BearDogEntity.AvoidEntityGoal(this, LlamaEntity.class, 24.0F, 1.5D, 1.5D));
		this.goalSelector.addGoal(4, new LeapAtTargetGoal(this, 0.4F));
		this.goalSelector.addGoal(5, new MeleeAttackGoal(this, 1.0D, true));
		this.goalSelector.addGoal(6, new FollowOwnerGoal(this, 1.0D, 10.0F, 2.0F, false));
		this.goalSelector.addGoal(7, new BreedGoal(this, 1.0D));
		this.goalSelector.addGoal(8, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
		//this.goalSelector.addGoal(9, new BegGoalMod(this, 8.0F));
		this.goalSelector.addGoal(10, new LookAtGoal(this, PlayerEntity.class, 8.0F));
		this.goalSelector.addGoal(10, new LookRandomlyGoal(this));
		this.targetSelector.addGoal(1, new OwnerHurtByTargetGoal(this));
		this.targetSelector.addGoal(2, new OwnerHurtTargetGoal(this));
		this.targetSelector.addGoal(3, (new HurtByTargetGoal(this)).setCallsForHelp());
		this.targetSelector.addGoal(4, new NonTamedTargetGoal<>(this, AnimalEntity.class, false, TARGET_ENTITIES));
		this.targetSelector.addGoal(4,
				new NonTamedTargetGoal<>(this, TurtleEntity.class, false, TurtleEntity.TARGET_DRY_BABY));
		this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, AbstractSkeletonEntity.class, false));
	}

	protected void registerAttributes() {
		super.registerAttributes();
		this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue((double) 0.3F);
		if (this.isTamed()) {
			this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20.0D);
		} else {
			this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(8.0D);
		}

		this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(2.0D);
		this.getAttributes().registerAttribute(JUMP_STRENGTH);
	}

	/**
	 * Sets the active target the Task system uses for tracking
	 */
	public void setAttackTarget(@Nullable LivingEntity entitylivingbaseIn) {
		super.setAttackTarget(entitylivingbaseIn);
		if (entitylivingbaseIn == null) {
			this.setAngry(false);
		} else if (!this.isTamed()) {
			this.setAngry(true);
		}

	}

	protected void registerData() {
		super.registerData();
		this.dataManager.register(BEGGING, false);
	}

	protected void playStepSound(BlockPos pos, BlockState blockIn) {
		this.playSound(SoundEvents.ENTITY_WOLF_STEP, 0.15F, 1.0F);
	}

	public void writeAdditional(CompoundNBT compound) {
		super.writeAdditional(compound);
		compound.putBoolean("Angry", this.isAngry());
		if (!this.horseChest.getStackInSlot(0).isEmpty()) {
			compound.put("SaddleItem", this.horseChest.getStackInSlot(0).write(new CompoundNBT()));
		}
	}

	/**
	 * (abstract) Protected helper method to read subclass entity data from NBT.
	 */
	public void readAdditional(CompoundNBT compound) {
		super.readAdditional(compound);
		this.setAngry(compound.getBoolean("Angry"));
		IAttributeInstance iattributeinstance = this.getAttributes().getAttributeInstanceByName("Speed");
		if (iattributeinstance != null) {
			this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED)
					.setBaseValue(iattributeinstance.getBaseValue() * 0.25D);
		}

		if (compound.contains("SaddleItem", 10)) {
			ItemStack itemstack = ItemStack.read(compound.getCompound("SaddleItem"));
			if (itemstack.getItem() == Items.SADDLE) {
				this.horseChest.setInventorySlotContents(0, itemstack);
			}
		}

		this.updateHorseSlots();
	}

	protected SoundEvent getAmbientSound() {
		if (this.isAngry()) {
			return SoundEvents.ENTITY_WOLF_GROWL;
		} else if (this.rand.nextInt(3) == 0) {
			return this.isTamed() && this.getHealth() < 10.0F ? SoundEvents.ENTITY_WOLF_WHINE
					: SoundEvents.ENTITY_WOLF_PANT;
		} else {
			return SoundEvents.ENTITY_WOLF_AMBIENT;
		}
	}

	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return SoundEvents.ENTITY_WOLF_HURT;
	}

	protected SoundEvent getDeathSound() {
		return SoundEvents.ENTITY_WOLF_DEATH;
	}

	public boolean canBeSteered() {
		return this.getControllingPassenger() instanceof LivingEntity;
	}

	@OnlyIn(Dist.CLIENT)
	public float getRearingAmount(float p_110223_1_) {
		return MathHelper.lerp(p_110223_1_, this.prevRearingAmount, this.rearingAmount);
	}

	public boolean isHorseSaddled() {
		return this.getHorseWatchableBoolean(4);
	}

	@OnlyIn(Dist.CLIENT)
	public void setJumpPower(int jumpPowerIn) {
		if (this.isHorseSaddled()) {
			if (jumpPowerIn < 0) {
				jumpPowerIn = 0;
			} else {
				this.allowStandSliding = true;
				this.makeHorseRear();
			}

			if (jumpPowerIn >= 90) {
				this.jumpPower = 1.0F;
			} else {
				this.jumpPower = 0.4F + 0.4F * (float) jumpPowerIn / 90.0F;
			}

		}
	}

	public boolean canJump() {
		return this.isHorseSaddled();
	}

	public void handleStartJump(int p_184775_1_) {
		this.allowStandSliding = true;
		this.makeHorseRear();
	}

	public void handleStopJump() {
	}

	public void updatePassenger(Entity passenger) {
		super.updatePassenger(passenger);
		if (passenger instanceof MobEntity) {
			MobEntity mobentity = (MobEntity) passenger;
			this.renderYawOffset = mobentity.renderYawOffset;
		}

		if (this.prevRearingAmount > 0.0F) {
			float f3 = MathHelper.sin(this.renderYawOffset * ((float) Math.PI / 180F));
			float f = MathHelper.cos(this.renderYawOffset * ((float) Math.PI / 180F));
			float f1 = 0.7F * this.prevRearingAmount;
			float f2 = 0.15F * this.prevRearingAmount;
			passenger.setPosition(this.getPosX() + (double) (f1 * f3),
					this.getPosY() + this.getMountedYOffset() + passenger.getYOffset() + (double) f2,
					this.getPosZ() - (double) (f1 * f));
			if (passenger instanceof LivingEntity) {
				((LivingEntity) passenger).renderYawOffset = this.renderYawOffset;
			}
		}

	}

	protected float getModifiedMaxHealth() {
		return 15.0F + (float) this.rand.nextInt(8) + (float) this.rand.nextInt(9);
	}

	/**
	 * Returns randomized jump strength
	 */
	protected double getModifiedJumpStrength() {
		return (double) 0.4F + this.rand.nextDouble() * 0.2D + this.rand.nextDouble() * 0.2D
				+ this.rand.nextDouble() * 0.2D;
	}

	/**
	 * Returns randomized movement speed
	 */
	protected double getModifiedMovementSpeed() {
		return ((double) 0.45F + this.rand.nextDouble() * 0.3D + this.rand.nextDouble() * 0.3D
				+ this.rand.nextDouble() * 0.3D) * 0.25D;
	}

	/**
	 * Returns the volume for the sounds this mob makes.
	 */
	protected float getSoundVolume() {
		return 0.4F;
	}

	public boolean wearsArmor() {
		return false;
	}

	public boolean isArmor(ItemStack stack) {
		return false;
	}

	public boolean replaceItemInInventory(int inventorySlot, ItemStack itemStackIn) {
		int i = inventorySlot - 400;
		if (i >= 0 && i < 2 && i < this.horseChest.getSizeInventory()) {
			if (i == 0 && itemStackIn.getItem() != Items.SADDLE) {
				return false;
			} else if (i != 1 || this.wearsArmor() && this.isArmor(itemStackIn)) {
				this.horseChest.setInventorySlotContents(i, itemStackIn);
				this.updateHorseSlots();
				return true;
			} else {
				return false;
			}
		} else {
			int j = inventorySlot - 500 + 2;
			if (j >= 2 && j < this.horseChest.getSizeInventory()) {
				this.horseChest.setInventorySlotContents(j, itemStackIn);
				return true;
			} else {
				return false;
			}
		}
	}

	@Nullable
	public Entity getControllingPassenger() {
		return this.getPassengers().isEmpty() ? null : this.getPassengers().get(0);
	}

	private net.minecraftforge.common.util.LazyOptional<?> itemHandler = null;

	@Override
	public <T> net.minecraftforge.common.util.LazyOptional<T> getCapability(
			net.minecraftforge.common.capabilities.Capability<T> capability,
			@Nullable net.minecraft.util.Direction facing) {
		if (this.isAlive() && capability == net.minecraftforge.items.CapabilityItemHandler.ITEM_HANDLER_CAPABILITY
				&& itemHandler != null)
			return itemHandler.cast();
		return super.getCapability(capability, facing);
	}

	@Override
	public void remove(boolean keepData) {
		super.remove(keepData);
		if (!keepData && itemHandler != null) {
			itemHandler.invalidate();
			itemHandler = null;
		}
	}

	/**
	 * Called frequently so the entity can update its state every tick as required.
	 * For example, zombies and skeletons use this to react to sunlight and start to
	 * burn.
	 */
	public void livingTick() {
		super.livingTick();
		if (!this.world.isRemote && this.isWet && !this.isShaking && !this.hasPath() && this.onGround) {
			this.isShaking = true;
			this.timeWolfIsShaking = 0.0F;
			this.prevTimeWolfIsShaking = 0.0F;
			this.world.setEntityState(this, (byte) 8);
		}

		if (!this.world.isRemote && this.getAttackTarget() == null && this.isAngry()) {
			this.setAngry(false);
		}

	}

	/**
	 * Called to update the entity's position/logic.
	 */
	public void tick() {
		super.tick();
		if (this.isAlive()) {
			this.headRotationCourseOld = this.headRotationCourse;
			if (this.isBegging()) {
				this.headRotationCourse += (1.0F - this.headRotationCourse) * 0.4F;
			} else {
				this.headRotationCourse += (0.0F - this.headRotationCourse) * 0.4F;
			}

			if (this.isInWaterRainOrBubbleColumn()) {
				this.isWet = true;
				this.isShaking = false;
				this.timeWolfIsShaking = 0.0F;
				this.prevTimeWolfIsShaking = 0.0F;
			} else if ((this.isWet || this.isShaking) && this.isShaking) {
				if (this.timeWolfIsShaking == 0.0F) {
					this.playSound(SoundEvents.ENTITY_WOLF_SHAKE, this.getSoundVolume(),
							(this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F);
				}

				this.prevTimeWolfIsShaking = this.timeWolfIsShaking;
				this.timeWolfIsShaking += 0.05F;
				if (this.prevTimeWolfIsShaking >= 2.0F) {
					this.isWet = false;
					this.isShaking = false;
					this.prevTimeWolfIsShaking = 0.0F;
					this.timeWolfIsShaking = 0.0F;
				}

				if (this.timeWolfIsShaking > 0.4F) {
					float f = (float) this.getPosY();
					int i = (int) (MathHelper.sin((this.timeWolfIsShaking - 0.4F) * (float) Math.PI) * 7.0F);
					Vec3d vec3d = this.getMotion();

					for (int j = 0; j < i; ++j) {
						float f1 = (this.rand.nextFloat() * 2.0F - 1.0F) * this.getWidth() * 0.5F;
						float f2 = (this.rand.nextFloat() * 2.0F - 1.0F) * this.getWidth() * 0.5F;
						this.world.addParticle(ParticleTypes.SPLASH, this.getPosX() + (double) f1, (double) (f + 0.8F),
								this.getPosZ() + (double) f2, vec3d.x, vec3d.y, vec3d.z);
					}
				}
			}

		}
	}

	/**
	 * Called when the mob's health reaches 0.
	 */
	public void onDeath(DamageSource cause) {
		this.isWet = false;
		this.isShaking = false;
		this.prevTimeWolfIsShaking = 0.0F;
		this.timeWolfIsShaking = 0.0F;
		super.onDeath(cause);
	}

	/**
	 * True if the wolf is wet
	 */
	@OnlyIn(Dist.CLIENT)
	public boolean isWolfWet() {
		return this.isWet;
	}

	/**
	 * Used when calculating the amount of shading to apply while the wolf is wet.
	 */
	@OnlyIn(Dist.CLIENT)
	public float getShadingWhileWet(float p_70915_1_) {
		return 0.75F + MathHelper.lerp(p_70915_1_, this.prevTimeWolfIsShaking, this.timeWolfIsShaking) / 2.0F * 0.25F;
	}

	@OnlyIn(Dist.CLIENT)
	public float getShakeAngle(float p_70923_1_, float p_70923_2_) {
		float f = (MathHelper.lerp(p_70923_1_, this.prevTimeWolfIsShaking, this.timeWolfIsShaking) + p_70923_2_) / 1.8F;
		if (f < 0.0F) {
			f = 0.0F;
		} else if (f > 1.0F) {
			f = 1.0F;
		}

		return MathHelper.sin(f * (float) Math.PI) * MathHelper.sin(f * (float) Math.PI * 11.0F) * 0.15F
				* (float) Math.PI;
	}

	@OnlyIn(Dist.CLIENT)
	public float getInterestedAngle(float p_70917_1_) {
		return MathHelper.lerp(p_70917_1_, this.headRotationCourseOld, this.headRotationCourse) * 0.15F
				* (float) Math.PI;
	}

	protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
		return sizeIn.height * 0.8F;
	}

	/**
	 * The speed it takes to move the entityliving's rotationPitch through the
	 * faceEntity method. This is only currently use in wolves.
	 */
	public int getVerticalFaceSpeed() {
		return this.isSitting() ? 20 : super.getVerticalFaceSpeed();
	}

	/**
	 * Called when the entity is attacked.
	 */
	public boolean attackEntityFrom(DamageSource source, float amount) {
		if (this.isInvulnerableTo(source)) {
			return false;
		} else {
			Entity entity = source.getTrueSource();
			if (this.sitGoal != null) {
				this.sitGoal.setSitting(false);
			}

			if (entity != null && !(entity instanceof PlayerEntity) && !(entity instanceof AbstractArrowEntity)) {
				amount = (amount + 1.0F) / 2.0F;
			}

			return super.attackEntityFrom(source, amount);
		}
	}

	public boolean attackEntityAsMob(Entity entityIn) {
		boolean flag = entityIn.attackEntityFrom(DamageSource.causeMobDamage(this),
				(float) ((int) this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getValue()));
		if (flag) {
			this.applyEnchantments(this, entityIn);
		}

		return flag;
	}

	public void setTamed(boolean tamed) {
		super.setTamed(tamed);
		if (tamed) {
			this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20.0D);
			this.setHealth(20.0F);
		} else {
			this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(8.0D);
		}

		this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(4.0D);
	}

	public boolean processInteract(PlayerEntity player, Hand hand) {
		ItemStack itemstack = player.getHeldItem(hand);
		Item item = itemstack.getItem();
		if (itemstack.getItem() instanceof SpawnEggItem) {
			return super.processInteract(player, hand);
		} else if (this.world.isRemote) {
			return this.isOwner(player) || item == Items.BONE && !this.isAngry();
		} else {
			if (this.isTamed()) {
				if (item.isFood() && item.getFood().isMeat() && this.getHealth() < this.getMaxHealth()) {
					if (!player.abilities.isCreativeMode) {
						itemstack.shrink(1);
					}

					this.heal((float) item.getFood().getHealing());
					return true;
				}

				if (!(item instanceof DyeItem)) {
					boolean flag = super.processInteract(player, hand);
					if (!flag || this.isChild()) {
						this.sitGoal.setSitting(!this.isSitting());
					}

					return flag;
				}

				if (this.isOwner(player) && !this.isBreedingItem(itemstack)) {
					this.sitGoal.setSitting(!this.isSitting());
					this.isJumping = false;
					this.navigator.clearPath();
					this.setAttackTarget((LivingEntity) null);
				}
			} else if (item == Items.BONE && !this.isAngry()) {
				if (!player.abilities.isCreativeMode) {
					itemstack.shrink(1);
				}

				if (this.rand.nextInt(3) == 0
						&& !net.minecraftforge.event.ForgeEventFactory.onAnimalTame(this, player)) {
					this.setTamedBy(player);
					this.navigator.clearPath();
					this.setAttackTarget((LivingEntity) null);
					this.sitGoal.setSitting(true);
					this.world.setEntityState(this, (byte) 7);
				} else {
					this.world.setEntityState(this, (byte) 6);
				}

				return true;
			}

			return super.processInteract(player, hand);
		}
	}

	/**
	 * Handler for {@link World#setEntityState}
	 */
	@OnlyIn(Dist.CLIENT)
	public void handleStatusUpdate(byte id) {
		if (id == 8) {
			this.isShaking = true;
			this.timeWolfIsShaking = 0.0F;
			this.prevTimeWolfIsShaking = 0.0F;
		} else {
			super.handleStatusUpdate(id);
		}

	}

	@OnlyIn(Dist.CLIENT)
	public float getTailRotation() {
		if (this.isAngry()) {
			return 1.5393804F;
		} else {
			return this.isTamed() ? (0.55F - (this.getMaxHealth() - this.getHealth()) * 0.02F) * (float) Math.PI
					: ((float) Math.PI / 5F);
		}
	}

	/**
	 * Checks if the parameter is an item which this animal can be fed to breed it
	 * (wheat, carrots or seeds depending on the animal type)
	 */
	public boolean isBreedingItem(ItemStack stack) {
		Item item = stack.getItem();
		return item.isFood() && item.getFood().isMeat();
	}

	/**
	 * Will return how many at most can spawn in a chunk at once.
	 */
	public int getMaxSpawnedInChunk() {
		return 8;
	}

	/**
	 * Determines whether this wolf is angry or not.
	 */
	public boolean isAngry() {
		return (this.dataManager.get(TAMED) & 2) != 0;
	}

	/**
	 * Sets whether this wolf is angry or not.
	 */
	public void setAngry(boolean angry) {
		byte b0 = this.dataManager.get(TAMED);
		if (angry) {
			this.dataManager.set(TAMED, (byte) (b0 | 2));
		} else {
			this.dataManager.set(TAMED, (byte) (b0 & -3));
		}

	}

	public WolfEntity createChild(AgeableEntity ageable) {
		WolfEntity wolfentity = EntityType.WOLF.create(this.world);
		UUID uuid = this.getOwnerId();
		if (uuid != null) {
			wolfentity.setOwnerId(uuid);
			wolfentity.setTamed(true);
		}

		return wolfentity;
	}

	public void setBegging(boolean beg) {
		this.dataManager.set(BEGGING, beg);
	}

	/**
	 * Returns true if the mob is currently able to mate with the specified mob.
	 */
	public boolean canMateWith(AnimalEntity otherAnimal) {
		if (otherAnimal == this) {
			return false;
		} else if (!this.isTamed()) {
			return false;
		} else if (!(otherAnimal instanceof BearDogEntity)) {
			return false;
		} else {
			BearDogEntity wolfentity = (BearDogEntity) otherAnimal;
			if (!wolfentity.isTamed()) {
				return false;
			} else if (wolfentity.isSitting()) {
				return false;
			} else {
				return this.isInLove() && wolfentity.isInLove();
			}
		}
	}

	public boolean isBegging() {
		return this.dataManager.get(BEGGING);
	}

	public boolean shouldAttackEntity(LivingEntity target, LivingEntity owner) {
		if (!(target instanceof CreeperEntity) && !(target instanceof GhastEntity)) {
			if (target instanceof BearDogEntity) {
				BearDogEntity wolfentity = (BearDogEntity) target;
				return !wolfentity.isTamed() || wolfentity.getOwner() != owner;
			} else if (target instanceof PlayerEntity && owner instanceof PlayerEntity
					&& !((PlayerEntity) owner).canAttackPlayer((PlayerEntity) target)) {
				return false;
			} else if (target instanceof BearDogEntity && ((BearDogEntity) target).isTamed()) {
				return false;
			} else {
				return !(target instanceof TameableEntity) || !((TameableEntity) target).isTamed();
			}
		} else {
			return false;
		}
	}

	public boolean canBeLeashedTo(PlayerEntity player) {
		return !this.isAngry() && super.canBeLeashedTo(player);
	}

	public boolean isHorseJumping() {
		return this.horseJumping;
	}

	public void setHorseJumping(boolean jumping) {
		this.horseJumping = jumping;
	}

	public boolean isRearing() {
		return this.getHorseWatchableBoolean(32);
	}

	protected boolean getHorseWatchableBoolean(int p_110233_1_) {
		return (this.dataManager.get(STATUS) & p_110233_1_) != 0;
	}

	protected void setHorseWatchableBoolean(int p_110208_1_, boolean p_110208_2_) {
		byte b0 = this.dataManager.get(STATUS);
		if (p_110208_2_) {
			this.dataManager.set(STATUS, (byte) (b0 | p_110208_1_));
		} else {
			this.dataManager.set(STATUS, (byte) (b0 & ~p_110208_1_));
		}

	}

	/**
	 * Called when the entity is attacked.
	 */

	/**
	 * Returns true if this entity should push and be pushed by other entities when
	 * colliding.
	 */
	public boolean canBePushed() {
		return !this.isBeingRidden();
	}

	public boolean onLivingFall(float distance, float damageMultiplier) {
		if (distance > 1.0F) {
			this.playSound(SoundEvents.ENTITY_HORSE_LAND, 0.4F, 1.0F);
		}

		int i = this.calculateFallDamage(distance, damageMultiplier);
		if (i <= 0) {
			return false;
		} else {
			this.attackEntityFrom(DamageSource.FALL, (float) i);
			if (this.isBeingRidden()) {
				for (Entity entity : this.getRecursivePassengers()) {
					entity.attackEntityFrom(DamageSource.FALL, (float) i);
				}
			}

			this.playFallSound();
			return true;
		}
	}

	protected int calculateFallDamage(float p_225508_1_, float p_225508_2_) {
		return MathHelper.ceil((p_225508_1_ * 0.5F - 3.0F) * p_225508_2_);
	}

	/**
	 * Updates the items in the saddle and armor slots of the horse's inventory.
	 */
	protected void updateHorseSlots() {
		if (!this.world.isRemote) {
			this.setHorseSaddled(!this.horseChest.getStackInSlot(0).isEmpty() && this.canBeSaddled());
		}
	}

	public void setHorseSaddled(boolean saddled) {
		this.setHorseWatchableBoolean(4, saddled);
	}

	public boolean canBeSaddled() {
		return true;
	}

	/**
	 * Called by InventoryBasic.onInventoryChanged() on a array that is never
	 * filled.
	 */
	public void onInventoryChanged(IInventory invBasic) {
		boolean flag = this.isHorseSaddled();
		this.updateHorseSlots();
		if (this.ticksExisted > 20 && !flag && this.isHorseSaddled()) {
			this.playSound(SoundEvents.ENTITY_HORSE_SADDLE, 0.5F, 1.0F);
		}

	}

	public double getHorseJumpStrength() {
		return this.getAttribute(JUMP_STRENGTH).getValue();
	}

	protected int getInventorySize() {
		return 2;
	}

	protected void initHorseChest() {
		Inventory inventory = this.horseChest;
		this.horseChest = new Inventory(this.getInventorySize());
		if (inventory != null) {
			inventory.removeListener(this);
			int i = Math.min(inventory.getSizeInventory(), this.horseChest.getSizeInventory());

			for (int j = 0; j < i; ++j) {
				ItemStack itemstack = inventory.getStackInSlot(j);
				if (!itemstack.isEmpty()) {
					this.horseChest.setInventorySlotContents(j, itemstack.copy());
				}
			}
		}

		this.horseChest.addListener(this);
		this.updateHorseSlots();
		this.itemHandler = net.minecraftforge.common.util.LazyOptional
				.of(() -> new net.minecraftforge.items.wrapper.InvWrapper(this.horseChest));
	}

	public void openGUI(PlayerEntity playerEntity) {
		if (!this.world.isRemote && (!this.isBeingRidden() || this.isPassenger(playerEntity)) && this.isTamed()) {
			this.openHorseInventory(this, this.horseChest);
		}

	}

	public void openHorseInventory(BearDogEntity horse, IInventory inventoryIn) {
	}

	protected void mountTo(PlayerEntity player) {
		if (!this.world.isRemote) {
			player.rotationYaw = this.rotationYaw;
			player.rotationPitch = this.rotationPitch;
			player.startRiding(this);
		}

	}

	private void makeHorseRear() {
		if (this.canPassengerSteer() || this.isServerWorld()) {
			this.jumpRearingCounter = 1;
			this.setRearing(true);
		}

	}

	public void setRearing(boolean rearing) {
		if (rearing) {
		//this.setEatingHaystack(false);
		}

		this.setHorseWatchableBoolean(32, rearing);
	}

	protected boolean isMovementBlocked() {
		return super.isMovementBlocked() && this.isBeingRidden() && this.isHorseSaddled()
				|| this.isRearing();
	}

	protected void dropInventory() {
		super.dropInventory();
		if (this.horseChest != null) {
			for (int i = 0; i < this.horseChest.getSizeInventory(); ++i) {
				ItemStack itemstack = this.horseChest.getStackInSlot(i);
				if (!itemstack.isEmpty() && !EnchantmentHelper.hasVanishingCurse(itemstack)) {
					this.entityDropItem(itemstack);
				}
			}

		}
	}

	public void travel(Vec3d p_213352_1_) {
		if (this.isAlive()) {
			if (this.isBeingRidden() && this.canBeSteered() && this.isHorseSaddled()) {
				LivingEntity livingentity = (LivingEntity) this.getControllingPassenger();
				this.rotationYaw = livingentity.rotationYaw;
				this.prevRotationYaw = this.rotationYaw;
				this.rotationPitch = livingentity.rotationPitch * 0.5F;
				this.setRotation(this.rotationYaw, this.rotationPitch);
				this.renderYawOffset = this.rotationYaw;
				this.rotationYawHead = this.renderYawOffset;
				float f = livingentity.moveStrafing * 0.5F;
				float f1 = livingentity.moveForward;
				if (f1 <= 0.0F) {
					f1 *= 0.25F;
					this.gallopTime = 0;
				}

				if (this.onGround && this.jumpPower == 0.0F && this.isRearing() && !this.allowStandSliding) {
					f = 0.0F;
					f1 = 0.0F;
				}

				if (this.jumpPower > 0.0F && !this.isHorseJumping() && this.onGround) {
					double d0 = this.getHorseJumpStrength() * (double) this.jumpPower * (double) this.getJumpFactor();
					double d1;
					if (this.isPotionActive(Effects.JUMP_BOOST)) {
						d1 = d0 + (double) ((float) (this.getActivePotionEffect(Effects.JUMP_BOOST).getAmplifier() + 1)
								* 0.1F);
					} else {
						d1 = d0;
					}

					Vec3d vec3d = this.getMotion();
					this.setMotion(vec3d.x, d1, vec3d.z);
					this.setHorseJumping(true);
					this.isAirBorne = true;
					if (f1 > 0.0F) {
						float f2 = MathHelper.sin(this.rotationYaw * ((float) Math.PI / 180F));
						float f3 = MathHelper.cos(this.rotationYaw * ((float) Math.PI / 180F));
						this.setMotion(this.getMotion().add((double) (-0.4F * f2 * this.jumpPower), 0.0D,
								(double) (0.4F * f3 * this.jumpPower)));
						// this.playJumpSound();
					}

					this.jumpPower = 0.0F;
				}

				this.jumpMovementFactor = this.getAIMoveSpeed() * 0.1F;
				if (this.canPassengerSteer()) {
					this.setAIMoveSpeed((float) this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getValue());
					super.travel(new Vec3d((double) f, p_213352_1_.y, (double) f1));
				} else if (livingentity instanceof PlayerEntity) {
					this.setMotion(Vec3d.ZERO);
				}

				if (this.onGround) {
					this.jumpPower = 0.0F;
					this.setHorseJumping(false);
				}

				this.prevLimbSwingAmount = this.limbSwingAmount;
				double d2 = this.getPosX() - this.prevPosX;
				double d3 = this.getPosZ() - this.prevPosZ;
				float f4 = MathHelper.sqrt(d2 * d2 + d3 * d3) * 4.0F;
				if (f4 > 1.0F) {
					f4 = 1.0F;
				}

				this.limbSwingAmount += (f4 - this.limbSwingAmount) * 0.4F;
				this.limbSwing += this.limbSwingAmount;
			} else {
				this.jumpMovementFactor = 0.02F;
				super.travel(p_213352_1_);
			}
		}
	}

	class AvoidEntityGoal<T extends LivingEntity> extends net.minecraft.entity.ai.goal.AvoidEntityGoal<T> {
		private final BearDogEntity wolf;

		public AvoidEntityGoal(BearDogEntity wolfIn, Class<T> entityClassToAvoidIn, float avoidDistanceIn,
				double farSpeedIn, double nearSpeedIn) {
			super(wolfIn, entityClassToAvoidIn, avoidDistanceIn, farSpeedIn, nearSpeedIn);
			this.wolf = wolfIn;
		}

		/**
		 * Returns whether execution should begin. You can also read and cache any state
		 * necessary for execution in this method as well.
		 */
		public boolean shouldExecute() {
			if (super.shouldExecute() && this.avoidTarget instanceof LlamaEntity) {
				return !this.wolf.isTamed() && this.avoidLlama((LlamaEntity) this.avoidTarget);
			} else {
				return false;
			}
		}

		private boolean avoidLlama(LlamaEntity llamaIn) {
			return llamaIn.getStrength() >= BearDogEntity.this.rand.nextInt(5);
		}

		/**
		 * Execute a one shot task or start executing a continuous task
		 */
		public void startExecuting() {
			BearDogEntity.this.setAttackTarget((LivingEntity) null);
			super.startExecuting();
		}

		/**
		 * Keep ticking a continuous task that has already been started
		 */
		public void tick() {
			BearDogEntity.this.setAttackTarget((LivingEntity) null);
			super.tick();
		}
	}
}