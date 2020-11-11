package me.supacal.bazaar.events;

import me.supacal.bazaar.util.GUIUtil;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import static me.supacal.bazaar.Bazaar.bazaarInventorys;
import static me.supacal.bazaar.Bazaar.ordersInventorys;
import static org.bukkit.Bukkit.createInventory;

public class PlayerJoin implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){
        Inventory bazaarInv = createInventory(null, 27, "Bazaar");
        bazaarInv.setItem(10, GUIUtil.customItemGeneratorWithData(Material.DIRT, 1, "New Dirt order", false, "orderItem", "DIRT"));
        bazaarInv.setItem(28, GUIUtil.customItemGeneratorWithData(Material.PAINTING, 1, "New Dirt order", false, "orderItem", "PAINTING"));
        bazaarInventorys.put(e.getPlayer().getName(), bazaarInv);
        ordersInventorys.put(e.getPlayer().getName(), createInventory(null, 9, "Orders"));
    }
}
