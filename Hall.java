package c;

import java.util.*;

public class Hall {
	private static ArrayList<Concert> Aconcerts;
	private static ArrayList<String> Agenres;
	private static String address;
	private static boolean flag;
	private static boolean last;
	private static Scanner sc = new Scanner(System.in);

	public Hall(String address, ArrayList<Concert> aconcerts, ArrayList<String> agenres) {
		Aconcerts = aconcerts;
		Agenres = agenres;
		Hall.address = address;
	}

	public static void sellTickets() {
		try {
			ArrayList<Concert> concerts = new ArrayList<>();
			System.out.println("\nWe offer tickets for 2 types of concerts:\n1. Rock concerts\n2. Metal concerts");
			System.out.print("\nWhich concert type do you choose: ");
			int choose = Integer.parseInt(sc.nextLine());
			switch (choose) {
			case 1:
				System.out.println("\nThere are 2 characteristics for grouping the concerts:\n1. Genre\n2. Price");
				System.out.print("\nWhat's the characteristic that you want to group the concerts by: ");
				int characteristic = Integer.parseInt(sc.nextLine());
				switch (characteristic) {
				case 1:
					chooseByGenre(choose, concerts);
					break;
				case 2:
					chooseByPrice(choose, concerts);
					break;
				default:
					System.out.println("\nInvalid characteristic!\nPlease try again!");
					sellTickets();
				}
				break;
			case 2:
				System.out.println("\nThere are 2 characteristics for grouping the concerts:\n1. Genre\n2. Price");
				System.out.print("\nWhat's the characteristic that you want to group the concerts by: ");
				int aspect = Integer.parseInt(sc.nextLine());
				switch (aspect) {
				case 1:
					chooseByGenre(choose, concerts);
					break;
				case 2:
					chooseByPrice(choose, concerts);
					break;
				default:
					System.out.println("\nInvalid characteristic!\nPlease try again!");
					sellTickets();
				}
				break;
			default:
				System.out.println("\nInvalid choice!\nPlease try again!");
				sellTickets();
			}
		} catch (NumberFormatException nfe) {
			System.out.println("\nInvalid input!");
			sellTickets();
		}
	}

	private static void chooseByGenre(int choose, ArrayList<Concert> concerts) {
		int choice = 1;
		switch (choose) {
		case 1:
			System.out.println("\nThis are the genres that we offer:");
			for (int i = 0; i < Agenres.size(); i++) {
				if (Agenres.get(i).contains("punk") || Agenres.get(i).contains("rock")) {
					System.out.printf("%d. %s\n", choice, Agenres.get(i));
					choice++;
				}
			}
			System.out.print("\nEnter the genre that you want: ");
			String genre = sc.nextLine();
			for (Concert c : Aconcerts) {
				if (Agenres.contains(genre)) {
					if (c.getGenre().equals(genre) || c.getGenre().contains(genre)) {
						concerts.add(c);
					}
				} else {
					System.out.println("\nSorry,but we don't have any concert in that genre category!");
					break;
				}
			}
			break;
		default:
			System.out.println("\nThis are the genres that we offer:");
			for (int i = 0; i < Agenres.size(); i++) {
				if (Agenres.get(i).contains("metal")) {
					System.out.printf("%d. %s\n", choice, Agenres.get(i));
					choice++;
				}
			}
			System.out.print("\nEnter the genre that you want: ");
			String genres = sc.nextLine();
			for (Concert c : Aconcerts) {
				if (Agenres.contains(genres)) {
					if (c.getGenre().equals(genres) || c.getGenre().contains(genres)) {
						concerts.add(c);
					}
				} else {
					System.out.println("\nSorry,but we don't have any concert in that genre category!");
					break;
				}
			}
		}
		choosingTickets(concerts);
	}

	private static boolean validGenre(int choose, Concert c) {
		switch (choose) {
		case 1:
			if ((c instanceof MetalConcerts) && (c.getGenre().contains("punk rock") || c.getGenre().contains("pop punk")
					|| c.getGenre().contains("alternative rock") || c.getGenre().contains("hard rock")
					|| c.getGenre().contains("grunge rock"))) {
				return true;
			}
		default:
			if ((c instanceof RockConcerts) && (c.getGenre().contains("thrash metal")
					|| c.getGenre().contains("heavy metal") || c.getGenre().contains("groove metal")
					|| c.getGenre().contains("glam metal") || c.getGenre().contains("black metal")
					|| c.getGenre().contains("melodic death metal") || c.getGenre().contains("death metal")
					|| c.getGenre().contains("nu metal") || c.getGenre().contains("alternative metal")
					|| c.getGenre().contains("progressive metal"))) {
				return true;
			}
		}
		return false;
	}

