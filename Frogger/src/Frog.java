import org.newdawn.slick.Input;

/*subclass of sprite created for the player*/
public class Frog extends Sprite {
	private boolean onRide = false;
	private boolean onWater = false;
	private boolean invincible = false;
	private float upSpeed = (float) 48.0;
	private float downSpeed = (float) 48.0;
	private float rightSpeed = (float) 48.0;
	private float leftSpeed = (float) 48.0;
	public Frog(String name, String imageSrc, float x, float y) {
		super(name, imageSrc,x, y);
	}

	public void changeSpeed(String direction, float speed) {
		if (direction.equals("North")) {
			this.upSpeed = speed;
		}
		if (direction.equals("East")) {
			this.rightSpeed = speed;
		}
		if (direction.equals("South")) {
			this.downSpeed = speed;
		}
		if (direction.equals("West")) {
			this.leftSpeed = speed;
		}
	}
	
	/*public void disableDirection(String direction) {
		if (direction.equals("North")) {
			this.North = false;
		}
		if (direction.equals("East")) {
			this.East = false;
		}
		if (direction.equals("South")) {
			this.South = false;
		}
		if (direction.equals("West")) {
			this.West = false;
		}
	}*/
	
	public void statusReset() {
		this.onRide = false;
		this.onWater = false;
		/*
		this.North = true;
		this.East = true;
		this.South = true;
		this.West = true;
		*/
		this.upSpeed =  (float) 48.0;
		this.downSpeed =  (float) 48.0;
		this.rightSpeed =  (float) 48.0;
		this.leftSpeed =  (float) 48.0;
	}
	
	public void statusCheck() {
		if ((this.onRide == false && this.onWater == true) || (this.getX() <= 0 - this.getImage().getWidth() || this.getX() >= App.SCREEN_WIDTH)) {
			this.setX(World.PLAYER_START_X-App.SPRITE_HEIGHT/2);
			this.setY( World.PLAYER_START_Y-App.SPRITE_HEIGHT/2);
			World.updateLife("remove");
		}
		
	}
	
	public void switchWaterStatus(boolean status) {
		this.onWater = status;
	}
	
	public boolean getWaterStatus() {
		return(this.onWater);
	}
	
	public void switchRideStatus(boolean status) {
		this.onRide = status;
	}
	
	public boolean getRideStatus() {
		return(this.onRide);
	}
	
	/*Determines if the player can move a certain direction or not. If
	 * the player can move, a method to move the player is called
	 */
	public void update(Frog player, Input input) {
		if (input.isKeyPressed(Input.KEY_UP) ) {
        	if (player.getY()>App.SPRITE_HEIGHT) {
        		player.update_pos("Up");
        	}
		}
        if (input.isKeyPressed(Input.KEY_DOWN) ) {
        	if (player.getY()<App.SCREEN_HEIGHT -App.SPRITE_HEIGHT-App.SPRITE_HEIGHT/2) {
        		player.update_pos("Down");
        	}
		}
        
        if (input.isKeyPressed(Input.KEY_LEFT) ) {
        	if (player.getX()>=App.SPRITE_WIDTH) {
        		player.update_pos("Left");
        	}
		}
        if (input.isKeyPressed(Input.KEY_RIGHT) ) {
        	if (player.getX()+48<(App.SCREEN_WIDTH -App.SPRITE_WIDTH)) {
        		player.update_pos("Right");
        	}
		}
        this.statusReset();
	}
	
	
	/*Moves the position of the player by 48 pixels depending on which key was pressed*/
	public void update_pos(String direction)
	{
		if (direction.equals("Left")){
			incrementX(-leftSpeed);
		}
		if (direction.equals("Right")){
			incrementX(rightSpeed);
		}
		if (direction.equals("Up")){
			incrementY(-upSpeed);
		}
		if (direction.equals("Down")){
			incrementY(downSpeed);
		}
	}
}
