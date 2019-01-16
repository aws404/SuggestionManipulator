package aws404.sugestionmanipulator;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;


public class Command implements CommandExecutor {
    @SuppressWarnings("unused")
	private Main plugin;
//    private Inventory inventory;
 
    public Command(Main plugin) {
        this.plugin = plugin;
    }
    
	@Override
	public boolean onCommand(CommandSender sender, org.bukkit.command.Command command, String commandLabel, String[] args) {


        if (command.getName().equalsIgnoreCase("suggestionmanipulator")) {     
        	if (args.length == 0) {
        		sender.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "Suggestion Manipulator - By aws404");
        		sender.sendMessage(ChatColor.GRAY + "Manipulates the list of command suggestions present in MC 1.13");
        		sender.sendMessage(ChatColor.GRAY + "" + ChatColor.ITALIC + "/suggestionmanipulator help " + ChatColor.RESET + ChatColor.GRAY + "for more");
        		sender.sendMessage(ChatColor.GRAY + "Version: 1.0");
        		return true;
        	}
        	if (args.length == 1) {
        		if (args[0].equalsIgnoreCase("help")) {
            		sender.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "Suggestion Manipulator - By aws404");
            		sender.sendMessage(ChatColor.GOLD + "/suggestionmanipulator OR /sm" + ChatColor.WHITE + " - Displays Basic Plugin info");
            		sender.sendMessage(ChatColor.GOLD + "/suggestionmanipulator help" + ChatColor.WHITE + " - Shows this help menu");
            		sender.sendMessage(ChatColor.GOLD + "/suggestionmanipulator reload" + ChatColor.WHITE + " - Reloads the config");
            		return true;
        		}
        		if (args[0].equalsIgnoreCase("reload")) {
        			FileManager.reloadConfigs();
        			sender.sendMessage(ChatColor.GOLD + "SuggestionManipulator >> " + ChatColor.GRAY + "Reloaded Configs! Relog for changes to take effect.");
        			return true;
        		}
        	}
 
        	return true;	
        }

        
        
       
		return false;
	}

}

