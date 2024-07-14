package com.example.ticketssystems.enums;

public enum TicketStatus {
    OPEN("Open"),
    CLOSED("Closed");

    private final String status;

    TicketStatus(String status){
        this.status = status;
    }

}
