package com.roustem.movieService.business.abstracts;

import com.roustem.movieService.entity.dto.TicketInformationDto;

public interface PaymentService {

    void sendTicketDetail(TicketInformationDto ticketInformationDto);
}
