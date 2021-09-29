package c;

import java.util.Comparator;

public interface Concert {
	void performerInfo();

	String getBand();

	String getGenre();

	double getTicketPrice();

	int getTicketCount();

	void setTicketCount(int ticketCount);

	public static Comparator<Concert> comparator = new Comparator<Concert>() {
		public int compare(Concert c1, Concert c2) {
			double price1 = c1.getTicketPrice();
			double price2 = c2.getTicketPrice();
			return (int) (price1 - price2);
		}
	};
}
