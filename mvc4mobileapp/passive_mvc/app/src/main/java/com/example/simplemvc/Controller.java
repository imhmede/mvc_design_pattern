package com.example.simplemvc;

import android.content.Context;

import java.util.List;

public class Controller {
    private Model model;
    private MainActivity view;

    public Controller(Model model, MainActivity view) {
        this.model = model;
        this.view = view;
    }

    public void addContact(String name
            , String title
            , String phone
            , String office
            , String station
                           ) throws Exception {
        System.out.printf("Controller:\t name: %s\ttitle: %s\t\n", name, title);
        model.addContact(name, title, phone, office, station);
    }

    public String[] viewContact(String name
            , String title
            , String phone
            , String office
            , String station) {
        String[] contact;
        contact = new String[]{name, title, phone, office, station};
        return contact;
    }

    public String getContacts() {

        List<Contact> contacts = model.getContacts();
        String log = "";
        for (Contact contact : contacts) {
            log = log + ("["
                    + contact.getName() + ", "
                    + contact.getTitle() + ", "
                    + contact.getPhone() + ", "
                    + contact.getOffice() + ", "
                    + contact.getStation() + "]\n");
        }

        return log;
    }

    public void deliverMessage(String message) {
        view.receiveMessage(message);
    }

}
