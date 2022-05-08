package com.openbank.database;

import java.sql.*;
import java.util.*;
import com.openbank.model.Gestor;
import com.openbank.utils.*;

public class DBGestor {

    Connection connection;

    public DBGestor() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/banco", "root", "Valencia9562??");
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public void insertGestor(Gestor gestor) {

        try {
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO gestor(usuario, password, correo) VALUES (?,?,?)", Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, gestor.getUsuario());
            statement.setString(2, gestor.getPassword());
            statement.setString(3, gestor.getCorreo());

            int affectedRows = statement.executeUpdate();

            if(affectedRows > 0) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    gestor.setId(generatedKeys.getInt(1));
                }
                else {
                    throw new SQLException("Creating cliente failed, no ID obtained.");
                }
            }

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public void updateGestor(Gestor gestor) {
        try {
            PreparedStatement statement = connection
                    .prepareStatement("UPDATE gestor SET usuario=?, password=?, correo=? WHERE id=?");
            statement.setString(1, gestor.getUsuario());
            statement.setString(2, gestor.getPassword());
            statement.setString(3, gestor.getCorreo());
            statement.setLong(4, gestor.getId());
            statement.execute();

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public void getGestor(int id) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM gestor WHERE id=?");
            statement.setInt(4, id);
            ResultSet results = statement.executeQuery();
            ArrayList<Gestor> gestores = new ArrayList<Gestor>();

            while (results.next()) {
                gestores.add(new Gestor(
                        results.getInt("id"),
                        results.getString("usuario"),
                        results.getString("password"),
                        results.getString("correo")));
            }
            Console.log(gestores.toString());
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public void getGestores() {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM gestor");
            ResultSet results = statement.executeQuery();
            ArrayList<Gestor> gestores = new ArrayList<Gestor>();

            while (results.next()) {
                gestores.add(new Gestor(
                        results.getInt("id"),
                        results.getString("usuario"),
                        results.getString("password"),
                        results.getString("correo")));
            }
            Console.log(gestores.toString());
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public void deleteGestor(int id) {
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM gestor WHERE id=?");
            statement.setInt(1, id);
            statement.executeUpdate();

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
    
}
