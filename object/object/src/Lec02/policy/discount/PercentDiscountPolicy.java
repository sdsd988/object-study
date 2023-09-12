package Lec02.policy.discount;

import Lec02.condition.discount.discountCondition;
import Lec02.Money;
import Lec02.Screening;

public class PercentDiscountPolicy extends DefaultDiscountPolicy {

    private double percent;

    public PercentDiscountPolicy(double percent, discountCondition... conditions) {
        super(conditions);
        this.percent = percent;
    }

    @Override
    protected Money getDiscountAmount(Screening screening) {
        return screening.getMovieFee().times(percent);
    }
}
