package utils;

public enum ApplicationUrls {

    PETSTORE_BASE_URL("https://petstore.swagger.io/v2/"),
    EPAM_MAIN_PAGE_URL("https://www.epam.com/"),
    EPAM_CONTACT_US_PAGE_URL("https://www.epam.com/about/who-we-are/contact/"),
    EPAM_ABOUT_US_PAGE_URL("https://www.epam.com/about/"),
    TRICENTIS_MAIN_PAGE_URL("https://demowebshop.tricentis.com/");

    private final String url;

    ApplicationUrls(String url) {
        this.url= url;
    }
    public String getUrl() {
        return url;
    }
}
