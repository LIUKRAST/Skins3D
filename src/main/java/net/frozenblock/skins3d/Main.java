package net.frozenblock.skins3d;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;

import java.nio.file.Path;

public class Main implements ModInitializer {

    public static final String MOD_ID = "skins3d";
    public static final Path CONFIG_PATH = FabricLoader.getInstance().getConfigDir().resolve("liukrastskins3d.json");

    @Override
    public void onInitialize() {
        System.out.println("Initializing " + MOD_ID);
    }
}
