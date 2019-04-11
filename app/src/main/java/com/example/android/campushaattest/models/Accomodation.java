package com.example.android.campushaattest.models;

public class Accomodation {

    public static final int PG_TYPE=0;
    public static final int HOSTEL_TYPE=1;
    public static final int APARTMENT_TYPE=2;

    private int type;
    private int roomCount;
    private String address;

    public Accomodation(int type, int roomCount, String address){
        this.setType(type);
        this.setRoomCount(roomCount);
        this.setAddress(address);
    }


    public int getRoomCount() {
        return roomCount;
    }

    public void setRoomCount(int roomCount) {
        this.roomCount = roomCount;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
