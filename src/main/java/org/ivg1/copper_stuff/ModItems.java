package org.ivg1.copper_stuff;

import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.Identifier;
import net.minecraft.item.Items;

public class ModItems {
    private ModItems() {}

    //give material to copper tools
    public static final ToolMaterial COPPER_TOOL_MATERIAL = new ToolMaterial(
            BlockTags.INCORRECT_FOR_WOODEN_TOOL,
            455,
            5.0F,
            1.5F,
            22,
            ToolMaterial.WOOD.repairItems()
    );

    //register copper sword
    public static final Item COPPER_SWORD = register(
            "copper_sword",
            settings -> new Item(settings.sword(COPPER_TOOL_MATERIAL, 3.0f, -2.4f)),
            new Item.Settings()
    );

    //register other tools... (TO-DO)

    //register armor... (TO-DO)

    //register items function
    private static Item register(String path, java.util.function.Function<Item.Settings, Item> factory, Item.Settings settings) {
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, Identifier.of("copper_stuff", path));
        return Items.register(key, factory, settings);
    }

    //when called, add items to groups
    public static void initialize() {
        ModItemsGroupAdding.initialize();
    }
}
