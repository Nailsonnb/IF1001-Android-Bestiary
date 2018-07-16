package if1001.android.bestiary3;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MonsterCreaterActivity extends AppCompatActivity {

    FloatingActionButton fab;

    private static final String[] TYPE = new String[] {
            "Aberrations", "Beasts", "Celestials", "Constructs", "Dragons" , "Elementals",
            "Fey","Fiends","Giants","Humanoids","Monstrosities","Oozes","Plants","Undead"
    };

    private static final String[] Languagues = new String[] {
            "Common", "Dwarvish", "Elvish", "Giant", "Gnomish" , "Goblin",
            "Halfling","Orc","Abyssal","Celestial","Draconic","Deep Speech","Infernal","Primordial","Sylvan","Undercommon"
    };




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monster_creater);

        Spinner spinner = (Spinner) findViewById(R.id.creater_monster_size);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.monsters_size_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        Spinner spinnerando = (Spinner) findViewById(R.id.creater_monster_alignment);
        ArrayAdapter<CharSequence> adaptero = ArrayAdapter.createFromResource(this,
                R.array.monsters_alignment_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerando.setAdapter(adaptero);

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, TYPE);
        AutoCompleteTextView textView = (AutoCompleteTextView)
                findViewById(R.id.creater_monster_type);
        textView.setAdapter(adaptador);

        ArrayAdapter<String> adaptando = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, Languagues);
        AutoCompleteTextView textaoView = (AutoCompleteTextView)
                findViewById(R.id.creater_monster_languagues);
        textaoView.setAdapter(adaptando);

        fab = findViewById(R.id.SaveButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText name = findViewById(R.id.creater_monster_name);
                Spinner size = findViewById(R.id.creater_monster_size);
                AutoCompleteTextView type = findViewById(R.id.creater_monster_type);
                Spinner alignment = findViewById(R.id.creater_monster_alignment);
                EditText armor_class = findViewById(R.id.creater_monster_armor_class);
                EditText hit_points = findViewById(R.id.creater_monster_hit_points);
                EditText hit_dice = findViewById(R.id.creater_monster_hit_dice);
                EditText speed = findViewById(R.id.creater_monster_speed);
                EditText strength = findViewById(R.id.creater_monster_strengh);
                EditText dexterity  = findViewById(R.id.creater_monster_dexterity);
                EditText constitution = findViewById(R.id.creater_monster_constitution);
                EditText intelligence = findViewById(R.id.creater_monster_intelligence);
                EditText wisdom = findViewById(R.id.creater_monster_wisdom);
                EditText charisma = findViewById(R.id.creater_monster_charisma);
                EditText languagues = findViewById(R.id.creater_monster_languagues);
                EditText challenge_rating = findViewById(R.id.creater_monster_challenge_rating);

                if(name.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(),"Digite um nome:",Toast.LENGTH_LONG).show();
                }else {

                    Intent createrMonsterViaService = new Intent(getApplicationContext(), CreaterMonsterViaService.class);
                    createrMonsterViaService.putExtra("name", name.getText().toString());
                    createrMonsterViaService.putExtra("size", size.getSelectedItem().toString());
                    createrMonsterViaService.putExtra("type", type.getText().toString());
                    createrMonsterViaService.putExtra("alignment", alignment.getSelectedItem().toString());
                    createrMonsterViaService.putExtra("armor_class", armor_class.getText().toString());
                    createrMonsterViaService.putExtra("hit_points", hit_points.getText().toString());
                    createrMonsterViaService.putExtra("hit_dice", hit_dice.getText().toString());
                    createrMonsterViaService.putExtra("speed", speed.getText().toString());
                    createrMonsterViaService.putExtra("strength", strength.getText().toString());
                    createrMonsterViaService.putExtra("dexterity", dexterity.getText().toString());
                    createrMonsterViaService.putExtra("constitution", constitution.getText().toString());
                    createrMonsterViaService.putExtra("intelligence", intelligence.getText().toString());
                    createrMonsterViaService.putExtra("wisdom", wisdom.getText().toString());
                    createrMonsterViaService.putExtra("charisma", charisma.getText().toString());
                    createrMonsterViaService.putExtra("languagues", languagues.getText().toString());
                    createrMonsterViaService.putExtra("challenge_rating", challenge_rating.getText().toString());
                    startService(createrMonsterViaService);


                    Intent intent = new Intent(getApplicationContext(), NewMonsters.class);
                    startActivity(intent);
                }
            }
        });

    }

    public void SalvarMonstro(View view){
        Toast.makeText(getApplicationContext(),"Salvo com Não sucesso",Toast.LENGTH_LONG).show();
    }

    public void AbrirMain(View view){
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
    }
}
