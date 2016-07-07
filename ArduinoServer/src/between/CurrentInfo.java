package between;

import java.util.ArrayList;
import java.util.List;

/**
 * ������¼�ͻ��˷�������Ϣ
 * @author Admain
 *
 */
public class CurrentInfo {
	private static List<String> list=new ArrayList<>();
	/**
	 * ��¼��������������Ϣ������ʼ�ձ���100�����µļ�¼
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
	 * �������µ�һ��������Ϣ
	 * @return
	 */
	public static String getOneInfo(){
		return  list.get(0);
	}
	/**
	 * ����ָ��������������Ϣ
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
