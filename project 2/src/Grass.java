/*subclass of sprite created for grass tiles*/
public class Grass extends Tile{
	public Grass(String name, String imageSrc, float x, float y) {
		super(name, imageSrc,x, y);	
	}
		
		
	/*dynamically creates Grass instances in an array to be returned to the World Class
	 *NOTE: function is only dependant on provided parameters*/
	public static void createGrass(Grass[][] grass, int rowNum, float height) {
		int i;
		int j = 0;
		for(i = 0;i<=App.SCREEN_WIDTH;i+=App.SPRITE_WIDTH) {
			grass[rowNum][j] = new Grass("grass", "assets/grass.png",(float) i, height);
			j++;
		}
	}
}
