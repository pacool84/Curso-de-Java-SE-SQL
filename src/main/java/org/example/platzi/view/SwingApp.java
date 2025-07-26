package org.example.platzi.view;

import org.example.platzi.model.Employee;
import org.example.platzi.repository.EmployeeRepository;
import org.example.platzi.repository.Repository;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.SQLException;
import java.util.List;

public class SwingApp extends JFrame {
    private final Repository<Employee> employeeRepository; // Repository to manage Employee data
    private final JTable employeeTable; // Table to display Employee data

    public SwingApp() {
        //Configurar la ventana principal
        setTitle("Gestion de Empleados");
        setDefaultCloseOperation(JFrame.exitOnClose); // Close the application when the window is closed
        setSize(800, 600); // Set the size of the window

        //Crear una tabla para mostrar los empleados
        employeeTable = new JTable();// Initialize the JTable to display Employee data
        JSscrollPane scrollPane = new JScrollPane(employeeTable); // Add a scroll pane to the table for better visibility
        add(scrollPane, BorderLayout.CENTER);

        //Crear botones para acciones
        JButton agregarButton = new JButton("Agregar -");
        JButton actualizarButton = new JButton("Actualizar -");
        JButton eliminarButton = new JButton("Eliminar -");

        // Configurar el panel de botones
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(agregarButton);
        buttonPanel.add(actualizarButton);
        buttonPanel.add(eliminarButton);
        add(buttonPanel, BorderLayout.SOUTH); // Add the button panel to the bottom of the window

        //Establecer estilos para los botones
        agregarButton.setBackground(new Color(46, 204, 113));
        agregarButton.setForeground(Color.WHITE);
        agregarButton.setFocusPainted(false);

        actualizarButton.setBackground(new Color(52, 152, 219));
        actualizarButton.setForeground(Color.WHITE);
        actualizarButton.setFocusPainted(false);

        eliminarButton.setBackground(new Color(231, 76, 60));
        eliminarButton.setForeground(Color.WHITE);
        eliminarButton.setFocusPainted(false);

        //Crear el objeto Repository para acceder a la base de datos
        employeeRepository = new EmployeeRepository(); // Initialize the EmployeeRepository to manage Employee data

        //Cargar los empleados iniciales de la tabla
        refreshEmployeeTable(); // Call the method to refresh the Employee table data

        //Agregar ActionListener para los botones
        agregarButton.addActionListener( e -> {
            try{
                agregarEmpleado();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        });

        actualizarButton.addActionListener(e -> actualizarEmpleado());

        eliminarButton.addActionListener(e -> eliminarEmpleado());

        //Method to refresh the Employee table data
        private void refreshEmployeeTable() {
            //Obtener la lista actualizada de empleados desde la base de datos
            try {
                List<Employee> employees = employeeRepository.findAll(); // Fetch all Employees from the repository

                //Crear un modelo de tabla y establecer los datos de los empleados
                DefaultTableModel model = new DefaultTableModel();
                model.addColumn("ID");
                model.addColumn("Nombre");
                model.addColumn("Apellido Paterno");
                model.addColumn("Apellido Materno");
                model.addColumn("Email");
                model.addColumn("Salario");

                for (Employee employee : employees) {
                    Object[] rowData = {
                            employee.getId();
                    employee.getFirst_name();
                    employee.getPa_surname();
                    employee.getMa_surname();
                    employee.getEmail();
                    employee.getSalary();
                };
                    model.addRow(rowData); // Add each Employee's data as a row in the table model
                }
                //Establecer el modelo de tabla actualizado
                employee.setModel(model); // Set the updated table model to the JTable
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Error al obtener los empleados de la base de datos", "Error, JOptionPane.ERROR_MESSAGE");
            }
        }
    }
}
