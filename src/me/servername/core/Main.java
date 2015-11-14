package me.servername.core;

import me.servername.core.command.CommandHandler;
import me.servername.core.command.builtin.LagCommand;
import me.servername.core.command.builtin.MsgCommand;
import me.servername.core.command.builtin.TpCommand;
import me.servername.core.command.builtin.UuidCommand;
import me.servername.core.events.Join;
import me.servername.core.events.PreventionListener;
import me.servername.core.util.Tps;
import me.servername.core.wrappers.Users;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{

    private static Main instance;

    public void onEnable(){
        instance = this;
        getServer().getScheduler().scheduleSyncRepeatingTask(this, new Tps(), 100L, 1L);
        reg(new CommandHandler(), new Join(), new PreventionListener());
        reg(LagCommand.class, UuidCommand.class, TpCommand.class, MsgCommand.class);
    }

    public void onDisable(){
        instance = null;
        Users.getUsers().clear();
    }

    public static Main getInstance(){
        return instance;
    }

    private void reg(Listener... l){
        for(Listener listener : l){
            getServer().getPluginManager().registerEvents(listener, this);
        }
    }

    private void reg(Class... classes){
        for(Class c : classes){
            CommandHandler.register(c);
        }
    }

}