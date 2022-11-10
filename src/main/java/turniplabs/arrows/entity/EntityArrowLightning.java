package turniplabs.arrows.entity;

import net.minecraft.src.*;

public class EntityArrowLightning extends EntityArrow {
    public boolean homing;

    public EntityArrowLightning(World world, EntityLiving entityliving, boolean doesArrowBelongToPlayer, int arrowType) {
        super(world, entityliving, doesArrowBelongToPlayer, arrowType);
    }

    @Override
    protected void inGroundAction() {
        this.worldObj.playSoundAtEntity(this, "random.drr", 1.0F, 1.2F / (this.rand.nextFloat() * 0.2F + 0.9F));
        this.inGround = true;
        kill();

        if (!worldObj.isMultiplayerAndNotHost) worldObj.entityJoinedWorld(new EntityLightningBolt(worldObj, posX - 1, posY, posZ));
    }

    public void setHoming(boolean homing) {
        this.homing = homing;
    }
}
