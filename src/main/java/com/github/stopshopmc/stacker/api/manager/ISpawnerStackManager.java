package com.github.stopshopmc.stacker.api.manager;

import org.bukkit.block.Block;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;

public interface ISpawnerStackManager {
    long getStackSize(Block block);
    void setStackSize(Block block, long stackSize);

    ItemStack createItemStack(String entityId);
    EntityType getEntityType(ItemStack item);
    EntityType getEntityType(Block block);
}