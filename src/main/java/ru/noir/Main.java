package ru.noir;

import ru.noir.engine.TimeManager;
import ru.noir.model.city.Location;
import ru.noir.model.entities.NPC;
import ru.noir.model.entities.ResourceLoader;
import ru.noir.model.investigation.CrimeCase;

import java.io.IOException;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {

        CrimeCase newCrimeCase = new CrimeCase(10, 5);



        System.out.println("Начало дела:");

        TimeManager timeManager = new TimeManager();
        System.out.println(timeManager);

        System.out.println("=== ИНИЦИАЛИЗАЦИЯ ДЕЛА ===");

        try {

            for(NPC npc : newCrimeCase.getSuspects()){
                System.out.println("id: " + npc.getId()+ "; " + npc.getRole().getTitle() + "; "+ npc.getName() + ": " + npc.getAlibiText());
            }

            for(Location l : newCrimeCase.getLocations()){
                System.out.println("id: " + l.getId() + "; " + l.getName() + "; " + l.getPermanentResident());
            }
            System.out.println("Жертва: " + newCrimeCase.getVictim().getName());
            System.out.println("Локация преступления: " + newCrimeCase.getMurderyLocation().getName());
            System.out.println("Жертва: " + newCrimeCase.getKiller().getName());

            // 4. Выводим результаты расследования
            System.out.println("\n[Сгенерированное дело]");



            System.out.println("Выполнение какого-то действия (130 минут)");
            timeManager.addMinutes(130);
            timeManager.setTimeLeft(130);
            System.out.println(timeManager);

        } catch (Exception e) {
            System.err.println("Ошибка при генерации дела: " + e.getMessage());
        }


    }
}