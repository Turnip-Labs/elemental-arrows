package turniplabs.arrows.entity;

import net.minecraft.client.Minecraft;
import net.minecraft.src.*;

// TODO - Set mobs on fire
// TODO - Make the arrows more reliably set fires
public class EntityArrowFire extends EntityArrow {

    public EntityArrowFire(World world, EntityLiving entityliving, boolean doesArrowBelongToPlayer, int arrowType) {
        super(world, entityliving, doesArrowBelongToPlayer, arrowType);
    }

    @Override
    protected void inGroundAction() {
        super.inGroundAction();
        kill();

        for (int x = (int) (posX - 1); x <= posX + 2; ++x) {
            for (int y = (int) (posY - 1); y <= posY; ++y) {
                for (int z = (int) (posZ - 1); z <= posZ + 1; ++z) {
                    if (!worldObj.isMultiplayerAndNotHost) {
                        if (this.worldObj.getBlockId(x, y + 1, z) == 0) {
                            worldObj.setBlockAndMetadataWithNotify(x, y + 1, z, Block.fire.blockID, 0);
                            worldObj.playSoundAtEntity(this, "fire.ignite", 1.0f, 1.0f);
                        }
                    }
                }
            }
        }
    }

    @Override
    public void onUpdate() {
        super.onUpdate();
        this.fire = 300;
        Minecraft minecraft = Minecraft.getMinecraft();
        for(int i = 0; i < 5; ++i) {
            minecraft.effectRenderer.addEffect(new EntitySmokeFX(worldObj, posX, posY, posZ, 0.0D, 0.0D, 0.0D));
        }
    }
}
