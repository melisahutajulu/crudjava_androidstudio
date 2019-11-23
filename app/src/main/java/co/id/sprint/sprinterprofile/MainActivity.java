package co.id.sprint.sprinterprofile;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import co.id.sprint.sprinterprofile.adapter.EmployeeAdapter;
import co.id.sprint.sprinterprofile.model.Employee;
import co.id.sprint.sprinterprofile.service.APIUtils;
import co.id.sprint.sprinterprofile.service.EmployeeService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    ListView listView;

    EmployeeService employeeService;
    List<Employee> list = new ArrayList<Employee>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("EMPLOYEE");

        listView = findViewById(R.id.listView);
        employeeService = APIUtils.getEmployeeService();
    }

    @Override
    protected void onStart() {
        super.onStart();
        getEmployeeList();
    }

    public void getEmployeeList(){
        Call<List<Employee>> call = employeeService.getEmployee();
        call.enqueue(new Callback<List<Employee>>() {
            @Override
            public void onResponse(Call<List<Employee>> call, Response<List<Employee>> response) {
                if(response.isSuccessful()){
                    list = response.body();
                    listView.setAdapter(new EmployeeAdapter(MainActivity.this, R.layout.activity_list_employee,list));
                }
            }

            @Override
            public void onFailure(Call<List<Employee>> call, Throwable t) {
                Log.e("ERROR: ", t.getMessage());
            }
        });
    }
}
