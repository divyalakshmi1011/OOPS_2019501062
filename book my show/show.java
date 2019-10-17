import java.util.Arrays;

/**
 * class show of a movie.
 */
public final class show {

    /**
     * movie name.
     */
    private String movieName;
    /**
     * Date and Time of the show.
     */
    private String dateTime;
    /**
     * Total seats Available for thar show.
     */
    private String[] seats;
    /**
     * Details of persons who booked tickets for a show.
     */
    private String[] ticketHolderDetails;
    /**
     * tickets booked count.
     */
    private int tickets;

    /**
     *
     * @param movieName1 movie name
     * @param dateTime1 date and time of show
     * @param seats1 seats available for that show
     */
    public show(final String movieName1,
    final String dateTime1, final String[] seats1) {
        this.movieName = movieName1;
        this.dateTime = dateTime1;
        this.seats = seats1;
        final int capacity = 10;
        this.ticketHolderDetails = new String[capacity];
        this.tickets = 0;


    }
    /**
     *
     * @return movie name
     */

    public String getMovieName() {
        return movieName;
    }
    /**
     *
     * @param movieName1 add movie name
     */
    public void setMovieName(final String movieName1) {
        this.movieName = movieName1;
    }
    /**
     *
     * @return date and time of the show
     */
    public String getDateTime() {
        return dateTime;
    }
    /**
     *
     * @param dateTime1 of show
     */
    public void setDateTime(final String dateTime1) {
        this.dateTime = dateTime1;
    }
    /**
     *
     * @return remaining seats for a show
     */
    public String[] getSeats() {
        return seats;
    }
    /**
     *
     * @param seats1 set the available seats for a show
     */
    public void setSeats(final String[] seats1) {
        this.seats = seats1;
    }
    /**
     *
     * @param midx from that seat
     */
    public void update(final int midx) {
        int seatIdx = midx;
        for (int idx1 = midx + 1; idx1 < seats.length; idx1++) {
            seats[seatIdx] = seats[idx1];
            seatIdx++;
        }
        seats = Arrays.copyOfRange(seats, 0, seats.length - 1);
    }
    /**
     *
     * @param p user
     * @param seats1 seats he reserved
     */
    public void bookAShow(final patron p, final String[] seats1) {
    int count = 0;
    for (int idx = 0; idx < seats1.length; idx++) {
        l2: for (int idx1 = 0; idx1 < this.seats.length; idx1++) {
            if (seats1[idx].equals(seats[idx1])) {
                seats[idx1] = null;
                count++;
                update(idx1);
                break l2;
            }
        }
    }
    if (count == seats1.length) {
    if (ticketHolderDetails.length == tickets) {
        ticketHolderDetails
        = Arrays.copyOf(ticketHolderDetails, tickets * 2);
    }
    ticketHolderDetails[tickets] =
    p.getTicketOwner() + " : " + Arrays.toString(seats1);
    tickets++;
    } else {
    System.out.println(p.getTicketOwner()
    + " Some Seats are already booked So"
    + " " + "Please book seats in Available seats : "
    + Arrays.toString(seats));
    }
}

    /**
     *
     * @param user ticket holder
     */
    public void printTickets(final patron user) {
        int len = user.getTicketOwner().length();
        boolean booked = false;
        int idx = 0;
        for (; idx < tickets; idx++) {
            if (ticketHolderDetails[idx] != null
            && ticketHolderDetails[idx].substring(0, len)
            .equals(user.getTicketOwner())) {
            booked = true;
            break;
        }
    }
        if (booked) {
            System.out.println(ticketHolderDetails[idx]);
        } else {
            System.out.println("So, far " + user.getTicketOwner()
            + " not booked any tickets");
        }
}
    /**
     * overriding toString() as per our requirement.
     */
    @Override
    public String toString() {
    return "Show [movieName = " + movieName + ", DateTime = "
    + dateTime + "]";
    }
    }
