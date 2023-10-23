package utils;

import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.Random;

@UtilityClass
public class RandomElementSelector {
    public static <E> E getRandom(List<E> element) {
        Random random = new Random();
        int randomIndex = random.nextInt(element.size());
        return element.get(randomIndex);
    }
}

