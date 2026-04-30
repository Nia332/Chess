package de.niamatullah_kainz.chess.service;

public class GameLoopSingleton {

    private final GameLoopService gameLoopService = new GameLoopService();

    private static volatile GameLoopSingleton instance;

    // Private constructor to prevent external instantiation
    private GameLoopSingleton() {
    }

    public static GameLoopSingleton getInstance() {
        if (instance == null) {
            synchronized (GameLoopSingleton.class) {
                if (instance == null) {
                    instance = new GameLoopSingleton();
                }
            }
        }
        return instance;
    }

    public void start() {
        gameLoopService.start();
    }

    public void end() {
        gameLoopService.end();
    }
}
