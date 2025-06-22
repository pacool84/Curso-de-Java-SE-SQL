package org.example.platzi;

import org.example.platzi.util.DataBaseConnection;

import java.sql.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws SQLException {


        //Al hacerlo de esta forma aplicamos el concepto de AutoCloseable, para poder cerrar automáticamente los recursos utilizados (Connection, Statement, ResultSet) al finalizar el bloque try.
        try (
                Connection myConnection = DataBaseConnection.getInstance(); //1.- Realizar la conexión a la base de datos
                Statement myStatement = myConnection.createStatement(); //2.- Crear un objeto Statement para ejecutar consultas SQL
                ResultSet myResultSet = myStatement.executeQuery("SELECT * FROM employees"); //3.- Ejecutar una consulta SQL para obtener datos de la tabla "employees"
        ) {

            //4.- Procesar los resultados de la consulta
            while (myResultSet.next()) {
                System.out.println(myResultSet.getString("first_name")); // Imprimir el valor de la columna "first_name" de cada fila
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al conectarse a la base de datos :( ");
        }
    }
}