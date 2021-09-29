package c;

import java.util.*;

public class Application {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		MetalConcerts concert1 = new MetalConcerts("Metallica", "James Hetfield", "Robert Trujillo",
				"James Hetfield, Kirk Hammett", "", "Lars Ulrich", "thrash metal,heavy metal", 170, 10);
		MetalConcerts concert2 = new MetalConcerts("Megadeth", "Dave Mustaine", "David Ellefson",
				"Dave Mustaine, Kiko Loureiro", "", "Dirk Verbeuren", "thrash metal,heavy metal", 180, 10);
		MetalConcerts concert3 = new MetalConcerts("Black Veil Brides", "Andy Biersack", "Lonny Eagleton",
				"Jake Pitts, Jinxx", "", "Christian 'CC' Coma", "hard rock,glam metal,heavy metal", 120, 10);
		MetalConcerts concert4 = new MetalConcerts("Opeth", "Mikael Åkerfeldt, Joakim Svalberg, Fredrik Åkesson",
				"Martín Méndez", "Mikael Åkerfeldt, Fredrik Åkesson", "Joakim Svalberg", "Martin 'Axe' Axenrot",
				"death metal,progressive metal", 125, 10);
		MetalConcerts concert5 = new MetalConcerts("Deep Purple", "Ian Gillan", "Roger Glover", "Steve Morse",
				"Don Airey", "Ian Paice", "heavy metal,hard rock", 90, 10);
		MetalConcerts concert6 = new MetalConcerts("Pantera", "Phil Anselmo", "Rex Brown", "Dimebag Darrell", "",
				"Vinnie Paul", "groove metal,heavy metal,glam metal", 210, 10);
		MetalConcerts concert7 = new MetalConcerts("Arch Enemy",
				"Alissa White-Gluz, Michael Amott, Jeff Loomis, Sharlee D'Angelo", "Sharlee D'Angelo",
				"Michael Amott, Jeff Loomis", "Daniel Erlandsson", "Daniel Erlandsson",
				"melodic death metal,death metal", 90, 10);
		MetalConcerts concert8 = new MetalConcerts("Cannibal Corpse", "George 'Corpsegrinder' Fisher", "Alex Webster",
				"Erik Rutan, Rob Barrett", "", "Paul Mazurkiewics", "death metal", 80, 10);
		MetalConcerts concert9 = new MetalConcerts("Mayhem", "Attila Csihar", "Necrobutcher", "Teloch, Ghul", "",
				"Hellhammer", "black metal", 65, 10);
		MetalConcerts concert10 = new MetalConcerts("Lamb of God", "Randy Blythe", "John Campbell",
				"Mark Morton, Willie Adler", "", "Art Cruz", "groove metal,heavy metal", 135, 10);
		RockConcerts concert11 = new RockConcerts("Blink-182", "Mark Hoppus, Matt Skiba", "Mark Hoppus", "Matt Skiba",
				"Travis Barker", "pop punk,alternative rock,punk rock", 110, 10);
		RockConcerts concert12 = new RockConcerts("Ramones", "Joey Ramone, Dee Dee Ramone", "Dee Dee Ramone",
				"Johnny Ramone", "Tommy Ramone", "punk rock,pop punk", 100, 10);
		RockConcerts concert13 = new RockConcerts("Sex Pistols", "Johhny Rotten", "Sid Vicious", "Steve Jones",
				"Paul Cook", "punk rock", 95, 10);
		RockConcerts concert14 = new RockConcerts("Kiss", "Paul Stanley, Gene Simons, Eric Singer, Tommy Thayer",
				"Gene Simons", "Paul Stanley, Tommy Thayer", "Eric Singer", "hard rock, glam metal, heavy metal", 150,
				10);
		RockConcerts concert15 = new RockConcerts("Green Day", "Billie Joe Armstrong, Mike Dirnt", "Mike Dirnt",
				"Billie Joe Armstrong", "Tre Cool", "punk rock,alternative rock", 230, 10);
		RockConcerts concert16 = new RockConcerts("Scorpions", "Klaus Meine, Rudolf Schenker, Matthias Jabs",
				"Paweł Mąciwoda", "Rudolf Schenker, Matthias Jabs", "Mikkey Dee", "hard rock,heavy metal", 30, 10);
		RockConcerts concert17 = new RockConcerts("System Of A Down", "Serj Tankian, Daron Malakian, Shavo Odadjian",
				"Shavo Odadjian", "Daron Malakian", "John Dolmayan", "hard rock,nu metal,alternative metal", 240, 10);
		RockConcerts concert18 = new RockConcerts("Nirvana", "Kurt Cobain", "Krist Novoselic", "Kurt Cobain",
				"Dave Grohl", "grunge,alternative rock", 70, 10);
		RockConcerts concert19 = new RockConcerts("Pearl Jam", "Eddie Vedder, Mike McCready", "Jeff Ament",
				"Mike McCready, Stone Gossard, Eddie Vedder", "Matt Cameron", "hard rock,grunge,alternative rock", 270,
				10);
		RockConcerts concert20 = new RockConcerts("Alice In Chains", "Jerry Cantrell, William DuVall", "Mike Inez",
				"Jerry Cantrell", "Sean Kinney", "grunge,alternative metal,hard rock,heavy metal", 40, 1);

		ArrayList<Concert> Aconcerts = new ArrayList<>(Arrays.asList(concert1, concert2, concert3, concert4, concert5,
				concert6, concert7, concert8, concert9, concert10, concert11, concert12, concert13, concert14,
				concert15, concert16, concert17, concert18, concert19, concert20));

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
						double budget = Double.parseDouble(sc.nextLine());
						if (budget < 0) {
							System.out.println("\nInvalid budget!\nPlease try again!");
						} else if (budget < 30) {
							System.out.println("\nYou don't have enough money to buy tickets!");
						} else {
							Hall cashier = new Hall("Sofia,Stadion 'Unak'", Aconcerts);
							cashier.sellTickets(budget);
						}
					} else {
						System.out.println("\nInvalid age!\nPlease try again!");
					}
					break;
				default:
					System.out.println("\nInvalid choice!\nPlease try again!");
				}
			} catch (NumberFormatException n) {
				System.out.println("Invalid input!");
			}
		}
		sc.close();
	}

}
