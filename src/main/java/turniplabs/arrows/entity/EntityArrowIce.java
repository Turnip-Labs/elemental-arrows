package turniplabs.arrows.entity;

import net.minecraft.client.Minecraft;
import net.minecraft.src.*;

import static net.minecraft.src.Block.*;

// TODO - make these more reliable as well
public class EntityArrowIce extends EntityArrow {

    public EntityArrowIce(World world, EntityLiving entityliving, boolean doesArrowBelongToPlayer, int arrowType) {
        super(world, entityliving, doesArrowBelongToPlayer, arrowType);
    }

    @Override
    protected void inGroundAction() {
        this.worldObj.playSoundAtEntity(this, "random.drr", 1.0F, 1.2F / (this.rand.nextFloat() * 0.2F + 0.9F));
        this.inGround = true;
        kill();

        if (!worldObj.isMultiplayerAndNotHost) {
            for (int x = (int) (posX - 1); x <= posX + 2; ++x) {
                for (int y = (int) (posY - 1); y <= posY; ++y) {
                    for (int z = (int) (posZ - 1); z <= posZ + 1; ++z) {
                        boolean destroy = false;
                        if (this.worldObj.getBlockMaterial(x, y + 1, z) == Material.water && this.worldObj.getBlockMetadata(x, y + 1, z) == 0) {
                            this.worldObj.setBlockAndMetadataWithNotify(x, y + 1, z, Block.ice.blockID, 0);
                            destroy = true;
                        }
                        else if (this.worldObj.getBlockMaterial(x, y + 1, z) == Material.lava && this.worldObj.getBlockMetadata(x, y + 1, z) == 0) {
                            this.worldObj.setBlockAndMetadataWithNotify(x, y + 1, z, Block.obsidian.blockID, 0);
                            worldObj.playSoundAtEntity(this,"random.fizz", 1.0f, 1.0f);
                            destroy = true;
                        }
                        else if (this.worldObj.getBlockId(x, y, z) == Block.fire.blockID) {
                            this.worldObj.setBlockAndMetadataWithNotify(x, y, z, 0, 0);
                            worldObj.playSoundAtEntity(this,"random.fizz", 1.0f, 1.0f);
                            destroy = true;
                        }
                        else if (this.worldObj.getBlockId(x, y, z) == Block.torchCoal.blockID) {
                            Block.torchCoal.dropBlockAsItem(this.worldObj, x, y, z, this.worldObj.getBlockMetadata(x, y, z));
                            this.worldObj.setBlockAndMetadataWithNotify(x, y, z, 0, 0);
                            destroy = true;
                        }
                        else if (this.worldObj.getBlockId(x, y, z) == 0) {
                            this.worldObj.setBlockAndMetadataWithNotify(x, y, z, Block.layerSnow.blockID, 0);
                            destroy = true;
                        }

                        if (destroy) {
                            Minecraft minecraft = Minecraft.getMinecraft();
                            for(int i = 0; i < 50; ++i) {
                                EntitySlimeFX particle = new EntitySlimeFX(this.worldObj, this.posX, this.posY, this.posZ, Item.ammoSnowball);
                                float f4 = 0.25F;
                                particle.posX = (float) this.worldObj.rand.nextGaussian() * f4;
                                particle.posY = (float) this.worldObj.rand.nextGaussian() * f4 + 0.2F;
                                particle.posZ = (float) this.worldObj.rand.nextGaussian() * f4;
                                minecraft.effectRenderer.addEffect(particle);
                            }
                        }
                    }
                }
            }
        }
    }

    @Override
    public void onUpdate() {
        super.onUpdate();

        if (!inGround) {
            Minecraft minecraft = Minecraft.getMinecraft();
            for (int i = 0; i < 5; ++i) {
                minecraft.effectRenderer.addEffect(new EntityDiggingFX(this.worldObj, this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D, blockSnow, 0, 0));
                minecraft.effectRenderer.addEffect(new EntityDiggingFX(this.worldObj, this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D, ice, 0, 0));
            }
        }
    }
}