	private static void chooseByPrice(int choose, ArrayList<Concert> concerts) {
		try {
			System.out.println("There are 3 price categories:\n1. 30 $ - 100 $\n2. 100 $ - 200 $\n3. 200 $ - 300 $\n");
			System.out.print("Enter the price that you want: ");
			double price = Double.parseDouble(sc.nextLine());
			for (Concert c : Aconcerts) {
				if (choose == 1) {
					if (price >= 30 && price <= 100) {
						if (((c instanceof RockConcerts) || validGenre(choose, c))
								&& (c.getTicketPrice() >= 30 && c.getTicketPrice() <= 100)) {
							concerts.add(c);
						}
					} else if (price > 100 && price <= 200) {
						if (((c instanceof RockConcerts) || validGenre(choose, c))
								&& (c.getTicketPrice() > 100 && c.getTicketPrice() <= 200)) {
							concerts.add(c);
						}
					} else if (price > 200 && price <= 300) {
						if (((c instanceof RockConcerts) || validGenre(choose, c))
								&& (c.getTicketPrice() > 200 && c.getTicketPrice() <= 300)) {
							concerts.add(c);
						}
					} else {
						System.out.println("\nSorry,but we don't have any concert in that price category!");
						break;
					}
				} else if (choose == 2) {
					if (price >= 30 && price <= 100) {
						if ((price >= 30 && price <= 100) && ((c instanceof MetalConcerts) || validGenre(choose, c))
								&& (c.getTicketPrice() >= 30 && c.getTicketPrice() <= 100)) {
							concerts.add(c);
						}
					} else if (price > 100 && price <= 200) {
						if (((c instanceof MetalConcerts) || validGenre(choose, c))
								&& (c.getTicketPrice() > 100 && c.getTicketPrice() <= 200)) {
							concerts.add(c);
						}
					} else if (price > 200 && price <= 300) {
						if (((c instanceof MetalConcerts) || validGenre(choose, c))
								&& (c.getTicketPrice() > 200 && c.getTicketPrice() <= 300)) {
							concerts.add(c);
						}
					} else {
						System.out.println("\nSorry,but we don't have any concert in that price category!");
						break;
					}
				}
			}
		} catch (NumberFormatException nfe) {
			System.out.println("\nInvalid input!\n");
			chooseByPrice(choose, concerts);
		}
		choosingTickets(concerts);
	}

	private static void sortAndPrint(ArrayList<Concert> concerts) {
		Collections.sort(concerts, Concert.comparator);
		for (Concert c : concerts) {
			System.out.println("\nBand's name: " + c.getBand());
			System.out.println("Ticket price: " + c.getTicketPrice());
		}
	}

