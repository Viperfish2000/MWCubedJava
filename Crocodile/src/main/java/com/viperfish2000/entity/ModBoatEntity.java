package com.viperfish2000.entity;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ChestBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.item.BoatEntity;
import net.minecraft.entity.item.minecart.AbstractMinecartEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.fluid.IFluidState;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.inventory.container.ChestContainer;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.network.play.client.CSteerBoatPacket;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Direction;
import net.minecraft.util.EntityPredicates;
import net.minecraft.util.Hand;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.GameRules;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.storage.loot.LootContext;
import net.minecraft.world.storage.loot.LootParameterSets;
import net.minecraft.world.storage.loot.LootParameters;
import net.minecraft.world.storage.loot.LootTable;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.network.FMLPlayMessages;
import net.minecraftforge.fml.network.NetworkHooks;

public class ModBoatEntity extends BoatEntity implements IInventory, INamedContainerProvider{
  private static final DataParameter<Integer> DATA_ID_HURT = EntityDataManager.createKey(BoatEntity.class, DataSerializers.VARINT);
  
  private static final DataParameter<Integer> DATA_ID_HURTDIR = EntityDataManager.createKey(BoatEntity.class, DataSerializers.VARINT);
  
  private static final DataParameter<Float> DATA_ID_DAMAGE = EntityDataManager.createKey(BoatEntity.class, DataSerializers.FLOAT);
  
  private static final DataParameter<Integer> DATA_ID_TYPE = EntityDataManager.createKey(BoatEntity.class, DataSerializers.VARINT);
  
  private static final DataParameter<Boolean> DATA_ID_PADDLE_LEFT = EntityDataManager.createKey(BoatEntity.class, DataSerializers.BOOLEAN);
  
  private static final DataParameter<Boolean> DATA_ID_PADDLE_RIGHT = EntityDataManager.createKey(BoatEntity.class, DataSerializers.BOOLEAN);
  
  private static final DataParameter<Integer> DATA_ID_BUBBLE_TIME = EntityDataManager.createKey(BoatEntity.class, DataSerializers.VARINT);
  
  private final float[] paddlePositions = new float[2];
  
  private float invFriction;
  
  private float outOfControlTicks;
  
  private float deltaRotation;
  
  private int lerpSteps;
  
  private double lerpX;
  
  private double lerpY;
  
  private double lerpZ;
  
  private double lerpYRot;
  
  private double lerpXRot;

  private double lerpYaw;

  private double lerpPitch;
  private boolean inputLeft;
  
  private boolean inputRight;
  
  private boolean inputUp;
  
  private boolean inputDown;
  
  private double waterLevel;
  
  private float landFriction;
  
  private BoatEntity.Status status;
  
  private BoatEntity.Status oldStatus;
  
  private double lastYd;
  
  private boolean isAboveBubbleColumn;
  
  private boolean bubbleColumnDirectionIsDown;
  
  private float bubbleMultiplier;
  
  private float bubbleAngle;
  
  private float bubbleAngleO;
  
  public ModBoatEntity(EntityType<? extends BoatEntity> p_i50129_1_, World p_i50129_2_) {
    super(p_i50129_1_, p_i50129_2_);
    this.preventEntitySpawning = true;
  }
  
  public ModBoatEntity(World worldIn, double x, double y, double z) {
    this(CrocodileEntities.BOAT, worldIn);
    setPosition(x, y, z);
    setMotion(Vec3d.ZERO);
    this.prevPosX = x;
    this.prevPosY = y;
    this.prevPosZ = z;
  }
  
  public ModBoatEntity(FMLPlayMessages.SpawnEntity spawnEntity, World world) {
    this(CrocodileEntities.BOAT, world);
  }
  
  protected boolean canTriggerWalking() {
    return false;
  }
  
  protected void registerData() {
    this.dataManager.register(DATA_ID_HURT, Integer.valueOf(0));
    this.dataManager.register(DATA_ID_HURTDIR, Integer.valueOf(1));
    this.dataManager.register(DATA_ID_DAMAGE, Float.valueOf(0.0F));
    this.dataManager.register(DATA_ID_TYPE, Integer.valueOf(BoatEntity.Type.OAK.ordinal()));
    this.dataManager.register(DATA_ID_PADDLE_LEFT, Boolean.valueOf(false));
    this.dataManager.register(DATA_ID_PADDLE_RIGHT, Boolean.valueOf(false));
    this.dataManager.register(DATA_ID_BUBBLE_TIME, Integer.valueOf(0));
  }
  
  @Nullable
  public AxisAlignedBB getCollisionBox(Entity entityIn) {
    return entityIn.canBePushed() ? entityIn.getBoundingBox() : null;
  }
  
  @Nullable
  public AxisAlignedBB getCollisionBoundingBox() {
    return getBoundingBox();
  }
  
  public boolean canBePushed() {
    return true;
  }
  
  public double getMountedYOffset() {
    return -0.1D;
  }
  
