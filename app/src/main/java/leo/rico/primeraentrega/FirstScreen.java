package leo.rico.primeraentrega;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class FirstScreen extends AppCompatActivity {

    EditText txt_name;
    EditText txt_lastname;
    Button btn_sign;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_first_screen);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.first), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //Inicializar componentes
        txt_name = findViewById(R.id.txt_name);
        txt_lastname = findViewById(R.id.txt_lastname);
        btn_sign = findViewById(R.id.btn_sign);

        //Intent para enviar datos
        btn_sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sendData = new Intent(FirstScreen.this, MainActivity.class);
                sendData.putExtra("Name", txt_name.getText());
                sendData.putExtra("Lastname", txt_lastname.getText());
                startActivity(sendData);
            }
        });
    }
}