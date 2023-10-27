package objectstudy.policy.refund;

import objectstudy.Money;
import objectstudy.Reservation;

public interface RefundPolicy {

    Money calculateRefundAmount(Reservation reservation);
}
