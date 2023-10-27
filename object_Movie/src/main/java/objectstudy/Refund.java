package objectstudy;

import objectstudy.policy.refund.RefundPolicy;

import java.time.LocalDateTime;

/**
 * refund - 환불과 관련된 정보를 가지고 있음
 */
public class Refund {

    private Reservation reservation;

    public Refund(Reservation reservation) {
        this.reservation = reservation;
    }

    public Money getMovieFee(){
        return reservation.getFee();
    }

    public LocalDateTime getMovieStartTime() {
        return reservation.getScreeningTime();
    }

    @Override
    public String toString() {
        return "Refund{" +
                "reservation=" + reservation +
                '}';
    }

    public Reservation getReservation() {
        return reservation;
    }
}
