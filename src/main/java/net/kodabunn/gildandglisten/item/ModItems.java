package net.kodabunn.gildandglisten.item;

import net.kodabunn.gildandglisten.GildNGlisten;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(GildNGlisten.MOD_ID);

    public static final DeferredItem<Item> THESILLY = ITEMS.register("thesilly",
            () -> new Item(new Item.Properties()));



    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
