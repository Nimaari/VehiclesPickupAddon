package tk.nimari;

import es.pollitoyeye.vehicles.enums.VehicleType;
import es.pollitoyeye.vehicles.events.VehiclePickupEvent;
import org.bstats.bukkit.Metrics;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;

public final class VehiclesPickupAddon extends JavaPlugin {

    public FileConfiguration config = this.getConfig();

    @Override
    public void onEnable() {
        long currentTime = System.currentTimeMillis();

        new Metrics(this, 16781);

        for (VehicleType vehicleType : VehicleType.values())
            config.addDefault("allow" + vehicleType.getConfigName() + "Pickup", true);

        config.addDefault("sendMessageOnDeniedPickup", false);
        config.addDefault("deniedPickupMessage", "&8[&eVehiclesPickupAddon&8] &cYou are not allowed to pick up this vehicle!");
        config.options().copyDefaults(true);
        saveConfig();
        Bukkit.getPluginManager().registerEvents(new Listeners(), this);

        getLogger().log(Level.INFO, "Successful startup! Took " + (System.currentTimeMillis() - currentTime) + "ms.");
    }

    @Override
    public void onDisable() {
        getLogger().log(Level.INFO, "Leaving so soon? Drive safe!");
    }

    public class Listeners implements Listener {

        @EventHandler
        public void noVehiclePickup(VehiclePickupEvent e) {
            if (!e.getPlayer().hasPermission("vehicles.pickupoverride") && !config.getBoolean("allow" + e.getVehicleType().getConfigName() + "Pickup")) {
                e.setCancelled(true);

                if (config.getBoolean("sendMessageOnDeniedPickup"))
                    e.getPlayer().sendMessage(config.getString("deniedPickupMessage").replace("&", "§"));
            }
        }
    }
}