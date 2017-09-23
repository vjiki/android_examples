package fr.centralesupelec.galtier.block01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // the 2 buttons defined in the activity_main.xml file
    Button buttonBlue, buttonPink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // display the GUI defined in the activity_main.xml file
        setContentView(R.layout.activity_main);

        // retrieve references to the Views defined in the activity_main.xml
        buttonBlue = (Button) findViewById(R.id.button_blueInvisible);
        buttonPink = (Button) findViewById(R.id.button_pinkPanther);
    }

    /**
     * called when a button from activity_main.xml is clicked
     * @param v the View which triggered the method call: should refer to buttonBlue or buttonPink
     */
    public void toDo(View v) {
        if (v.equals(buttonBlue))
            // buttonBlue was clicked
            // turn the button invisible
            v.setVisibility(View.INVISIBLE);
        if (v.equals(buttonPink))
            // buttonPink was clicked
            // display a pop-up message for a short duration
            Toast.makeText(getApplicationContext(),
                    "to do to do to do...",
                    Toast.LENGTH_SHORT).show();
    }
}