  public boolean attackEntityFrom(DamageSource source, float amount) {
    if (isInvulnerableTo(source))
      return false; 
    if (!this.world.isRemote && !this.removed) {
      if (source instanceof net.minecraft.util.IndirectEntityDamageSource && source.getTrueSource() != null && isPassenger(source.getTrueSource()))
        return false; 
      setForwardDirection(-getForwardDirection());
      setTimeSinceHit(10);
      setDamageTaken(getDamageTaken() + amount * 10.0F);
      markVelocityChanged();
      boolean flag = (source.getTrueSource() instanceof PlayerEntity && ((PlayerEntity)source.getTrueSource()).abilities.isCreativeMode);
      if (flag || getDamageTaken() > 40.0F) {
        if (!flag && this.world.getGameRules().getBoolean(GameRules.DO_ENTITY_DROPS))
          entityDropItem((IItemProvider)getItemBoat()); 
        remove();
      } 
      return true;
    } 
    return true;
  }
  
  public void onEnterBubbleColumnWithAirAbove(boolean downwards) {
    if (!this.world.isRemote) {
      this.isAboveBubbleColumn = true;
      this.bubbleColumnDirectionIsDown = downwards;
      if (getBubbleTime() == 0)
        setBubbleTime(60); 
    } 
    this.world.addParticle((IParticleData)ParticleTypes.SPLASH, getPosX() + this.rand.nextFloat(), getPosY() + 0.7D, getPosZ() + this.rand.nextFloat(), 0.0D, 0.0D, 0.0D);
    if (this.rand.nextInt(20) == 0)
      this.world.playSound(getPosX(), getPosY(), getPosZ(), getSplashSound(), getSoundCategory(), 1.0F, 0.8F + 0.4F * this.rand.nextFloat(), false); 
  }
  
  public Item getItemBoat() {
    switch (getBoatModel()) {
      default:
        return Items.OAK_BOAT;
    }
  }
  
  @OnlyIn(Dist.CLIENT)
  public void performHurtAnimation() {
    setForwardDirection(-getForwardDirection());
    setTimeSinceHit(10);
    setDamageTaken(getDamageTaken() * 11.0F);
  }
  
  public boolean canBeCollidedWith() {
    return !this.removed;
  }
  
  @OnlyIn(Dist.CLIENT)
  public void setPositionAndRotationDirect(double x, double y, double z, float yaw, float pitch, int posRotationIncrements, boolean teleport) {
    this.lerpX = x;
    this.lerpY = y;
    this.lerpZ = z;
    this.lerpYRot = yaw;
    this.lerpXRot = pitch;
    this.lerpSteps = 10;
  }
  
  public Direction getAdjustedHorizontalFacing() {
    return getHorizontalFacing().rotateY();
  }

  public void tick() {
    this.oldStatus = this.status;
    this.status = getStatus();
    if (this.status != BoatEntity.Status.UNDER_WATER && this.status != BoatEntity.Status.UNDER_FLOWING_WATER) {
      this.outOfControlTicks = 0.0F;
    } else {
      this.outOfControlTicks++;
    } 
    if (!this.world.isRemote && this.outOfControlTicks >= 60.0F)
      removePassengers(); 
    if (getTimeSinceHit() > 0)
      setTimeSinceHit(getTimeSinceHit() - 1); 
    if (getDamageTaken() > 0.0F)
      setDamageTaken(getDamageTaken() - 1.0F); 
    if (!this.world.isRemote)
      setFlag(6, isGlowing()); 
    baseTick();
    tickLerp();
    if (canPassengerSteer()) {
      if (getPassengers().isEmpty() || !(getPassengers().get(0) instanceof PlayerEntity))
        setPaddleState(false, false); 
      floatBoat();
      if (this.world.isRemote) {
        controlBoat();
        this.world.sendPacketToServer((IPacket)new CSteerBoatPacket(getPaddleState(0), getPaddleState(1)));
      } 
      move(MoverType.SELF, getMotion());
    } else {
      setMotion(Vec3d.ZERO);
    } 
    tickBubbleColumn();
    for (int i = 0; i <= 1; i++) {
      if (getPaddleState(i)) {
        if (!isSilent() && (this.paddlePositions[i] % 6.2831855F) <= 0.7853981852531433D && (this.paddlePositions[i] + 0.39269909262657166D) % 6.2831854820251465D >= 0.7853981852531433D) {
          SoundEvent soundevent = getPaddleSound();
          if (soundevent != null) {
            Vec3d vec3d = getLook(1.0F);
            double d0 = (i == 1) ? -vec3d.z : vec3d.z;
            double d1 = (i == 1) ? vec3d.x : -vec3d.x;
            this.world.playSound((PlayerEntity)null, getPosX() + d0, getPosY(), getPosZ() + d1, soundevent, getSoundCategory(), 1.0F, 0.8F + 0.4F * this.rand.nextFloat());
          } 
        } 
        this.paddlePositions[i] = (float)(this.paddlePositions[i] + 0.39269909262657166D);
      } else {
        this.paddlePositions[i] = 0.0F;
      } 
    } 
    doBlockCollisions();
    List<Entity> list = this.world.getEntitiesInAABBexcluding((Entity)this, getBoundingBox().grow(0.20000000298023224D, -0.009999999776482582D, 0.20000000298023224D), EntityPredicates.pushableBy((Entity)this));
    if (!list.isEmpty()) {
      boolean flag = (!this.world.isRemote && !(getControllingPassenger() instanceof PlayerEntity));
      for (int j = 0; j < list.size(); j++) {
        Entity entity = list.get(j);
        if (!entity.isPassenger((Entity)this))
          if (flag && getPassengers().size() < 2 && !entity.isPassenger() && entity.getWidth() < getWidth() && entity instanceof net.minecraft.entity.LivingEntity && !(entity instanceof net.minecraft.entity.passive.WaterMobEntity) && !(entity instanceof PlayerEntity)) {
            entity.startRiding((Entity)this);
          } else {
            applyEntityCollision(entity);
          }  
      } 
    } 
  }
  
