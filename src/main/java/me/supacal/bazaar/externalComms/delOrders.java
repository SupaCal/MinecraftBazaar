package me.supacal.bazaar.externalComms;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import static org.bukkit.Bukkit.getLogger;

public class delOrders {
    public static void one(String id) throws IOException {
        getLogger().info("delOrders.one got called");
        getLogger().info(id);
        String combinedURL = "http://127.0.0.1:2021/del/" + id;
        getLogger().info(combinedURL);
        URL url = new URL(combinedURL);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.connect();
        InputStream inputStream = con.getInputStream();
        InputStreamReader reader = new InputStreamReader(inputStream);
        char[] buffer = new char[4096];
        reader.read(buffer);
        getLogger().info(String.valueOf(buffer));
    }
}
