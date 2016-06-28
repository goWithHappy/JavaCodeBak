package interator;

/**
 * ²âÊÔµü´úÆ÷
 * @author Admain
 *
 */
public class Client {
	public static void main(String[] args) {
		ConcreteMyAggregate cma=new ConcreteMyAggregate();
		cma.addObject("aaa");
		cma.addObject("bbb");
		cma.addObject("ccc");
		MyInterator iter=cma.createInrator();
		while(iter.hasNext()){
			System.out.println(iter.getCurrentObj());
			iter.next();
		}
	}
}
