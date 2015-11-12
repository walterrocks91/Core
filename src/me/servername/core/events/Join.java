package me.servername.core.events;

import me.servername.core.data.UserDataHandler;
import me.servername.core.wrappers.User;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class Join implements Listener{

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        e.setJoinMessage("");
        UserDataHandler.getInstance().update(e.getPlayer());
        new User(e.getPlayer());
    }

}