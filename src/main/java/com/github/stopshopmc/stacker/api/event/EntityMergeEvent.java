package com.github.stopshopmc.stacker.api.event;

import org.bukkit.entity.Entity;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import com.github.sirblobman.api.utility.Validate;

public class EntityMergeEvent extends Event implements Cancellable {
    private static final HandlerList handlerList = new HandlerList();
    private final Entity entity1;
    private final Entity entity2;
    private boolean isCancelled;
    public EntityMergeEvent(Entity entity1, Entity entity2) {
        this.entity1 = Validate.notNull(entity1, "entity1 must not be null!");
        this.entity2 = Validate.notNull(entity2, "entity2 must not be null!");
        this.isCancelled = false;
    }

    public static HandlerList getHandlerList() {
        return handlerList;
    }
    
    @Override
    public HandlerList getHandlers() {
        return getHandlerList();
    }
    
    @Override
    public boolean isCancelled() {
        return this.isCancelled;
    }
    
    @Override
    public void setCancelled(boolean cancel) {
        this.isCancelled = cancel;
    }
    
    public Entity getFirstEntity() {
        return this.entity1;
    }
    
    public Entity getSecondEntity() {
        return this.entity2;
    }
}
