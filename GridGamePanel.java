import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

/**
 * A basic framework for rendering tic-tac-toe and other grid based games.
 * Override with your own game logic.
 */

public class GridGamePanel extends GamePanel {
		
	//***********************************BEGIN STUFF YOU DON'T CARE ABOUT***********************************
	
	private static int DEFAULT_WID = 500,DEFAULT_HEI = 500;
	private static int UI_HEI = 40;
	public static void main(String[] args) { 
		GridGamePanel n = new GridGamePanel(DEFAULT_WID,DEFAULT_HEI,3);
		n._current_message = "TODO - Override me with game logic!";
	} 
	
	private int DIM; 		 //DIMxDIM tic tac toe grid
	private int WID,HEI; 	 //board width and height
	private int SQWID,SQHEI; //square width and height
	
	/**
	 * Creates a new tic tac toe board of given dimension
	 * @param dim - board dimension
	 */
	public GridGamePanel(int dim) {
		this(DEFAULT_WID,DEFAULT_HEI,dim);
	}
	
	private GridGamePanel(int width, int height, int dim) {
		super(width, height+UI_HEI);
		this.DIM = dim;
		this.WID = width;
		this.HEI = height;
		this.SQWID = WID/DIM;
		this.SQHEI = HEI/DIM;
		this._board = new int[DIM][DIM];
		this._g.setFont(new Font(null, 25, 25));
		((Graphics2D)this._g).setStroke(new BasicStroke(7));
	}
	
	@Override
	public void update() {
		this.set_mouse_sq();
		this.draw_board();
	}
	
	@Override
	public void mouseReleased(MouseEvent e) { 
		super.mouseReleased(e);
		clicked(); 
	}
	
	@Override
	public void keyReleased(KeyEvent e) { 
		super.keyReleased(e);
		if (e.getKeyCode() == KeyEvent.VK_R) reset(); 
	}
	
	private void draw_board() {
		this.clear();
		_g.setColor(Color.BLACK);
		_g.fillRect(0, 0, WID, HEI+UI_HEI); 												//draw black bg
		_g.setColor(Color.DARK_GRAY); 
		_g.fillRect(_mouse_sq_x*(SQWID), _mouse_sq_y*(SQWID), SQWID, SQHEI); 				//draw current mouse square
		_g.setColor(Color.WHITE);
		
		for(int y = 0; y < _board.length; y++) { 												//draw current state of this.board
			for(int x = 0; x < _board[y].length; x++) {
				if (_board[y][x]==P1) { 
					_g.drawOval(x*(SQWID), y*(SQHEI), SQWID, SQHEI); 						//draw circle if square is == P1
				} else if (_board[y][x]==P2) {
					_g.drawLine(x*(SQWID), y*(SQHEI), x*(SQWID)+SQWID, y*(SQHEI)+SQHEI); 	//draw x if square is == P2
					_g.drawLine(x*(SQWID), y*(SQHEI)+(SQHEI), x*(SQWID)+SQWID, y*(SQHEI));
				}
			}
		}
		
		for(int i = SQWID; i < (SQWID)*DIM; i+= SQWID) _g.drawLine(i, 0, i, HEI); 			//draw grid lines
		for(int i = SQHEI; i < (SQHEI)*DIM; i+= SQHEI) _g.drawLine(0, i, WID, i);
		_g.drawLine(0, HEI, WID, HEI);
		
		_g.drawString(this._current_message, 10, HEI+30);
	}
	
	private void set_mouse_sq() {
		if (this.get_mouse_x() > 0 && this.get_mouse_x() < WID && this.get_mouse_y() > 0 && this.get_mouse_y() < HEI) {
			_mouse_sq_x = this.get_mouse_x()*DIM/WID;
			_mouse_sq_y = this.get_mouse_y()*DIM/HEI;
		}
	}
	//***********************************END STUFF YOU DON'T CARE ABOUT***********************************
	
	protected static int EMPTY = 0,P1 = 1, P2 = 2;		//constants to use in board, empty represents empty square, p1 represents player 1's taken (O's), p2 represents player 2's taken (X's)
	protected String _current_message = "Loading...";	//current message to be displayed at bottom
	protected int _mouse_sq_x, _mouse_sq_y;				//current board coordinates of mouse
	protected int[][] _board;							//2d array containing tic-tac-toe game state
	
	public void clicked() {} //called when clicked
	public void reset() {}   //called when R button is pressed

}
