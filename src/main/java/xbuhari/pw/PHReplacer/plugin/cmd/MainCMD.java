package xbuhari.pw.PHReplacer.plugin.cmd;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import xbuhari.pw.PHReplacer.Main;

public class MainCMD implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String cmdLabel, String[] args) {
        if (sender instanceof ConsoleCommandSender || sender instanceof Player) {
            if (args.length == 1) {
                if (args[0].equalsIgnoreCase("reload")) {
                    if (sender instanceof ConsoleCommandSender || sender.isOp()) {
                        Main.getPlugin().reload();
                        Main.getPlugin().getRm().update();
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cPHReplacer &aReloaded config.yml; if not, restart the plugin."));
                        return false;
                    }
                }
            }
            return false;
        }
        return false;
    }
}
