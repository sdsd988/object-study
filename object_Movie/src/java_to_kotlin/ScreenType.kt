package java_to_kotlin

enum class ScreenType(val fee: Money) {
    IMAX(Money.Companion.wons(20000)),
    SCREENX(Money.Companion.wons(17000)),
    BASIC(Money.Companion.wons(13000))

}
