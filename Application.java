package c;

import java.util.*;

public class Application {
	private static double budget;

	public static double getBudget() {
		return budget;
	}

	public static void setBudget(double budget) {
		Application.budget = budget;
	}

	public static boolean validBudget(double budget) {
		if (budget < 0) {
			System.out.println("\nInvalid budget!\nPlease try again!");
		} else if (budget < 30) {
			System.out.println("\nYour budget should be over 30 $!");
		} else {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		MetalConcerts concert1 = new MetalConcerts("Metallica", "thrash metal, heavy metal", 170, 10);
		MetalConcerts concert2 = new MetalConcerts("Megadeth", "thrash metal, heavy metal", 180, 10);
		MetalConcerts concert3 = new MetalConcerts("Black Veil Brides", "hard rock, glam metal, heavy metal", 120, 10);
		MetalConcerts concert4 = new MetalConcerts("Opeth", "death metal, progressive metal", 125, 10);
		MetalConcerts concert5 = new MetalConcerts("Deep Purple", "heavy metal, hard rock", 90, 10);
		MetalConcerts concert6 = new MetalConcerts("Pantera", "groove metal, heavy metal, glam metal", 210, 10);
		MetalConcerts concert7 = new MetalConcerts("Arch Enemy", "melodic death metal, death metal", 90, 10);
		MetalConcerts concert8 = new MetalConcerts("Cannibal Corpse", "death metal", 80, 10);
		MetalConcerts concert9 = new MetalConcerts("Mayhem", "black metal", 65, 10);
		MetalConcerts concert10 = new MetalConcerts("Lamb of God", "groove metal, heavy metal", 135, 10);
		RockConcerts concert11 = new RockConcerts("Blink-182", "pop punk, alternative rock, punk rock", 110, 10);
		RockConcerts concert12 = new RockConcerts("Ramones", "punk rock, pop punk", 100, 10);
		RockConcerts concert13 = new RockConcerts("Sex Pistols", "punk rock", 95, 10);
		RockConcerts concert14 = new RockConcerts("Kiss", "hard rock, glam metal, heavy metal", 150, 10);
		RockConcerts concert15 = new RockConcerts("Green Day", "punk rock, alternative rock", 230, 10);
		RockConcerts concert16 = new RockConcerts("Scorpions", "hard rock, heavy metal", 30, 10);
		RockConcerts concert17 = new RockConcerts("System Of A Down", "hard rock, nu metal, alternative metal", 240,
				10);
		RockConcerts concert18 = new RockConcerts("Nirvana", "grunge rock, alternative rock", 70, 10);
		RockConcerts concert19 = new RockConcerts("Pearl Jam", "hard rock, grunge rock, alternative rock", 270, 10);
		RockConcerts concert20 = new RockConcerts("Alice In Chains",
				"grunge rock, alternative metal, hard rock, heavy metal", 40, 1);

		ArrayList<Concert> Aconcerts = new ArrayList<>(Arrays.asList(concert1, concert2, concert3, concert4, concert5,
				concert6, concert7, concert8, concert9, concert10, concert11, concert12, concert13, concert14,
				concert15, concert16, concert17, concert18, concert19, concert20));

		ArrayList<String> Agenres = new ArrayList<>(Arrays.asList("heavy metal", "thrash metal", "alternative metal",
				"nu metal", "black metal", "glam metal", "death metal", "melodic death metal", "progressive metal",
				"groove metal", "hard rock", "alternative rock", "punk rock", "grunge rock", "pop punk"));

		while (true) {
			try {
				System.out.println("\n1. Buy ticket\n2. Leave the program");
				System.out.print("\nWhat is your choice: ");
				int choice = Integer.parseInt(sc.nextLine());
				if (choice == 2) {
					break;
				}
				switch (choice) {
				case 1:
					System.out.print("\nWhat's your age: ");
					int age = Integer.parseInt(sc.nextLine());
					if (age > 0 && age < 16) {
						System.out.println("\nYou're not old enough to get ticket!");
					} else if (age >= 16 && age <= 100) {
						System.out.print("What is your budget: ");
						budget = Double.parseDouble(sc.nextLine());
						new Hall("Sofia, 'Unak' Stadium", Aconcerts, Agenres);
						if (validBudget(budget)) {
							Hall.sellTickets();
						}
					} else {
						System.out.println("\nInvalid age!\nPlease try again!");
					}
					break;
				default:
					System.out.println("\nInvalid choice!\nPlease try again!");
				}
			} catch (NumberFormatException nfe) {
				System.out.println("\nInvalid input!");
			}
		}
		sc.close();
	}

}
