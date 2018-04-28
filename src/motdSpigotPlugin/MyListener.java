package motdSpigotPlugin;

//import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.EventHandler;

public class MyListener implements Listener{
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		//Bukkit.broadcastMessage("Hello, World!");
		event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.ENTITY_CAT_PURREOW, 1.0F, 1.0F);
	
	}
	
}
