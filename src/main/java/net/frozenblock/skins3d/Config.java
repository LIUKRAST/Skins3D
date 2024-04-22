package net.frozenblock.skins3d;

import java.io.*;
import java.nio.file.Files;
import java.util.Properties;

import static net.frozenblock.skins3d.Skins3D.logger;

public final class Config {
    private Config() {}

    public static void createConfig() {
        try (final OutputStream output = new FileOutputStream(String.valueOf(Skins3D.CONFIG_PATH))) {
            final Properties prop = new Properties();
            prop.setProperty("player", "true");
            prop.setProperty("player.heads", "true");
            prop.setProperty("resolution", "25");
            prop.store(output, null);
        } catch (final IOException ex) {
            logger.error(ex.getMessage());
        }
    }
    public static Object getConfig(final String property) {
        if (!Files.exists(Skins3D.CONFIG_PATH)) createConfig();
        else {
            try (final InputStream input = new FileInputStream(String.valueOf(Skins3D.CONFIG_PATH))) {
                final Properties prop = new Properties();
                prop.load(input);
                return prop.getProperty(property);
            } catch (final IOException ex) {
                logger.error(ex.getMessage());
            }
        }
        return null;
    }
}
