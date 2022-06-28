package net.frozenblock.skins3d;

import net.minecraft.client.network.ClientPlayerEntity;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Objects;

public class Config {
    public static boolean getConfig(String type) throws IOException {
        if (!Files.exists(Main.CONFIG_PATH)) {
            fixConfig();
            return true;
        } else if( Files.readAllLines(Main.CONFIG_PATH).size() != 2) {
            fixConfig();
            return true;
        }
        ArrayList<String> result = (ArrayList<String>) Files.readAllLines(Main.CONFIG_PATH);
        if(Objects.equals(type, "enable")) {
            if (Objects.equals(result.get(0), "player: true")) {
                return true;
            } else if (Objects.equals(result.get(0), "player: false")) {
                return false;
            } else {
                Files.delete(Main.CONFIG_PATH);
                fixConfig();
                return true;
            }
        } else if(Objects.equals(type, "player heads")) {
            if (Objects.equals(result.get(1), "player heads: true")) {
                return true;
            } else if (Objects.equals(result.get(1), "player heads: false")) {
                return false;
            } else {
                Files.delete(Main.CONFIG_PATH);
                fixConfig();
                return true;
            }
        }
        return false;
    }


    public static void fixConfig() throws IOException {
        File config = new File(String.valueOf(Main.CONFIG_PATH));
        if(config.createNewFile()) {
            FileWriter config2 = new FileWriter(String.valueOf(Main.CONFIG_PATH));
            String configtext = "player: true" + "\n" + "player heads: true";
            config2.write(configtext);

            config2.close();
        }
    }
}
