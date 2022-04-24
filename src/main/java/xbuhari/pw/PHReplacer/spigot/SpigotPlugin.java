package xbuhari.pw.PHReplacer.spigot;

import org.bukkit.plugin.java.JavaPlugin;
import xbuhari.pw.PHReplacer.Main;

public class SpigotPlugin extends JavaPlugin {

    public void reload() {
        saveDefaultConfig();
        reloadConfig();
    }
}
