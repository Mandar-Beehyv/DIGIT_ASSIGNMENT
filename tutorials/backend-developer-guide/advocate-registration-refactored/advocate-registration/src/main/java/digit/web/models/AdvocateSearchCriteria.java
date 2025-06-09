package digit.web.models;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AdvocateSearchCriteria {

    private String id;
    private String barRegistrationNumber;
    private String applicationNumber;
}
