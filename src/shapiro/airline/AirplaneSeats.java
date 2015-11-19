package shapiro.airline;

import java.util.ArrayList;

/**
 * This class is part of an Airline Reservation system. It holds seats that are
 * reserved. You are allowed to add your own member variables and private
 * methods.
 */
public class AirplaneSeats {

	private char[][] seats;
	private int numRows;
	private int numColumns;

	/**
	 * @param rows
	 *            the number of rows of seats on the plane.
	 * @param columns
	 *            the number of columns of seats on the plane.
	 */
	public AirplaneSeats(int rows, int columns) {
		seats = new char[rows][columns];
		numRows = rows;
		numColumns = columns;

		for (int row = 0; row < numRows; row++) {
			for (int column = 0; column < numColumns; column++) {
				seats[row][column] = 'o';
			}
		}
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
	public void reserve(String seatName) throws AlreadyReservedException,
			SeatOutOfBoundsException {
		int column = seatName.charAt(0) - 65;
		int row = Integer.parseInt(seatName.substring(1)) - 1;
		if (row < 0 || column < 0 || row >= numRows || column >= numColumns) {
			throw new SeatOutOfBoundsException();
		}
		if (isReserved(seatName)) {
			throw new AlreadyReservedException();
		}
		seats[row][column] = '#';
	}

	/**
	 * @param seatName
	 *            is a String in the form of "A1" where "A" is the column and 1
	 *            is the row. The first row on the plane is 1.
	 * @return true if the seat has been reserved, otherwise false.
	 */
	public boolean isReserved(String seatName) {
		int column = seatName.charAt(0) - 65;
		int row = Integer.parseInt(seatName.substring(1)) - 1;
		return (seats[row][column] == '#');
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
	public void reserveAll(String... seatNames)
			throws AlreadyReservedException, SeatOutOfBoundsException {
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
		for (int i = 0; i < numColumns; i++) {
			char letter = (char) (i + 65);
			builder.append(letter);
		}
		builder.append("\n");
		for (int row = 0; row < numRows; row++) {
			builder.append(row + 1);
			builder.append(" ");
			for (int column = 0; column < numColumns; column++) {
				builder.append(seats[row][column]);
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
	public ArrayList<String> reserveGroup(int numberOfSeatsTogether)
			throws NotEnoughSeatsException, AlreadyReservedException,
			SeatOutOfBoundsException {

		if (numberOfSeatsTogether > numColumns) {
			throw new NotEnoughSeatsException();
		}
		if (numberOfSeatsTogether == numColumns) {
			for (int row = 0; row < numRows; row++) {
				if (seats[row][0] == 'o') {
					ArrayList<String> groupSeats = new ArrayList<String>();
					int reserveRow = row + 1;
					for (int column = 0; column < numColumns; column++) {
						StringBuilder builder = new StringBuilder();
						builder.append((char) (column + 65));
						builder.append(reserveRow);
						String seat = builder.toString();
						reserve(seat);
						groupSeats.add(seat);
					}
					return groupSeats;
				}
			}
			throw new NotEnoughSeatsException();
		}
		// no need for if statement because if the code reached this point,
		// obviously numberOfSeatsTogether < numColumns
		for (int row = 0; row < numRows; row++) {
			for (int j = 0; j < numberOfSeatsTogether; j++) {
				if (seats[row][j] == 'o') {
					boolean canWork = true;
					for (int i = 1; i < numberOfSeatsTogether; i++) {
						if (seats[row][j] != seats[row][j + 1]) {
							canWork = false;
							break;
						}
					}
					if (canWork) {
						ArrayList<String> groupSeats = new ArrayList<String>();
						int reserveRow = row + 1;
						for (int column = j; column < numberOfSeatsTogether; column++) {
							StringBuilder builder = new StringBuilder();
							builder.append((char) (column + 65));
							builder.append(reserveRow);
							String seat = builder.toString();
							reserve(seat);
							groupSeats.add(seat);
						}
						return groupSeats;
					}
				}
			}
		}
		// if no seats can be reserved together, throw exception
		throw new NotEnoughSeatsException();
	}

	/**
	 * @return true if the plane is full, otherwise false.
	 */
	public boolean isPlaneFull() {
		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j < numColumns; j++) {
				if (seats[i][j] == 'o') {
					return false;
				}
			}
		}
		return true;
	}

}
