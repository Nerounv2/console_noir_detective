package ru.noir;

import ru.noir.engine.CrimeGenerator;
import ru.noir.engine.TimeManager;
import ru.noir.model.city.Location;
import ru.noir.model.city.LocationEnum;
import ru.noir.model.entities.NPC;
import ru.noir.model.entities.NPCRole;

import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        System.out.println("Начало дела:");

        TimeManager timeManager = new TimeManager();
        System.out.println(timeManager);

        System.out.println("=== ИНИЦИАЛИЗАЦИЯ ДЕЛА ===");

        //Список локаций для примера
        List<Location> locations = new ArrayList<>();
        locations.add(new Location(LocationEnum.BLUE_BIRD_BAR, 0, 0, null));
        locations.add(new Location(LocationEnum.CENTRAL_PRECINCT, 1, 0, null));
        locations.add(new Location(LocationEnum.CITY_MORGUE, 2, 0, null));
        locations.add(new Location(LocationEnum.ABANDONED_WAREHOUSE, 3, 0, null));

        // Список подозреваемых (NPC)
        List<NPC> suspects = new ArrayList<>();
        suspects.add(new NPC("npc_1", "Джек «Острый Глаз»", NPCRole.BARTENDER, true, LocationEnum.BLUE_BIRD_BAR, LocationEnum.BLUE_BIRD_BAR, "Я стоял за стойкой весь вечер.", false, null));
        suspects.add(new NPC("npc_2", "Мэри Кэллехен", NPCRole.WITNESS, false, LocationEnum.SLEEPY_HOTEL, LocationEnum.SLEEPY_HOTEL, "Я спала в своей комнате.", false, null));
        suspects.add(new NPC("npc_3", "Офицер Смит", NPCRole.POSTMAN, false, LocationEnum.CENTRAL_PRECINCT, LocationEnum.CENTRAL_PRECINCT, "Патрулировал улицы седьмого сектора.", false, null));

        try {

            for(NPC npc : suspects){
                System.out.println("id: " + npc.getId()+ "; " + npc.getName() + ": " + npc.getAlibiText());
            }

            CrimeGenerator generator = new CrimeGenerator(new ArrayList<>(suspects), new ArrayList<>(locations));

            // 4. Выводим результаты расследования
            System.out.println("\n[Сгенерированное дело]");
            System.out.println(generator.toString());
            for(NPC npc : suspects){
                if(!npc.isVictim())
                    System.out.println(npc.getName() + ": " + npc.getAlibiText());
            }

            System.out.println("Настроящий убийца: " + generator.getKiller().getName() + ": " + generator.getKiller().getAlibiText());

            System.out.println("Выполнение какого-то действия (130 минут)");
            timeManager.addMinutes(130);
            timeManager.setTimeLeft(130);
            System.out.println(timeManager);

        } catch (Exception e) {
            System.err.println("Ошибка при генерации дела: " + e.getMessage());
        }


    }
}