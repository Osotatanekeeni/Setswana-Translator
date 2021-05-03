import java.util.*;
import java.io.*;
import java.util.regex.Pattern;


class Translator {

    ArrayList<String> pronouns = new ArrayList<String>();

    // Temp variables for translated words
    //His Car
    //Hardcode pronouns
    //Translating man, go to file, look for man, store the translation in a temp variable
    //Using sentences, tokenuze the then put them in a array 
    //Koloi ya monna

    public void testTranslator(String word) {
        //Add the pronouns
        pronouns.add("his");
        pronouns.add("her");
        pronouns.add("your");
        pronouns.add("their");

        File file = new File("nouns.txt");
        try {
            Scanner sc = new Scanner(file);

            while(sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] arr = line.split(" ");
                String english = arr[0];
                String setswana = arr[1];

                if (word.equalsIgnoreCase(english)) {
                    System.out.println(word + " --> " + setswana);
                } 
                continue;
            }
            //His car - Koloi 
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
    }

    public static String checkNoun(String n) {
        File nouns = new File("nouns.txt");
        String tempNoun = "";
        try {
            Scanner sc = new Scanner(nouns);
            while(sc.hasNextLine()) {
                String noun = sc.nextLine();
                String[] nounArr = noun.split(" ");
                String englishNoun = nounArr[0];
                String setswanaNoun = nounArr[1];

                    if (n.equalsIgnoreCase(englishNoun))
                        tempNoun = setswanaNoun;
            }
        sc.close();
        }catch(FileNotFoundException e) {
            e.printStackTrace();
        }
        return tempNoun;
    }

    public static String checkPronoun(String n) {
        File pronouns = new File("pronouns.txt");
        String tempPronoun = "";
        try {
            Scanner sc = new Scanner(pronouns);
            while(sc.hasNextLine()) {
                String pronoun = sc.nextLine();
                String[] pronounArr = pronoun.split(" ");
                String englishPro = pronounArr[0];
                String setswanaPro = pronounArr[1];

                    if (n.equalsIgnoreCase(englishPro))
                        tempPronoun = setswanaPro;
            }
        sc.close();
        }catch(FileNotFoundException e) {
            e.printStackTrace();
        }
        return tempPronoun;
    }

    public static String checkAdjective(String n) {
        File adjs = new File("adjectives.txt");
        String tempAdj = "";
        try {
            Scanner sc = new Scanner(adjs);
            while(sc.hasNextLine()) {
                String adj = sc.nextLine();
                String[] adjArr = adj.split(" ");
                String englishAdj = adjArr[0];
                String setswanaAdj = adjArr[1];

                    if (n.equalsIgnoreCase(englishAdj))
                        tempAdj = setswanaAdj;
            }
        sc.close();
        }catch(FileNotFoundException e) {
            e.printStackTrace();
        }
        return tempAdj;
    }

    /**
     * Translation for a sentence with possessive and adjective
     */
    public void translateSentence(String sentence) {
        File nounClass = new File("nounClass.txt");
    
        String[] words = sentence.split(" ");
        System.out.println(Arrays.toString(words));
        Pattern pattern = Pattern.compile(" ");
        words = pattern.split(sentence);
        //System.out.println(Arrays.toString(words));

        String tempPronoun, tempNoun, tempAdjective, tempConcord;
        tempPronoun = tempNoun = tempAdjective = tempConcord = "";
        String transPronoun, transNoun, transAdjective;
        transPronoun = transNoun = transAdjective = "";
        String subs = "";
        String subs2 = "";
        String subs3 = "";
        // String tempNoun = "";
        // String tempAdjective = "";
        // String tempConcord = "";
        //String combinedSentence = "";

        /**
         * Sentence: His red chair
         * Pronoun = red
         * Noun = chair
         * Adjective = red
         */
        try {
            Scanner sc = new Scanner(nounClass);

            while(sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] arr = line.split(";");
                String legokedi = arr[0];
                String letlhaodi = arr[1];
                //String leamanyi = arr[2];
                String lerui = arr[3];

                tempPronoun = words[0];
                tempAdjective = words[1];
                tempNoun = words[2];
                transNoun = checkNoun(tempNoun);
                //transAdjective = checkAdjective(tempAdjective);
                //transPronoun = checkPronoun(tempPronoun);

                //get the first 2 characters of the noun
                //to find the class
                subs = transNoun.substring(0,2);
                subs2 = transNoun.substring(0,1);
                subs3 = transNoun.substring(0,3);
                if (subs.equalsIgnoreCase(legokedi)) {
                    transPronoun = lerui+ " "+checkPronoun(tempPronoun);
                    transAdjective = letlhaodi+ " " + checkAdjective(tempAdjective);
                }
                if (subs2.equalsIgnoreCase(legokedi)) {
                    transPronoun = lerui+ " "+checkPronoun(tempPronoun);
                    transAdjective = letlhaodi+ " " + checkAdjective(tempAdjective);
                }
                if (subs3.equalsIgnoreCase(legokedi)) {
                    transPronoun = lerui+ " "+checkPronoun(tempPronoun);
                    transAdjective = letlhaodi+ " " + checkAdjective(tempAdjective);
                }

            }
            
            System.out.println(transNoun + " " + transPronoun + " " + transAdjective + " ");
            sc.close();
        }catch(FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws FileNotFoundException {
        
        Translator translate= new Translator();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a sentence: ");
        String sentence = sc.nextLine();

        //translate.testTranslator(word);
        sc.close();
        translate.translateSentence(sentence);
    }
}