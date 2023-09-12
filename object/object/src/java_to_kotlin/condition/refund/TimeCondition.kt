package java_to_kotlin.condition.refund

import java_to_kotlin.Screening
import java.time.LocalDateTime

class TimeCondition : RefundCondition {
    private val currentTime: LocalDateTime? = null
    override fun isSatisfiedBy(screening: Screening): Boolean {
        return currentTime!!.compareTo(screening.startTime) <= 0
    }
}
