package com.example.abhi.alphamatch;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.example.abhi.alphamatch.DrawView;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;
import static com.example.abhi.alphamatch.R.id.notification_background;
public class GameHome extends AppCompatActivity {
    RelativeLayout rl1;
    DrawView1 drawView;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_home);
        final Character z[] = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        final List<Character> a = new ArrayList<>();
        final List<Integer> x = new ArrayList<>();
        final Random rng = new Random(System.currentTimeMillis()); // Ideally just create one instance globally
        for (int i = 0; i < 4; i++) {
            while (true) {
                int next = (rng.nextInt(26));
                if (!x.contains(next)) {
                    x.add(next);
                    break;
                }
            }
        }
        a.add(z[x.get(0)]);
        a.add(z[x.get(1)]);
        a.add(z[x.get(2)]);
        a.add(z[x.get(3)]);
        rl1 =(RelativeLayout)findViewById(R.id.rl1);
        final Button playbutton1 = (Button) findViewById(R.id.playbutton1);
        final Button playbutton2 = (Button) findViewById(R.id.playbutton2);
        final Button playbutton3 = (Button) findViewById(R.id.playbutton3);
        final Button playbutton4 = (Button) findViewById(R.id.playbutton4);
        final Button playbutton5 = (Button) findViewById(R.id.playbutton5);
        final Button playbutton6 = (Button)findViewById(R.id.playbutton6);
        final Button playbutton7 = (Button)findViewById(R.id.playbutton7);
        final Button playbutton8 = (Button)findViewById(R.id.playbutton8);
        playbutton1.setText(String.valueOf(a.get(0)));
        playbutton2.setText(String.valueOf(a.get(1)));
        playbutton3.setText(String.valueOf(a.get(2)));
        playbutton4.setText(String.valueOf(a.get(3)));
        final List<Integer> b = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            while (true) {
                int next = (rng.nextInt(4));
                if (!b.contains(next)) {
                    b.add(next);
                    break;
                }
            }
        }
        playbutton5.setText(String.valueOf(a.get(b.get(0))));
        playbutton6.setText(String.valueOf(a.get(b.get(1))));
        playbutton7.setText(String.valueOf(a.get(b.get(2))));
        playbutton8.setText(String.valueOf(a.get(b.get(3))));

        final int[] check1 = {0};
        final int[] check2 = {0};
        final int[] index = {0};
        final int[] verify1 = {0,0,0,0};
        final int[] verify2 = {0,0,0,0};
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.custom_toast,
                (ViewGroup) findViewById(R.id.custom_toast_container));
        final Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);
        LayoutInflater inflater2 = getLayoutInflater();
        View layout2 = inflater2.inflate(R.layout.star_toast,
                (ViewGroup) findViewById(R.id.star));
        final Toast toast2 = new Toast(getApplicationContext());
        toast2.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast2.setDuration(Toast.LENGTH_SHORT);
        toast2.setView(layout2);
        Button exit = (Button)findViewById(R.id.exit);
        Button next = (Button)findViewById(R.id.next);
        final MediaPlayer WrongSound = MediaPlayer.create(GameHome.this, R.raw.wrong_sound);
        final MediaPlayer GameMusic = MediaPlayer.create(GameHome.this, R.raw.game_music);
        playbutton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (check1[0] == 0 && check2[0] == 0 && verify1[0] == 0) {
                    playbutton1.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_color_red));
                    check1[0] = 1;
                    index[0] = 0;
                } else if (check2[0] == 1 && check1[0] == 0) {
                    if (index[0] == 0) {
                        if (a.get(0) == a.get(b.get(0))) {
                            playbutton1.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_color_green));
                            playbutton5.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_color_green));
                            check2[0] = 0;
                            drawView = new DrawView1(GameHome.this, playbutton1, playbutton5, 0, 0, 0, 0);
                            rl1.addView(drawView);
                            verify1[0] = 1;
                            verify2[0] = 1;
                        } else{
                            WrongSound.start();
                            toast.show();}
                    } else if (index[0] == 1) {
                        if (a.get(0) == a.get(b.get(1))) {
                            playbutton1.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_color_green));
                            playbutton6.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_color_green));
                            check2[0] = 0;
                            drawView = new DrawView1(GameHome.this, playbutton1, playbutton6, 0, 0, 0, 0);
                            rl1.addView(drawView);
                            verify1[0] = 1;
                            verify2[1] = 1;
                        } else{
                            WrongSound.start();
                            toast.show();}
                    } else if (index[0] == 2) {
                        if (a.get(0) == a.get(b.get(2))) {
                            playbutton1.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_color_green));
                            playbutton7.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_color_green));
                            check2[0] = 0;
                            drawView = new DrawView1(GameHome.this, playbutton1, playbutton7, 0, 0, 0, 0);
                            rl1.addView(drawView);
                            verify1[0] = 1;
                            verify2[2] = 1;
                        } else{
                            WrongSound.start();
                            toast.show();}
                    } else if (index[0] == 3) {
                        if (a.get(0) == a.get(b.get(3))) {
                            playbutton1.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_color_green));
                            playbutton8.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_color_green));
                            check2[0] = 0;
                            drawView = new DrawView1(GameHome.this, playbutton1, playbutton8, 0, 0, 0, 0);
                            rl1.addView(drawView);
                            verify1[0] = 1;
                            verify2[3] = 1;
                        } else{
                            WrongSound.start();
                            toast.show();}
                    }
                    if(verify1[0] == 1 && verify1[1] == 1 && verify1[2] == 1 && verify1[3] == 1 && verify2[0] == 1 && verify2[1] == 1 && verify2[2] == 1 && verify2[3] == 1 ){
                        Intent i =new Intent(GameHome.this,winstar.class);
                        finish();
                        startActivity(i);
                    }
                }
            }
        });
        playbutton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (check1[0] == 0 && check2[0] == 0 && verify1[1] == 0) {
                    playbutton2.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_color_red));
                    check1[0] = 1;
                    index[0] = 1;
                } else if (check2[0] == 1 && check1[0] == 0) {
                    if (index[0] == 0) {
                        if (a.get(1) == a.get(b.get(0))) {
                            playbutton2.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_color_green));
                            playbutton5.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_color_green));
                            check2[0] = 0;
                            drawView = new DrawView1(GameHome.this,playbutton2, playbutton5, 50, 100, 50, 100);
                            rl1.addView(drawView);
                            verify1[1] = 1;
                            verify2[0] = 1;
                        } else{
                            WrongSound.start();
                            toast.show();}
                    }
                    if (index[0] == 1) {
                        if (a.get(1) == a.get(b.get(1))) {
                            playbutton2.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_color_green));
                            playbutton6.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_color_green));
                            check2[0] = 0;
                            drawView = new DrawView1(GameHome.this, playbutton2, playbutton6, 50, 100, 50, 100);
                            rl1.addView(drawView);
                            verify1[1] = 1;
                            verify2[1] = 1;
                        } else{
                            WrongSound.start();
                            toast.show();}
                    }
                    if (index[0] == 2) {
                        if (a.get(1) == a.get(b.get(2))) {
                            playbutton2.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_color_green));
                            playbutton6.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_color_green));
                            check2[0] = 0;
                            drawView = new DrawView1(GameHome.this, playbutton2, playbutton6, 50, 100, 50, 100);
                            rl1.addView(drawView);
                            verify1[1] = 1;
                            verify2[2] = 1;
                        } else{
                            WrongSound.start();
                            toast.show();}
                    }
                    if (index[0] == 3) {
                        if (a.get(1) == a.get(b.get(3))) {
                            playbutton8.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_color_green));
                            playbutton2.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_color_green));
                            check2[0] = 0;
                            drawView = new DrawView1(GameHome.this, playbutton2,playbutton8, 50, 100, 50, 100);
                            rl1.addView(drawView);
                            verify1[1] = 1;
                            verify2[3] = 1;
                        } else{
                            WrongSound.start();
                            toast.show();}
                    }
                    if(verify1[0] == 1 && verify1[1] == 1 && verify1[2] == 1 && verify1[3] == 1 && verify2[0] == 1 && verify2[1] == 1 && verify2[2] == 1 && verify2[3] == 1 ){
                        Intent i =new Intent(GameHome.this, winstar.class);
                        finish();
                        startActivity(i);
                    }
                }
            }
        });
        playbutton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (check1[0] == 0 && check2[0] == 0 && verify1[2] == 0) {
                    playbutton3.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_color_red));
                    check1[0] = 1;
                    index[0] = 2;
                } else if (check2[0] == 1 && check1[0] == 0) {
                    if (index[0] == 0) {
                        if (a.get(2) == a.get(b.get(0))) {
                            playbutton3.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_color_green));
                            playbutton5.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_color_green));
                            check2[0] = 0;
                            drawView = new DrawView1(GameHome.this, playbutton3, playbutton5, 50, 100, 50, 100);
                            rl1.addView(drawView);
                            verify1[2] = 1;
                            verify2[0] = 1;
                        } else{
                            WrongSound.start();
                            toast.show();}
                    }
                    if (index[0] == 1) {
                        if (a.get(2) == a.get(b.get(1))) {
                            playbutton3.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_color_green));
                            playbutton6.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_color_green));
                            check2[0] = 0;
                            drawView = new DrawView1(GameHome.this, playbutton3, playbutton6, 50, 100, 50, 100);
                            rl1.addView(drawView);
                            verify1[2] = 1;
                            verify2[1] = 1;
                        } else{
                            WrongSound.start();
                            toast.show();}
                    }
                    if (index[0] == 2) {
                        if (a.get(2) == a.get(b.get(2))) {
                            playbutton3.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_color_green));
                            playbutton7.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_color_green));
                            check2[0] = 0;
                            drawView = new DrawView1(GameHome.this, playbutton3, playbutton7, 50, 100, 50, 100);
                            rl1.addView(drawView);
                            verify1[2] = 1;
                            verify2[2] = 1;
                        } else{
                            WrongSound.start();
                            toast.show();}
                    }
                    if (index[0] == 3) {
                        if (a.get(2) == a.get(b.get(3))) {
                            playbutton3.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_color_green));
                            playbutton8.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_color_green));
                            check2[0] = 0;
                            drawView = new DrawView1(GameHome.this, playbutton3, playbutton8, 50, 100, 50, 100);
                            rl1.addView(drawView);
                            verify1[2] = 1;
                            verify2[3] = 1;
                        } else{
                            WrongSound.start();
                            toast.show();}
                    }
                    if(verify1[0] == 1 && verify1[1] == 1 && verify1[2] == 1 && verify1[3] == 1 && verify2[0] == 1 && verify2[1] == 1 && verify2[2] == 1 && verify2[3] == 1 ){
                        Intent i =new Intent(GameHome.this, winstar.class);
                        finish();
                        startActivity(i);
                    }
                }
            }
        });
        playbutton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (check1[0] == 0 && check2[0] == 0 && verify1[3] == 0) {
                    playbutton4.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_color_red));
                    check1[0] = 1;
                    index[0] = 3;
                } else if (check2[0] == 1 && check1[0] == 0) {
                    if (index[0] == 0) {
                        if (a.get(3) == a.get(b.get(0))) {
                            playbutton4.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_color_green));
                            playbutton5.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_color_green));
                            check2[0] = 0;
                            drawView = new DrawView1(GameHome.this, playbutton4, playbutton5, 50, 100, 50, 100);
                            rl1.addView(drawView);
                            verify1[3] = 1;
                            verify2[0] = 1;
                        } else{
                            WrongSound.start();
                            toast.show();}
                    }
                    if (index[0] == 1) {
                        if (a.get(3) == a.get(b.get(1))) {
                            playbutton4.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_color_green));
                            playbutton6.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_color_green));
                            check2[0] = 0;
                            drawView = new DrawView1(GameHome.this, playbutton4, playbutton6, 50, 100, 50, 100);
                            rl1.addView(drawView);
                            verify1[3] = 1;
                            verify2[1] = 1;
                        } else{
                            WrongSound.start();
                            toast.show();}
                    }
                    if (index[0] == 2) {
                        if (a.get(3) == a.get(b.get(2))) {
                            playbutton4.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_color_green));
                            playbutton7.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_color_green));
                            check2[0] = 0;
                            drawView = new DrawView1(GameHome.this, playbutton4, playbutton7, 50, 100, 50, 100);
                            rl1.addView(drawView);
                            verify1[3] = 1;
                            verify2[2] = 1;
                        } else{
                            WrongSound.start();
                            toast.show();}
                    }
                    if (index[0] == 3) {
                        if (a.get(3) == a.get(b.get(3))) {
                            playbutton4.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_color_green));
                            playbutton8.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_color_green));
                            check2[0] = 0;
                            drawView = new DrawView1(GameHome.this, playbutton4, playbutton8, 50, 100, 50, 100);
                            rl1.addView(drawView);
                            verify1[3] = 1;
                            verify2[3] = 1;
                        } else{
                            WrongSound.start();
                            toast.show();}
                    }
                    if(verify1[0] == 1 && verify1[1] == 1 && verify1[2] == 1 && verify1[3] == 1 && verify2[0] == 1 && verify2[1] == 1 && verify2[2] == 1 && verify2[3] == 1 ){
                        Intent i =new Intent(GameHome.this, winstar.class);
                        finish();
                        startActivity(i);
                    }
                }
            }
        });
        playbutton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (check1[0] == 1 && check2[0] == 0) {
                    if (index[0] == 0) {
                        if (a.get(0) == a.get(b.get(0))) {
                            playbutton1.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_color_green));
                            playbutton5.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_color_green));
                            check1[0] = 0;
                            drawView = new DrawView1(GameHome.this, playbutton1, playbutton5, 50, 100, 50, 100);
                            rl1.addView(drawView);
                            verify1[0] = 1;
                            verify2[0] = 1;
                        }else{
                            WrongSound.start();
                            toast.show();}
                    }
                    if (index[0] == 1) {
                        if (a.get(1) == a.get(b.get(0))) {
                            playbutton2.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_color_green));
                            playbutton5.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_color_green));
                            check1[0] = 0;
                            drawView = new DrawView1(GameHome.this, playbutton2, playbutton5, 50, 100, 50, 100);
                            rl1.addView(drawView);
                            verify1[1] = 1;
                            verify2[0] = 1;
                        } else{
                            WrongSound.start();
                            toast.show();}
                    }
                    if (index[0] == 2) {
                        if (a.get(2) == a.get(b.get(0))) {
                            playbutton3.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_color_green));
                            playbutton5.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_color_green));
                            check1[0] = 0;
                            drawView = new DrawView1(GameHome.this, playbutton3, playbutton5, 50, 100, 50, 100);
                            rl1.addView(drawView);
                            verify1[2] = 1;
                            verify2[0] = 1;
                        } else{
                            WrongSound.start();
                            toast.show();}
                    }
                    if (index[0] == 3) {
                        if (a.get(3) == a.get(b.get(0))) {
                            playbutton4.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_color_green));
                            playbutton5.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_color_green));
                            check1[0] = 0;
                            drawView = new DrawView1(GameHome.this, playbutton4, playbutton5, 50, 100, 50, 100);
                            rl1.addView(drawView);
                            verify1[3] = 1;
                            verify2[0] = 1;
                        }else{
                            WrongSound.start();
                            toast.show();}
                    }
                    if(verify1[0] == 1 && verify1[1] == 1 && verify1[2] == 1 && verify1[3] == 1 && verify2[0] == 1 && verify2[1] == 1 && verify2[2] == 1 && verify2[3] == 1 ){
                        Intent i =new Intent(GameHome.this, winstar.class);
                        finish();
                        startActivity(i);
                    }
                } else if (check2[0] == 0 && check1[0] == 0 && verify2[0] == 0) {
                    playbutton5.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_color_red));
                    check2[0] = 1;
                    index[0] = 0;
                }
            }
        });
        playbutton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (check1[0] == 1 && check2[0] == 0) {
                    if (index[0] == 0) {
                        if (a.get(0) == a.get(b.get(1))) {
                            playbutton1.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_color_green));
                            playbutton6.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_color_green));
                            check1[0] = 0;
                            drawView = new DrawView1(GameHome.this, playbutton1, playbutton6, 50, 100, 50, 100);
                            rl1.addView(drawView);
                            verify1[0] = 1;
                            verify2[1] = 1;
                        } else{
                            WrongSound.start();
                            toast.show();}
                    }
                    if (index[0] == 1) {
                        if (a.get(1) == a.get(b.get(1))) {
                            playbutton2.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_color_green));
                            playbutton6.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_color_green));
                            check1[0] = 0;
                            drawView = new DrawView1(GameHome.this, playbutton2, playbutton6, 50, 100, 50, 100);
                            rl1.addView(drawView);
                            verify1[1] = 1;
                            verify2[1] = 1;
                        }else{
                            WrongSound.start();
                            toast.show();}
                    }
                    if (index[0] == 2) {
                        if (a.get(2) == a.get(b.get(1))) {
                            playbutton3.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_color_green));
                            playbutton6.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_color_green));
                            check1[0] = 0;
                            drawView = new DrawView1(GameHome.this, playbutton3, playbutton6, 50, 100, 50, 100);
                            rl1.addView(drawView);
                            verify1[2] = 1;
                            verify2[1] = 1;
                        } else{
                            WrongSound.start();
                            toast.show();}
                    }
                    if (index[0] == 3) {
                        if (a.get(3) == a.get(b.get(1))) {
                            playbutton4.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_color_green));
                            playbutton6.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_color_green));
                            check1[0] = 0;
                            drawView = new DrawView1(GameHome.this, playbutton4, playbutton6, 50, 100, 50, 100);
                            rl1.addView(drawView);
                            verify1[3] = 1;
                            verify2[1] = 1;
                        }else{
                            WrongSound.start();
                            toast.show();}
                    }
                    if(verify1[0] == 1 && verify1[1] == 1 && verify1[2] == 1 && verify1[3] == 1 && verify2[0] == 1 && verify2[1] == 1 && verify2[2] == 1 && verify2[3] == 1 ){
                        Intent i =new Intent(GameHome.this, winstar.class);
                        finish();
                        startActivity(i);
                    }
                } else if (check2[0] == 0 && check1[0] == 0 && verify2[1] == 0) {
                    playbutton6.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_color_red));
                    check2[0] = 1;
                    index[0] = 1;
                }
            }
        });
        playbutton7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (check1[0] == 1 && check2[0] == 0) {
                    if (index[0] == 0) {
                        if (a.get(0) == a.get(b.get(2))) {
                            playbutton1.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_color_green));
                            playbutton7.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_color_green));
                            check1[0] = 0;
                            drawView = new DrawView1(GameHome.this, playbutton1, playbutton7, 50, 100, 50, 100);
                            rl1.addView(drawView);
                            verify1[0] = 1;
                            verify2[2] = 1;
                        } else{
                            WrongSound.start();
                            toast.show();}
                    }
                    if (index[0] == 1) {
                        if (a.get(1) == a.get(b.get(2))) {
                            playbutton2.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_color_green));
                            playbutton7.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_color_green));
                            check1[0] = 0;
                            drawView = new DrawView1(GameHome.this, playbutton2, playbutton7, 50, 100, 50, 100);
                            rl1.addView(drawView);
                            verify1[1] = 1;
                            verify2[2] = 1;
                        } else{
                            WrongSound.start();
                            toast.show();}
                    }
                    if (index[0] == 2) {
                        if (a.get(2) == a.get(b.get(2))) {
                            playbutton3.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_color_green));
                            playbutton7.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_color_green));
                            check1[0] = 0;
                            drawView = new DrawView1(GameHome.this, playbutton3, playbutton7, 50, 100, 50, 100);
                            rl1.addView(drawView);
                            verify1[2] = 1;
                            verify2[2] = 1;
                        } else{
                            WrongSound.start();
                            toast.show();}
                    }
                    if (index[0] == 3) {
                        if (a.get(3) == a.get(b.get(2))) {
                            playbutton4.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_color_green));
                            playbutton7.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_color_green));
                            check1[0] = 0;
                            drawView = new DrawView1(GameHome.this, playbutton4, playbutton7, 50, 100, 50, 100);
                            rl1.addView(drawView);
                            verify1[3] = 1;
                            verify2[2] = 1;
                        } else{
                            WrongSound.start();
                            toast.show();}
                    }
                    if(verify1[0] == 1 && verify1[1] == 1 && verify1[2] == 1 && verify1[3] == 1 && verify2[0] == 1 && verify2[1] == 1 && verify2[2] == 1 && verify2[3] == 1 ){
                        Intent i =new Intent(GameHome.this, winstar.class);
                        finish();
                        startActivity(i);
                    }
                } else if (check2[0] == 0 && check1[0] == 0 && verify2[2] == 0) {
                    playbutton7.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_color_red));
                    check2[0] = 1;
                    index[0] = 2;
                }
            }
        });
        playbutton8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (check1[0] == 1 && check2[0] == 0) {
                    if (index[0] == 0) {
                        if (a.get(0) == a.get(b.get(3))) {
                            playbutton1.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_color_green));
                            playbutton8.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_color_green));
                            check1[0] = 0;
                            drawView = new DrawView1(GameHome.this, playbutton1, playbutton8, 50, 100, 50, 100);
                            rl1.addView(drawView);
                            verify1[0] = 1;
                            verify2[3] = 1;
                        } else{
                            WrongSound.start();
                            toast.show();}
                    }
                    if (index[0] == 1) {
                        if (a.get(1) == a.get(b.get(3))) {
                            playbutton2.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_color_green));
                            playbutton8.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_color_green));
                            check1[0] = 0;
                            drawView = new DrawView1(GameHome.this, playbutton2, playbutton8, 50, 100, 50, 100);
                            rl1.addView(drawView);
                            verify1[1] = 1;
                            verify2[3] = 1;
                        } else{
                            WrongSound.start();
                            toast.show();}
                    }
                    if (index[0] == 2) {
                        if (a.get(2) == a.get(b.get(3))) {
                            playbutton8.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_color_green));
                            playbutton3.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_color_green));
                            check1[0] = 0;
                            drawView = new DrawView1(GameHome.this,playbutton3, playbutton8, 50, 100, 50, 100);
                            rl1.addView(drawView);
                            verify1[2] = 1;
                            verify2[3] = 1;
                        } else{
                            WrongSound.start();
                            toast.show();}
                    }
                    if (index[0] == 3) {
                        if (a.get(3) == a.get(b.get(3))) {
                            playbutton4.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_color_green));
                            playbutton8.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_color_green));
                            check1[0] = 0;
                            drawView = new DrawView1(GameHome.this, playbutton4, playbutton8, 50, 100, 50, 100);
                            rl1.addView(drawView);
                            verify1[3] = 1;
                            verify2[3] = 1;
                        } else{
                            WrongSound.start();
                            toast.show();}
                    }
                    if(verify1[0] == 1 && verify1[1] == 1 && verify1[2] == 1 && verify1[3] == 1 && verify2[0] == 1 && verify2[1] == 1 && verify2[2] == 1 && verify2[3] == 1 ){
                        Intent i =new Intent(GameHome.this, winstar.class);
                        finish();
                        startActivity(i);
                    }
                } else if (check2[0] == 0 && check1[0] == 0 && verify2[3] == 0) {
                    playbutton8.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_color_red));
                    check2[0] = 1;
                    index[0] = 3;
                }
            }
        });
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent i =new Intent(GameHome.this, GameIntro.class);
                finish();
                startActivity(i);
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent clicknext = getIntent();
                x.clear();
                b.clear();
                a.clear();
                for (int i = 0; i < 4; i++) {
                    while (true) {
                        int next = (rng.nextInt(26));
                        if (!x.contains(next)) {
                            x.add(next);
                            break;
                        }
                    }
                }
                a.add(z[x.get(0)]);
                a.add(z[x.get(1)]);
                a.add(z[x.get(2)]);
                a.add(z[x.get(3)]);
                playbutton1.setText(String.valueOf(a.get(0)));
                playbutton2.setText(String.valueOf(a.get(1)));
                playbutton3.setText(String.valueOf(a.get(2)));
                playbutton4.setText(String.valueOf(a.get(3)));
                for (int i = 0; i < 4; i++) {
                    while (true) {
                        int next = (rng.nextInt(4));
                        if (!b.contains(next)) {
                            b.add(next);
                            break;
                        }
                    }
                }
                playbutton5.setText(String.valueOf(a.get(b.get(0))));
                playbutton6.setText(String.valueOf(a.get(b.get(1))));
                playbutton7.setText(String.valueOf(a.get(b.get(2))));
                playbutton8.setText(String.valueOf(a.get(b.get(3))));
                check1[0]=0;
                check2[0]=0;
                verify1[0]=0;
                verify1[1]=0;
                verify1[2]=0;
                verify1[3]=0;
                verify2[0]=0;
                verify2[1]=0;
                verify2[2]=0;
                verify2[3]=0;
                playbutton5.setBackgroundDrawable(getResources().getDrawable(R.drawable.buttonshape));
                playbutton6.setBackgroundDrawable(getResources().getDrawable(R.drawable.buttonshape));
                playbutton7.setBackgroundDrawable(getResources().getDrawable(R.drawable.buttonshape));
                playbutton8.setBackgroundDrawable(getResources().getDrawable(R.drawable.buttonshape));
                playbutton1.setBackgroundDrawable(getResources().getDrawable(R.drawable.buttonshape));
                playbutton2.setBackgroundDrawable(getResources().getDrawable(R.drawable.buttonshape));
                playbutton3.setBackgroundDrawable(getResources().getDrawable(R.drawable.buttonshape));
                playbutton4.setBackgroundDrawable(getResources().getDrawable(R.drawable.buttonshape));
                rl1.removeAllViews();
            }
        });
    }
}