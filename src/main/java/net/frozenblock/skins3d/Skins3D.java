package net.frozenblock.skins3d;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.Path;
import java.util.Objects;

public final class Skins3D implements ModInitializer {
    public static boolean configRes1;
    public static boolean configRes2;
    public static int configRes3;
    public static boolean configRes4 = false;

    public static final Logger logger = LoggerFactory.getLogger("skins3d");
    public static final Path CONFIG_PATH = FabricLoader.getInstance().getConfigDir().resolve("liukrast3dskins.json");

    @Override
    public void onInitialize() {
        Skins3D.configRes1 = Boolean.parseBoolean((String) Config.getConfig("player"));
        Skins3D.configRes2 = Boolean.parseBoolean((String) Config.getConfig("player.heads"));
        Skins3D.configRes3 = Integer.parseInt((String) Objects.requireNonNull(Config.getConfig("resolution")));
    }
}
