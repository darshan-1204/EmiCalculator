package com.example.emicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    EditText edit_amount,edit_interest,edit_period;
    Button btn;
    TextView tv,total_pay,total_i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit_amount = findViewById(R.id.edit_amount);
        edit_interest = findViewById(R.id.edit_interest);
        edit_period = findViewById(R.id.edit_period);
        btn = findViewById(R.id.btn);
        tv = findViewById(R.id.tv);
        total_pay = findViewById(R.id.total_pay);
        total_i = findViewById(R.id.total_i);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                double p = Double.parseDouble(edit_amount.getText().toString());
                double r = Double.parseDouble(edit_interest.getText().toString());
                double n = Double.parseDouble(edit_period.getText().toString());

                r = r / (12 * 100);

                float final_ans = 1.0f;

                for (int i = 0; i < n; i++) {

                    final_ans *= 1 + r;

                }

                float emi = (float) (p * r * (final_ans) / (final_ans - 1));

                DecimalFormat decimalFormat = new DecimalFormat("0");

                int final_emi = Integer.parseInt(decimalFormat.format(emi));

                tv.setText("EMI :" + final_emi);

                int t_p = (int) (final_emi * n);

                total_pay.setText("Total Pay : " + t_p);

                total_i.setText("Total Interest : " + (t_p -p));


            }
        });

    }
}