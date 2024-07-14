package com.example.ticketssystems.enums;


public enum TicketCategory {
    CRITICAL("Critical"),
    HIGH("High"),
    MEDIUM("Medium"),
    LOW("Description");

    private final String description;

    TicketCategory(String description) {
        this.description = description;
    }

}
