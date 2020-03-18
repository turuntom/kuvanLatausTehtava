package tomi.imagejuttu;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.SimpleAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class KuvaAdapteri extends BaseAdapter {

    private Context context;
    private LayoutInflater layoutInflater;
    private ArrayList<String> imageUrls;

    public KuvaAdapteri(@NonNull Context context, @Nullable ArrayList<String> imageUrls) {
        this.layoutInflater = LayoutInflater.from(context);
        this.context = context;
        this.imageUrls = imageUrls;
    }

    @Override
    public int getCount() {
        return imageUrls.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.listaleiska, parent, false);
        }

        ImageView imageView = (ImageView) convertView.findViewById(R.id.imageView);

        Picasso.get()
                .load(imageUrls.get(position))
                .into(imageView);



        return convertView;
    }
}
