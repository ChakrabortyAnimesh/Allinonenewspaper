package com.trending.news.allinonenewspaper;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private ImageView anandabazar;
    private ImageView abela;
    private ImageView present;
    private ImageView aisamy;
    private ImageView ajkal;
    private ImageView everyday;
    private ImageView gonosakte;
    private ImageView karma;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inisializeView();
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
       toolbar.setTitle("Bengali News Papers");
       // getSupportActionBar().setDisplayShowTitleEnabled(false);
    }

    private void inisializeView() {
        anandabazar = findViewById(R.id.anandabazar);
        abela = findViewById(R.id.abela);
        present = findViewById(R.id.present);
        aisamy = findViewById(R.id.aisamay);
        ajkal = findViewById(R.id.ajkal);
        everyday = findViewById(R.id.everyday);
        gonosakte = findViewById(R.id.gonosakte);
        karma = findViewById(R.id.karma);
    }

    private void sendToWebViewActivity(String url) {
        Intent intent = new Intent(MainActivity.this, WebViewActivity.class);
        intent.putExtra("url", url);
        startActivity(intent);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_share:
                shareit();
                return true;
            case R.id.item_rate:
                Toast.makeText(this, "Thanks for rate us", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://play.google.com/store/apps/details?id=com.trending.news.allinonenewspaper"));
                startActivity(intent);
                return true;
            case R.id.item_moreapps:
                Toast.makeText(this, "pass intent", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    private void shareit() {
        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "All in one News -");
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, "Hey! Check out this app All in one news 2018 app!https://play.google.com/store/apps/details?id=com.trending.news.allinonenewspaper");
        startActivity(Intent.createChooser(sharingIntent, "Share via"));
    }


    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == android.view.KeyEvent.KEYCODE_BACK) {
            exitByBackKey();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    protected void exitByBackKey() {
        AlertDialog alertbox = new AlertDialog.Builder(this)
                .setCancelable(false)
                .setTitle("Exit?")
                .setMessage("Do you really want to exit this application?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface arg0, int arg1) {
                        finish();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {

                    // do something when the button is clicked
                    public void onClick(DialogInterface arg0, int arg1) {

                    }
                })
                .show();
    }

    //region all onClicks
    public void gotoWebViewActivity(View view) {
        switch (view.getId()) {
            case R.id.anandabazar:
                sendToWebViewActivity("https://www.anandabazar.com");
                break;
            case R.id.abela:
                sendToWebViewActivity("https://ebela.in");
                break;
            case R.id.aisamay:
                sendToWebViewActivity("https://eisamay.indiatimes.com");
                break;
            case R.id.ajkal:
                sendToWebViewActivity("https://aajkaal.in");
                break;
            case R.id.gonosakte:
                sendToWebViewActivity("http://ganashakti.com/");
                break;
            case R.id.present:
                sendToWebViewActivity("http://www.bartamanpatrika.com");
                break;
            case R.id.everyday:
                sendToWebViewActivity("http://www.sangbadpratidin.in");
                break;
            case R.id.karma:
                sendToWebViewActivity("https://www.karmasandhan.com");
                break;
            default:
                break;
        }
    }
    //endregion
}
