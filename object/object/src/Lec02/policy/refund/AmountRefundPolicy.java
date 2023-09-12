package Lec02.policy.refund;

import Lec02.Money;
import Lec02.Screening;
import Lec02.condition.refund.RefundCondition;

import java.util.List;

public class AmountRefundPolicy extends DefaultRefundPolicy{

    public AmountRefundPolicy(List<RefundCondition> conditions) {
        super(conditions);
    }

    @Override
    protected Money getDiscountAmount(Screening screening) {

        return screening.getMovieFee();
    }
}
