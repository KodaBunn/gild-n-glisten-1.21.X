package net.kodabunn.gildandglisten.item;

import net.kodabunn.gildandglisten.GildNGlisten;
import net.kodabunn.gildandglisten.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, GildNGlisten.MOD_ID);

    public static final Supplier<CreativeModeTab> SILLY_ITEMS_TAB = CREATIVE_MODE_TAB.register("silly_items_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.THESILLY.get()))
                    .title(Component.translatable("creativetab.gildandglisten.silly_items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.THESILLY);
                    }).build());
    public static final Supplier<CreativeModeTab> SILLY_BLOCKS_TAB = CREATIVE_MODE_TAB.register("silly_blocks_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModBlocks.SILLY_BLOCK.get()))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(GildNGlisten.MOD_ID, "silly_items_tab"))
                    .title(Component.translatable("creativetab.gildandglisten.silly_blocks"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.SILLY_BLOCK);
                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }


}
