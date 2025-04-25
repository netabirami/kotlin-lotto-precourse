package lotto

class Result(
    private val winningNumbers: List<Int>,
    private val bonusNumber: Int
) {
    private val lottoResults = mutableListOf<LottoRanks>()

    fun analyzeResult(lottoTickets: List<Lotto>) {
        lottoResults.clear()
        lottoResults.addAll(lottoTickets.map { lotto ->
            val match = lotto.countingWinningNumbers(winningNumbers)
            val isBonus = lotto.isContainsBonusNumber(bonusNumber)
            LottoRanks.from(match, isBonus)
        })
    }

    fun getStatistics(): Map<LottoRanks, Int> {
        return lottoResults
            .filter { it != LottoRanks.MISS }
            .groupingBy { it }
            .eachCount()
    }

    fun calculateReturnRate(purchaseAmount: Int): Double {
        val totalPrize = lottoResults.sumOf { it.prize.toLong() }
        return (totalPrize.toDouble() / purchaseAmount) * 100
    }
}