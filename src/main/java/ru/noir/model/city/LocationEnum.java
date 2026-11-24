package ru.noir.model.city;

import ru.noir.model.entities.NPCRole;

import java.util.concurrent.ThreadLocalRandom;

public enum LocationEnum {
    BLUE_BIRD_BAR(
            "Бар «Синяя птица»",
            LocationType.BAR,
            "Затуманенное сигаретным дымом заведение. В углу наигрывает неторопливый джаз.",
            ru.noir.model.entities.NPCRole.BARTENDER
    ),
    DIRTY_DINO_BAR(
            "Бар «Грязный Джин»",
            LocationType.BAR,
            "Дешевое питейное заведение. Пахнет пролитым спиртом и сыростью.",
            ru.noir.model.entities.NPCRole.BARTENDER
    ),
    CENTRAL_PRECINCT(
            "Центральный участок",
            LocationType.POLICE_STATION,
            "Шумный полицейский отдел. Стучат печатные машинки, офицеры гоняют остывший противный кофе.",
            null
    ),
    CITY_MORGUE(
            "Городской морг",
            LocationType.MORGUE,
            "Холодный кафельный подвал. В воздухе висит тяжелый запах антисептика.",
            null
    ),
    SLEEPY_HOTEL(
            "Отель «Пилигрим»",
            LocationType.HOTEL,
            "Обшарпанная ночлежка. Тусклая вывеска мигает на фасаде, ступенчатый пол скрипит.",
            ru.noir.model.entities.NPCRole.WITNESS
    ),
    DARK_ALLEY(
            "Переулок Понтиак",
            LocationType.ALLEY,
            "Узкий темный проход между кирпичными домами. Пар валит из вентиляционных люков.",
            null
    ),
    OLD_PAWN_SHOP(
            "Ломбард «У соседа»",
            LocationType.PAWN_SHOP,
            "Заваленная старым барахлом лавка. За решеткой висят карманные часы и старые пафосные револьверы.",
            null
    ),
    ABANDONED_WAREHOUSE(
            "Склад №4",
            LocationType.CRIME_SCENE,
            "Мрачный заброшенный док. Желтая полицейская лента огораживает место преступления.",
            ru.noir.model.entities.NPCRole.JANITOR
    ),
    NORTH_DOCKS(
            "Северный пирс",
            LocationType.DOCKS,
            "Сырой причал. Волны бьются о гнилые сваи, слышен далекий гудок катера.",
            null
    );

    private final String name;
    private final LocationType type;
    private final String description;
    private final NPCRole NPCRole;

    LocationEnum(String name, LocationType type, String description, NPCRole npcRole) {
        this.name = name;
        this.type = type;
        this.description = description;
        this.NPCRole = npcRole;
    }


    private static final LocationEnum[] VALUES = values();

    public static LocationEnum getRandomLocation() {
        int randomIndex = ThreadLocalRandom.current().nextInt(VALUES.length);
        return VALUES[randomIndex];
    }

    public String getName() {
        return name;
    }

    public LocationType getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public NPCRole getNPCRole() {
        return NPCRole;
    }
}
