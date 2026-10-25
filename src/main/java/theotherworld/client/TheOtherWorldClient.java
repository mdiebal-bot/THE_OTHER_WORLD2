package theotherworld.client;

import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import software.bernie.geckolib.model.DefaultedBlockGeoModel;
import software.bernie.geckolib.renderer.GeoBlockEntityRenderer;
import theotherworld.ModBlocks;

public class TheOtherWorldClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockEntityRenderers.register(ModBlocks.DIMENSIONAL_CORE_BE,
                context -> new GeoBlockEntityRenderer<>(new DefaultedBlockGeoModel<>(ModBlocks.id("dimensional_core"))));
    }
}
