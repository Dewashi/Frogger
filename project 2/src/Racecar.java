public class Racecar extends Vehicle{
	
	public static final float RACECAR_VELOCITY = (float) 0.5;
	public Racecar (String name, String imageSrc, float x, float y, boolean direction) {
		super(name, imageSrc,x, y, direction);	
	}
	
	
	public void update(Frog player, Racecar racecar,int delta) {
		racecar.collide(player, racecar);
		racecar.move(racecar.getImage(), racecar, delta, RACECAR_VELOCITY);
	}
	

	
	
}
	