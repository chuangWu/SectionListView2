package cn.chuangblog.sectionlistview2;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;


public class SimpleActivity extends Activity {
	private SectionListView listView;
	List<Entity> entityList = new ArrayList<Entity>();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_simple);

		listView = (SectionListView) findViewById(R.id.listView);

		initData();
		ListAdapter adapter = new ListAdapter(this, entityList);
		listView.setAdapter(adapter);

	}
	private void initData() {

		Entity section1 = new Entity();
		section1.setType(Entity.SECTION);
		section1.setName("张");
		entityList.add(section1);
		for (int i = 0; i < 15; i++) {
			Entity entity = new Entity();
			entity.setName("张"+i);
			entity.setType(Entity.ITEM);
			entityList.add(entity);
		}
		
		
		
		
		Entity section2 = new Entity();
		section2.setType(Entity.SECTION);
		section2.setName("李");
		entityList.add(section2);
		for (int i = 0; i < 25; i++) {
			Entity entity = new Entity();
			entity.setName("李"+i);
			entity.setType(Entity.ITEM);
			entityList.add(entity);
		}
		
		
		Entity section3 = new Entity();
		section3.setType(Entity.SECTION);
		section3.setName("刘");
		entityList.add(section3);
		for (int i = 0; i < 15; i++) {
			Entity entity = new Entity();
			entity.setName("刘"+i);
			entity.setType(Entity.ITEM);
			entityList.add(entity);
		}
	}

}
