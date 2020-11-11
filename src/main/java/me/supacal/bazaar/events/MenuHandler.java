package me.supacal.bazaar.events;

import me.supacal.bazaar.Bazaar;
import me.supacal.bazaar.NewOrderClass;
import me.supacal.bazaar.actions.updateOrderingGUI;
import me.supacal.bazaar.externalComms.delOrders;
import me.supacal.bazaar.util.GUIUtil;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import java.io.IOException;

import static me.supacal.bazaar.Bazaar.*;
import static org.bukkit.Bukkit.createInventory;
import static org.bukkit.Bukkit.getLogger;

public class MenuHandler implements Listener {
    @EventHandler
    public void clickEvent(InventoryClickEvent event){



        if (event.getCurrentItem() != null){
            Player player = (Player) event.getWhoClicked();
            String playerName = player.getName();
            Inventory thisOrdersInventory = ordersInventorys.get(playerName);
            Inventory thisBazaarInventory = ordersInventorys.get(playerName);
            ItemStack item = event.getCurrentItem();
            ItemMeta meta = item.getItemMeta();
            if(thisOrdersInventory.getViewers().contains(player)){

                if (GUIUtil.hasCustomData(item, "dbId")){
                    String dbId = GUIUtil.getCustomData(item, "dbId");
                    Inventory inventory = createInventory(null, 9, "Are you sure");
                    cancelOrdersInventorys.put(playerName, inventory);
                    ItemStack confirm = GUIUtil.customItemGeneratorWithData(Material.GREEN_WOOL, 1, "Confirm", false, "confirmDbId", dbId);
                    ItemStack cancel = GUIUtil.customItemGeneratorWithData(Material.RED_WOOL, 1, "Cancel", false, "cancelButton", "true");
                    inventory.setItem(3, confirm);
                    inventory.setItem(5, cancel);
                    player.openInventory(inventory);
                }


                event.setCancelled(true);
            }
            if (thisBazaarInventory.getViewers().contains(player)){
                if (GUIUtil.hasCustomData(item, "orderItem")){
                    String customData = GUIUtil.getCustomData(item, "orderItem");
                    if (customData.equals("PAINTING")){
                        player.openInventory(thisOrdersInventory);
                    }else{
                        NewOrderClass newOrder = new NewOrderClass(Material.getMaterial(customData));
                        newOrders.put(playerName, newOrder);
                        player.openInventory(newOrder.inventory);
                    }
                }
                //updateOrderingGUI.exec(player.getName());
            }
            if (cancelOrdersInventorys.containsKey(playerName)){
                if (GUIUtil.hasCustomData(item, "cancelButton")){
                    event.setCancelled(true);
                    player.openInventory(ordersInventorys.get(playerName));
                }
                if (GUIUtil.hasCustomData(item, "confirmDbId")){
                    try {
                        delOrders.one(GUIUtil.getCustomData(item, "confirmDbId"));
                    } catch (IOException e) {
                        player.sendMessage("Failed canceling order");
                    }
                }
            }


        }


    }
}
