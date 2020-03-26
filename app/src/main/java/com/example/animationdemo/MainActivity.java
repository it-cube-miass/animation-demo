package com.example.animationdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, Animation.AnimationListener {
    Animation animFadeIn;
    Animation animFadeOut;
    Animation animFadeInOut;
    Animation animZoomIn;
    Animation animZoomOut;
    Animation animLeftRight;
    Animation animRightLeft;
    Animation animTopBottom;
    Animation animBounce;
    Animation animFlash;
    Animation animRotateLeft;
    Animation animRotateRight;

    ImageView imageView;
    TextView textStatus;

    Button btnFadeIn;
    Button btnFadeOut;
    Button btnFadeInOut;
    Button btnZoomIn;
    Button btnZoomOut;
    Button btnLeftRight;
    Button btnRightLeft;
    Button btnTopBottom;
    Button btnBounce;
    Button btnFlash;
    Button btnRotateLeft;
    Button btnRotateRight;

    SeekBar seekBarSpeed;
    TextView textSeekerSpeed;

    int seekSpeedProgress = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadAnimations();
        loadUI();
        updateTextSeekerSpeed();
    }

    private void loadUI() {
        imageView = (ImageView) findViewById(R.id.imageView);
        textStatus = (TextView) findViewById(R.id.textStatus);

        btnFadeIn = (Button) findViewById(R.id.btnFadeIn);
        btnFadeOut = (Button) findViewById(R.id.btnFadeOut);
        btnFadeInOut = (Button) findViewById(R.id.btnFadeInOut);
        btnZoomIn = (Button) findViewById(R.id.btnZoomIn);
        btnZoomOut = (Button) findViewById(R.id.btnZoomOut);
        btnLeftRight = (Button) findViewById(R.id.btnLeftRight);
        btnRightLeft = (Button) findViewById(R.id.btnRightLeft);
        btnTopBottom = (Button) findViewById(R.id.btnTopBottom);
        btnBounce = (Button) findViewById(R.id.btnBounce);
        btnFlash = (Button) findViewById(R.id.btnFlash);
        btnRotateLeft = (Button) findViewById(R.id.btnRotateLeft);
        btnRotateRight = (Button) findViewById(R.id.btnRotateRight);

        btnFadeIn.setOnClickListener(this);
        btnFadeOut.setOnClickListener(this);
        btnFadeInOut.setOnClickListener(this);
        btnZoomIn.setOnClickListener(this);
        btnZoomOut.setOnClickListener(this);
        btnLeftRight.setOnClickListener(this);
        btnRightLeft.setOnClickListener(this);
        btnTopBottom.setOnClickListener(this);
        btnBounce.setOnClickListener(this);
        btnFlash.setOnClickListener(this);
        btnRotateLeft.setOnClickListener(this);
        btnRotateRight.setOnClickListener(this);

        seekBarSpeed = (SeekBar) findViewById(R.id.seekBarSpeed);
        textSeekerSpeed = (TextView) findViewById(R.id.textSeekerSpeed);

        seekBarSpeed.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekSpeedProgress = progress;
                updateTextSeekerSpeed();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
    }

    private void updateTextSeekerSpeed() {
        textSeekerSpeed.setText(seekSpeedProgress + " of " + seekBarSpeed.getMax());
    }

    private void loadAnimations() {
        animFadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        animFadeOut = AnimationUtils.loadAnimation(this, R.anim.fade_out);
        animFadeInOut = AnimationUtils.loadAnimation(this, R.anim.fade_in_out);
        animZoomIn = AnimationUtils.loadAnimation(this, R.anim.zoom_in);
        animZoomOut = AnimationUtils.loadAnimation(this, R.anim.zoom_out);
        animLeftRight = AnimationUtils.loadAnimation(this, R.anim.left_right);
        animRightLeft = AnimationUtils.loadAnimation(this, R.anim.right_left);
        animTopBottom = AnimationUtils.loadAnimation(this, R.anim.top_bot);
        animBounce = AnimationUtils.loadAnimation(this, R.anim.bounce);
        animFlash = AnimationUtils.loadAnimation(this, R.anim.flash);
        animRotateLeft = AnimationUtils.loadAnimation(this, R.anim.rotate_left);
        animRotateRight = AnimationUtils.loadAnimation(this, R.anim.rotate_right);
    }

    @Override
    public void onClick(View v) {
        Animation anim = null;
        switch (v.getId()) {
            case R.id.btnFadeIn: anim = animFadeIn; break;
            case R.id.btnFadeOut: anim = animFadeOut; break;
            case R.id.btnFadeInOut: anim = animFadeInOut; break;
            case R.id.btnZoomIn: anim = animZoomIn; break;
            case R.id.btnZoomOut: anim = animZoomOut; break;
            case R.id.btnLeftRight: anim = animLeftRight; break;
            case R.id.btnRightLeft: anim = animRightLeft; break;
            case R.id.btnTopBottom: anim = animTopBottom; break;
            case R.id.btnBounce: anim = animBounce; break;
            case R.id.btnFlash: anim = animFlash; break;
            case R.id.btnRotateLeft: anim = animRotateLeft; break;
            case R.id.btnRotateRight: anim = animRotateRight; break;
        }
        if (anim == null) {
            return;
        }

        anim.setDuration(seekSpeedProgress);
        anim.setAnimationListener(this);
        imageView.startAnimation(anim);
    }

    @Override
    public void onAnimationStart(Animation animation) {
        textStatus.setText("RUNNING");
    }

    @Override
    public void onAnimationEnd(Animation animation) {
        textStatus.setText("STOPPED");
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}
