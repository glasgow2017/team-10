package magpies.whodarescares;

/**
 * Created by marcus on 05/11/17.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;;

public class Web extends AppCompatActivity {


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_profile:
                    goToDashboard(); //FIXME
                    return true;
                case R.id.navigation_dashboard:
                    goToDashboard();
                    return true;
                case R.id.navigation_notifications:
                    goToWeb();
                    return true;
            }
            return false;
        }

    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.hamburger, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.navigation_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.web);

        WebView web = new WebView(this);

        WebSettings webSettings = web.getSettings();
        webSettings.setJavaScriptEnabled(true);
        setContentView(web);
        web = (WebView) findViewById(R.id.web);
        web.loadUrl("http://www.bbc.co.uk");
    }





    public void goToForm(View view) {
        Intent intent = new Intent(this, Form.class);
        startActivity(intent);
    }

    public void goToDashboard() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void goToWeb() {
        Intent intent = new Intent(this, Web.class);
        startActivity(intent);
    }


}
