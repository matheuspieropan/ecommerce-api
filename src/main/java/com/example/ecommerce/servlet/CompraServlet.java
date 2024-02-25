package com.example.ecommerce.servlet;

import com.example.ecommerce.dto.CompraRequest;
import com.example.ecommerce.repository.CompraRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/compra/*")
public class CompraServlet extends HttpServlet {

    private final ObjectMapper objectMapper = new ObjectMapper();

    private final CompraRepository compraRepository = new CompraRepository();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        try (BufferedReader bufferedReader = new BufferedReader(request.getReader())) {
            StringBuilder json = new StringBuilder();
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                json.append(line);
            }

            CompraRequest compraRequest = objectMapper.readValue(json.toString(), CompraRequest.class);
            compraRepository.realizarCompra(compraRequest.getIdItem(), compraRequest.getQuantidade());
        }
    }
}