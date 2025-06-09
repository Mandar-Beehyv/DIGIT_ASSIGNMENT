package digit.validators;

import digit.repository.AdvocateRepository;
import digit.web.models.AdvocateRequest;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AdvocateValidator {

    public final AdvocateRepository advocateRepository;

    public void createAdvocateValidator(AdvocateRequest advocateRequest) {
        if (advocateRequest == null) {
            throw new IllegalArgumentException("AdvocateRequest cannot be null.");
        }

        if (advocateRequest.getTenantId() == null) {
            throw new IllegalArgumentException("Tenant ID cannot be null");
        }

        if (advocateRequest.getBarRegistrationNumber() == null) {
            throw new IllegalArgumentException("BAR Registration Number cannot be null");
        }

        if (advocateRequest.getAdvocateType() == null) {
            throw new IllegalArgumentException("Advocate Type cannot be null");
        }

        if (advocateRequest.getIndividualId() == null) {
            throw new IllegalArgumentException("Individual Id cannot be null");
        }

        if (advocateRequest.getOrganisationId() == null) {
            throw new IllegalArgumentException("Organisation Id cannot be null");
        }
    }


    public void updateAdvocateValidator(AdvocateRequest advocateRequest) {

        if (advocateRequest == null) {
            throw new IllegalArgumentException("AdvocateRequest cannot be null.");
        }
        if (advocateRequest.getId() == null) {
            throw new IllegalArgumentException("Id cannot be null.");
        }
        if(!isValidUUID(advocateRequest.getId())){
            throw new IllegalArgumentException("Id is not a valid UUID");
        }
        if(!advocateRepository.ifExistById(advocateRequest.getId())){
            throw new IllegalArgumentException("Id does not exist");
        }


    }
    private boolean isValidUUID(String uuid) {
        try {
            UUID.fromString(uuid);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}
