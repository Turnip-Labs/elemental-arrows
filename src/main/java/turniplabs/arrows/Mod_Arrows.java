package turniplabs.arrows;

import net.fabricmc.api.ModInitializer;
import net.minecraft.src.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import turniplabs.arrows.item.ItemBowHoming;
import turniplabs.halplibe.helper.RecipeHelper;
import turniplabs.halplibe.helper.TextureHelper;

import static net.minecraft.src.Item.*;


public class Mod_Arrows implements ModInitializer {

    public static final String MOD_ID = "arrows";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static String name(String name) {
        return Mod_Arrows.MOD_ID + "." + name;
    }

    public static final Item arrowEgg = new Item(800).setIconCoord(0,31).setItemName(name("ammo.egg"));
    public static final Item arrowExplosive = new Item(801).setIconCoord(1,31).setItemName(name("ammo.explosive"));
    public static final Item arrowFire = new Item(802).setIconCoord(2,31).setItemName(name("ammo.fire"));
    public static final Item arrowIce = new Item(803).setIconCoord(3,31).setItemName(name("ammo.ice"));
    public static final Item arrowLightning = new Item(804).setIconCoord(4,31).setItemName(name("ammo.lightning"));
    public static final Item bowHoming = new ItemBowHoming(805).setIconCoord(5,31).setItemName(name("bow.homing"));

    @Override
    public void onInitialize() {
        LOGGER.info("Elemental Arrows initialized.");

        TextureHelper.addTextureToItems(MOD_ID,"eggarrow.png",0,31);
        TextureHelper.addTextureToItems(MOD_ID,"exarrow.png",1,31);
        TextureHelper.addTextureToItems(MOD_ID,"fiarrow.png",2,31);
        TextureHelper.addTextureToItems(MOD_ID,"icearrow.png",3,31);
        TextureHelper.addTextureToItems(MOD_ID,"liarrow.png",4,31);
        TextureHelper.addTextureToItems(MOD_ID,"hombow.png",5,31);

        RecipeHelper.Crafting.createRecipe(arrowEgg,1, new Object[]{"1", "2", "3", '1', eggChicken, '2', stick, '3', featherChicken});
        RecipeHelper.Crafting.createRecipe(arrowExplosive,1, new Object[]{"1", "2", "3", '1', sulphur, '2', stick, '3', featherChicken});
        RecipeHelper.Crafting.createRecipe(arrowFire,1, new Object[]{"1", "2", "3", '1', coal, '2', stick, '3', featherChicken});
        RecipeHelper.Crafting.createRecipe(arrowIce,1, new Object[]{"1", "2", "3", '1', ammoSnowball, '2', stick, '3', featherChicken});
        RecipeHelper.Crafting.createRecipe(arrowLightning,1, new Object[]{"1", "2", "3", '1', diamond, '2', stick, '3', featherChicken});
        RecipeHelper.Crafting.createRecipe(bowHoming, 1, new Object[]{" 1 ", "1 2", " 12", '1', diamond, '2', string});
    }
}
