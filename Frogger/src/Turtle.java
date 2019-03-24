public class Turtle extends Ride{
	public static final float TURTLE_VELOCITY = (float) 0.085;
	public Turtle(String name, String imageSrc, float x, float y, boolean direction) {
		super(name, imageSrc,x, y, direction);	
	}
	
	public void update(Frog player, Turtle turtle, int delta) {
		turtle.move(turtle.getImage(), turtle, delta, TURTLE_VELOCITY );
	
		
		
		turtle.contactSprite(player, turtle, delta, TURTLE_VELOCITY );
		turtle.hide(turtle, delta);
	}
	
	
	public void hide(Turtle turtle, int delta) {
		

		if ((World.getTimer()/1000)%9 > 7) {
			turtle.setDrawStatus(false);
			
		}
		else {
			turtle.setDrawStatus(true);
		}
	}
	
}