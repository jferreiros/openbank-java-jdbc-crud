package com.openbank.database;

import java.sql.*;
import java.util.*;
import com.openbank.utils.*;

import com.openbank.model.Prestamo;

public class DBPrestamo {

    Connection connection;

    public DBPrestamo() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/banco", "root", "Valencia9562??");
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public void insertPrestamo(Prestamo prestamo) {

        try {
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO prestamo(nombre, comision, meses) VALUES (?,?,?)", Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, prestamo.getNombre());
            statement.setLong(2, prestamo.getComision());
            statement.setInt(3, prestamo.getMeses());

            int affectedRows = statement.executeUpdate();

            if(affectedRows > 0) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    prestamo.setId(generatedKeys.getInt(1));
                }
                else {
                    throw new SQLException("Creating prestamo failed, no ID obtained.");
                }
            }

            

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public void updatePrestamo(Prestamo prestamo) {
        try {
            PreparedStatement statement = connection
                    .prepareStatement("UPDATE prestamo SET nombre=?, comision=?, meses=? WHERE id=?");
            statement.setString(1, prestamo.getNombre());
            statement.setLong(2, prestamo.getComision());
            statement.setInt(3, prestamo.getMeses());
            statement.setLong(4, prestamo.getId());
            statement.execute();

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public void getPrestamo(int id) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM prestamo WHERE id=?");
            statement.setInt(1, id);
            ResultSet results = statement.executeQuery();
            ArrayList<Prestamo> prestamo = new ArrayList<Prestamo>();

            while (results.next()) {
                prestamo.add(new Prestamo(
                        results.getInt("id"),
                        results.getString("nombre"),
                        results.getLong("comision"),
                        results.getInt("meses")));
            }
            Console.log(prestamo.toString());
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public void getPrestamos() {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM prestamo");
            ResultSet results = statement.executeQuery();
            ArrayList<Prestamo> prestamo = new ArrayList<Prestamo>();

            while (results.next()) {
                prestamo.add(new Prestamo(
                    results.getInt("id"),
                    results.getString("nombre"),
                    results.getLong("comision"),
                    results.getInt("meses")));
            }
            Console.log(prestamo.toString());
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public void deletePrestamo(int id) {
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM prestamo WHERE id=?");
            statement.setInt(1, id);
            statement.executeUpdate();

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
    
}
