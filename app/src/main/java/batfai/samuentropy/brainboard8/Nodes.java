package batfai.samuentropy.brainboard8;

/**
 * Created by Auror on 2016.10.22..
 */

public class Nodes {

    public final static int NODES_START = 2;

    private android.graphics.Bitmap boardPic;
    private android.graphics.Bitmap neuronSprite;
    private android.graphics.Bitmap nandIronProcCover;
    private NeuronBox[] neuronBox;
    NorbironSurfaceView surfaceView;

    public Nodes(NorbironSurfaceView surfaceView) {

        this.surfaceView = surfaceView;

        int resId = surfaceView.getResources().getIdentifier("pcb550i", "drawable",
                "batfai.samuentropy.brainboard8");

        boardPic = android.graphics.BitmapFactory.decodeResource(surfaceView.getResources(), resId);

        boardPic = android.graphics.Bitmap.createScaledBitmap(boardPic, 300, 300, false);

        resId = surfaceView.getResources().getIdentifier("neuronsprite", "drawable",
                "batfai.samuentropy.brainboard8");

        neuronSprite = android.graphics.BitmapFactory.decodeResource(surfaceView.getResources(), resId);

        neuronSprite = android.graphics.Bitmap.createScaledBitmap(neuronSprite, 64 * 2 * 14, 62, false);

        neuronBox = new NeuronBox[15];

        resId = surfaceView.getResources().getIdentifier("buildproci", "drawable",
                "batfai.samuentropy.brainboard8");
        nandIronProcCover = android.graphics.BitmapFactory.decodeResource(surfaceView.getResources(), resId);
        nandIronProcCover = android.graphics.Bitmap.createScaledBitmap(nandIronProcCover, 84, 98, false);

        neuronBox[0] = new NeuronBox(neuronSprite, 2 * 14, 64, 62, 1, nandIronProcCover, 0 + 30 + 35, 0 + 30 + 15 + 7);
        neuronBox[0].setType(-1);

        resId = surfaceView.getResources().getIdentifier("boxinproci", "drawable",
                "batfai.samuentropy.brainboard8");
        nandIronProcCover = android.graphics.BitmapFactory.decodeResource(surfaceView.getResources(), resId);
        nandIronProcCover = android.graphics.Bitmap.createScaledBitmap(nandIronProcCover, 84, 98, false);

        neuronBox[1] = new NeuronBox(neuronSprite, 2 * 14, 64, 62, 1, nandIronProcCover, 0 + 30 + 35 + 84 + 30 + 35, 0 + 30 + 15 + 7);
        neuronBox[1].setType(0);

        resId = R.drawable.randnmproci;
        NorbironSurfaceView.getNodeIds().add(resId);

        nandIronProcCover = android.graphics.BitmapFactory.decodeResource(surfaceView.getResources(), resId);
        nandIronProcCover = android.graphics.Bitmap.createScaledBitmap(nandIronProcCover, 168, 197, false);

        neuronBox[2] = new NeuronBox(neuronSprite, 2 * 14, 64, 62, 10, nandIronProcCover, 100, 100);

        resId = R.drawable.gaussnmproci;
        NorbironSurfaceView.getNodeIds().add(resId);

        nandIronProcCover = android.graphics.BitmapFactory.decodeResource(surfaceView.getResources(), resId);
        nandIronProcCover = android.graphics.Bitmap.createScaledBitmap(nandIronProcCover, 168, 197, false);
        neuronBox[3] = new NeuronBox(neuronSprite, 2 * 14, 64, 62, 10, nandIronProcCover, 100, 100);

        resId = R.drawable.zeronmproci;
        NorbironSurfaceView.getNodeIds().add(resId);

        nandIronProcCover = android.graphics.BitmapFactory.decodeResource(surfaceView.getResources(), resId);
        nandIronProcCover = android.graphics.Bitmap.createScaledBitmap(nandIronProcCover, 168, 197, false);
        neuronBox[4] = new NeuronBox(neuronSprite, 2 * 14, 64, 62, 10, nandIronProcCover, 100, 100);

        resId = R.drawable.unifnmproci;
        NorbironSurfaceView.getNodeIds().add(resId);

        nandIronProcCover = android.graphics.BitmapFactory.decodeResource(surfaceView.getResources(), resId);
        nandIronProcCover = android.graphics.Bitmap.createScaledBitmap(nandIronProcCover, 168, 197, false);
        neuronBox[5] = new NeuronBox(neuronSprite, 2 * 14, 64, 62, 10, nandIronProcCover, 100, 100);

        resId = R.drawable.addproci;
        NorbironSurfaceView.getNodeIds().add(resId);

        nandIronProcCover = android.graphics.BitmapFactory.decodeResource(surfaceView.getResources(), resId);
        nandIronProcCover = android.graphics.Bitmap.createScaledBitmap(nandIronProcCover, 168, 197, false);
        neuronBox[6] = new NeuronBox(neuronSprite, 2 * 14, 64, 62, 10, nandIronProcCover, 100, 100);

        resId = R.drawable.mulproci;
        NorbironSurfaceView.getNodeIds().add(resId);

        nandIronProcCover = android.graphics.BitmapFactory.decodeResource(surfaceView.getResources(), resId);
        nandIronProcCover = android.graphics.Bitmap.createScaledBitmap(nandIronProcCover, 168, 197, false);

        neuronBox[7] = new NeuronBox(neuronSprite, 2 * 14, 64, 62, 10, nandIronProcCover, 100, 100);

        resId = R.drawable.nandironproci;
        NorbironSurfaceView.getNodeIds().add(resId);

        nandIronProcCover = android.graphics.BitmapFactory.decodeResource(surfaceView.getResources(), resId);
        nandIronProcCover = android.graphics.Bitmap.createScaledBitmap(nandIronProcCover, 168, 197, false);

        neuronBox[8] = new NeuronBox(neuronSprite, 2 * 14, 64, 62, 25, nandIronProcCover, 100, 100);

        resId = R.drawable.nandironproci2;
        NorbironSurfaceView.getNodeIds().add(resId);

        nandIronProcCover = android.graphics.BitmapFactory.decodeResource(surfaceView.getResources(), resId);
        nandIronProcCover = android.graphics.Bitmap.createScaledBitmap(nandIronProcCover, 168, 197, false);

        neuronBox[9] = new NeuronBox(neuronSprite, 2 * 14, 64, 62, 50, nandIronProcCover, 350, 100);

        resId = R.drawable.matyironproci;
        NorbironSurfaceView.getNodeIds().add(resId);

        nandIronProcCover = android.graphics.BitmapFactory.decodeResource(surfaceView.getResources(), resId);
        nandIronProcCover = android.graphics.Bitmap.createScaledBitmap(nandIronProcCover, 168, 197, false);

        neuronBox[10] = new NeuronBox(neuronSprite, 2 * 14, 64, 62, 25, nandIronProcCover, 600, 100);

        resId = R.drawable.matyironproci2;
        NorbironSurfaceView.getNodeIds().add(resId);

        nandIronProcCover = android.graphics.BitmapFactory.decodeResource(surfaceView.getResources(), resId);
        nandIronProcCover = android.graphics.Bitmap.createScaledBitmap(nandIronProcCover, 168, 197, false);

        neuronBox[11] = new NeuronBox(neuronSprite, 2 * 14, 64, 62, 50, nandIronProcCover, 100, 400);

        resId = R.drawable.gretironproci;
        NorbironSurfaceView.getNodeIds().add(resId);

        nandIronProcCover = android.graphics.BitmapFactory.decodeResource(surfaceView.getResources(), resId);
        nandIronProcCover = android.graphics.Bitmap.createScaledBitmap(nandIronProcCover, 168, 197, false);

        neuronBox[12] = new NeuronBox(neuronSprite, 2 * 14, 64, 62, 25, nandIronProcCover, 350, 400);

        resId = R.drawable.gretironproci2;
        NorbironSurfaceView.getNodeIds().add(resId);

        nandIronProcCover = android.graphics.BitmapFactory.decodeResource(surfaceView.getResources(), resId);
        nandIronProcCover = android.graphics.Bitmap.createScaledBitmap(nandIronProcCover, 168, 197, false);

        neuronBox[13] = new NeuronBox(neuronSprite, 2 * 14, 64, 62, 50, nandIronProcCover, 600, 400);

        resId = R.drawable.boxproci;
        //NorbironSurfaceView.getNodeIds().add(resId);

        nandIronProcCover = android.graphics.BitmapFactory.decodeResource(surfaceView.getResources(), resId);
        nandIronProcCover = android.graphics.Bitmap.createScaledBitmap(nandIronProcCover, 168, 197, false);

        neuronBox[14] = new NeuronBox(neuronSprite, 2 * 14, 64, 62, 15, nandIronProcCover, 600, 400);

    }

    public android.graphics.Bitmap getBoardPic() {
        return boardPic;
    }

    public NeuronBox get(int i) {
        if (i < 0) {
            return neuronBox[-i - 1];
        } else {
            return neuronBox[NODES_START + i];
        }

    }

    public int getSize() {
        return neuronBox.length;
    }

}
