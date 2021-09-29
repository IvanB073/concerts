package c;

public class MetalConcerts implements Concert {
	private String band;
	private String vocalist;
	private String bassist;
	private String guitarist;
	private String keyboardist;
	private String drummer;
	private String genre;
	private double ticketPrice;
	private int ticketCount;

	public MetalConcerts(String band, String vocalist, String bassist, String guitarist, String keyboardist,
			String drummer, String genre, double ticketPrice, int ticketCount) {
		this.band = band;
		this.vocalist = vocalist;
		this.bassist = bassist;
		this.guitarist = guitarist;
		this.keyboardist = keyboardist;
		this.drummer = drummer;
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

	public String getVocalist() {
		return this.vocalist;
	}

	public void setVocalist(String vocalist) {
		this.vocalist = vocalist;
	}

	public String getBassist() {
		return this.bassist;
	}

	public void setBassist(String bassist) {
		this.bassist = bassist;
	}

	public String getGuitarist() {
		return this.guitarist;
	}

	public void setGuitarist(String guitarist) {
		this.guitarist = guitarist;
	}

	public String getKeyboardist() {
		return this.keyboardist;
	}

	public void setKeyboardist(String keyboardist) {
		this.keyboardist = keyboardist;
	}

	public String getDrummer() {
		return this.drummer;
	}

	public void setDrummer(String drummer) {
		this.drummer = drummer;
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

	@Override
	public void performerInfo() {
		System.out.println("\nBand's name: " + this.band);
		System.out.println("Vocalist: " + this.vocalist);
		System.out.println("Bassist: " + this.bassist);
		System.out.println("Guitarist: " + this.guitarist);
		System.out.println("Drummer: " + this.drummer);
		if (!(this.keyboardist.equals(""))) {
			System.out.println("Keyboardist: " + this.keyboardist);
		}
		System.out.println("Ticket price: " + this.ticketPrice);
	}

}