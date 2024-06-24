package com.android.devrhyan.jokenpo;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Objects;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void setPedra(View view){
       handleWinner("Pedra");
    }

    public void setPapel(View view){
        handleWinner("Papel");
    }

    public void setTesoura(View view){
        handleWinner("Tesoura");
    }

    public String getEscolha(){
         ImageView AppImage = findViewById(R.id.image_app);

         int number = new Random().nextInt(3);
         String[] archives = {"Pedra", "Papel", "Tesoura"};
         String Resultado = archives[number];

         switch(Resultado){
             case "Pedra" :
                 AppImage.setImageResource(R.drawable.pedra);
                 break;
             case "Papel" :
                 AppImage.setImageResource(R.drawable.papel);
                 break;
             case "Tesoura" :
                 AppImage.setImageResource(R.drawable.tesoura);
                 break;
             default:
                 AppImage.setImageResource(R.drawable.padrao);
                 break;
         }

         return Resultado;
    }

    private void handleWinner(String Select){
        TextView Final = findViewById(R.id.resultado);

        String CPU = getEscolha();
        System.out.println("Escolha do Usúario: " + Select);
        System.out.println("Escolha da CPU: " + CPU);

        if((Objects.equals(CPU, "Pedra") && Objects.equals(Select, "Tesoura")) || (Objects.equals(CPU, "Papel") && Objects.equals(Select, "Pedra")) || (Objects.equals(CPU, "Tesoura") && Objects.equals(Select, "Papel"))){
            Final.setText("Resultado: A CPU Venceu!");
        } else if( (Objects.equals(Select, "Pedra") && Objects.equals(CPU, "Tesoura")) || (Objects.equals(Select, "Papel") && Objects.equals(CPU, "Pedra")) || (Objects.equals(Select, "Tesoura") && Objects.equals(CPU, "Papel"))){
            Final.setText("Resultado: Você ganhou!");
        } else {
            Final.setText("Resultado: Empate!");
        }
    }
}