package com.github.stopshopmc.stacker.api.manager;

import org.bukkit.entity.LivingEntity;

public interface INerfManager {
    void removeAll();
    void addNerf(LivingEntity entity);
    void removeNerf(LivingEntity entity);
    boolean isNerfed(LivingEntity entity);
}