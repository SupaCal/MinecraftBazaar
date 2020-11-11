package me.supacal.bazaar.util;

import me.supacal.bazaar.Bazaar;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import java.util.Arrays;

public final class GUIUtil {

    public static ItemStack customItemGenerator(Material type, int amount, String displayName, boolean glowing, String... lore) {
        ItemStack item = new ItemStack(type, amount);
        ItemMeta meta = item.getItemMeta();
        assert meta != null;
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_UNBREAKABLE);

        meta.getPersistentDataContainer().set(new NamespacedKey(Bazaar.getPlugin(Bazaar.class), "isCustomItem"), PersistentDataType.INTEGER, 1);
        meta.setDisplayName(displayName);
        meta.setLore(Arrays.asList(lore));

        if (glowing) {
            meta.addEnchant(Enchantment.DURABILITY, 1, true);
        }

        item.setItemMeta(meta);
        return item;
    }
    public static ItemStack customItemGeneratorWithData(Material type, int amount, String displayName, boolean glowing, String dataKey, String dataValue, String... lore) {
        ItemStack item = customItemGenerator(type, amount, displayName, glowing, lore);
        ItemMeta meta = item.getItemMeta();
        assert meta != null;
        meta.getPersistentDataContainer().set(new NamespacedKey(Bazaar.getPlugin(Bazaar.class), dataKey), PersistentDataType.STRING, dataValue);

        item.setItemMeta(meta);
        return item;
    }

    public static boolean isCustomItem(ItemStack item){
        return item.getItemMeta().getPersistentDataContainer().has(new NamespacedKey(Bazaar.getPlugin(Bazaar.class), "isCustomItem"), PersistentDataType.STRING);
    }
    public static boolean hasCustomData(ItemStack item, String key){
         return item.getItemMeta().getPersistentDataContainer().has(new NamespacedKey(Bazaar.getPlugin(Bazaar.class), key), PersistentDataType.STRING);
    }
    public static String getCustomData(ItemStack item, String key){
        return item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(Bazaar.getPlugin(Bazaar.class), key), PersistentDataType.STRING);
    }
}