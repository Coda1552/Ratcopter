package coda.ratcopter.entities;

import coda.ratcopter.client.RatcopterKeyBindings;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.potion.Effects;
import net.minecraft.util.*;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.Nullable;

public class RatcopterEntity extends AnimalEntity {

	public float acceleration = 0.0f;
	public float turnPower = 0;

	public RatcopterEntity(EntityType<? extends RatcopterEntity> p_i48563_1_, World p_i48563_2_) {
		super(p_i48563_1_, p_i48563_2_);
		this.maxUpStep = 1.0F;
	}

	public boolean isPushable() {
		return false;
	}

	public boolean causeFallDamage(float p_225503_1_, float p_225503_2_) {
		return false;
	}

	public static AttributeModifierMap.MutableAttribute createBaseHorseAttributes() {
		return MobEntity.createMobAttributes().add(Attributes.JUMP_STRENGTH).add(Attributes.MAX_HEALTH, 53.0D).add(Attributes.MOVEMENT_SPEED, (double)0.225F);
	}

	protected void doPlayerRide(PlayerEntity p_110237_1_) {
		if (!this.level.isClientSide) {
			p_110237_1_.yRot = this.yRot;
			p_110237_1_.xRot = this.xRot;
			p_110237_1_.startRiding(this);
		}

	}

	public void travel(Vector3d p_213352_1_) {
		if (this.isAlive()) {
			if (this.isVehicle() && this.canBeControlledByRider()) {
				LivingEntity livingentity = (LivingEntity)this.getControllingPassenger();

				float f = livingentity.xxa * 0.5F;
				float f1 = livingentity.zza;
				if (f1 <= 0.0F) {
					f1 *= 0.25F;
				}

				if (this.onGround) {
					f = 0.0F;
					f1 = 0.0F;
				}

				if(livingentity instanceof PlayerEntity){
					PlayerEntity player = (PlayerEntity) livingentity;

					turnPower += player.xxa * 3f;
					if(turnPower > 10) turnPower = 10;
					if(turnPower < -10) turnPower = -10;

					if(turnPower < 0){
						turnPower = Math.min(turnPower + 0.3f, 0);
					}
					else if(turnPower > 0){
						turnPower = Math.max(turnPower - 0.3f, 0);
					}

					setYBodyRot(yBodyRot - (player.xxa * 3f));
					this.yRot = yBodyRot;
					this.yRotO = this.yRot;
					this.setRot(this.yRot, this.xRot);
					this.yBodyRot = this.yRot;
					this.yHeadRot = this.yBodyRot;
				}

				float yDelta = 0;

				if (Minecraft.getInstance().options.keyJump.isDown()) {
					yDelta = 0.3f;
				}
				else if(RatcopterKeyBindings.RATCOPTER_DESCEND.isDown()){
					yDelta = -0.3f;
				}

				if(livingentity.zza > 0){
					acceleration = Math.min(acceleration + 0.3F, 10.0F);
				}
				else{
//					System.out.println("Decelerating");
//					System.out.println(acceleration);
					acceleration = Math.max(acceleration - 0.3F + (livingentity.zza * 0.5F), 0f);
				}

				if(acceleration < 0){
					acceleration = 0;
				}

				float calcX = MathHelper.sin(-yBodyRot * 0.017453292F);
				float calcZ = MathHelper.cos(yBodyRot * 0.017453292F);

//				System.out.println(livingentity.zza);
//				System.out.println(acceleration);

				this.setDeltaMovement(calcX * acceleration * 0.1F, yDelta, calcZ * acceleration * 0.1F);

				this.hasImpulse = true;


				this.flyingSpeed = this.getSpeed() * 0.1F;
				if (this.isControlledByLocalInstance()) {
					this.setSpeed((float)this.getAttributeValue(Attributes.MOVEMENT_SPEED));
					super.travel(new Vector3d((double)f, p_213352_1_.y, (double)f1));
				} else if (livingentity instanceof PlayerEntity) {
					this.setDeltaMovement(Vector3d.ZERO);
				}

				this.calculateEntityAnimation(this, false);
			} else {
				this.flyingSpeed = 0.02F;
				super.travel(p_213352_1_);
			}
		}
	}

	@Override
	public boolean isNoGravity() {
		return !getPassengers().isEmpty();
	}

	@Nullable
	@Override
	public AgeableEntity getBreedOffspring(ServerWorld serverWorld, AgeableEntity ageableEntity) {
		return null;
	}

