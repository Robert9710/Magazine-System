package magazinesystem.components;

public interface MarketingDepartmentInterface {
    String sendAdvert(String title);
    String deleteAdvert(String title);
    String storeAdvertDetails(String title);
    int getRequestsNumber();
    void checkRequests();
}
