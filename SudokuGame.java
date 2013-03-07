
public class SudokuGame extends SudokuPanel {
	
	public static void main(String[] args) { new SudokuGame(); }
	
	//fields to use:
	//int[][] _board  (it's a 9x9 2d array this time!)
	
	/**
	 * Randomly generates a playable sudoku board.
	 * Called when (P) is pressed.
	 */
	@Override
	public void play_random() {
		//TODO -- finish me!
		//just call reset and zero some random squares
	}
	
	/**
	 * Checks if the current sudoku board is solved.
	 * Prints message to window.
	 */
	@Override
	public void check_sudoku() {
		//TODO -- finish me!
		//hint: write a helper 'private boolean check_board()' (you'll be using this in solve_sudoku!)
		
		//plan: check one thing at a time. Check rows, columns and then squares
	}
	
	/**
	 * Solves current sudoku board (if possible)
	 */
	@Override
	public void solve_sudoku() {
		//TODO -- finish me!
		
		//hint: you'll want to use recursive backtracking here!
		//consider your *choose* to be setting an empty square to a number (make sure it's valid)!
		//*recurse* with this choice
		//if it doesn't work, unchoose (set back to empty) and choose something else
	}

}
