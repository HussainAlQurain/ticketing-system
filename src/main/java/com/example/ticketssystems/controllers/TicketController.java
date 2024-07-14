package com.example.ticketssystems.controllers;

import com.example.ticketssystems.domains.dto.TicketDTO;
import com.example.ticketssystems.domains.TicketEntity;
import com.example.ticketssystems.services.TicketService;
import com.example.ticketssystems.utils.mapper.TicketMapper;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Log
public class TicketController {

    private TicketMapper ticketMapper;
    private TicketService ticketService;

    public TicketController(TicketMapper ticketMapper, TicketService ticketService) {
        this.ticketMapper = ticketMapper;
        this.ticketService = ticketService;
    }

    @PostMapping(path = "/tickets")
    public ResponseEntity<TicketDTO> createTicket(@RequestBody TicketDTO ticketDTO){
        TicketEntity ticketEntity = ticketMapper.mapFrom(ticketDTO);
        TicketEntity savedTicket = ticketService.save(ticketEntity);
        return new ResponseEntity<>(ticketMapper.mapTo(savedTicket), HttpStatus.CREATED);
    }

    @GetMapping(path = "/tickets")
    public List<TicketEntity> listTickets() {
        return ticketService.findAll();
    }

    @GetMapping(path = "/tickets/{id}")
    public ResponseEntity<TicketDTO> getTicket(@PathVariable("id") Long id){
        Optional<TicketEntity> foundTicket = ticketService.findOne(id);
        return foundTicket.map(ticketEntity -> {
            TicketDTO ticketDTO = ticketMapper.mapTo(ticketEntity);
            return new ResponseEntity<>(ticketDTO, HttpStatus.OK);
        }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping(path = "/tickets/{id}")
    public ResponseEntity<TicketDTO> fullUpdateSport(
            @PathVariable("id") Long id,
            @RequestBody TicketDTO ticketDTO){
        if(!ticketService.isExists(id)){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        ticketDTO.setId(id);
        TicketEntity ticketEntity = ticketMapper.mapFrom(ticketDTO);
        TicketEntity savedSportEntity = ticketService.save(ticketEntity);
        return new ResponseEntity<>(ticketMapper.mapTo(savedSportEntity),
                HttpStatus.OK);
    }

    @PatchMapping(path = "/tickets/{id}")
    public ResponseEntity<TicketDTO> partialUpdateSport(
            @PathVariable("id") Long id,
            @RequestBody TicketDTO ticketDTO
    )
    {
        if(!ticketService.isExists(id)){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        TicketEntity ticketEntity = ticketMapper.mapFrom(ticketDTO);
        TicketEntity updatedTicket = ticketService.partialUpdate(id, ticketEntity);

        return new ResponseEntity<>(ticketMapper.mapTo(updatedTicket),
                HttpStatus.OK);
    }
}
