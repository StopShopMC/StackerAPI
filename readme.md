# Stacker API Usage


### Maven Module
Stacker API is a maven jar. You can install it in your local repository and use it in your project.
```xml
<dependency>
    <groupId>com.github.stopshopmc.stacker</groupId>
    <artifactId>api</artifactId>
    <version>3.0.0-SNAPSHOT</version>
    <scope>provided</scope>
    
    <!-- (Optional) Exclude Dependencies -->
    <exclusions>
        <exclusion>
            <groupId>*</groupId>
            <artifactId>*</artifactId>
        </exclusion>
    </exclusions>
</dependency>
```

### API Usage Example
This example shows you how to get the stack size of a mob.
```java
public long getStackSize(LivingEntity entity) {
    PluginManager pluginManager = Bukkit.getPluginManager();
    if(pluginManager.isPluginEnabled("Stacker")) {
        IStackerPlugin stacker = (IStackerPlugin) pluginManager.getPlugin("Stacker");
        IMobStackManager mobStackManager = stacker.getMobStackManager();
        return mobStackManager.getStackSize(entity);
    }
    
    // Stacker is not enabled, mob stack is always 1
    return 1L;
}
```