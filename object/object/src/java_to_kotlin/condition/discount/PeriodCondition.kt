package java_to_kotlin.condition.discount

import java_to_kotlin.Screening
import java.time.DayOfWeek
import java.time.LocalTime

class PeriodCondition(
    private val dayOfWeek: DayOfWeek,
    private val startTime: LocalTime,
    private val endTime: LocalTime
) : discountCondition {
    override fun isSatisfiedBy(screening: Screening): Boolean {
        return screening.startTime.dayOfWeek == dayOfWeek &&
                startTime <= screening.startTime.toLocalTime() &&
                endTime >= screening.startTime.toLocalTime()
    }
}
