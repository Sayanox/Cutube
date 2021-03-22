package com.example.cutube.controller;

import android.app.DownloadManager;
import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.cutube.R;

import at.huber.youtubeExtractor.YouTubeUriExtractor;
import at.huber.youtubeExtractor.YtFile;


public class UrlActivity extends AppCompatActivity {

    String downloadLink="";//ici le lien de video qu'est recupere'
    String newLink;
    EditText urlBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_url);
        Button button =findViewById(R.id.min_activity_mp4_btn);
        urlBox=findViewById(R.id.url_activity_EditText);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newLink=urlBox.getText().toString().trim();
               downloadLink=newLink;
                YouTubeUriExtractor youTubeUriExtractor=new YouTubeUriExtractor(UrlActivity.this) {
                    @Override
                    public void onUrisAvailable(String videoId, String videoTitle, SparseArray<YtFile> ytFiles) {

                        if(ytFiles!=null){
                            Toast.makeText(UrlActivity.this, "Téléchargement en cours", Toast.LENGTH_SHORT).show();

                            int tag=22;
                            newLink=ytFiles.get(tag).getUrl();
                            String title="vidéo téléchargé par CuTube";
                            DownloadManager.Request request=new DownloadManager.Request(Uri.parse(newLink));
                            request.setTitle(title);
                            request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS,title+".mp4");
                            DownloadManager downloadManager=(DownloadManager)getSystemService(Context.DOWNLOAD_SERVICE);
                            request.allowScanningByMediaScanner();
                            request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_MOBILE | DownloadManager.Request.NETWORK_WIFI);
                            downloadManager.enqueue(request);

                        }

                    }
                };

                youTubeUriExtractor.execute(downloadLink);

            }
        });
}}