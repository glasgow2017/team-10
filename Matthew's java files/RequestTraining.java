

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;public class RequestTraining  {
   	
   protected void sendEmail() {
      Log.i("Send email", "");
      String[] TO = {""};
      String[] CC = {""};
      Intent emailIntent = new intent(emailIntent.ACTION_SEND);
      
      emailIntent.setData(Uri.parse("mailto:"));
      emailIntent.setType("text/plain");
      emailIntent.putExtra(emailIntent.EXTRA_EMAIL, TO);
      emailIntent.putExtra(emailIntent.EXTRA_CC, CC);
      emailIntent.putExtra(emailIntent.EXTRA_SUBJECT, "Your subject");
      emailIntent.putExtra(emailIntent.EXTRA_TEXT, "Email message goes here");
      
      try {
         startActivity(emailIntent.createChooser(emailIntent, "Send mail..."));
         finish();
         Log.i("Finished sending email...", "");
      } catch (android.content.ActivityNotFoundException ex) {
         Toast.makeText(MainActivity.this, "There is no email client installed.", Toast.LENGTH_SHORT).show();
      }
   }
}