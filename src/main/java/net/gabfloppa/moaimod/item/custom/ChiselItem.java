package net.gabfloppa.moaimod.item.custom;

import net.gabfloppa.moaimod.block.ModBlocks;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.Map;

public class ChiselItem extends Item {

    private static final Map<Block, Block> CHISEL_MAP = Map.of(
            Blocks.STONE, Blocks.STONE_BRICKS,
            Blocks.END_STONE, Blocks.END_STONE_BRICKS,
            Blocks.DEEPSLATE, Blocks.DEEPSLATE_BRICKS,
            Blocks.IRON_BLOCK, Blocks.DIAMOND_BLOCK,
            Blocks.DIRT, ModBlocks.FLOPPIUM_BLOCK.get()
    );

    public ChiselItem(Properties properties) {
        super(properties);
    }


    @Override
    public InteractionResult useOn(UseOnContext p_41427_) {
        Level level = p_41427_.getLevel();
        Block clickedBlock = level.getBlockState(p_41427_.getClickedPos()).getBlock();

        if(CHISEL_MAP.containsKey(clickedBlock)) {
            if(!level.isClientSide()){
                level.setBlockAndUpdate(p_41427_.getClickedPos(), CHISEL_MAP.get(clickedBlock).defaultBlockState());
                p_41427_.getItemInHand().hurtAndBreak(1, ((ServerLevel) level), ((ServerPlayer) p_41427_.getPlayer()),
                        item -> p_41427_.getPlayer().onEquippedItemBroken(item, EquipmentSlot.MAINHAND));

                level.playSound(null, p_41427_.getClickedPos(), SoundEvents.GRINDSTONE_USE, SoundSource.BLOCKS, 1.0F, 1.0F);
            }
        }

        return InteractionResult.SUCCESS;
    }
}
