package composite;
/**
 * �������
 * @author Admain
 *
 */
public interface Component {
	void operation();
}

//Ҷ�����
interface leaf extends Component{
	
}
//�������
interface Composite extends Component{
	void add(Component c);
	void remove(Component c);
	Component getChild(int index);
}