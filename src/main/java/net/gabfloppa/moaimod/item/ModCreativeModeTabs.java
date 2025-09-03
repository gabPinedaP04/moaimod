package net.gabfloppa.moaimod.item;

import net.gabfloppa.moaimod.MoaiMod;
import net.gabfloppa.moaimod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MoaiMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> MOAI_ITEMS_TAB = CREATIVE_MODE_TABS.register("creative_items_tab",
            ()-> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.FLOPPA.get()))
                    .title(Component.translatable("creativetab.moaimod.moai_items"))
                    .displayItems((itemDisplayParameters, output) ->{
                        output.accept(ModItems.FLOPPA.get());
                        output.accept(ModItems.MOAI.get());
                        output.accept(ModItems.CHISEL.get());
                        output.accept(ModItems.KOHLRABI.get());
                        output.accept(ModItems.AURORA_ASHES.get());

                    })
                    .build());
    public static final RegistryObject<CreativeModeTab> MOAI_BLOCKS_TAB = CREATIVE_MODE_TABS.register("creative_blocks_tab",
            ()-> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.FLOPPIUM_BLOCK.get()))
                    .withTabsBefore(MOAI_ITEMS_TAB.getId()) //Dar click en withTabsBefore para poder ver lo que contiene en origen
                    .title(Component.translatable("creativetab.moaimod.moai_block"))
                    .displayItems((itemDisplayParameters, output) ->{

                        output.accept(ModBlocks.NIGGUM_BLOCK.get());
                        output.accept(ModBlocks.FLOPPIUM_BLOCK.get());
                        output.accept(ModBlocks.MAGIC_BLOCK.get());
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);

    }

}
