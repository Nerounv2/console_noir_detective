package ru.noir.model.entities;

import java.util.concurrent.ThreadLocalRandom;

public enum NPCRole {

        BARTENDER("Бармен", "Протирал стойку весь вечер.")
    ,   JANITOR("Уборщик", "Мыл полы в другом крыле.")
    ,   WITNESS("Сосед", "Смотрел телевизор дома.")
    ,   MAFIA_THUG("Осведомитель", "Был в подпольном клубе.")
    ,   JOURNALIST("Журналист", "Проявлял снимки у себя в редакции.")
    ,   BODYGUARD("Телохранитель", "Дежурил у главного входа и никого не видел.")
    ,   POSTMAN("Почтальон", "Весь день проверял почтовые ящики в другом районе")
    ,   CORONER("Коронер", "Все время был у себя в лаборатории, у меня был очень важный эксперимент")
    ;

    private final String title;
    private final String alibi;


    NPCRole(String title, String alibi) {
        this.title = title;
        this.alibi = alibi;
    }

    private static final NPCRole[] VALUES = values();

    public static NPCRole getRandomRole() {
        int randomIndex = ThreadLocalRandom.current().nextInt(VALUES.length);
        return VALUES[randomIndex];
    }

    public String getAlibi() {
        return alibi;
    }

    public String getTitle() {
        return title;
    }
}
