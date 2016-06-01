package cn.aposoft.basic.generics.effective.item23;
import java.util.*;

public class Raw {
    // Uses raw type (List) - fails at runtime! - Page 112
    public static void main(String[] args) {
        List<String> strings = new ArrayList<String>();
        unsafeAdd(strings, new Integer(42));
        @SuppressWarnings("unused")
		String s = strings.get(0); // Compiler-generated cast
    }
    
    // don't do this!
    @SuppressWarnings({ "unchecked", "rawtypes" })
	private static void unsafeAdd(List list, Object o) {
        list.add(o);
    }

    // Use of raw type for unknown element type - don't do this! - Page 113
    static int rawNumElementsInCommon(@SuppressWarnings("rawtypes") Set s1, @SuppressWarnings("rawtypes") Set s2) {
        int result = 0;
        for (Object o1 : s1)
            if (s2.contains(o1))
                result++;
        return result;
    }

    // Unbounded wildcard type - typesafe and flexible - Page 113
    static int numElementsInCommon(Set<?> s1, Set<?> s2) {
        int result = 0;
        for (Object o1 : s1)
            if (s2.contains(o1))
                result++;
        return result;
    }
}

