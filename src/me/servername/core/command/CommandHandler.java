package me.servername.core.command;

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
        String msg = e.getMessage();
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
                    boolean access = m.isAccessible();
                    if(!access) m.setAccessible(true);
                    m.invoke(m.getDeclaringClass().newInstance(), e.getPlayer(), args);
                    m.setAccessible(access);
                }catch(Exception ex){
                    ex.printStackTrace();
                }
                e.setCancelled(true);
                break;
            }
        }
    }

    public static void register(Class c){
        for(Method m : c.getDeclaredMethods()){
            if(m.isAnnotationPresent(Command.class)){
                cmds.add(m);
                break;
            }
        }
    }

}