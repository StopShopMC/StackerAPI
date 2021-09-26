package com.github.stopshopmc.stacker.api.object;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import com.github.sirblobman.api.utility.Validate;

public class CustomDrop {
    private final boolean keepOriginalDrops;
    private final List<CustomDropItem> dropList;
    
    private ExperienceMode experienceMode;
    private int minExperience, maxExperience;
    
    public CustomDrop(boolean keepOriginalDrops, List<CustomDropItem> dropList) {
        this.keepOriginalDrops = keepOriginalDrops;
        this.dropList = new ArrayList<>(Validate.notNull(dropList, "dropList must not be null!"));
    }
    
    public boolean shouldKeepOriginalDrops() {
        return this.keepOriginalDrops;
    }
    
    public List<CustomDropItem> getDrops() {
        return Collections.unmodifiableList(this.dropList);
    }
    
    public ExperienceMode getExperienceMode() {
        return this.experienceMode;
    }
    
    public void setExperienceMode(ExperienceMode experienceMode) {
        this.experienceMode = Validate.notNull(experienceMode, "experienceMode must not be null!");
    }
    
    public int calculateExperience() {
        if(this.minExperience == this.maxExperience) return this.maxExperience;
        
        ThreadLocalRandom rng = ThreadLocalRandom.current();
        return rng.nextInt(this.minExperience, this.maxExperience);
    }
    
    public void setExperience(int min, int max) {
        if(min > max) throw new IllegalArgumentException("min must not be greater than max!");
        this.minExperience = min;
        this.maxExperience = max;
    }
}
