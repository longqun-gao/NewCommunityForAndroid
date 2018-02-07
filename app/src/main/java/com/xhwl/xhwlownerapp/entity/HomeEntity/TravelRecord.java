package com.xhwl.xhwlownerapp.entity.HomeEntity;

/**
 * Created by Administrator on 2018/2/2.
 */

public class TravelRecord {
    private String TraveName;
    private String TraveDoor;
    private String TraveTime;
    private String TreveOut;

    public TravelRecord(){}

    public TravelRecord(String TraveName,String TraveDoor,String TraveTime,String TreveOut){
        this.TraveDoor = TraveDoor;
        this.TraveName = TraveName;
        this.TraveTime = TraveTime;
        this.TreveOut = TreveOut;
    }

    public String getTraveName() {
        return TraveName;
    }

    public void setTraveName(String traveName) {
        TraveName = traveName;
    }

    public String getTraveDoor() {
        return TraveDoor;
    }

    public void setTraveDoor(String traveDoor) {
        TraveDoor = traveDoor;
    }

    public String getTraveTime() {
        return TraveTime;
    }

    public void setTraveTime(String traveTime) {
        TraveTime = traveTime;
    }

    public String getTreveOut() {
        return TreveOut;
    }

    public void setTreveOut(String treveOut) {
        TreveOut = treveOut;
    }
}
