/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package sara.textanalyzer;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/**
 *
 * @author saraqin
 */
public class TextAnalyzer {

    public static void main(String[] args) throws FileNotFoundException, IOException  {
        String stringText=null;
        HashMap<String,String> verbsNouns = new HashMap();
        HashMap<String,String> repetitions = new HashMap();
        List<String> repeatedWords = new ArrayList();
        
        try 
        {
            System.out.println("Hello World!");
            File file = new File("/Users/saraqin/Downloads/text.txt");
            File verbFile = new File("/Users/saraqin/Downloads/noun_and_verb.txt");
            FileReader text = new FileReader (file);
            FileReader verbText = new FileReader (verbFile);
            BufferedReader bufferedText = new BufferedReader(text);
            BufferedReader bufferedVerbText = new BufferedReader(verbText);
        
            stringText = bufferedText.readLine();
            String s;
            
            while((s = bufferedVerbText.readLine())!=null)
            {
                String[] splited=s.split("\\,");
                verbsNouns.put(splited[0], splited[1]);
                System.out.println("key: "+splited[0]);
                System.out.println("value: "+splited[1]);
            }
        }
        catch(RuntimeException e)
        {
            System.out.println("Fail to operate");
        }

        String[] splited=stringText.split("[\\,\\.\\s]+");
        for (int i=0;i<splited.length;i++)
        {
            System.out.println(splited[i]);
        }

        int numberOfVerb=0;
        int numberOfNoun=0;
        List<String> verbs = new ArrayList();
        List<String> nouns = new ArrayList();
        int numberOfRepeat=0;
        for (String var:splited)
        {
            if(repetitions.get(var)!=null)
            {
                numberOfRepeat++;
                repeatedWords.add(var);
                continue;
            }
            
            String value = verbsNouns.get(var);
            
            if(value==null)
            {
                continue;
            }
            
            
            
            if(value.equals("verb"))
            {
                numberOfVerb++;
                verbs.add(var);
            }
            
            if(value.equals("noun"))
            {
                numberOfNoun++;
                nouns.add(var);
                }
            repetitions.put(var, value);
            
            
        }

        System.out.println("Verbs: "+numberOfVerb);
        System.out.println("Nouns: "+numberOfNoun);

        System.out.print("Verbs: ");
        for (int i=0;i<verbs.size();i++)
        {
          System.out.print(verbs.get(i)+" ");  
        }
        System.out.println();  
        
        
        System.out.print("Nouns: ");
        for (int i=0;i<nouns.size();i++)
        {
            System.out.print(nouns.get(i)+" ");  
        }
        System.out.println(); 

        System.out.println("The repeated word is :");
        for (String s :repeatedWords)
        {
            System.out.println(s+" ");
        }
        System.out.println("Number of repetition is :"+numberOfRepeat);
    } 
}
