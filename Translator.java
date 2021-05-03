import java.util.*;
import java.io.*;
import java.util.regex.Pattern;


class Translator {

    public static void translateNoun(String word) {
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
            }
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

    public static void printNouns() {
        File nouns = new File("nouns.txt");

        try {
            Scanner sc = new Scanner(nouns);
            System.out.print("Accepted Nouns --> [ ");
            while(sc.hasNextLine()) {
                String noun = sc.nextLine();
                String[] nounarr = noun.split(" ");
                String englishnoun = nounarr[0];
                
                System.out.print(englishnoun + "|");
            }
            System.out.print(" ]");
            System.out.println("");
            sc.close();
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void printPronouns() {
        File pronouns = new File("pronouns.txt");

        try {
            Scanner sc = new Scanner(pronouns);
            System.out.print("Accepted Pronouns --> [ ");
            while(sc.hasNextLine()) {
                String pronoun = sc.nextLine();
                String[] pronounarr = pronoun.split(" ");
                String englishpro = pronounarr[0];
                
                System.out.print(englishpro + "|");
            }
            System.out.print(" ]");
            System.out.println(" ");
            sc.close();
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void printAdjectives() {
        File adjectives = new File("adjectives.txt");

        try {
            Scanner sc = new Scanner(adjectives);
            System.out.print("Accepted Adjectives --> [ ");
            while(sc.hasNextLine()) {
                String adj = sc.nextLine();
                String[] adjarr = adj.split(" ");
                String englishadj = adjarr[0];
                
                System.out.print(englishadj + "|");
            }
            sc.close();
            System.out.print(" ]");
            System.out.println("");
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void translateAdjectiveAndNoun(String sentence) {
        File nounClass = new File("nounClass.txt");
        String[] words = sentence.split(" ");
        Pattern pattern = Pattern.compile(" ");
        words = pattern.split(sentence);

        String tempNoun, tempAdjective;
        tempNoun = tempAdjective = "";
        String transAdjective, transNoun;
        transNoun = transAdjective = "";

        try {
            Scanner sc = new Scanner(nounClass);

            while(sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] arr = line.split(";");
                String legokedi = arr[0];
                String letlhaodi = arr[1];
                //String leamanyi = arr[2];
                String lerui = arr[3];

                
                tempAdjective = words[0];
                tempNoun = words[1];
                transNoun = checkNoun(tempNoun);

                String concord = transNoun.substring(0,2);
                String concord2 = transNoun.substring(0,1);
                String concord3 = transNoun.substring(0,3);

                if (concord.equalsIgnoreCase(legokedi)) {
                    transAdjective = letlhaodi+ " " + checkAdjective(tempAdjective);
                }
                if (concord2.equalsIgnoreCase(legokedi)) {
                    transAdjective = letlhaodi+ " " + checkAdjective(tempAdjective);
                }
                if (concord3.equalsIgnoreCase(legokedi)) {
                    transAdjective = letlhaodi+ " " + checkAdjective(tempAdjective);
                }
            }
            System.out.println(sentence + " " + "-->" + transNoun + " " + transAdjective);
            sc.close();
        }catch(FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    /**
     * Translation for a sentence with possessive and adjective
     */
    public static void translateSentence(String sentence) {
        File nounClass = new File("nounClass.txt");
    
        String[] words = sentence.split(" ");
        //System.out.println(Arrays.toString(words));
        Pattern pattern = Pattern.compile(" ");
        words = pattern.split(sentence);
        //System.out.println(Arrays.toString(words));

        String tempPronoun, tempNoun, tempAdjective;
        tempPronoun = tempNoun = tempAdjective = "";
        String transPronoun, transNoun, transAdjective;
        transPronoun = transNoun = transAdjective = "";
        String concord = "";
        String concord2 = "";
        String concord3 = "";

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
                concord = transNoun.substring(0,2);
                concord2 = transNoun.substring(0,1);
                concord3 = transNoun.substring(0,3);

                if (concord.equalsIgnoreCase(legokedi)) {
                    transPronoun = lerui+ " "+checkPronoun(tempPronoun);
                    transAdjective = letlhaodi+ " " + checkAdjective(tempAdjective);
                }
                if (concord2.equalsIgnoreCase(legokedi)) {
                    transPronoun = lerui+ " "+checkPronoun(tempPronoun);
                    transAdjective = letlhaodi+ " " + checkAdjective(tempAdjective);
                }
                if (concord3.equalsIgnoreCase(legokedi)) {
                    transPronoun = lerui+ " "+checkPronoun(tempPronoun);
                    transAdjective = letlhaodi+ " " + checkAdjective(tempAdjective);
                }

            }
            
            System.out.println(sentence + " " + "---> " +transNoun + " " + transPronoun + " " + transAdjective + " ");
            sc.close();
        }catch(FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("");
        System.out.println("----------ENGLISH TO SETSWANA TRANSLATION----------");
        System.out.println("");

        printNouns();
        printPronouns();
        printAdjectives();
        System.out.println("");
       
        // Translator translate= new Translator();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String sentence = sc.nextLine();

        sc.close();

        //TRANSLATE A NOUN
        //translateNoun(sentence);
        //Sentence with only noun and adjective
        //translateAdjectiveAndNoun(sentence);

        //Sentence with pronoun, adjective and noun
        translateSentence(sentence);
    }
}