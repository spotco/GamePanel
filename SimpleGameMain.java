import java.awt.Color;


public class SimpleGameMain extends GamePanel {
	
	public static void main(String[] args) {
		new SimpleGameMain(300,300);
	}
	
	public int _player_x,_player_y;
	public int _food_x,_food_y;

	public SimpleGameMain(int width, int height) {
		super(width, height);
		move_food();
	}
	
	public void move_food(){
		_food_x = (int) (Math.random()*get_width());
		_food_y = (int) (Math.random()*get_height());
	}
	
	public double get_food_dist() {
		return Math.sqrt(Math.pow(_player_x-_food_x,2)+Math.pow(_player_y-_food_y,2));
	}
	
	@Override
	public void update() {
		clear();
		
		if (is_key_down(KEY_UP)) {
			_player_y-=5;
		}
		if (is_key_down(KEY_DOWN)) {
			_player_y+=5;
		} 
		if (is_key_down(KEY_LEFT)) {
			_player_x-=5;
		}
		if (is_key_down(KEY_RIGHT)) {
			_player_x+=5;
		}
		
		if (get_food_dist()<15) {
			move_food();
		}
		
		_g.setColor(Color.RED);
		_g.fillOval(_player_x-10, _player_y-10, 20, 20);
		
		_g.setColor(Color.GREEN);
		_g.fillOval(_food_x-5, _food_y-5, 10, 10);
	}

}
