package mycustom.com.dogorcatperson;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView seekbarTextView;
    private RadioGroup canineRadioGroup;
    private RadioButton canineRadioButton;
    private CheckBox checkBoxDog,checkBoxCat,checkBoxParrot;
    private RadioGroup droolRadioGroup;
    private RadioButton droolRadioButton;
    private int dogCount=0;
    private int catcount=0;
    private int parrotCount;
    private SeekBar resultSeekbar;
    private Button resultButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultSeekbar=findViewById(R.id.seekbarid);
        seekbarTextView=findViewById(R.id.cutenessid);
        resultSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekbarTextView.setText("comfortableness"+progress+"/"+seekBar.getMax());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        setUp();
    }
    public void setUp()
    {
        dogCount=0;
        catcount=0;
        parrotCount=0;

        canineRadioGroup=findViewById(R.id.radiogroupid);
        droolRadioGroup=findViewById(R.id.radiogroupDrool);
        checkBoxDog=findViewById(R.id.checkboxdog);
        checkBoxCat=findViewById(R.id.checkboxcat);
        checkBoxParrot=findViewById(R.id.checkboxparrot);
        resultButton=findViewById(R.id.ShowButtonid);
        resultButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this,ResultActivity.class);
             intent.putExtra("dog",dogCount);
               intent.putExtra("cat",catcount);
              intent.putExtra("parrot",parrotCount);
              startActivity(intent);processDrool(droolRadioGroup);
              cutest(checkBoxDog,checkBoxCat,checkBoxParrot);
               processcanines(canineRadioGroup);
//Toast.makeText(getApplicationContext(),catcount+"  "+dogCount,Toast.LENGTH_SHORT).show();
            }
        });

    }
    public void cutest(CheckBox dog,CheckBox cat, CheckBox parrot) {
        if (dog.isChecked() && !cat.isChecked() && !parrot.isChecked())
        {
        dogCount += 5;
    }else if(cat.isChecked() && !dog.isChecked()&&!parrot.isChecked()){
            catcount+=5;
        }



   }
   public void processDrool( final RadioGroup radioGroup)
   {
       radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
           @Override
           public void onCheckedChanged(RadioGroup group, int checkedId) {
              int radioId=radioGroup.getCheckedRadioButtonId();
              canineRadioButton=findViewById(radioId);
               if (canineRadioButton.getText().equals("YES"))
               {
                   catcount+=5;
               }
               if (canineRadioButton.getText().equals("NO"))
               {
                   dogCount=dogCount+5;
               }
           }
       });
   }
   public void processcanines(final RadioGroup radioGroup)
   {
       radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
           @Override
           public void onCheckedChanged(RadioGroup group, int checkedId) {
               int radioId=radioGroup.getCheckedRadioButtonId();
               droolRadioButton=findViewById(radioId);
               if (droolRadioButton.getText().equals("YES"))
               {
                   catcount=catcount+5;
               }
               if (droolRadioButton.getText().equals("NO"))
               {
                   dogCount=dogCount+5;
               }
           }
       });
   }
}
