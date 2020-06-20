package com.example.guesswhat;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnGuess;
    EditText etGuess;
    TextView tvResult,tvDesc;
    String result;
    char [] resultArray;
    char input;
    int tries =5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnGuess = (Button) findViewById(R.id.btnGuess);
        etGuess = (EditText) findViewById(R.id.etGuess);
        tvResult =(TextView) findViewById(R.id.tvResult);
        tvDesc =(TextView) findViewById(R.id.tvDesc);
        result =" ";
        Movie [] movies =new Movie[10];
        movies[0]=new Movie("Saw", 3,"Psychological horror");
        movies[1]=new Movie("Hush", 3,"Psychological horror");
        movies[2]=new Movie("Lord Of The Rings", 3,"Psychological horror");
        movies[3]=new Movie("venvom", 3,"Psychological horror");
        movies[4]=new Movie("The Last Witchhunter", 3,"Psychological horror");
        movies[5]=new Movie("Fast And Ferious", 3,"Psychological horror");
        movies[6]=new Movie("Paranormal Activity 3", 3,"Psychological horror");
        movies[7]=new Movie("La La Land", 3,"Psychological horror");
        movies[8]=new Movie("The Avengers", 3,"Psychological horror");
        movies[9]=new Movie("Suicide Squad", 3,"Psychological horror");

        int randomIndex = (int)(Math.random()*10);
        final Movie randomMovie = movies[randomIndex];
        tvDesc.setText("The movie is "+randomMovie.getDesc());
        resultArray =new char[randomMovie.getLetters()];
        for(int i=0;i<randomMovie.getLetters();++i)
        {
            if(randomMovie.getName().charAt(i) == ' ')
            {
                resultArray[i] =' ';
            }
            else{
                resultArray[i] ='_';
            }

        }
        result=String.copyValueOf(resultArray);
        tvResult.setText(result);
        btnGuess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tries != 0) {

                    if(etGuess.getText().toString().length()>1 || etGuess.getText().toString().isEmpty())
                    {
                        Toast.makeText(MainActivity.this, "Please try again!", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        String str = etGuess.getText().toString();
                        input =str.charAt(0);
                        etGuess.setText("");
                        // Toast.makeText(MainActivity.this, "I'm Here", Toast.LENGTH_SHORT).show();
                        checkInput(input,randomMovie);
                    }
                }
                else
                {
                    Toast.makeText(MainActivity.this, "have no tries left!", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    void checkInput (char ch,Movie movie)
    {
        char [] newResult =new char[movie.getLetters()];
        int check=0;
       for(int i=0;i<movie.getLetters();++i)
       {
           if (ch == movie.getName().charAt(i)) {
               resultArray[i] = ch;
               check++;
           }
       }
       if(check == 0)
       {
           tries--;
           Toast.makeText(MainActivity.this, "have "+tries+" guess(es) left", Toast.LENGTH_SHORT).show();
       }
        result=String.copyValueOf(resultArray);
        tvResult.setText(result);
    }
}
