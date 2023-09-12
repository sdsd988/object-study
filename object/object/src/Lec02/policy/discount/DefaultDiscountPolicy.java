package Lec02.policy.discount;

import Lec02.Money;
import Lec02.Screening;
import Lec02.condition.discount.discountCondition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public abstract class DefaultDiscountPolicy implements DiscountPolicy {

    private List<discountCondition> conditions = new ArrayList<>();

    public DefaultDiscountPolicy(discountCondition... conditions) {
        this.conditions = Arrays.asList(conditions);
    }

    @Override
    public Money calculateDiscountAmount(Screening screening) {
        for(discountCondition each : conditions) {
            if (each.isSatisfiedBy(screening)) {
                return getDiscountAmount(screening);
            }
        }

        return Money.ZERO;
    }

    abstract protected Money getDiscountAmount(Screening Screening);
}
