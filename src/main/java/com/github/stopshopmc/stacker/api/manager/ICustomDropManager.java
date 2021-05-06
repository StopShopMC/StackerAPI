package com.github.stopshopmc.stacker.api.manager;

import org.bukkit.entity.EntityType;

import com.github.stopshopmc.stacker.api.object.CustomDrop;

public interface ICustomDropManager {
    CustomDrop getCustomDrop(EntityType entityType);
    void loadDrops();
}
