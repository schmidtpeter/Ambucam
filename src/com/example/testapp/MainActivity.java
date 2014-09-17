package com.example.testapp;

import com.example.testapp.PanAndZoomListener.Anchor;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Context;
import android.net.Uri;
import android.widget.FrameLayout;
import android.widget.MediaController;
import android.widget.VideoView;



public class MainActivity extends ActionBarActivity {
	
//	String vidAddress = "http://eyead.itsol.dk/movie.mp4";
	String vidAddress = "rtmp://54.77.202.131/live/pi55";
	Uri vidUri = Uri.parse(vidAddress); 

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//       setContentView(R.layout.activity_main);
        
        FrameLayout view = new FrameLayout(this);
        FrameLayout.LayoutParams fp = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT, Gravity.CENTER);
        
        setContentView(view);
        
//        VideoView videoView = (VideoView) findViewById(R.id.myVideo); 
        
        VideoView videoView = new VideoView(this);
        view.addView(videoView, fp);
        view.setOnTouchListener(new PanAndZoomListener(view, videoView, Anchor.CENTER));
        
        
        videoView.setVideoURI(vidUri);
        MediaController vidControl = new MediaController(this);
        vidControl.setAnchorView(videoView); 
        videoView.setMediaController(vidControl);
        videoView.setOnTouchListener(new PanAndZoomListener(view, videoView, Anchor.CENTER) );
        videoView.start();
        
       
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
