package java_to_kotlin

import java_to_kotlin.policy.refund.RefundPolicy
import java.time.LocalDateTime

/**
 * refund - 환불과 관련된 정보를 가지고 있음
 */
class Refund(private val screening: Screening, private val refundPolicy: RefundPolicy, private val audienceCount: Int) {
    val movieFee: Money?
        get() = screening.movieFee
    val movieStartTime: LocalDateTime?
        get() = screening.startTime

    fun calculateRefundFee(audienceCount: Int): Money? {
        return screening.refundCalculator(this)!!.times(audienceCount.toDouble())
    }
}
