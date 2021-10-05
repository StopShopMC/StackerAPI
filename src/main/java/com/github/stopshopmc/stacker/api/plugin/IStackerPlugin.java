package com.github.stopshopmc.stacker.api.plugin;

import org.bukkit.World;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import com.github.sirblobman.api.configuration.ConfigurationManager;
import com.github.sirblobman.api.configuration.PlayerDataManager;
import com.github.sirblobman.api.language.LanguageManager;
import com.github.sirblobman.api.nms.MultiVersionHandler;

import com.github.stopshopmc.stacker.api.manager.ICustomDropManager;
import com.github.stopshopmc.stacker.api.manager.IItemStackManager;
import com.github.stopshopmc.stacker.api.manager.IMobStackManager;
import com.github.stopshopmc.stacker.api.manager.INerfManager;
import com.github.stopshopmc.stacker.api.manager.ISpawnReasonManager;
import com.github.stopshopmc.stacker.api.manager.ISpawnerStackManager;

public interface IStackerPlugin {
    JavaPlugin getPlugin();
    
    void onLoad();
    void onEnable();
    void onDisable();
    
    YamlConfiguration getConfig();
    void saveDefaultConfig();
    void reloadConfig();
    void saveConfig();
    
    ConfigurationManager getConfigurationManager();
    MultiVersionHandler getMultiVersionHandler();
    PlayerDataManager getPlayerDataManager();
    LanguageManager getLanguageManager();
    
    ISpawnerStackManager getSpawnerStackManager();
    IItemStackManager getItemStackManager();
    IMobStackManager getMobStackManager();
    
    ISpawnReasonManager getSpawnReasonManager();
    ICustomDropManager getCustomDropManager();
    INerfManager getNerfManager();
    
    boolean isDisabled(World world);
    void printDebug(Class<?> clazz, String message);
}
