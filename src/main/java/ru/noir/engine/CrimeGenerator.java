package ru.noir.engine;

import ru.noir.model.city.Location;
import ru.noir.model.entities.NPC;

import java.util.List;
import java.util.Random;

public class CrimeGenerator{
    private final NPC killer;
    private final NPC victim;
    private final Location murderyLocation;


    public CrimeGenerator (List<NPC> suspectsList, List<Location> locationsList){
        if(suspectsList.isEmpty() || locationsList.isEmpty()){
            throw new IllegalArgumentException("Списки не должны быть пустыми!");
        }


        Random random = new Random();
        int killerIndex = random.nextInt(0, suspectsList.size());
        this.killer = suspectsList.get(killerIndex);
        this.killer.setKiller(true);

        this.victim = suspectsList.stream()
                .filter(s -> !s.isKiller())
                .findAny()
                .orElse(null);                ;

        this.victim.setVictim(true);
//        this.victim.setCurrentLocationId(LocationEnum.CITY_MORGUE);

        Location fakeLocation = locationsList.get(random.nextInt(0, locationsList.size()));
        this.killer.setAlibiText("Я был в " + fakeLocation.getName() + ". Меня там все видели.");

//      Создание локации преступления



        this.murderyLocation = locationsList.stream()
                .filter(l -> !fakeLocation.equals(l))
                .findAny()
                .orElse(null);
    }

    public NPC getKiller(){
        return this.killer;
    }

    public NPC getVictim(){
        return this.victim;
    }

    public Location getMurderyLocation() {
        return this.murderyLocation;
    }

    @Override
    public String toString() {
        return "Убийца: " + killer.getName() + "; Жертва: " + victim.getName() + "; Локация: " + murderyLocation.getName();
    }
}
