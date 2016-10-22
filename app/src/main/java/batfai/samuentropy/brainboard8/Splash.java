package batfai.samuentropy.brainboard8;

/**
 * Created by Auror on 2016.10.22..
 */

class Splash extends Thread {

    SplashActivity act;
    android.graphics.drawable.AnimationDrawable anim;

    public Splash(android.graphics.drawable.AnimationDrawable anim, SplashActivity act) {
        this.anim = anim;
        this.act = act;
    }

    public void st() {
        android.content.Intent intent = new android.content.Intent();
        intent.setClass(act, NeuronGameActivity.class);
        act.startActivity(intent);
        anim.stop();
    }

    @Override
    public void run() {
        anim.start();
    }
}

