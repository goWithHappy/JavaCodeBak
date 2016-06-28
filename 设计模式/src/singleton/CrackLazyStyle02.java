package singleton;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;

/**
 * ͨ�����л��ͷ����л������в���
 * @author Admain
 *
 */
public class CrackLazyStyle02 {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		LazyStyle s1=LazyStyle.getInstance();
		//�����л�
		OutputStream fos=new FileOutputStream("d:/a.txt");
		ObjectOutputStream oos=new ObjectOutputStream(fos);
		oos.writeObject(s1);
		oos.close();
		fos.close();
		//�����л������ɶ������
		ObjectInputStream ois=new ObjectInputStream(new FileInputStream("d:/a.txt"));
		LazyStyle s2=(LazyStyle) ois.readObject();
		System.out.println(s2);
		System.out.println(s1);
	}
	
	
}
