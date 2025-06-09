package digit.repository.rowmapper;

import digit.web.models.Advocate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class AdvocateRowMapper implements RowMapper<Advocate> {

    @Override
    public Advocate mapRow(ResultSet rs, int rowNum) throws SQLException {
        Advocate advocate = new Advocate();
        advocate.setId(UUID.fromString(rs.getString("id")));
        advocate.setTenantId(rs.getString("tenant_id"));
        advocate.setApplicationNumber(rs.getString("application_number"));
        advocate.setBarRegistrationNumber(rs.getString("bar_registration_number"));
        advocate.setAdvocateType(rs.getString("advocate_type"));
        advocate.setOrganisationID(UUID.fromString(rs.getString("organisation_id")));
        advocate.setIndividualId(rs.getString("individual_id"));
        advocate.setActive(rs.getBoolean("is_active"));
        return advocate;
    }
}
