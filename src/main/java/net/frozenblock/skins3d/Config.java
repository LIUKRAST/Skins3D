package net.frozenblock.skins3d;

import java.io.*;
import java.nio.file.Files;
import java.util.Properties;

public class Config {

    public static void createConfig() {

        try (OutputStream output = new FileOutputStream(String.valueOf(Skins3D.CONFIG_PATH))) {
            Properties prop = new Properties();
            prop.setProperty("player", "true");
            prop.setProperty("player.heads", "true");
            prop.setProperty("resolution", "25");
            prop.store(output, null);
        } catch (IOException io) {
            io.printStackTrace();
        }
    }

    public static Object getConfig(String property) {
        if (!Files.exists(Skins3D.CONFIG_PATH)) {
            createConfig();
        } else {
            try (InputStream input = new FileInputStream(String.valueOf(Skins3D.CONFIG_PATH))) {
                Properties prop = new Properties();

                prop.load(input);

                return prop.getProperty(property);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }

    public static Object getFixedConfig(String property) {
        if (getConfig(property) == null) {
            if (Files.exists(Skins3D.CONFIG_PATH)) {
                try {
                    Files.delete(Skins3D.CONFIG_PATH);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            createConfig();
        }
        return getConfig(property);
    }
}
