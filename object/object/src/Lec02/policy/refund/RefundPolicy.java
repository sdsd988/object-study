package Lec02.policy.refund;

import Lec02.Money;
import Lec02.Screening;

public interface RefundPolicy {

    Money calculateRefundAmount(Screening screening);
}
