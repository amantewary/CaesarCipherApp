package com.example.amant.cipherapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputFilter;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView encrypt_decrypt_output;
    private EditText input_value;
    private TextView shift_value;
    private SeekBar seekBar;
    private Button encrypt_decrypt_button;
    private CaesarCipher caesarCipher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        encrypt_decrypt_output = findViewById(R.id.encrypt_decrypt_value);
        input_value = findViewById(R.id.input_value);
        shift_value = findViewById(R.id.shift_value);
        seekBar = findViewById(R.id.seekBar);
        encrypt_decrypt_button = findViewById(R.id.encrypt_decrypt);
        caesarCipher = new CaesarCipher();

        shift_value.setText(String.valueOf(seekBar.getProgress()));
        input_value.setFilters(new InputFilter[]{new InputFilter.AllCaps()});


        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                shift_value.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        encrypt_decrypt_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(input_value.getText().toString().isEmpty()){

                    input_value.setError("Enter some text");
                } else {
                    caesarCipher.setInput(input_value.getText().toString());
                    caesarCipher.setShiftValue(seekBar.getProgress());
                    caesarCipher.caesar();
                    encrypt_decrypt_output.setText(caesarCipher.getCryptedInput());
                }
            }
        });
    }
}
