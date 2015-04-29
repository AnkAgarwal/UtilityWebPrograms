package src.tw.operation;

import src.tw.CustomException.StepOnMine;
import src.tw.board.Board;
import src.tw.operation.OperationDefine.OperationType;

public class Operation {

	Board board;
	
	public Operation(Board board) {
		this.board = board;
	}

	public void openProcessing(int x, int y) throws StepOnMine {

		if (checkForMine(x, y)) {
			board.getDisplayBorad()[x][y] = "m";
			throw new StepOnMine("Oops, you stepped on a mine ! Game over !");

		} else {
			checkAndDecrementMineCount(x, y);
			int mines = countMines(x, y);
			board.getDisplayBorad()[x][y] = Integer.toString(mines);
		}

	}

	private void checkAndDecrementMineCount(int x, int y) {
		// TODO Auto-generated method stub
		if (board.getDisplayBorad()[x][y] == "x"
				|| board.getDisplayBorad()[x][y] == "f")
			board.setNonMineCont(board.getNonMineCont() - 1);

	}

	private boolean checkForMine(int x, int y) {
		// TODO Auto-generated method stub
		return board.getMinesBoard()[x][y] == "m";
	}

	private int countMines(int x, int y) {
		// TODO Auto-generated method stub
		int retCount = 0;

		if (x - 1 >= 0 && board.getMinesBoard()[x - 1][y] == "m") {
			retCount++;
		}
		if (x + 1 < board.getxLength()
				&& board.getMinesBoard()[x + 1][y] == "m") {
			retCount++;
		}
		if (y - 1 >= 0 && board.getMinesBoard()[x][y - 1] == "m") {
			retCount++;
		}
		if (y + 1 < board.getyLength()
				&& board.getMinesBoard()[x][y + 1] == "m") {
			retCount++;
		}

		return retCount;
	}

	public void flagProcessing(int x, int y) {

		board.getDisplayBorad()[x][y] = "f";

	}

	public void printBoard() {

		for (int i = 0; i < board.getxLength(); i++) {
			for (int j = 0; j < board.getyLength(); j++) {
				System.out.print(board.getDisplayBorad()[i][j] + "\t");

			}
			System.out.println();
		}

	}

	public void checkForWin(int i, int j) {
		// TODO Auto-generated method stub
		if (board.getNonMineCont() == 0) {
			System.out.println("Wow, you cleared the minefield ! Game over");
		}
	}

	public void flag(int i, int j) {
		// TODO Auto-generated method stub

		flagProcessing(i, j);
		printBoard();

	}

	public void open(int i, int j) throws StepOnMine {
		openProcessing(i, j);
		printBoard();
		checkForWin(i, j);

	}

	public void performAction(OperationType opType, int i, int j)
			throws StepOnMine {
		try {
			System.out.println("Operation performed " + opType + "(" + i + ","
					+ j + ")");
			switch (opType) {
			case Open:
				open(i, j);
				break;
			case Flag:
				flag(i, j);
				break;
			}
		} catch (ArrayIndexOutOfBoundsException ex) {
			System.out.println("Invalid cordinates");
		}
	}

}
