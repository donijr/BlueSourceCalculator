package br.com.donizetijr.bluesourcecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calcularBoulosCho(View view) {

        float resultadoBoulosCho = 0.0f;

        EditText editTextGCho1 = (EditText) findViewById(R.id.editTextGCho1);
        EditText editTextGCho2 = (EditText) findViewById(R.id.editTextGCho2);
        EditText editTextUiBoulos = (EditText) findViewById(R.id.editTextUiBoulos);
        TextView textViewResultadoBoulosCho = findViewById(R.id.textViewResultadoBoulosCho);

        float gCho1 = Float.parseFloat(editTextGCho1.getText().toString());
        float gCho2 = Float.parseFloat(editTextGCho2.getText().toString());
        float uiBoulos = Float.parseFloat(editTextUiBoulos.getText().toString());

        resultadoBoulosCho = ((gCho2 * uiBoulos) / gCho1);
        textViewResultadoBoulosCho.setText(String.valueOf(resultadoBoulosCho));


    }

    public void calcularBoulosCorrecao(View view){
        float resultadoBoulosCorrecao = 0.0f;

        EditText editTextGlicemiaAtual = (EditText) findViewById(R.id.editTextGlicemiaAtual);
        TextView textViewInsulinaCorrecao = findViewById(R.id.textViewInsulinaCorrecao);

        int glicemiaAtual = Integer.parseInt(editTextGlicemiaAtual.getText().toString());

        // Calculo da Correção do Boulos. Se glicemiaAtual <= 100 não tem correção. Se glicemiaAtual > 100
        if (glicemiaAtual <= 100 ) {
            resultadoBoulosCorrecao = 0;
        }else {

            resultadoBoulosCorrecao = ((float) glicemiaAtual - 100) / 50;
        }

        textViewInsulinaCorrecao.setText(String.valueOf(resultadoBoulosCorrecao));


    }

    public void calcularTotalBoulos(View view){
        TextView textViewTotalBoulos = findViewById(R.id.textViewTotalBoulos);
        //EditText editTextGlicemiaAtual = (EditText) findViewById(R.id.editTextGlicemiaAtual);
        TextView textViewResultadoBoulosCho = findViewById(R.id.textViewResultadoBoulosCho);
        TextView textViewInsulinaCorrecao = findViewById(R.id.textViewInsulinaCorrecao);

        float totalBoulos = Float.parseFloat(textViewResultadoBoulosCho.getText().toString()) + Float.parseFloat(textViewInsulinaCorrecao.getText().toString());

        textViewTotalBoulos.setText(String.valueOf(totalBoulos));

    }


}
