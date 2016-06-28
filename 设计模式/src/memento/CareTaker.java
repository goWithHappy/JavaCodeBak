package memento;
/**
 * 负责人类进行数据的管理
 * @author Admain
 *
 */
public class CareTaker {
	private EmpMemento memento;

	public EmpMemento getMemento() {
		return memento;
	}

	public void setMemento(EmpMemento memento) {
		this.memento = memento;
	}
	
}
