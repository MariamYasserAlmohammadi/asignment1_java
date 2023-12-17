package basics;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.basics.R;

public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
      Button button= (Button) findViewById(R.id.btn1);
  button.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
         openPostActivity();
      }
  });
    }
    public void openPostActivity(){
        Intent intent =new Intent(this ,PostActivity.class);
        startActivity(intent);
    }
}
