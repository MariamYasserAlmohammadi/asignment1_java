package basics;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.basics.R;
// static class -> can access class by its name
// layoutInflater -> create view
//R -> res class
public class SplashActivity extends AppCompatActivity
        implements View.OnClickListener {
    Button categoriesButton ;
    Button calculatorScreenButton;
    Button gameButton;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        // view created then instatiate button
        categoriesButton =findViewById(R.id.btn_categories);
        //categoriesButton.setTextColor(0xFFFF0000);
        gameButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startGame();
            }
        });
        // anonymous object -> don't have name and no reference for this object
        // this is reference for object not class

        categoriesButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

            }
        });
      //  categoriesButton.setOnClickListener(this);
        calculatorScreenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startCalculatorActivity();
            }
        });

    }

    private void startGame() {
        Intent intent=new Intent(this , XOGameActivity.class);
        startActivity(intent);
    }

    private void startCalculatorActivity() {
        Intent intent =new Intent( this, CalculatorActivity.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btn_categories){
            // OP controls in activity life cycle
            // class context is the parent of activity
            // intent -> نيه explicit intent واضح و صريح
            //implicit intent مش عارف انا رايح فين
            // give me options
            // intent can take parameters

            Intent intent =new Intent(this, HomeActivity.class);
            startActivity(intent);
        }
        else if (v.getId() == R.id.btn_login) {

        }
        // Activities put in Stack
        // Activity launched
        // - onCreate() -> Activity not visible
        // - onStart()  -> Activity is visible but user cant interact with it
        // - onResume() -> once onResume end user can interact with Activity
        // Activity running -> user can interact with it
        // - onPause() -> another activity comes into the foreground|| (interrupts) call through playing game
        // - onStop() -> the activity is no longer visible or the Activity is finishing
        // - onDestroy -> finish();

    }

    // Log (logger) use print data to debug code
    // verbose - info - debug - warning - error -assert
    // we use only error

}