  private void tickBubbleColumn() {
    if (this.world.isRemote) {
      int i = getBubbleTime();
      if (i > 0) {
        this.bubbleMultiplier += 0.05F;
      } else {
        this.bubbleMultiplier -= 0.1F;
      } 
      this.bubbleMultiplier = MathHelper.clamp(this.bubbleMultiplier, 0.0F, 1.0F);
      this.bubbleAngleO = this.bubbleAngle;
      this.bubbleAngle = 10.0F * (float)Math.sin((0.5F * (float)this.world.getGameTime())) * this.bubbleMultiplier;
    } else {
      if (!this.isAboveBubbleColumn)
        setBubbleTime(0); 
      int k = getBubbleTime();
      if (k > 0) {
        k--;
        setBubbleTime(k);
        int j = 60 - k - 1;
        if (j > 0 && k == 0) {
          setBubbleTime(0);
          Vec3d vec3d = getMotion();
          if (this.bubbleColumnDirectionIsDown) {
            setMotion(vec3d.add(0.0D, -0.7D, 0.0D));
            removePassengers();
          } else {
            setMotion(vec3d.x, isPassenger(PlayerEntity.class) ? 2.7D : 0.6D, vec3d.z);
          } 
        } 
        this.isAboveBubbleColumn = false;
      } 
    } 
  }
  
  @Nullable
  protected SoundEvent getPaddleSound() {
    switch (getStatus()) {
      case IN_WATER:
      case UNDER_WATER:
      case UNDER_FLOWING_WATER:
        return SoundEvents.ENTITY_BOAT_PADDLE_WATER;
      case ON_LAND:
        return SoundEvents.ENTITY_BOAT_PADDLE_LAND;
    } 
    return null;
  }
  
  protected void tickLerp() {
    if (canPassengerSteer()) {
      this.lerpSteps = 0;
      setPacketCoordinates(getPosX(), getPosY(), getPosZ());
    } 
    if (this.lerpSteps > 0) {
      double d0 = getPosX() + (this.lerpX - getPosX()) / this.lerpSteps;
      double d1 = getPosY() + (this.lerpY - getPosY()) / this.lerpSteps;
      double d2 = getPosZ() + (this.lerpZ - getPosZ()) / this.lerpSteps;
      double d3 = MathHelper.wrapDegrees(this.lerpYRot - this.rotationYaw);
      this.rotationYaw = (float)(this.rotationYaw + d3 / this.lerpSteps);
      this.rotationPitch = (float)(this.rotationPitch + (this.lerpXRot - this.rotationPitch) / this.lerpSteps);
      this.lerpSteps--;
      setPosition(d0, d1, d2);
      setRotation(this.rotationYaw, this.rotationPitch);
    } 
  }
  
  public void setPaddleState(boolean left, boolean right) {
    this.dataManager.set(DATA_ID_PADDLE_LEFT, Boolean.valueOf(left));
    this.dataManager.set(DATA_ID_PADDLE_RIGHT, Boolean.valueOf(right));
  }
  
  @OnlyIn(Dist.CLIENT)
  public float getRowingTime(int side, float limbSwing) {
    return getPaddleState(side) ? (float)MathHelper.clampedLerp(this.paddlePositions[side] - 0.39269909262657166D, this.paddlePositions[side], limbSwing) : 0.0F;
  }
  
  private BoatEntity.Status getStatus() {
    BoatEntity.Status boatentity$status = isUnderwater();
    if (boatentity$status != null) {
      this.waterLevel = (getBoundingBox()).maxY;
      return boatentity$status;
    } 
    if (checkInWater())
      return BoatEntity.Status.IN_WATER; 
    float f = getBoatGlide();
    if (f > 0.0F) {
      this.landFriction = f;
      return BoatEntity.Status.ON_LAND;
    } 
    return BoatEntity.Status.IN_AIR;
  }
  
