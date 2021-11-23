package FormPage;

public class FormLocator {
    private FormData data = new FormData();

    private String id_firstName = "firstName";
    private String id_lastName = "lastName";
    private String id_userMail = "userEmail";
    private String id_gender = "gender-radio-1";
    private String id_userNumber = "userNumber";
    private String id_dateOfBirth = "dateOfBirthInput";
    private String id_subjects = "subjectsInput";
    private String xpath_hobbies = "//*[@id=\"hobbiesWrapper\"]/div[2]//label[contains(text(),'" + data.getHobbies() + "')]";
    private String id_image = "uploadPicture";
    private String id_address = "currentAddress";
    private String id_submitBtn = "submit";
    private String id_closeBtn = "closeLargeModal";
    private String xpath_gender = "//*[@id=\"genterWrapper\"]//label[contains(text(),'"+data.getGender()+"')]";
    private String xpath_day = "//*[@class=\"react-datepicker__week\"]//div[contains(text(),'"+ data.getDay() +"')]";
    private String xpath_month = "//select/option[@value="+ data.getMonth() +"]";




    private String xpath_year = "//select/option[@value='"+ data.getYear() +"']";
    private String xpath_subjectsClick = "//*[@id=\"subjectsContainer\"]/div[2]/div//div[contains(text(),'"+ data.getSubjects() +"')]";
    private String id_state = "state";
    private String id_city = "city";
    private String xpath_stateValue = "//*[@id=\"state\"]";
    private String xpath_cityValue = "//*[@id=\"city\"]";

    public String getXpath_gender() {
        return xpath_gender;
    }


    public String getXpath_day() {
        return xpath_day;
    }

    public String getXpath_month() {
        return xpath_month;
    }

    public String getXpath_year() {
        return xpath_year;
    }
    public String getId_firstName() {
        return id_firstName;
    }

    public String getId_lastName() {
        return id_lastName;
    }

    public String getId_userMail() {
        return id_userMail;
    }

    public String getId_gender() {
        return id_gender;
    }

    public String getId_userNumber() {
        return id_userNumber;
    }

    public String getId_dateOfBirth() {
        return id_dateOfBirth;
    }

    public String getId_subjects() {
        return id_subjects;
    }

    public String getXpath_hobbies() {
        return xpath_hobbies;
    }

    public String getId_image() {
        return id_image;
    }

    public String getId_address() {
        return id_address;
    }

    public String getId_submitBtn() {
        return id_submitBtn;
    }

    public String getId_closeBtn() {
        return id_closeBtn;
    }

    public String getXpath_subjectsClick() {
        return xpath_subjectsClick;
    }

    public String getId_state() {
        return id_state;
    }

    public String getId_city() {
        return id_city;
    }

    public String getXpath_stateValue() {
        return xpath_stateValue;
    }

    public String getXpath_cityValue() {
        return xpath_cityValue;
    }
}
