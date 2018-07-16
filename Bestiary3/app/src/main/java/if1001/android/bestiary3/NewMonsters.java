package if1001.android.bestiary3;


import android.app.NotificationManager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.NotificationCompat;

import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;

public class NewMonsters extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    private DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
    private DatabaseReference monstroReference = databaseReference.child("Monstros");
    ArrayList<HashMap<String, String>> monsterList;
    private ListView lv;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_monsters);


        monsterList = new ArrayList<>();
        lv = (ListView) findViewById(R.id.lv_new_monsters);

        firebaseAuth = FirebaseAuth.getInstance();

        final ListAdapter adapter = new SimpleAdapter(
                NewMonsters.this, monsterList,
                R.layout.list_item, new String[]{"name", "type",
                "challenge_rating"}, new int[]{R.id.name,
                R.id.type, R.id.challenge_rating});

        lv.setAdapter(adapter);

        monstroReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {




                //limpando array
                monsterList.clear();

                //listando novos monstros
                for(DataSnapshot dados: dataSnapshot.getChildren()){
                    Monstro monstro = dados.getValue(Monstro.class);


                    //monstro unico
                    HashMap<String, String> monster = new HashMap<>();
                    monster.put("name", monstro.getName());
                    monster.put("size",monstro.getSize());
                    monster.put("type", monstro.getType());
                    monster.put("alignment",monstro.getAlignment());
                    monster.put("armor_class",monstro.getArmor_class());
                    monster.put("hit_points",monstro.getHit_points());
                    monster.put("hit_dice",monstro.getHit_dice());
                    monster.put("speed",monstro.getSpeed());
                    monster.put("strength",monstro.getStrength());
                    monster.put("dexterity",monstro.getDexterity());
                    monster.put("constitution",monstro.getConstitution());
                    monster.put("intelligence",monstro.getIntelligence());
                    monster.put("wisdom",monstro.getWisdom());
                    monster.put("charisma",monstro.getCharisma());
                    monster.put("languages",monstro.getLanguages());
                    monster.put("challenge_rating",monstro.getChallenge_rating());

                    monsterList.add(monster);

                }

                lv.setAdapter(adapter);

                lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view,
                                            int position, long id) {
                        Intent intent = new Intent(getApplicationContext(), ExibiMonstro.class);
                        intent.putExtra("name",monsterList.get(position).get("name"));
                        intent.putExtra("size",monsterList.get(position).get("size"));
                        intent.putExtra("type", monsterList.get(position).get("type"));
                        intent.putExtra("subtype",monsterList.get(position).get("subtype"));
                        intent.putExtra("alignment",monsterList.get(position).get("alignment"));
                        intent.putExtra("armor_class",monsterList.get(position).get("armor_class"));
                        intent.putExtra("hit_points",monsterList.get(position).get("hit_points"));
                        intent.putExtra("hit_dice",monsterList.get(position).get("hit_dice"));
                        intent.putExtra("speed",monsterList.get(position).get("speed"));
                        intent.putExtra("strength",monsterList.get(position).get("strength"));
                        intent.putExtra("dexterity",monsterList.get(position).get("dexterity"));
                        intent.putExtra("constitution",monsterList.get(position).get("constitution"));
                        intent.putExtra("intelligence",monsterList.get(position).get("intelligence"));
                        intent.putExtra("wisdom",monsterList.get(position).get("wisdom"));
                        intent.putExtra("charisma",monsterList.get(position).get("charisma"));
                        intent.putExtra("perception",monsterList.get(position).get("perception"));
                        intent.putExtra("languages",monsterList.get(position).get("languages"));
                        intent.putExtra("challenge_rating", monsterList.get(position).get("challenge_rating"));
                        startActivity(intent);
                    }
                });

                LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(new Intent("novo-monstro"));

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        fab = findViewById(R.id.fab_new_monster);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MonsterCreaterActivity.class);
                startActivity(intent);
            }
        });
    }




    private BroadcastReceiver onNotice = new BroadcastReceiver() {

        @Override
        public void onReceive(Context context, Intent intent) {
            // intent can contain anydata
            Log.d("sohail","onReceive called");
            Toast.makeText(getApplicationContext(),"Lista de monstro atualizada!",Toast.LENGTH_SHORT).show();


        }
    };
    protected void onResume() {
        super.onResume();
        IntentFilter iff= new IntentFilter("novo-monstro");
        LocalBroadcastManager.getInstance(this).registerReceiver(onNotice, iff);
    }
    protected void onPause() {
        super.onPause();
        LocalBroadcastManager.getInstance(this).unregisterReceiver(onNotice);
    }







    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_new_monsters, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if(id == R.id.Logout){
            firebaseAuth.signOut();
            Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
            startActivity(intent);
            return true;
        } else if(id == R.id.Monstros_base){
            Intent intent = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(intent);
            return true;
        }
        return true;
    }

}
