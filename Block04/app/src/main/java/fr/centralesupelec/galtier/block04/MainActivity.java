package fr.centralesupelec.galtier.block04;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    MediaPlayer pianoMusic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // display the GUI defined in the activity_main.xml file
        setContentView(R.layout.activity_main);

        // create a player ready to play the piano.mp3 file from the res/raw folder
        pianoMusic = MediaPlayer.create(this, R.raw.piano);

        // retrieve a reference to the switch View defined in the activity_main.xml
        Switch switch_looping = (Switch) findViewById(R.id.switch_looping);

        // attach a listener to the switch to control the looping mode of the music player
        switch_looping.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                pianoMusic.setLooping(isChecked);
            }
        });
    }

    /**
     *  called when the play button defined in activity_main.xml is clicked
     *  start (or resume) the music playback
     * @param v the View which triggered the method call: should refer to button_play
     */
    public void playMusic (View v) {
        pianoMusic.start();
    }

    /**
     *  called when the pause button defined in activity_main.xml is clicked
     *  pause the music playback
     * @param v the View which triggered the method call: should refer to button_pause
     */
    public void pauseMusic (View v) {
        if(pianoMusic.isPlaying())
            pianoMusic.pause();
    }

    /**
     * good practice: release allocated resources when they are no longer of use
     */
    @Override
    protected void onPause() {
        super.onPause();
        pianoMusic.release();
    }
}
