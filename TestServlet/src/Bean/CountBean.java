package Bean;
import java.io.Serializable;

//�±�ָ���л��ӿڣ�ָʵ�ָýӿڵ�����Խ�����д�뵽�ļ���
public class CountBean implements Serializable{
	int count=0;
	//дһ���չ�����������������
	public CountBean(){
		
	}
	public int getCount()
	{
		count++;
		return count;
	}
	public void setCount(int c)
	{
		count=c;
	}
}
