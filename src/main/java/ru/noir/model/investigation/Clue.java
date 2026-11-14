package ru.noir.model.investigation;

public record Clue(String title, String description) {

    @Override
    public String toString() {
        return title + ": " + description;
    }
}
