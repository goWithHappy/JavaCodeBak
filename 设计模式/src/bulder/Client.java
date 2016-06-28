package bulder;

public class Client {
	public static void main(String[] args) {
		AirShipDirector director=new SxtAirShipDirector(new SxtAirShipBuilder());
		AirShip ship=director.directAirShip();
		System.out.println(ship.getEngine());
	}
}
