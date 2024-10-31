package com.example.simplemvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Model {

    private Controller controller;
    List<Contact> contacts;


    public Model() {
        this.contacts = new ArrayList<Contact>();
    }
    public void setController(Controller controller) {
        this.controller = controller;

    }

    public void addContact(String name
            , String title
            , String phone
            , String office
            , String station) throws Exception {

        try {
            System.out.println("I am in Model");
            Contact contact = new Contact();
            contact.setName(name);
            contact.setTitle(title);
            contact.setPhone(phone);
            contact.setOffice(office);
            contact.setStation(station);
            contacts.add(contact);
            deliverMessage("Succeed");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void deliverMessage(String message) {
        controller.deliverMessage(message);
    }
}
