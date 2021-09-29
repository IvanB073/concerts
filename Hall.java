package c;

import java.util.*;

public class Hall {
	private String adress;
	private static ArrayList<Concert> Aconcerts;
	private static Scanner sc = new Scanner(System.in);
	private static Hall h = new Hall();

	public Hall() {
	}

	public Hall(String adress, ArrayList<Concert> aconcerts) {
		this.adress = adress;
		Aconcerts = aconcerts;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public ArrayList<Concert> getAconcerts() {
		return Aconcerts;
	}

	public void setAconcerts(ArrayList<Concert> aconcerts) {
		Aconcerts = aconcerts;
	}

	public void sellTickets(double budget) {
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
					chooseByGenre(budget, choose, concerts);
					break;
				case 2:
					chooseByPrice(budget, choose, concerts);
					break;
				default:
					System.out.println("\nInvalid characteristic!\nPlease try again!");
					sellTickets(budget);
				}
				break;
			case 2:
				System.out.println("\nThere are 2 characteristics for grouping the concerts:\n1. Genre\n2. Price");
				System.out.print("\nWhat's the characteristic that you want to group the concerts by: ");
				int aspect = Integer.parseInt(sc.nextLine());
				switch (aspect) {
				case 1:
					chooseByGenre(budget, choose, concerts);
					break;
				case 2:
					chooseByPrice(budget, choose, concerts);
					break;
				default:
					System.out.println("\nInvalid characteristic!\nPlease try again!");
					sellTickets(budget);
				}
				break;
			default:
				System.out.println("\nInvalid choice!\nPlease try again!");
				sellTickets(budget);
			}
		} catch (NumberFormatException nfe) {
			System.out.println("Invalid input!");
			sellTickets(budget);
		}
	}

	private static void chooseByGenre(double budget, int choose, ArrayList<Concert> concerts) {
		System.out.print("Enter the genre that you want: ");
		String genre = sc.nextLine();
		switch (choose) {
		case 1:
			for (Concert c : Aconcerts) {
				if (genre.equals("hard rock") || genre.equals("alternative rock") || genre.equals("grunge")
						|| genre.equals("punk rock") || genre.equals("pop punk")) {
					if (c.getGenre().equals(genre) || c.getGenre().contains(genre)) {
						concerts.add(c);
					}
				} else {
					System.out.println("\nSorry,but we don't have any concert in that genre category!");
					break;
				}
			}
			break;
		case 2:
			for (Concert c : Aconcerts) {
				if (genre.equals("thrash metal") || genre.equals("heavy metal") || genre.equals("groove metal")
						|| genre.equals("glam metal") || genre.equals("black metal")
						|| genre.equals("melodic death metal") || genre.equals("death metal")
						|| genre.equals("nu metal") || genre.equals("alternative metal")
						|| genre.equals("progressive metal")) {
					if (c.getGenre().equals(genre) || c.getGenre().contains(genre)) {
						concerts.add(c);
					}
				} else {
					System.out.println("\nSorry,but we don't have any concert in that genre category!");
					break;
				}
			}
			break;
		}
		choosingTickets(budget, concerts);
	}

	private static void chooseByPrice(double budget, int choose, ArrayList<Concert> concerts) {
		try {
			System.out.print("Enter the price that you want: ");
			double price = Double.parseDouble(sc.nextLine());
			for (Concert c : Aconcerts) {
				if (choose == 1) {
					if (price >= 30 && price <= 100) {
						if (((c instanceof RockConcerts) || (c.getGenre().contains("punk rock")
								|| c.getGenre().contains("pop punk") || c.getGenre().contains("alternative rock")
								|| c.getGenre().contains("hard rock")
								|| c.getGenre().contains("grunge") && (c instanceof MetalConcerts)))
								&& (c.getTicketPrice() >= 30 && c.getTicketPrice() <= 100)) {
							concerts.add(c);
						}
					} else if (price > 100 && price <= 200) {
						if (((c instanceof RockConcerts) || (c.getGenre().contains("punk rock")
								|| c.getGenre().contains("pop punk") || c.getGenre().contains("alternative rock")
								|| c.getGenre().contains("hard rock")
								|| c.getGenre().contains("grunge") && (c instanceof MetalConcerts)))
								&& (c.getTicketPrice() > 100 && c.getTicketPrice() <= 200)) {
							concerts.add(c);
						}
					} else if (price > 200 && price <= 300) {
						if (((c instanceof RockConcerts) || (c.getGenre().contains("punk rock")
								|| c.getGenre().contains("pop punk") || c.getGenre().contains("alternative rock")
								|| c.getGenre().contains("hard rock")
								|| c.getGenre().contains("grunge") && (c instanceof MetalConcerts)))
								&& (c.getTicketPrice() > 200 && c.getTicketPrice() <= 300)) {
							concerts.add(c);
						}
					} else {
						System.out.println("\nSorry,but we don't have any concert in that price category!");
						break;
					}
				} else if (choose == 2) {
					if (price >= 30 && price <= 100) {
						if (((c instanceof MetalConcerts) || (c.getGenre().contains("thrash metal")
								|| c.getGenre().contains("heavy metal") || c.getGenre().contains("groove metal")
								|| c.getGenre().contains("glam metal") || c.getGenre().contains("black metal")
								|| c.getGenre().contains("melodic death metal") || c.getGenre().contains("death metal")
								|| c.getGenre().contains("nu metal") || c.getGenre().contains("alternative metal")
								|| c.getGenre().contains("progressive metal") && (c instanceof RockConcerts)))
								&& (c.getTicketPrice() >= 30 && c.getTicketPrice() <= 100)) {
							concerts.add(c);
						}
					} else if (price > 100 && price <= 200) {
						if (((c instanceof MetalConcerts) || (c.getGenre().contains("thrash metal")
								|| c.getGenre().contains("heavy metal") || c.getGenre().contains("groove metal")
								|| c.getGenre().contains("glam metal") || c.getGenre().contains("black metal")
								|| c.getGenre().contains("melodic death metal") || c.getGenre().contains("death metal")
								|| c.getGenre().contains("nu metal") || c.getGenre().contains("alternative metal")
								|| c.getGenre().contains("progressive metal") && (c instanceof RockConcerts)))
								&& (c.getTicketPrice() > 100 && c.getTicketPrice() <= 200)) {
							concerts.add(c);
						}
					} else if (price > 200 && price <= 300) {
						if (((c instanceof MetalConcerts) || (c.getGenre().contains("thrash metal")
								|| c.getGenre().contains("heavy metal") || c.getGenre().contains("groove metal")
								|| c.getGenre().contains("glam metal") || c.getGenre().contains("black metal")
								|| c.getGenre().contains("melodic death metal") || c.getGenre().contains("death metal")
								|| c.getGenre().contains("nu metal") || c.getGenre().contains("alternative metal")
								|| c.getGenre().contains("progressive metal") && (c instanceof RockConcerts)))
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
			System.out.println("Invalid input!\n");
			chooseByPrice(budget, choose, concerts);
		}
		choosingTickets(budget, concerts);
	}

	private static void sortAndPrint(ArrayList<Concert> concerts) {
		Collections.sort(concerts, Concert.comparator);
		for (Concert c : concerts) {
			c.performerInfo();
		}
	}

	private static void choosingTickets(double budget, ArrayList<Concert> concerts) {
		sortAndPrint(concerts);
		while (concerts.size() != 0) {
			try {
				System.out.print("\nWould you like to buy tickets: ");
				String decision = sc.nextLine();
				if (decision.equals("yes")) {
					if (concerts.size() == 1) {
						System.out.print("How many tickets would you buy: ");
						int count = Integer.parseInt(sc.nextLine());
						if (count <= 0) {
							System.out.println("\nInvalid ticket count!\nPlease try again!");
						} else {
							if (budget < count * concerts.get(0).getTicketPrice()) {
								if (count == 1) {
									System.out.printf(
											"\nSorry, but you have only %.2f $, which is not enough to buy tickets for the %s's concert!\n",
											budget, concerts.get(0).getBand());
									break;
								} else {
									int availableCount = (int) (budget / concerts.get(0).getTicketPrice());
									if (count == 2) {
										System.out.printf("\nYou can buy only 1 ticket for the %s's concert!\n",
												concerts.get(0).getBand());
										System.out.print("Would you like to buy it: ");
										String choice = sc.nextLine();
										if (choice.equals("yes")) {
											System.out.printf("\nYou bought a ticket for the %s's concert!\n",
													concerts.get(0).getBand());
											concerts.get(0)
													.setTicketCount(concerts.get(0).getTicketCount() - availableCount);
											budget -= availableCount * concerts.get(0).getTicketPrice();
											break;
										} else if (choice.equals("no")) {
											System.out.println("\nWe are sorry to hear that!");
											break;
										} else {
											System.out.println("\nSomething went wrong!\nPlease try again!");
										}
									} else {
										System.out.printf("\nYou can buy only %d tickets for the %s's concert!\n",
												availableCount, concerts.get(0).getBand());
										System.out.print("Would you like to buy them: ");
										String choice = sc.nextLine();
										if (choice.equals("yes")) {
											System.out.printf("\nYou bought %d tickets for the %s's concert!\n",
													availableCount, concerts.get(0).getBand());
											concerts.get(0)
													.setTicketCount(concerts.get(0).getTicketCount() - availableCount);
											budget -= availableCount * concerts.get(0).getTicketPrice();
											break;
										} else if (choice.equals("no")) {
											System.out.println("\nWe are sorry to hear that!");
											break;
										} else {
											System.out.println("\nSomething went wrong!\nPlease try again!");
										}
									}
								}
							} else {
								if (concerts.get(0).getTicketCount() < count) {
									if (concerts.get(0).getTicketCount() == 1) {
										System.out.printf("\nWe have only 1 ticket for the %s's concert!\n",
												concerts.get(0).getBand());
										System.out.print("Would you like to buy it: ");
										String choice = sc.nextLine();
										if (choice.equals("yes")) {
											System.out.printf("\nYou bought the last ticket for the %s's concert!\n",
													concerts.get(0).getBand());
											concerts.get(0).setTicketCount(10);
											budget -= count * concerts.get(0).getTicketPrice();
											break;
										} else if (choice.equals("no")) {
											System.out.println("\nWe are sorry to hear that!");
											break;
										} else {
											System.out.println("\nSomething went wrong!\nPlease try again!");
										}
									} else {
										System.out.printf("\nWe have only %d tickets for the %s's concert!\n",
												concerts.get(0).getTicketCount(), concerts.get(0).getBand());
										System.out.print("Would you like to buy them: ");
										String choice = sc.nextLine();
										if (choice.equals("yes")) {
											System.out.printf(
													"\nYou bought the last %d tickets for the %s's concert!\n",
													concerts.get(0).getTicketCount(), concerts.get(0).getBand());
											concerts.get(0).setTicketCount(10);
											budget -= count * concerts.get(0).getTicketPrice();
											break;
										} else if (choice.equals("no")) {
											System.out.println("\nWe are sorry to hear that!");
											break;
										} else {
											System.out.println("\nSomething went wrong!\nPlease try again!");
										}
									}
								} else if (concerts.get(0).getTicketCount() == count) {
									concerts.get(0).setTicketCount(10);
									budget -= count * concerts.get(0).getTicketPrice();
									if (count == 1) {
										System.out.printf("\nYou bought the last ticket for the %s's concert!\n",
												concerts.get(0).getBand());
									} else {
										System.out.printf("\nYou bought the last %d tickets for the %s's concert!\n",
												count, concerts.get(0).getBand());
									}
									break;
								} else {
									concerts.get(0).setTicketCount(concerts.get(0).getTicketCount() - count);
									budget -= count * concerts.get(0).getTicketPrice();
									if (count == 1) {
										System.out.printf("\nYou bought a ticket for the %s's concert!\n",
												concerts.get(0).getBand());
									} else {
										System.out.printf("\nYou bought %d tickets for the %s's concert!\n", count,
												concerts.get(0).getBand());
									}
									break;
								}
							}
						}
					} else {
						System.out.printf("\nYou got %d choises\nWhich band do you choose: ", concerts.size());
						int choice = Integer.parseInt(sc.nextLine());
						if (choice <= 0 || choice > concerts.size()) {
							System.out.println("\nInvalid choice!\nPlease try again!");
						} else {
							System.out.print("How many tickets would you buy: ");
							int count = Integer.parseInt(sc.nextLine());
							if (count <= 0) {
								System.out.println("\nInvalid ticket count!\nPlease try again!");
							} else {
								for (int i = 0; i <= concerts.size(); i++) {
									if (i + 1 == choice) {
										if (budget < count * concerts.get(i).getTicketPrice()) {
											if (count == 1) {
												System.out.printf(
														"\nSorry, but you have only %.2f $, which is not enough to buy tickets for the %s's concert!\n",
														budget, concerts.get(i).getBand());
												break;
											} else {
												int availableCount = (int) (budget / concerts.get(i).getTicketPrice());
												if (count == 2) {
													System.out.printf(
															"\nYou can buy only 1 ticket for the %s's concert!\n",
															concerts.get(i).getBand());
													System.out.print("Would you like to buy it: ");
													String answer = sc.nextLine();
													if (answer.equals("yes")) {
														System.out.printf(
																"\nYou bought a ticket for the %s's concert!\n",
																concerts.get(i).getBand());
														concerts.get(i).setTicketCount(
																concerts.get(i).getTicketCount() - availableCount);
														budget -= availableCount * concerts.get(i).getTicketPrice();
														break;
													} else if (answer.equals("no")) {
														System.out.println("\nWe are sorry to hear that!");
														break;
													} else {
														System.out
																.println("\nSomething went wrong!\nPlease try again!");
													}
												} else {
													System.out.printf(
															"\nYou can buy only %d tickets for the %s's concert!\n",
															availableCount, concerts.get(i).getBand());
													System.out.print("Would you like to buy them: ");
													String verdict = sc.nextLine();
													if (verdict.equals("yes")) {
														System.out.printf(
																"\nYou bought %d tickets for the %s's concert!\n",
																availableCount, concerts.get(i).getBand());
														concerts.get(i).setTicketCount(
																concerts.get(i).getTicketCount() - availableCount);
														budget -= availableCount * concerts.get(i).getTicketPrice();
														break;
													} else if (verdict.equals("no")) {
														System.out.println("\nWe are sorry to hear that!");
														break;
													} else {
														System.out
																.println("\nSomething went wrong!\nPlease try again!");
													}
												}
											}
										} else {
											if (concerts.get(i).getTicketCount() < count) {
												if (concerts.get(i).getTicketCount() == 1) {
													System.out.printf("\nWe have only 1 ticket for the %s's concert!\n",
															concerts.get(i).getBand());
													System.out.print("Would you like to buy it: ");
													String answer = sc.nextLine();
													if (answer.equals("yes")) {
														System.out.printf(
																"\nYou bought the last ticket for the %s's concert!\n",
																concerts.get(i).getBand());
														concerts.get(i).setTicketCount(10);
														budget -= count * concerts.get(i).getTicketPrice();
														break;
													} else if (answer.equals("no")) {
														System.out.println("\nWe are sorry to hear that!");
														break;
													} else {
														System.out
																.println("\nSomething went wrong!\nPlease try again!");
													}
												} else {
													System.out.printf(
															"\nWe have only %d tickets for the %s's concert!\n",
															concerts.get(i).getTicketCount(),
															concerts.get(i).getBand());
													System.out.print("Would you like to buy them: ");
													String verdict = sc.nextLine();
													if (verdict.equals("yes")) {
														System.out.printf(
																"\nYou bought the last %d tickets for the %s's concert!\n",
																concerts.get(i).getTicketCount(),
																concerts.get(i).getBand());
														concerts.get(i).setTicketCount(10);
														budget -= count * concerts.get(i).getTicketPrice();
														break;
													} else if (verdict.equals("no")) {
														System.out.println("\nWe are sorry to hear that!");
														break;
													} else {
														System.out
																.println("\nSomething went wrong!\nPlease try again!");
													}
												}
											} else if (concerts.get(i).getTicketCount() == count) {
												concerts.get(i).setTicketCount(10);
												budget -= count * concerts.get(i).getTicketPrice();
												if (count == 1) {
													System.out.printf(
															"\nYou bought the last ticket for the %s's concert!\n",
															concerts.get(i).getBand());
												} else {
													System.out.printf(
															"\nYou bought the last %d tickets for the %s's concert!\n",
															count, concerts.get(i).getBand());
												}
												break;
											} else {
												concerts.get(i)
														.setTicketCount(concerts.get(i).getTicketCount() - count);
												budget -= count * concerts.get(i).getTicketPrice();
												if (count == 1) {
													System.out.printf("\nYou bought a ticket for the %s's concert!\n",
															concerts.get(i).getBand());
												} else {
													System.out.printf("\nYou bought %d tickets for the %s's concert!\n",
															count, concerts.get(i).getBand());
												}
												break;
											}
										}
									}
								}
							}
						}
					}
				} else if (decision.equals("no")) {
					System.out.println("\nWe are sorry to hear that!");
					break;
				} else {
					System.out.println("\nSomething went wrong!\nPlease try again!");
				}
			} catch (NumberFormatException nfe) {
				System.out.println("Invalid input!");
			}
		}
		System.out.print("\nWould you like to see other concerts: ");
		String choice = sc.nextLine();
		switch (choice) {
		case "yes":
			h.sellTickets(budget);
			break;
		case "no":
			System.out.println("\nGoodbye!\nHave a nice day!");
			break;
		default:
			System.out.println("\nSomething went wrong!\nPlease try again!");
			h.sellTickets(budget);
		}
	}

}