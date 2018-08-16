package distance;
import java.util.Scanner;

abstract class Distance {
    protected int feet;
    protected float inches;
    
	abstract public void setFeetAndInches(int feet, float inches);
	abstract public int getFeet();
	abstract public float getInches();
	abstract String getDistanceComparison(Distance dist2);
}

class DistanceImplementation extends Distance{

	@Override
	public void setFeetAndInches(int feet, float inches) {
		
		this.feet = feet;
		this.inches = inches;
		
	}

	@Override
	public int getFeet() {
		return this.feet;
	}

	@Override
	public float getInches() {
		// TODO Auto-generated method stub
		return this.inches;
	}

	@Override
	String getDistanceComparison(Distance dist2) {
		int feet = dist2.feet;
		float inch = dist2.inches;
		
		float totalDistance2 = (feet*12)+inch;
		float totalDistance1 = (this.feet*12) + this.inches;
		
		if(totalDistance1<totalDistance2){
			return "Second distance is greater";
		}
		if(totalDistance1>totalDistance2){
			return "First distance is greater";
		}
		
		return "Both distances are equal";
		
		
	}
	
	
}

public class DistanceCalculator {

	private static final Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		Distance dist1 = new DistanceImplementation();
		Distance dist2 = new DistanceImplementation();

		int feet1 = scan.nextInt();
		float inches1 = scan.nextFloat();

		int feet2 = scan.nextInt();
		float inches2 = scan.nextFloat();

		dist1.setFeetAndInches(feet1, inches1);
		dist2.setFeetAndInches(feet2, inches2);

		System.out.println(dist1.getDistanceComparison(dist2));
	}
}
