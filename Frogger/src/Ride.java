import utilities.BoundingBox;

/*subclass of sprite created for grass tiles*/
public class Ride extends MovingSprite{
	public Ride(String name, String imageSrc, float x, float y, boolean direction) {
		super(name, imageSrc,x, y, direction);	
	}
	
	public void contactSprite(Frog player, Sprite sprite, int delta, float velocity) {
	    BoundingBox playerBox =  new BoundingBox(player.getX()+player.getImage().getWidth()/2,player.getY(),player.getImage().getWidth(),player.getImage().getHeight());
	    BoundingBox spriteBox = new BoundingBox(sprite.getX()+sprite.getImage().getWidth()/2,sprite.getY(),sprite.getImage().getWidth(),sprite.getImage().getHeight());
	    if(playerBox.intersects(spriteBox) && sprite.getDrawStatus() == true) {
	    	player.switchRideStatus(true);
	    	player.incrementX(this.getDirectionMutiplier()*velocity*delta);
	    	System.out.print("Ride\n");
		}
	}
	
	
	
	

	
}
		