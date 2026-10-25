package theotherworld;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.world.item.CreativeModeTabs;

public class TheOtherWorld implements ModInitializer {
    public static final String MOD_ID = "theotherworld";

    @Override
    public void onInitialize() {
        ModBlocks.init();
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.FUNCTIONAL_BLOCKS)
                .register(output -> output.accept(ModBlocks.DIMENSIONAL_CORE_ITEM));
    }
}
