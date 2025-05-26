package org.ivg1.copper_stuff;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.item.ItemGroup;

import static org.ivg1.copper_stuff.ModItems.*;

public class ModItemGroups {

    public static final RegistryKey<ItemGroup> COPPER_STUFF_GROUP = RegistryKey.of(
            Registries.ITEM_GROUP.getKey(),
            Identifier.of("copper_stuff", "copper_group")
    );

    public static void registerItemGroups() {
        Registry.register(Registries.ITEM_GROUP, COPPER_STUFF_GROUP,
                FabricItemGroup.builder()
                        .icon(() -> new ItemStack(COPPER_SWORD)) // icon for the group tab
                        .displayName(Text.translatable("Copper stuff mod"))
                        .entries((context, entries) -> {
                            //copper weapons
                            entries.add(COPPER_SWORD);
                            entries.add(COPPER_PICKAXE);
                            entries.add(COPPER_AXE);
                            entries.add(COPPER_SHOVEL);
                            entries.add(COPPER_HOE);

                            //copper armor
                            entries.add(COPPER_HELMET);
                            entries.add(COPPER_CHESTPLATE);
                            entries.add(COPPER_LEGGINGS);
                            entries.add(COPPER_BOOTS);

                            //more copper stuff
                            entries.add(COPPER_NUGGET);

                            entries.add(OP_COPPER_AXE);
                            entries.add(OP_COPPER_PICKAXE);
                            entries.add(OP_COPPER_SWORD);
                            entries.add(OP_WEAPONS_UNLOCKER);
                        })
                        .build()
        );

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries -> {
            entries.add(COPPER_SWORD);
            entries.add(COPPER_AXE);

            entries.add(COPPER_HELMET);
            entries.add(COPPER_CHESTPLATE);
            entries.add(COPPER_LEGGINGS);
            entries.add(COPPER_BOOTS);

            entries.add(OP_COPPER_AXE);
            entries.add(OP_COPPER_SWORD);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(entries -> {
            entries.add(COPPER_SHOVEL);
            entries.add(COPPER_PICKAXE);
            entries.add(COPPER_AXE);
            entries.add(COPPER_HOE);

            entries.add(OP_COPPER_AXE);
            entries.add(OP_COPPER_PICKAXE);
        });


    }
}
