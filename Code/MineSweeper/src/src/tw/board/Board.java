package src.tw.board;

import java.util.IllegalFormatException;

import src.tw.CustomException.*;

public class Board {

	private String[][] minesBoard;
	private String[][] displayBorad;
	private int xLength;
	private int yLength;
	private int nonMineCont;

	public Board(String[][] input) {
		minesBoard = input;
		xLength = input.length;
		yLength = input[0].length;
		if (xLength != yLength)
			throw new IllegalArgumentException();

		nonMineCont = xLength * yLength;

		displayBorad = new String[xLength][yLength];
		for (int i = 0; i < xLength; i++) {
			for (int j = 0; j < yLength; j++) {
				if (minesBoard[i][j] == "m")
					nonMineCont--;
				displayBorad[i][j] = "x";
			}
		}
	}

	public int getxLength() {
		return xLength;
	}

	public int getyLength() {
		return yLength;
	}

	public String[][] getMinesBoard() {
		return minesBoard;
	}

	public String[][] getDisplayBorad() {
		return displayBorad;
	}

	public int getNonMineCont() {
		return nonMineCont;
	}

	public void setNonMineCont(int nonMineCont) {
		this.nonMineCont = nonMineCont;
	}

	/*
	 * public void open(int x, int y) throws StepOnMine {
	 * 
	 * if (checkForMine(x, y)) { displayBorad[x][y] = "m"; throw new
	 * StepOnMine("Oops, you stepped on a mine ! Game over !");
	 * 
	 * } else { checkAndDecrementMineCount(x, y); int mines = countMines(x, y);
	 * displayBorad[x][y] = Integer.toString(mines); }
	 * 
	 * }
	 * 
	 * private void checkAndDecrementMineCount(int x, int y) { // TODO
	 * Auto-generated method stub if (displayBorad[x][y] == "x" ||
	 * displayBorad[x][y] == "f") nonMineCont--; }
	 * 
	 * private boolean checkForMine(int x, int y) { // TODO Auto-generated
	 * method stub return minesBoard[x][y] == "m"; }
	 * 
	 * private int countMines(int x, int y) { // TODO Auto-generated method stub
	 * int retCount = 0;
	 * 
	 * if (x - 1 >= 0 && minesBoard[x - 1][y] == "m") { retCount++; } if (x + 1
	 * < xLength && minesBoard[x + 1][y] == "m") { retCount++; } if (y - 1 >= 0
	 * && minesBoard[x][y - 1] == "m") { retCount++; } if (y + 1 < yLength &&
	 * minesBoard[x][y + 1] == "m") { retCount++; }
	 * 
	 * return retCount; }
	 * 
	 * public void flag(int x, int y) {
	 * 
	 * displayBorad[x][y] = "f";
	 * 
	 * }
	 * 
	 * public void printBoard() {
	 * 
	 * for (int i = 0; i < xLength; i++) { for (int j = 0; j < yLength; j++) {
	 * System.out.print(displayBorad[i][j] + "\t");
	 * 
	 * } System.out.println(); }
	 * 
	 * }
	 * 
	 * public void checkForWin(int i, int j) { // TODO Auto-generated method
	 * stub if (nonMineCont == 0) {
	 * System.out.println("Wow, you cleared the minefield ! Game over"); } }
	 */

}
