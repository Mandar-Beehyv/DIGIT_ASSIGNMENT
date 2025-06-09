package digit.repository.querybuilder;

public class AdvocateQueryBuilder {

    public static final String ADVOCATE_BY_ID = "SELECT * FROM eg_advocate_registration WHERE id = ?";
    public static final String ADVOCATE_BY_APPLICATION_NUMBER = "SELECT * FROM eg_advocate_registration WHERE application_number = ?";
    public static final String ADVOCATE_BY_BAR_REGISTRATION_NUMBER = "SELECT * FROM eg_advocate_registration WHERE bar_registration_number = ?";
    public static final String IF_EXIST_BY_ID = "SELECT COUNT(*) FROM eg_advocate_registration WHERE id = ?";

}
