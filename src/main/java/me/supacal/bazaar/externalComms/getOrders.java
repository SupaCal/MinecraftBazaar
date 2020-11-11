package me.supacal.bazaar.externalComms;

import com.google.gson.Gson;
import netscape.javascript.JSObject;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;



import static org.bukkit.Bukkit.getLogger;


public class getOrders {

    public static JSONArray allOrders() throws IOException {
        URL url = new URL("http://127.0.0.1:2021/allorders");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.connect();
        InputStream inputStream = con.getInputStream();
        InputStreamReader reader = new InputStreamReader(inputStream);
        char[] buffer = new char[4096];
        reader.read(buffer);
        JSONObject obj = new JSONObject(String.valueOf(buffer));
        JSONArray orders = obj.getJSONArray("orders");



        //array = orders;
        return orders;
    }
    public static JSONArray userOrders(String arg) throws IOException {
        URL url = new URL("http://127.0.0.1:2021/orders/"+arg);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        con.connect();
        InputStream inputStream = con.getInputStream();
        InputStreamReader reader = new InputStreamReader(inputStream);
        char[] buffer = new char[4096];
        reader.read(buffer);
        JSONObject obj = new JSONObject(String.valueOf(buffer));
        JSONArray orders = obj.getJSONArray("orders");




        return orders;
    }


}
