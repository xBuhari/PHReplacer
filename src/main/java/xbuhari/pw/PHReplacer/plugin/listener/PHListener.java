package xbuhari.pw.PHReplacer.plugin.listener;

import me.clip.placeholderapi.PlaceholderAPI;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import xbuhari.pw.PHReplacer.Main;
import xbuhari.pw.PHReplacer.plugin.PHRText;
import xbuhari.pw.PHReplacer.plugin.ReplaceManager;
import xbuhari.pw.PHReplacer.spigot.Utils;

import java.util.HashMap;
import java.util.Map;

public class PHListener extends PlaceholderExpansion {
    private final String version;

    public PHListener() {
        this.version = Main.getPlugin().getDescription().getVersion();
    }

    public String getIdentifier() {
        return "phr";
    }

    public String getAuthor() {
        return "xBuhari";
    }

    public String getVersion() {
        return this.version;
    }

    public String onPlaceholderRequest(Player player, String identifier) {
        HashMap<String, PHRText> _temp = Main.getPlugin().getRm().getTextList().get(ReplaceManager.PHMode.PlaceHolderAPI);
        if (_temp.containsKey(identifier)) {
            PHRText phrText = _temp.get(identifier);
            return Utils.replaced(ChatColor.translateAlternateColorCodes('&', PlaceholderAPI.setPlaceholders((phrText.getReq_player()) ? player : null, phrText.getPlaceholder())), phrText.getReplaces());
        }
        return null;
    }
}
