package com.github.stopshopmc.stacker.api.manager;

import java.util.UUID;

import org.bukkit.entity.Entity;

public interface IStackManager<E extends Entity> {
    boolean isStacked(E entity);
    long getStackSize(E entity);
    long getStackSize(UUID uuid);
    void setStackSize(E entity, long stackSize);
    long getMaxStackSize();

    void removeStack(E entity);
    void removeStackAndEntity(E entity);
    void removeAll();

    E merge(E entity1, E entity2);
    void updateName(E entity);
    boolean shouldNotStack(E entity1, E entity2);
}