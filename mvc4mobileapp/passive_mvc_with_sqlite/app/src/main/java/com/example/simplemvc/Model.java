package com.example.simplemvc;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Model extends SQLiteOpenHelper {

    /**
     * Class data members used to create a database including tables if
     * it doesn't exist
     */
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "universityDirectory";
    private static final String TABLE_CONTACTS = "contacts";
    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String TITLE = "title";
    private static final String PHONE = "phone";
    private static final String OFFICE = "office";
    private static final String STATION = "station";

    private Controller controller;


    /**
     * This is the SQLiteOpenHelper's constructor, defining where/when the database
     * exists.
     * @param context the ActivityName.this
     */
    public Model(Context context) {
        // Create a helper object to create, open, and/or manage a database.
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /**
     * This function create a table
     * @param sqLiteDatabase a database object to create, delete, execute SQL commands
     */
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_CONTACTS + "("
                + ID + " INTEGER PRIMARY KEY," + NAME + " TEXT,"
                + TITLE + " TEXT," + PHONE + " TEXT, "
                + OFFICE + " TEXT," + STATION + " TEXT" +")";
        Log.d("name", CREATE_CONTACTS_TABLE );
        sqLiteDatabase.execSQL(CREATE_CONTACTS_TABLE);

    }

    /**
     * This function writes the cashed database into the actual database
     * @param sqLiteDatabase a database object
     * @param oldVersion database old version
     * @param newVersion database new version
     */
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        // Drop older table if existed
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTS);

        // Create tables again
        onCreate(sqLiteDatabase);
    }

    /**
     * This function adds a new user to the database
     * @param contact user data structure object
     */
    public void addContact(Contact contact) {
        // Retrieves a writable instance of the database to allow inserting new records
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        // Define a ContentValues object to store the data aimed to be inserted into the database.
        ContentValues values = new ContentValues();
        values.put(NAME, contact.getName()); // Contact Name
        values.put(TITLE, contact.getTitle()); // Contact title
        values.put(PHONE, contact.getPhone()); // Contact Phone
        values.put(OFFICE, contact.getOffice()); // Contact office
        values.put(STATION, contact.getStation()); // Contact station

        // For debugging purpose
        //Log.d("name", values.toString());

        /*
        Inserting Row, 2nd argument is String containing nullColumnHack
        , allowing to insert a row even when all data is null
         */
        sqLiteDatabase.insert(TABLE_CONTACTS, null, values);
        sqLiteDatabase.close(); // Closing database connection
    }


    public void setController(Controller controller) {
        this.controller = controller;

    }

    /**
     * This function retrieves all contacts from the database
     */
    public void getAllContacts() {
        List<Contact> contacts = new ArrayList<Contact>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_CONTACTS;

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        /*
        A Cursor is an Android interface, acting like a pointer traversing through the rows of data
         retrieved from the database.
         rawQuery allows to execute a SQL query for retrieving data.
         */
        Cursor cursor = sqLiteDatabase.rawQuery(selectQuery, null);

        // Check if the results contain data and loops through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Contact contact = new Contact();
                contact.setID(Integer.parseInt(cursor.getString(0)));
                contact.setName(cursor.getString(1));
                contact.setTitle(cursor.getString(2));
                contact.setPhone(cursor.getString(3));
                contact.setOffice(cursor.getString(4));
                contact.setStation(cursor.getString(5));

                // Adding contact to list
                contacts.add(contact);
            } while (cursor.moveToNext());
        }

        sqLiteDatabase.close(); // Close the database connection

        // deliver contact list
        deliverMessage(contacts);
    }

    public void deleteAllContacts() {
        /*
        String sql = "DELETE FROM contacts WHERE name = 'Essa Imhmed'";
        sqLiteDatabase.execSQL(sql);
         */
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        // Delete all contacts
        sqLiteDatabase.execSQL("DELETE FROM " + TABLE_CONTACTS);
        sqLiteDatabase.close(); // Close the database connection
    }

    public void deleteContactByName(String contactName) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        // Define the WHERE clause
        String whereClause = "name = ?";
        // Define the arguments for the WHERE clause
        String[] whereArgs = new String[] { contactName };

        // Delete the record
        sqLiteDatabase.delete(TABLE_CONTACTS, whereClause, whereArgs);
        sqLiteDatabase.close(); // Close the database connection
    }

    public void updateContactName(String oldName, String newName) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        // Define the WHERE clause
        String whereClause = "name = ?";
        // Define the arguments for the WHERE clause
        String[] whereArgs = new String[] { oldName };

        // Create a ContentValues object to hold the new values
        ContentValues values = new ContentValues();
        values.put("name", newName); // Update the name

        // Update the record
        sqLiteDatabase.update(TABLE_CONTACTS, values, whereClause, whereArgs);
        sqLiteDatabase.close(); // Close the database connection
    }

    public void getContactByName(String contactName) {
        List<Contact> contacts = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        // Define the query
        String selectQuery = "SELECT * FROM " + TABLE_CONTACTS + " WHERE name = ?";

        // Execute the query
        Cursor cursor = sqLiteDatabase.rawQuery(selectQuery, new String[] { contactName });

        // Loop through the results
        if (cursor.moveToFirst()) {
            do {
                Contact contact = new Contact();
                contact.setID(Integer.parseInt(cursor.getString(0)));
                contact.setName(cursor.getString(1));
                contact.setTitle(cursor.getString(2));
                contact.setPhone(cursor.getString(3));
                contact.setOffice(cursor.getString(4));
                contact.setStation(cursor.getString(5));

                // Add contact to the list
                contacts.add(contact);
            } while (cursor.moveToNext());
        }

        // Close the cursor and database
        cursor.close();
        sqLiteDatabase.close();

        // Display the contact information (assuming you have a method to do this)
        deliverMessage(contacts);
    }

    public void deliverMessage(List<Contact> contacts) {
        controller.deliverMessage(contacts);
    }

}
