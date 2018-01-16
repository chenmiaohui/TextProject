package list.chenmiaohui.com.textproject;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.util.List;

/**
 * 适配器
 * Created by cmh on 2018/1/15.
 */

public class MyAdapter  extends BaseAdapter{

    private List<File> dataLists;
    private Context mContent;

    public MyAdapter(Context mContent) {
        this.mContent = mContent;
    }

    public List<File> getDataLists() {
        return dataLists;
    }

    public void setDataLists(List<File> dataLists) {
        this.dataLists = dataLists;
    }
    //list条目
    @Override
    public int getCount() {
        if (dataLists!=null){
            return dataLists.size();
        }
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder =null;
        if (convertView==null){
            convertView = LayoutInflater.from(mContent).inflate(R.layout.item_list,null);
            //忘记创建ViewHolder  重大失误！！！！！！
            viewHolder = new ViewHolder();
            viewHolder.tv = (TextView) convertView.findViewById(R.id.tv);
            viewHolder.img = (ImageView) convertView.findViewById(R.id.img);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        File file = dataLists.get(position);
//        Log.e("ii",text.getName());
        viewHolder.tv.setText(file.getName());//名字
//        viewHolder.img.setImageResource(file.getImgRed());//头像
        if (file.isDirectory()){
            viewHolder.img.setImageResource(R.mipmap.ic_launcher);
        }else{
            viewHolder.img.setImageResource(R.mipmap.ic_launcher_round);
        }
        return convertView;
    }

    class  ViewHolder{
        ImageView img;
        TextView tv;
    }
}
