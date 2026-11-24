package ru.noir.model.investigation;

import ru.noir.engine.CrimeGenerator;
import ru.noir.model.city.Location;
import ru.noir.model.city.LocationEnum;
import ru.noir.model.city.LocationType;
import ru.noir.model.entities.NPC;
import ru.noir.model.entities.NPCRole;
import ru.noir.model.entities.ResourceLoader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//Возвращает готовое дело с участниками, локацией и списком подозреваемых

public class CrimeCase {

    private final List<NPC> suspects = new ArrayList<>();
    private final List<Location> locations = new ArrayList<>();
    private final Location murderyLocation;
    private final NPC killer;
    private final NPC victim;

    public CrimeCase(int suspectsCount, int locationsCount)  throws IOException {

        if(suspectsCount < 4){
            throw new IllegalArgumentException("Недостаточное кол-во подозреваемых");
        }

        if(locationsCount < 4){
            throw new IllegalArgumentException("Недостаточное кол-во локаций");
        }

        Random random = new Random();

        ResourceLoader namesData = new ResourceLoader();

        List<String> names = namesData.getNames();
        List<String> surnames = namesData.getSurnames();



        this.suspects.add(new NPC(1,  (names.get(random.nextInt(names.size())) + " " + surnames.get(random.nextInt(surnames.size()))),
                NPCRole.BARTENDER, true, LocationEnum.BLUE_BIRD_BAR,
                false, null));

//      Создание списка рандомных NPC
        for(int i = 2; i <= suspectsCount; i++) {
            NPCRole randomRole = NPCRole.getRandomRole();
            this.suspects.add(new NPC(i, (names.get(random.nextInt(names.size()))
                    + " " + surnames.get(random.nextInt(surnames.size()))),
                    randomRole, false, null,
                    false, null));

//            Не понимаю почему так не работает. Различие в записи имя/фамилия.
//            this.suspects.add(new NPC(i, (names.stream().findAny().toString()
//                    + " " + surnames.stream().findAny().toString()), randomRole,
//                    false, null, false, null));
        }

//      Добавление локации бара и назначение бармена в локацию
        this.locations.add(new Location(1, LocationEnum.BLUE_BIRD_BAR, 1, 0,
                        this.suspects.stream()
                                .filter(n -> n.getClaimedLocation().getType() == LocationType.BAR)
                                .findFirst()
                                .orElse(null))
                );

        for(int i = 2; i <= locationsCount; i++){

//          Тут тоже не совсем понимаю как сделать так, чтобы выбирались
//          100% разные локации
            LocationEnum randomLocation = LocationEnum.getRandomLocation();
            this.locations.add(new Location(i, randomLocation, i, 0, null));
        }

//      Запуск генератора дела
        CrimeGenerator generator = new CrimeGenerator(suspects, locations);

        this.murderyLocation = generator.getMurderyLocation();
        this.killer = generator.getKiller();
        this.victim = generator.getVictim();

    }

    public List<NPC> getSuspects(){
        return this.suspects;
    }

    public List<Location> getLocations(){
        return this.locations;
    }

    public NPC getKiller() {
        return killer;
    }

    public Location getMurderyLocation() {
        return murderyLocation;
    }


    public NPC getVictim() {
        return victim;
    }

}



