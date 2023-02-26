package net.antwan.bungeehub.commands;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;
import net.md_5.bungee.protocol.Location;

public class Hub extends Command {
    public Hub(String name) {
        super(name);
    }

    @Override
    public void execute(CommandSender commandSender, String[] strings) {
        ProxiedPlayer sender;
        if(commandSender instanceof ProxiedPlayer){
            sender = (ProxiedPlayer) commandSender;
        }

    }
}
