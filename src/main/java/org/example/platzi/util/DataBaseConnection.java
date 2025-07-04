package org.example.platzi.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataBaseConnection {
    private static String URL = "jdbc:mysql://localhost:3306/project"; // URL de la base de datos
    private static String USER = "root";
    private static String PASSWORD = "Chevy17";
    private static Connection myConnection;

    // Método getInstance() para obtener la conexión a la base de datos
    public static Connection getInstance() {
        if(myConnection == null) {
            try{
                myConnection = DriverManager.getConnection(URL, USER, PASSWORD); // Realizar la conexión a la base de datos
                System.out.println("データベースへの接続が成功しました！！！");
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("データベース接続エラー :( ");
            }
        }
        return myConnection;
    }
}
