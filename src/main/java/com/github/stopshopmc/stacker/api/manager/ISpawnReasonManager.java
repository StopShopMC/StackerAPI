package com.github.stopshopmc.stacker.api.manager;

import org.bukkit.entity.LivingEntity;
import org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason;

public interface ISpawnReasonManager {
    void setSpawnReason(LivingEntity entity, SpawnReason spawnReason);
    SpawnReason getSpawnReason(LivingEntity entity);
}