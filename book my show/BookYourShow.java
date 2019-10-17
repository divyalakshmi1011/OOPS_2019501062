import java.util.Arrays;

public class BookYourShow {
    /**
     * shows array.
     */
    private show[] shows;
    /**
     * number of shows in shows array.
     */
    private int size;

    /**
     * constructor for initialization.
     */
    public BookYourShow() {
        this.size = 0;
        final int capacity = 50;
        this.shows = new show[capacity];

    }

    /**
     * resizes the shows array when it is full.
     */
    public void resize() {
        shows = Arrays.copyOf(shows, shows.length * 2);
    }
    /**
     *
     * @param show show details of a movie
     */
    public void addAShow(final show show) {
        if (size == shows.length) {
            resize();
        }
        shows[size] = show;
        binarySort(shows);
        size++;
    }

    /**
     *
     * @param arr shows array
     */
    public void binarySort(final show[] arr) {
        for (int idx = 0; idx < size; ++idx) {
            for (int idx1 = idx + 1; idx1 < size + 1; ++idx1) {
                if (shows[idx].getMovieName()
                .compareTo(shows[idx1].getMovieName()) > 0) {
                    // swap shows[i] with shows[j]
                    show temp = shows[idx];
                    shows[idx] = shows[idx1];
                    shows[idx1] = temp;
                }
            }
        }

    }
    /**
     *
     * @param movieName1 movie name
     * @param dateTime1 date and time of a show
     * @return show details
     */
    public show getAShow(final String movieName1, final String dateTime1) {

        for (int idx = 0; idx < size; idx++) {
            if (shows[idx].getMovieName().equals(movieName1)
            && shows[idx].getDateTime().equals(dateTime1)) {
                    return shows[idx];
                }
        }
        return null;
    }
    /**
     * print all the shows.
     */
    public void printShows() {
        for (int idx = 0; idx < size; idx++) {
            System.out.println(shows[idx]);
        }
    }
}


