package co.edu.upb.authServer.utils;

import io.github.cdimascio.dotenv.Dotenv;

public class Environment {

    private static volatile Environment instance;

    private Dotenv dotenv;

    private Environment() {
        String configDir = System.getProperty("config.dir", "/home/auth/authServer/environment");
    	//String configDir = System.getProperty("config.dir", "C:\\UPB\\08\\distribuidos\\Proyecto_PDF\\auth\\authServer\\environment");
        dotenv = Dotenv.configure()
                .directory(configDir)
                .filename(".env")
                .load();
    }

    public static Environment getInstance() {
        if (instance == null) {
            synchronized (Environment.class) {
                if (instance == null) {
                    instance = new Environment();
                }
            }
        }
        return instance;
    }

    public Dotenv getDotenv() {
        return this.dotenv;
    }
}
