package domain;

public class ReservationRepository {

    private static ReservationRepository instance;

    public synchronized static ReservationRepository getInstance() {
        if (instance == null) {
            instance = new ReservationRepository();
        }
        return instance;
    }
}
