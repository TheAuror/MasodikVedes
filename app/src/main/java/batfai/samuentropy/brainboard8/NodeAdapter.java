package batfai.samuentropy.brainboard8;

/**
 * Created by Auror on 2016.10.22..
 */

public class NodeAdapter extends android.widget.BaseAdapter {

    private android.content.Context context;
    java.util.ArrayList<Integer> nodeIds = new java.util.ArrayList<Integer>();

    public void setNodeIds(java.util.ArrayList<Integer> nodeIds) {
        this.nodeIds = nodeIds;
    }

    public NodeAdapter(android.content.Context context) {

        cinit(context);
    }

    public NodeAdapter(android.content.Context context, android.util.AttributeSet attrs) {

        cinit(context);
    }

    public NodeAdapter(android.content.Context context,
                       android.util.AttributeSet attrs, int defStyle) {

        cinit(context);
    }

    private void cinit(android.content.Context context) {

        this.context = context;
    }

    public int getCount() {
        return nodeIds.size();
    }

    public long getItemId(int position) {
        return nodeIds.get(position);
    }

    public Object getItem(int position) {
        return nodeIds.get(position);
    }

    public android.view.View getView(int position, android.view.View oldView, android.view.ViewGroup parent) {

        android.widget.ImageView imageView;

        if (oldView != null) {
            imageView = (android.widget.ImageView) oldView;
        } else {
            imageView = new android.widget.ImageView(context);
        }

        imageView.setImageResource(nodeIds.get(position));
        return imageView;
    }

}