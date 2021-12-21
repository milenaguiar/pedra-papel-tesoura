package com.example.pedrapapeltesoura;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private  ImageView imageResultado;
    private  TextView textResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageResultado  = findViewById(R.id.imageResultado);
        textResultado   = findViewById(R.id.textResultado);

    }
    public void pedraSelecionado(View view){
        this.opcaoSelecionada("pedra");

    }
    public void papelSelecionado(View view){
        this.opcaoSelecionada("papel");

    }
    public void tesouraSelecionado(View view){
        this.opcaoSelecionada("tesoura");

    }

    public void opcaoSelecionada( String opcaoUsuario){



      int numero = new Random().nextInt(3);
      String[] opcoes = {"pedra" , "papel" , "tesoura"};
      String opcaoApp = opcoes[numero];

      switch ( opcaoApp ){
          case  "pedra" :
              imageResultado.setImageResource(R.drawable.pedra);
              break;
          case  "papel" :
              imageResultado.setImageResource(R.drawable.papel);
              break;
          case  "tesoura" :
              imageResultado.setImageResource(R.drawable.tesoura);
              break;

      }

      if(
              ( opcaoApp == "tesoura" && opcaoUsuario == "papel") ||
              ( opcaoApp == "papel" && opcaoApp == "pedra" ) ||
              ( opcaoApp == "pedra" && opcaoApp == "tesoura")
      ){//app ganhador
          textResultado.setText("Você perdeu! :(");

      }else if(
              ( opcaoUsuario == "tesoura" && opcaoApp == "papel") ||
              ( opcaoUsuario == "papel" && opcaoApp == "pedra" ) ||
              ( opcaoUsuario== "pedra" && opcaoApp == "tesoura")

      ){ //usuario ganhador
          textResultado.setText("Você ganhou! :)");

      }else{
          //empate
          textResultado.setText("Empate!");


      }


        System.out.println("item clicado " + opcaoApp);

    }
}