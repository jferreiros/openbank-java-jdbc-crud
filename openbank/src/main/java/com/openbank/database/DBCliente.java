package com.openbank.database;

import com.openbank.model.Cliente;
import java.sql.*;
import java.util.*;
import com.openbank.utils.*;

public class DBCliente {

    Connection connection;

    public DBCliente() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://uhrcja8gdyt99akt:zUYalrZHMAG08E9lrFc4@b5sgogoij9blju0wicti-mysql.services.clever-cloud.com:3306/b5sgogoij9blju0wicti", "uhrcja8gdyt99akt", "zUYalrZHMAG08E9lrFc4");
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public void insertCliente(Cliente cliente) {

        try {
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO cliente(id_gestor, usuario, password, correo, saldo) VALUES (?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            statement.setLong(1, cliente.getId_gestor());
            statement.setString(2, cliente.getUsuario());
            statement.setString(3, cliente.getPassword());
            statement.setString(4, cliente.getCorreo());
            statement.setDouble(5, cliente.getSaldo());

            int affectedRows = statement.executeUpdate();

            if(affectedRows > 0) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    cliente.setId(generatedKeys.getLong(1));
                }
                else {
                    throw new SQLException("Creating cliente failed, no ID obtained.");
                }
            }

            

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public void updateCliente(Cliente cliente) {
        try {
            PreparedStatement statement = connection
                    .prepareStatement("UPDATE cliente SET usuario=?, password=?, correo=?, saldo=? WHERE id=?");
            statement.setString(1, cliente.getUsuario());
            statement.setString(2, cliente.getPassword());
            statement.setString(3, cliente.getCorreo());
            statement.setDouble(4, cliente.getSaldo());
            statement.setLong(5, cliente.getId());
            statement.execute();

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public void getCliente(int id) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM cliente WHERE id=?");
            statement.setInt(1, id);
            ResultSet results = statement.executeQuery();
            ArrayList<Cliente> client = new ArrayList<Cliente>();

            while (results.next()) {
                client.add(new Cliente(
                        results.getLong("id"),
                        results.getLong("id_gestor"),
                        results.getString("usuario"),
                        results.getString("password"),
                        results.getString("correo"),
                        results.getDouble("saldo")));
            }
            Console.log(client.toString());
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public void getClientes() {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM cliente");
            ResultSet results = statement.executeQuery();
            ArrayList<Cliente> clients = new ArrayList<Cliente>();

            while (results.next()) {
                clients.add(new Cliente(
                        results.getLong("id"),
                        results.getLong("id_gestor"),
                        results.getString("usuario"),
                        results.getString("password"),
                        results.getString("correo"),
                        results.getDouble("saldo")));
            }
            Console.log(clients.toString());
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public void deleteCliente(int id) {
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM cliente WHERE id=?");
            statement.setInt(1, id);
            statement.executeUpdate();

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

}
