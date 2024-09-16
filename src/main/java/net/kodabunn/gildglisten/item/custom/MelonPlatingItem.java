package net.kodabunn.gildglisten.item.custom;

import net.kodabunn.gildglisten.block.ModBlocks;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.Map;

public class MelonPlatingItem extends Item {
    private static final Map<Block, Block> PLATE_MAP =
            Map.of(
                    Blocks.MELON, ModBlocks.GILDED_MELON.get()
            );

    public MelonPlatingItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        Block clickedBlock = level.getBlockState(context.getClickedPos()).getBlock();

        if(PLATE_MAP.containsKey(clickedBlock)) {
            if(!level.isClientSide()) {
                level.setBlockAndUpdate(context.getClickedPos(), PLATE_MAP.get(clickedBlock).defaultBlockState());

                context.getItemInHand().consume(1, context.getPlayer());

                level.playSound(null, context.getClickedPos(), SoundEvents.NETHER_GOLD_ORE_FALL, SoundSource.BLOCKS);
            }
        }

        return InteractionResult.SUCCESS;
    }
}
