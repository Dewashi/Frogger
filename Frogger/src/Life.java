import java.util.ArrayList;

/*subclass of sprite created for grass tiles*/
public class Life extends Tile{
	public static int numLifes = 3;
	public static float XDrawPos = 24-App.SPRITE_HEIGHT/2;
	public Life(String name, String imageSrc, float x, float y) {
		super(name, imageSrc,x, y);	
	}
	
	public static void remove(ArrayList<Life> lifes) {
		XDrawPos-= 32;
		numLifes -= 1;
		Life.checkEnd();
		lifes.remove(lifes.size()-1);
		
		
	}
	public static void add(ArrayList<Life> lifes) {
		numLifes += 1;
		lifes.add(new Life("lives", "assets/lives.png", XDrawPos, 744-App.SPRITE_HEIGHT/2));
		XDrawPos += 32;
	}
		
	public static void checkEnd (){
		if (numLifes == 0) {
			System.exit(1);
		}
	}
	
}