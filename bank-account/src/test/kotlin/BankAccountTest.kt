import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.runBlocking
import org.junit.Test
import java.util.Random
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class BankAccountTest {

    @Test
    fun zeroBalanceWhenOpened() {
        val account = BankAccount()
        assertEquals(0, account.balance)
    }

    @Test
    fun sequentialBalanceAdjustments() {
        val account = BankAccount()

        account.adjustBalance(1000)
        assertEquals(1000, account.balance)

        account.adjustBalance(-958)
        assertEquals(42, account.balance)
    }

    @Test
    fun closedAccountHasNoBalance() {
        val account = BankAccount()
        account.close()

        assertFailsWith(IllegalStateException::class, { account.balance })
    }

    @Test
    fun closedAccountCannotBeAdjusted() {
        val account = BankAccount()
        account.close()

        assertFailsWith(IllegalStateException::class, { account.adjustBalance(1000) })
    }

    @Test
    fun concurrentBalanceAdjustments() {
        val threads = 1000
        val iterations = 500
        val random = Random()

        val account = BankAccount()

        val jobs = List(threads) {
            launch(CommonPool) {
                repeat(iterations) {
                    account.adjustBalance(1)
                    delay(random.nextInt(10).toLong())
                    account.adjustBalance(-1)
                }
            }
        }

        runBlocking {
            jobs.forEach { it.join() }
        }

        assertEquals(0, account.balance)
    }
}

