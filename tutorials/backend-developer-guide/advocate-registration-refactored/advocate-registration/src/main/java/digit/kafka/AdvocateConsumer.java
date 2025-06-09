package digit.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import digit.repository.AdvocateRepository;
import digit.web.models.AdvocateRequest;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class AdvocateConsumer {

    //    private static final Logger log = LoggerFactory.getLogger(AdvocateConsumer.class);
//
//    private final AdvocateRepository advocateRepository;
//    private final ObjectMapper objectMapper; // ObjectMapper to convert HashMap to AdvocateRequest
//
//    @KafkaListener(topics = "save-advocate-application", groupId = "advocate-group")
//    public void processAdvocateRegistration(Object advocateData, Acknowledgment acknowledgment) {
//        if (advocateData == null) {
//            log.warn("Received null advocate registration event from Kafka. Skipping processing.");
//            return;
//        }
//
//        try {
//            // Check if the payload is a Map and convert it to AdvocateRequest
//            if (advocateData instanceof Map) {
//                AdvocateRequest advocateRequest = objectMapper.convertValue(advocateData, AdvocateRequest.class);
//                log.info("Received advocate registration event: {}", advocateRequest);
//
//                // Save the advocate details
//                advocateRepository.saveAdvocate(advocateRequest);
//                log.info("Advocate registration persisted successfully.");
//
//                // Manually acknowledge the Kafka message after successful processing
//                acknowledgment.acknowledge();
//            } else {
//                log.error("Unexpected message format: {}", advocateData.getClass().getName());
//            }
//        } catch (Exception e) {
//            log.error("Error processing advocate registration event: {}", advocateData, e);
//            // Do not acknowledge to let Kafka retry
//        }
//    }

}
