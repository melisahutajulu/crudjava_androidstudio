package co.id.sprint.sprinterprofile.service;

public class APIUtils {
    private APIUtils(){

    }

    public static final  String API_URL = "https://jsonplaceholder.typicode.com/";

    public static EmployeeService getEmployeeService(){
        return RetrofitClient.getClient(API_URL).create(EmployeeService.class);
    }
}
