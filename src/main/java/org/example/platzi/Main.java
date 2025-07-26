package org.example.platzi;

import org.example.platzi.model.Employee;
import org.example.platzi.repository.EmployeeRepository;
import org.example.platzi.repository.Repository;
import org.example.platzi.util.DataBaseConnection;
//import org.example.platzi.view.SwingApp;

import java.sql.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws SQLException {

        //Al hacerlo de esta forma aplicamos el concepto de AutoCloseable, para poder cerrar automáticamente los recursos utilizados (Connection, Statement, ResultSet) al finalizar el bloque try.
//        try (Connection myConnection = DataBaseConnection.getInstance()) { //1.- Realizar la conexión a la base de datos
//            Repository<Employee> repository = new EmployeeRepository(); //2.- Crear una instancia del repositorio de empleados
//            repository.findAll().forEach(System.out::println); //3.- Obtener todos los empleados y mostrarlos por consola

//            System.out.println("--------------Metodo getById----------------------");
//            System.out.println("Obteniendo un empleado por ID: " + repository.getById(4)); //4.- Obtener un empleado por su ID y mostrarlo por consola

//            System.out.println("-----------Metodo SAVE-----------------");
//            System.out.println("メソッド保存");

            // Crear un nuevo empleado y establecer sus atributos
//            Employee myNewEmployee = new Employee();
//            myNewEmployee.setId(15);
//            myNewEmployee.setFirst_name("Francisco");
//            myNewEmployee.setPa_surname("López");
//            myNewEmployee.setMa_surname("Campos");
//            myNewEmployee.setEmail("sebast17@outlook.com");
//            myNewEmployee.setSalary(10000.0F);
//
//            repository.save(myNewEmployee); //5.- Actualizar un nuevo empleado en la base de datos
//            System.out.println("メソッド保存");
//            System.out.println("Empleado actualizado exitosamente: " + myNewEmployee);

//            System.out.println("-----------Metodo DELETE-----------------");
//            repository.delete(18); //6.- Eliminar un empleado por su ID
//            repository.delete(15);
//            repository.delete(14);
//
//        }
//        SwingApp app = new SwingApp();//Crear una instancia de la aplicación Swing
//        app.setVisible(true); //Hacer visible la aplicación Swing

        try(Connection myConnection = DataBaseConnection.getInstance()) {

            if(myConnection.getAutoCommit()){
                myConnection.setAutoCommit(false); // Desactivar el autocommit para manejar transacciones manualmente
            }
            try {
                Repository<Employee> repository = new EmployeeRepository(myConnection);
                Employee employee = new Employee();
                employee.setFirst_name("America");
                employee.setPa_surname("Gonzalez");
                employee.setMa_surname("Lopez");
                employee.setEmail("a.gonzalez@outlook.com");
                employee.setSalary(15000.0F);
                employee.setCurp("GOLA010101HDFLPA09");
                repository.save(employee); // Guardar el nuevo empleado en la base de datos

                myConnection.commit(); // Confirmar la transacción

            } catch (SQLException e) {
                myConnection.rollback(); // Revertir la transacción en caso de error
                throw new RuntimeException(e);
            }
        }
    }
}