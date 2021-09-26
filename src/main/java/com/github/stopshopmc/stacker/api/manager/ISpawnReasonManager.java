package com.github.stopshopmc.stacker.api.manager;

import org.bukkit.entity.LivingEntity;
import org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason;

public interface ISpawnReasonManager {
    SpawnReason getSpawnReason(LivingEntity entity);
    
    void setSpawnReason(LivingEntity entity, SpawnReason spawnReason);
    
    boolean contains(LivingEntity entity);
    
    void remove(LivingEntity entity);
    
    void removeAll();
}
