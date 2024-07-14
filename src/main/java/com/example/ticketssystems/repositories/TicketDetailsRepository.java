package com.example.ticketssystems.repositories;

import com.example.ticketssystems.domains.TicketComments;
import org.springframework.data.repository.CrudRepository;

public interface TicketDetailsRepository extends CrudRepository<TicketComments, Long> {
}
