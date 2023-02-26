package net.antwan.bungeehub;

import net.antwan.bungeehub.commands.Hub;
import net.antwan.bungeehub.commands.SetHub;
import net.antwan.bungeehub.ymlhandler.ProvidedConfiguration;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.config.Configuration;

import java.io.File;
import java.util.ArrayList;

public class Main extends Plugin {

    private ProvidedConfiguration lobbys;
    private ProvidedConfiguration config;
    private File file;

    @Override
    public void onEnable(){
        getLogger().info("Initializing...");
        lobbys = new ProvidedConfiguration(this, new Configuration(), "lobby.yml");
        ProxyServer.getInstance().getPluginManager().registerCommand(this, new Hub("hub", this));
        ProxyServer.getInstance().getPluginManager().registerCommand(this, new SetHub("setproxyhub", this));
    }

    @Override
    public void onDisable(){
        getLogger().info("Shutting down");
    }

    public ArrayList<ProvidedConfiguration> getProvidedConfigurations(){
        ArrayList<ProvidedConfiguration> providedConfigurations = new ArrayList<>();
        providedConfigurations.add(this.lobbys);
        /* Later
         providedConfigurations.add(this.config);
         */
        return providedConfigurations;
    }

}
