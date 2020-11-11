package me.supacal.bazaar.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import static me.supacal.bazaar.Bazaar.bazaarInventorys;
import static me.supacal.bazaar.Bazaar.ordersInventorys;

public class PlayerLeave implements Listener {
    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent e) {
        if (!(ordersInventorys.get(e.getPlayer().getName()) == null)) {
            ordersInventorys.remove(e.getPlayer().getName());
        }
        if (!(bazaarInventorys.get(e.getPlayer().getName()) == null)) {
            bazaarInventorys.remove(e.getPlayer().getName());
        }
    }
}