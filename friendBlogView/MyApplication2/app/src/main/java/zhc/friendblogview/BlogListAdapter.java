package zhc.friendblogview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.HeaderViewListAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.List;
import java.util.Map;

/**
 * Created by apple on 16/1/6.
 * 用于ListView的内容适配
 */
public class BlogListAdapter extends BaseAdapter {
    private Context context;
    private int itemViewResource;
    private LayoutInflater mInflater;
    private List<BlogDomain> listItems;


    public BlogListAdapter(Context context, List<BlogDomain> data) {
        this.context = context;
        this.mInflater = LayoutInflater.from(context);    //创建视图容器并设置上下文
        this.listItems = data;

    }

    public final class ViewHolder {
        public ImageView headImg;
        public TextView nameTxt,infoTxt,contentTxt;
    }


    @Override
    public int getCount() {
        return listItems.size();
    }

    @Override
    public Object getItem(int arg0) {
        return null;
    }

    @Override
    public long getItemId(int arg0) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = mInflater.inflate(R.layout.blog_list_view,null);
            holder.headImg = (ImageView) convertView.findViewById(R.id.head_image);
            holder.nameTxt = (TextView) convertView.findViewById(R.id.title_name);
            holder.infoTxt = (TextView) convertView.findViewById(R.id.title_info);
            holder.contentTxt = (TextView) convertView.findViewById(R.id.content_txt);
            initData(holder,position);
            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }





        return convertView;
    }

    private void initData(ViewHolder holder,int position){
        holder.headImg.setImageResource(listItems.get(position).getHeadImg());
        holder.nameTxt.setText(listItems.get(position).getName());
        holder.contentTxt.setText(listItems.get(position).getContent());
        holder.infoTxt.setText(listItems.get(position).getInfo());
    }
}
