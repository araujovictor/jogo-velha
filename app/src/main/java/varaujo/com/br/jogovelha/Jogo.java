package varaujo.com.br.jogovelha;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import varaujo.com.br.p1_jogovelha.R;

public class Jogo extends AppCompatActivity {

    private final String BTN = "btn";
    private final String Bola = "O";
    private final String Xis = "X";
    private String ultimoJogado = "O";
    private View view;
    private int qntJogadas = 0;

    int [][] resultados = new int[][]{
            {1,2,3},
            {4,5,6},
            {7,8,9},

            {1,4,7},
            {2,5,8},
            {3,6,9},

            {1,5,9},
            {3,5,7},
    };

        @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setView(getLayoutInflater().inflate(R.layout.activity_jogo, null));
        setContentView(getView());

        TextView player1 = (TextView) findViewById(R.id.lblPlayer1);
        TextView player2 = (TextView) findViewById(R.id.lblPlayer2);
        TextView jogadorRodada = (TextView) findViewById(R.id.lblNomeJogadorRodada);
        player1.setText(getIntent().getStringExtra("player1").concat(" - X"));
        player2.setText(getIntent().getStringExtra("player2").concat(" - O"));
        jogadorRodada.setText(player1.getText());
    }

    public void setarValor(View view){
        qntJogadas++;
        TextView jogadorRodada = (TextView) findViewById(R.id.lblNomeJogadorRodada);
        if(((Button)view).getText().equals("")) {
            if ((getUltimoJogado().equals(Bola))) {
                ((Button) view).setText(Xis);
                setUltimoJogado(Xis);
                calculoResultado();
                TextView playerRodada = (TextView) findViewById(R.id.lblPlayer2);
                jogadorRodada.setText(playerRodada.getText().toString().trim());
            } else {
                ((Button) view).setText(Bola);
                setUltimoJogado(Bola);
                calculoResultado();
                TextView playerRodada = (TextView) findViewById(R.id.lblPlayer1);
                jogadorRodada.setText(playerRodada.getText().toString().trim());
            }
        }
    }

    public Button getQuad(int tagNum){
        return (Button)getView().findViewWithTag(BTN+tagNum);
    }

    public void clear(View view){
        TextView jogadorRodada = (TextView) findViewById(R.id.lblNomeJogadorRodada);
        for(int i = 0; i <=9; i++){
            if(getQuad(i)!=null){
                getQuad(i).setText("");
            }
        }
        setUltimoJogado("O");
        TextView playerRodada = (TextView) findViewById(R.id.lblPlayer1);
        jogadorRodada.setText(playerRodada.getText().toString());
    }

    public void calculoResultado(){

        for(int j = 0; j<=7; j++){

            TextView txtWinner = (TextView) findViewById(R.id.lblNomeJogadorRodada);
            String winner = txtWinner.getText().toString().trim().toUpperCase();
            Intent informaGanhador = new Intent(this, Vencedores.class);
            informaGanhador.putExtra("winner",winner);

            String s1 = getQuad( resultados[j][0]).getText().toString();
            String s2 = getQuad( resultados[j][1]).getText().toString();
            String s3 = getQuad( resultados[j][2]).getText().toString();

            if(!s1.isEmpty() && !s2.isEmpty() && !s3.isEmpty()) {
                if (s1.equals(s2) && (s2.equals(s3))) {
                    if(s1.equals(Xis)){
                        startActivity(informaGanhador);
                    }else{
                        startActivity(informaGanhador);
                    }
                } else if(qntJogadas == 9){
                    winner = getText(R.string.empate).toString();
                    informaGanhador.putExtra("winner", winner);
                    startActivity(informaGanhador);
                }
            }
        }
    }

    public String getUltimoJogado() {
        return ultimoJogado;
    }

    public void setUltimoJogado(String ultimoJogado) {
        this.ultimoJogado = ultimoJogado;
    }

    public void setView(View view) {
        this.view = view;
    }

    public View getView() {
        return view;
    }
}
