package net.gabfloppa.moaimod.block;


import net.gabfloppa.moaimod.MoaiMod;
import net.gabfloppa.moaimod.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    // Aquí se declara un registro diferido para todos los bloques del mod
    // Forge usa DeferredRegister para registrar cosas (bloques, ítems, etc.) en el momento correcto
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, MoaiMod.MOD_ID);

    //rEGISTRAR EL BLOQUE

    public static final RegistryObject<Block> FLOPPIUM_BLOCK = registerBlock("floppium_block",
            ()-> new Block(BlockBehaviour.Properties.of()
                    .strength(1.0F).requiresCorrectToolForDrops().sound(SoundType.ANVIL)
            ));

    public static final RegistryObject<Block> NIGGUM_BLOCK = registerBlock("niggum_block",
            ()-> new Block(BlockBehaviour.Properties.of()
                    .strength(1.0F).requiresCorrectToolForDrops().sound(SoundType.GLASS)
            ));

    // Método genérico para registrar un bloque
    // 1. Recibe un nombre y un Supplier (que crea el bloque)
    // 2. Lo registra en BLOCKS
    // 3. Llama a registerBlockItem para que ese bloque también tenga un item asociado (el que se usa en el inventario)
    // 4. Devuelve el RegistryObject (referencia al bloque registrado)
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> supplier) {
        RegistryObject<T> toReturn = BLOCKS.register(name, supplier);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    // Método para registrar el Item asociado al bloque
    // En Minecraft, un bloque no se puede tener en inventario si no existe un BlockItem
    // Aquí se crea un nuevo BlockItem a partir del bloque registrado y se mete en el registro de ítems
    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name, ()-> new BlockItem(block.get(), new Item.Properties()));
    }

    // Método que conecta el registro de bloques con el EventBus de Forge
    // Esto asegura que Forge realmente procese y registre los bloques durante el ciclo de carga del juego
    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }



}