  public float getWaterLevelAbove() {
    AxisAlignedBB axisalignedbb = getBoundingBox();
    int i = MathHelper.floor(axisalignedbb.maxZ);
    int j = MathHelper.ceil(axisalignedbb.maxX);
    int k = MathHelper.floor(axisalignedbb.maxY);
    int l = MathHelper.ceil(axisalignedbb.maxY - this.lastYd);
    int i1 = MathHelper.floor(axisalignedbb.minZ);
    int j1 = MathHelper.ceil(axisalignedbb.maxZ);
    try (BlockPos.PooledMutable blockpos$pooledmutable = BlockPos.PooledMutable.retain()) {
        label161:
        for(int k1 = k; k1 < l; ++k1) {
           float f = 0.0F;

           for(int l1 = i; l1 < j; ++l1) {
              for(int i2 = i1; i2 < j1; ++i2) {
                 blockpos$pooledmutable.setPos(l1, k1, i2);
                 IFluidState ifluidstate = this.world.getFluidState(blockpos$pooledmutable);
                 if (ifluidstate.isTagged(FluidTags.WATER)) {
                    f = Math.max(f, ifluidstate.getActualHeight(this.world, blockpos$pooledmutable));
                 }

                 if (f >= 1.0F) {
                    continue label161;
                 }
              }
           }

           if (f < 1.0F) {
               float f2 = blockpos$pooledmutable.getY() + f;
               float f3 = f2;
               if (blockpos$pooledmutable != null)
                 if (null != null) {
                   try {
                     blockpos$pooledmutable.close();
                   } catch (Throwable throwable) {
                 //    null.addSuppressed(throwable);
                   } 
                 } else {
                   blockpos$pooledmutable.close();
                 }  
               return f3;
           }
        }

        float f1 = (float)(l + 1);
        return f1;
     }
  }
  
  public float getBoatGlide() {
    AxisAlignedBB axisalignedbb = getBoundingBox();
    AxisAlignedBB axisalignedbb1 = new AxisAlignedBB(axisalignedbb.maxZ, axisalignedbb.minY - 0.001D, axisalignedbb.minZ, axisalignedbb.maxX, axisalignedbb.minY, axisalignedbb.maxZ);
    int i = MathHelper.floor(axisalignedbb1.maxZ) - 1;
    int j = MathHelper.ceil(axisalignedbb1.maxX) + 1;
    int k = MathHelper.floor(axisalignedbb1.minY) - 1;
    int l = MathHelper.ceil(axisalignedbb1.maxY) + 1;
    int i1 = MathHelper.floor(axisalignedbb1.minZ) - 1;
    int j1 = MathHelper.ceil(axisalignedbb1.maxZ) + 1;
    VoxelShape voxelshape = VoxelShapes.create(axisalignedbb1);
    float f = 0.0F;
    int k1 = 0;
    try (BlockPos.PooledMutable blockpos$pooledmutable = BlockPos.PooledMutable.retain()) {
      for (int l1 = i; l1 < j; l1++) {
        for (int i2 = i1; i2 < j1; i2++) {
          int j2 = ((l1 != i && l1 != j - 1) ? 0 : 1) + ((i2 != i1 && i2 != j1 - 1) ? 0 : 1);
          if (j2 != 2)
            for (int k2 = k; k2 < l; k2++) {
              if (j2 <= 0 || (k2 != k && k2 != l - 1)) {
                blockpos$pooledmutable.setPos(l1, k2, i2);
                BlockState blockstate = this.world.getBlockState((BlockPos)blockpos$pooledmutable);
                if (!(blockstate.getBlock() instanceof net.minecraft.block.LilyPadBlock) && VoxelShapes.compare(blockstate.getCollisionShape((IBlockReader)this.world, (BlockPos)blockpos$pooledmutable).withOffset(l1, k2, i2), voxelshape, IBooleanFunction.AND)) {
                  f += blockstate.getSlipperiness((IWorldReader)this.world, (BlockPos)blockpos$pooledmutable, (Entity)this);
                  k1++;
                } 
              } 
            }  
        } 
      } 
    } 
    return f / k1;
  }
  
  private boolean checkInWater() {
    int m;
    AxisAlignedBB axisalignedbb = getBoundingBox();
    int i = MathHelper.floor(axisalignedbb.maxZ);
    int j = MathHelper.ceil(axisalignedbb.maxX);
    int k = MathHelper.floor(axisalignedbb.minY);
    int l = MathHelper.ceil(axisalignedbb.minY + 0.001D);
    int i1 = MathHelper.floor(axisalignedbb.minZ);
    int j1 = MathHelper.ceil(axisalignedbb.maxZ);
    boolean flag = false;
    this.waterLevel = Double.MIN_VALUE;

    try (BlockPos.PooledMutable blockpos$pooledmutable = BlockPos.PooledMutable.retain()) {
       for(int k1 = i; k1 < j; ++k1) {
          for(int l1 = k; l1 < l; ++l1) {
             for(int i2 = i1; i2 < j1; ++i2) {
                blockpos$pooledmutable.setPos(k1, l1, i2);
                IFluidState ifluidstate = this.world.getFluidState(blockpos$pooledmutable);
                if (ifluidstate.isTagged(FluidTags.WATER)) {
                   float f = (float)l1 + ifluidstate.getActualHeight(this.world, blockpos$pooledmutable);
                   this.waterLevel = Math.max((double)f, this.waterLevel);
                   flag |= axisalignedbb.minY < (double)f;
                }
             }
          }
       }
    }

    return flag;
 }
  
