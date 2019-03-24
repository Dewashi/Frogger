/*subclass of sprite created for grass tiles*/
public class Vehicle extends MovingSprite{
	public Vehicle(String name, String imageSrc, float x, float y, boolean direction) {
		super(name, imageSrc,x, y, direction);	
	}
	
	public void collide(Frog player, Vehicle vehicle) {
		vehicle.contactSprite(player, vehicle);
		
	}

	
}
		