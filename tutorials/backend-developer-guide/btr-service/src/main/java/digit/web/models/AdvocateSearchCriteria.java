package digit.web.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AdvocateSearchCriteria {

    private String tenantId;

    private List<String> id;

    private String name;

    private String status;

    private Integer limit;

    private Integer offset;
}
