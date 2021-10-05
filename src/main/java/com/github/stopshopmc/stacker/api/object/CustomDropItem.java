package com.github.stopshopmc.stacker.api.object;

import java.util.concurrent.ThreadLocalRandom;

import org.bukkit.inventory.ItemStack;

import com.github.sirblobman.api.utility.Validate;

public final class CustomDropItem {
    private final ItemStack item;
    private boolean looting;
    private int chance, maxChance;
    private int minAmount, maxAmount;
    
    public CustomDropItem(ItemStack item) {
        this.item = Validate.notNull(item, "item must not be null!").clone();
        this.looting = false;
    }
    
    public ItemStack getItem() {
        return this.item.clone();
    }
    
    public boolean isLootingEnabled() {
        return this.looting;
    }
    
    public boolean calculateChance() {
        if(this.chance == 0 || this.maxChance == 0) return false;
        if(this.chance == this.maxChance) return true;
        
        ThreadLocalRandom rng = ThreadLocalRandom.current();
        int randomValue = rng.nextInt(this.maxChance);
        return (randomValue <= this.chance);
    }
    
    public int calculateAmount(int looting) {
        if(this.minAmount == this.maxAmount) {
            return (this.maxAmount + looting);
        }
        
        ThreadLocalRandom rng = ThreadLocalRandom.current();
        int randomValue = rng.nextInt(this.minAmount, this.maxAmount + 1);
        return (randomValue + looting);
    }
    
    public void setChance(int chance, int maxChance) {
        if(chance > maxChance) throw new IllegalArgumentException("chance cannot be greater than maxChance!");
        this.chance = chance;
        this.maxChance = maxChance;
    }
    
    public void setAmount(int min, int max) {
        if(min > max) throw new IllegalArgumentException("min cannot be greater than max!");
        this.minAmount = min;
        this.maxAmount = max;
    }
    
    public void setLooting(boolean value) {
        this.looting = value;
    }
}
