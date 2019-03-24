import utilities.BoundingBox;

/*subclass of sprite created for grass tiles*/
public class Tree extends Tile{
	public Tree(String name, String imageSrc, float x, float y) {
		super(name, imageSrc,x, y);	
	}
		
	
	public void update(Frog player, Tree tree) {
		tree.block(player, tree,"North");
		tree.block(player, tree,"East");
		tree.block(player, tree,"South");
		tree.block(player, tree,"West");
	}
	
	public void block(Frog player, Tree bulldozer, String direction) {
		BoundingBox playerBox =  new BoundingBox((float)100000.0,(float)1000000.0,App.SPRITE_WIDTH,App.SPRITE_HEIGHT);
	    BoundingBox spriteBox = new BoundingBox(bulldozer.getX(),bulldozer.getY(),App.SPRITE_WIDTH,App.SPRITE_HEIGHT);
		/*float playerX = player.getX()+player.getImage().getWidth()/2;
		float bulldozerX = bulldozer.getX()+player.getImage().getWidth()/2;
		float playerY = player.getY()+player.getImage().getHeight()/2;
		float bulldozerY = bulldozer.getY()+player.getImage().getHeight()/2;*/
		
	    /*North*/
		if (direction.equals("North")) {
			playerBox =  new BoundingBox(player.getX(),player.getY()-player.getImage().getHeight(),App.SPRITE_WIDTH,App.SPRITE_HEIGHT);
			if(playerBox.intersects(spriteBox)) {
				player.changeSpeed(direction, player.getY() -bulldozer.getY() -48);
			}
		}
		
		/*East*/	
		if (direction.equals("East")) {
			playerBox =  new BoundingBox(player.getX()+ player.getImage().getWidth(),player.getY(),App.SPRITE_WIDTH,App.SPRITE_HEIGHT);
			if(playerBox.intersects(spriteBox)) {
				player.changeSpeed(direction, bulldozer.getX() -player.getX() -48);

			}
		}
		
		/*South*/
		if (direction.equals("South")) {
			playerBox =  new BoundingBox(player.getX(),player.getY()+player.getImage().getHeight(),App.SPRITE_WIDTH,App.SPRITE_HEIGHT);
			if(playerBox.intersects(spriteBox)) {
				player.changeSpeed(direction, bulldozer.getY() -player.getY() -48);
				
			}
		}
		
		/*West*/
		if (direction.equals("West")) {
			playerBox =  new BoundingBox(player.getX()-player.getImage().getWidth(),player.getY(),App.SPRITE_WIDTH,App.SPRITE_HEIGHT);
			if(playerBox.intersects(spriteBox)) {
				player.changeSpeed(direction, player.getX() -bulldozer.getX() -48);
			}
		}
		
		
		
		
		
		/*if (playerY - player.getImage().getHeight()/2 > bulldozerX - bulldozer.getImage().getHeight() && playerMid + player.getImage().getHeight() > bulldozerMid - bulldozer.getImage().getHeight()) {
			player.disableDirection("North");
			System.out.print("gello\n");
		}*/
		
		
	}
	
}