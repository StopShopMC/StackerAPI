package com.github.stopshopmc.stacker.api.event;

import org.bukkit.entity.LivingEntity;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import com.github.sirblobman.api.utility.Validate;

public class StackDeathEvent extends Event {
    private static final HandlerList handlerList = new HandlerList();
    public static HandlerList getHandlerList() {
        return handlerList;
    }
    
    @Override
    public HandlerList getHandlers() {
        return getHandlerList();
    }
    
    private final LivingEntity entity;
    private final int stackSize;
    private boolean killEntireStack;
    public StackDeathEvent(LivingEntity entity, int stackSize) {
        this.entity = Validate.notNull(entity, "entity must not be null!");
        this.stackSize = stackSize;
        this.killEntireStack = (stackSize <= 1);
    }
    
    public LivingEntity getStack() {
        return this.entity;
    }
    
    public int getStackSize() {
        return this.stackSize;
    }
    
    public boolean isKillEntireStack() {
        return this.killEntireStack;
    }
    
    public void setKillEntireStack(boolean killEntireStack) {
        this.killEntireStack = killEntireStack;
    }
}
