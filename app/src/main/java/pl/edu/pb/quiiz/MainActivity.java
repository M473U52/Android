package pl.edu.pb.quiiz;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private Button trueButton;
    private Button falseButton;
    private Button nextButton;
    private TextView questionTextView;
    private int currentIndex = 0;
    private Question[] questions = new Question[]
            {
                new Question(R.string.q_activity,  true),
                new Question(R.string.q_find_resources,  false),
                new Question(R.string.q_listener,  true),
                new Question(R.string.q_resources,  true),
                new Question(R.string.q_version,  false)
            };
    private void checkAnswerCorrectness(boolean userAnswer)
    {
        boolean correctAnswer = questions[currentIndex].istrueAnswer();
        int resultMessageId = 0;
        if (userAnswer ==correctAnswer){
            resultMessageId = R.string.correct_answer;
        }else{
            resultMessageId=R.string.incorrect_answer;
        }
        Toast.makeText( this,resultMessageId, Toast.LENGTH_SHORT).show();
    }
    private void setNextQuestion(){
        questionTextView.setText(questions[currentIndex].getQuestionId());
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        trueButton = findViewById(R.id.true_button);
        falseButton = findViewById(R.id.false_button);
        nextButton = findViewById(R.id.next_button);
        setNextQuestion();

        trueButton.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View v)
            {
                checkAnswerCorrectness (true);
            }
        });
        falseButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                checkAnswerCorrectness (false);
            }
        });
        nextButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                currentIndex = (currentIndex+1)%questions.length;
                setNextQuestion();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart");
    }
}