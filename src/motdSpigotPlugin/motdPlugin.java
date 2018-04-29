package motdSpigotPlugin;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
//import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
//import org.bukkit.scheduler.BukkitTask;

public class motdPlugin extends JavaPlugin{
	public static File file;
	@Override
	public void onEnable() {
		int min1 = 10;
		createConfig();
		getLogger().info("motdPlugin is enabled."); //apparently spigot does this automatically?
		getServer().getPluginManager().registerEvents(new MyListener(), this);
		this.getCommand("setmotd").setExecutor(new motdCommands());
		motdTaskRunner task1 = new motdTaskRunner();
		task1.runTaskTimer(this, 200L, min1*1200L); //20ticks/sec, 1200ticks/min
		
		//COMPLETE: Build the default config (if config is not present) with a single string for message of the day (motd).
		//COMPLETE: Prints the message of the day to the console via configured motd.
		//COMPLETE: Starts a synchronous task to broadcast the message of the day every 10 minutes.
		//COMPLETE: Plays a sound to a player when they join the server.
		

	}
	private void createConfig() {
		try {
			if(!getDataFolder().exists()) {
				getDataFolder().mkdirs();
			}
			file = new File(getDataFolder(), "config.yml");
			if(!file.exists()) {
				getLogger().info("config.yml file not found, creating new config file.");
				try {
					file.createNewFile();
					BufferedWriter writer = new BufferedWriter(new FileWriter(file));
					writer.write("Default Message of the Day. Change in the config.yml file.");
					writer.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
				saveDefaultConfig();
			}else {
				getLogger().info("config.yml file found, loading.");
				BufferedReader reader = new BufferedReader(new FileReader(file));
				String line;
				String motd = "";
				while((line = reader.readLine())!=null) {
					motd.concat(" "+line);
				}
				
				
				reader.close();
				
				getLogger().info("Message of the Day is: "+ motd);
				
			}
			
		
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void onDisable() {
		getLogger().info("motdPlugin is disabled.  Sad Panda.  :(   ");
		
		//COMPLETE: Send a sad message to console that the plugin is being unloaded.
		//Maybe complete?: Cancel all running tasks.
		
	}
	
	

}
