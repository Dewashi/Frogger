/*subclass of sprite created for grass tiles*/
import java.util.ArrayList;
import java.util.Random;

import utilities.BoundingBox; 
public class ExtraLife extends MovingSprite{
	
	private boolean statusSet = false;
	private boolean logChosen = false;
	private boolean inPlace = false;
	private int logIndex = 0;
	private float lifeSpawnTimer = 0;
	private static float timer = 0;
	private boolean canMove = false;
	private float spaceMoved = 0;
	
	
	
	public ExtraLife(String name, String imageSrc, float x, float y, boolean direction) {
		super(name, imageSrc,x, y, direction);	
	}
	
	public void setLifeStatus() {
		Random rand = new Random(); 
		this.lifeSpawnTimer = 25 + Math.abs(rand.nextInt() % 11);
		this.statusSet = true;
		this.setDrawStatus(false);
		this.spaceMoved = 0;
		this.setDirectionMultiplier(true);
		
	}
	
	public int selectLogNum() {
		Random rand = new Random(); 
		int randNum = Math.abs(rand.nextInt());
		while (randNum == 0) {
			randNum = Math.abs(rand.nextInt());
		}
		return randNum % Log.logCount;
	}
	
	public void update(Frog player, ExtraLife life, ArrayList<Sprite> sprites, int delta) {
		if (this.statusSet == false && this.inPlace == false) {
			life.setLifeStatus();
		}
		
		if (logChosen == false) {
			life.chooseLog(player, life, sprites);
			logChosen = true;
		}
		
		/*set*/
		if (logChosen == true && ExtraLife.timer/1000 >lifeSpawnTimer && this.inPlace == false) {
			this.setDrawStatus(true);
			this.inPlace = true;
			
			ExtraLife.timer = 0;
		}
		
		/*disappear*/
		if ((ExtraLife.timer/1000)>14 && this.inPlace == true) {
			this.setDrawStatus(false);
			this.statusSet = false;
			this.inPlace = false;
			logChosen = false;
			ExtraLife.timer = 0;
			
		}
		
		/*
		if (canMove == true) {
			life.spaceMoved += life.getDirectionMutiplier()*(int)(ExtraLife.timer/1000) % 2;
			canMove = false;
		}
		*/
		if(inPlace == true) {
			
			if (life.getX()+48 >= sprites.get(logIndex).getX() + sprites.get(logIndex).getImage().getWidth()) {
				life.setDirectionMultiplier(false);
			}
			
			if (life.getX() <= sprites.get(logIndex).getX()) {
				life.setDirectionMultiplier(true);
			}
	
			if ((int)ExtraLife.timer/1000 % 2 == 0 && canMove == true) {
				spaceMoved += 1*this.getDirectionMutiplier();
				canMove = false;
			
			}
			
			if ((int)ExtraLife.timer/1000 % 2 == 1) {
			
				canMove = true;
			}
			
		}
		
		/*System.out.print(ExtraLife.timer/1000+"\n");*/
		
		life.placeLife(inPlace, (Log) sprites.get(logIndex),life );
		
		contactSprite(player,  life);
		
		ExtraLife.timer += delta;
		
		
	}
	
	public void placeLife(boolean inPlace, Log log, ExtraLife life ) {
		
		
		
		
		if (this.inPlace == true) {
			life.setX(log.getX()+spaceMoved*life.getImage().getWidth());
			life.setY(log.getY());
		}
		
		
	}
	
	public void chooseLog(Frog player, ExtraLife life, ArrayList<Sprite> sprites) {
		int i, j = -1;
		int logNum = selectLogNum();
		
		/*System.out.print(logNum+"\n");*/
		for(i=0;i<sprites.size();i++) {
			if (sprites.get(i) instanceof Log){
				
				j++;
				if(j == logNum) {
					
					this.logIndex = i;
					
				}
				
			}
			
		}
	}
	
	
	public void contactSprite(Frog player, ExtraLife life) {
	    BoundingBox playerBox =  new BoundingBox(player.getX(),player.getY(),App.SPRITE_WIDTH,App.SPRITE_HEIGHT);
	    BoundingBox spriteBox = new BoundingBox(life.getX(),life.getY(),App.SPRITE_WIDTH,App.SPRITE_HEIGHT);
	    if(playerBox.intersects(spriteBox) && life.getDrawStatus() == true) {
	    	life.setDrawStatus(false);
			World.updateLife("add");
			ExtraLife.timer = 14000;
		}
	}
	
	
	
}
		