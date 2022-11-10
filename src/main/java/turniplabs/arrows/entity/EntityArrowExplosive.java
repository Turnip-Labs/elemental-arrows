package turniplabs.arrows.entity;

import net.minecraft.src.EntityArrow;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.World;

public class EntityArrowExplosive extends EntityArrow {
    public boolean homing;

    public EntityArrowExplosive(World world, EntityLiving entityliving, boolean doesArrowBelongToPlayer, int arrowType) {
        super(world, entityliving, doesArrowBelongToPlayer, arrowType);
    }

    @Override
    protected void inGroundAction() {
        this.worldObj.playSoundAtEntity(this, "random.drr", 1.0F, 1.2F / (this.rand.nextFloat() * 0.2F + 0.9F));
        this.inGround = true;
        kill();
        worldObj.createExplosion(this, posX, posY, posZ, 3.0f);
    }

    public void setHoming(boolean homing) {
        this.homing = homing;
    }
}
