package co.id.sprint.sprinterprofile.service;

import java.util.List;

import co.id.sprint.sprinterprofile.model.Employee;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Path;

public interface EmployeeService {

    @GET("users/")
    Call<List<Employee>> getEmployee();

    @POST("add/")
    Call<Employee> addEmployee (@Body Employee employee);

    @PUT("update/{id}")
    Call<Employee> updateEmployee (@Path("id") String employeeId, @Body Employee employee);

    @DELETE("delete/{id}")
    Call<Employee> deleteEmployee (@Path("id") String employeeId);

}
