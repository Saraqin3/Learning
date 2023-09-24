/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package sara.caloriecount;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
/**
 *
 * @author saraqin
 */
public class CalorieCount {
    
    static HashMap<String,FoodInformation> foodBank = new HashMap();
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        System.out.println("Hello World!");
        
        
        
        File file = new File("/Users/saraqin/Downloads/food.csv");
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        
        String s="start";
        while ((s = bufferedReader.readLine())!=null)
        {
           String[] strings = s.split("\\,");
           int caleries=Integer.valueOf(strings[2])/100;
           FoodInformation foodInfo = new FoodInformation(strings[1],caleries);
           foodBank.put(strings[0], foodInfo);
        }
        
        Integer howMuchCaloriesIAte=0;
        howMuchCaloriesIAte+=calerieCalculator("Butter",10);
        howMuchCaloriesIAte+=calerieCalculator("Toast",200);
        howMuchCaloriesIAte+=calerieCalculator("Banana",50);
        howMuchCaloriesIAte+=calerieCalculator("Brown Rice",100);
        howMuchCaloriesIAte+=calerieCalculator("Lamb",50);
        howMuchCaloriesIAte+=calerieCalculator("Shrimp",50);
        howMuchCaloriesIAte+=calerieCalculator("Beef Steak",75);
        howMuchCaloriesIAte+=calerieCalculator("Yogurt",125);
        howMuchCaloriesIAte+=calerieCalculator("Trout",250);
        howMuchCaloriesIAte+=calerieCalculator("Spinach",100);
        
        System.out.println("How much calories I ate? "+howMuchCaloriesIAte);
        
        Integer howMuchCaloriesIAteFish=0;
        howMuchCaloriesIAteFish+=calerieCalculatorFish("Butter",10);
        howMuchCaloriesIAteFish+=calerieCalculatorFish("Toast",200);
        howMuchCaloriesIAteFish+=calerieCalculatorFish("Banana",50);
        howMuchCaloriesIAteFish+=calerieCalculatorFish("Brown Rice",100);
        howMuchCaloriesIAteFish+=calerieCalculatorFish("Lamb",50);
        howMuchCaloriesIAteFish+=calerieCalculatorFish("Shrimp",50);
        howMuchCaloriesIAteFish+=calerieCalculatorFish("Beef Steak",75);
        howMuchCaloriesIAteFish+=calerieCalculatorFish("Yogurt",125);
        howMuchCaloriesIAteFish+=calerieCalculatorFish("Trout",250);
        howMuchCaloriesIAteFish+=calerieCalculatorFish("Spinach",100);
        
        
        System.out.println("How much calories of fish did I eat? "+howMuchCaloriesIAteFish);
        
    }
    
    public static Integer calerieCalculator(String name, int gram)
    {
        if (foodBank.get(name)==null)
        {
            System.out.println(name + " does not exist");
            return 0;
        }
        return(foodBank.get(name).caleries*gram);
    }
    
    public static Integer calerieCalculatorFish(String name, int gram)
    {
        
        if (foodBank.get(name)==null||foodBank.get(name).category.equals("Fish")==false)
        {
            System.out.println(name + " is not fish");
            return 0;
        }
        return(foodBank.get(name).caleries*gram);
    }
}
