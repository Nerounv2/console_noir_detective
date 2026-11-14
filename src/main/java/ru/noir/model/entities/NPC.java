package ru.noir.model.entities;

import ru.noir.model.Item.Item;
import ru.noir.model.city.LocationEnum;

public class NPC {
    private final String id;
    private final String name;
    private final NPCRole role;
    private final boolean isHost;        // Хозяин локации или нет
    private LocationEnum currentLocationId;    // Где реально находится
    private LocationEnum claimedLocationId;    // Aлиби
    private String alibiText;
    private boolean isKiller;
    private boolean isVictim;
    private final Item rewardClue;       // Улика, которую может отдать

    public NPC( String id, String name, NPCRole role, boolean isHost, LocationEnum currentLocationId, LocationEnum claimedLocationId, String alibiText, boolean isKiller, Item rewardClue ) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.isHost = isHost;
        this.currentLocationId = currentLocationId;
        this.claimedLocationId = claimedLocationId;
        this.alibiText = alibiText;
        this.isKiller = isKiller;
        this.rewardClue = rewardClue;
    }

    public void setClaimedLocationId( LocationEnum claimedLocationId ) {
        this.claimedLocationId = claimedLocationId;
    }

    public void setAlibiText( String alibiText ) {
        this.alibiText = alibiText;
    }

    public void setKiller( boolean killer ) {
        isKiller = killer;
    }

    public void setCurrentLocationId( LocationEnum currentLocationId ) {
        this.currentLocationId = currentLocationId;
    }


    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public NPCRole getRole() {
        return role;
    }

    public boolean isHost() {
        return isHost;
    }

    public LocationEnum getCurrentLocationId() {
        return currentLocationId;
    }

    public LocationEnum getClaimedLocationId() {
        return claimedLocationId;
    }

    public String getAlibiText() {
        return alibiText;
    }

    public boolean isKiller() {
        return isKiller;
    }

    public Item getRewardClue() {
        return rewardClue;
    }

    public boolean isVictim() {
        return isVictim;
    }

    public void setVictim( boolean victim ) {
        isVictim = victim;
    }
}
