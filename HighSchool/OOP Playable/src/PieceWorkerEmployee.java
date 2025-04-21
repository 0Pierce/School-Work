
public class PieceWorkerEmployee extends Employee {

	private double wage;
	private double pieces;

	public PieceWorkerEmployee(String firstName, String lastName, String socialSecurityNumber, Date birthDate,
			double wage, double pieces) {
		super(firstName, lastName, socialSecurityNumber, birthDate);
		setWage(wage);
		setPieces(pieces);
	}

	
	
	public double getWage() {
		return wage;
	}

	public void setWage(double wage) {
		if(wage > 0) {
			this.wage = wage;
		}else
			this.wage = 0;
	}

	public double getPieces() {
		return pieces;
	}

	public void setPieces(double pieces) {
		if(pieces > 0) {
			this.pieces = pieces;
		}else
			this.pieces = 0;
	}

	public double earnings() {
		return (getPieces() * getWage());
	}
	
	public String toString() {
		return String.format("Piece worker employee \n%s\nWage per Piece: $%.2f\nPieces Sold: %d", super.toString(), getWage(), getPieces());
		
		
		
	}

}