  @Nullable
  private BoatEntity.Status isUnderwater() {
    AxisAlignedBB axisalignedbb = getBoundingBox();
    double d0 = axisalignedbb.maxY + 0.001D;
    int i = MathHelper.floor(axisalignedbb.maxZ);
    int j = MathHelper.ceil(axisalignedbb.maxX);
    int k = MathHelper.floor(axisalignedbb.maxY);
    int l = MathHelper.ceil(d0);
    int i1 = MathHelper.floor(axisalignedbb.minZ);
    int j1 = MathHelper.ceil(axisalignedbb.maxZ);
    boolean flag = false;
    try (BlockPos.PooledMutable blockpos$pooledmutable = BlockPos.PooledMutable.retain()) {
      for (int k1 = i; k1 < j; k1++) {
        for (int l1 = k; l1 < l; l1++) {
          for (int i2 = i1; i2 < j1; i2++) {
            blockpos$pooledmutable.setPos(k1, l1, i2);
            IFluidState ifluidstate = this.world.getFluidState((BlockPos)blockpos$pooledmutable);
            if (ifluidstate.isTagged(FluidTags.WATER) && d0 < (blockpos$pooledmutable.getY() + ifluidstate.getActualHeight((IBlockReader)this.world, (BlockPos)blockpos$pooledmutable))) {
              if (!ifluidstate.isSource()) {
                BoatEntity.Status boatentity$status = BoatEntity.Status.UNDER_FLOWING_WATER;
                return boatentity$status;
              } 
              flag = true;
            } 
          } 
        } 
      } 
    } 
    return flag ? BoatEntity.Status.UNDER_WATER : null;
  }
  
  private void floatBoat() {
    double d0 = -0.03999999910593033D;
    double d1 = hasNoGravity() ? 0.0D : -0.03999999910593033D;
    double d2 = 0.0D;
    this.invFriction = 0.05F;
    if (this.oldStatus == BoatEntity.Status.IN_AIR && this.status != BoatEntity.Status.IN_AIR && this.status != BoatEntity.Status.ON_LAND) {
      this.waterLevel = getPosYHeight(1.0D);
      setPosition(getPosX(), (getWaterLevelAbove() - getHeight()) + 0.101D, getPosZ());
      setMotion(getMotion().mul(1.0D, 0.0D, 1.0D));
      this.lastYd = 0.0D;
      this.status = BoatEntity.Status.IN_WATER;
    } else {
      if (this.status == BoatEntity.Status.IN_WATER) {
        d2 = (this.waterLevel - getPosY()) / getHeight();
        this.invFriction = 0.9F;
      } else if (this.status == BoatEntity.Status.UNDER_FLOWING_WATER) {
        d1 = -7.0E-4D;
        this.invFriction = 0.9F;
      } else if (this.status == BoatEntity.Status.UNDER_WATER) {
        d2 = 0.009999999776482582D;
        this.invFriction = 0.45F;
      } else if (this.status == BoatEntity.Status.IN_AIR) {
        this.invFriction = 0.9F;
      } else if (this.status == BoatEntity.Status.ON_LAND) {
        this.invFriction = this.landFriction;
        if (getControllingPassenger() instanceof PlayerEntity)
          this.landFriction /= 2.0F; 
      } 
      Vec3d vec3d = getMotion();
      setMotion(vec3d.x * this.invFriction, vec3d.y + d1, vec3d.z * this.invFriction);
      this.deltaRotation *= this.invFriction;
      if (d2 > 0.0D) {
        Vec3d vec3d1 = getMotion();
        setMotion(vec3d1.x, (vec3d1.y + d2 * 0.06153846016296973D) * 0.75D, vec3d1.z);
      } 
    } 
  }
  
  private void controlBoat() {
    if (isBeingRidden()) {
      float f = 0.0F;
      if (this.inputLeft)
        this.deltaRotation--; 
      if (this.inputRight)
        this.deltaRotation++; 
      if (this.inputRight != this.inputLeft && !this.inputUp && !this.inputDown)
        f += 0.005F; 
      this.rotationYaw += this.deltaRotation;
      if (this.inputUp)
        f += 0.04F; 
      if (this.inputDown)
        f -= 0.005F; 
      setMotion(getMotion().add((MathHelper.sin(-this.rotationYaw * 0.017453292F) * f), 0.0D, (MathHelper.cos(this.rotationYaw * 0.017453292F) * f)));
      setPaddleState(((this.inputRight && !this.inputLeft) || this.inputUp), ((this.inputLeft && !this.inputRight) || this.inputUp));
    } 
  }
  
