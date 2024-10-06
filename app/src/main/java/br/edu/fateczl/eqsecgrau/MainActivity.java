/*
    Nome:   Éden Vieira Brito
    RA:     1110482213006
*/

package br.edu.fateczl.eqsecgrau;

import static java.lang.Math.sqrt;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText etA;

    private EditText etB;

    private EditText etC;

    //private Button btnCalc;

    private TextView tvRes1;

    private TextView tvRes2;

    private TextView tvAviso;

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

        etA = findViewById(R.id.etA);
        etA.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);
        etB = findViewById(R.id.etB);
        etB.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);
        etC = findViewById(R.id.etC);
        etC.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);
        tvRes1 = findViewById(R.id.tvRes1);
        tvRes1.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);
        tvRes2 = findViewById(R.id.tvRes2);
        tvRes2.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);
        tvAviso = findViewById(R.id.tvAviso);
        tvAviso.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);
        Button btnCalc = findViewById(R.id.btnCalc);

        btnCalc.setOnClickListener(op -> calc());//Chamada para o botão receber a função calc
    }
    //O botão deve acionar esse procedimento
    private void calc() {
        tvAviso.setText(""); // garantindo que será mostrado somente o que se deseja ver
        tvRes1.setText("");
        tvRes2.setText("");
        int aaa = Integer.parseInt(etA.getText().toString());
        int bbb = Integer.parseInt(etB.getText().toString());
        int ccc = Integer.parseInt(etC.getText().toString());
        double delta = (bbb*bbb)-4*aaa*ccc;
        if (delta>=0) {
            double x1 = (-bbb + sqrt(delta)) / 2 * aaa;
            double x2 = (-bbb - sqrt(delta)) / 2 * aaa;
            String resX1 = getString(R.string.x1) + " " + x1;//String que monta o texto que aparecerá no TextView ou no EditText
            String resX2 = getString(R.string.x2) + " " + x2;//String que monta o texto que aparecerá no TextView ou no EditText
            tvRes1.setText(resX1);              //forma de colocar texto no TextView ou no EditText
            tvRes2.setText(resX2);              //forma de colocar texto no TextView ou no EditText
        }else {
            String aviso = ("Delta não possui raízes!");
            tvAviso.setText(aviso);
        }
        etA.setText(""); //limpar a tela
        etB.setText("");
        etC.setText("");
    }
}
