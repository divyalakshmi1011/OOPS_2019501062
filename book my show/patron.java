public final class patron {
    /**
     * ticket owner name.
     */
    private String ticketOwner;
    /**
     * ticket owner phone number.
     */
    private String phoneNumber;

    /**
     *
     * @param ticketowner1 ticket owner name
     * @param phonenumber1 ticket owner phone number
     * initializing with the given details in constructor.
     */
    public patron(final String ticketowner1, final String phonenumber1) {
        this.ticketOwner = ticketowner1;
        this.phoneNumber = phonenumber1;
    }

    /**
     * overriding toString() as per our requirement.
     */
    @Override
    public String toString() {
        return "Patron [phoneNumber="
        + phoneNumber + ", ticketOwner=" + ticketOwner + "]";
    }

    /**
     *
     * @return name of the ticket holder
     */

    public String getTicketOwner() {
        return ticketOwner;
    }

    /**
     *
     * @param ticketOwner1 sets the name of the ticket holder
     */
    public void setTicketOwner(final String ticketOwner1) {
        this.ticketOwner = ticketOwner1;
    }
}
