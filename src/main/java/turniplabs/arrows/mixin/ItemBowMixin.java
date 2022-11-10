package turniplabs.arrows.mixin;

import net.minecraft.src.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import turniplabs.arrows.Mod_Arrows;
import turniplabs.arrows.entity.*;

import java.util.Random;

@Mixin (value = ItemBow.class, remap = false)
public class ItemBowMixin {
    private static Random itemRand = new Random();

    @Inject(method = "onItemRightClick", at = @At(value = "RETURN"))
        private void arrows_onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer, CallbackInfoReturnable<ItemStack> cir) {
        if (entityplayer.inventory.consumeInventoryItem(Mod_Arrows.arrowEgg.itemID)) {
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
    }
}
