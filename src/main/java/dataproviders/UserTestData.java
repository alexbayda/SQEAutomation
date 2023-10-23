package dataproviders;



import org.testng.annotations.DataProvider;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.StreamSupport;

public class UserTestData implements Iterable<Object[]> {

    private final List<Object[]> usersData = Arrays.asList(
            new Object[]{"Alex8098", "Alex", "Bayda", "alexalex@email.com", "12345", "9056424242", 1},
            new Object[]{"Alex8098ADD", "AlexADD", "BaydaADD", "alexalexADD@email.com", "54321", "905642424ADD2", 0}
    );

    private final List<Object[]> userData = Collections.singletonList((
            new Object[]{"Alex8098", "Alex", "Bayda", "alexalex@email.com", "12345", "9056424242", 1}
    ));
    @Override
    public Iterator<Object[]> iterator() {
        return userData.iterator();
    }

    @DataProvider(name = "userData")
    public static Object[][] userDataProvider() {
        Iterable<Object[]> iterable = new UserTestData();
        return StreamSupport.stream(iterable.spliterator(), false).toArray(Object[][]::new);
    }
}
