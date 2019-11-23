package co.id.sprint.sprinterprofile.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Employee {
    @SerializedName("id")
    @Expose
    private String employeeId;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("email")
    @Expose
    private String email;

    @SerializedName("phone")
    @Expose
    private String phone;

    public  Employee(){

    }

    public Employee(String employeeId, String name, String email, String phone) {
        this.employeeId = employeeId;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
