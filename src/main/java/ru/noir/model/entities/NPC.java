package ru.noir.model.entities;

import ru.noir.model.Item.Item;
import ru.noir.model.city.LocationEnum;

public class NPC {
    private final int id;
    private final String name;
    private NPCRole role;
    private final boolean isHost;        // Хозяин локации или нет
//    private LocationEnum currentLocationId;    // Где реально находится
    private LocationEnum claimedLocation;    // Aлиби
    private String alibiText;
    private boolean isKiller;
    private boolean isVictim;
    private final Item rewardClue;       // Улика, которую может отдать

    //Builder
    public NPC( int id, String name, NPCRole role, boolean isHost,
                LocationEnum claimedLocationId,
                boolean isKiller, Item rewardClue ) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.isHost = isHost;
//        this.currentLocationId = currentLocationId;
        this.claimedLocation = claimedLocationId;
        this.alibiText = role.getAlibi();
        this.isKiller = isKiller;
        this.rewardClue = rewardClue;
    }

    public void setClaimedLocation(LocationEnum claimedLocation) {
        this.claimedLocation = claimedLocation;
    }

    public void setAlibiText( String alibiText ) {
        this.alibiText = alibiText;
    }

    public void setKiller( boolean killer ) {
        isKiller = killer;
    }

//    public void setCurrentLocationId( LocationEnum currentLocationId ) {
//        this.currentLocationId = currentLocationId;
//    }

    public void setRole(NPCRole role){
        this.role = role;
    }



    public int getId() {
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

//    public LocationEnum getCurrentLocationId() {
//        return currentLocationId;
//    }

    public LocationEnum getClaimedLocation() {
        return claimedLocation;
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

    @Override
    public String toString() {
        return super.toString();
    }
}
