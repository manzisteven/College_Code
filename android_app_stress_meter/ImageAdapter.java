package mobilestressmeter.edu.cmu.stressmeter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import mobilestressmeter.edu.cmu.psm.PSM;


public class ImageAdapter extends BaseAdapter {
    private Context mContext;
    public Integer[] mThumbIds;

    public ImageAdapter(Context c) {
        mContext = c;
    }

    public int getCount() {
        return mThumbIds.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    public Integer[] getGrid(int gridNo){

        int [] data=PSM.getGridById(gridNo);

        Integer [] grid = new Integer[data.length];

        for(int i=0;i<data.length;i++){
            grid[i] =data[i];
        }

        return grid;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            imageView = new ImageView(mContext);
            //imageView.setLayoutParams(new GridView.LayoutParams(150, 150));
            imageView.setLayoutParams(new GridView.LayoutParams(
                    (int)mContext.getResources().getDimension(R.dimen.width),
                    (int)mContext.getResources().getDimension(R.dimen.height)));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(0, 0, 0, 0);
        } else {
            imageView = (ImageView) convertView;
        }

        imageView.setImageResource(mThumbIds[position]);
        return imageView;
    }

    // references to our images




}
