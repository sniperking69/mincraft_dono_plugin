package me.assman.assPlugin;

import me.assman.assPlugin.command.creeperCommand;
import org.bukkit.plugin.java.JavaPlugin;

public class assPlugin extends JavaPlugin {
    @Override
    public void onEnable() {
        getLogger().info("onEnable is called!");
        new creeperCommand(this);
    }
    @Override
    public void onDisable() {
        getLogger().info("onDisable is called!");
    }
}
