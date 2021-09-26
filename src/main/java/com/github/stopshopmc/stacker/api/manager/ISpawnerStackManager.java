package com.github.stopshopmc.stacker.api.manager;

import org.bukkit.block.CreatureSpawner;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;

import com.github.stopshopmc.stacker.api.object.WorldXYZ;

public interface ISpawnerStackManager extends IStackManager<CreatureSpawner, WorldXYZ> {
    void loadSpawners();
    
    void saveSpawners();
    
    void removeAllHolograms();
    
    EntityType getEntityType(CreatureSpawner spawner);
    
    ItemStack createItemStack(EntityType entityType, int amount, int stackSize);
    
    EntityType getEntityType(ItemStack item);
    
    int getStackSize(ItemStack item);
}
