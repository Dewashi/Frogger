import java.util.ArrayList;

import org.newdawn.slick.Image;

/*subclass of sprite created for grass tiles*/
public class MovingSprite extends Sprite{
	public static final float TURTLE_WIDTH = (float) 144;
	public static final float LOG_WIDTH = (float) 132;
	public static final float LONG_LOG_WIDTH = (float) 144;
	
	private int directionMultiplier = 1;
	private boolean direction;
	public MovingSprite(String name, String imageSrc, float x, float y, boolean direction) {
		super(name, imageSrc,x, y);	
		this.direction = direction;
	}
	
	public boolean getDirection() {
		return this.direction;
	}
	
	public int getDirectionMutiplier() {
		return this.directionMultiplier;
	}
	
	public void switchDirection(boolean direction) {
		this.direction = direction;
	}
	
	public static void createMovingSprites(ArrayList<Sprite> sprites, String[] details ) {
		int i, j;
		if (details[0].equals("bus") ) {
			sprites.add(new Bus("bus", "assets/bus.png", Float.parseFloat(details[1])-App.SPRITE_HEIGHT/2, Float.parseFloat(details[2])-App.SPRITE_HEIGHT/2, Boolean.parseBoolean(details[3])));
		}
		
		if (details[0].equals("bike") ) {
			sprites.add(new Bike("bike", "assets/bike.png", Float.parseFloat(details[1])-App.SPRITE_HEIGHT/2, Float.parseFloat(details[2])-App.SPRITE_HEIGHT/2, Boolean.parseBoolean(details[3])));
		}
		
		if (details[0].equals("racecar") ) {
			sprites.add(new Racecar("racecar", "assets/racecar.png", Float.parseFloat(details[1])-App.SPRITE_HEIGHT/2, Float.parseFloat(details[2])-App.SPRITE_HEIGHT/2, Boolean.parseBoolean(details[3])));
		}
		
		if (details[0].equals("bulldozer") ) {
			sprites.add(new Bulldozer("bulldozer", "assets/bulldozer.png", Float.parseFloat(details[1])-App.SPRITE_HEIGHT/2, Float.parseFloat(details[2])-App.SPRITE_HEIGHT/2, Boolean.parseBoolean(details[3])));
		}
		
		if (details[0].equals("longLog")) {
			sprites.add(new Log("longLog", "assets/longLog.png", Float.parseFloat(details[1])-LONG_LOG_WIDTH/2, Float.parseFloat(details[2])-App.SPRITE_HEIGHT/2, Boolean.parseBoolean(details[3])));
			Log.logCount += 1;
		}
		
		if (details[0].equals("log")) {
			sprites.add(new Log("log", "assets/log.png", Float.parseFloat(details[1])-LOG_WIDTH/2, Float.parseFloat(details[2])-App.SPRITE_HEIGHT/2, Boolean.parseBoolean(details[3])));
			Log.logCount += 1;
		}
		
		if (details[0].equals("turtle")) {
			sprites.add(new Turtle("turtle", "assets/turtles.png", Float.parseFloat(details[1])-TURTLE_WIDTH/2, Float.parseFloat(details[2])-App.SPRITE_HEIGHT/2, Boolean.parseBoolean(details[3])));
		}
		
		
		
		
		
		
	}
	
	
	public void setDirectionMultiplier(boolean direction) {
		if (direction == false) {
			this.directionMultiplier = -1;
		}
		if (direction == true) {
			this.directionMultiplier = 1;
		}
		
		
	}
	
	public void move(Image img, MovingSprite sprite,int delta, float velocity) {
		sprite.setDirectionMultiplier(this.getDirection());
		if ((int)sprite.getX()<= -img.getWidth()) {
			sprite.incrementX(App.SCREEN_WIDTH+img.getWidth());
		}
		
		if ((int)sprite.getX()>= App.SCREEN_WIDTH) {
			sprite.incrementX(-App.SCREEN_WIDTH-img.getWidth());
		}
		
		/*sets the velocity of the bus at 0.15 pixels per millisecond*/
		sprite.incrementX((float) this.directionMultiplier*velocity*delta);
	}

	
	
}
		