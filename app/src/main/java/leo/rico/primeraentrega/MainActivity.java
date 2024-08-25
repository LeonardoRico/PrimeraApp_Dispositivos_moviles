package leo.rico.primeraentrega;

import android.annotation.SuppressLint;
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
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private ImageButton btnOpenCalendar;
    private TextView txtdateImput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate Called");
        // Configuración inicial de la actividad
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //Inicializar componentes
        btnOpenCalendar = findViewById(R.id.btnopen_calendar);
        txtdateImput = findViewById(R.id.txtdateInput);

        //Configurar listeners
        btnOpenCalendar.setOnClickListener(v -> showDatePickerDialog());
    }

    private void showDatePickerDialog() {
        // Obtener la fecha actual
        final Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int MONTH = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        // Crear el DatePickerDialog
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this,
                new DatePickerDialog.OnDateSetListener() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        // Formatear y mostrar la fecha seleccionada
                        String formattedDay, formattedMonth;

                        //Obtener dia
                        if (dayOfMonth < 10){
                            formattedDay = 0 + String.valueOf(dayOfMonth);
                        }else{
                            formattedDay = String.valueOf(dayOfMonth);
                        }

                        //Obtener mes
                        int MONTH = month + 1;
                        if (MONTH < 10){
                            formattedMonth = 0 + String.valueOf(month);
                        }else{
                            formattedMonth = String.valueOf(month);
                        }

                        //settear fecha en textView
                        txtdateImput.setText(formattedDay + "/" + formattedMonth + "/" + year);
                    }
                },
                year,
                MONTH,
                day
        );

        // Mostrar el DatePickerDialog
        datePickerDialog.show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart called");
        //iniciar o reanudar procesos que deben estar activos mientras la actividad está visible
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume called");
        // Aquí puedes reiniciar procesos que deben estar activos mientras la actividad está en primer plano
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause called");
        // Aquí puedes guardar el estado o detener procesos que no deben continuar mientras la actividad está en segundo plano
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop called");
        // Aquí puedes liberar recursos que no se necesitan mientras la actividad no está en primer plano
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy called");
        // Aquí puedes limpiar recursos o liberar memoria
    }
}