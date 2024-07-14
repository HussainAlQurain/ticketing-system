package com.example.ticketssystems.services;


import com.example.ticketssystems.domains.TicketEntity;
import com.example.ticketssystems.repositories.TicketRepository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;


public interface TicketService {
    TicketEntity save(TicketEntity ticketEntity);
    List<TicketEntity> findAll();
    Optional<TicketEntity> findOne(Long id);
    TicketEntity partialUpdate(Long id, TicketEntity ticketEntity);
    boolean isExists(Long id);
}