  public void updatePassenger(Entity passenger) {
    if (isPassenger(passenger)) {
      float f = 0.0F;
      float f1 = (float)((this.removed ? 0.009999999776482582D : getMountedYOffset()) + passenger.getYOffset());
      if (getPassengers().size() > 1) {
        int i = getPassengers().indexOf(passenger);
        if (i == 0) {
          f = 0.2F;
        } else {
          f = -0.6F;
        } 
        if (passenger instanceof AnimalEntity)
          f = (float)(f + 0.2D); 
      } 
      Vec3d vec3d = (new Vec3d(f, 0.0D, 0.0D)).rotateYaw(-this.rotationYaw * 0.017453292F - 1.5707964F);
      passenger.setPosition(getPosX() + vec3d.x, getPosY() + f1, getPosZ() + vec3d.z);
      passenger.rotationYaw += this.deltaRotation;
      passenger.setRotationYawHead(passenger.getRotationYawHead() + this.deltaRotation);
      applyYawToEntity(passenger);
      if (passenger instanceof AnimalEntity && getPassengers().size() > 1) {
        int j = (passenger.getEntityId() % 2 == 0) ? 90 : 270;
        passenger.setRenderYawOffset(((AnimalEntity)passenger).renderYawOffset + j);
        passenger.setRotationYawHead(passenger.getRotationYawHead() + j);
      } 
    } 
  }
  
  protected void applyYawToEntity(Entity entityToUpdate) {
    entityToUpdate.setRenderYawOffset(this.rotationYaw);
    float f = MathHelper.wrapDegrees(entityToUpdate.rotationYaw - this.rotationYaw);
    float f1 = MathHelper.clamp(f, -105.0F, 105.0F);
    entityToUpdate.prevRotationYaw += f1 - f;
    entityToUpdate.rotationYaw += f1 - f;
    entityToUpdate.setRotationYawHead(entityToUpdate.rotationYaw);
  }
  
  @OnlyIn(Dist.CLIENT)
  public void applyOrientationToEntity(Entity entityToUpdate) {
    applyYawToEntity(entityToUpdate);
  }
  
  protected void writeAdditional(CompoundNBT compound) {
    compound.putString("Type", getBoatModel().getName());
    //super.writeAdditional(compound);
    if (this.lootTable != null) {
       compound.putString("LootTable", this.lootTable.toString());
       if (this.lootTableSeed != 0L) {
          compound.putLong("LootTableSeed", this.lootTableSeed);
       }
    } else {
       ItemStackHelper.saveAllItems(compound, this.minecartContainerItems);
    }
  }
  
  protected void readAdditional(CompoundNBT compound) {
    if (compound.contains("Type", 8))
      setBoatModel(Type.byName(compound.getString("Type"))); 
    super.readAdditional(compound);
    this.minecartContainerItems = NonNullList.withSize(this.getSizeInventory(), ItemStack.EMPTY);
    if (compound.contains("LootTable", 8)) {
       this.lootTable = new ResourceLocation(compound.getString("LootTable"));
       this.lootTableSeed = compound.getLong("LootTableSeed");
    } else {
       ItemStackHelper.loadAllItems(compound, this.minecartContainerItems);
    }
  }
  
  public boolean processInitialInteract(PlayerEntity player, Hand hand) {
   
    if (!this.world.isRemote && this.outOfControlTicks < 60.0F) 
    	{
    	 if (player.isSecondaryUseActive()) {
     	    player.openContainer(this); 
    		 return false; 
}
    	return player.startRiding((Entity)this);}
    else {
    	return false;
    }
 
   
  }
  
  protected void updateFallState(double y, boolean onGroundIn, BlockState state, BlockPos pos) {
    this.lastYd = (getMotion()).y;
    if (!isPassenger())
      if (onGroundIn) {
        if (this.fallDistance > 3.0F) {
          if (this.status != BoatEntity.Status.ON_LAND) {
            this.fallDistance = 0.0F;
            return;
          } 
          onLivingFall(this.fallDistance, 1.0F);
          if (!this.world.isRemote && !this.removed) {
            remove();
            if (this.world.getGameRules().getBoolean(GameRules.DO_ENTITY_DROPS)) {
              for (int i = 0; i < 3; i++)
                entityDropItem((IItemProvider)getBoatModel().getPlanks()); 
              for (int j = 0; j < 2; j++)
                entityDropItem((IItemProvider)Items.STICK); 
            } 
          } 
        } 
        this.fallDistance = 0.0F;
      } else if (!this.world.getFluidState((new BlockPos((Entity)this)).down()).isTagged(FluidTags.WATER) && y < 0.0D) {
        this.fallDistance = (float)(this.fallDistance - y);
      }  
  }
  
  public boolean getPaddleState(int side) {
    return (((Boolean)this.dataManager.get((side == 0) ? DATA_ID_PADDLE_LEFT : DATA_ID_PADDLE_RIGHT)).booleanValue() && getControllingPassenger() != null);
  }
  
