package me.servername.core.util;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.UUID;

public class Matcher {

    public static Player matchPlayer(String name){
        for(Player p : Bukkit.getOnlinePlayers()){
            if(p.getName().equalsIgnoreCase(name)) return p;
        }
        return null;
    }

    public static Player matchPlayer(UUID uuid){
        for(Player p : Bukkit.getOnlinePlayers()){
            if(p.getUniqueId() == uuid) return p;
        }
        return null;
    }

}