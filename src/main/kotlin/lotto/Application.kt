package lotto

fun main() {
    OutputConsole.printLottoPurchaseAmount()
    val amount = InputsConsole.readLottoPurchaseAmount()
    val ticketCount = (amount / 1000)
    val lottoTickets = List(ticketCount) { LottoGenerator().generate() }

    OutputConsole.printTicketCount(ticketCount)
    OutputConsole.printTickets(lottoTickets.map { it.getSortedNumbers() })

    OutputConsole.printWinningNumbers()
    val winningNumbers = InputsConsole.readLottoWinningNumbers()

    OutputConsole.printBonusNumber()
    val bonusNumber = InputsConsole.readBonusNumber(winningNumbers)

    val lottoResults = Result(winningNumbers, bonusNumber)
    lottoResults.analyzeResult(lottoTickets)

    OutputConsole.printResultStatistics(lottoResults.getStatistics())
    OutputConsole.printsReturnRate(lottoResults.calculateReturnRate(amount))
}
