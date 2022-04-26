package xbuhari.pw.PHReplacer.plugin;

import org.bukkit.Bukkit;
import org.bukkit.configuration.ConfigurationSection;
import xbuhari.pw.PHReplacer.Main;
import xbuhari.pw.PHReplacer.plugin.cmd.MainCMD;
import xbuhari.pw.PHReplacer.plugin.listener.MvDwPHListener;
import xbuhari.pw.PHReplacer.plugin.listener.PHListener;

import java.util.HashMap;

public class ReplaceManager {
    private HashMap<PHMode, HashMap<String, PHRText>> textList;

    public ReplaceManager() {
        this.update();
        if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI")!=null) {
            new PHListener().register();
        }
        if (Bukkit.getPluginManager().getPlugin("MVdWPlaceholderAPI")!=null) {
            new MvDwPHListener().register();
        }
        Main.getPlugin().getCommand("phreplacer").setExecutor(new MainCMD());
    }

    public void update() {
        this.textList = new HashMap<>();
        ConfigurationSection _cs = Main.getPlugin().getConfig().getConfigurationSection("texts");
        for (String type : _cs.getKeys(false)) {
            PHMode phMode;
            try {
                phMode = PHMode.valueOf(type);
            }
            catch (Exception e){
                Main.getPlugin().getLogger().warning("Not found placeholder type = " + type);
                continue;
            }
            HashMap<String, PHRText> _temp = new HashMap<>();
            ConfigurationSection _csPh = _cs.getConfigurationSection(phMode.toString());
            for (String _keyPH : _csPh.getKeys(false)) {
                HashMap<String, String> replaces = new HashMap<>();
                for (String _key : _csPh.getConfigurationSection(_keyPH + ".replaces").getKeys(false)) {
                    replaces.put(_key, _csPh.getConfigurationSection(_keyPH + ".replaces").getString(_key));
                }
                _temp.put(_keyPH, new PHRText(
                        _keyPH,
                        _csPh.getString(_keyPH + ".placeholder"),
                        replaces,
                        _csPh.getBoolean(_keyPH + ".require_player")
                ));
            }
            this.textList.put(phMode, _temp);
        }
    }

    public HashMap<PHMode, HashMap<String, PHRText>> getTextList() {
        return textList;
    }

    public enum PHMode {
        PlaceHolderAPI(0),
        MVdWPlaceholderAPI(1);

        int index;

        PHMode(int i) {
            this.index = i;
        }

        public int getIndex() {
            return index;
        }
    }
}
