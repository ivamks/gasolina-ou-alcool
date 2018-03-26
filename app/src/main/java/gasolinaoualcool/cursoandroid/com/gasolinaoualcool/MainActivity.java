package gasolinaoualcool.cursoandroid.com.gasolinaoualcool;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText precoAlcool;
    private EditText precoGasolina;
    private Button botaoVerificar;
    private TextView textoResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //localizar componentes na tela
        precoAlcool = (EditText) findViewById(R.id.precoAlcoolId);
        precoGasolina = (EditText) findViewById(R.id.precoGasolinaId);
        botaoVerificar = (Button) findViewById(R.id.botaoVerificarId);
        textoResultado = (TextView) findViewById(R.id.textoResultadoId);

        botaoVerificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //recupera valores digitados
                String textoPrecoAlcool = precoAlcool.getText().toString();
                String textoPrecoGasolina = precoGasolina.getText().toString();

                if (!textoPrecoAlcool.equals("")  && !textoPrecoAlcool.isEmpty() && !textoPrecoGasolina.equals("")  && !textoPrecoGasolina.isEmpty()) {

                    //Converte valores string para numeros

                    Double valorAlcool = Double.parseDouble( textoPrecoAlcool );
                    Double valorGasolina = Double.parseDouble( textoPrecoGasolina );

                    //faz o calculo
                    double resultado = valorAlcool / valorGasolina;

                    if( resultado <= 0.7 ){
                        textoResultado.setText("É melhor utilizar Álcool ");
                        //Toast.makeText(MainActivity.this, "É melhor utilizar álcool", Toast.LENGTH_LONG).show();
                    }else{
                        textoResultado.setText("É melhor utilizar Gasolina ");
                        //Toast.makeText(MainActivity.this, "É melhor utilizar gasolina", Toast.LENGTH_LONG).show();
                    }

                }else{
                    Toast.makeText(MainActivity.this, "Preencha os campos", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}
