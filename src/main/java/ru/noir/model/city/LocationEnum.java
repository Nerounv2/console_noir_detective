package ru.noir.model.city;

public enum LocationEnum {
    BLUE_BIRD_BAR(
            "Бар «Синяя птица»",
            LocationType.BAR,
            "Затуманенное сигаретным дымом заведение. В углу наигрывает неторопливый джаз."
    ),
    DIRTY_DINO_BAR(
            "Бар «Грязный Джин»",
            LocationType.BAR,
            "Дешевое питейное заведение. Пахнет пролитым спиртом и сыростью."
    ),
    CENTRAL_PRECINCT(
            "Центральный участок",
            LocationType.POLICE_STATION,
            "Шумный полицейский отдел. Стучат печатные машинки, офицеры гоняют остывший противный кофе."
    ),
    CITY_MORGUE(
            "Городской морг",
            LocationType.MORGUE,
            "Холодный кафельный подвал. В воздухе висит тяжелый запах антисептика."
    ),
    SLEEPY_HOTEL(
            "Отель «Пилигрим»",
            LocationType.HOTEL,
            "Обшарпанная ночлежка. Тусклая вывеска мигает на фасаде, ступенчатый пол скрипит."
    ),
    DARK_ALLEY(
            "Переулок Понтиак",
            LocationType.ALLEY,
            "Узкий темный проход между кирпичными домами. Пар валит из вентиляционных люков."
    ),
    OLD_PAWN_SHOP(
            "Ломбард «У соседа»",
            LocationType.PAWN_SHOP,
            "Заваленная старым барахлом лавка. За решеткой висят карманные часы и старые пафосные револьверы."
    ),
    ABANDONED_WAREHOUSE(
            "Склад №4",
            LocationType.CRIME_SCENE,
            "Мрачный заброшенный док. Желтая полицейская лента огораживает место преступления."
    ),
    NORTH_DOCKS(
            "Северный пирс",
            LocationType.DOCKS,
            "Сырой причал. Волны бьются о гнилые сваи, слышен далекий гудок катера."
    );

    private final String name;
    private final LocationType type;
    private final String description;

    LocationEnum(String name, LocationType type, String description) {
        this.name = name;
        this.type = type;
        this.description = description;
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
}
