package me.servername.core.command.builtin;

import me.servername.core.command.Command;
import me.servername.core.util.Matcher;
import me.servername.core.util.Txt;
import org.bukkit.entity.Player;

public class TpCommand {

    @Command(name="tp",perm="servername.commands.teleport")
    public void tpCommand(Player p, String[] args){
        if(args.length == 0){
            p.sendMessage(Txt.from("&9Usage&8: /&btp &8<&bPlayer&8> &8[&bPlayer&8]"));
            return;
        }
        Player target = Matcher.matchPlayer(args[0]);
        if(target == null){
            p.sendMessage(Txt.from("&c" + args[0] + " could not be found&8."));
            return;
        }
        if(args.length == 1){
            p.teleport(target);
            p.sendMessage(Txt.from("&9Teleported to&8: &b" + target.getName()));
        }else if(args.length == 2){
            Player second = Matcher.matchPlayer(args[1]);
            if(second == null){
                p.sendMessage(Txt.from("&c" + args[1] + " could not be found&8."));
                return;
            }
            target.teleport(second);
            target.sendMessage(Txt.from("&9Teleported to&8: &b" + second.getName()));
            p.sendMessage(Txt.from("&9Teleported " + target.getName() + " to&8: &b" + second.getName()));
        }else{
            p.sendMessage(Txt.from("&9Usage&8: /&btp &8<&bPlayer&8> &8[&bPlayer&8]"));
        }
    }

    @Command(name="tphere",perm="servername.commands.teleport")
    public void tphereCommand(Player p, String[] args){
        if(args.length == 0){
            p.sendMessage(Txt.from("&9Usage&8: /&btphere &8<&bPlayer&8>"));
            return;
        }
        Player target = Matcher.matchPlayer(args[0]);
        if(target == null){
            p.sendMessage(Txt.from("&c" + args[0] + " could not be found&8."));
            return;
        }
        if(args.length == 1){
            target.teleport(p);
            p.sendMessage(Txt.from("&9Teleported &b" + target.getName() + " &9to you&8."));
            target.sendMessage(Txt.from("&9You were Teleported to &b" + p.getName() + "&8."));
        }else{
            p.sendMessage(Txt.from("&9Usage&8: /&btphere &8<&bPlayer&8>"));
        }
    }

}