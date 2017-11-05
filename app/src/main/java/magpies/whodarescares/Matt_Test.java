package magpies.whodarescares;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.widget.Toolbar;
import android.view.View;

/**
 * Created by charl on 05/11/2017.
 */

public class Matt_Test {

    private boolean available;

    public void setAvailable(boolean available){
        this.available = available;
    }

    public boolean getAvailable() {
        return available;
    }

    public void returnAvailable(View view) {
        setAvailable(true);
        available();
    }

    public void returnUnavailable(View view) {
        setAvailable(false);
        available();
    }

    public int available(){
        if(getAvailable()){
            return 1;
        }
        else return 0;
    }
}

