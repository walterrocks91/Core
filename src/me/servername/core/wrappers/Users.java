package me.servername.core.wrappers;

import me.servername.core.data.UserDataHandler;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Users {

    private static List<User> users = new ArrayList<>();

    public static void register(User u){
        if(!users.contains(u)) users.add(u);
    }

    public static User getUserByPlayer(Player p){
        return getUserByID(p.getUniqueId());
    }

    public static User getUserByName(String name){
        return getUserByID(UserDataHandler.getInstance().getUUID(name));
    }

    public static User getUserByID(UUID uuid){
        for(User u : users){
            if(u.getUUID() == uuid){
                if(Bukkit.getPlayer(UserDataHandler.getInstance().getName(u.getUUID())) == null){
                    users.remove(u);
                    return null;
                }
                return u;
            }
        }
        return null;
    }

    public static List<User> getUsers(){
        return users;
    }

}