package turniplabs.arrows.entity;

import net.minecraft.src.EntityArrow;
import net.minecraft.src.EntityChicken;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.World;

public class EntityArrowEgg extends EntityArrow {
    public boolean homing;

    public EntityArrowEgg(World world, EntityLiving entityliving, boolean doesArrowBelongToPlayer, int arrowType) {
        super(world, entityliving, doesArrowBelongToPlayer, arrowType);
    }

    protected void inGroundAction() {
        EntityChicken chicken = new EntityChicken(worldObj);
        this.worldObj.playSoundAtEntity(this, "random.drr", 1.0F, 1.2F / (this.rand.nextFloat() * 0.2F + 0.9F));
        this.inGround = true;

        if (!worldObj.isMultiplayerAndNotHost) {
            double d1 = this.rand.nextGaussian() * 0.02D;
            double d2 = this.rand.nextGaussian() * 0.02D;
            double d3 = this.rand.nextGaussian() * 0.02D;
            this.worldObj.spawnParticle("explode", this.posX + (double) (this.rand.nextFloat() * this.width * 2.0F) - (double) this.width, this.posY + (double) (this.rand.nextFloat() * this.height), this.posZ + (double) (this.rand.nextFloat() * this.width * 2.0F) - (double) this.width, d1, d2, d3);
            kill();
            chicken.setPosition(posX, posY, posZ);
            worldObj.entityJoinedWorld(chicken);
        }
    }

    public void setHoming(boolean homing) {
        this.homing = homing;
    }
}
