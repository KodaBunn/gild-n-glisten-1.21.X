package net.kodabunn.gildglisten.item;

import net.kodabunn.gildglisten.GildNGlisten;
import net.kodabunn.gildglisten.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, GildNGlisten.MOD_ID);

    public static final Supplier<CreativeModeTab> GILD_GLISTEN_TAB = CREATIVE_MODE_TAB.register("gild_glisten_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(Items.GLISTERING_MELON_SLICE))
                    .title(Component.translatable("creativetab.gildglisten.gild_glisten_items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.MELON_PLATE);
                        output.accept(ModItems.MELON_PLATE_MOLD);
                        output.accept(ModBlocks.GILDED_MELON);
                    }).build());

    public static final Supplier<CreativeModeTab> SILLY_ITEMS_TAB = CREATIVE_MODE_TAB.register("silly_items_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.THESILLY.get()))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(GildNGlisten.MOD_ID, "gild_glisten_tab"))
                    .title(Component.translatable("creativetab.gildglisten.silly_items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.THESILLY);
                    }).build());
    public static final Supplier<CreativeModeTab> SILLY_BLOCKS_TAB = CREATIVE_MODE_TAB.register("silly_blocks_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModBlocks.SILLY_BLOCK.get()))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(GildNGlisten.MOD_ID, "silly_items_tab"))
                    .title(Component.translatable("creativetab.gildglisten.silly_blocks"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.SILLY_BLOCK);
                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }


}
