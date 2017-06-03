package varaujo.com.br.jogovelha;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import varaujo.com.br.p1_jogovelha.R;

public class Principal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
    }

    public void newGame(View view){
        Intent callDisplay = new Intent(this, Jogadores.class);
        startActivity(callDisplay);
    }

    public void encerra(View view){
        Intent encerra = new Intent(Intent.ACTION_MAIN);
        encerra.addCategory(Intent.CATEGORY_HOME);
        encerra.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(encerra);
    }


}
