package strategy;
/**
 * ���Բ���ģʽ
 * @author Admain
 *
 */
public class Client {
	public static void main(String[] args) {
		Strategy s1=new NewCustromerManyStratefy();  //��ͬ�û�ʹ�ò�ͬ�㷨
		Context context=new Context(s1);
		context.printPrice(998);
	}
}
