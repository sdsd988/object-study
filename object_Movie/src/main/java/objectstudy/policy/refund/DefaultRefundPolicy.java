package objectstudy.policy.refund;

import objectstudy.Money;
import objectstudy.Refund;
import objectstudy.Reservation;
import objectstudy.condition.refund.RefundCondition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

abstract class DefaultRefundPolicy implements RefundPolicy {

    private List<RefundCondition> conditions = new ArrayList<>();

    public DefaultRefundPolicy(RefundCondition... conditions) {

        this.conditions = Arrays.asList(conditions);
    }

    @Override
    public Money calculateRefundAmount(Reservation reservation) {
        for(RefundCondition each : conditions) {
            if (each.isSatisfiedBy(reservation)) {
                return getDiscountAmount(reservation);
            }
        }

        return Money.ZERO;
    }

    abstract protected Money getDiscountAmount(Reservation reservation);
}
