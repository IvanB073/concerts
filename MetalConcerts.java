package c;

public class MetalConcerts implements Concert {
	private String band;
	private String genre;
	private double ticketPrice;
	private int ticketCount;

	public MetalConcerts(String band, String genre, double ticketPrice, int ticketCount) {
		this.band = band;
		this.genre = genre;
		this.ticketPrice = ticketPrice;
		this.ticketCount = ticketCount;
	}

	public String getBand() {
		return this.band;
	}

	public void setBand(String band) {
		this.band = band;
	}

	public String getGenre() {
		return this.genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public double getTicketPrice() {
		return this.ticketPrice;
	}

	public void setTicketPrice(double ticketPrice) {
		this.ticketPrice = ticketPrice;
	}

	public int getTicketCount() {
		return this.ticketCount;
	}

	public void setTicketCount(int ticketCount) {
		this.ticketCount = ticketCount;
	}

}
