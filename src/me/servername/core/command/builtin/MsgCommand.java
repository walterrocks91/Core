package me.servername.core.command.builtin;

import me.servername.core.command.Command;
import me.servername.core.util.Matcher;
import me.servername.core.util.Txt;
import org.bukkit.entity.Player;

public class MsgCommand {

    @Command(name="msg",perm="servername.commands.msg")
    public void msgCommand(Player p, String[] args){
        System.out.println(Txt.concat(args, 0));
        if(args.length < 2){
            p.sendMessage(Txt.from("&9Usage&8: /&bmsg &8<&bPlayer&8> <&bMessage&8>"));
            return;
        }
        Player target = Matcher.matchPlayer(args[0]);
        if(target == null){
            p.sendMessage(Txt.from("&c" + args[0] + " could not be found&8."));
            return;
        }
        String str = Txt.concat(args, 1);
        p.sendMessage(Txt.from("&9[&bYou &8➭&r &b" + target.getName() + "&9] &b" + str));
        target.sendMessage(Txt.from("&9[&b" + target.getName() + " &8➭&r &bYou&9] &b" + str));
    }

}