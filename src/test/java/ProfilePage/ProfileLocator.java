package ProfilePage;

public class ProfileLocator {
    private String urlPath = "profile";
    private String idUserName = "userName-value";
    private String locatorLogoutBtn = "//*[@id=\"books-wrapper\"]//*[@id=\"submit\"]";

    public String getIdUserName() {
        return idUserName;
    }

    public String getLocatorLogoutBtn() {
        return locatorLogoutBtn;
    }

    public String getUrlPath() {
        return urlPath;
    }
}
