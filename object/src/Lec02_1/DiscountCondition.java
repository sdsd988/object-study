package Lec02_1;

import Lec02.Screening;

public interface DiscountCondition {
    boolean isSatisfiedBy(Screening screening);
}
