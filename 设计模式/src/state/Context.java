package state;

/**
 * 
 * @author Admain
 *
 */
public class Context {
	private State state;
	public void setState(State s){
		System.out.println("�޸�״̬��");
		state=s;
		state.handle();
	}
}
