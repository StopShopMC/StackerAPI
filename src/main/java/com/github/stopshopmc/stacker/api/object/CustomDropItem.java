package com.github.stopshopmc.stacker.api.object;

import java.util.concurrent.ThreadLocalRandom;

import org.bukkit.inventory.ItemStack;

import com.github.sirblobman.api.utility.Validate;

public class CustomDropItem {
    private final int chance, maxChance;
    private final ItemStack item;
    public CustomDropItem(ItemStack item, int chance, int maxChance) {
        if(chance > maxChance) throw new IllegalArgumentException("chance cannot be greater than maxChance!");
        this.chance = chance;
        this.maxChance = maxChance;
        this.item = Validate.notNull(item, "item must not be null!").clone();
    }
    
    public boolean calculateChance() {
        if(this.chance == this.maxChance) return true;
        
        ThreadLocalRandom rng = ThreadLocalRandom.current();
        int randomValue = rng.nextInt(this.maxChance);
        return (randomValue <= this.chance);
    }
    
    public ItemStack getItem() {
        return this.item.clone();
    }
}