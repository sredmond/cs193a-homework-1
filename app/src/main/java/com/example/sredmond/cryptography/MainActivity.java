package com.example.sredmond.cryptography;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public String getInputText() {
        TextView input = (TextView) findViewById(R.id.input);
        return input.getText().toString();
    }

    private void setOutputText(String text) {
        TextView output = (TextView) findViewById(R.id.output);
        output.setText(text);
    }

    public void encrypt(View view) {
        String plaintext = getInputText();
        String ciphertext = encryptText(plaintext);
        setOutputText(ciphertext);
    }

    public void decrypt(View view) {
        String ciphertext = getInputText();
        String plaintext = decryptText(ciphertext);
        setOutputText(plaintext);
    }

    private String encryptText(String plaintext) {
        String result = "";
        for (int i = 0; i < plaintext.length(); i++) {
            char ch = plaintext.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                result += (char) (((ch - 'a') + 3) % 26 + 'a');
            } else if (ch >= 'A' && ch <= 'Z') {
                result += (char) (((ch - 'A') + 3) % 26 + 'A');
            } else {
                result += ch;
            }
        }
        return result;
    }

    private String decryptText(String ciphertext) {
        String result = "";
        for (int i = 0; i < ciphertext.length(); i++) {
            char ch = ciphertext.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                result += (char) (((ch - 'a') + 23) % 26 + 'a');
            } else if (ch >= 'A' && ch <= 'Z') {
                result += (char) (((ch - 'A') + 23) % 26 + 'A');
            } else {
                result += ch;
            }
        }
        return result;
    }
}
