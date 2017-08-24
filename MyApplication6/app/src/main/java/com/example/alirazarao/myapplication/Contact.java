package com.example.alirazarao.myapplication;

/**
 * Created by Hussnain on 4/8/2017.
 */

public class Contact {

    private int _id;
    private String _name;
    private int _phone_number;
    public Contact(String name, int id, String ph){
    }

    public Contact(int name, int id, int _phone_number){
        this._id = id;

        this._phone_number = _phone_number;
    }

    public Contact(String name){
        this._name = name;

    }

    public int getID(){
        return this._id;
    }

    public void setID(int id){
        this._id = id;
    }

    public String getName(){
        return this._name;
    }

    public void setName(String name){
        this._name = name;
    }

    public int getPhoneNumber(){
        return this._phone_number;
    }

    public void setPhoneNumber(int phone_number){
        this._phone_number = phone_number;
    }
}
