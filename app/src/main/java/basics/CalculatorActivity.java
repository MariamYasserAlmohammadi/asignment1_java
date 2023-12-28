package basics;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.basics.R;
 // xml is a markup language cant contain fun only contain design
public class CalculatorActivity extends AppCompatActivity {
    TextView resultTV;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        resultTV=findViewById(R.id.tv_result);
    }
    public void onDigitClick(View view){
        Button btn = ((Button) view);
        resultTV.setText(btn.getText());
    }
    String savedNum ="";
    String savedOperator ="";
    public void onOperatorClick(View view){
       Button clickedOperator =  ((Button) view);
        if(savedOperator.isEmpty()){
            savedNum=resultTV.getText().toString();
            // gettext return charSequence ,charSequence is parent class of String
        }else{
            String rhs =resultTV.getText().toString();
           String res = calculate(savedNum ,savedOperator,rhs);
           savedNum=res;
        }
        savedOperator=clickedOperator.getText().toString();
        resultTV.setText("");
    }

    public  void onEqualClick(View view){
        String rhs =resultTV.getText().toString();
        String res =calculate(savedNum ,savedOperator,rhs);
        resultTV.setText(res);
        savedOperator="";
        savedNum="";
    }

    private String calculate(String lhs, String operator, String rhs) {
        double n1 =Double.parseDouble(lhs);
        double n2 =Double.parseDouble(lhs);
        double res=0;
        if ( "+".equals(operator)) {
            res = n1 + n2;
        } else if ("-".equals(operator)) {
            res = n1 - n2;
        }else if ("/".equals(operator)) {
            res = n1 / n2;
        }else if ("*".equals(operator)) {
            res = n1 * n2;
        }
        return res+"";
    }
}
