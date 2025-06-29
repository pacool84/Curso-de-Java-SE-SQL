package org.example.platzi.repository;

import org.example.platzi.model.Employee;
import org.example.platzi.util.DataBaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// Clase EmployeeRepository que implementa la interfaz Repository para manejar objetos Employee
//Aquí está el concepto de IMPLEMENTACIÓN DE INTERFACES, que permite que una clase implemente los métodos definidos en una interfaz.

public class EmployeeRepository implements Repository <Employee> {
    // Atributo para almacenar la conexión a la base de datos
    private Connection getConnection() throws SQLException {
        return DataBaseConnection.getInstance();
    }
// Implementación de los métodos de la interfaz Repository para la clase Employee
    @Override // Método para obtener todos los registros de la base de datos
    public List<Employee> findAll() throws SQLException {
        List <Employee> employees = new ArrayList<>();

        try(Statement myStatement = getConnection().createStatement();
        ResultSet myResultSet = myStatement.executeQuery("SELECT * FROM employees")){
            while(myResultSet.next()){
                Employee myEmployee = createEmployee(myResultSet); // Crear el objeto Employee a partir del ResultSet
                employees.add(myEmployee); // Agregar el objeto Employee a la lista
            }
        }
        return employees;
    }
    @Override // Método para obtener un registro por su ID
    public Employee getById(Integer id) throws SQLException {
        Employee myEmployee = null;
        try(PreparedStatement myPreparedStatement = getConnection().prepareStatement("SELECT * FROM employees WHERE id = ?")){
            myPreparedStatement.setInt(1, id); // Establecer el valor del parámetro en la consulta SQL
            try(ResultSet myResultSet = myPreparedStatement.executeQuery()) {
                if(myResultSet.next()){
                    myEmployee = createEmployee(myResultSet); // Crear el objeto Employee a partir del ResultSet
                } else {
                    System.out.println("IDが見つかりませんでした: " + id);
                    System.out.println("No se encontró un empleado con el ID: " + id);
                }
            }
        }
        return myEmployee; // Retorna el objeto Employee encontrado o null si no se encontró
    }

    @Override
    public void save(Employee employee) throws SQLException {
        String sql = "INSERT INTO employees (first_name, pa_surname, ma_surname, email, salary) VALUES (?, ?, ?, ?, ?)"; // Consulta SQL para insertar un nuevo empleado

        try (PreparedStatement myPreparedStatement = getConnection().prepareStatement(sql)) {
            myPreparedStatement.setString(1, employee.getFirst_name());
            myPreparedStatement.setString(2, employee.getPa_surname());
            myPreparedStatement.setString(3, employee.getMa_surname());
            myPreparedStatement.setString(4, employee.getEmail());
            myPreparedStatement.setFloat(5, employee.getSalary());

            myPreparedStatement.executeUpdate(); // Ejecutar la inserción
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al guardar el empleado: " + e.getMessage());
        }

    }

    @Override
    public void delete(Integer id) {

    }

    private Employee createEmployee(ResultSet myResultSet) throws SQLException {
        Employee myEmployee = new Employee();
        myEmployee.setId(myResultSet.getInt("id"));
        myEmployee.setFirst_name(myResultSet.getString("first_name"));
        myEmployee.setPa_surname(myResultSet.getString("pa_surname"));
        myEmployee.setMa_surname(myResultSet.getString("ma_surname"));
        myEmployee.setEmail(myResultSet.getString("email"));
        myEmployee.setSalary(myResultSet.getFloat("salary"));

        return myEmployee; // Retorna el objeto Employee creado a partir del ResultSet
    }
}
