package me.servername.core.command;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class CommandHandler implements Listener{

    private static List<Method> cmds = new ArrayList<>();

    @EventHandler
    public void onCommand(PlayerCommandPreprocessEvent e){
        String msg = e.getMessage().replaceFirst("/", "");
        String cmd = (msg.contains(" ") ? msg.split(" ")[0] : msg);
        String[] args = (msg.contains(" ") ? (msg.split(" ")[1].contains(" ") ? msg.split(" ")[1].split(" ") : new String[]{ msg.split(" ")[1] }) : new String[0]);
        for(Method m : cmds){
            Command command = m.getAnnotation(Command.class);
            if(command.name().equalsIgnoreCase(cmd)){
                if(!command.perm().trim().equals("")){
                    if(!e.getPlayer().hasPermission(command.perm())){
                        e.getPlayer().sendMessage(command.no_perm());
                        return;
                    }
                }
                try{
                    Class[] params = m.getParameterTypes();
                    if(params[0] == Player.class && params[1] == String[].class) {
                        boolean access = m.isAccessible();
                        if (!access) m.setAccessible(true);
                        m.invoke(m.getDeclaringClass().newInstance(), e.getPlayer(), args);
                        m.setAccessible(access);
                        e.setCancelled(true);
                    }else{
                        System.err.println("Invalid command creation for command '" + command.name() + "'!");
                    }
                }catch(Exception ex){
                    ex.printStackTrace();
                }
                break;
            }
        }
    }

    public static void register(Class c){
        for(Method m : c.getDeclaredMethods()){
            if(m.isAnnotationPresent(Command.class)){
                cmds.add(m);
            }
        }
    }

}