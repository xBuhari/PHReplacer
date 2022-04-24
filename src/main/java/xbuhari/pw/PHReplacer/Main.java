package xbuhari.pw.PHReplacer;

import xbuhari.pw.PHReplacer.plugin.ReplaceManager;
import xbuhari.pw.PHReplacer.spigot.SpigotPlugin;

public class Main extends SpigotPlugin {
    private static Main plugin;
    private ReplaceManager rm;

    @Override
    public void onEnable() {
        plugin = this;
        this.reload();
        this.rm = new ReplaceManager();
    }

    @Override
    public void onDisable() {

    }

    public ReplaceManager getRm() {
        return rm;
    }

    public static Main getPlugin() {
        return plugin;
    }
}
