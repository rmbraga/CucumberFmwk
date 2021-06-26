package com.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private Properties prop;

    public Properties initProperties() {
        prop = new Properties();
        try {
            FileInputStream fileInputStream =
                    new FileInputStream("config.properties");
            prop.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return prop;
    }
}
