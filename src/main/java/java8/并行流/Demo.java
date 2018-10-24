package java8.并行流;

import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.Calendar;
import java.util.OptionalLong;
import java.util.stream.LongStream;

public class Demo {


    @Test
    public void test1() {

        Instant start = Instant.now();
        Calendar instance = Calendar.getInstance();
        Calendar instance1 = Calendar.getInstance();
        instance1.set(Calendar.HOUR_OF_DAY, 18);
        System.out.println(instance1.getTime().toLocaleString());
        boolean after = instance.before(instance1);
        System.out.println(after);
        OptionalLong reduce = LongStream.range(1, 10000000000L)
                .parallel()
                .reduce(Long::sum);
        System.out.println(reduce.getAsLong());
        Instant end = Instant.now();
        System.out.println(Duration.between(start, end).toMillis());

    }
}
