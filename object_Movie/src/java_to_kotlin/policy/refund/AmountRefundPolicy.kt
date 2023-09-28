package java_to_kotlin.policy.refund

import java_to_kotlin.Money
import java_to_kotlin.Refund
import java_to_kotlin.condition.refund.RefundCondition

class AmountRefundPolicy(vararg conditions: RefundCondition?) : DefaultRefundPolicy(*conditions) {
    override fun getDiscountAmount(refund: Refund): Money? {
        return refund.movieFee
    }
}
