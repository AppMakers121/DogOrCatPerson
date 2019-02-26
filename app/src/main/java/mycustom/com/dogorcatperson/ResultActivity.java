package mycustom.com.dogorcatperson;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    private TextView resultTextView;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        resultTextView=findViewById(R.id.resultTextView2);
        imageView=findViewById(R.id.imageView);
        Bundle extras=getIntent().getExtras();
        if(extras!=null)
        {
            int catResult=extras.getInt("cat");
            int dogResult=extras.getInt("dog");
            if(catResult>dogResult)
            {
                resultTextView.setText("cat person");
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.cat));
            }
            else if(dogResult>catResult)
            {
                resultTextView.setText("dog person");
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.dog));
            }
            else if(dogResult==catResult)
            {
                resultTextView.setText("neither");
            }
        }
    }
}
