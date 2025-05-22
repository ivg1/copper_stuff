package org.ivg1.copper_stuff;

import net.fabricmc.api.ModInitializer;

public class Copper_stuff implements ModInitializer {
    public static final String MOD_ID = "copper_stuff";

    @Override
    public void onInitialize() {
        ModItems.initialize();
    }
}
