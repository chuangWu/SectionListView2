package cn.chuangblog.sectionlistview2;

import java.util.List;


import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ListAdapter extends BaseAdapter implements
		SectionListView.PinnedSectionListAdapter {

	private Context context;
	private List<Entity> entityList;
	private Entity entity;

	public ListAdapter(Context context, List<Entity> entityList) {
		this.context = context;
		this.entityList = entityList;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return entityList.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return entityList.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup arg2) {
		entity = entityList.get(position);
		ViewHolder viewHolder;
		if (convertView == null) {
			viewHolder = new ViewHolder();
			if (entity.getType() == Entity.ITEM) {
				convertView = View.inflate(context, R.layout.item_simple, null);
				viewHolder.icon = (ImageView) convertView.findViewById(R.id.icon);
			} else {
				convertView = View.inflate(context, R.layout.selection_simple, null);
				viewHolder.name = (TextView) convertView.findViewById(R.id.name);
			}
			convertView.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) convertView.getTag();
		}

		if (entity.getType() == Entity.ITEM) {
			viewHolder.icon.setImageResource(R.mipmap.ic_launcher);
		}else{
			viewHolder.name.setText(entity.getName());
		}
		
		return convertView;
	}

	private static class ViewHolder {
		private TextView name;
		private ImageView icon;
	}

	@Override
	public boolean isItemViewTypePinned(int viewType) {
		return entity.SECTION == viewType;
	}

	@Override
	public int getViewTypeCount() {
		return 2;
	}

	@Override
	public int getItemViewType(int position) {
		// TODO Auto-generated method stub
		return entityList.get(position).getType();
	}
}
