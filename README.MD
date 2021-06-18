# Stacker API Usage


### Maven Module
Stacker API is a maven jar. You can use it in your project.
```xml
<repositories>
    <!-- SirBlobman Public Repository -->
    <repository>
        <id>sirblobman-public</id>
        <url>https://nexus.sirblobman.xyz/repository/public/</url>
    </repository>
</repositories>

<dependencies>
    <!-- Stacker API -->
    <dependency>
        <groupId>com.github.stopshopmc.stacker</groupId>
        <artifactId>api</artifactId>
        <version>4.0.0-SNAPSHOT</version>
        <scope>provided</scope>
    </dependency>
</dependencies>
```

### API Usage Example
This example shows you how to get the stack size of a mob.
```java
public int getStackSize(LivingEntity entity) {
    PluginManager pluginManager = Bukkit.getPluginManager();
    if(pluginManager.isPluginEnabled("Stacker")) {
        IStackerPlugin stacker = (IStackerPlugin) pluginManager.getPlugin("Stacker");
        IMobStackManager mobStackManager = stacker.getMobStackManager();
        return mobStackManager.getStackSize(entity);
    }
    
    // Stacker is not enabled, mob stack is always 1
    return 1;
}
```
