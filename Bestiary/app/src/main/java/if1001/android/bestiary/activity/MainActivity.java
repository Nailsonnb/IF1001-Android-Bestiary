package if1001.android.bestiary.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import if1001.android.bestiary.R;

public class MainActivity extends AppCompatActivity {

    private ListView listaItens;
    private String[] itens = {"Bear","Black Bear","Wolf","Winter Wolf","Skeleton","Ghoul","Young Red Dragon","Minotaur","Dark Aparentice","The Doctor"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaItens = findViewById(R.id.listViewId);

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(
                getApplicationContext(),
                android.R.layout.simple_list_item_2,
                android.R.id.text1,
                itens
        );

        listaItens.setAdapter(adaptador);
    }

    public void AbrirMonstroCreater(View view){
        Intent intent = new Intent(getApplicationContext(),MonsterCreateActivity.class);
        startActivity(intent);
    }
}
