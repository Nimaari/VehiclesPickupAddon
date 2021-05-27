package jp.ataru;

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

        String[] strings = {"Bike", "Broom", "Car", "Helicopter", "Parachute", "Plane", "Raft", "Submarine", "Tank", "Train", "Hoverbike", "Sportbike", "RacingCar", "Drill", "Tractor"};
        for (String str : strings) {
            config.addDefault("allow" + str + "Pickup", true);
        }
        config.options().copyDefaults(true);
        saveConfig();
        Bukkit.getPluginManager().registerEvents(new Listeners(), this);

        System.out.println("[VehiclesPickupAddon] Hello! My maker is Ataru! Successful startup took " + (System.currentTimeMillis() - currentTime) + "ms.");
    }

    @Override
    public void onDisable() {
        System.out.println("[VehiclesPickupAddon] Bye-bye! See you another time.");
    }

    public class Listeners implements Listener {

        @EventHandler
        public void noVehiclePickup(VehiclePickupEvent e) {
            reloadConfig();
            if (!e.getPlayer().hasPermission("vehicles.pickupoverride")) {
                switch (e.getVehicleType()) {
                    case BIKE:
                        if (!config.getBoolean("allowBikePickup")) {
                            e.setCancelled(true);
                        }
                        break;
                    case BROOM:
                        if (!config.getBoolean("allowBroomPickup")) {
                            e.setCancelled(true);
                        }
                        break;
                    case CAR:
                        if (!config.getBoolean("allowCarPickup")) {
                            e.setCancelled(true);
                        }
                        break;
                    case HELICOPTER:
                        if (!config.getBoolean("allowHelicopterPickup")) {
                            e.setCancelled(true);
                        }
                        break;
                    case PARACHUTE:
                        if (!config.getBoolean("allowParachutePickup")) {
                            e.setCancelled(true);
                        }
                        break;
                    case PLANE:
                        if (!config.getBoolean("allowPlanePickup")) {
                            e.setCancelled(true);
                        }
                        break;
                    case RAFT:
                        if (!config.getBoolean("allowRaftPickup")) {
                            e.setCancelled(true);
                        }
                        break;
                    case SUBMARINE:
                        if (!config.getBoolean("allowSubmarinePickup")) {
                            e.setCancelled(true);
                        }
                        break;
                    case TANK:
                        if (!config.getBoolean("allowTankPickup")) {
                            e.setCancelled(true);
                        }
                        break;
                    case TRAIN:
                        if (!config.getBoolean("allowTrainPickup")) {
                            e.setCancelled(true);
                        }
                        break;
                    case HOVER_BIKE:
                        if (!config.getBoolean("allowHoverbikePickup")) {
                            e.setCancelled(true);
                        }
                        break;
                    case SPORT_BIKE:
                        if (!config.getBoolean("allowSportbikePickup")) {
                            e.setCancelled(true);
                        }
                        break;
                    case RACING_CAR:
                        if (!config.getBoolean("allowRacingCarPickup")) {
                            e.setCancelled(true);
                        }
                        break;
                    case TRACTOR:
                        if (!config.getBoolean("allowTractorPickup")) {
                            e.setCancelled(true);
                        }
                        break;
                    case DRILL:
                        if (!config.getBoolean("allowDrillPickup")) {
                            e.setCancelled(true);
                        }
                        break;
                }
            }
        }
    }
}