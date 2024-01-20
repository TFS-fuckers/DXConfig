# DXConfig
simply use several methods to read and load your own config in json format (used by ImpartMusic)

## Create a config structure
```java
public class MyConfig implements Config {
    public int valA = 1; //give it default value
}
```

## Create a config 
```java
DXConfig<MyConfig> configReader = new DXConfig<>(MyConfig.class, "./data/config.json");
```

using this constructor to create an instance of a config reader based on the structure of the class specified in the constructor.

or if you want to create a config reader with specified message output, you can use:
```java
DXConfig<MyConfig> configReader = new DXConfig<>(MyConfig.class, "./data/config.json", (message, head) -> {
    // ... give out output with the method you like ... or leave it empty to simply mute it
});
```

the `head` parameter means the level of the message like "INFO" or "WARNING" or "ERROR"

## Read config values

Simply, if we created an instance called `configReader`, use:
```java
int val = configReader.getValue("valA").getAsInt();
```
to get the value of the `valA` cached in your computer in json format

if you modified the config and want to make the change to the file(use this config as a save file), you have to turn an instance of config structure into a `JsonObject` to save it.

In this case, we use `Gson` to implement it:

```java
public void save(IMConfig config) {
    Gson gson = new Gson();
    JsonObject object = JsonParser.parseString(gson.toJson(config)).getAsJsonObject();
    this.configReader.save(object);
}
```

And don't forget to close config reader when you sure you won't use it anymore, or the modifications might be discarded.

```java
configReader.close();
```