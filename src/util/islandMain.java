package util;

import engine.IslandEngine;

public class IslandMain {
    public static void main(String[] args) {
        IslandEngine engine = new IslandEngine(20, 10); // Створюємо двигун симуляції
        engine.startSimulation(); // Запускаємо симуляцію
    }
}
