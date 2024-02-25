package com.example.ecommerce.repository;

import com.example.ecommerce.conexao.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemRepository {

    public int obterQuantidadeItem(Long idItem) {
        try (Connection connection = DatabaseConnection.getDataSource().getConnection()) {
            PreparedStatement prepareStatement = connection.prepareStatement("SELECT quantidade FROM estoque WHERE id_item = ?");
            prepareStatement.setLong(1, idItem);

            ResultSet resultSet = prepareStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt("quantidade");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }
}