package java_to_kotlin.condition.discount

import java_to_kotlin.Screening
import java.time.DayOfWeek
import java.time.LocalTime

class PeriodCondition(private val dayOfWeek: DayOfWeek, private val startTime: LocalTime, private val endTime: LocalTime) : DiscountCondition {
    override fun isSatisfiedBy(screening: Screening): Boolean {
        return screening.startTime.dayOfWeek == dayOfWeek && startTime.compareTo(screening.startTime.toLocalTime()) <= 0 && endTime.compareTo(screening.startTime.toLocalTime()) >= 0
    }
}
