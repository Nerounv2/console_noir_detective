package ru.noir.model.investigation;

import ru.noir.engine.CrimeGenerator;
import ru.noir.model.city.Location;

//Итог работы CrimeGenerator
//Возвращает готовое дело с участниками, локацией и списком подозреваемых

public record CrimeCase(CrimeGenerator crimeGenerator) {
}



