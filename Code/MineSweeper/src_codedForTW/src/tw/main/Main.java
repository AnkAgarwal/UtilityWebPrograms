package src.tw.main;

import src.tw.CustomException.StepOnMine;
import src.tw.board.Board;
import src.tw.operation.Operation;
import src.tw.operation.OperationDefine;
import src.tw.operation.OperationDefine.OperationType;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[][] input = { { "x", "x", "m" }, { "x", "m", "x" },
				{ "x", "x", "x" } };
		Board board = null;
		Operation operation = null;
		try {
			board = new Board(input);
			operation = new Operation(board);
			
			operation.performAction(OperationType.Open, 0, 0);
			operation.performAction(OperationType.Open, 0, 1);
			operation.performAction(OperationType.Flag, 0, 2);
			operation.performAction(OperationType.Open, 1, 0);
			operation.performAction(OperationType.Open, 1, 2);
			operation.performAction(OperationType.Open, 2, 0);
			operation.performAction(OperationType.Open, 2, 1);
			operation.performAction(OperationType.Open, 2, 2);
			

		} catch (StepOnMine e) {
			operation.printBoard();
			System.out.println(e.getMessage());
		} catch (NumberFormatException e) {
			// TODO: handle exception
			System.out.println("Operation must be given numeric input");
		} catch (NullPointerException ex) {
			System.out.println("Board is not initialized");
		} catch (IllegalArgumentException e) {
			System.out.println("Input must be a square matrix");
		}

	}

}
