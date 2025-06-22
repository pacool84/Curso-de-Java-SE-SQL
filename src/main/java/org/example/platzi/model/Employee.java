package org.example.platzi.model;

public class Employee {
    // Atributos de la clase Employee
    // Estos atributos representan las columnas de la tabla "employees" en la base de datos
    private int id;
    private String first_name;
    private String pa_surname;
    private String ma_surname;
    private String email;
    private Float salary;

    // Constructor de la clase Employee
    public Employee() {

    }

    public Employee (int id, String first_name, String pa_surname, String ma_surname, String email, Float salary) {
        this.id = id;
        this.first_name = first_name;
        this.pa_surname = pa_surname;
        this.ma_surname = ma_surname;
        this.email = email;
        this.salary = salary;
    }

    // Getters y Setters para acceder y modificar los atributos
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getPa_surname() {
        return pa_surname;
    }

    public void setPa_surname(String pa_surname) {
        this.pa_surname = pa_surname;
    }

    public String getMa_surname() {
        return ma_surname;
    }

    public void setMa_surname(String ma_surname) {
        this.ma_surname = ma_surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Float getSalary() {
        return salary;
    }

    public void setSalary(Float salary) {
        this.salary = salary;
    }

    // Método toString para representar el objeto Employee como una cadena
    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", pa_surname='" + pa_surname + '\'' +
                ", ma_surname='" + ma_surname + '\'' +
                ", email='" + email + '\'' +
                ", salary=" + salary +
                '}';
    }
}
