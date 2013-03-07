
public class TicTacToeGame extends GridGamePanel {
	
	public static void main(String[] args) { 
		new TicTacToeGame(3); 
	}
	
	public TicTacToeGame(int dim) { 
		super(dim);
		_current_message = "Move: P1";
	}
	
	/*
	 * Constants to use:
	 * 	static int EMPTY = 0,P1 = 1, P2 = 2;
	 * 
	 * Fields to use:
	 *	String _current_message = "Loading...";
	 *	int _mouse_sq_x, mouse_sq_y;
	 *	int[][] _board; //note::this is accessed like board[y][x]
	 */
	
	private int _cur_player = P1;

	@Override
	public void clicked() {
		if (_board[_mouse_sq_y][_mouse_sq_x] == 0) {
			_board[_mouse_sq_y][_mouse_sq_x] = _cur_player;
			
			if (_cur_player == P1) {
				_cur_player = P2;
				_current_message = "Move: P2";
				
			} else if (_cur_player == P2) {
				_cur_player = P1;
				_current_message = "Move: P1";
				
			}
		}
		check_game_state();
		AI_move();
	}
	
	private void check_game_state() {
		if (check_winner() != 0) {
			_current_message = "{fill in the blank here...} won!";
		}
	}
	
	
	@Override
	/**
	 * Completely resets game state
	 */
	public void reset() {
		//TODO -- complete me!
	}
	
	/**
	 * Checks if there is a winner
	 * @return 1 if p1 won, 2 if p2 won, else 0
	 */
	private int check_winner() {
		return 0; //TODO -- complete me!
	}
	
	/**
	 * Beyond expert AI player (plays for P2)
	 */
	private void AI_move() {
		//TODO -- complete me!
	}
	

}
