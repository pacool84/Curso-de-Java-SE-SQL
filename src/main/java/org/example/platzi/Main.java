package org.example.platzi;

import org.example.platzi.model.Employee;
import org.example.platzi.repository.EmployeeRepository;
import org.example.platzi.repository.Repository;
import org.example.platzi.util.DataBaseConnection;

import java.sql.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws SQLException {

        //Al hacerlo de esta forma aplicamos el concepto de AutoCloseable, para poder cerrar automáticamente los recursos utilizados (Connection, Statement, ResultSet) al finalizar el bloque try.
        try (Connection myConnection = DataBaseConnection.getInstance()) { //1.- Realizar la conexión a la base de datos
            Repository<Employee> repository = new EmployeeRepository(); //2.- Crear una instancia del repositorio de empleados
            repository.findAll().forEach(System.out::println); //3.- Obtener todos los empleados y mostrarlos por consola
        }
    }
}