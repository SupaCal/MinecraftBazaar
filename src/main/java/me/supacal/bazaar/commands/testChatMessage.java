package me.supacal.bazaar.commands;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class testChatMessage implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings){
        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;
            TextComponent component1 = new TextComponent("Survival ");
            component1.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/gamemode survival"));
            TextComponent component2 = new TextComponent("Creative");
            component2.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/gamemode creative"));
            player.spigot().sendMessage(ChatMessageType.CHAT, component1, component2);

        }
        return false;
    }
}
