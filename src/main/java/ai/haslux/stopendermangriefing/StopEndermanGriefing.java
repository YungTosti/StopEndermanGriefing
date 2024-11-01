package ai.haslux.stopendermangriefing;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Enderman;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityChangeBlockEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class StopEndermanGriefing extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);
        getLogger().info("StopEndermanGriefing has been enabled! Preventing Endermen from picking up blocks.");
    }

    @EventHandler
    public void onEntityChangeBlock(EntityChangeBlockEvent event) {

        // Is this an enderman?
        if (event.getEntity() instanceof Enderman enderman) {

            // Always cancel the event
            event.setCancelled(true);

            // If they're holding a block, remove them as well
            if (enderman.getEquipment().getItemInMainHand().getType() != Material.AIR) {
                enderman.remove();
            }
        }
    }
}
