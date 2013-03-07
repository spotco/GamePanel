import java.awt.event.KeyEvent;
import java.util.Scanner;


public class SudokuPanel extends GridGamePanel {
	
	private static int HPAD = -5, VPAD = 10;
	
	public static void main(String[] args) { new SudokuPanel(); }
	public SudokuPanel() {
		super(9);
		System.out.println("Welcome to sudoku! Mouse over square and press 1-9 to set number.");
		_current_message = "(P)lay random, (R)eset, (C)heck, (S)olve";
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		super.keyReleased(e);
		if (e.getKeyCode() == KeyEvent.VK_R) reset();
		else if (e.getKeyCode() == KeyEvent.VK_P) play_random();
		else if (e.getKeyCode() == KeyEvent.VK_C) check_sudoku();
		else if (e.getKeyCode() == KeyEvent.VK_S) solve_sudoku();
	}
	
	@Override
	public void update() {
		super.update();
		if (this.is_key_down(KeyEvent.VK_1)) _board[_mouse_sq_y][_mouse_sq_x] = 1;
		else if (this.is_key_down(KeyEvent.VK_2)) _board[_mouse_sq_y][_mouse_sq_x] = 2;
		else if (this.is_key_down(KeyEvent.VK_3)) _board[_mouse_sq_y][_mouse_sq_x] = 3;
		else if (this.is_key_down(KeyEvent.VK_4)) _board[_mouse_sq_y][_mouse_sq_x] = 4;
		else if (this.is_key_down(KeyEvent.VK_5)) _board[_mouse_sq_y][_mouse_sq_x] = 5;
		else if (this.is_key_down(KeyEvent.VK_6)) _board[_mouse_sq_y][_mouse_sq_x] = 6;
		else if (this.is_key_down(KeyEvent.VK_7)) _board[_mouse_sq_y][_mouse_sq_x] = 7;
		else if (this.is_key_down(KeyEvent.VK_8)) _board[_mouse_sq_y][_mouse_sq_x] = 8;
		else if (this.is_key_down(KeyEvent.VK_9)) _board[_mouse_sq_y][_mouse_sq_x] = 9;
		else if (this.is_key_down(KeyEvent.VK_ESCAPE)) _board[_mouse_sq_y][_mouse_sq_x] = 0;
	}
	
	@Override
	protected void draw_element(int x, int y) {
		if (_board[y][x]==1) 	  _g.drawString("1", x*(SQWID)+SQWID/2 + HPAD, y*(SQHEI)+SQHEI/2 + VPAD);
		else if (_board[y][x]==2) _g.drawString("2", x*(SQWID)+SQWID/2 + HPAD, y*(SQHEI)+SQHEI/2 + VPAD);
		else if (_board[y][x]==3) _g.drawString("3", x*(SQWID)+SQWID/2 + HPAD, y*(SQHEI)+SQHEI/2 + VPAD);
		else if (_board[y][x]==4) _g.drawString("4", x*(SQWID)+SQWID/2 + HPAD, y*(SQHEI)+SQHEI/2 + VPAD);
		else if (_board[y][x]==5) _g.drawString("5", x*(SQWID)+SQWID/2 + HPAD, y*(SQHEI)+SQHEI/2 + VPAD);
		else if (_board[y][x]==6) _g.drawString("6", x*(SQWID)+SQWID/2 + HPAD, y*(SQHEI)+SQHEI/2 + VPAD);
		else if (_board[y][x]==7) _g.drawString("7", x*(SQWID)+SQWID/2 + HPAD, y*(SQHEI)+SQHEI/2 + VPAD);
		else if (_board[y][x]==8) _g.drawString("8", x*(SQWID)+SQWID/2 + HPAD, y*(SQHEI)+SQHEI/2 + VPAD);
		else if (_board[y][x]==9) _g.drawString("9", x*(SQWID)+SQWID/2 + HPAD, y*(SQHEI)+SQHEI/2 + VPAD);
	}
	
	@Override
	public void reset() {
		load(DEFAULT_BOARD);
	}
	
	public static final String DEFAULT_BOARD = 
			"316578492\n"+
			"529134768\n"+
			"487629531\n"+
			"263415987\n"+
			"974863125\n"+
			"851792643\n"+
			"138947256\n"+
			"692351874\n"+
			"745286319";
	
	/**
	 * Resets the sudoku board given a string in format of DEFAULT_BOARD
	 * @param s
	 */
	public void load(String s) {
		Scanner sc = new Scanner(s);
		int y = 0;
		while(sc.hasNextLine()) {
			String line = sc.nextLine();
			for(int x = 0; x < _board[y].length; x++) {
				_board[y][x] = Character.getNumericValue(line.charAt(x));
			}
			y++;
		}
	}
	
	//override me!
	public void play_random() {}
	public void check_sudoku() {}
	public void solve_sudoku() {}

}
