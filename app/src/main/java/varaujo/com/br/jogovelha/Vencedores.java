package varaujo.com.br.jogovelha;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import varaujo.com.br.p1_jogovelha.R;

public class Vencedores extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vencedores);

        TextView winner = (TextView) findViewById(R.id.txtNomeVencerdor);
        winner.setText(getIntent().getStringExtra("winner"));
    }

    public void newGame(View view){
        Intent callNewGame = new Intent(this, Jogadores.class);
        startActivity(callNewGame);
    }

}
