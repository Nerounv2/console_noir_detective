package ru.noir.model.entities;

import ru.noir.model.Item.Item;


//В ходе диалога с NPC будет собираться результат опроса NPC
public record DialogResult(String message, boolean isLieFound, Item foundClue) {
}
