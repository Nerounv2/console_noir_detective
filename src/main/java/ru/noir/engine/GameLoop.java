package ru.noir.engine;
import ru.noir.model.city.CityMap;
import ru.noir.model.entities.Detective;
import ru.noir.ui.ScreenManager;

public class GameLoop {
    boolean isRunning;
    GameState currentState;
    ScreenManager screenManager;
    CityMap cityMap;
    Detective detective;
    CrimeGenerator crimeGenerator;
    TimeManager timeManager;

    public GameLoop() {

    }

}
