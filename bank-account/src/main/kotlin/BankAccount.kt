class BankAccount {
    private var opened = true

    var balance = 0
        @Synchronized get() {
            checkIfOpen()
            return field
        }
        private set

    @Synchronized
    fun adjustBalance(amount: Int) {
        checkIfOpen()
        balance += amount
    }

    @Synchronized
    fun close() {
        opened = false
    }

    private fun checkIfOpen() {
        require(opened) { throw IllegalStateException("Account is closed") }
    }
}