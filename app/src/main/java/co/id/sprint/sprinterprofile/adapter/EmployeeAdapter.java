package co.id.sprint.sprinterprofile.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

import co.id.sprint.sprinterprofile.ListEmployee;
import co.id.sprint.sprinterprofile.R;
import co.id.sprint.sprinterprofile.model.Employee;

public class EmployeeAdapter extends ArrayAdapter<Employee> {

    private Context context;
    private List<Employee> emp;

    public EmployeeAdapter(@NonNull Context context, int resource, @NonNull List<Employee> objects) {
        super(context, resource, objects);
        this.context = context;
        this.emp  = objects;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.activity_list_employee,parent,false);

        TextView txtEmployeeName = rowView.findViewById(R.id.txtEmployeeName);
        txtEmployeeName.setText(emp.get(position).getName());

        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ListEmployee.class);
                intent.putExtra("name", emp.get(position).getName());
                context.startActivity(intent);
            }
        });

        return rowView;
    }
}
