package com.example.acer.project_try;

import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Environment;

import java.io.File;

public class AudioSaving {
    private MediaRecorder recorder;
    private String OUTPUT_FILE;
    private MediaPlayer mediaPlayer;

    public void beginRecording() throws Exception {
        //OUTPUT_FILE = Environment.getExternalStorageDirectory() +"/audio.3gpp";
        ditchMediaRecorder();
        File outFile=new File(OUTPUT_FILE);
        if(outFile.exists())
            outFile.delete();

        recorder=new MediaRecorder();
        recorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        recorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
        recorder.setOutputFile(OUTPUT_FILE);
        recorder.prepare();
        recorder.start();
    }

    public void ditchMediaRecorder() {
        if(recorder!=null)
            recorder.release();
    }

    public void finishRecording() {
        if(recorder!=null)
            recorder.stop();
    }


    public void playRecording() throws Exception {
        ditchMediaplayer();
        mediaPlayer=new MediaPlayer();
        mediaPlayer.setDataSource(OUTPUT_FILE);
        mediaPlayer.prepare();
        mediaPlayer.start();

    }

    public void ditchMediaplayer() {
        if(mediaPlayer!=null){
            try{
                mediaPlayer.release();
            }catch(Exception e){
                e.printStackTrace();
            }
        }

    }

    public void stopRecording() {
        if(mediaPlayer!=null)
            mediaPlayer.stop();
    }
}
