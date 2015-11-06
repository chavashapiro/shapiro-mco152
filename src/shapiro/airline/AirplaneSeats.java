package shapiro.airline;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * This class is part of an Airline Reservation system. It holds seats that are
 * reserved. You are allowed to add your own member variables and private
 * methods.
 */
public class AirplaneSeats {

	private HashMap<Integer, ArrayList<Integer>> seats;
	private HashMap<Character, Integer> letters;
	private HashMap<Integer, Character> numbers;
	private int numRows;
	private int numColumns;

	/**
	 * @param rows
	 *            the number of rows of seats on the plane.
	 * @param columns
	 *            the number of columns of seats on the plane.
	 */
	public AirplaneSeats(int rows, int columns) {
		letters = new HashMap<Character, Integer>();
		letters.put('A', 1);
		letters.put('B', 2);
		letters.put('C', 3);
		letters.put('D', 4);
		letters.put('E', 5);
		letters.put('F', 6);
		letters.put('G', 7);
		letters.put('H', 8);
		letters.put('I', 9);
		letters.put('J', 10);
		letters.put('K', 11);
		letters.put('L', 12);
		letters.put('M', 13);
		letters.put('N', 14);
		letters.put('O', 15);
		letters.put('P', 16);
		letters.put('Q', 17);
		letters.put('R', 18);
		letters.put('S', 19);
		letters.put('T', 20);
		letters.put('U', 21);
		letters.put('V', 22);
		letters.put('W', 23);
		letters.put('X', 24);
		letters.put('Y', 25);
		letters.put('Z', 26);

		numbers = new HashMap<Integer, Character>();
		numbers.put(1, 'A');
		numbers.put(2, 'B');
		numbers.put(3, 'C');
		numbers.put(4, 'D');
		numbers.put(5, 'E');
		numbers.put(6, 'F');
		numbers.put(7, 'G');
		numbers.put(8, 'H');
		numbers.put(9, 'I');
		numbers.put(10, 'J');
		numbers.put(11, 'K');
		numbers.put(12, 'L');
		numbers.put(13, 'M');
		numbers.put(14, 'N');
		numbers.put(15, 'O');
		numbers.put(16, 'P');
		numbers.put(17, 'Q');
		numbers.put(18, 'R');
		numbers.put(19, 'S');
		numbers.put(20, 'T');
		numbers.put(21, 'U');
		numbers.put(22, 'V');
		numbers.put(23, 'W');
		numbers.put(24, 'X');
		numbers.put(25, 'Y');
		numbers.put(26, 'Z');

		seats = new HashMap<Integer, ArrayList<Integer>>();
		numRows = rows;
		numColumns = columns;
	}

	/**
	 * @param seatName
	 *            is a String in the form of "A1" where "A" is the column and 1
	 *            is the row. The first row on the plane is 1.
	 * @throws AlreadyReservedException
	 *             if the seat has already been reserved
	 * @throws SeatOutOfBoundsException
	 *             if the seat is outside the columns and rows set in the
	 *             constructor
	 */
	public void reserve(String seatName) throws AlreadyReservedException, SeatOutOfBoundsException {
		if (isReserved(seatName)) {
			throw new AlreadyReservedException();
		}
		int column = letters.get(seatName.charAt(0));
		int row = Character.getNumericValue(seatName.charAt(1));
		if (row < 1 || column < 1 || row > numRows || column > numColumns) {
			throw new SeatOutOfBoundsException();
		}
		if (seats.containsKey(row)) {
			seats.get(row).add((column - 1), 1);
		} else {
			ArrayList<Integer> rowSeats = new ArrayList<Integer>(26);
			for (int i = 0; i < 26; i++) {
				rowSeats.add(i, null);
			}
			rowSeats.add((column - 1), 1);
			seats.put(row, rowSeats);
		}
	}

	/**
	 * @param seatName
	 *            is a String in the form of "A1" where "A" is the column and 1
	 *            is the row. The first row on the plane is 1.
	 * @return true if the seat has been reserved, otherwise false.
	 */
	public boolean isReserved(String seatName) {
		int column = letters.get(seatName.charAt(0));
		int row = Character.getNumericValue(seatName.charAt(1));
		if (seats.containsKey(row)) {
			return seats.get(row).get(column - 1) != null;
		} else {
			return false;
		}
	}

