package com.example.quickr;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.List;

@Service
public class SupplyService {

    private final JdbcTemplate jdbc;

    public SupplyService(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public void addSupply(String name, int quantity) {
        if (name == null || name.isBlank() || quantity <= 0) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Invalid supply details");
        }

        int count = jdbc.update(
                "UPDATE supplies SET quantity = quantity + ? " +
                        "WHERE item_name = ?", quantity, name);

        if (count == 0) {
            jdbc.update(
                    "INSERT INTO supplies(item_name, quantity) VALUES (?, ?)",
                    name, quantity);
        }
    }

    public List<Supply> getSupplies() {
        return jdbc.query(
                "SELECT * FROM supplies",
                (rs, rowNum) -> new Supply(
                        rs.getInt("id"),
                        rs.getString("item_name"),
                        rs.getInt("quantity")
                )
        );
    }

    @Transactional
    public void requestSupply(SupplyRequest request) {
        if (request.itemName() == null || request.itemName().isBlank()
                || request.requestedBy() == null
                || request.requestedBy().isBlank()
                || request.quantity() <= 0) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Invalid request details");
        }

        int updated = jdbc.update(
                "UPDATE supplies SET quantity = quantity - ? " +
                        "WHERE item_name = ? AND quantity >= ?",
                request.quantity(),
                request.itemName(),
                request.quantity());

        if (updated == 0) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Supply not found or insufficient stock");
        }

        jdbc.update(
                "INSERT INTO requests(item_name, quantity, status, requested_by) " +
                        "VALUES (?, ?, ?, ?)",
                request.itemName(),
                request.quantity(),
                "APPROVED",
                request.requestedBy());
    }
}