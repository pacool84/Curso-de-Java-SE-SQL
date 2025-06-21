package org.example.platzi;

import java.sql.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws SQLException {
        Connection myConnection = null;
        Statement myStatement = null;
        ResultSet myResultSet = null;

        String URL = "jdbc:mysql://localhost:3306/project"; // URL de la base de datos
        String USER = "root";
        String PASSWORD = "Chevy17";

        try {
            //1.- Realizar la conexión a la base de datos
            myConnection = DriverManager.getConnection( URL , USER, PASSWORD);
            System.out.println("Conexión exitosa a la base de datos!!!");
            //2.- Crear un objeto Statement para ejecutar consultas SQL
            myStatement = myConnection.createStatement(); // Crear un objeto Statement para ejecutar consultas SQL
            //3.- Ejecutar una consulta SQL para obtener datos de la tabla "employees"
            myResultSet = myStatement.executeQuery("SELECT * FROM employees"); // Ejecutar una consulta SQL para obtener datos de la tabla "employees"
            //4.- Procesar los resultados de la consulta
            while (myResultSet.next()) {
                System.out.println(myResultSet.getString("first_name")); // Imprimir el valor de la columna "first_name" de cada fila
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al conectarse a la base de datos :( ");
        } finally {
            //5.- Cerrar los recursos utilizados
            if(myConnection != null){
                try {
                    myConnection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if(myStatement != null){
                try {
                    myStatement.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if(myResultSet != null){
                try {
                    myResultSet.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }
}