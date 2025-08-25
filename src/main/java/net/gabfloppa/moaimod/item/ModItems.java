package net.gabfloppa.moaimod.item;

import net.gabfloppa.moaimod.MoaiMod;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, MoaiMod.MOD_ID);

    public static final RegistryObject<Item> MOAI = ITEMS.register("moai", () -> new Item((new Item.Properties())));

    public static final RegistryObject<Item> FLOPPA = ITEMS.register("floppa", () -> new Item((new Item.Properties())));


    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);

    }
}
