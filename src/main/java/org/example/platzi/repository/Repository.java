package org.example.platzi.repository;

import java.sql.SQLException;
import java.util.List;

public interface Repository <T> {
    //Metodo generico para ser implementado por varias clases
    List<T> findAll() throws SQLException; // Método para obtener todos los registros de la base de datos
    T getById(Integer id) throws SQLException; // Método para obtener un registro por su ID
    void save(T t); // Método para guardar un registro en la base de datos INSERT o UPDATE
    void delete(Integer id); // Método para eliminar un registro por su ID
}
