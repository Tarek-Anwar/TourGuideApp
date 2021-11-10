package com.android.tourguide.Adapter;

public class PlaceInfo {

    // date to need in view
    private String namePlace;
    private String placeAddress;
    private String aboutPlace;
    private String phonePlace = "0";
    private String locationPlace;
    private int placeImg ;

    public PlaceInfo(String namePlace, String placeAddress ,String aboutPlace
            ,String phonePlace , String locationPlace, int placeImg) {

        this.namePlace = namePlace;
        this.placeAddress = placeAddress;
        this.placeImg = placeImg;
        this.aboutPlace = aboutPlace;
        this.phonePlace = phonePlace;
        this.locationPlace = locationPlace;
    }

    public PlaceInfo(String namePlace, String placeAddress ,String aboutPlace
             , String locationPlace, int placeImg) {
        this.namePlace = namePlace;
        this.placeAddress = placeAddress;
        this.placeImg = placeImg;
        this.aboutPlace = aboutPlace;
        this.locationPlace = locationPlace;
    }

    public  boolean hasPhone (){
        return !(phonePlace.equals("0"));
    }
    public String getAboutPlace() {
        return aboutPlace;
    }

    public void setAboutPlace(String aboutPlace) {
        this.aboutPlace = aboutPlace;
    }

    public String getPhonePlace() {
        return phonePlace;
    }

    public void setPhonePlace(String phonePlace) {
        this.phonePlace = phonePlace;
    }

    public String getLactionPlace() {
        return locationPlace;
    }

    public void setLactionPlace(String lactionPlace) {
        this.locationPlace = lactionPlace;
    }

    public String getNamePlace() {
        return namePlace;
    }

    public void setNamePlace(String namePlace) {
        this.namePlace = namePlace;
    }

    public String getPlaceAddress() {
        return placeAddress;
    }

    public void setPlaceAddress(String placeAddress) {
        this.placeAddress = placeAddress;
    }

    public int getPlaceImg() {
        return placeImg;
    }

    public void setPlaceImg(int placeImg) {
        this.placeImg = placeImg;
    }
}
