package makikihnia.matti.animationtest;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;

import java.util.zip.InflaterInputStream;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView animateImage2;
    private ImageView animateImage1;
    private ObjectAnimator animator;
    private ConstraintLayout background;
    private ObjectAnimator animator2;
    private AnimatorSet animatorSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        animateImage1 = findViewById(R.id.animate_image);
        animateImage2 = findViewById(R.id.animate_image2);
        background = findViewById(R.id.background);
        Button stopButton = findViewById(R.id.stopButton);
        Button startButton = findViewById(R.id.startButton);
        startButton.setOnClickListener(this);
        stopButton.setOnClickListener(this);
    }

    private void startAnimation() {
        animatorSet = new AnimatorSet();
        animator = ObjectAnimator.ofFloat(animateImage1, "x", background.getWidth());
        animator.setDuration(3000);
        animator.setRepeatCount(Animation.INFINITE);
        animator2 = ObjectAnimator.ofFloat(animateImage2, "x", background.getWidth());
        animator2.setDuration(3000);
        animator2.setRepeatCount(Animation.INFINITE);
        animator2.setStartDelay(1500);
        animatorSet.playTogether(animator, animator2);
        animatorSet.setInterpolator(new LinearInterpolator());
        animatorSet.start();
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.startButton) {
            startAnimation();
        } else {
            stopAnimation();
        }
    }

    private void stopAnimation() {
        if (animatorSet != null && animatorSet.isRunning()) {
            animatorSet.end();
        }
    }
}
