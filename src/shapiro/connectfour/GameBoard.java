package shapiro.connectfour;

public class GameBoard {
	private int[][] board;

	public GameBoard() {
		board = new int[6][7];
	}

	public int takeTurn(int player, int column) throws ColumnFullException {
		for (int row = 5; row >= 0; row--) {
			if (board[row][column] != 1 && board[row][column] != 2) {
				board[row][column] = player;
				return row;
			}
		}
		// if it didn't find an empty row, throw exception
		throw new ColumnFullException();
	}

	public boolean isWinner() {
		// test for horizontal winning
		for (int row = 0; row < 6; row++) {
			for (int column = 0; column <= 3; column++) {
				if ((board[row][column] == 1 || board[row][column] == 2)
						&& board[row][column] == board[row][column + 1]
						&& board[row][column] == board[row][column + 2]
						&& board[row][column] == board[row][column + 3]) {
					return true;
				}
			}
		}

		// test for vertical winning
		for (int column = 0; column < 7; column++) {
			for (int row = 0; row <= 2; row++) {
				if ((board[row][column] == 1 || board[row][column] == 2)
						&& board[row][column] == board[row + 1][column]
						&& board[row][column] == board[row + 2][column]
						&& board[row][column] == board[row + 3][column]) {
					return true;
				}
			}
		}

		// test for diagonal up and right
		for (int row = 3; row < 6; row++) {
			for (int column = 0; column <= 3; column++) {
				if ((board[row][column] == 1 || board[row][column] == 2)
						&& board[row][column] == board[row - 1][column + 1]
						&& board[row][column] == board[row - 2][column + 2]
						&& board[row][column] == board[row - 3][column + 3]) {
					return true;
				}
			}
		}

		// test for diagonal down and right
		for (int row = 0; row <= 2; row++) {
			for (int column = 0; column <= 3; column++) {
				if ((board[row][column] == 1 || board[row][column] == 2)
						&& board[row][column] == board[row + 1][column + 1]
						&& board[row][column] == board[row + 2][column + 2]
						&& board[row][column] == board[row + 3][column + 3]) {
					return true;
				}

			}
		}

		return false;
	}

	public boolean isFull() {
		for (int column = 0; column < 7; column++) {
			if (board[0][column] != 1 && board[0][column] != 2) {
				return false;
			}
		}

		return true;
	}
}
