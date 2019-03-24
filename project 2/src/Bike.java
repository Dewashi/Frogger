public class Bike extends Vehicle{
	
	public static final float BIKE_VELOCITY = (float) 0.2;
	public Bike(String name, String imageSrc, float x, float y, boolean direction) {
		super(name, imageSrc,x, y, direction);	
	}
	
	
	public void update(Frog player, Bike bike,int delta) {
		
		bike.determineDirection();
		bike.collide(player, bike);
		bike.move(bike.getImage(), bike, delta, BIKE_VELOCITY);
	}

	public void determineDirection() {
		if ((int)this.getX()<= 24-App.SPRITE_WIDTH/2) {
			this.switchDirection(true);
		}
		
		if ((int)this.getX()>= 1000-App.SPRITE_WIDTH/2) {
			this.switchDirection(false);
		}
		
	}
	
	
}
	