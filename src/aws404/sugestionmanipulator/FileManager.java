package aws404.sugestionmanipulator;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class FileManager {

	
	public static YamlConfiguration config;
	private static File configFile;
	

	static Main plugin;
    public FileManager(Main pluginX) {
    plugin = pluginX;
 
    configFile = new File(plugin.getDataFolder(), "config.yml"); //The file (you can name it what you want)
    config = YamlConfiguration.loadConfiguration(configFile); //Take the file and basically turning it into a .yml file
    
        
    try {
        config.save(configFile);
    } catch (IOException e) {
        e.printStackTrace();
    }
    

    
}
    public static FileConfiguration getConfig() {
        if (config == null) {
            reloadConfigs();
        }
        return config;
    }

    


    public static void saveConfigs() {
        if (config == null || configFile == null) {
            return;
        }
        try {
            getConfig().save(configFile);
        } catch (IOException ex) {
            plugin.getLogger().log(Level.SEVERE, "Could not save config files" , ex);
        }
    }
    
    public static void reloadConfigs() {
        if (configFile == null) {
        configFile = new File(plugin.getDataFolder(), "config.yml");
        }
        config = YamlConfiguration.loadConfiguration(configFile);
    }
    
}
