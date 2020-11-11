package me.supacal.bazaar.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;

import static me.supacal.bazaar.Bazaar.cancelOrdersInventorys;
import static me.supacal.bazaar.Bazaar.newOrders;

public class InventoryClose implements Listener {
    @EventHandler
    public void onInventoryClose(InventoryCloseEvent e){
        Player p = (Player) e.getPlayer();
        if (newOrders.containsKey(p.getName())){
            newOrders.remove(p.getName());
        }
        if (cancelOrdersInventorys.containsKey(p.getName())){
            cancelOrdersInventorys.remove(p.getName());
        }
    }
}
