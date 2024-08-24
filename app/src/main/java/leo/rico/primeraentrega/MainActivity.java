package leo.rico.primeraentrega;

import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ImageButton;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.Calendar;
import android.app.DatePickerDialog;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ImageButton btnOpenCalendar;
    private TextView txtdateImput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnOpenCalendar = findViewById(R.id.btnopen_calendar);
        txtdateImput = findViewById(R.id.txtdateInput);

        btnOpenCalendar.setOnClickListener(v -> showDatePickerDialog());
    }

    private void showDatePickerDialog() {
        // Obtener la fecha actual
        final Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        // Crear el DatePickerDialog
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        // Formatear y mostrar la fecha seleccionada
                        String selectedDate = dayOfMonth + "/" + (month + 1) + "/" + year;
                        txtdateImput.setText(selectedDate);
                    }
                },
                year,
                month,
                day
        );

        // Mostrar el DatePickerDialog
        datePickerDialog.show();
    }
}