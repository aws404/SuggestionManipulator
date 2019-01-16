package aws404.sugestionmanipulator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandSendEvent;

public class PlayerListener implements Listener{
	@SuppressWarnings("unused")
	private Main plugin;

	
	public PlayerListener(Main plugin) {
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
        this.plugin = plugin;
	}
	
	@EventHandler
	public void sendCommandList(PlayerCommandSendEvent e) {
		Collection<String> commandlist = e.getCommands();
		Collection<String> send = new ArrayList<>();
		
		Collection<String> list = FileManager.getConfig().getStringList("list");
		
		if(FileManager.getConfig().getBoolean("remove-colon")) {
			if (FileManager.getConfig().getString("whitelist-blacklist").equalsIgnoreCase("blacklist")) {
				//Things in list should not be shown
				for (Object x : commandlist) {
					if (!(x.toString().contains(":")) && !(list.contains(x.toString().toLowerCase()))) {
						send.add(x.toString());
					}
				}
			}	
		} else {
			if (FileManager.getConfig().getString("whitelist-blacklist").equalsIgnoreCase("blacklist")) {
				//Things in list should not be shown
				for (Object x : commandlist) {
					if (!(list.contains(x.toString().toLowerCase()))) {
						send.add(x.toString());
					}
				}
			}	
		}
		

		if (FileManager.getConfig().getString("whitelist-blacklist").equalsIgnoreCase("whitelist")) {
			//Things in list SHOULD shown
			Set<String> perms = FileManager.getConfig().getConfigurationSection("permission-based").getKeys(true);
			for (Object x : list) {
				send.add(x.toString());
			}
			for (String x : perms) {
				String x1 = x;
				if (e.getPlayer().hasPermission("suggestionmanipulator." + x)) {
					Collection<String> addperms = FileManager.getConfig().getStringList("permission-based." + x1);
					for (String add : addperms) {
						send.add(add);
					}
				}
			}
		}

		
		commandlist.removeAll(commandlist);
		commandlist.addAll(send);

	}
	

}
