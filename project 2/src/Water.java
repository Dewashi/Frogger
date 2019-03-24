import utilities.BoundingBox;

/*Subclass of sprite created for water tiles*/
public class Water extends Tile{
	public Water(String name, String imageSrc, float x, float y) {
		super(name, imageSrc,x, y);
	}
		
		
	/*dynamically creates Water instances in an array to be returned to the World Class
	 * NOTE: function is only dependant on provided parameters*/
	public static void createWater(Water[][] water, int rowNum, float height) {
		int i;
		int j = 0;
		for(i = 0;i<=App.SCREEN_WIDTH;i+=App.SPRITE_WIDTH) {
			water[rowNum][j] = new Water( "water", "assets/water.png",(float) i, height);
			j++;
		}
	}
	
	
	/*Checks each water tile to see if the player has come in contact
	 * with it*/
	public void update(Frog player, Water water) {
		water.contactSprite(player, water);
	}
	
	public void contactSprite(Frog player, Sprite sprite) {
	    BoundingBox playerBox =  new BoundingBox(player.getX(),player.getY(),App.SPRITE_WIDTH,App.SPRITE_HEIGHT);
	    BoundingBox spriteBox = new BoundingBox(sprite.getX(),sprite.getY(),App.SPRITE_WIDTH,App.SPRITE_HEIGHT);
	    if(playerBox.intersects(spriteBox)) {
	    	player.switchWaterStatus(true);
	    	
	    }
	}
}
