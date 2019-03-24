import org.newdawn.slick.Input;

import utilities.BoundingBox;

public class Bulldozer extends Vehicle{
	
	public static final float BULLDOZER_VELOCITY = (float) 0.05;
	public Bulldozer(String name, String imageSrc, float x, float y, boolean direction) {
		super(name, imageSrc,x, y, direction);	
	}
	
	
	public void update(Frog player, Bulldozer bulldozer,int delta) {
		bulldozer.contactSprite(player, bulldozer, delta);
		bulldozer.move(bulldozer.getImage(), bulldozer, delta, BULLDOZER_VELOCITY );
		bulldozer.block(player, bulldozer,"North");
		bulldozer.block(player, bulldozer,"East");
		bulldozer.block(player, bulldozer,"South");
		bulldozer.block(player, bulldozer,"West");
		
		
	}
	
	public void contactSprite(Frog player, Bulldozer bulldozer, int delta) {
	    BoundingBox playerBox =  new BoundingBox(player.getX(),player.getY(),App.SPRITE_WIDTH,App.SPRITE_HEIGHT);
	    BoundingBox spriteBox = new BoundingBox(bulldozer.getX(),bulldozer.getY(),App.SPRITE_WIDTH,App.SPRITE_HEIGHT);
	    if(playerBox.intersects(spriteBox)) {
			player.incrementX(this.getDirectionMutiplier()*BULLDOZER_VELOCITY*delta);
		}
	}
	
	public void block(Frog player, Bulldozer bulldozer, String direction) {
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
	
	
	/*public void move(Bulldozer bulldozer,int delta) {
		if ((int)bulldozer.getX()<= -App.SPRITE_WIDTH) {
			bulldozer.setX(App.SCREEN_WIDTH+App.SPRITE_WIDTH);
		}
		
		bulldozer.setX((float)-BULLDOZER_VELOCITY*delta);
	}*/
	
	
}
	