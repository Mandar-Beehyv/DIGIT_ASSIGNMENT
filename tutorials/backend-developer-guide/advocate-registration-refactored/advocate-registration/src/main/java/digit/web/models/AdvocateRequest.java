package digit.web.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class AdvocateRequest {

    @JsonProperty("id")
    private String id;

    @JsonProperty("tenantId")
    private String tenantId;

    @JsonProperty("applicationNumber")
    private String applicationNumber;

    @JsonProperty("barRegistrationNumber")
    private String barRegistrationNumber;

    @JsonProperty("advocateType")
    private String advocateType;

    @JsonProperty("individualId")
    private String individualId;

    @JsonProperty("organisationId")
    private String organisationId;

    @JsonProperty("isActive")
    private Boolean isActive;

    @JsonProperty("createdBy")
    private String createdBy;

    @JsonProperty("createdTime")
    private Long createdTime;

    @JsonProperty("lastModifiedBy")
    private String lastModifiedBy;

    @JsonProperty("lastModifiedTime")
    private Long lastModifiedTime;


}
