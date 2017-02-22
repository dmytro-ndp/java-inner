package test;

/**
 * Hello world!
 * Output:
 App anonym + App method local inner test
 App inner value
 App static inner value
 */
public class App {

    public static void main(String[] args) {
        testAppInnerClass();
    }

    private static void testAppInnerClass() {
        App anonym = new App() {
            String anonym = "App anonym";

            @Override
            public String getAppValue() {
                return getAnonymValue() + " + " + super.getAppValue();
            }

            String getAnonymValue() {
                return anonym;
            }
        };

        System.out.println(anonym.getAppValue());

        System.out.println(anonym.new Inner().getInnerValue());

        System.out.println(new StaticInner().getStaticInnerValue());
    }

    public String getAppValue() {
        final String methodValue = "App method local inner test";

        class MethodLocalInner {
            String getValue() {
                return methodValue;
            }
        }

        return new MethodLocalInner().getValue();
    }

    class Inner {
        private String innerValue = "App inner value";

        String getInnerValue() {
            return innerValue;
        }
    }

    static class StaticInner {
        private String staticInnerValue = "App static inner value";

        String getStaticInnerValue() {
            return staticInnerValue;
        }
    }

}
