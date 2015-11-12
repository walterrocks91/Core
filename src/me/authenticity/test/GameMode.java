package me.authenticity.test;

import me.authenticity.core.command.Command;
import org.bukkit.entity.Player;

public class GameMode {

    @Command(name="gm", perm="authenticity.gamemode")
    public void gm(Player p, String[] args){
        p.sendMessage("Test");
    }

}