package digit.repository;

import digit.repository.querybuilder.AdvocateQueryBuilder;
import digit.repository.rowmapper.AdvocateRowMapper;
import digit.web.models.Advocate;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class AdvocateRepository {

    private final JdbcTemplate jdbcTemplate;
    private final AdvocateRowMapper advocateRowMapper = new AdvocateRowMapper();

    public Advocate getAdvocateById(String id) {
        return jdbcTemplate.query(AdvocateQueryBuilder.ADVOCATE_BY_ID, advocateRowMapper, id)
                .stream().findFirst().orElse(null);
    }

    public Advocate getAdvocateByApplicationNumber(String applicationNumber) {
        return jdbcTemplate.query(AdvocateQueryBuilder.ADVOCATE_BY_APPLICATION_NUMBER, advocateRowMapper, applicationNumber)
                .stream().findFirst().orElse(null);
    }

    public Advocate getAdvocateByBarRegistrationNumber(String barRegistrationNumber) {
        return jdbcTemplate.query(AdvocateQueryBuilder.ADVOCATE_BY_BAR_REGISTRATION_NUMBER, advocateRowMapper, barRegistrationNumber)
                .stream().findFirst().orElse(null);
    }

    public boolean ifExistById(String id) {
        Integer count = jdbcTemplate.queryForObject(AdvocateQueryBuilder.IF_EXIST_BY_ID, Integer.class, id);
        return count != null && count > 0;
    }
}
