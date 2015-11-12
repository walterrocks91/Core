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
    }

    public User(Player p){
        this.uuid = p.getUniqueId();
    }

    public User(String s){
        UUID u = UserDataHandler.getInstance().getUUID(s);
        Validate.notNull(u);
        this.uuid = u;
    }

    public PreventionSet getPreventionSet(){
        if(prevention == null) prevention = new PreventionSet();
        return prevention;
    }

}