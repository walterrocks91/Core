package me.servername.core.wrappers;

import me.servername.core.data.UserDataHandler;
import me.servername.core.util.PreventionSet;
import org.apache.commons.lang.Validate;
import org.bukkit.entity.Player;

import java.util.UUID;

public class User {

    private PreventionSet prevention;

    private UUID uuid;

    public User(UUID uuid){
        this.uuid = uuid;
        Users.register(this);
    }

    public User(Player p){
        this.uuid = p.getUniqueId();
        Users.register(this);
    }

    public User(String s){
        UUID u = UserDataHandler.getInstance().getUUID(s);
        Validate.notNull(u);
        this.uuid = u;
        Users.register(this);
    }

    public PreventionSet getPreventionSet(){
        if(prevention == null) prevention = new PreventionSet();
        return prevention;
    }

    public UUID getUUID(){
        return uuid;
    }

    public String toString(){
        return "{uuid=" + uuid.toString() + "}," + prevention.toString() + ",";
    }

}