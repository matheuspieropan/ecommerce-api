package com.example.ecommerce.repository;

import com.example.ecommerce.conexao.DatabaseConnection;
import com.example.ecommerce.dto.CompraRequest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CompraRepository {

    public void realizarCompra(CompraRequest compraRequest) {
        try (Connection connection = DatabaseConnection.getDataSource().getConnection()) {

            PreparedStatement prepareStatement = connection.prepareStatement("update estoque set quantidade = quantidade - ? WHERE id_item = ?");
            prepareStatement.setInt(1, compraRequest.getQuantidade());
            prepareStatement.setLong(2, compraRequest.getIdItem());

            prepareStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}