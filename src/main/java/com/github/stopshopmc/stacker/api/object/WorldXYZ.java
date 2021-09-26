package com.github.stopshopmc.stacker.api.object;

import java.util.Objects;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;

import com.github.sirblobman.api.utility.Validate;

import org.jetbrains.annotations.Nullable;

public final class WorldXYZ {
    private final UUID worldId;
    private final int x, y, z;
    
    public WorldXYZ(World world, int x, int y, int z) {
        this.worldId = Validate.notNull(world, "world must not be null!").getUID();
        this.x = x;
        this.y = y;
        this.z = z;
    }
    
    public WorldXYZ(Location location) {
        Validate.notNull(location, "location must not be null!");
        
        World world = location.getWorld();
        if(world == null) throw new IllegalArgumentException("location must have a valid world!");
        this.worldId = world.getUID();
        
        this.x = location.getBlockX();
        this.y = location.getBlockY();
        this.z = location.getBlockZ();
    }
    
    public WorldXYZ(Block block) {
        Validate.notNull(block, "block must not be null!");
        this.worldId = block.getWorld().getUID();
        this.x = block.getX();
        this.y = block.getY();
        this.z = block.getZ();
    }
    
    @Override
    public boolean equals(Object object) {
        if(!(object instanceof WorldXYZ)) return false;
        WorldXYZ other = (WorldXYZ) object;
        return (this.worldId.equals(other.worldId) && this.x == other.x && this.y == other.y && this.z == other.z);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(this.worldId, this.x, this.y, this.z);
    }
    
    @Override
    public String toString() {
        return String.format("WorldXYZ{worldId=%s,x=%s,y=%s,z=%s}", this.worldId, this.x, this.y, this.z);
    }
    
    public UUID getWorldId() {
        return this.worldId;
    }
    
    public int getX() {
        return this.x;
    }
    
    public int getY() {
        return this.y;
    }
    
    public int getZ() {
        return this.z;
    }
    
    @Nullable
    public World getWorld() {
        UUID worldId = getWorldId();
        return Bukkit.getWorld(worldId);
    }
    
    @Nullable
    public Block getBlock() {
        World world = getWorld();
        if(world == null) return null;
        
        int x = getX(), y = getY(), z = getZ();
        return world.getBlockAt(x, y, z);
    }
    
    @Nullable
    public Location getLocation() {
        World world = getWorld();
        if(world == null) return null;
        
        int x = getX(), y = getY(), z = getZ();
        return new Location(world, x, y, z, 0.0F, 0.0F);
    }
}
