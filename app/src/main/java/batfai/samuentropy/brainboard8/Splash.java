package batfai.samuentropy.brainboard8;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;

import com.brainboard.activities.NeuronGameActivity;
import com.brainboard.activities.SplashActivity;

public class Splash extends Thread {

    private SplashActivity act;
    private AnimationDrawable anim;

    public Splash(SplashActivity act)
    {
        this.act = act;
        this.anim = act.getAnimation();
    }

    public void st()
    {
        Intent intent = new Intent();
        intent.setClass(act, NeuronGameActivity.class);
        act.startActivity(intent);
        anim.stop();
    }

    @Override
    public void run()
    {
        anim.start();
    }
}

