package me.servername.core.command.builtin;

import me.servername.core.command.Command;
import me.servername.core.util.Tps;
import me.servername.core.util.Txt;
import org.bukkit.entity.Player;

import java.text.DecimalFormat;

public class LagCommand {

    @Command(name="lag",perm="servername.commands.lag")
    public void tpsCommand(Player p, String[] args){
        p.sendMessage(Txt.from("&9&lTPS&8: &b" + new DecimalFormat("0.00").format(Tps.getTPS()) + " " + (Tps.getTPS() >= 18 ? "&a✔" : "&c✘")));
        p.sendMessage(Txt.from("&9&lStability&8: &b" + new DecimalFormat("0.00").format(Tps.getStability()) + "%"));
    }

}