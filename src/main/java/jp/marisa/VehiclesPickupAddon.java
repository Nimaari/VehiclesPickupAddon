package jp.marisa;

import es.pollitoyeye.vehicles.enums.VehicleType;
import es.pollitoyeye.vehicles.events.VehiclePickupEvent;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class VehiclesPickupAddon extends JavaPlugin {

    public FileConfiguration config = this.getConfig();

    @Override
    public void onEnable() {
        long currentTime = System.currentTimeMillis();

        for (VehicleType vehicleType : VehicleType.values()) {
            config.addDefault("allow" + vehicleType.getConfigName() + "Pickup", true);
        }
        config.options().copyDefaults(true);
        saveConfig();
        Bukkit.getPluginManager().registerEvents(new Listeners(), this);

        System.out.println("[VehiclesPickupAddon] Successful startup took " + (System.currentTimeMillis() - currentTime) + "ms.");
    }

    @Override
    public void onDisable() {
        System.out.println("[VehiclesPickupAddon] Bye-bye! See you another time.");
    }

    public class Listeners implements Listener {

        @EventHandler
        public void noVehiclePickup(VehiclePickupEvent e) {
            if (!e.getPlayer().hasPermission("vehicles.pickupoverride") && !config.getBoolean("allow" + e.getVehicleType().getConfigName() + "Pickup"))
                e.setCancelled(true);
        }
    }
}