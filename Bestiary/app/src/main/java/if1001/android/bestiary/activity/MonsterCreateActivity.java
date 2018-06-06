package if1001.android.bestiary.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import if1001.android.bestiary.R;

public class MonsterCreateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monster_create);
    }

    public void SalvarMonstro(View view){
        Toast.makeText(getApplicationContext(),"Salvo com Não sucesso",Toast.LENGTH_LONG).show();
    }

    public void AbrirMain(View view){
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
    }
}
