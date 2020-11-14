package matejpersic_dz1.ferit.hr;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    //declaration of all parameters used for solving the problem, app tested on Pixel 3a (AVD) and Huawei P20 lite
    TextView person1;
    TextView person2;
    TextView person3;
    ImageView iwPerson1;
    ImageView iwPerson2;
    ImageView iwPerson3;
    RadioButton rbPerson1;
    RadioButton rbPerson2;
    RadioButton rbPerson3;
    EditText etNewDescription;
    Button btnEditInspiration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
    }
    void initialize(){
        //method for initializing all the parameters used for this homework
        person1=(TextView)findViewById(R.id.twPerson1Inspirational);
        person2=(TextView)findViewById(R.id.twPerson2Inspirational);
        person3=(TextView)findViewById(R.id.twPerson3Inspirational);

        iwPerson1=(ImageView)findViewById(R.id.person1Image);
        iwPerson2=(ImageView)findViewById(R.id.person2Image);
        iwPerson3=(ImageView)findViewById(R.id.person3Image);

        rbPerson1=(RadioButton)findViewById(R.id.rbFirstPerson);
        rbPerson2=(RadioButton)findViewById(R.id.rbSecondPerson);
        rbPerson3=(RadioButton)findViewById(R.id.rbThirdPerson);

        etNewDescription=(EditText)findViewById(R.id.etNewDescription);
        btnEditInspiration=(Button)findViewById(R.id.btnEditInspiration);
    }

    public void person1OnClick(View view) {
        //when the picture is pressed, set the image resource to transparent so the picture is invisible
        iwPerson1.setImageResource(android.R.color.transparent);
    }

    public void person2OnClick(View view) {
        iwPerson2.setImageResource(android.R.color.transparent);
    }

    public void person3OnClick(View view) {
        iwPerson3.setImageResource(android.R.color.transparent);
    }

    public void btnInspirationOnClick(View view) {
        //generating random facts about inspiring people is solved by saving all of the facts in an array and by generating
        //a random index, a random fact is found, which is shown to the end user as a Toast message
        String[] inspirations={getResources().getString(R.string.person1InspirationGen),
                getResources().getString(R.string.person2InspirationGen),
                getResources().getString(R.string.person3InspirationGen)};
        int i = new Random().nextInt(inspirations.length);
        Toast.makeText(this,inspirations[i],Toast.LENGTH_LONG).show();
    }

    public void btnEditInspirationOnClick(View view) {
        //when the button Edit Inspirations is pressed, check if EditText above is null, if not, set it as a description
        //of the image which the clicked radio button(if any) corresponds to
        String editTextDescription=etNewDescription.getText().toString();
        if(editTextDescription.isEmpty()) {
            if (rbPerson1.isChecked()) {
                person1.setText(editTextDescription);
            }
            if (rbPerson2.isChecked()) {
                person2.setText(editTextDescription);
            }
            if (rbPerson3.isChecked()) {
                person3.setText(editTextDescription);
            }
        }
    }
}