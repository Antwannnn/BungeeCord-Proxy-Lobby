package net.antwan.bungeehub.commands;

import net.antwan.bungeehub.Main;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class Hub extends Command {

    private Main main;

    public Hub(String name, Main main) {
        super(name);
        this.main = main;
    }

    @Override
    public void execute(CommandSender commandSender, String[] strings) {
        ProxiedPlayer sender;
        if(commandSender instanceof ProxiedPlayer){
            sender = (ProxiedPlayer) commandSender;
            if(main.getProvidedConfigurations().get(0).getConfig().get("lobby") != null){
                String serverPath = (String) main.getProvidedConfigurations().get(0).getConfig().get("lobby");
                if(!serverPath.equals(null)){
                    if(!sender.getServer().getInfo().getName().equals(serverPath)){
                        sender.sendMessage(new ComponentBuilder("Sending you to " + serverPath + "...").color(ChatColor.GOLD).create());
                        sender.connect(ProxyServer.getInstance().getServerInfo(serverPath));
                    } else{
                        sender.sendMessage(new ComponentBuilder("You are already connected to this server !").color(ChatColor.RED).create());
                    }

                }
            } else{
                sender.sendMessage(new ComponentBuilder("Unable to find lobby, please contact the administrator.").color(ChatColor.RED).create());
            }

        }

    }
}
