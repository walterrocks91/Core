package me.servername.core.events;

import me.servername.core.wrappers.User;
import me.servername.core.wrappers.Users;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockMultiPlaceEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerBucketEmptyEvent;
import org.bukkit.event.player.PlayerBucketFillEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.event.player.PlayerMoveEvent;

public class PreventionListener implements Listener{

    @EventHandler
    public void onBreak(BlockBreakEvent e){
        User u = Users.getUserByPlayer(e.getPlayer());
        if(!u.getPreventionSet().canBreak()) e.setCancelled(true);
    }

    @EventHandler
    public void onFillBucket(PlayerBucketFillEvent e){
        User u = Users.getUserByPlayer(e.getPlayer());
        if(!u.getPreventionSet().canBreak()) e.setCancelled(true);
    }

    @EventHandler
    public void onPlace(BlockPlaceEvent e){
        User u = Users.getUserByPlayer(e.getPlayer());
        if(!u.getPreventionSet().canPlace()) e.setCancelled(true);
    }

    @EventHandler
    public void onMultiPlace(BlockMultiPlaceEvent e) {
        User u = Users.getUserByPlayer(e.getPlayer());
        if (!u.getPreventionSet().canPlace()) e.setCancelled(true);
    }

    @EventHandler
    public void onEmptyBucket(PlayerBucketEmptyEvent e){
        User u = Users.getUserByPlayer(e.getPlayer());
        if(!u.getPreventionSet().canPlace()) e.setCancelled(true);
    }

    @EventHandler
    public void onConsume(PlayerItemConsumeEvent e){
        User u = Users.getUserByPlayer(e.getPlayer());
        if(!u.getPreventionSet().canConsume()) e.setCancelled(true);
    }

    @EventHandler
    public void onMove(PlayerMoveEvent e){
        if(e.getFrom().getBlockX() != e.getTo().getBlockX()
                || e.getFrom().getBlockY() != e.getTo().getBlockY()
                || e.getFrom().getBlockZ() != e.getTo().getBlockZ()){
            User u = Users.getUserByPlayer(e.getPlayer());
            if(!u.getPreventionSet().canMove()) e.setCancelled(true);
        }
    }

    @EventHandler
    public void onDamage(EntityDamageByEntityEvent e){
        if(e.getDamager() instanceof Player){
            Player p = (Player)e.getDamager();
            User u = Users.getUserByPlayer(p);
            if(!u.getPreventionSet().canDamage()) e.setCancelled(true);
        }
    }

    @EventHandler
    public void onDamage(EntityDamageEvent e){
        if(e.getEntity() instanceof Player){
            Player p = (Player)e.getEntity();
            User u = Users.getUserByPlayer(p);
            if(!u.getPreventionSet().isInvincible()) e.setCancelled(true);
        }
    }

}