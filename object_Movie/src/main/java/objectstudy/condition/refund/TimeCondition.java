package objectstudy.condition.refund;


import objectstudy.Refund;
import objectstudy.Reservation;
import objectstudy.Screening;

import java.time.LocalDateTime;

public class TimeCondition implements RefundCondition {

    private LocalDateTime currentTime;

    public TimeCondition(LocalDateTime currentTime) {
        this.currentTime = currentTime;
    }

    @Override
    public boolean isSatisfiedBy(Reservation reservation) {
        return currentTime.compareTo(reservation.getScreeningTime()) <= 0;
    }
}