	/**
	 * Reserve all seats in the array of seatNames. This is provided her for
	 * convenience of testing. Do not modify this method.
	 * 
	 * @param seatNames
	 *            is an array of seatNames
	 * @throws AlreadyReservedException
	 *             if one of the seats has already been reserved
	 * @throws SeatOutOfBoundsException
	 *             if one of the seats is outside the columns and rows set in
	 *             the constructor
	 */
	public void reserveAll(String... seatNames) throws AlreadyReservedException, SeatOutOfBoundsException {
		for (String seatName : seatNames) {
			reserve(seatName);
		}
	}

	/**
	 * This method is worth 10 points.
	 * 
	 * @return a String representation of reserved and empty seats on the plane
	 *         in the form of.
	 * 
	 *         ABCD 1 #oo#\n 2 #ooo\n 3 ###o\n 4 ##oo\n 5 #ooo\n
	 * 
	 *         Where o is an empty seat and # is a reserved seat.
	 * 
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("  ");
		for (int i = 1; i <= numColumns; i++) {
			builder.append(numbers.get(i));
		}
		builder.append("\n");
		for (int i = 1; i <= numRows; i++) {
			builder.append(i + " ");
			if (seats.containsKey(i)) {
				for (int integer = 0; integer < numColumns; integer++) {
					if (seats.get(i).get(integer) == null) {
						builder.append("o");
					} else {
						builder.append("#");
					}
				}
			} else {
				for (int j = 1; j <= numColumns; j++) {
					builder.append("o");
				}
			}
			builder.append("\n");
		}
		return builder.toString();
	}

	/**
	 * This method is worth 10 points Reserve a group of seats in the same row.
	 * For instance, on a 3,4 airplane whose "A1" is occupied, calling
	 * reserveGroup(4) should return a list of elements ["A2", "B2", "C2", "D2"]
	 * 
	 * @param numberOfSeatsTogether
	 *            the number of seats to look for that are together
	 * @return an ArrayList of seatNames of the seats that have been reserved.
	 * @throws NotEnoughSeatsException
	 *             if there are not enough seats together to reserve.
	 * @throws SeatOutOfBoundsException
	 * @throws AlreadyReservedException
	 */
	public ArrayList<String> reserveGroup(int numberOfSeatsTogether) throws NotEnoughSeatsException,
			AlreadyReservedException, SeatOutOfBoundsException {

		if (numberOfSeatsTogether > numColumns) {
			throw new NotEnoughSeatsException();
		}
		if (numberOfSeatsTogether == numColumns) {
			for (int i = 1; i <= numRows; i++) {
				if (!seats.containsKey(i)) {
					ArrayList<String> array = new ArrayList<String>();
					for (int j = 1; j <= numberOfSeatsTogether; j++) {
						StringBuilder builder = new StringBuilder();
						builder.append(numbers.get(j));
						builder.append(i);
						String builderString = builder.toString();
						reserve(builderString);
						array.add(builderString);
					}
					return array;
				}
			}
			throw new NotEnoughSeatsException();
		}
		// no need for if statement because if the code reached this point,
		// obviously numberOfSeatsTogether < numColumns
		for (int i = 1; i <= numRows; i++) {
			if (seats.containsKey(i)) {
				for (int j = 0; j < numberOfSeatsTogether; j++) {
					boolean canWork = true;
					for (int k = 0; k < numberOfSeatsTogether; k++) {
						Integer newTemp = seats.get(i).get(j + k);
						if (newTemp != null) {
							canWork = false;
							break;
						}
					}
					if (canWork) {
						ArrayList<String> array = new ArrayList<String>();
						for (int k = 1; k <= numberOfSeatsTogether; k++) {
							StringBuilder builder = new StringBuilder();
							builder.append(numbers.get(k));
							builder.append(i);
							String builderString = builder.toString();
							reserve(builderString);
							array.add(builderString);
						}
						return array;
					}
				}
			}
			if (!(seats.containsKey(i))) {
				// I didn't have time to finish this method
			}
		}

		return null;
	}

	/**
	 * @return true if the plane is full, otherwise false.
	 */
	public boolean isPlaneFull() {
		for (int i = 1; i <= numRows; i++) {
			if (!seats.containsKey(i)) {
				return false;
			}
			for (int j = 0; j < numColumns; j++) {
				if (seats.get(i).get(j) == null) {
					return false;
				}
			}
		}
		return true;
	}

}
