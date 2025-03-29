package com.example.restservice.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Employee {

    //base variables
    private int employee_id;
    @JsonProperty("fname")
    private String first_Name;
    private String email;
    private String last_Name;
    private String title;

    // default constructor
    public Employee() {}


    //new instance constructor
    public Employee(int employee_id, String fName, String lName, String title_JB, String email_AD){
        this.employee_id = employee_id;
        this.first_Name = fName;
        this.email = email_AD;
        this.last_Name = lName;
        this.title = title_JB;

    }

    public int getID() {
        return this.employee_id;
    }

    public void setID( int id){
        this.employee_id = id;
    }

    public String getFname(){
        return this.first_Name;
    }

    public void setFame( String fName){
        this.first_Name = fName;
    }

    public String getEmail(){
        return this.email;
    }

    public void setEmail( String email ){
        this.email = email;
    }

    public String getLname(){
        return this.last_Name;
    }

    public void setLname( String lName ){
        this.last_Name = lName;
    }

    public String getTitle(){
        return this.title;
    }

    public void setTitle( String title ){
        this.title = title;
    }

    @Override
    public String toString() {
        return " Employees:  [" +
                "{  " +
                "employee_id" + employee_id +
                " first_name" + first_Name +
                " last_name" + last_Name +
                " email" + email +
                " title=" + title +
                "}";
    }

}
