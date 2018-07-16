package if1001.android.bestiary3;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CreaterMonsterViaService extends IntentService {
    private DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
    private DatabaseReference monsterReference = databaseReference.child("Monstros");

    public CreaterMonsterViaService(String name) {
        super(name);
    }

    public CreaterMonsterViaService(){
        super("CreaterMonsterViaService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

        Monstro monstro = new Monstro();
        monstro.setName(intent.getStringExtra("name"));
        monstro.setSize(intent.getStringExtra("size"));
        monstro.setType(intent.getStringExtra("type"));
        monstro.setAlignment(intent.getStringExtra("alignment"));
        monstro.setArmor_class(intent.getStringExtra("armor_class"));
        monstro.setHit_points(intent.getStringExtra("hit_points"));
        monstro.setHit_dice(intent.getStringExtra("hit_dice"));
        monstro.setSpeed(intent.getStringExtra("speed"));
        monstro.setStrength(intent.getStringExtra("strength"));
        monstro.setDexterity(intent.getStringExtra("dexterity"));
        monstro.setConstitution(intent.getStringExtra("constitution"));
        monstro.setIntelligence(intent.getStringExtra("intelligence"));
        monstro.setWisdom(intent.getStringExtra("wisdom"));
        monstro.setCharisma(intent.getStringExtra("charisma"));
        monstro.setLanguages(intent.getStringExtra("languagues"));
        monstro.setChallenge_rating(intent.getStringExtra("challenge_rating"));
        monsterReference.child(intent.getStringExtra("name")).setValue(monstro);
        Toast.makeText(getApplicationContext(),"Monstro Criado com sucesso!",Toast.LENGTH_SHORT).show();




    }
}
