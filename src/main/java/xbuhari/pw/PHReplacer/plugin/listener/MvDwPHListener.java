package xbuhari.pw.PHReplacer.plugin.listener;

import be.maximvdw.placeholderapi.PlaceholderAPI;
import be.maximvdw.placeholderapi.PlaceholderReplaceEvent;
import be.maximvdw.placeholderapi.PlaceholderReplacer;
import org.bukkit.ChatColor;

import xbuhari.pw.PHReplacer.Main;
import xbuhari.pw.PHReplacer.plugin.PHRText;
import xbuhari.pw.PHReplacer.plugin.ReplaceManager;
import xbuhari.pw.PHReplacer.spigot.Utils;

import java.util.HashMap;
import java.util.Map;

public class MvDwPHListener {

    public void register() {
        for (ReplaceManager.PHMode _key : Main.getPlugin().getRm().getTextList().keySet()) {
            PlaceholderAPI.registerPlaceholder(Main.getPlugin(), "phr_" + _key.toString() ,event -> {
                HashMap<String, PHRText> _temp = Main.getPlugin().getRm().getTextList().get(ReplaceManager.PHMode.MVdWPlaceholderAPI);
                if (_temp.containsKey(event.getPlaceholder().split("_")[1])) {
                    PHRText phrText = _temp.get(event.getPlaceholder().split("_")[1]);
                    return Utils.replaced(ChatColor.translateAlternateColorCodes('&', PlaceholderAPI.replacePlaceholders((phrText.getReq_player()) ? event.getPlayer() : null, phrText.getPlaceholder())), phrText.getReplaces());
                }
                return null;
            });
        }
    }
}
