package Lec02.policy.refund;

import Lec02.Money;
import Lec02.Screening;
import Lec02.condition.refund.RefundCondition;

import java.util.ArrayList;
import java.util.List;

abstract class DefaultRefundPolicy implements RefundPolicy {

    private List<RefundCondition> conditions = new ArrayList<>();

    public DefaultRefundPolicy(List<RefundCondition> conditions) {
        this.conditions = conditions;
    }

    @Override
    public Money calculateRefundAmount(Screening screening) {
        for(RefundCondition each : conditions) {
            if (each.isSatisfiedBy(screening)) {
                return getDiscountAmount(screening);
            }
        }

        return Money.ZERO;
    }

    abstract protected Money getDiscountAmount(Screening screening);
}
