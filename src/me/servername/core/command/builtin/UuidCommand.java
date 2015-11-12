package me.servername.core.command.builtin;

import me.servername.core.command.Command;
import me.servername.core.data.UserDataHandler;
import me.servername.core.util.Txt;
import org.bukkit.entity.Player;

import java.util.UUID;

public class UuidCommand {

    @Command(name="uuid",perm="servername.commands.uuid")
    public void uuidCommand(Player p, String[] args){
        String target = p.getName();
        if(args.length >= 1){
            target = args[0];
        }
        UUID uuid = (!p.getName().equals(target) ? UserDataHandler.getInstance().getUUID(target) : p.getUniqueId());
        if(uuid == null){
            p.sendMessage(Txt.from("&cThat player has never joined the server&8."));
            return;
        }
        p.sendMessage(Txt.from("&9" + (target.equals(p.getName()) ? "Your" : target + "&8'&9s") + " UUID&8: &b" + uuid.toString()));
    }

}