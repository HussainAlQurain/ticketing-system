package com.example.ticketssystems.utils.mapper;

import com.example.ticketssystems.domains.dto.TicketDTO;
import com.example.ticketssystems.domains.TicketEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class TicketMapper implements Mapper<TicketEntity, TicketDTO> {
    private ModelMapper modelMapper;

    public TicketMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public TicketDTO mapTo(TicketEntity ticketEntity) {
        return modelMapper.map(ticketEntity, TicketDTO.class);
    }

    @Override
    public TicketEntity mapFrom(TicketDTO ticketDTO) {
        return modelMapper.map(ticketDTO, TicketEntity.class);
    }
}
