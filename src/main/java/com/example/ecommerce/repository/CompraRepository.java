package com.example.ecommerce.repository;

import com.example.ecommerce.conexao.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CompraRepository {

    public void realizarCompra(Long idItem, int quantidadeRequerida) {
        try (Connection connection = DatabaseConnection.getDataSource().getConnection()) {

            PreparedStatement prepareStatement = connection.prepareStatement("SELECT quantidade FROM estoque WHERE id_item = ?");
            prepareStatement.setLong(1, idItem);
            ResultSet resultSet = prepareStatement.executeQuery();

            if (resultSet.next()) {
                int quantidade = resultSet.getInt("quantidade");
                if (quantidade > 0) {

                    String updateQuery = "update estoque set quantidade = ? WHERE id_item = ?";

                    try (PreparedStatement updateStatement = connection.prepareStatement(updateQuery)) {
                        updateStatement.setInt(1, (quantidade - quantidadeRequerida));
                        updateStatement.setLong(2, idItem);

                        updateStatement.executeUpdate();
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}