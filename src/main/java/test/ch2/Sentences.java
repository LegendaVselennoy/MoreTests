package test.ch2;

public enum Sentences {

    JUNIT_IN_ACTION("JUnit in Action"),
    SOME_PARAMETERS("Check some parameters"),
    THREE_PARAMETERS("Check three parameters");

    private final String sentence;

    Sentences(String sentence) {
        this.sentence = sentence;
    }

    public String value() {
        return sentence;
    }
}
