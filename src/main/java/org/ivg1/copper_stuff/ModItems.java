package org.ivg1.copper_stuff;

import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.equipment.*;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.item.Items;

import java.util.Map;

import static org.ivg1.copper_stuff.Copper_stuff.MOD_ID;

public class ModItems {
    private ModItems() {}

    //give material to copper tools
    public static final ToolMaterial COPPER_TOOL_MATERIAL = new ToolMaterial(
            BlockTags.INCORRECT_FOR_DIAMOND_TOOL,
            300,
            12.0F,
            2.5F,
            22,
            ToolMaterial.WOOD.repairItems()
    );

    // Register copper sword
    public static final Item COPPER_SWORD = register(
            "copper_sword",
            settings -> new Item(settings.sword(COPPER_TOOL_MATERIAL, 3.5f, -2.4f)), // 2.5 + 3.5 = 6
            new Item.Settings()
    );

    // Register copper pickaxe
    public static final Item COPPER_PICKAXE = register(
            "copper_pickaxe",
            settings -> new Item(settings.pickaxe(COPPER_TOOL_MATERIAL, 2.5f, -2.8f)), // 5 total
            new Item.Settings()
    );

    // Register copper axe
    public static final Item COPPER_AXE = register(
            "copper_axe",
            settings -> new Item(settings.axe(COPPER_TOOL_MATERIAL, 5.5f, -3.0f)), // 8 total
            new Item.Settings()
    );

    // Register copper shovel
    public static final Item COPPER_SHOVEL = register(
            "copper_shovel",
            settings -> new Item(settings.shovel(COPPER_TOOL_MATERIAL, 2.0f, -3.0f)), // 4.5 total
            new Item.Settings()
    );

    // Register copper hoe
    public static final Item COPPER_HOE = register(
            "copper_hoe",
            settings -> new Item(settings.hoe(COPPER_TOOL_MATERIAL, 1.0f, -3.0f)), // 3.5 total
            new Item.Settings()
    );

    //make copper armor material
    public static class CopperArmorMaterial {
        public static final int BASE_DURABILITY = 15;
        public static final RegistryKey<EquipmentAsset> COPPER_ARMOR_MATERIAL_KEY = RegistryKey.of(EquipmentAssetKeys.REGISTRY_KEY, Identifier.of(MOD_ID, "copper_armor"));

        public static final ArmorMaterial INSTANCE = new ArmorMaterial(
                BASE_DURABILITY,
                Map.of(
                        EquipmentType.HELMET, 3,
                        EquipmentType.CHESTPLATE, 8,
                        EquipmentType.LEGGINGS, 6,
                        EquipmentType.BOOTS, 3
                ),
                5,
                SoundEvents.ITEM_ARMOR_EQUIP_GOLD,
                0.0F,
                0.0F,
                ArmorMaterials.IRON.repairIngredient(),
                COPPER_ARMOR_MATERIAL_KEY
        );
    }

    //register copper helmet
    public static final Item COPPER_HELMET = register(
            "copper_helmet",
            settings -> new Item(
                    settings.armor(CopperArmorMaterial.INSTANCE, EquipmentType.HELMET)
            ),
            new Item.Settings().maxDamage(
                    EquipmentType.HELMET.getMaxDamage(CopperArmorMaterial.BASE_DURABILITY)
            )
    );

    //register copper chestplate
    public static final Item COPPER_CHESTPLATE = register(
            "copper_chestplate",
            settings -> new Item(
                    settings.armor(CopperArmorMaterial.INSTANCE, EquipmentType.CHESTPLATE)
            ),
            new Item.Settings().maxDamage(
                    EquipmentType.CHESTPLATE.getMaxDamage(CopperArmorMaterial.BASE_DURABILITY)
            )
    );

    //register copper chestplate
    public static final Item COPPER_LEGGINGS = register(
            "copper_leggings",
            settings -> new Item(
                    settings.armor(CopperArmorMaterial.INSTANCE, EquipmentType.LEGGINGS)
            ),
            new Item.Settings().maxDamage(
                    EquipmentType.LEGGINGS.getMaxDamage(CopperArmorMaterial.BASE_DURABILITY)
            )
    );

    //register copper boots
    public static final Item COPPER_BOOTS = register(
            "copper_boots",
            settings -> new Item(
                    settings.armor(CopperArmorMaterial.INSTANCE, EquipmentType.BOOTS)
            ),
            new Item.Settings().maxDamage(
                    EquipmentType.BOOTS.getMaxDamage(CopperArmorMaterial.BASE_DURABILITY)
            )
    );



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
