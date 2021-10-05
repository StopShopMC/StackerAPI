package com.github.stopshopmc.stacker.api.manager;

import org.bukkit.entity.LivingEntity;

public interface INerfManager {
    boolean isNerfed(LivingEntity entity);
    void addNerf(LivingEntity entity);
    void removeNerf(LivingEntity entity);
    
    void removeAll();
}
