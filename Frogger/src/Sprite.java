import org.newdawn.slick.Image;
import utilities.BoundingBox;
import org.newdawn.slick.SlickException;


public abstract class Sprite {
	private Image pic;
	private float x;
	private float y;
	private String name;
	private boolean drawStatus = true;
	
	
	/*Initialises a Sprite instance*/
	public Sprite(String name, String imageSrc, float x, float y) {
		this.x = x;
		this.y = y;
		this.name = name;
		try {
			this.pic = new Image(imageSrc);
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}
	
	public boolean getDrawStatus() {
		return this.drawStatus;
	}
	
	public void setDrawStatus(boolean status) {
		this.drawStatus = status;
	}
	
	public void setX(float step) {
		this.x = step;
	}
	
	
	
	public void setY(float step) {
		this.y = step;
	}
	
	
	/*increments the protected x co-ordinate of a Sprite instance 
	 * by a set amount*/
	public void incrementX(float step) {
		this.x += step;
	}
	
	
	/*increments the protected y co-ordinate of a Sprite instance 
	 * by a set amount*/
	public void incrementY(float step) {
		this.y += step;
	}
	
	
	/*Returns the protected x co-ordinate of a Sprite instance*/
	public float getX() {
		return this.x;
	}
	
	
	/*Returns the protected y co-ordinate of a Sprite instance*/
	public float getY() {
		return this.y;
	}
	
	
	/*Returns the protected image of a Sprite instance*/
	public Image getImage()
	{
	    return this.pic;
	}
	
	public String getName()
	{
	    return this.name;
	}
	
	/*renders the selected sprite*/
	public void render(Image sprite) {
		sprite.draw(this.x, this.y);
	}
	
	public void update(Frog player, Sprite sprite, int delta) {
		if (sprite instanceof Water) {
			((Water) sprite).update(player, (Water)sprite);
		}
		
		if (sprite instanceof Tree) {
			((Tree) sprite).update(player, (Tree)sprite);
		}
		
		if (sprite instanceof Bus) {
			((Bus) sprite).update(player, (Bus)sprite, delta);
		}
		
		if (sprite instanceof Bulldozer) {
			((Bulldozer) sprite).update(player, (Bulldozer)sprite, delta);
		}
		
		if (sprite instanceof Racecar) {
			((Racecar) sprite).update(player, (Racecar)sprite, delta);
		}
		
		if (sprite instanceof Bike) {
			((Bike) sprite).update(player, (Bike)sprite, delta);
		}
		
		if (sprite instanceof Log) {
			((Log) sprite).update(player, (Log)sprite, delta);
		}
		if (sprite instanceof Turtle) {
			((Turtle) sprite).update(player, (Turtle)sprite, delta);
		}
		/*
		if (sprite instanceof Life) {
			((Life) sprite).update(player, (Life)sprite, delta);
		}
		*/
	}
	
	
	/*determines if the player has come in contact with water or a bus and if so
	 * ends the game
	 */
	public void contactSprite(Frog player, Sprite sprite) {
	    BoundingBox playerBox =  new BoundingBox(player.getX(),player.getY(),App.SPRITE_WIDTH,App.SPRITE_HEIGHT);
	    BoundingBox spriteBox = new BoundingBox(sprite.getX(),sprite.getY(),App.SPRITE_WIDTH,App.SPRITE_HEIGHT);
	    if(playerBox.intersects(spriteBox)) {
			player.resetPos();
			World.updateLife("remove");
		}
	}
	
	public void resetPos() {
	    this.setX(World.PLAYER_START_X-App.SPRITE_HEIGHT/2);
	    this.setY( World.PLAYER_START_Y-App.SPRITE_HEIGHT/2);
	}
}
