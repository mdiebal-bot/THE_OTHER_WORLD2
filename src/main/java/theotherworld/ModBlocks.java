package theotherworld;

import java.util.Set;
import java.util.function.Function;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;

public final class ModBlocks {
    public static final Block DIMENSIONAL_CORE = registerBlock("dimensional_core", DimensionalCoreBlock::new,
            BlockBehaviour.Properties.of().strength(3.0f).requiresCorrectToolForDrops().noOcclusion().lightLevel(state -> 10));

    public static final Item DIMENSIONAL_CORE_ITEM = registerBlockItem("dimensional_core", DIMENSIONAL_CORE);

    public static final BlockEntityType<DimensionalCoreBlockEntity> DIMENSIONAL_CORE_BE = Registry.register(
            BuiltInRegistries.BLOCK_ENTITY_TYPE, id("dimensional_core"),
            new BlockEntityType<>(DimensionalCoreBlockEntity::new, Set.of(DIMENSIONAL_CORE)));

    public static Identifier id(String name) {
        return Identifier.fromNamespaceAndPath(TheOtherWorld.MOD_ID, name);
    }

    private static <T extends Block> T registerBlock(String name, Function<BlockBehaviour.Properties, T> factory,
            BlockBehaviour.Properties properties) {
        ResourceKey<Block> key = ResourceKey.create(Registries.BLOCK, id(name));
        T block = factory.apply(properties.setId(key));
        return Registry.register(BuiltInRegistries.BLOCK, key, block);
    }

    private static Item registerBlockItem(String name, Block block) {
        ResourceKey<Item> key = ResourceKey.create(Registries.ITEM, id(name));
        BlockItem item = new BlockItem(block, new Item.Properties().setId(key).useBlockDescriptionPrefix());
        return Registry.register(BuiltInRegistries.ITEM, key, item);
    }

    public static void init() {
    }
}
