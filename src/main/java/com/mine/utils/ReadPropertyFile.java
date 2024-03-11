package com.mine.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

public final class ReadPropertyFile {
    private ReadPropertyFile() { }

    private static Properties property = new Properties();
    private static final Map<String, String> PROPERTIES_MAP = new HashMap<>();
    static {
        try {
            FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/utilityFiles/config.properties");
            property.load(file); // this returns HashTable type; in below line we're changing HashTable to HashMap
            property.entrySet().forEach(entry -> PROPERTIES_MAP.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()).trim()));
            // in above statement, better to use entrySet() instead of keySet(), as we are accessing keys & values. keySet() can be used if we are accessing only keys

            /* another logic instead of using above BiConsumer feature is by using enhanced-For loop, as below
            for (Map.Entry<Object, Object> propertyEntry : property.entrySet()) {
                PROPERTIES_MAP.put(String.valueOf(propertyEntry.getKey()), String.valueOf(propertyEntry.getValue()));
            } */
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getValue(String propertyName) throws Exception {
        if(Objects.isNull(propertyName) || Objects.isNull(PROPERTIES_MAP.get(propertyName)))
            throw new Exception("Property name: " + propertyName + "is not found. Please check config.properties file");
        else return PROPERTIES_MAP.get(propertyName);
    }

    /* If we use below logic, then we are accessing the properties files everytime. Better to access once via Static Block feature and store all values in map, as above

    public static String getValue(String propertyName) throws Exception {
        Properties property = new Properties();
        FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/utilityFiles/config.properties");
        property.load(file);
        String value = property.getProperty(propertyName);
        if (Objects.isNull(value))
            throw new Exception("Property name: " + propertyName + "is not found. Please check config.properties file");
        else return value;
    }
    */
}
