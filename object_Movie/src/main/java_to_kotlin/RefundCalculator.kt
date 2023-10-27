package java_to_kotlin

import java_to_kotlin.policy.refund.RefundPolicy

/**
 * refundCalculate 역할 :
 * 책임 : 환불 금액 계산
 */
class RefundCalculator(private val refundPolicy: RefundPolicy) {
    val fee: Money? = null

    fun calculateRefundFee(refund: Refund): Money? {
        return refundPolicy.calculateRefundAmount(refund)
    }
}
