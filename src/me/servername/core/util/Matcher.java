package me.servername.core.util;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Matcher {

    public static Player matchPlayer(String name){
        for(Player p : Bukkit.getOnlinePlayers()){
            if(p.getName().equalsIgnoreCase(name)) return p;
        }
        return null;
    }

}