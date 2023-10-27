package objectstudy.policy.refund;

import objectstudy.Money;
import objectstudy.Refund;
import objectstudy.Reservation;
import objectstudy.condition.refund.RefundCondition;

public class AmountRefundPolicy extends DefaultRefundPolicy{

    public AmountRefundPolicy(RefundCondition... conditions) {
        super(conditions);
    }

    @Override
    protected Money getDiscountAmount(Reservation reservation) {

        return reservation.calculateRefundFee();
    }
}