	public void addAdditionalSaveData(CompoundNBT p_213281_1_) {
		super.addAdditionalSaveData(p_213281_1_);
	}

	public void readAdditionalSaveData(CompoundNBT p_70037_1_) {
		super.readAdditionalSaveData(p_70037_1_);
	}

	public boolean canBeControlledByRider() {
		return this.getControllingPassenger() instanceof LivingEntity;
	}

/*	public void positionRider(Entity entity) {
		super.positionRider(entity);
		if (entity instanceof MobEntity) {
			MobEntity mobentity = (MobEntity) entity;
			this.yBodyRot = mobentity.yBodyRot;
		}
	}*/

	@Nullable
	public Entity getControllingPassenger() {
		return this.getPassengers().isEmpty() ? null : this.getPassengers().get(0);
	}

	@Nullable
	private Vector3d getDismountLocationInDirection(Vector3d p_234236_1_, LivingEntity p_234236_2_) {
		double d0 = this.getX() + p_234236_1_.x;
		double d1 = this.getBoundingBox().minY;
		double d2 = this.getZ() + p_234236_1_.z;
		BlockPos.Mutable blockpos$mutable = new BlockPos.Mutable();

		for(Pose pose : p_234236_2_.getDismountPoses()) {
			blockpos$mutable.set(d0, d1, d2);
			double d3 = this.getBoundingBox().maxY + 0.75D;

			while(true) {
				double d4 = this.level.getBlockFloorHeight(blockpos$mutable);
				if ((double)blockpos$mutable.getY() + d4 > d3) {
					break;
				}

				if (TransportationHelper.isBlockFloorValid(d4)) {
					AxisAlignedBB axisalignedbb = p_234236_2_.getLocalBoundsForPose(pose);
					Vector3d vector3d = new Vector3d(d0, (double)blockpos$mutable.getY() + d4, d2);
					if (TransportationHelper.canDismountTo(this.level, p_234236_2_, axisalignedbb.move(vector3d))) {
						p_234236_2_.setPose(pose);
						return vector3d;
					}
				}

				blockpos$mutable.move(Direction.UP);
				if (!((double)blockpos$mutable.getY() < d3)) {
					break;
				}
			}
		}

		return null;
	}

	public ActionResultType mobInteract(PlayerEntity p_230254_1_, Hand p_230254_2_) {
		this.doPlayerRide(p_230254_1_);
		return ActionResultType.sidedSuccess(this.level.isClientSide);
	}

	@Override
	protected boolean canAddPassenger(Entity p_184219_1_) {
		return this.getPassengers().size() < 2;
	}

	public void positionRider(Entity entity) {
		if (this.hasPassenger(entity)) {
			float f = 0f;
			float f1 = (float)((this.removed ? (double)0.01F : this.getPassengersRidingOffset()) + entity.getMyRidingOffset());
			if (this.getPassengers().size() > 1) {
				int i = this.getPassengers().indexOf(entity);
				f = -i;
			}

			Vector3d vector3d = (new Vector3d((double)f + 1.0F, 0.0D, 0.0D)).yRot(-this.yRot * ((float)Math.PI / 180F) - ((float)Math.PI / 2F));
			entity.setPos(this.getX() + vector3d.x, this.getY() + (double)f1 - 1.53F, this.getZ() + vector3d.z);
		}
	}

	public Vector3d getDismountLocationForPassenger(LivingEntity p_230268_1_) {
		Vector3d vector3d = getCollisionHorizontalEscapeVector((double)this.getBbWidth(), (double)p_230268_1_.getBbWidth(), this.yRot + (p_230268_1_.getMainArm() == HandSide.RIGHT ? 90.0F : -90.0F));
		Vector3d vector3d1 = this.getDismountLocationInDirection(vector3d, p_230268_1_);
		if (vector3d1 != null) {
			return vector3d1;
		} else {
			Vector3d vector3d2 = getCollisionHorizontalEscapeVector((double)this.getBbWidth(), (double)p_230268_1_.getBbWidth(), this.yRot + (p_230268_1_.getMainArm() == HandSide.LEFT ? 90.0F : -90.0F));
			Vector3d vector3d3 = this.getDismountLocationInDirection(vector3d2, p_230268_1_);
			return vector3d3 != null ? vector3d3 : this.position();
		}
	}
}
