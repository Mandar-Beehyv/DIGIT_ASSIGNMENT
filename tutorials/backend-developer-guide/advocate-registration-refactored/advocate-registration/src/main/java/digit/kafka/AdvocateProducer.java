package digit.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import digit.web.models.AdvocateRequest;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AdvocateProducer {

    private static final Logger log = LoggerFactory.getLogger(AdvocateProducer.class);
    private final ObjectMapper objectMapper;
    private final KafkaTemplate<String,  Object> kafkaTemplate;


    public void sendCreateEvent(AdvocateRequest advocateRequest) {
        log.info("Sending advocate registration event to Kafka...");

        try {
            Map<String, Object> advocateMap = objectMapper.convertValue(advocateRequest, HashMap.class);

            kafkaTemplate.send("save-advocate-application", advocateMap).whenComplete((result, throwable) -> {
                if (throwable != null) {
                    log.error("Failed to send advocate event to Kafka", throwable);
                } else {
                    log.info("Successfully sent advocate event to Kafka. Offset: {}", result.getRecordMetadata().offset());
                }
            });

        } catch (Exception e) {
            log.error("Error converting AdvocateRequest to JSON", e);
        }
    }

    public void sendUpdateEvent(AdvocateRequest advocateRequest) {
        log.info("Sending advocate update event to Kafka...");

        try {
            Map<String, Object> advocateMap = objectMapper.convertValue(advocateRequest, HashMap.class);

            kafkaTemplate.send("update-advocate-application", advocateMap).whenComplete((result, throwable) -> {
                if (throwable != null) {
                    log.error("Failed to send advocate update event to Kafka", throwable);
                } else {
                    log.info("Successfully sent advocate update event to Kafka. Offset: {}", result.getRecordMetadata().offset());
                }
            });

        } catch (Exception e) {
            log.error("Error converting AdvocateRequest to JSON", e);
        }

    }
}
