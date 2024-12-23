package test;

import java.util.Comparator;
import java.util.Map;

public class CompareByRoll implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        return (Integer)o1 - (Integer)o1;
    }
}
