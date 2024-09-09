package leo.rico.primeraentrega;

import android.annotation.SuppressLint;
import android.content.Intent;
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
    ImageButton btnOpenCalendar;
    TextView txtdateImput;
    ImageButton btn_add_task;
    TextView txt_welcome;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate Called");
        // Configuración inicial de la actividad
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.second), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //Inicializar componentes
        btnOpenCalendar = findViewById(R.id.btnopen_calendar);
        txtdateImput = findViewById(R.id.txtdateInput);
        btn_add_task = findViewById(R.id.btn_add_task);
        txt_welcome = findViewById(R.id.txt_welcome);

        //Configurar listeners
        btnOpenCalendar.setOnClickListener(v -> showDatePickerDialog());

        //crear la configuracion del evento para añadir tareas
        btn_add_task.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                Log.d(TAG, "Estoy en el botón añadir");

                Intent receiveData = new Intent(MainActivity.this, FirstScreen.class);
                String welcome_name = receiveData.getStringExtra("Name");
                String welcome_lastname = receiveData.getStringExtra("Lastname");

                txt_welcome.setText(R.string.Welcome + welcome_name + " " + welcome_lastname);
            }
        });
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
                        if (dayOfMonth < 10) {
                            formattedDay = 0 + String.valueOf(dayOfMonth);
                        } else {
                            formattedDay = String.valueOf(dayOfMonth);
                        }

                        //Obtener mes
                        int MONTH = month + 1;
                        if (MONTH < 10) {
                            formattedMonth = 0 + String.valueOf(month);
                        } else {
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
        // procesos que deben estar activos mientras la actividad está en primer plano
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause called");
        // guardar el estado o detener procesos que no deben continuar mientras la actividad está en segundo plano
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop called");
        // liberar recursos que no se necesitan mientras la actividad no está en primer plano
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy called");
        // limpiar recursos o liberar memoria
    }
}
