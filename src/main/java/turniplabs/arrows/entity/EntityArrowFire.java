package turniplabs.arrows.entity;

import net.minecraft.client.Minecraft;
import net.minecraft.src.*;

// TODO - Set mobs on fire
// TODO - Make the arrows more reliably set fires
public class EntityArrowFire extends EntityArrow {
    public boolean homing;

    public EntityArrowFire(World world, EntityLiving entityliving, boolean doesArrowBelongToPlayer, int arrowType) {
        super(world, entityliving, doesArrowBelongToPlayer, arrowType);
    }

    @Override
    protected void inGroundAction() {
        this.worldObj.playSoundAtEntity(this, "random.drr", 1.0F, 1.2F / (this.rand.nextFloat() * 0.2F + 0.9F));
        this.inGround = true;
        if (!worldObj.isMultiplayerAndNotHost) worldObj.setBlockAndMetadataWithNotify((int) posX - 1, (int) posY, (int) posZ, Block.fire.blockID,0);
        kill();
    }

    @Override
    public void onUpdate() {
        super.onUpdate();

        Minecraft minecraft = Minecraft.getMinecraft();
        for(int i = 0; i < 5; ++i) {
            minecraft.effectRenderer.addEffect(new EntitySmokeFX(worldObj, posX, posY, posZ, 0.0D, 0.0D, 0.0D));
        }
    }

    public void setHoming(boolean homing) {
        this.homing = homing;
    }
}
