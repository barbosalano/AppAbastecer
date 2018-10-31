package com.example.barbosa.horadeabastecer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText etPrecoAlcool;
    private EditText etPrecoGasolina;
    private TextView tvResposta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etPrecoAlcool = findViewById(R.id.etPrecoAlcool);
        etPrecoGasolina = findViewById(R.id.etPrecoGasolina);
        tvResposta = findViewById(R.id.tvResposta);

    }

    public void btnCalcular(View view) {

        //para recuperar valores digitados
        String precoAlcool = etPrecoAlcool.getText().toString();
        String precoGasolina = etPrecoGasolina.getText().toString();

        //validar campos digitados

        Boolean camposValidados = this.validarCampos(precoAlcool, precoGasolina);

        if (camposValidados) {

            this.calcularMelhorPreco(precoAlcool, precoGasolina);

        } else {
            tvResposta.setText("Preencha os campos corretamente!");
        }

    }

    public void calcularMelhorPreco(String pAlcool, String pGasolina) {

        //convertendo valores Strings para int
        Double precoAlcool = Double.parseDouble(pAlcool);
        Double precoGasolina = Double.parseDouble(pGasolina);

        //fazendo o calculo final

        Double resposta = precoAlcool / precoGasolina;
        if (resposta >= 0.7){
            tvResposta.setText("Melhor utilizar Álcool hoje!");

        }else {

            tvResposta.setText("Melhor utilizar Gasolina hoje!");
        }
    }

    public Boolean validarCampos(String pAlcool, String pGasolina) {

        Boolean camposValidados = true;

        //validar campos
        if (pAlcool == null || pAlcool.equals("")) {

            camposValidados = false;

        } else if (pGasolina == null || pGasolina.equals("")) {
            camposValidados = false;
        }

        return camposValidados;

    }
}
