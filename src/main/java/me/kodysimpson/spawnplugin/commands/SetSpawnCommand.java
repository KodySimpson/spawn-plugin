package me.kodysimpson.spawnplugin.commands;

import me.kodysimpson.spawnplugin.SpawnPlugin;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetSpawnCommand implements CommandExecutor {

    private final SpawnPlugin spawnPlugin;

    public SetSpawnCommand(SpawnPlugin spawnPlugin){
        this.spawnPlugin = spawnPlugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        //Make sure that they are a player
        if (sender instanceof Player){
            Player player = (Player) sender;

            //get the players location
            Location location = player.getLocation();

            //set the spawn location in the config.yml
//            spawnPlugin.getConfig().set("spawn.x", location.getX());
//            spawnPlugin.getConfig().set("spawn.y", location.getY());
//            spawnPlugin.getConfig().set("spawn.z", location.getZ());

            //A Location is a special type of object that can be saved to a config.yml automatically by bukkit
            //This is because it implements ConfigurationSerializable
            spawnPlugin.getConfig().set("spawn", location);

            //save the config.yml
            spawnPlugin.saveConfig();

            //send a message to the player
            player.sendMessage("Spawn location set!");

        }else{
            System.out.println("Bruh get yo ass on the server.");
        }

        return true;
    }
}
