package java_to_kotlin.condition.refund

import java_to_kotlin.Refund
import java.time.LocalDateTime

class TimeCondition(private val currentTime: LocalDateTime) : RefundCondition {
    override fun isSatisfiedBy(refund: Refund): Boolean {
        return currentTime.compareTo(refund.movieStartTime) <= 0
    }
}