  public void setDamageTaken(float damageTaken) {
    this.dataManager.set(DATA_ID_DAMAGE, Float.valueOf(damageTaken));
  }
  
  public float getDamageTaken() {
    return ((Float)this.dataManager.get(DATA_ID_DAMAGE)).floatValue();
  }
  
  public void setTimeSinceHit(int timeSinceHit) {
    this.dataManager.set(DATA_ID_HURT, Integer.valueOf(timeSinceHit));
  }
  
  public int getTimeSinceHit() {
    return ((Integer)this.dataManager.get(DATA_ID_HURT)).intValue();
  }
  
  private void setBubbleTime(int p_203055_1_) {
    this.dataManager.set(DATA_ID_BUBBLE_TIME, Integer.valueOf(p_203055_1_));
  }
  
  private int getBubbleTime() {
    return ((Integer)this.dataManager.get(DATA_ID_BUBBLE_TIME)).intValue();
  }
  
  @OnlyIn(Dist.CLIENT)
  public float getRockingAngle(float partialTicks) {
    return MathHelper.lerp(partialTicks, this.bubbleAngleO, this.bubbleAngle);
  }
  
  public void setForwardDirection(int forwardDirection) {
    this.dataManager.set(DATA_ID_HURTDIR, Integer.valueOf(forwardDirection));
  }
  
  public int getForwardDirection() {
    return ((Integer)this.dataManager.get(DATA_ID_HURTDIR)).intValue();
  }
  
  public void setBoatModel(Type boatType) {
    this.dataManager.set(DATA_ID_TYPE, Integer.valueOf(boatType.ordinal()));
  }
  
  public Type getBoatModel() {
    return Type.byId(((Integer)this.dataManager.get(DATA_ID_TYPE)).intValue());
  }
  
  protected boolean canFitPassenger(Entity passenger) {
    return (getPassengers().size() < 1 && !areEyesInFluid(FluidTags.WATER));
  }
  
  @Nullable
  public Entity getControllingPassenger() {
    List<Entity> list = getPassengers();
    return list.isEmpty() ? null : list.get(0);
  }
  
  @OnlyIn(Dist.CLIENT)
  public void updateInputs(boolean p_184442_1_, boolean p_184442_2_, boolean p_184442_3_, boolean p_184442_4_) {
    this.inputLeft = p_184442_1_;
    this.inputRight = p_184442_2_;
    this.inputUp = p_184442_3_;
    this.inputDown = p_184442_4_;
  }
  
  protected void addPassenger(Entity passenger) {
    super.addPassenger(passenger);
    if (canPassengerSteer() && this.lerpSteps > 0) {
      this.lerpSteps = 0;
      setPositionAndRotation(this.lerpX, this.lerpY, this.lerpZ, (float)this.lerpYRot, (float)this.lerpXRot);
    } 
  }
  
  public IPacket<?> createSpawnPacket() {
    return NetworkHooks.getEntitySpawningPacket((Entity)this);
  }
  
  public enum Type {
    OAK(Blocks.OAK_PLANKS, "oak");
    
    private final String name;
    
    private final Block block;
    
    Type(Block p_i48146_3_, String p_i48146_4_) {
      this.name = p_i48146_4_;
      this.block = p_i48146_3_;
    }
    
    public String getName() {
      return this.name;
    }
    
    public Block getPlanks() {
      return this.block;
    }
    
    public String toString() {
      return this.name;
    }
    
    public static Type byId(int id) {
      Type[] aboatentity$type = values();
      if (id < 0 || id >= aboatentity$type.length)
        id = 0; 
      return aboatentity$type[id];
    }
    
    public static Type byName(String nameIn) {
      Type[] aboatentity$type = values();
      for (int i = 0; i < aboatentity$type.length; i++) {
        if (aboatentity$type[i].getName().equals(nameIn))
          return aboatentity$type[i]; 
      } 
      return aboatentity$type[0];
    }
  }
  private NonNullList<ItemStack> minecartContainerItems = NonNullList.withSize(36, ItemStack.EMPTY);
  private boolean dropContentsWhenDead = true;
  @Nullable
  private ResourceLocation lootTable;
  private long lootTableSeed;

  public boolean isEmpty() {
     for(ItemStack itemstack : this.minecartContainerItems) {
        if (!itemstack.isEmpty()) {
           return false;
        }
     }

     return true;
  }

  /**
   * Returns the stack in the given slot.
   */
  public ItemStack getStackInSlot(int index) {
     this.addLoot((PlayerEntity)null);
     return this.minecartContainerItems.get(index);
  }

  /**
   * Removes up to a specified number of items from an inventory slot and returns them in a new stack.
   */
  public ItemStack decrStackSize(int index, int count) {
     this.addLoot((PlayerEntity)null);
     return ItemStackHelper.getAndSplit(this.minecartContainerItems, index, count);
  }

