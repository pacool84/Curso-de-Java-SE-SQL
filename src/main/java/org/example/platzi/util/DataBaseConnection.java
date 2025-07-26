package org.example.platzi.util;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {
    private static String URL = "jdbc:mysql://localhost:3306/project"; // URL de la base de datos
    private static String USER = "root";
    private static String PASSWORD = "Chevy17";
//    private static Connection myConnection;
    private static BasicDataSource poolConnection; // Pool de conexiones para manejar múltiples conexiones a la base de datos

    // Método getInstance() para obtener la conexión a la base de datos
    public static BasicDataSource getInstance() {
        if(poolConnection == null) {
            try{
                poolConnection = new BasicDataSource();
                poolConnection.setUrl(URL); // Establecer la URL de la base de datos
                poolConnection.setUsername(USER); // Establecer el usuario de la base de datos
                poolConnection.setPassword(PASSWORD); // Establecer la contraseña de la base de datos

                poolConnection.setInitialSize(10); // Establecer el tamaño inicial del pool de conexiones
                poolConnection.setMinIdle(10); // Establecer el número mínimo de conexiones inactivas en el pool
                poolConnection.setMaxIdle(10); // Establecer el número máximo de conexiones inactivas en el pool
                poolConnection.setMaxTotal(20); // Establecer el número máximo total de conexiones en el pool


                System.out.println("データベースへの接続が成功しました！！！");
                System.out.println("¡Conexión a la base de datos exitosa!");

            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("データベース接続エラー :( ");
                System.out.println("Error de conexión a la base de datos :( ");
            }
        }
        return poolConnection;
    }

    public static Connection getConnection() throws SQLException {
        return getInstance().getConnection(); // Obtener una conexión del pool de conexiones
    }
}
