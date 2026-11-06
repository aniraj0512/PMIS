package com.example.quickrelief;

public record SupplyRequest(
        String itemName,
        int quantity,
        String requestedBy
) {
}