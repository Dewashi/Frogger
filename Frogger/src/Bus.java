public class Bus extends Vehicle{
	
	public static final float BUS_VELOCITY = (float) 0.15;
	public Bus(String name, String imageSrc, float x, float y, boolean direction) {
		super(name, imageSrc,x, y, direction);	
	}
	
	
	public void update(Frog player, Bus bus,int delta) {
		
		bus.collide(player, bus);
		bus.move(bus.getImage(), bus, delta, BUS_VELOCITY);
	}
	

	
}
	