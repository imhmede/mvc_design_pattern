package com.example.simplemvc;

public class Contact {

    /**
     * Class fields
     */
    private int id;
    private String name;
    private String title;
    private String phone;
    private String office;
    private String station;

    public Contact() {}

    public Contact(String name
            , String title
            , String phone
            , String office
            , String station) {

        this.name = name;
        this.title = title;
        this.phone = phone;
        this.office = office;
        this.station = station;
    }

    /**
     * Setters for the class fields
     */

    public void setID(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public void setStation(String station) {
        this.station = station;
    }

    /**
     * Getters for the class field
     */

    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }

    public String getPhone() {
        return phone;
    }

    public String getOffice() {
        return office;
    }

    public String getStation() {
        return station;
    }
}
