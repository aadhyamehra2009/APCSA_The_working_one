package piglatin;
import java.util.Scanner;
public class PigLatinTranslator {
    public static Book translate(Book input) {
        Book translatedBook = new Book();

        // TODO: Add code here to populate translatedBook with a translation of the
        // input book.
        // Curent do-nothing code will return an empty book.
        // Your code will need to call translate(String input) many times.
        translatedBook.setTitle(input.getTitle()+"_Transalted");
        for(int index=0;index<input.getLineCount();index++)
        {
            String line=input.getLine(index);
            String transLine=translate(line);
            translatedBook.appendLine(transLine);


        }
        
        return translatedBook;
    }

    public static String translate(String input) {
        System.out.println("  -> translate('" + input + "')");

        String result = "";

        // The input to this function could be any English string.
        // It may be made up of many words.
        // This method must call translateWord once for each word in the string.
        Scanner sc = new Scanner(input);
        while (sc.hasNext()) {
            result+=translateWord(sc.next());
            if (sc.hasNext())
            {
                result+=" ";
            }
        }
        sc.close();
        return result;
    }
    public static boolean isVowel(String test)
    {
        String vowels = "aeiouyAEIOUY";
        if (vowels.indexOf(test) != -1)
        {
            return true;
        }
        return false;
    }
    public static boolean isPunct(String test)
    {
        String puncts = ",.?!\"[]()*`^\'";
        if (puncts.indexOf(test) != -1)
        {
            return true;
        }
        return false;
    }
    public static boolean isLetter(String test)
    {
        String letters = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";
        if (letters.indexOf(test) != -1)
        {
            return true;
        }
        return false;
    }
    private static String translateWord(String input) {
        System.out.println("  -> translateWord('" + input + "')");
        int firstVowelLocation=-1;
        String firstPart,secondPart,thirdPart="ay";
        String result = "";
        boolean isAllSpace=true;
        for (int i=0;i<input.length();i++)
        {
            if (isLetter(input.substring(i, i+1)))
            {
                result
            }
        }
        for (int i=0;i<input.length();i++)
        {
            if (!(input.substring(i, i+1).equals(" ")))
            {
                isAllSpace=false;
                break;
            }
        }
        if (isAllSpace)
        {
            return "";
        }
        boolean firstCap=false;
        if (Character.isUpperCase(input.charAt(0)))
        {
            firstCap=true;
        }
        for (int i=0;i<input.length();i++)
        {
            if (isVowel(input.substring(i, i+1)))
            {
                firstVowelLocation=i;
                break;
            }

        }

        if (input.equals("United"))
        {
            System.out.println("");
        }
        firstPart=input.substring(firstVowelLocation);
        secondPart=input.substring(0, firstVowelLocation);
        if (firstCap)
        {
            //first letter of first part should be upper cased with .touppercase
            firstPart=firstPart.substring(0,1).toUpperCase()+firstPart.substring(1);
            //first letter of second part should be lower cased with .tolowercase
            secondPart=secondPart.length()==0?secondPart:secondPart.substring(0,1).toLowerCase()+secondPart.substring(1);

        }
        if (isPunct(input.substring(input.length()-1)))//if we have any punctuation in input
        {
            //we just assume its in the end of the string
            thirdPart=thirdPart+firstPart.substring(firstPart.length()-1);
            firstPart=firstPart.substring(0,firstPart.length()-1);
        }
        result=firstPart+secondPart+thirdPart;

        // Start here first!
        // This is the first place to work.
        

        return result;

    }

    // Add additonal private methods here.
    // For example, I had one like this:
    // private static String capitalizeFirstLetter(String input)

}
