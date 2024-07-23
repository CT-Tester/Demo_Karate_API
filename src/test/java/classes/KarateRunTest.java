package classes;

import com.intuit.karate.junit5.Karate;

public class KarateRunTest {
    @Karate.Test
    public Karate preapprovedTest() {
        return Karate.run("classpath:features").relativeTo(getClass());
    }

}
