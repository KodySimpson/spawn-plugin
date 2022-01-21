package me.kodysimpson.spawnplugin;

import me.kodysimpson.spawnplugin.commands.SetSpawnCommand;
import me.kodysimpson.spawnplugin.commands.SpawnCommand;
import me.kodysimpson.spawnplugin.listeners.SpawnListeners;
import org.bukkit.plugin.java.JavaPlugin;

public final class SpawnPlugin extends JavaPlugin {

    @Override
    public void onEnable() {

        //Setup/Load Config
        getConfig().options().copyDefaults();
        saveDefaultConfig();

        //register the commands
        getCommand("setspawn").setExecutor(new SetSpawnCommand(this));
        getCommand("spawn").setExecutor(new SpawnCommand(this));

        //register the events
        getServer().getPluginManager().registerEvents(new SpawnListeners(this), this);

    }

}
