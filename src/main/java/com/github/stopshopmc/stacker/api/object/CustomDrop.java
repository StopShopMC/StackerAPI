package com.github.stopshopmc.stacker.api.object;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

public class CustomDrop {
    private final int minExperience, maxExperience;
    private final boolean removeOtherDrops;
    private final List<CustomDropItem> dropList;
    public CustomDrop(int minExperience, int maxExperience, boolean removeOtherDrops, List<CustomDropItem> dropList) {
        if(minExperience > maxExperience) throw new IllegalArgumentException("minExperience cannot be greater than maxExperience!");
        this.minExperience = minExperience;
        this.maxExperience = maxExperience;
        this.removeOtherDrops = removeOtherDrops;
        
        this.dropList = new ArrayList<>(Objects.requireNonNull(dropList, "dropList must not be null!"));
    }
    
    public boolean shouldRemoveOtherDrops() {
        return this.removeOtherDrops;
    }
    
    public int calculateExperience() {
        if(this.minExperience == this.maxExperience) return this.maxExperience;
        
        ThreadLocalRandom rng = ThreadLocalRandom.current();
        return rng.nextInt(this.minExperience, this.maxExperience);
    }
    
    public List<CustomDropItem> getDrops() {
        return new ArrayList<>(this.dropList);
    }
}