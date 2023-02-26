package net.antwan.bungeehub.commands;

import net.antwan.bungeehub.Main;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class SetHub extends Command {

    private Main main;
    public SetHub(String name, Main main) {
        super(name);
        this.main = main;
    }

    @Override
    public void execute(CommandSender commandSender, String[] strings) {
        ProxiedPlayer sender;
        if(commandSender instanceof ProxiedPlayer){
            sender = (ProxiedPlayer) commandSender;
            if(sender.hasPermission("bh.sethub")){
                if(strings.length > 0){
                    sender.sendMessage(new ComponentBuilder("Too many arguments").color(ChatColor.RED).create());
                }
                else{
                    main.getProvidedConfigurations().get(0).getConfig().set("lobby", sender.getServer().getInfo().getName());
                    sender.sendMessage(new ComponentBuilder("Set global hub to server: " + sender.getServer().getInfo().getName()).color(ChatColor.GREEN).create());
                    main.getProvidedConfigurations().get(0).save();
                }

            }
        }
    }
}
