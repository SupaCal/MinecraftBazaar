package me.supacal.bazaar.events;

import me.supacal.bazaar.Bazaar;
import me.supacal.bazaar.actions.updateOrderingGUI;
import org.bukkit.ChatColor;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.persistence.PersistentDataType;

import java.io.IOException;

import static me.supacal.bazaar.Bazaar.bazaarInventorys;


//import static org.bukkit.Bukkit.getLogger;

public class playerInteractEntityEvent implements Listener {
    updateOrderingGUI updateOrderingGUI = new updateOrderingGUI();
    @EventHandler
    public void PlayerInteractEntityEvent(PlayerInteractEntityEvent event) {
        if (event.getHand() == EquipmentSlot.HAND) {
            if (event.getRightClicked().getPersistentDataContainer().has(new NamespacedKey(Bazaar.getPlugin(Bazaar.class), "isBazaar") ,  PersistentDataType.INTEGER)){
                event.setCancelled(true);
                Player player = event.getPlayer();


                player.openInventory(bazaarInventorys.get(player.getName()));

            }


        }


    }
}
