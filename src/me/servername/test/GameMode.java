package me.servername.test;

import me.servername.core.command.Command;
import org.bukkit.entity.Player;

public class GameMode {

    @Command(name="gm", perm="servername.gamemode")
    public void gm(Player p, String[] args){
        p.sendMessage("Test");
    }

}