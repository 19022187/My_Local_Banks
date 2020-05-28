package sg.edu.rp.c346.id19022187.mylocalbanks;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tvDbs, tvOcbc, tvUob;
    String bankClicked = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDbs = findViewById(R.id.textViewDBS);
        tvOcbc = findViewById(R.id.textViewOCBC);
        tvUob = findViewById(R.id.textViewUOB);
        registerForContextMenu(tvDbs);
        registerForContextMenu(tvOcbc);
        registerForContextMenu(tvUob);

    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(0,0,0,"Website");
        menu.add(0,1,1,"Contact the Bank");

        if (v.getId() == tvDbs.getId()){
            bankClicked = "DBS";
        }
        else if (v.getId() == tvOcbc.getId()){
            bankClicked = "OCBC";
        }
        else{
            bankClicked = "UOB";
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if(item.getItemId() == 0) { //check whether the selected menu item ID is 0
            // code for action
            if (bankClicked.equals("DBS")){
                Toast.makeText(MainActivity.this, "View Website", Toast.LENGTH_SHORT).show();
                Intent intentCall = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.dbswebsite)));
                startActivity(intentCall);
            }
            else if (bankClicked.equals("OCBC")){
                Toast.makeText(MainActivity.this, "View Website", Toast.LENGTH_SHORT).show();
                Intent intentCall = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.ocbcwebsite)));
                startActivity(intentCall);
            }
            else {
                Toast.makeText(MainActivity.this, "View Website", Toast.LENGTH_SHORT).show();
                Intent intentCall = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.uobwebsite)));
                startActivity(intentCall);
            }

            return true; //menu item successfully handled
        }
        else if(item.getItemId() == 1) { //check if the selected menu item ID is 1
            // code for action
            if (bankClicked.equals("DBS")){
                Toast.makeText(MainActivity.this, "Contacting the Bank", Toast.LENGTH_SHORT).show();
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: " + getString(R.string.dbsnum)));
                startActivity(intentCall);
            }
            else if (bankClicked.equals("DBS")){
                Toast.makeText(MainActivity.this, "Contacting the Bank", Toast.LENGTH_SHORT).show();
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: " + getString(R.string.ocbcnum)));
                startActivity(intentCall);
            }
            else {
                Toast.makeText(MainActivity.this, "Contacting the Bank", Toast.LENGTH_SHORT).show();
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: " + getString(R.string.uobnum)));
                startActivity(intentCall);
            }
            return true;  //menu item successfully handled
        }
        return super.onContextItemSelected(item); //pass menu item to the superclass implementation
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.menuEnglish) {
            tvDbs.setText(getString(R.string.dbs));
            tvOcbc.setText(getString(R.string.ocbc));
            tvUob.setText(getString(R.string.uob));
        }
        if (item.getItemId() == R.id.menuChinese) {
            tvDbs.setText(getString(R.string.chiDbs));
            tvOcbc.setText(getString(R.string.chiOcbc));
            tvUob.setText(getString(R.string.chiUob));
        }
        return super.onOptionsItemSelected(item);
    }
}
