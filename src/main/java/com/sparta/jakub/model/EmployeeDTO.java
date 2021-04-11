package com.sparta.jakub.model;


import java.util.Date;

public class EmployeeDTO {
    private int employee_id;
    private String name_prefix;
    private String first_name;
    private String middle_initial;
    private String last_name;
    private String gender;
    private String email;
    private Date date_of_birth;
    private Date date_of_join;
    private int salary;

    public EmployeeDTO(int employee_id, String name_prefix, String first_name, String middle_initial, String last_name, String gender, String email, Date date_of_birth, Date date_of_join, int salary) {

        this.employee_id = employee_id;
        this.name_prefix = name_prefix;
        this.first_name = first_name;
        this.middle_initial = middle_initial;
        this.last_name = last_name;
        this.gender = gender;
        this.email = email;
        this.date_of_birth = date_of_birth;
        this.date_of_join = date_of_join;
        this.salary = salary;
    }


    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public String getName_prefix() {
        return name_prefix;
    }

    public void setName_prefix(String name_prefix) {
        this.name_prefix = name_prefix;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getMiddle_initial() {
        return middle_initial;
    }

    public void setMiddle_initial(String middle_initial) {
        this.middle_initial = middle_initial;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(Date date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public Date getDate_of_join() {
        return date_of_join;
    }

    public void setDate_of_join(Date date_of_join) {
        this.date_of_join = date_of_join;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "EmployeeDTO{" +
                "employee_id=" + employee_id +
                ", name_prefix='" + name_prefix + '\'' +
                ", first_name='" + first_name + '\'' +
                ", middle_initial='" + middle_initial + '\'' +
                ", last_name='" + last_name + '\'' +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", date_of_birth=" + date_of_birth +
                ", date_of_join=" + date_of_join +
                ", salary=" + salary +
                '}';
    }
}
