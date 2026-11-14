package ru.noir.model.city;

public enum LocationType {
    BAR("Бар / Клуб"),
    POLICE_STATION("Полицейский участок"),
    MORGUE("Городской морг"),
    HOTEL("Отель / Ночлежка"),
    CRIME_SCENE("Место преступления"),
    PAWN_SHOP("Ломбард"),
    ALLEY("Темный переулок"),
    DOCKS("Портовые доки");

    private final String title;

    LocationType(String russianTitle) {
        this.title = russianTitle;
    }

    public String getTitle() {
        return title;
    }
}
