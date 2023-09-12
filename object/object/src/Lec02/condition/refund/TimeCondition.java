package Lec02.condition.refund;


import Lec02.Screening;

import java.time.LocalDateTime;

public class TimeCondition implements RefundCondition {

    private LocalDateTime currentTime;

    @Override
    public boolean isSatisfiedBy(Screening screening) {
        return currentTime.compareTo(screening.getStartTime()) <= 0;
    }
}
