/*Class intialises objects and updates game*/
import java.util.ArrayList;

import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

import java.io.FileReader;
import java.io.BufferedReader;



public class World {
	/** player starting midpoint*/
	public static final int PLAYER_START_X = 512;
	public static final int PLAYER_START_Y = 720;
	/** Constants relating to grass, water and bus lanes*/
    public static final int NUM_BUS_LANES = 5;
    public static final int TILES_PER_ROW = 22;
    public static final int NUM_GRASS_ROWS = 2;
    private static float timer = 0;
    private boolean endGame =false;
    private int numWins = 0;
    private ArrayList<Sprite> sprites = new ArrayList<Sprite>();
    private static ArrayList<Life> lifes = new ArrayList<Life>();
    private ArrayList<EndTile> endTiles = new ArrayList<EndTile>();
    private Frog player = new Frog("frog", "assets/frog.png", PLAYER_START_X-App.SPRITE_HEIGHT/2, PLAYER_START_Y-App.SPRITE_HEIGHT/2);
    public ExtraLife extraLife = new ExtraLife("extraLife", "assets/extralife.png", -48, -48,  true);
    
    private int worldIntialised = 0;
 
    int i, j;
	
    
	/*initialises elements in the game
	 * NOTE: static method used to create the arrays 
	 * as an object has not been initialised yet*/
	public World() {

		 
		
		
}
    	
		
	
	public boolean update(World world, Input input, int delta) {
		int i;
		
		World.timer += delta;
		
		/*Update all of the sprites in the game*/
		player.update(player, input);
		
		for(i=0;i<sprites.size();i++) {
			sprites.get(i).update(player, sprites.get(i), delta);
		}
		
		extraLife.update(player, extraLife, sprites, delta);
		
		for(i=0;i<endTiles.size();i++) {
			endTiles.get(i).update(player, endTiles.get(i));
		}
		
		
		
		/*busLanes[0][0].update(busLanes, player, delta);*/     
        /*water[0][0].update(player, water);*/
        
        player.statusCheck();
        world.checkEnd();
        
        return endGame;
        
        
	}
	
	public void initialise(World world, String level) {
		
		
		if (worldIntialised == 0) {
			timer = 0;
			lifes.clear();
			world.createInstance(level);
			
		}
		worldIntialised = 1;
		
		world.render();
		
	}
	
	public void createInstance(String level) {
		int i;
		try (BufferedReader br = new BufferedReader(new FileReader(level))) {

	            String text;   
	            
	            
	            while ((text = br.readLine()) != null) {
	                
	                String[] fields = text.split(",");
	                int len = (fields.length);
	                if (len == 3) {	                	
	                	Tile.createTiles(sprites, fields);
	                }
	                if (len == 4) {	                	
	                	MovingSprite.createMovingSprites(sprites, fields);
	                }
	               /* for (i = 0; i<len; i++){
	                    System.out.print(fields[i]+"***\n");
	                    
	                }*/
	                    
	               
	            }
	    } 
		
		catch (Exception e) {
	       e.printStackTrace();
	    }

		
		for(i=0; i<Life.numLifes; i++) {
			lifes.add(new Life("lives", "assets/lives.png", Life.XDrawPos, 744-App.SPRITE_HEIGHT/2));
			Life.XDrawPos += 32;
		}
		
		j = 96;
		for(i=0; i<5; i++) {
			endTiles.add(new EndTile("endTile", "assets/frog.png", j, 24));
			endTiles.get(i).setDrawStatus(false);
			j += 192;
		}
	
		
	}
	
	
	
	public void render() {
		
		
		for(i=0;i<sprites.size();i++) {
			if(sprites.get(i).getDrawStatus() == true)
			sprites.get(i).render(sprites.get(i).getImage());
		}
		
		for(i=0;i<endTiles.size();i++) {
			if(endTiles.get(i).getDrawStatus() == true)
				endTiles.get(i).render(endTiles.get(i).getImage());
		}
		
		

   
		
		
		for(i=0;i<lifes.size();i++) {
			if(lifes.get(i).getDrawStatus() == true)
				lifes.get(i).render(lifes.get(i).getImage());
		}
		
		/*renders the player*/
		player.render(player.getImage());
		
		if (extraLife.getDrawStatus() == true) {
			extraLife.render(extraLife.getImage());

		}
		
		
		
		
	}
	
	public void checkEnd() {
		
		for(i=0;i<endTiles.size();i++) {
			if(endTiles.get(i).getDrawStatus() == true)
				numWins += 1;
		}
		
		
		if (numWins == 5) {
			/*level = "assets/levels/1.lvl";
			worldIntialised = 0;*/
			endGame = true;
			Log.logCount = 0;
			Life.XDrawPos = 24-App.SPRITE_HEIGHT/2;
			System.out.print("hi\n");
			return;
			
		}
		
		numWins = 0;
		
		
	}
	
	public static void updateLife(String command) {
		if (command.equals("add")) {
			Life.add(lifes);
		}
		if (command.equals("remove")) {
			Life.remove(lifes);
		}
	}
	
	public static float getTimer() {
		return World.timer;
	}
}
