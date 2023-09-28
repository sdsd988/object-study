package java_to_kotlin

class ReservationAgency {
    fun reserve(screening: Screening, customer: Customer?, audienceCount: Int): Reservation {
        val fee = screening.calculateFee(audienceCount)
        return Reservation(customer, screening, fee, audienceCount)
    }
}
