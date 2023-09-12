package java_to_kotlin

import java_to_kotlin.policy.refund.RefundPolicy

/**
 * refundCalculate : 환불 금액 계산
 */
class RefundCalculate(private val screening: Screening,
                      private val refundPolicy: RefundPolicy) {
    fun calculateRefundFee(screening: Screening): Money? {
        return refundPolicy.calculateRefundAmount(screening)
    }
}
