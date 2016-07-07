package between;

import java.util.ArrayList;
import java.util.List;

/**
 * 用来记录客户端发来的信息
 * @author Admain
 *
 */
public class CurrentInfo {
	private static List<String> list=new ArrayList<>();
	/**
	 * 记录发过来的最新信息，并且始终保持100条最新的记录
	 * @param Info
	 */
	public static void add(String Info){
		if(Info!=null){
			list.add(Info);
		}
		if(list.size()>100){
			list.remove(list.size()-1);
		}
	}
	/**
	 * 返回最新的一条坐标信息
	 * @return
	 */
	public static String getOneInfo(){
		return  list.get(0);
	}
	/**
	 * 返回指定数量的坐标信息
	 * @param count
	 * @return
	 */
	public static List<String> getInfo(int count){
		List<String> listInfo=null;
		if(list.size()<count){
			listInfo=list;
		}
		else{
			if(listInfo==null){
				listInfo=new ArrayList();
			}
			for(int i=0;i<count;i++){
				listInfo.add(list.get(i));
			}
		}
		return listInfo;
	}
}
