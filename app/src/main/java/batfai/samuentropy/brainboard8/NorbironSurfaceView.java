/*
 * NorbironSurfaceView.java
 *
 * Norbiron Game
 * This is a case study for creating sprites for SamuEntropy/Brainboard.
 *
 * Copyright (C) 2016, Dr. Bátfai Norbert
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 * Ez a program szabad szoftver; terjeszthető illetve módosítható a
 * Free Software Foundation által kiadott GNU General Public License
 * dokumentumában leírtak; akár a licenc 3-as, akár (tetszőleges) későbbi
 * változata szerint.
 *
 * Ez a program abban a reményben kerül közreadásra, hogy hasznos lesz,
 * de minden egyéb GARANCIA NÉLKÜL, az ELADHATÓSÁGRA vagy VALAMELY CÉLRA
 * VALÓ ALKALMAZHATÓSÁGRA való származtatott garanciát is beleértve.
 * További részleteket a GNU General Public License tartalmaz.
 *
 * A felhasználónak a programmal együtt meg kell kapnia a GNU General
 * Public License egy példányát; ha mégsem kapta meg, akkor
 * tekintse meg a <http://www.gnu.org/licenses/> oldalon.
 *
 * Version history:
 *
 * 0.0.1, 2013.szept.29.
 */
package batfai.samuentropy.brainboard8;

import com.brainboard.activities.NeuronGameActivity;
import com.brainboard.activities.NodeActivity;

import java.util.List;

/**
 *
 * @author nbatfai
 */
public class NorbironSurfaceView extends android.view.SurfaceView implements Runnable {

    private float startsx = 0;
    private float startsy = 0;
    private float width = 2048;
    private float height = 2048;

    protected float swidth;
    protected float sheight;

    protected float fromsx;
    protected float fromsy;

    protected float boardx = 0;
    protected float boardy = 0;

    private Nodes nodes;
    private static java.util.List<NeuronBox> nodeBoxes = new java.util.ArrayList<NeuronBox>();

    private static java.util.List<Integer> nodeIds = new java.util.ArrayList<Integer>();

    protected NeuronBox selNb = null;

    private android.view.SurfaceHolder surfaceHolder;
    private android.view.ScaleGestureDetector scaleGestureDetector;
    private float scaleFactor = 1.0f;

    private boolean running = true;

    private android.content.Context context;

    public static List<Integer> getNodeIds() {
        return nodeIds;
    }

    public void setScaleFactor(float scaleFactor) {
        this.scaleFactor = scaleFactor;
    }

    public float getScaleFactor() {
        return scaleFactor;
    }

    public NorbironSurfaceView(android.content.Context context) {
        super(context);

        cinit(context);

    }

    public NorbironSurfaceView(android.content.Context context,
            android.util.AttributeSet attrs) {
        super(context, attrs);

        cinit(context);

    }

    public NorbironSurfaceView(android.content.Context context,
            android.util.AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        cinit(context);

    }

    @Override
    protected void onSizeChanged(int newx, int newy, int x, int y) {

        super.onSizeChanged(newx, newy, x, y);

        width = newx;
        height = newy;

        swidth = width / 2 - nodes.getBoardPic().getWidth() / 2;
        sheight = height / 2 - nodes.getBoardPic().getHeight() / 2;

    }

    public void initBoxNodes() {

        if (nodeBoxes.size() == 0) {
            nodeBoxes.add((NeuronBox) nodes.get(-1).clone());
            nodeBoxes.add((NeuronBox) nodes.get(-2).clone());
        }
    }

    private void cinit(android.content.Context context) {

        this.context = context;
        nodes = new Nodes(this);

        initBoxNodes();

        android.content.Intent intent = ((NeuronGameActivity) context).getIntent();
        android.os.Bundle bundle = intent.getExtras();

        if (bundle != null) {
            int i = bundle.getInt("selectedNode");

            if (i > 12) {
                i = 12;
            }
            nodeBoxes.add((NeuronBox) nodes.get(i).clone());

        }

        surfaceHolder = getHolder();
        surfaceHolder.addCallback(new SurfaceEvents(this));

        scaleGestureDetector = new android.view.ScaleGestureDetector(context, new ScaleAdapter(this));

    }

