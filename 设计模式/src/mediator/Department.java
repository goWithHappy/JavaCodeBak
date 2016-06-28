package mediator;

/**
 * 同事类的接口
 * @author Admain
 *
 */
public interface Department {
	void selfAction();//做自己的本分工作
	void outAction();//向总经理发出协调申请
}
