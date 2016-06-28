package strategy;
/**
 * 测试策略模式
 * @author Admain
 *
 */
public class Client {
	public static void main(String[] args) {
		Strategy s1=new NewCustromerManyStratefy();  //不同用户使用不同算法
		Context context=new Context(s1);
		context.printPrice(998);
	}
}