    @Override
    public void onDraw(android.graphics.Canvas canvas) {

        if (surfaceHolder.getSurface().isValid()) {

            canvas.save();
            canvas.scale(scaleFactor, scaleFactor);

            canvas.drawColor(android.graphics.Color.BLACK);

            for (int i = 0; i < 10; ++i) {
                for (int j = 0; j < 10; ++j) {
                    canvas.drawBitmap(nodes.getBoardPic(), -startsx + boardx + i * 300, -startsy + boardy + j * 300, null);
                }
            }

            for (NeuronBox nb : nodeBoxes) {
                nb.draw(-startsx, -startsy, canvas);
            }

            canvas.restore();
        }
    }

    public void repaint() {

        android.graphics.Canvas canvas = null;
        try {
            canvas = surfaceHolder.lockCanvas();
            if (canvas != null) {
                onDraw(canvas);
            }

        } finally {

            if (canvas != null) {
                surfaceHolder.unlockCanvasAndPost(canvas);
            }

        }
    }

    public float d(float x1, float x2, float y1, float y2) {

        return (x1 - y1) * (x1 - y1) + (x2 - y2) * (x2 - y2);
    }

    protected NeuronBox nearestNeuronBox(float x, float y) {

        NeuronBox r = null;
        float max = 10000, m;

        for (NeuronBox nb : nodeBoxes) {

            if ((m = d(nb.getX() + nb.getWidth() / 2, nb.getY() + nb.getHeight() / 2, x, y)) < max) {
                max = m;
                r = nb;
            }
        }
        return r;
    }

    public void newNode() {

        android.content.Intent intent = new android.content.Intent(context, NodeActivity.class);
        intent.putIntegerArrayListExtra("nodeIds", (java.util.ArrayList<Integer>) nodeIds);
        context.startActivity(intent);

    }

    public void newBox() {

        NorbironSurfaceView.getNodeIds().add(R.drawable.boxproci);
        nodeBoxes.clear();
        initBoxNodes();
        android.widget.Toast.makeText(context, "New box added. See BUILD", android.widget.Toast.LENGTH_SHORT).show();

    }

    @Override
    public boolean onTouchEvent(android.view.MotionEvent event) {

        scaleGestureDetector.onTouchEvent(event);

        float x = event.getX() / scaleFactor;
        float y = event.getY() / scaleFactor;

        if (event.getAction() == android.view.MotionEvent.ACTION_DOWN) {

            fromsx = x;
            fromsy = y;

            NeuronBox nb = nearestNeuronBox(x + startsx, y + startsy);
            if (nb != null) {

                if (nb.getType() == -1) {
                    // if (nb.getSelected()) {
                    newNode();
                    // }
                } else if (nb.getType() == 0) {
                    // if (nb.getSelected()) {
                    newBox();
                    // }
                } else {
                    nb.setCover(!nb.getCover());
                    nb.setSelected(!nb.getSelected());
                    selNb = nb;
                }
            } else {
                selNb = null;
            }

        } else if (event.getAction() == android.view.MotionEvent.ACTION_POINTER_DOWN) {

            if (selNb != null) {
                selNb = null;
            }

        } else if (event.getAction() == android.view.MotionEvent.ACTION_CANCEL) {

        } else if (event.getAction() == android.view.MotionEvent.ACTION_MOVE) {

            if (selNb != null) {
                selNb.setXY(selNb.getX() - (fromsx - x), selNb.getY() - (fromsy - y));

                fromsx = x;
                fromsy = y;

            } else if (Math.abs(fromsx - x) + Math.abs(fromsy - y) > 25) {
                startsx += (fromsx - x);
                startsy += (fromsy - y);

                fromsx = x;
                fromsy = y;
            }

            repaint();

        } else if (event.getAction() == android.view.MotionEvent.ACTION_UP) {

            if (selNb != null) {

                float nx = selNb.getX() - (fromsx - x);
                float ny = selNb.getY() - (fromsy - y);

                selNb.setXY(selNb.getX() - (fromsx - x) - nx % 300 + 30 + 35, selNb.getY() - (fromsy - y) - ny % 300 + 30 + 15 + 7);

                fromsx = x;
                fromsy = y;

            }

        }

        return true;
    }

    public void stop() {
        running = false;
    }

    @Override
    public void run() {
        long now = System.currentTimeMillis(), newnow;
        float spritex = 0;
        running = true;
        while (running) {

            if ((newnow = System.currentTimeMillis()) - now > 100) {

                for (NeuronBox nb : nodeBoxes) {
                    nb.step();
                }

                repaint();

                now = newnow;
            }

        }

    }
}
