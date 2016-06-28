package strategy;

/**
 * 负责和具体的算法进行交互，使得算法可以独立与客户端，独立变化
 * @author Admain
 *
 */
public class Context {
	private Strategy strategy;
	/**
	 * 通过构造来注入
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
		System.out.println("应该报的价"+strategy.getPrice(s));
	}
	
}
