package com.example.ticketssystems.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.ticketssystems.domains.TicketEntity;

@Repository
public interface TicketRepository extends CrudRepository<TicketEntity, Long> {
}
