package digit.web.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.egov.common.contract.models.AuditDetails;

import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class Advocate {

    private UUID id;

    @NotBlank
    @Size(min =2, max =128)
    private String tenantId;

    @Size(min = 2, max = 64)
    private String applicationNumber;

    @NotBlank
    @Size(min = 2, max = 64)
    private String barRegistrationNumber;

    @NotBlank
    @Size(min =2, max =64)
    private String advocateType;

    @NotNull
    private UUID organisationID;

    @NotBlank
    private String individualId;

    private boolean isActive = true;


}
