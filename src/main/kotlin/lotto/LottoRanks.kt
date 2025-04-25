package lotto

enum class LottoRanks(
    val matchCount: Int,
    val isBonus: Boolean = false,
    val prize: Int,
    val description: String
) {
    MISS(0, false, 0, "No prize"),
    FIFTH(3, false, PRIZE_FIFTH, LottoRanksOutputFormatter.formatDescription(3, false, PRIZE_FIFTH)),
    FOURTH(4, false, PRIZE_FOURTH, LottoRanksOutputFormatter.formatDescription(4, false, PRIZE_FOURTH)),
    THIRD(5, false, PRIZE_THIRD, LottoRanksOutputFormatter.formatDescription(5, false, PRIZE_THIRD)),
    SECOND(5, true, PRIZE_SECOND, LottoRanksOutputFormatter.formatDescription(5, true, PRIZE_SECOND)),
    FIRST(6, false, PRIZE_FIRST, LottoRanksOutputFormatter.formatDescription(6, false, PRIZE_FIRST));

    companion object {
        fun from(matchCount: Int, isBonus: Boolean): LottoRanks {
            return when {
                matchCount == FIRST.matchCount -> FIRST
                matchCount == SECOND.matchCount && isBonus -> SECOND
                matchCount == THIRD.matchCount -> THIRD
                matchCount == FOURTH.matchCount -> FOURTH
                matchCount == FIFTH.matchCount -> FIFTH
                else -> MISS
            }
        }
    }
}