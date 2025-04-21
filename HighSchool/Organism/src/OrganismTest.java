import java.util.ArrayList;

public class OrganismTest {

	public static void main(String[] args) {

		ArrayList<Organism> organismList = new ArrayList<Organism>();

		// Instead of true and false i decided to use a string, i felt it would be
		// better
		// in the future incase somebody wanted to add extra types or something
		System.out.println("Original Data:");
		organismList.add(new Plant("Rose", 50, "flowering"));
		organismList.add(new Plant("Cactus", 300, "non-flowering"));
		System.out.println(organismList);
		organismList.add(new Mammal("Human", "Omnivore", 2));
		organismList.add(new Mammal("Cheetah", "Carnivore", 4));
		organismList.add(new Fish("Shark", "Carnivore", "Cartilaginous"));
		organismList.add(new Fish("Parrotfish", "Herbivore", "Bony"));

		
		System.out.println("");
		System.out.println("Modified Plant Height Data:");
		
		
		
		
		for(Organism currentOrganism : organismList) {
			
			
			
			
			if(currentOrganism instanceof Animal) {
				
				Organism organism = (Animal)currentOrganism;
				
				System.out.println(organism);
			
				//"[Mammal] Name: "+name + ", Food Type: " + foodType + ", Number of Legs: " + numLegs;
		}else if(currentOrganism instanceof Plant) {
			Organism organism = (Plant)currentOrganism;
			System.out.println(organism);
		}
			
		
		
		
		
			
		
				}
		
		
		
	}

}
