import java.util.ArrayList;

/*Subclass of sprite created for buses*/
public class Tile extends Sprite {
	public Tile(String name, String imageSrc, float x, float y) {
		super(name, imageSrc,x, y);	
	}


	public static void createTiles(ArrayList<Sprite> sprites, String[] details ) {
		int i, j;
		if (details[0].equals("water") ) {
			sprites.add(new Water("water", "assets/water.png", Float.parseFloat(details[1])-App.SPRITE_HEIGHT/2, Float.parseFloat(details[2])-App.SPRITE_HEIGHT/2));
		}
		
		if (details[0].equals("grass") ) {
			sprites.add(new Grass("grass", "assets/grass.png", Float.parseFloat(details[1])-App.SPRITE_HEIGHT/2, Float.parseFloat(details[2])-App.SPRITE_HEIGHT/2));
		}
		
		if (details[0].equals("tree") ) {
			sprites.add(new Tree("tree", "assets/tree.png", Float.parseFloat(details[1])-App.SPRITE_HEIGHT/2, Float.parseFloat(details[2])-App.SPRITE_HEIGHT/2));
		}
		
		if (details[0].equals("lives") ) {
			j = 0;
			for(i=0; i<3; i++) {
				sprites.add(new Life("lives", "assets/lives.png", Float.parseFloat(details[1])+j-App.SPRITE_HEIGHT/2, Float.parseFloat(details[2])-App.SPRITE_HEIGHT/2));
				j += 32;
			}
		}
		
		
		/*System.out.print(sprites.size()+"\n");*/

		
		
	}
	
	
}