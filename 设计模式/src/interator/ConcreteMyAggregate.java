package interator;

import java.util.ArrayList;
import java.util.List;

/**
 * 自定义聚合类
 * @author Admain
 *
 */
public class ConcreteMyAggregate {
	private List<Object> list=new ArrayList<>();
	private int cursor;
	/**
	 * 获得迭代器
	 * @param obj
	 */
	public MyInterator createInrator(){
		return new ConcretrIterator(); 
	}
	public void addObject(Object obj){
		list.add(obj);
	}
	public void removeObj(int index){
		this.list.remove(index);
	}
	public List<Object> getList() {
		return list;
	}
	public void setList(List<Object> list) {
		this.list = list;
	}
	/**
	 * 定义了内部类，用于实现迭代器
	 * @author Admain
	 *
	 */
	private class ConcretrIterator implements MyInterator{
		@Override
		public void first() {
			cursor=0;
		}

		@Override
		public void next() {
			if(cursor<list.size()){
				cursor++;
			}
		}

		@Override
		public boolean hasNext() {
			return cursor<list.size()?true:false;
		}

		@Override
		public boolean isFirst() {
			return cursor==1;
		}

		@Override
		public boolean isLast() {
			return cursor==(list.size()-1);
		}

		@Override
		public Object getCurrentObj() {
			return list.get(cursor);
		}
	}
}