	private static String generateForm(String symbol, int number) {
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < number; i++) {
			buffer.append(symbol);
		}
		return buffer.toString();
	}

	private static void showTicket(int count, Concert concert) {
		int rows = 24;
		String price = "Price: " + concert.getTicketPrice();
		String tcount = "Count: " + count;
		String tprice = "Total: " + count * concert.getTicketPrice();
		System.out.println(" " + generateForm("_ ", rows) + "_");
		System.out.println("|" + generateForm(" ", rows - 2) + "TICKET" + generateForm(" ", rows - 3) + "|");
		System.out.println("|" + concert.getBand()
				+ generateForm(" ", 2 * rows + 1 - (concert.getBand().length() + tcount.length())) + tcount + "|");
		String type = (concert instanceof RockConcerts) ? "Rock concert" : "Metal Concert";
		System.out
				.println("|" + type + generateForm(" ", 2 * rows + 1 - (type.length() + price.length())) + price + "|");
		System.out.println("|" + generateForm(" ", 2 * rows + 1) + "|");
		System.out.println(
				"|" + address + generateForm(" ", 2 * rows + 1 - (address.length() + tprice.length())) + tprice + "|");
		System.out.println(" " + generateForm("¯ ", rows) + "¯");
	}

	private static void decision(String choice, int count, Concert concert) {
		switch (choice) {
		case "yes":
			showTicket(count, concert);
			if (last) {
				concert.setTicketCount(10);
			} else {
				concert.setTicketCount(concert.getTicketCount() - count);
			}
			Application.setBudget(Application.getBudget() - count * concert.getTicketPrice());
			flag = true;
			break;
		case "no":
			System.out.println("\nWe are sorry to hear that!");
			flag = true;
			break;
		default:
			System.out.println("\nSomething went wrong!\nPlease try again!");
		}
	}

	private static void calculateAffCount(Concert concert) {
		int affCount = (int) (Application.getBudget() / concert.getTicketPrice());
		if (affCount >= 1) {
			switch (affCount) {
			case 1:
				System.out.printf("\nYou can buy only 1 ticket for the %s's concert!\n", concert.getBand());
				System.out.print("Would you buy it ('yes' or 'no'): ");
				String choice = sc.nextLine();
				decision(choice, affCount, concert);
				break;
			default:
				System.out.printf("\nYou can buy only %d tickets for the %s's concert!\n", affCount, concert.getBand());
				System.out.print("Would you buy them ('yes' or 'no'): ");
				choice = sc.nextLine();
				decision(choice, affCount, concert);
			}
		} else {
			System.out.printf("\nYou cannot buy a single ticket for the %s's concert!\n", concert.getBand());
			flag = true;
		}
	}

	private static void choose(int count, Concert concert) {
		while (true) {
			try {
				if (flag) {
					break;
				}
				if (Application.getBudget() < count * concert.getTicketPrice()) {
					switch (count) {
					case 1:
						System.out.printf(
								"\nSorry, but you have only %.2f $, which is not enough to buy tickets for the %s's concert!\n",
								Application.getBudget(), concert.getBand());
						System.out.print("Would you add some money to your budget ('yes' or 'no'): ");
						String choice = sc.nextLine();
						switch (choice) {
						case "yes":
							System.out.print("\nEnter the amount you want to add: ");
							double add = Double.parseDouble(sc.nextLine());
							if (add > 0) {
								if (Application.validBudget(Application.getBudget() + add)) {
									Application.setBudget(Application.getBudget() + add);
								} else {
									System.out.printf("Your current budget is: %.2f $\n", Application.getBudget());
								}
							} else {
								System.out.println("\nInvalid input!");
							}
							flag = true;
							break;
						case "no":
							System.out.println("\nOK!");
							flag = true;
							break;
						default:
							System.out.println("\nSomething went wrong!\nPlease try again!");
						}
						break;
					default:
						calculateAffCount(concert);
					}
				} else {
					if (concert.getTicketCount() < count) {
						switch (concert.getTicketCount()) {
						case 1:
							System.out.printf("\nWe have only 1 ticket for the %s's concert!\n", concert.getBand());
							System.out.print("Would you buy it ('yes' or 'no'): ");
							String choice = sc.nextLine();
							last = true;
							decision(choice, count, concert);
							break;
						default:
							System.out.printf("\nWe have only %d tickets for the %s's concert!\n",
									concert.getTicketCount(), concert.getBand());
							System.out.print("Would you buy them ('yes' or 'no'): ");
							choice = sc.nextLine();
							last = true;
							decision(choice, count, concert);
						}
					} else if (concert.getTicketCount() == count) {
						concert.setTicketCount(10);
						Application.setBudget(Application.getBudget() - count * concert.getTicketPrice());
						showTicket(count, concert);
						break;
					} else {
						concert.setTicketCount(concert.getTicketCount() - count);
						Application.setBudget(Application.getBudget() - count * concert.getTicketPrice());
						showTicket(count, concert);
						break;
					}
				}
			} catch (NumberFormatException nfe) {
				System.out.println("\nInvalid input!");
				sellTickets();
			}
		}
	}

	private static void choosingTickets(ArrayList<Concert> concerts) {
		while (concerts.size() != 0) {
			try {
				if (flag) {
					break;
				}
				sortAndPrint(concerts);
				System.out.print("\nWould you like to buy tickets ('yes' or 'no'): ");
				String decision = sc.nextLine();
				switch (decision) {
				case "yes":
					switch (concerts.size()) {
					case 1:
						System.out.print("How many tickets would you buy: ");
						int count = Integer.parseInt(sc.nextLine());
						if (count <= 0) {
							System.out.println("\nInvalid ticket count!\nPlease try again!");
						} else {
							choose(count, concerts.get(0));
						}
						break;
					default:
						System.out.printf(
								"\nYou got %d choises\nWhich band do you choose (enter number from 1 to %d): ",
								concerts.size(), concerts.size());
						int choice = Integer.parseInt(sc.nextLine());
						if (choice <= 0 || choice > concerts.size()) {
							System.out.println("\nInvalid choice!\nPlease try again!");
						} else {
							System.out.print("How many tickets would you buy: ");
							int counts = Integer.parseInt(sc.nextLine());
							if (counts <= 0) {
								System.out.println("\nInvalid ticket count!\nPlease try again!");
							} else {
								for (int i = 0; i <= concerts.size(); i++) {
									if (i + 1 == choice) {
										choose(counts, concerts.get(i));
									}
								}
							}
						}
					}
					break;
				case "no":
					System.out.println("\nWe are sorry to hear that!");
					flag = true;
					break;
				default:
					System.out.println("\nSomething went wrong!\nPlease try again!");
				}
			} catch (NumberFormatException nfe) {
				System.out.println("\nInvalid input!");
			}
		}
		flag = false;
		last = false;
		System.out.print("\nWould you like to see other concerts ('yes' or 'no'): ");
		String choice = sc.nextLine();
		switch (choice) {
		case "yes":
			sellTickets();
			break;
		case "no":
			System.out.println("\nGoodbye!\nHave a nice day!");
			break;
		default:
			System.out.println("\nSomething went wrong!\nPlease try again!");
			sellTickets();
		}
	}

}
