public class Result {
    private int wordLenght;
    private String charArray;
    private double frequency;

    public Result(int wordLenght, String charArray, double frequency) {
        this.wordLenght = wordLenght;
        this.charArray = charArray;
        this.frequency = frequency;
    }

    public int getWordLenght() {
        return wordLenght;
    }

    public String getCharArray() {
        return charArray;
    }

    public double getFrequency() {
        return frequency;
    }

    @Override
    public String toString() {
        return "Result{" +
                "wordLenght=" + wordLenght +
                ", charArray='" + charArray + '\'' +
                ", frequency=" + frequency +
                '}';
    }
}
