package com.viperfish2000.entity;

import java.util.Random;

import javax.annotation.Nonnull;

import net.minecraft.block.Blocks;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntitySize;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.Pose;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.RandomPositionGenerator;
import net.minecraft.entity.ai.goal.AvoidEntityGoal;
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
import net.minecraft.entity.passive.PolarBearEntity;
import net.minecraft.entity.passive.TurtleEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.pathfinding.PathFinder;
import net.minecraft.pathfinding.PathNavigator;
import net.minecraft.pathfinding.SwimmerPathNavigator;
import net.minecraft.pathfinding.WalkAndSwimNodeProcessor;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class OtterPenguinEntity extends AnimalEntity {
    private static final Ingredient TEMPTATION_ITEMS = Ingredient.fromItems(Items.COD, Items.SALMON);
    private static final DataParameter<Boolean> TRAVELLING = EntityDataManager.createKey(OtterPenguinEntity.class, DataSerializers.BOOLEAN);

    private static final DataParameter<BlockPos> TRAVEL_POS = EntityDataManager.createKey(TurtleEntity.class, DataSerializers.BLOCK_POS);
    public short rotationFlipper;
    private boolean moveFlipper = false;

    public OtterPenguinEntity(EntityType<? extends OtterPenguinEntity> adelie, World world) {
        super(adelie, world);
       this.stepHeight = 1.0F;
    }

    @Override
    protected void registerGoals() {
       // this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(1, new EntityAIExtinguishFire());
        this.goalSelector.addGoal(2, new PanicGoal(this, 1.5D));
        this.goalSelector.addGoal(3, new BreedGoal(this, 0.8D));
        this.goalSelector.addGoal(4, new AvoidEntityGoal<>(this, PolarBearEntity.class, 6.0F, 1.0D, 1.2D));
        //this.goalSelector.addGoal(5, new TemptGoal(this, 1.0D, false, TEMPTATION_ITEMS));
        this.goalSelector.addGoal(6, new FollowParentGoal(this, 1.1D));

        this.goalSelector.addGoal(5, new OtterPenguinEntity.TravelGoal(this, 1.0D));
        this.goalSelector.addGoal(7, new RandomWalkingGoal(this, 1.0D));
        this.goalSelector.addGoal(8, new LookAtGoal(this, PlayerEntity.class, 6.0F));
        this.goalSelector.addGoal(9, new LookAtGoal(this, OtterPenguinEntity.class, 6.0F));
      this.goalSelector.addGoal(10, new OtterPenguinEntity.WanderGoal(this, 1.0D, 100));
    }


    @Override
    protected void registerAttributes() {
        super.registerAttributes();
        this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(8.0D);
        this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.16D);
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return null;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return null;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return null;
    }

    @Override
    public void livingTick() {
        super.livingTick();
        if (this.world.isRemote) {
            if (this.getPosX() != this.prevPosZ) {
                if (this.moveFlipper) {
                    this.rotationFlipper++;
                }
            }
        }
    }

    protected PathNavigator createNavigator(World worldIn) {
        return new OtterPenguinEntity.Navigator(this, worldIn);
     }
    
    private void setTravelPos(BlockPos position) {
        this.dataManager.set(TRAVEL_POS, position);
     }

     private BlockPos getTravelPos() {
        return this.dataManager.get(TRAVEL_POS);
     }
    @Override
    public boolean canBreatheUnderwater() {
        return true;
    }
    private void setTravelling(boolean isTravelling) {
        this.dataManager.set(TRAVELLING, isTravelling);
     }

    @Override
    public boolean isBreedingItem(@Nonnull ItemStack stack) {
        return !stack.isEmpty() && TEMPTATION_ITEMS.test(stack);
    }
    protected void registerData() {
        super.registerData();

        this.dataManager.register(TRAVEL_POS, BlockPos.ZERO);
        this.dataManager.register(TRAVELLING, false);
     }


    @Override
    public OtterPenguinEntity createChild(@Nonnull AgeableEntity ageable) {
        return CrocodileEntities.OTTER_PENGUIN.create(this.world);
    }
    public void travel(Vec3d p_213352_1_) {
        if (this.isServerWorld() && this.isInWater()) {
           this.moveRelative(0.1F, p_213352_1_);
           this.move(MoverType.SELF, this.getMotion());
           this.setMotion(this.getMotion().scale(0.9D));
           if (this.getAttackTarget() == null) {
              this.setMotion(this.getMotion().add(0.0D, -0.005D, 0.0D));
           }
        } else {
           super.travel(p_213352_1_);
        }

     }
    @Override
    protected float getStandingEyeHeight(Pose pose, EntitySize size) {
        return this.isChild() ? 0.5F : 0.9F;
    }
    private boolean isTravelling() {
        return this.dataManager.get(TRAVELLING);
     }
    private class EntityAIExtinguishFire extends PanicGoal {
        EntityAIExtinguishFire() {
            super(OtterPenguinEntity.this, 2.0D);
        }

        @Override
        public boolean shouldExecute() {
            return (OtterPenguinEntity.this.isChild() || OtterPenguinEntity.this.isBurning()) && super.shouldExecute();
        }
    }
    static class TravelGoal extends Goal {
        private final OtterPenguinEntity turtle;
        private final double speed;
        private boolean field_203139_c;

        TravelGoal(OtterPenguinEntity turtle, double speedIn) {
           this.turtle = turtle;
           this.speed = speedIn;
        }

        /**
         * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
         * method as well.
         */
        public boolean shouldExecute() {
           return this.turtle.isInWater();
        }

        /**
         * Execute a one shot task or start executing a continuous task
         */
        public void startExecuting() {
           int i = 512;
           int j = 4;
           Random random = this.turtle.rand;
           int k = random.nextInt(1025) - 512;
           int l = random.nextInt(9) - 4;
           int i1 = random.nextInt(1025) - 512;
           if ((double)l + this.turtle.getPosY() > (double)(this.turtle.world.getSeaLevel() - 1)) {
              l = 0;
           }

           BlockPos blockpos = new BlockPos((double)k + this.turtle.getPosX(), (double)l + this.turtle.getPosY(), (double)i1 + this.turtle.getPosZ());
           this.turtle.setTravelPos(blockpos);
           this.turtle.setTravelling(true);
           this.field_203139_c = false;
        }

        /**
         * Keep ticking a continuous task that has already been started
         */
        public void tick() {
           if (this.turtle.getNavigator().noPath()) {
              Vec3d vec3d = new Vec3d(this.turtle.getTravelPos());
              Vec3d vec3d1 = RandomPositionGenerator.findRandomTargetTowardsScaled(this.turtle, 16, 3, vec3d, (double)((float)Math.PI / 10F));
              if (vec3d1 == null) {
                 vec3d1 = RandomPositionGenerator.findRandomTargetBlockTowards(this.turtle, 8, 7, vec3d);
              }

              if (vec3d1 != null) {
                 int i = MathHelper.floor(vec3d1.x);
                 int j = MathHelper.floor(vec3d1.z);
                 int k = 34;
                 if (!this.turtle.world.isAreaLoaded(i - 34, 0, j - 34, i + 34, 0, j + 34)) {
                    vec3d1 = null;
                 }
              }

              if (vec3d1 == null) {
                 this.field_203139_c = true;
                 return;
              }

              this.turtle.getNavigator().tryMoveToXYZ(vec3d1.x, vec3d1.y, vec3d1.z, this.speed);
           }

        }

        /**
         * Returns whether an in-progress EntityAIBase should continue executing
         */
        public boolean shouldContinueExecuting() {
           return !this.turtle.getNavigator().noPath() && !this.field_203139_c;
        }

        /**
         * Reset the task's internal state. Called when this task is interrupted by another one
         */
        public void resetTask() {
           this.turtle.setTravelling(false);
           super.resetTask();
        }
     }
    static class Navigator extends SwimmerPathNavigator {
        Navigator(OtterPenguinEntity turtle, World worldIn) {
           super(turtle, worldIn);
        }

        /**
         * If on ground or swimming and can swim
         */
        protected boolean canNavigate() {
           return true;
        }

        protected PathFinder getPathFinder(int p_179679_1_) {
           this.nodeProcessor = new WalkAndSwimNodeProcessor();
           return new PathFinder(this.nodeProcessor, p_179679_1_);
        }

        public boolean canEntityStandOnPos(BlockPos pos) {
           if (this.entity instanceof OtterPenguinEntity) {
              OtterPenguinEntity OtterPenguinEntity = (OtterPenguinEntity)this.entity;
              if (OtterPenguinEntity.isTravelling()) {
                 return this.world.getBlockState(pos).getBlock() == Blocks.WATER;
              }
           }

           return !this.world.getBlockState(pos.down()).isAir();
        }
     }
    static class WanderGoal extends RandomWalkingGoal {
        private final OtterPenguinEntity turtle;

        private WanderGoal(OtterPenguinEntity turtle, double speedIn, int chance) {
           super(turtle, speedIn, chance);
           this.turtle = turtle;
        }

        /**
         * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
         * method as well.
         */
        public boolean shouldExecute() {
           return !this.creature.isInWater()? super.shouldExecute() : false;
        }
     }
}