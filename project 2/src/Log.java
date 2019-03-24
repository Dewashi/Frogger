/*subclass of sprite created for grass tiles*/
public class Log extends Ride{
	public static final float LONG_LOG_VELOCITY = (float) 0.07;
	public static final float LOG_VELOCITY = (float) 0.1;
	public static int logCount = 0;
	
	public Log(String name, String imageSrc, float x, float y, boolean direction) {
		super(name, imageSrc,x, y, direction);	
	}
	
	
	public void update(Frog player, Log log,int delta) {
		if (log.getName().equals("longLog")) { 
			log.move(log.getImage(), log, delta, LONG_LOG_VELOCITY );
			log.contactSprite(player, log, delta, LONG_LOG_VELOCITY );
		
		
		}
		if (log.getName().equals("log")) { 
			log.move(log.getImage(), log, delta, LOG_VELOCITY );
			log.contactSprite(player, log, delta, LOG_VELOCITY);
		
		}
		
		
		
	}
	
}