package com.example.ticketssystems.domains.dto;

import com.example.ticketssystems.domains.TicketComments;
import com.example.ticketssystems.enums.TicketCategory;
import com.example.ticketssystems.enums.TicketStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TicketDTO {
    private Long id;
    private TicketCategory category;
    private TicketStatus status;
    private List<TicketComments> ticketComments;
}
