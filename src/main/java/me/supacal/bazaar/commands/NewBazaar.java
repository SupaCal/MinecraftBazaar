package me.supacal.bazaar.commands;


import me.supacal.bazaar.Bazaar;
import org.bukkit.Location;
import org.bukkit.NamespacedKey;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.persistence.PersistentDataType;


public class NewBazaar implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (commandSender instanceof Player){
            Player player = (Player) commandSender;
            Location location = player.getLocation();
            World world = player.getWorld();

            LivingEntity entity = (LivingEntity) world.spawnEntity(location, EntityType.VILLAGER);
            entity.setAI(false);
            entity.setInvulnerable(true);
            //FixedMetadataValue metadata = new FixedMetadataValue(Bazaar.getPlugin(Bazaar.class), true);
            entity.getPersistentDataContainer().set(new NamespacedKey(Bazaar.getPlugin(Bazaar.class), "isBazaar"), PersistentDataType.INTEGER,1 );
            //entity.setMetadata("isBazaar", metadata);


        }

        return false;
    }
}
