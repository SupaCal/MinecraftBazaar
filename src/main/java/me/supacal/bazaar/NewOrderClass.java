package me.supacal.bazaar;

import me.supacal.bazaar.util.GUIUtil;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import static org.bukkit.Bukkit.createInventory;

public class NewOrderClass {
    Material currentItem;
    public NewOrderClass(Material item){
        this.currentItem = item;
    }


    public Inventory inventory = createInventory(null, 9, "New Order");
    ItemStack buySell = new ItemStack(Material.BONE, 1);
    ItemStack item = new ItemStack(currentItem, 1);
    ItemStack price = new ItemStack(Material.GOLD_INGOT, 1);
    ItemStack amount = new ItemStack(Material.COCOA_BEANS, 1);
    ItemStack confirm = GUIUtil.customItemGenerator(Material.GREEN_WOOL, 1, "Confirm", false);
    ItemStack cancel = GUIUtil.customItemGenerator(Material.RED_WOOL, 1, "Cancel", false);
    ItemMeta buySellMeta = buySell.getItemMeta();
    ItemMeta priceMeta = price.getItemMeta();
    ItemMeta amountMeta = amount.getItemMeta();
    ItemMeta confirmMeta = confirm.getItemMeta();
    ItemMeta cancelMeta = cancel.getItemMeta();



    public void refreshInventory(){
        String buySellName = "Idk";
        if (buySell.getType() == Material.BONE){
            buySellName = "Sell";
        }else if (buySell.getType() == Material.BAMBOO){
            buySellName = "Buy";
        }

        buySellMeta.setDisplayName(ChatColor.RESET + buySellName);
        buySell.setItemMeta(buySellMeta);
    }

    public void swapBuySell() {
        if (buySell.getType() == Material.BONE){
            buySell.setType(Material.BAMBOO);
        }else if (buySell.getType() == Material.BAMBOO){
            buySell.setType(Material.BONE);
        }
    }

}
