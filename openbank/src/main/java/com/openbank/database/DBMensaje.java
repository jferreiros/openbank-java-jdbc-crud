package com.openbank.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.openbank.model.Mensaje;
import com.openbank.utils.Console;

public class DBMensaje {

    Connection connection;

    public DBMensaje() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/banco", "root", "Valencia9562??");
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public void insertMensaje(Mensaje mensaje) {

        try {
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO mensaje(id_origen, id_destino, texto, fecha) VALUES (?,?,?,?)");
            statement.setInt(1, mensaje.getId_origen());
            statement.setInt(2, mensaje.getId_destino());
            statement.setString(3, mensaje.getTexto());
            statement.setDate(4, mensaje.getFecha());

            int affectedRows = statement.executeUpdate();

            if(affectedRows > 0) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    mensaje.setId(generatedKeys.getInt(1));
                }
                else {
                    throw new SQLException("Creating cliente failed, no ID obtained.");
                }
            }

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public void getMensaje(int id) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM mensaje WHERE id=?");
            statement.setInt(4, id);
            ResultSet results = statement.executeQuery();
            ArrayList<Mensaje> mensajes = new ArrayList<Mensaje>();

            while (results.next()) {
                mensajes.add(new Mensaje(
                        results.getInt("id"),
                        results.getInt("id_origen"),
                        results.getInt("id_destino"),
                        results.getString("texto"),
                        results.getDate("fecha")));
            }
            Console.log(mensajes.toString());
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public void getMensajes() {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM mensaje");
            ResultSet results = statement.executeQuery();
            ArrayList<Mensaje> mensajes = new ArrayList<Mensaje>();

            while (results.next()) {
                mensajes.add(new Mensaje(
                        results.getInt("id"),
                        results.getInt("id_origen"),
                        results.getInt("id_destino"),
                        results.getString("texto"),
                        results.getDate("fecha")));
            }
            Console.log(mensajes.toString());
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public void deleteMensaje(int id) {
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM mensaje WHERE id=?");
            statement.setInt(1, id);
            statement.executeUpdate();

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
    
}