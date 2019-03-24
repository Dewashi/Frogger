import utilities.BoundingBox;

/*subclass of sprite created for grass tiles*/
public class EndTile extends Tile{
	public EndTile(String name, String imageSrc, float x, float y) {
		super(name, imageSrc,x, y);	
	}
		
		
	public void update(Frog player, EndTile endTile) {
		endTile.contactSprite(player, endTile);
		
	}
	
	public void contactSprite(Frog player, EndTile endTile) {
	    BoundingBox playerBox =  new BoundingBox(player.getX(),player.getY(),App.SPRITE_WIDTH,App.SPRITE_HEIGHT);
	    BoundingBox spriteBox = new BoundingBox(endTile.getX(),endTile.getY(),App.SPRITE_WIDTH,App.SPRITE_HEIGHT);
	    if(playerBox.intersects(spriteBox)) {
	    	if(this.getDrawStatus() == true) {
	    		player.resetPos();
	    		World.updateLife("remove");
	    		return;
	    	}
	    	player.resetPos();
	    	this.setDrawStatus(true);
	    	player.resetPos();
	    	
	    }
	}
}
