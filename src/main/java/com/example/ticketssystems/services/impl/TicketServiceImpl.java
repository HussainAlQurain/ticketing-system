package com.example.ticketssystems.services.impl;

import com.example.ticketssystems.domains.TicketEntity;
import com.example.ticketssystems.repositories.TicketRepository;
import com.example.ticketssystems.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class TicketServiceImpl implements TicketService {
    private final TicketRepository ticketRepository;


    public TicketServiceImpl(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @Override
    public TicketEntity save(TicketEntity ticketEntity) {
        return ticketRepository.save(ticketEntity);
    }

    @Override
    public List<TicketEntity> findAll() {
        return StreamSupport.stream(ticketRepository.findAll().spliterator(), true).collect(Collectors.toList());
    }

    @Override
    public Optional<TicketEntity> findOne(Long id) {
        return ticketRepository.findById(id);
    }

    @Override
    public TicketEntity partialUpdate(Long id, TicketEntity ticketEntity) {
        ticketEntity.setId(id);
        return ticketRepository.findById(id).map(existingTicket -> {
            Optional.ofNullable(ticketEntity.getCategory()).ifPresent(existingTicket::setCategory);
            Optional.ofNullable(ticketEntity.getStatus()).ifPresent(existingTicket::setStatus);
            Optional.ofNullable(ticketEntity.getTicketComments()).ifPresent(existingTicket::setTicketComments);
            return ticketRepository.save(existingTicket);
        }).orElseThrow(() -> new RuntimeException("Ticket does not exist"));
    }
    @Override
    public boolean isExists(Long id) {
        return ticketRepository.existsById(id);
    }
}
