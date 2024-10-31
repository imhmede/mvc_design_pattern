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
        model.addContact(new Contact(name, title, phone, office, station));
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

    public void getAllContacts() {
        model.getAllContacts();
    }

    public void deliverMessage(List<Contact> contacts) {
        String log = "";
        for (Contact contact : contacts) {
            log = log + ("["
                    + contact.getName() + ", "
                    + contact.getTitle() + ", "
                    + contact.getPhone() + ", "
                    + contact.getOffice() + ", "
                    + contact.getStation() + "]\n");
        }
        view.receiveMessage(log);
    }

}
