package com.example.budgetmanager.Model;

public class Data {

    private int amount;
    private String type;
    private String note;

    public Data(String data, String id, String note, String type, int amount) {
        this.data = data;
        this.id = id;
        this.note = note;
        this.type = type;
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    private String id;
    private String data;

    public Data(){

    }


}
