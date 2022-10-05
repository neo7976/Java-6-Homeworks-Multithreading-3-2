import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.IntStream;

public class ReportThread {
    AtomicReference<BigDecimal> money = new AtomicReference<>(BigDecimal.ZERO);

    public void tax(int[] array) {
        BigDecimal addValue = BigDecimal.valueOf(IntStream.of(array).sum() * 0.13);
        System.out.printf("Совершен перевод на сумму %.2f руб. от %s.\n", addValue, Thread.currentThread().getName());
        money.accumulateAndGet(addValue, BigDecimal::add);
        System.out.printf("Баланс: %.2f руб.\n", getMoney());
    }

    public BigDecimal getMoney() {
        return money.get();

    }
}
