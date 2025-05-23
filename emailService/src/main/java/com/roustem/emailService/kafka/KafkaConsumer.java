package com.roustem.emailService.kafka;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.roustem.emailService.business.abstracts.EmailService;
import com.roustem.emailService.dto.EmailMessageKafkaDto;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class KafkaConsumer {

    private final EmailService emailService;

    @KafkaListener(topics = "${spring.kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(EmailMessageKafkaDto emailMessageKafkaDto){
        
        Map<String, String> model = new HashMap<>();
        model.put("fullName", emailMessageKafkaDto.getFullName());
        model.put("movieName", emailMessageKafkaDto.getMovieName());
        model.put("movieDay", emailMessageKafkaDto.getMovieDay());
        model.put("saloonName", emailMessageKafkaDto.getSaloonName());
        model.put("movieStartTime", emailMessageKafkaDto.getMovieStartTime());
        model.put("chairNumbers", emailMessageKafkaDto.getChairNumbers());

        emailService.sendEmail(emailMessageKafkaDto.getSender(), emailMessageKafkaDto.getRecipient(), emailMessageKafkaDto.getSubtitle(), model);
    }
}
