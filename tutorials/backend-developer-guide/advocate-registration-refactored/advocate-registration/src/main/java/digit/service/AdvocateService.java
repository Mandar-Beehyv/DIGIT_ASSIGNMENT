package digit.service;

import digit.enrichment.AdvocateEnrichment;
import digit.kafka.AdvocateProducer;
import digit.repository.AdvocateRepository;
import digit.validators.AdvocateValidator;
import digit.web.models.*;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AdvocateService {

    private static final Logger log = LoggerFactory.getLogger(AdvocateService.class);
    private final AdvocateProducer advocateProducer;
    private final AdvocateRepository advocateRepository;
    private final AdvocateEnrichment advocateEnrichment;
    private final AdvocateValidator advocateValidator;

    public String createAdvocate(AdvocateRequest advocateRequest){
        advocateValidator.createAdvocateValidator(advocateRequest);

        log.info("Processing advocate registration request...");

        advocateEnrichment.enrichAdvocateRegistration(advocateRequest);

        advocateProducer.sendCreateEvent(advocateRequest);
        log.info("Advocate event sent to Kafka.");

        return "successfully registered Advocate with application number " + advocateRequest.getApplicationNumber() ;
    }


    public String updateAdvocate(AdvocateRequest advocateRequest) {

        advocateValidator.updateAdvocateValidator(advocateRequest);

        log.info("Processing advocate update request...");

        advocateEnrichment.enrichAdvocateUpdate(advocateRequest);
        advocateProducer.sendUpdateEvent(advocateRequest);

        log.info("Advocate update event sent to Kafka.");

        return "successfully updated Advocate";
    }


    public List<Advocate> searchAdvocate(List<AdvocateSearchCriteria> advocateSearchCriteriaList){
        List<Advocate> advocates = new ArrayList<>();
        for(AdvocateSearchCriteria advocateSearchCriteria : advocateSearchCriteriaList ){
            advocates.add(searchAdvocateBySearchCriteria(advocateSearchCriteria));
        }
        return advocates;
    }

    private Advocate searchAdvocateBySearchCriteria(AdvocateSearchCriteria advocateSearchCriteria) {

        if(advocateSearchCriteria.getId()!=null){
            return advocateRepository.getAdvocateById(advocateSearchCriteria.getId());
        }
        else if(advocateSearchCriteria.getApplicationNumber()!=null) {
            return advocateRepository.getAdvocateByApplicationNumber(advocateSearchCriteria.getApplicationNumber());
        }
        else if(advocateSearchCriteria.getBarRegistrationNumber()!=null){
            return advocateRepository.getAdvocateByBarRegistrationNumber(advocateSearchCriteria.getBarRegistrationNumber());
        }
        else{
            throw new IllegalArgumentException("All fields can not be null");
        }

    }
}
