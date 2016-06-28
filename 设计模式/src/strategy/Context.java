package strategy;

/**
 * ����;�����㷨���н�����ʹ���㷨���Զ�����ͻ��ˣ������仯
 * @author Admain
 *
 */
public class Context {
	private Strategy strategy;
	/**
	 * ͨ��������ע��
	 * @param strategy
	 */
	public Context(Strategy strategy) {
		super();
		this.strategy = strategy;
	}
	public Strategy getStrategy() {
		return strategy;
	}
	public void setStrategy(Strategy strategy) {
		this.strategy = strategy;
	}
	public void printPrice(double s){
		System.out.println("Ӧ�ñ��ļ�"+strategy.getPrice(s));
	}
	
}
