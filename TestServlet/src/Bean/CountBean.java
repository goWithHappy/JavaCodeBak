package Bean;
import java.io.Serializable;

//下边指序列化接口，指实现该接口的类可以将对象写入到文件中
public class CountBean implements Serializable{
	int count=0;
	//写一个空构造器供服务器调用
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
