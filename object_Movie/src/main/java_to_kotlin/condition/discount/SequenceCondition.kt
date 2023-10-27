package java_to_kotlin.condition.discount

import java_to_kotlin.Screening

class SequenceCondition(private val sequence: Int) : DiscountCondition {
    override fun isSatisfiedBy(screening: Screening): Boolean {
        return screening.isSequence(sequence)
    }
}
