package ru.noir.engine;

import ru.noir.model.city.Location;
import ru.noir.model.city.LocationEnum;
import ru.noir.model.entities.NPC;

import java.util.ArrayList;
import java.util.Random;

public class CrimeGenerator{
    private final NPC killer;
    private final NPC victim;
    private final Location murderyLocation;


    public CrimeGenerator (ArrayList<NPC> suspectsList, ArrayList<Location> locationsList){
        if(suspectsList.isEmpty() || locationsList.isEmpty()){
            throw new IllegalArgumentException("Списки не должны быть пустыми!");
        }


        Random random = new Random();
        int killerIndex = random.nextInt(0, suspectsList.size());
        this.killer = suspectsList.get(killerIndex);
        this.killer.setKiller(true);

        NPC selectedVictim;
        do{
            selectedVictim = suspectsList.get(random.nextInt(0, suspectsList.size()));
        } while(selectedVictim.equals(this.killer));

        this.victim = selectedVictim;
        this.victim.setVictim(true);
        this.victim.setCurrentLocationId(LocationEnum.CITY_MORGUE);

        Location fakeLocation = locationsList.get(random.nextInt(0, locationsList.size()));
        this.killer.setAlibiText("Я был в " + fakeLocation.getName() + ". Меня там все видели.");

//      Создание локации преступления
        Location murderLocation;
        do{
            murderLocation = locationsList.get(random.nextInt(0, locationsList.size()));
        } while (fakeLocation.equals(murderLocation));

        this.murderyLocation = murderLocation;

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
