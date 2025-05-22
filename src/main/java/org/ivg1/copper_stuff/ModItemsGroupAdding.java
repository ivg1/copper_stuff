package org.ivg1.copper_stuff;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroups;

public class ModItemsGroupAdding {
    private ModItemsGroupAdding() {}

    public static void initialize() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register((entries) -> {
            entries.add(ModItems.COPPER_SWORD);
        });
    }
}
