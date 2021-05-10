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
import android.widget.Toast;

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
                String ipName = name.getText().toString();
                String ipPhone = phone.getText().toString();
                String ipSize = size.getText().toString();
                int checkTable = grpTable.getCheckedRadioButtonId();
                int day = dateP.getDayOfMonth();
                int mth = dateP.getMonth();
                int yr = dateP.getYear();
                int hr = timeP.getCurrentHour();
                int min = timeP.getCurrentMinute();

                if (ipName.length() != 0 && ipPhone.length() != 0 && ipSize.length() != 0) {
                    if (checkTable == R.id.radioBtnSmoking){
                        showInfo.setText(String.format("Name: %s\nDate & Time: %d/%d/%d, %02d:%02d\nTable at: Smoking Area",
                                ipName, day, mth, yr, hr, min));
                    }

                    if (checkTable == R.id.radioBtnNonSmoke){
                        showInfo.setText(String.format("Name: %s\nDate & Time: %d/%d/%d, %02d:%02d\nTable at: Non-Smoking Area",
                                ipName, day, mth, yr, hr, min));
                    }
                }

                else {
                    if (ipName.length() == 0){
                        Toast.makeText(MainActivity.this, "Please enter Name", Toast.LENGTH_LONG).show();
                    }
                    if (ipPhone.length() == 0){
                        Toast.makeText(MainActivity.this, "Please enter Phone Number", Toast.LENGTH_LONG).show();
                    }
                    if (ipSize.length() == 0) {
                        Toast.makeText(MainActivity.this, "Please enter Size of Group", Toast.LENGTH_LONG).show();
                    }
                }

            }
        });

        btnR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name.setText("");
                phone.setText("");
                size.setText("");
                grpTable.clearCheck();
                dateP.updateDate(2020, 5, 1);
                timeP.setCurrentHour(19);
                timeP.setCurrentMinute(30);
                showInfo.setText("");
            }
        });

        // Restrictions for reservation timing
        timeP.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                // Add code here to limit the time to 8AM and 8PM
                hourOfDay = timeP.getCurrentHour();
                minute = timeP.getCurrentMinute();

                if (hourOfDay < 8 && minute <= 59){
                    timeP.setCurrentHour(8);
                    timeP.setCurrentMinute(00);
                    Toast.makeText(MainActivity.this, "Open at 8AM", Toast.LENGTH_LONG).show();
                }

                if (hourOfDay > 20 && minute > 00){
                    timeP.setCurrentHour(19);
                    timeP.setCurrentMinute(59);
                    Toast.makeText(MainActivity.this, "Close at 8PM", Toast.LENGTH_LONG).show();
                }

            }
        });

    }
}