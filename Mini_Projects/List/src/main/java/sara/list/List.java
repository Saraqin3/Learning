/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package sara.list;

/**
 *
 * @author saraqin
 */
public class List {

    static int[] list = {4,5,7,8,4,23,56,12,3,6,78,20,6};
    
    public static void main(String[] args) {
        System.out.println("Hello World!");
             
        sort();
        print();
        
    }
    
    public static void sort()
        {
            int n = 3;//random number
            while(n!=0)
            {
            n=0;
            for (int i=0;i+1<list.length;i++)
            {
                
                if(list[i]>list[i+1])
                {
                    int box=list[i];
                    list[i]=list[i+1];
                    list[i+1]=box;
                    n++;

                }
                    
            }
            }
        }
    
    public static void print()
    {
        for (int i=0;i<list.length;i++)
        {
         System.out.print(list[i]+" ");
        }
    }
}
