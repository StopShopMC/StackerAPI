package com.github.stopshopmc.stacker.api.manager;

public interface IStackManager<K, V> {
    V map(K k);
    
    int getMaxStackSize();
    
    boolean isStacked(K k);
    
    int getStackSize(K k);
    
    void setStackSize(K k, int stackSize);
    
    void unstack(K k);
    
    void remove(K k);
    
    void removeAll();
    
    K merge(K k1, K k2);
    
    void updateName(K k);
    
    boolean shouldNotStack(K k1, K k2);
    
    void setStackable(K k, boolean stackable);
    
    boolean isUnstackable(K k);
    
    default boolean isInstant() {
        return true;
    }
}
