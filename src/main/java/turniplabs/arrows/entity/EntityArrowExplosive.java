package turniplabs.arrows.entity;

import net.minecraft.src.EntityArrow;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.World;

public class EntityArrowExplosive extends EntityArrow {

    public EntityArrowExplosive(World world, EntityLiving entityliving, boolean doesArrowBelongToPlayer, int arrowType) {
        super(world, entityliving, doesArrowBelongToPlayer, arrowType);
    }

    @Override
    protected void inGroundAction() {
        super.inGroundAction();
        kill();
        worldObj.createExplosion(this, posX, posY, posZ, 2.0f);
    }
}
