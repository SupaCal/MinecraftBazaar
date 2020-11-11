package me.supacal.bazaar;

import me.supacal.bazaar.commands.NewBazaar;
import me.supacal.bazaar.commands.testChatMessage;
import me.supacal.bazaar.events.*;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.java.JavaPlugin;
import org.json.JSONArray;

import java.util.HashMap;



public final class Bazaar extends JavaPlugin {
    //public static JSONArray array = new JSONArray();
    public static HashMap<String, Inventory> bazaarInventorys = new HashMap<String, Inventory>();
    public static HashMap<String, Inventory> ordersInventorys = new HashMap<String, Inventory>();
    public static HashMap<String, Inventory> cancelOrdersInventorys = new HashMap<String, Inventory>();
    public static HashMap<String, NewOrderClass> newOrders = new HashMap<String, NewOrderClass>();
    @Override
    public void onEnable() {
        // Plugin startup logic

        getLogger().info("Started");
        getServer().getPluginManager().registerEvents(new playerInteractEntityEvent(), this);
        getServer().getPluginManager().registerEvents(new MenuHandler(), this);
        getServer().getPluginManager().registerEvents(new PlayerJoin(), this);
        getServer().getPluginManager().registerEvents(new PlayerLeave(), this);
        getServer().getPluginManager().registerEvents(new InventoryClose(), this);
        getCommand("bazaarnew").setExecutor(new NewBazaar());
        getCommand("testchat").setExecutor(new testChatMessage());
        //this.getServer().getPlayer("SupaCal").sendMessage();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic

    }

}
