package me.supacal.bazaar.actions;

import me.supacal.bazaar.Bazaar;
import me.supacal.bazaar.externalComms.getOrders;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Objects;

import static me.supacal.bazaar.util.GUIUtil.customItemGeneratorWithData;


public class updateOrderingGUI {


    public static void exec(String name) throws IOException {
        JSONArray orders = getOrders.userOrders(name);

        Bazaar.ordersInventorys.get(name).clear();
        for (int i = 0; i < 8 && orders.length() != i; i++) {

            JSONObject thisObj = new JSONObject(orders.get(i).toString());
            Material thisMaterial = Objects.requireNonNull(Material.getMaterial(thisObj.getString("item")));
            ChatColor fufno;
            if(Integer.parseInt(thisObj.get("amountnotfulfilled").toString()) == 0){
                fufno = ChatColor.RED;
            }else if(Integer.parseInt(thisObj.get("amountnotfulfilled").toString()) == Integer.parseInt(thisObj.get("amount").toString())){
                fufno = ChatColor.GREEN;
            }else {
                fufno = ChatColor.GOLD;
            }
            ItemStack itemStack = customItemGeneratorWithData(thisMaterial, 1, thisMaterial.toString(), false, "dbId", thisObj.get("id").toString(), ChatColor.WHITE + thisObj.get("price").toString(), ChatColor.WHITE +"Amount fulfilled "  + ChatColor.BOLD + fufno +thisObj.get("amountnotfulfilled").toString() + "/" + thisObj.get("amount").toString(), ChatColor.WHITE +thisObj.getString("sellbuy"));

            Bazaar.ordersInventorys.get(name).setItem(i, itemStack);
        }
    }
}
