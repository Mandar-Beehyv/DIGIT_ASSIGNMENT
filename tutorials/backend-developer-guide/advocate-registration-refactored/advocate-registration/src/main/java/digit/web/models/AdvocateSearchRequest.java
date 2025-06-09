package digit.web.models;

import lombok.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.Valid;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class AdvocateSearchRequest {

    @Valid
    private RequestInfo requestInfo;

    @Valid
    private List<AdvocateSearchCriteria> criteria;
}
