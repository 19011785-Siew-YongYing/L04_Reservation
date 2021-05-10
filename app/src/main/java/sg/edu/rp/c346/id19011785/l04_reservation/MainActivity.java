package sg.edu.rp.c346.id19011785.l04_reservation;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {

    Button btnCfm, btnR;
    RadioGroup grpTable;
    EditText name, phone, size;
    DatePicker dateP;
    TimePicker timeP;
    TextView showInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCfm = findViewById(R.id.btnConfirm);
        btnR = findViewById(R.id.btnReset);
        grpTable = findViewById(R.id.radioBtnTable);
        name = findViewById(R.id.editName);
        phone = findViewById(R.id.editMobile);
        size = findViewById(R.id.editSize);
        dateP = findViewById(R.id.datePicker);
        timeP = findViewById(R.id.timePicker);
        showInfo = findViewById(R.id.displayInfo);

        btnCfm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(name.getText().toString().length() > 0)

            }
        });


    }
}