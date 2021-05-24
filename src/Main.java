import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        String input = "logic";
        String inputText;

        //get text from user input
        Scanner scanner = new Scanner(System.in);
        inputText = scanner.nextLine().toLowerCase();
        int totalCharacters = inputText.length();
        totalCharacters -= countInvalidChars(inputText);
        String words[] =inputText.split(" ");

        int [][] appearance = new int[words.length][input.length()];
        int counter = 0;
        int totalAppearance = 0;
        for (String word: words) {  //check for given characters in the text
            for(int i=0;i<input.length();i++){
                for(int j=0;j<word.length();j++){
                    if(word.charAt(j)==input.charAt(i)){
                        totalAppearance++;
                        appearance[counter][i]=1;
                    }
                }
            }
            counter++;
        }

        //create the list, with necessary data
        counter = 0;
        List<Result> listResult = new ArrayList<Result>();
        for (String word: words) {
            double tmpAppearance = 0.0;
            String charArray = "";
            for (int i=0;i<input.length();i++){
                for(int j=0;j<word.length();j++)
                if((word.charAt(j)==input.charAt(i))){
                    if(!charArray.contains(String.valueOf(input.charAt(i))))
                    charArray+=input.charAt(i);

                        tmpAppearance++;
                }
            }
            listResult.add(new Result(word.length(),charArray,Math.round(100*tmpAppearance/totalAppearance)/100.0));

        }

        //sort list for frequency and print
        listResult.sort(Comparator.comparingInt(Result::getWordLenght).thenComparingDouble(Result::getFrequency));
        for(Result r: listResult) {
            System.out.println("{ (" + r.getCharArray() + "), " + r.getWordLenght() + "} = " + r.getFrequency() + " (" + r.getCharArray().length()
            + "/" + totalAppearance + ")");
        }
        System.out.println("TOTAL frequency: " + Math.round(100*totalAppearance/totalCharacters)/100.0);

    }

    public static int countInvalidChars(String inputText){
        final String invalidChars = " !\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~);";
        int counter=0;

        for(int i=0;i<inputText.length();i++){
            if((invalidChars.indexOf(inputText.charAt(i))!=-1))
            counter++;
        }
        return counter;
    }

}
