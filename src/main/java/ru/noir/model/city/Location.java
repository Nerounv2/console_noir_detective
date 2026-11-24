package ru.noir.model.city;

import ru.noir.model.Item.Item;
import ru.noir.model.entities.NPC;

import java.util.ArrayList;
import java.util.List;

public class Location {
    private final int id;
    private final String name;
    private final LocationType type;
    private final String description;
    private final int x;
    private final int y;
    private final NPC permanentResident;
    private final List<NPC> visitors;
    private Item hiddenClue;
    private boolean isSearched;

    public Location(int id, LocationEnum locationEnum, int x, int y, NPC permanentResident) {
        this.id = id;
        this.name = locationEnum.getName();
        this.type = locationEnum.getType();
        this.description = locationEnum.getDescription();
        this.x = x;
        this.y = y;
        this.permanentResident = permanentResident;
        this.visitors = new ArrayList<>();
        this.isSearched = false;
        if(permanentResident != null){
            permanentResident.setRole(locationEnum.getNPCRole());
        }

    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public void addVisitor(NPC npc) {
        if (npc != null) {
            this.visitors.add(npc);
        }
    }

//    Поиск улики
    public Item searchLocation() {
        if (!isSearched) {
            isSearched = true;
            Item clue = hiddenClue;
            hiddenClue = null;
            return clue;
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public int getId(){
        return id;
    }

    public LocationType getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public NPC getPermanentResident() {
        return permanentResident;
    }

    public List<NPC> getVisitors() {
        return visitors;
    }

    public boolean isSearched() {
        return isSearched;
    }

    public void setHiddenClue(Item hiddenClue) {
        this.hiddenClue = hiddenClue;
    }
}
