package org.ivg1.copper_stuff;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroups;

public class ModItemsGroupAdding {
    private ModItemsGroupAdding() {}

    public static void initialize() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register((entries) -> {
            entries.add(ModItems.COPPER_SWORD);
            entries.add(ModItems.COPPER_PICKAXE);
            entries.add(ModItems.COPPER_AXE);
            entries.add(ModItems.COPPER_SHOVEL);
            entries.add(ModItems.COPPER_HOE);

            entries.add(ModItems.COPPER_HELMET);
            entries.add(ModItems.COPPER_CHESTPLATE);
            entries.add(ModItems.COPPER_LEGGINGS);
            entries.add(ModItems.COPPER_BOOTS);
        });
    }
}
