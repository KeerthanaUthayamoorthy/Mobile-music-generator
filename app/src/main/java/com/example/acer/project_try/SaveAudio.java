package com.example.acer.project_try;

import android.app.Dialog;
import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Environment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import static android.view.WindowManager.*;

public class SaveAudio extends AppCompatActivity {
    private MediaPlayer mediaPlayer;
    private MediaRecorder recorder;
    private String OUTPUT_FILE;
    private Editable variable;
    public String name = "n";
//Random random ;
    //String RandomAudioFileName = "ABCDEFGHIJKLMNOP";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_audio);
        Button audio_name = (Button) findViewById(R.id.showdialog);
        final TextView display_text = (TextView) findViewById(R.id.userinputtext);
        audio_name.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                View view = (LayoutInflater.from(SaveAudio.this)).inflate(R.layout.activity_audio_name_input, null);
                AlertDialog.Builder alertBuilder = new AlertDialog.Builder(SaveAudio.this);
                alertBuilder.setView(view);
                final EditText userinput = (EditText) view.findViewById(R.id.userinput);

                //random = new Random();

                alertBuilder.setCancelable(true)
                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                display_text.setText(userinput.getText());
                                if (TextUtils.isEmpty(display_text.getText().toString())) {
                                    SimpleDateFormat timeStampFormat = new SimpleDateFormat(
                                            "yyyy-MM-dd-HH.mm.ss");
                                    OUTPUT_FILE = Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + "audio_" + timeStampFormat.format(new Date()) + ".mp4";
                                } else {
                                    OUTPUT_FILE = Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + display_text.getText().toString() + ".mp4";

                                }
                            }
                        });

                AlertDialog alertToShow = alertBuilder.create();     // to display keypad  automatically while dialogbox was called
                alertToShow.getWindow().setSoftInputMode(
                        LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
                alertToShow.show();
            }
        });


//        OUTPUT_FILE = Environment.getExternalStorageDirectory().getAbsolutePath() + "/" +
//                CreateRandomAudioFileName(5) + "AudioRecording.3gp";

        //OUTPUT_FILE =Environment.getExternalStorageDirectory().getAbsolutePath()+"/recorded_audio.3gp";

        //OUTPUT_FILE=Environment.getExternalStorageDirectory()+new StringBuilder(name).append("/audio.3gpp").toString();

    }
//    public String CreateRandomAudioFileName(int string){             // to create random file name for the audio storage
//        StringBuilder stringBuilder = new StringBuilder( string );
//        int i = 0 ;
//        while(i < string ) {
//            stringBuilder.append(RandomAudioFileName.
//                    charAt(random.nextInt(RandomAudioFileName.length())));
//
//            i++ ;
//        }
//        return stringBuilder.toString();
//    }


    public void buttonTapped(View view) {

        switch (view.getId()) {
            case R.id.startBtn:
                try {
                    beginRecording();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;

            case R.id.finishBtn:
                try {
                    finishRecording();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case R.id.playBtn:
                try {
                    playRecording();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case R.id.stopBtn:
                try {
                    stopRecording();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    public void beginRecording() throws Exception {

        ditchMediaRecorder();
        // File outFile=new File(OUTPUT_FILE);
        //if(outFile.exists())
        //outFile.delete();

        recorder = new MediaRecorder();
        recorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        recorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
        recorder.setOutputFile(OUTPUT_FILE);
        recorder.prepare();
        recorder.start();
    }

    public void ditchMediaRecorder() {
        if (recorder != null)
            recorder.release();
    }

    public void finishRecording() {
        if (recorder != null)
            recorder.stop();
    }


    public void playRecording() throws Exception {
        ditchMediaplayer();
        mediaPlayer = new MediaPlayer();
        mediaPlayer.setDataSource(OUTPUT_FILE);
        mediaPlayer.prepare();
        mediaPlayer.start();

    }

    public void ditchMediaplayer() {
        if (mediaPlayer != null) {
            try {
                mediaPlayer.release();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public void stopRecording() {
        if (mediaPlayer != null)
            mediaPlayer.stop();
    }

}
