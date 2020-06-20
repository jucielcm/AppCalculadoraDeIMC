package com.example.calculadoradeimc;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {
    //Declaração das variáveis

    int peso;
    float altura;
    float imc;
    String mensagem = "";

    // Apontando os objetos do layout
    //Declaração dos objetos (Layout)

    EditText editPeso, editAltura;
    TextView txtResultado;
    Button btCalcular;
    Spinner spinnerSexo;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       editPeso =(EditText) findViewById(R.id.peso);
       editAltura =(EditText) findViewById(R.id.altura);
       txtResultado =(TextView) findViewById(R.id.resultado);
       btCalcular =(Button) findViewById(R.id.btCalcular);
       spinnerSexo = findViewById(R.id.spinnerSexo);



       btCalcular.setOnClickListener (new View.OnClickListener(){
          @Override
          public void onClick(View v){
              //Recuperar os valores digitados

              peso = Integer.parseInt(editPeso.getText().toString());
              altura = Float.parseFloat(editAltura.getText().toString());


              //Calcular o IMC
              imc = peso / (altura * altura);

              //Verificar as faixas de peso
              if(imc<16.0){
                mensagem = "Magreza Grave";
              }else if((imc>=16.0) && (imc<17.0)){
                  mensagem = "Magreza Moderada";
              }else if((imc>=17.0) && (imc<18.5)){
                  mensagem = "Magreza Leve";
              }else if((imc>=18.5) && (imc<25.0)){
                  mensagem = "Peso Ideal (Saudável, menor risco para doenças)";
              }else if((imc>=25.0) && (imc<30.0)){
                  mensagem = "Sobrepeso";
              }else if((imc>=30.0) && (imc<35.0)){
                  mensagem = "Obesidade de Grau I";
              }else if((imc>=35.0) && (imc<40.0)){
                  mensagem = "Obesidade de Grau II (Severa)";
              }else{
                  mensagem = "Obesidade de Grau III(Mórbita)";
              }

              //Mostrar a saída do Resultado
              txtResultado.setText("IMC: " + String.valueOf(imc) + "\nMensagem: " + mensagem);
          }
        });
    }
}
