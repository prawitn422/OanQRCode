package oansweety.cpn.co.th.oanqrcode;

import android.content.res.Configuration;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.ToolbarWidgetWrapper;
import android.util.Log;
import android.view.MenuItem;

import oansweety.cpn.co.th.oanqrcode.fragment.ShowAllFragment;

public class ServiceActivity extends AppCompatActivity {

    //Explicit
    private String tag = "12MacrchV1";
    private String[] loginStrings;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
        //Get Value From Intent
        getValueFromIntent();


        //Create Toolbar

        createToolbar();

       // add fragment to activiry

        if (savedInstanceState == null ) {
            getSupportFragmentManager().beginTransaction().add(R.id.contentServiceFragment,new ShowAllFragment())
                    .commit();
        }

    } // main method

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return  true;
        }
        return super.onOptionsItemSelected(item);

    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        actionBarDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        actionBarDrawerToggle.syncState();
    }



    private void createToolbar() {

        Toolbar toolbar = findViewById(R.id.toolbarService);
        setSupportActionBar(toolbar);
        //Setup Title
        getSupportActionBar().setTitle("My Prawit");
        getSupportActionBar().setSubtitle(loginStrings[1]);
        getSupportActionBar().setHomeButtonEnabled(true );
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //create hamberger toolbar
        drawerLayout = findViewById(R.id.drawerLayout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(ServiceActivity.this,
                drawerLayout,R.string.open,R.string.close);

        drawerLayout.setDrawerListener(actionBarDrawerToggle);
    }

    private void getValueFromIntent() {
        loginStrings = getIntent().getStringArrayExtra("Login");
        Log.d(tag,"NameLogin ==>" + loginStrings[1]);
    }
} //Main
