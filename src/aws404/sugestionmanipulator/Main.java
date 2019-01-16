package aws404.sugestionmanipulator;


import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import aws404.sugestionmanipulator.Command;







public class Main extends JavaPlugin {
	
	//Define variables
	public static Main instance;
	
    private Command Command;
    
    static Logger log;

    
    
    //On Enable
    @Override
    public void onEnable() {
        
    	//Misc Variables
    	instance = this;
        log = this.getLogger();
        Command = new Command(this);
        
        this.getConfig().options().copyDefaults(true);
        saveDefaultConfig();
        saveConfig();
        this.getConfig().options().header("Suggestion Manipulator|by aws404");
       	new FileManager(this);
        
        
  

        

        getCommand("suggestionmanipulator").setExecutor(Command);
        
        //Register Classes
        new PlayerListener(this);


        
        
        //Message
        Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_GREEN + "._/ " + ChatColor.GOLD + "Command Sugestion Manipulator Loaded Sucessfully!");
        
    }
    
    
   
    
    
    
    
    //On Disable
    @Override
    public void onDisable() {

    }


    
      
}
