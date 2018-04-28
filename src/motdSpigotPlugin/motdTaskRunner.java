package motdSpigotPlugin;

import java.io.BufferedReader;
import java.io.FileReader;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;
//import org.bukkit.scheduler.BukkitTask;
import org.bukkit.ChatColor;

public class motdTaskRunner extends BukkitRunnable {

	@Override
	public void run() {
		String motd = "";
		try {
			
			BufferedReader reader = new BufferedReader(new FileReader(motdPlugin.file));
			motd = reader.readLine();
			reader.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', motd));
		
	}


}
