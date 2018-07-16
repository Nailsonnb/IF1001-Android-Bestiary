package if1001.android.bestiary3;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class CadastroActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    private EditText email;
    private EditText senha;
    private Button cadastro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        getSupportActionBar().hide();

        email = findViewById(R.id.emailCadastro);
        senha = findViewById(R.id.senhaCadastro);
        cadastro = findViewById(R.id.buttonCadastrar);
        firebaseAuth = FirebaseAuth.getInstance();

        cadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //cadastrando
                firebaseAuth.createUserWithEmailAndPassword(email.getText().toString(),senha.getText().toString())
                        .addOnCompleteListener(CadastroActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful()){
                                    Log.i("cadastro usuario: ","sucesso ao cadastrar usuario");
                                    Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                                    startActivity(intent);
                                } else {
                                    Log.i("cadastro usuario: ","erro ao cadastrar usuario");
                                    Toast.makeText(getApplicationContext(),"erro ao cadastrar usuario",Toast.LENGTH_LONG).show();
                                }

                            }
                        });
                //cadastrado
            }
        });



    }

    public void AbrirLogin(View view){
        Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
        startActivity(intent);
    }

    public void ConcluirCadastro(View view){
        Toast.makeText(getApplicationContext(),"Cadastro Criado com não sucesso",Toast.LENGTH_LONG).show();
        Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
        startActivity(intent);
    }
}
