package turniplabs.arrows.item;

import net.minecraft.src.*;
import turniplabs.arrows.Mod_Arrows;
import turniplabs.arrows.entity.*;

// TODO - add the homing ability from the original mod
public class ItemHomingBow extends ItemBow {

    public ItemHomingBow(int i) {
        super(i);
        this.setMaxDamage(768);
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer) {
        ItemStack quiverSlot = entityplayer.inventory.armorItemInSlot(2);
        if (quiverSlot != null && quiverSlot.itemID == Item.armorQuiver.itemID && quiverSlot.getMetadata() < quiverSlot.getMaxDamage()) {
            entityplayer.inventory.armorItemInSlot(2).damageItem(1, entityplayer);
            itemstack.damageItem(1, entityplayer);
            world.playSoundAtEntity(entityplayer, "random.bow", 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 0.8F));
            if (!world.isMultiplayerAndNotHost) {
                world.entityJoinedWorld(new EntityArrow(world, entityplayer, true, 0));
            }
        } else if (quiverSlot != null && quiverSlot.itemID == Item.armorQuiverGold.itemID) {
            itemstack.damageItem(1, entityplayer);
            world.playSoundAtEntity(entityplayer, "random.bow", 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 0.8F));
            if (!world.isMultiplayerAndNotHost) {
                world.entityJoinedWorld(new EntityArrowPurple(world, entityplayer, false));
            }
        } else if (entityplayer.inventory.consumeInventoryItem(Item.ammoArrowGold.itemID)) {
            itemstack.damageItem(1, entityplayer);
            world.playSoundAtEntity(entityplayer, "random.bow", 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 0.8F));
            if (!world.isMultiplayerAndNotHost) {
                world.entityJoinedWorld(new EntityArrowGolden(world, entityplayer, true));
            }
        } else if (entityplayer.inventory.consumeInventoryItem(Item.ammoArrow.itemID)) {
            itemstack.damageItem(1, entityplayer);
            world.playSoundAtEntity(entityplayer, "random.bow", 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 0.8F));
            if (!world.isMultiplayerAndNotHost) {
                world.entityJoinedWorld(new EntityArrow(world, entityplayer, true, 0));
            }
        } else if (entityplayer.inventory.consumeInventoryItem(Mod_Arrows.arrowEgg.itemID)) {
            itemstack.damageItem(1, entityplayer);
            world.playSoundAtEntity(entityplayer, "random.bow", 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 0.8F));
            if (!world.isMultiplayerAndNotHost) {
                world.entityJoinedWorld(new EntityArrowEgg(world, entityplayer, true, 0));
            }
        }
        else if (entityplayer.inventory.consumeInventoryItem(Mod_Arrows.arrowExplosive.itemID)) {
            itemstack.damageItem(1, entityplayer);
            world.playSoundAtEntity(entityplayer, "random.bow", 1.0f, 1.0f / (itemRand.nextFloat() * 0.4f + 0.8f));
            if (!world.isMultiplayerAndNotHost) {
                world.entityJoinedWorld(new EntityArrowExplosive(world, entityplayer, true, 0));
            }
        }
        else if (entityplayer.inventory.consumeInventoryItem(Mod_Arrows.arrowFire.itemID)) {
            itemstack.damageItem(1, entityplayer);
            world.playSoundAtEntity(entityplayer, "random.bow", 1.0f, 1.0f / (itemRand.nextFloat() * 0.4f + 0.8f));
            if (!world.isMultiplayerAndNotHost) {
                world.entityJoinedWorld(new EntityArrowFire(world, entityplayer, true, 0));
            }
        }
        else if (entityplayer.inventory.consumeInventoryItem(Mod_Arrows.arrowIce.itemID)) {
            itemstack.damageItem(1, entityplayer);
            world.playSoundAtEntity(entityplayer, "random.bow", 1.0f, 1.0f / (itemRand.nextFloat() * 0.4f + 0.8f));
            if (!world.isMultiplayerAndNotHost) {
                world.entityJoinedWorld(new EntityArrowIce(world, entityplayer, true, 0));
            }
        } else if (entityplayer.inventory.consumeInventoryItem(Mod_Arrows.arrowLightning.itemID)) {
            itemstack.damageItem(1, entityplayer);
            world.playSoundAtEntity(entityplayer, "random.bow", 1.0f, 1.0f / (itemRand.nextFloat() * 0.4f + 0.8f));
            if (!world.isMultiplayerAndNotHost) {
                world.entityJoinedWorld(new EntityArrowLightning(world, entityplayer, true, 0));
            }
        }
        return itemstack;
    }
}
