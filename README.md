# VehiclesPickupAddon
An open-source addon for the Minecraft plugin Vehicles that allows you to modify whether you can pick up vehicles or not.

Original [plugin](https://www.spigotmc.org/resources/%E2%9C%88%EF%B8%8Fvehicles-no-resourcepacks-needed.12446/) is by Pollitoyeye, I did **NOT** make the Vehicles plugin, I only made an addon for it utilizing its API.

## Configuration
NOTE: This configuration applies to THIS plugin config file, not Vehicles.
### Pickup settings
To disable picking up a vehicle:
```
allow<vehicle name>Pickup: false
```
Example: `allowHelicopterPickup: false`
To override pickup restriction, use a permission: ``vehicles.pickupoverride``
### Message on denied pickup
Enable/disable: `sendMessageOnDeniedPickup: true/false`  
Edit message text: `deniedPickupMessage: "&8[&eVehiclesPickupAddon&8] &cYou are not allowed to pick up this vehicle!"`
