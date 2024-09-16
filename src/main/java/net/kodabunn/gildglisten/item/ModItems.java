package net.kodabunn.gildglisten.item;

import net.kodabunn.gildglisten.GildNGlisten;
import net.kodabunn.gildglisten.item.custom.MelonPlatingItem;
import net.kodabunn.gildglisten.item.custom.MelonPlatingMoldItem;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(GildNGlisten.MOD_ID);

    public static final DeferredItem<Item> THESILLY = ITEMS.register("thesilly",
            () -> new Item(new Item.Properties()));



    public static final DeferredItem<Item> MELON_PLATE = ITEMS.register("melon_plate",
            () -> new MelonPlatingItem(new Item.Properties()));


    public static final DeferredItem<Item> MELON_PLATE_MOLD = ITEMS.register("melon_plate_mold",
            () -> new MelonPlatingMoldItem(new Item.Properties()));



    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
