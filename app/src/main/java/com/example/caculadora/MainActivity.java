package com.example.caculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    /*ATRIBUTOS*/

    private TextView display;
    private String primeironumeo = "";
    private String segundonumero = "";
    private String operacao = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        display = findViewById(R.id.textview_numero);
    }

    /*NUMEROS DA CALCULADORA*/

    public void onClickBotao1(View v) {
        atualizarNumeroDigitado("1");
        atualizarDisplay("1");
    }

    public void onClickBotao2(View v) {
        atualizarNumeroDigitado("2");
        atualizarDisplay("2");
    }

    public void onClickBotao3(View v) {
        atualizarNumeroDigitado("3");
        atualizarDisplay("3");
    }

    public void onClickBotao4(View v) {
        atualizarNumeroDigitado("4");
        atualizarDisplay("4");
    }

    public void onClickBotao5(View v) {
        atualizarNumeroDigitado("5");
        atualizarDisplay("5");
    }

    public void onClickBotao6(View v) {
        atualizarNumeroDigitado("6");
        atualizarDisplay("6");
    }

    public void onClickBotao7(View v) {
        atualizarNumeroDigitado("7");
        atualizarDisplay("7");
    }

    public void onClickBotao8(View v) {
        atualizarNumeroDigitado("8");
        atualizarDisplay("8");
    }

    public void onClickBotao9(View v) {
        atualizarNumeroDigitado("9");
        atualizarDisplay("9");
    }

    public void onClickBotao0(View v) {
        atualizarNumeroDigitado("0");
        atualizarDisplay("0");
    }

    public void onClicknegativo(View v) {
        atualizarNumeroDigitado("-");
        atualizarDisplay("-");
    }

    public void onClickponto(View v) {
        atualizarNumeroDigitado(",");
        atualizarDisplay(",");
    }



    /*OPERACOES DA CALCULADORA*/

    public void onClickadicao(View v) {

       if (!primeironumeo.isEmpty()) {
           operacao = "+";
           atualizarDisplay("+");
       }else {
           Toast.makeText(MainActivity.this,"É priciso informar um número antes", Toast.LENGTH_LONG).show();
       }

    }

    public void onClicksubtracao(View v) {
        if(!primeironumeo.isEmpty()){
        operacao = "-";
        atualizarDisplay("-");
        }else {
        Toast.makeText(MainActivity.this,"É priciso informar um número antes", Toast.LENGTH_LONG).show();
        }
    }

    public void onClickmultiplicacao(View v) {

        if (!primeironumeo.isEmpty()){
        operacao = "x";
        atualizarDisplay("x");

        }else {
        Toast.makeText(MainActivity.this,"É priciso informar um úumero antes", Toast.LENGTH_LONG).show();
        }
    }

    public void onClickdivisao(View v) {
        if (!primeironumeo.isEmpty()){
        operacao = "/";
        atualizarDisplay("/");
        }else {
            Toast.makeText(MainActivity.this,"É preciso informar um número antes", Toast.LENGTH_LONG).show();
        }
    }

    public void onClickexpoente(View v) {
        if (!primeironumeo.isEmpty()){
        operacao = "^";
        atualizarDisplay("^");
        }else {
            Toast.makeText(MainActivity.this,"É preciso informar um número antes", Toast.LENGTH_LONG).show();
        }
    }

    /*BOTAO C(CLEAR)*/

    public void onClickC(View v) {
        atualizarDisplaynulo("");
        primeironumeo = "";
        segundonumero = "";
        operacao = "";
    }

    /*CONCLUSAO DA CONTA*/

    public void onClickigual(View v) {

        if (!primeironumeo.isEmpty() && !segundonumero.isEmpty()) {
            double numero1 = Integer.parseInt(primeironumeo);
            double numero2 = Integer.parseInt(segundonumero);

            int numero1expoente = Integer.parseInt(primeironumeo);
            int numero2expoente = Integer.parseInt(segundonumero);

            if (operacao.equals("+")) {
                double resultado = numero1 + numero2;
                display.setText(String.valueOf(resultado));
            }

            if (operacao.equals("-")) {
                double resultado = numero1 - numero2;
                display.setText(String.valueOf(resultado));
            }

            if (operacao.equals("x")) {
                double resultado = numero1 * numero2;
                display.setText(String.valueOf(resultado));
            }

            if (operacao.equals("/")) {
                if (numero2 != 0) {
                    double resultado = numero1 / numero2;
                    display.setText(String.valueOf(resultado));
                }else {
                    Toast.makeText(MainActivity.this,"Não é possivel dividir um número por zero", Toast.LENGTH_LONG).show();
                }
            }

            if (operacao.equals("^")) {
                int resultado = numero1expoente ^ numero2expoente;
                display.setText(String.valueOf(resultado));
            }
        }else {
            Toast.makeText(MainActivity.this,"Não foi efetuado nenhuma operação.", Toast.LENGTH_LONG).show();
        }


    }

    /*METODOS*/

    private void atualizarDisplay(String texto) {
        String textoDisplay = display.getText().toString();
        textoDisplay = textoDisplay + texto;
        display.setText(textoDisplay);
    }

    private void atualizarNumeroDigitado(String numero) {
        if (operacao.isEmpty()) {
            primeironumeo = primeironumeo + numero;
        } else {
            segundonumero = segundonumero + numero;

        }
    }

    private void atualizarDisplaynulo(String texto) {
        String cleartexto = display.getText().toString();
        cleartexto = "";
        display.setText(cleartexto);
    }
}

