package com.example.rv;

public class Contact {
int id;
    String ContactName;
    String ContactNumber;

    public Contact(String contactName, String contactNumber) {
        ContactName = contactName;
        ContactNumber = contactNumber;

}public Contact(int id,String contactName, String contactNumber) {
    this.id=id;
    ContactName = contactName;
    ContactNumber = contactNumber;
}
    public Contact(int id){
        this.id=id;
    }
    public int getId() {
        return id;
    }

    public String getContactName() {
        return ContactName;
    }

    public void setContactName(String contactName) {
        ContactName = contactName;
    }

    public String getContactNumber() {
        return ContactNumber;
    }

    public void setContactNumber(String contactNumber) {
        ContactNumber = contactNumber;
    }


}
