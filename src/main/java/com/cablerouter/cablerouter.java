package com.cablerouter;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod(cablerouter.MOD_ID)
public class cablerouter {

    public static final String MOD_ID = "cablerouter";
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MOD_ID);
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister
            .create(Registries.CREATIVE_MODE_TAB, MOD_ID);
    public static final RegistryObject<Item> CABLE_ROUTER = ITEMS.register("cable_router",
            () -> new cablerouteritem(new Item.Properties()));

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            event.accept(CABLE_ROUTER);
        }
    }

    @SuppressWarnings("removal")
    public cablerouter() {
        IEventBus modeventbus = FMLJavaModLoadingContext.get().getModEventBus();
        modeventbus.addListener(this::addCreative);
        ITEMS.register(modeventbus);
        CREATIVE_MODE_TABS.register(modeventbus);
    }
}
