package varaujo.com.br.jogovelha;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import varaujo.com.br.p1_jogovelha.R;

public class Jogadores extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogadores);
    }

    public void startMatch(View view){
        EditText txtPlayer1 = (EditText) findViewById(R.id.txtJogador1);
        EditText txtPlayer2 = (EditText) findViewById(R.id.txtJogador2);
        String player1 = txtPlayer1.getText().toString().toUpperCase().trim();
        String player2 = txtPlayer2.getText().toString().toUpperCase().trim();

        if(player1.isEmpty() || player2.isEmpty()){
            Toast.makeText(getApplicationContext(), "Favor preencher os campos", Toast.LENGTH_SHORT).show();
        }else{
            Intent callGame = new Intent(this, Jogo.class);
            callGame.putExtra("player1", player1);
            callGame.putExtra("player2", player2);
            startActivity(callGame);
        }
    }
}