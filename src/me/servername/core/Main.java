package me.servername.core;

import me.servername.core.command.CommandHandler;
import me.servername.core.command.builtin.LagCommand;
import me.servername.core.command.builtin.MsgCommand;
import me.servername.core.command.builtin.TpCommand;
import me.servername.core.command.builtin.UuidCommand;
import me.servername.core.events.Join;
import me.servername.core.util.Tps;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{

    private static Main instance;

    public void onEnable(){
        instance = this;
        getServer().getScheduler().scheduleSyncRepeatingTask(this, new Tps(), 100L, 1L);
        getServer().getPluginManager().registerEvents(new CommandHandler(), this);
        getServer().getPluginManager().registerEvents(new Join(), this);
        CommandHandler.register(LagCommand.class);
        CommandHandler.register(UuidCommand.class);
        CommandHandler.register(TpCommand.class);
        CommandHandler.register(MsgCommand.class);
    }

    public static Main getInstance(){
        return instance;
    }

}