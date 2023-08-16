package com.example.checkout;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;

@Slf4j
@Service
@RequiredArgsConstructor
public class SaveService {

    private static final String CHECKOUT_COMPLETET_TOPIC_NAME = "checkout.complete.v1";
    private final CheckOutRepository checkOutRepository;
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ModelMapper modelMapper = new ModelMapper();
    private final ObjectMapper objectMapper = new ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    public Long saveCheckOutData(CheckOutDto checkOutDto) {
        CheckOutEntity checkOutEntity = saveDatabase(checkOutDto);
        checkOutDto.setCheckOutId(checkOutEntity.getCheckOutId());
        checkOutDto.setCreatedAt(new Date(checkOutEntity.getCreatedAt().getTime()));
        sendToKafka(checkOutDto);

        return checkOutEntity.getCheckOutId();
    }

    private void sendToKafka(CheckOutDto checkOutDto) {
        try {
            String jsonInString = objectMapper.writeValueAsString(checkOutDto);
            kafkaTemplate.send(CHECKOUT_COMPLETET_TOPIC_NAME, jsonInString);
            log.info("success sendToKafka");
        } catch (Exception e) {
            log.error("sendToKafka", e);
        }
    }

    private CheckOutEntity saveDatabase(CheckOutDto checkOutDto) {
        CheckOutEntity checkOutEntity = modelMapper.map(checkOutDto, CheckOutEntity.class);

        return checkOutRepository.save(checkOutEntity);
    }

}
