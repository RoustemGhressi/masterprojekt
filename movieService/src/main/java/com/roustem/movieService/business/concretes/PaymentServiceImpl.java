package com.roustem.movieService.business.concretes;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.roustem.movieService.business.abstracts.PaymentService;
import com.roustem.movieService.entity.dto.EmailMessageKafkaDto;
import com.roustem.movieService.entity.dto.TicketInformationDto;
import com.roustem.movieService.kafka.KafkaProducer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final KafkaProducer kafkaProducer;

    @Override
    public void sendTicketDetail(TicketInformationDto ticketInformationDto) {

        EmailMessageKafkaDto emailMessage = EmailMessageKafkaDto.builder()
                .sender("roustem12345@gmail.com")
                .recipient(ticketInformationDto.getEmail())
                .subtitle("CineVision Ticket details")
                .fullName(ticketInformationDto.getFullName())
                .movieName(ticketInformationDto.getMovieName())
                .movieDay(ticketInformationDto.getMovieDay())
                .movieStartTime(ticketInformationDto.getMovieStartTime())
                .saloonName(ticketInformationDto.getSaloonName())
                .chairNumbers(ticketInformationDto.getChairNumbers())
                .build();

        log.info("Built emailMessageKafkaDto: {}", emailMessage);

        try {
                
            kafkaProducer.sendMessage(emailMessage);
            log.info("Kafka message sent successfully");
        } catch (Exception e) {
            log.error("Error sending message to Kafka", e);
            throw e;
                }
    }
}
