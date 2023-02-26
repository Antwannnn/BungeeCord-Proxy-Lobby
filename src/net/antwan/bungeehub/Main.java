package net.antwan.bungeehub;

import net.antwan.bungeehub.commands.Hub;
import net.antwan.bungeehub.ymlhandler.ProvidedConfiguration;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.config.Configuration;

import java.io.File;

public class Main extends Plugin {

    private Configuration lobby;

    ProvidedConfiguration config;
    private File file;

    @Override
    public void onEnable(){
        getLogger().info("Test passed");
        config = new ProvidedConfiguration(this, lobby, "lobby.yml");
        config.getConfig().set("Salut", "default");
        config.save();
        ProxyServer.getInstance().getPluginManager().registerCommand(this, new Hub("hub"));
    }

    @Override
    public void onDisable(){
        getLogger().info("Test passed for shut down");
    }

}
