package lotto
object LottoRanksOutputFormatter {
    fun formatDescription(match: Int, isBonus: Boolean, prize: Int): String {
        return if (isBonus) {
            "$match Matches + Bonus Ball (${formatCurrency(prize)})"
        } else {
            "$match Matches (${formatCurrency(prize)})"
        }
    }

    private fun formatCurrency(amount: Int): String {
        return "%,d KRW".format(amount)
    }
}