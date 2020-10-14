package br.com.donizetijr.bluesourcecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public RadioGroup opcaoRefeicao;
    public EditText editTextGCho1, editTextGCho2, editTextUiBoulos, editTextGlicemiaAtual;
    public TextView textViewResultadoBoulosCho, textViewInsulinaCorrecao, textViewTotalBoulos;



    //TextView textViewResultadoBoulosCho = findViewById(R.id.textViewResultadoBoulosCho);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // EditText
        editTextGCho1 = findViewById(R.id.editTextGCho1);
        editTextGCho2 = findViewById(R.id.editTextGCho2);
        editTextUiBoulos = findViewById(R.id.editTextUiBoulos);
        editTextGlicemiaAtual = findViewById(R.id.editTextGlicemiaAtual);

        // Text View
        textViewResultadoBoulosCho = findViewById(R.id.textViewResultadoBoulosCho);
        textViewInsulinaCorrecao = findViewById(R.id.textViewInsulinaCorrecao);

        // Radio Group
        opcaoRefeicao = findViewById(R.id.radioGroupRefeicao);

        radiobutton();
    }

    public void radiobutton(){
        opcaoRefeicao.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.radiobtn_cafe) {
                    editTextGCho1.setText("8");
                    editTextUiBoulos.setText("1");

                }else if(checkedId == R.id.radiobtn_almoco){
                    editTextGCho1.setText("10");
                    editTextUiBoulos.setText("1");

                }else if(checkedId == R.id.radiobtn_lanche){
                    editTextGCho1.setText("10");
                    editTextUiBoulos.setText("1");

                }else if(checkedId == R.id.radiobtn_jantar){
                    editTextGCho1.setText("8");
                    editTextUiBoulos.setText("1");

                }

            }
        });

    }
    public void calcularBoulosCho (View view){

        float resultadoBoulosCho = 0.0f;

        //EditText editTextGCho1 = (EditText) findViewById(R.id.editTextGCho1);
        //EditText editTextGCho2 = (EditText) findViewById(R.id.editTextGCho2);
        //EditText editTextUiBoulos = (EditText) findViewById(R.id.editTextUiBoulos);


        float gCho1 = Float.parseFloat(editTextGCho1.getText().toString());
        float gCho2 = Float.parseFloat(editTextGCho2.getText().toString());
        float uiBoulos = Float.parseFloat(editTextUiBoulos.getText().toString());

        resultadoBoulosCho = ((gCho2 * uiBoulos) / gCho1);
        textViewResultadoBoulosCho.setText(String.valueOf(resultadoBoulosCho));


    }

    public void calcularBoulosCorrecao (View view){
        float resultadoBoulosCorrecao = 0.0f;

        //EditText editTextGlicemiaAtual = (EditText) findViewById(R.id.editTextGlicemiaAtual);
        //TextView textViewInsulinaCorrecao = findViewById(R.id.textViewInsulinaCorrecao);

        int glicemiaAtual = Integer.parseInt(editTextGlicemiaAtual.getText().toString());

        // Calculo da Correção do Boulos. Se glicemiaAtual <= 100 não tem correção. Se glicemiaAtual > 100
        if (glicemiaAtual <= 100) {
            resultadoBoulosCorrecao = 0;
        } else {

            resultadoBoulosCorrecao = ((float) glicemiaAtual - 100) / 38;
        }

        textViewInsulinaCorrecao.setText(String.valueOf(resultadoBoulosCorrecao));


    }

    public void calcularTotalBoulos (View view){
        TextView textViewTotalBoulos = findViewById(R.id.textViewTotalBoulos);

        // já estava comentado -- EditText editTextGlicemiaAtual = (EditText) findViewById(R.id.editTextGlicemiaAtual);
        TextView textViewResultadoBoulosCho = findViewById(R.id.textViewResultadoBoulosCho);
        TextView textViewInsulinaCorrecao = findViewById(R.id.textViewInsulinaCorrecao);

        float totalBoulos = Float.parseFloat(textViewResultadoBoulosCho.getText().toString()) + Float.parseFloat(textViewInsulinaCorrecao.getText().toString());

        textViewTotalBoulos.setText(String.valueOf(totalBoulos));

    }


}
