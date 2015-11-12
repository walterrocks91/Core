package me.servername.core;

import me.servername.core.command.CommandHandler;
import me.servername.core.util.Tps;
import org.bukkit.plugin.java.JavaPlugin;
import me.servername.test.GameMode;

public class Main extends JavaPlugin{

    private static Main instance;

    public void onEnable(){
        instance = this;
        getServer().getScheduler().scheduleSyncRepeatingTask(this, new Tps(), 100L, 1L);
        getServer().getPluginManager().registerEvents(new CommandHandler(), this);
        CommandHandler.register(GameMode.class);
    }

    public static Main getInstance(){
        return instance;
    }

}