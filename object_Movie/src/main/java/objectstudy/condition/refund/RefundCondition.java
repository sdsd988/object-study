package objectstudy.condition.refund;


import objectstudy.Refund;
import objectstudy.Reservation;
import objectstudy.Screening;

public interface RefundCondition {

    boolean isSatisfiedBy(Reservation reservation);
}
