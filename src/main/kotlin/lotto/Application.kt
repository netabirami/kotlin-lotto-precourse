package lotto

fun main() {
    OutputView.printLottoPurchaseAmount()
    val amount = InputsConsole.readLottoPurchaseAmount()
    val ticketCount = (amount / 1000)
    val lottoTickets = List(ticketCount) { LottoGenerator().generate() }

    OutputView.printTicketCount(ticketCount)
    OutputView.printTickets(lottoTickets.map { it.getSortedNumbers() })

    OutputView.printWinningNumbers()
    val winningNumbers = InputsConsole.readLottoWinningNumbers()

    OutputView.printBonusNumber()
    val bonusNumber = InputsConsole.readBonusNumber(winningNumbers)

    val lottoResults = Result(winningNumbers, bonusNumber)
    lottoResults.prepareResults(lottoTickets)

    OutputView.printResultStatistics(lottoResults.getStatistics())
    OutputView.printsReturnRate(lottoResults.calculateReturnRate(amount))
}
