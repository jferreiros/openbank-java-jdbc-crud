package com.openbank.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


import java.sql.*;
import java.util.*;
import com.openbank.utils.*;

import com.openbank.model.Transferencia;

public class DBTransferencia {

    Connection connection;

    public DBTransferencia() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/banco", "root", "Valencia9562??");
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public void insertTransferencia(Transferencia transferencia) {

        try {
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO transferencia(id_ordenante, id_beneficiario, importe, concepto, fecha) VALUES (?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, transferencia.getId_ordenante());
            statement.setInt(2, transferencia.getId_beneficiairo());
            statement.setFloat(3, transferencia.getImporte());
            statement.setString(4, transferencia.getConcepto());
            statement.setDate(5, transferencia.getFecha());

            int affectedRows = statement.executeUpdate();

            if(affectedRows > 0) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    transferencia.setId(generatedKeys.getInt(1));
                }
                else {
                    throw new SQLException("Creating transferencia failed, no ID obtained.");
                }
            }

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public void getTransferencia(int id) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM transferencia WHERE id=?");
            statement.setInt(1, id);
            ResultSet results = statement.executeQuery();
            ArrayList<Transferencia> transferencia = new ArrayList<Transferencia>();

            while (results.next()) {
                transferencia.add(new Transferencia(
                        results.getInt("id"),
                        results.getInt("id_ordenante"),
                        results.getInt("id_beneficiario"),
                        results.getFloat("importe"),
                        results.getString("concepto"),
                        results.getDate("fecha")));
            }
            Console.log(transferencia.toString());
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public void getTransferencias() {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM transferencia");
            ResultSet results = statement.executeQuery();
            ArrayList<Transferencia> transferencia = new ArrayList<Transferencia>();

            while (results.next()) {
                transferencia.add(new Transferencia(
                    results.getInt("id"),
                    results.getInt("id_ordenante"),
                    results.getInt("id_beneficiario"),
                    results.getFloat("importe"),
                    results.getString("concepto"),
                    results.getDate("fecha")));
            }
            Console.log(transferencia.toString());
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public void deleteTransferencia(int id) {
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM transferencia WHERE id=?");
            statement.setInt(1, id);
            statement.executeUpdate();

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
    
}
