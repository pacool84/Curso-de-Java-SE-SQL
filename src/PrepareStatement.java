import java.sql.*;

public class PrepareStatement {
    public static void main(String[] args) {
        // Se declaran las variables-componentes de la conexión a la base de datos
        Connection myConnection = null;
        //Statement  myStatement = null; //Permite ejecutar consultas SQL simples y estáticas
        PreparedStatement myPreparedStatement = null; // Mayor eficiencia al ejecutar consultas SQL repetitivas y por que vamos a hacer inserciones
        ResultSet myResultSet = null;


        // Realizar la conexión a la base de datos
        try {
            myConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "Chevy17");
            System.out.println("Conexión exitosa a la base de datos!!!");

            // Crear un objeto Statement para ejecutar consultas SQL
            //myStatement = myConnection.createStatement();
            String sqlQuery = "INSERT INTO employees (first_name, pa_surname) VALUES (?, ?)"; // Consulta SQL con parámetros
            myPreparedStatement = myConnection.prepareStatement(sqlQuery); // Crear un objeto PrepareStatement para ejecutar consultas SQL con parámetros
            myPreparedStatement.setString(1, "Johana"); // Establecer el valor del primer parámetro
            myPreparedStatement.setString(2, "Dorantes"); // Establecer el valor del segundo parámetro

            // Ejecutar una consulta SQL para obtener datos de la tabla "employees"
            //myResultSet = myStatement.executeQuery("SELECT * FROM employees");
            int rowsAffected = myPreparedStatement.executeUpdate(); // Ejecutar la consulta de inserción

            // Procesar los resultados de la consulta
//            while(myResultSet.next() ) {
//                // Imprimir el valor de la columna "first_name" de cada fila
//                System.out.println(myResultSet.getString("first_name"));
//            }

            if (rowsAffected > 0) {
                System.out.println("Se a creado un nuevo empleado con éxito!!!");
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al conectarse a la base de datos :( ");
        }
    }
}