  /**
   * Removes a stack from the given slot and returns it.
   */
  public ItemStack removeStackFromSlot(int index) {
     this.addLoot((PlayerEntity)null);
     ItemStack itemstack = this.minecartContainerItems.get(index);
     if (itemstack.isEmpty()) {
        return ItemStack.EMPTY;
     } else {
        this.minecartContainerItems.set(index, ItemStack.EMPTY);
        return itemstack;
     }
  }

  /**
   * Sets the given item stack to the specified slot in the inventory (can be crafting or armor sections).
   */
  public void setInventorySlotContents(int index, ItemStack stack) {
     this.addLoot((PlayerEntity)null);
     this.minecartContainerItems.set(index, stack);
     if (!stack.isEmpty() && stack.getCount() > this.getInventoryStackLimit()) {
        stack.setCount(this.getInventoryStackLimit());
     }

  }

  public boolean replaceItemInInventory(int inventorySlot, ItemStack itemStackIn) {
     if (inventorySlot >= 0 && inventorySlot < this.getSizeInventory()) {
        this.setInventorySlotContents(inventorySlot, itemStackIn);
        return true;
     } else {
        return false;
     }
  }

  /**
   * For tile entities, ensures the chunk containing the tile entity is saved to disk later - the game won't think it
   * hasn't changed and skip it.
   */
  public void markDirty() {
  }

  /**
   * Don't rename this method to canInteractWith due to conflicts with Container
   */
  public boolean isUsableByPlayer(PlayerEntity player) {
     if (this.removed) {
        return false;
     } else {
        return !(player.getDistanceSq(this) > 64.0D);
     }
  }

  @Nullable
  public Entity changeDimension(DimensionType destination, net.minecraftforge.common.util.ITeleporter teleporter) {
     this.dropContentsWhenDead = false;
     return super.changeDimension(destination, teleporter);
  }

  @Override
  public void remove(boolean keepData) {
     if (!this.world.isRemote && this.dropContentsWhenDead) {
        InventoryHelper.dropInventoryItems(this.world, this, this);
     }

     super.remove(keepData);
     if (!keepData) itemHandler.invalidate();
  }



  /**
   * Adds loot to the minecart's contents.
   */
  public void addLoot(@Nullable PlayerEntity player) {
     if (this.lootTable != null && this.world.getServer() != null) {
        LootTable loottable = this.world.getServer().getLootTableManager().getLootTableFromLocation(this.lootTable);
        this.lootTable = null;
        LootContext.Builder lootcontext$builder = (new LootContext.Builder((ServerWorld)this.world)).withParameter(LootParameters.POSITION, new BlockPos(this)).withSeed(this.lootTableSeed);
        // Forge: add this entity to loot context, however, currently Vanilla uses 'this' for the player creating the chests. So we take over 'killer_entity' for this.
        lootcontext$builder.withParameter(LootParameters.KILLER_ENTITY, this);
        if (player != null) {
           lootcontext$builder.withLuck(player.getLuck()).withParameter(LootParameters.THIS_ENTITY, player);
        }

        loottable.fillInventory(this, lootcontext$builder.build(LootParameterSets.CHEST));
     }

  }

  public void clear() {
     this.addLoot((PlayerEntity)null);
     this.minecartContainerItems.clear();
  }

  public void setLootTable(ResourceLocation lootTableIn, long lootTableSeedIn) {
     this.lootTable = lootTableIn;
     this.lootTableSeed = lootTableSeedIn;
  }

  @Nullable
  public Container createMenu(int p_createMenu_1_, PlayerInventory p_createMenu_2_, PlayerEntity p_createMenu_3_) {
     if (this.lootTable != null && p_createMenu_3_.isSpectator()) {
        return null;
     } else {
        this.addLoot(p_createMenu_2_.player);
        return this.createContainer(p_createMenu_1_, p_createMenu_2_);
     }
  }

  public Container createContainer(int id, PlayerInventory playerInventoryIn) {
      return ChestContainer.createGeneric9X3(id, playerInventoryIn, this);
   }

  private net.minecraftforge.common.util.LazyOptional<?> itemHandler = net.minecraftforge.common.util.LazyOptional.of(() -> new net.minecraftforge.items.wrapper.InvWrapper(this));

  @Override
  public <T> net.minecraftforge.common.util.LazyOptional<T> getCapability(net.minecraftforge.common.capabilities.Capability<T> capability, @Nullable net.minecraft.util.Direction facing) {
     if (this.isAlive() && capability == net.minecraftforge.items.CapabilityItemHandler.ITEM_HANDLER_CAPABILITY)
        return itemHandler.cast();
     return super.getCapability(capability, facing);
  }

  public void dropContentsWhenDead(boolean value) {
     this.dropContentsWhenDead = value;
  }
  public int getSizeInventory() {
      return 27;
   }


   public BlockState getDefaultDisplayTile() {
      return Blocks.CHEST.getDefaultState().with(ChestBlock.FACING, Direction.NORTH);
   }

   public int getDefaultDisplayTileOffset() {
      return 8;
   }
}
