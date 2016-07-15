package com.example.downloadread;

import java.io.File;
import java.io.IOException;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends Activity {

    private static final int PROGRESS = 0x1;

    private ProgressBar mProgress;
    private int mProgressStatus = 0;

    Button viewButton;
    Button downloadButton;

    private Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mProgress = (ProgressBar) findViewById(R.id.progressBar);
        viewButton = (Button) findViewById(R.id.button2);
        downloadButton = (Button) findViewById(R.id.button1);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void download(View v)
    {
        new DownloadFile().execute("http://media.ldscdn.org/pdf/magazines/liahona-june-2016/2016-06-03-our-father-our-mentor-eng.pdf", "2016-06-03-our-father-our-mentor-eng.pdf");
        mProgress.setVisibility(View.VISIBLE);
        viewButton.setEnabled(true);
        viewButton.setVisibility(View.VISIBLE);
        viewButton.setClickable(true);
       // mProgress.setVisibility(View.INVISIBLE);
        downloadButton.setVisibility(View.INVISIBLE);
       new Thread(new Runnable() {
            public void run() {
                while (mProgressStatus < 101) {
                    // mProgressStatus = doWork();
                    //Update the progress bar
                    mHandler.post(new Runnable() {
                        public void run() {
                            mProgress.setProgress(mProgressStatus);
                        }
                    });
                    mProgressStatus++;
                    android.os.SystemClock.sleep(20);
                }
            }
        }).start();

      //  viewButton.setVisibility(View.VISIBLE);
      //  viewButton.setEnabled(true);
      //  viewButton.setClickable(true);
    }

    public void view(View v)
    {
        mProgress.setVisibility(View.INVISIBLE);
        //reset download bar
        mProgressStatus = 0;
        mHandler.post(new Runnable() {
            public void run() {
                mProgress.setProgress(mProgressStatus);
            }
        });

        File pdfFile = new File(Environment.getExternalStorageDirectory() + "/testthreepdf/" + "2016-06-03-our-father-our-mentor-eng.pdf");
        Uri path = Uri.fromFile(pdfFile);
        Intent pdfIntent = new Intent(Intent.ACTION_VIEW);
        pdfIntent.setDataAndType(path, "application/pdf");
        pdfIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        try{
            startActivity(pdfIntent);
        }catch(ActivityNotFoundException e){
            Toast.makeText(MainActivity.this, "No Application available to view PDF", Toast.LENGTH_SHORT).show();
        }
    }




    private class DownloadFile extends AsyncTask<String, Void, Void>{

        @Override
        protected Void doInBackground(String... strings) {
            String fileUrl = strings[0];
            String fileName = strings[1];  
            String extStorageDirectory = Environment.getExternalStorageDirectory().toString();
            File folder = new File(extStorageDirectory, "testthreepdf");
            folder.mkdir();

            File pdfFile = new File(folder, fileName);

            try{
                pdfFile.createNewFile();
            }catch (IOException e){
                e.printStackTrace();
            }
            FileDownloader.downloadFile(fileUrl, pdfFile);
            return null;
        }
    }


}
