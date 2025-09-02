package net.gabfloppa.moaimod.item;

import net.gabfloppa.moaimod.MoaiMod;
import net.gabfloppa.moaimod.item.custom.ChiselItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.apache.logging.log4j.Logger;

import org.apache.logging.log4j.LogManager;


public class ModItems {
    public static final Logger LOGGER = LogManager.getLogger();

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, MoaiMod.MOD_ID);

    public static final RegistryObject<Item> MOAI = ITEMS.register("moai", () -> new Item((new Item.Properties())));

    public static final RegistryObject<Item> FLOPPA = ITEMS.register("floppa", () -> new Item((new Item.Properties())));

    public static final RegistryObject<Item> RAW_FLOPPA = ITEMS.register("raw_floppa", () -> new Item((new Item.Properties())));

    public static final RegistryObject<Item> CHISEL = ITEMS.register("chisel", () -> new ChiselItem((new Item.Properties().durability(32))));


    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);

    }
    public static void logItems() {
        LOGGER.info("===== Items de moaimod =====");
        ITEMS.getEntries().forEach(item ->
                LOGGER.info("Registrado: {}", item.getId()));
        LOGGER.info("============================");
    }


}
