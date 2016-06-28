package factor.abstractFatory;
/**
 * 创造车子
 * @author Admain
 *
 */
public interface CarFactory {
	Engine createEngine();
	Seat createSeat();
}
