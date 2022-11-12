package turniplabs.arrows.entity;

import net.minecraft.src.*;

public class EntityArrowLightning extends EntityArrow {

    public EntityArrowLightning(World world, EntityLiving entityliving, boolean doesArrowBelongToPlayer, int arrowType) {
        super(world, entityliving, doesArrowBelongToPlayer, arrowType);
    }

    @Override
    protected void inGroundAction() {
        super.inGroundAction();
        kill();
        if (!worldObj.isMultiplayerAndNotHost) worldObj.entityJoinedWorld(new EntityLightningBolt(worldObj, posX - 1, posY, posZ));
    }
}
