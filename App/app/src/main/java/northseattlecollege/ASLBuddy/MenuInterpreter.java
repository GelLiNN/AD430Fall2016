package northseattlecollege.ASLBuddy;

import android.content.Intent;
import android.content.SharedPreferences;
import android.location.Location;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

/**
 * Author: Nathan Flint
 * Created 10/10/2016
 */

public class MenuInterpreter extends AppCompatActivity {

    private SharedPreferences mPrefs;
    private Switch videoSwitch, locationSwitch;
    public InterpreterStatus status;
    private LocationService locationService;
    private Location location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_interpreter);

        Button backButton = (Button) findViewById(R.id.back);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                Intent navigationIntent = new Intent(MenuInterpreter.this, LoginActivity.class);
                MenuInterpreter.this.startActivity(navigationIntent);
            }
        });
        videoSwitch = (Switch)findViewById(R.id.videoSwitch);
        locationSwitch = (Switch)findViewById(R.id.locationSwitch);

        //getting the status from the database here in the separate class
        status = new InterpreterStatus();

        locationService = new LocationService(this);
    }

    public void SetLocation(Location location) {
        this.location = location;
    }
}
