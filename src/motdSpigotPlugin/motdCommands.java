package motdSpigotPlugin;

import java.io.BufferedWriter;
import java.io.FileWriter;
//import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class motdCommands implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		//Bukkit.broadcastMessage("You input command, :"+command.getName()+"!");
		
		if(command.getName().equalsIgnoreCase("setmotd")) {
			try {
				BufferedWriter writer = new BufferedWriter(new FileWriter(motdPlugin.file));
				for(String item : args) {
					writer.write(item+" ");
					
				}				
				
				writer.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}

}
