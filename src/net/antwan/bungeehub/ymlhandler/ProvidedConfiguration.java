package net.antwan.bungeehub.ymlhandler;

import net.antwan.bungeehub.Main;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class ProvidedConfiguration {

    private Main main;
    private String name;
    private Configuration config;
    private File configFile;

    public ProvidedConfiguration(Main main, Configuration config, String name){
        this.main = main;
        this.config = config;
        this.name = name;
        loadConfiguration();
    }

    public void save(){
        if(config == null)
            loadConfiguration();
        try{
            ConfigurationProvider.getProvider(YamlConfiguration.class).save(config, configFile);
        } catch(IOException e){
            e.printStackTrace();
        }

    }

    public Configuration getConfig(){
        if(config == null)
            loadConfiguration();
        return this.config;

    }

    public void loadConfiguration() {

        configFile = new File(main.getDataFolder(), name);

        if (!configFile.exists()) {
            main.getDataFolder().mkdir();
            try{
                Files.copy(main.getResourceAsStream(name),
                        configFile.toPath());
            } catch (IOException e){
                e.printStackTrace();
            }

        }
        try{
            config = ConfigurationProvider.getProvider(YamlConfiguration.class)
                    .load(configFile);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public String getFilePath(){
        if(!configFile.exists()){
            return "File doesn't exist";
        } else{
            return configFile.getAbsolutePath();
        }
    }

}
