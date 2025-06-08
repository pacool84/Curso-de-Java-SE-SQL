import com.mysql.cj.protocol.Resultset;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //Se declaran las variables-componentes de la conexión a la base de datos
        Connection myConnection = null;
        Statement myStatement = null;
        ResultSet myResultSet = null;

        //Realizar la conexión a la base de datos
        try{
            myConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "Chevy17"); // Aquí debes colocar la URL de tu base de datos, usuario y contraseña
            System.out.println("Conexión exitosa a la base de datos!!!");

            //Crear un objeto Statement para ejecutar consultas SQL
            myStatement = myConnection.createStatement(); // Crear un objeto Statement para ejecutar consultas SQL
            myResultSet = myStatement.executeQuery("SELECT * FROM employees"); // Ejecutar una consulta SQL para obtener datos de la tabla "employees"

            //Procesar los resultados de la consulta
            while(myResultSet.next()) {
                System.out.println(myResultSet.getString("first_name"));// Imprimir el valor de la columna "first_name" de cada fila
                System.out.println();
            }
        } catch (Exception e){
            e.printStackTrace();
            System.out.println("Error al conectarse a la base de datos :( ");
        }

    }
}