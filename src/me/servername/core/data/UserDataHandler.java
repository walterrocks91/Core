package me.servername.core.data;

import me.servername.core.util.Config;
import me.servername.core.util.Configurations;
import me.servername.core.util.Matcher;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.util.*;

public class UserDataHandler {

    private Config config = Configurations.USER_DATA_CACHE;
    private YamlConfiguration conf = Configurations.USER_DATA_CACHE.getConfiguration();

    private static UserDataHandler instance;

    public UserDataHandler(){
        instance = this;
        if(!conf.contains("data")) conf.set("data", "");
    }

    public static UserDataHandler getInstance(){
        return (instance == null ? new UserDataHandler() : instance);
    }

    public void update(String player, UUID uuid){
        String str = conf.getString("data");
        List<String> list = new ArrayList<>();
        Collections.addAll(list, str.split(";"));
        for(String s : list){
            if(s.split("=")[0].equalsIgnoreCase(player)){
                list.remove(s);
                break;
            }
        }
        list.add(player + "=" + uuid.toString());
        str = "";
        for(String s : list){
            str += s + ";";
        }
        conf.set("data", str);
        config.save();
    }

    public void update(Player p){
        update(p.getName(), p.getUniqueId());
    }

    public void update(Map<String, UUID> map){
        for(Map.Entry<String, UUID> entry : map.entrySet()){
            update(entry.getKey(), entry.getValue());
        }
    }

    public UUID getUUID(String player){
        Player target = Matcher.matchPlayer(player);
        if(target != null) return target.getUniqueId();
        String s = conf.getString("data");
        String[] arr = s.split(";");
        for(String str : arr){
            if(str.split("=")[0].equalsIgnoreCase(player)) return UUID.fromString(str.split("=")[1]);
        }
        return null;
    }

    public String getName(UUID uuid){
        Player target = Matcher.matchPlayer(uuid);
        if(target != null) return target.getName();
        String s = conf.getString("data");
        String[] arr = s.split(";");
        for(String str : arr){
            if(str.split("=")[1].equalsIgnoreCase(uuid.toString())) return str.split("=")[0];
        }
        return null;
    }

}