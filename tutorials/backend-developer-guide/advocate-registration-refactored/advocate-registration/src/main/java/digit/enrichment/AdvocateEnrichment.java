package digit.enrichment;

import digit.service.AdvocateService;
import digit.util.IdgenUtil;
import digit.web.models.AdvocateRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.egov.common.contract.request.RequestInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class AdvocateEnrichment {

    private static final Logger log = LoggerFactory.getLogger(AdvocateEnrichment.class);
    private final IdgenUtil idgenUtil;
    public void enrichAdvocateRegistration(AdvocateRequest advocateRequest) {
        log.info("Enriching advocate registration request...");

        List<String> applicationIdList = idgenUtil.getIdList(new RequestInfo(),advocateRequest.getTenantId(),"advocate.case.id","",1);
        String id = UUID.randomUUID().toString();

        advocateRequest.setId(id);
        advocateRequest.setApplicationNumber(applicationIdList.get(0));
        log.info("Generated Application Number: {}","APN-" + id );

        advocateRequest.setCreatedTime(Instant.now().toEpochMilli());
        advocateRequest.setLastModifiedTime(Instant.now().toEpochMilli());

        if(advocateRequest.getCreatedBy() == null) {
            advocateRequest.setCreatedBy("system");
            advocateRequest.setLastModifiedBy("system");
        }
        advocateRequest.setIsActive(false);

        log.info("Advocate registration request enriched successfully.");

    }

    public void enrichAdvocateUpdate(AdvocateRequest advocateRequest) {
        log.info("Enriching advocate update request...");

        advocateRequest.setLastModifiedTime(Instant.now().toEpochMilli());

        if(advocateRequest.getCreatedBy() == null) {
            advocateRequest.setLastModifiedBy("admin");
        }


        log.info("Advocate update request enriched successfully.");
    }


}
