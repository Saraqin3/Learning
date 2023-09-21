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
             
        int n =3;//random number;
        sort(n);
        print();
        
    }
    
    public static void sort(int n)
        {
            
            if(n!=0)
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
           sort(n);
            }
            
        }
    
    public static void divide(int n1, int n4)
    {


        if(n1!=n4)
        {
        int n2 = (n4 - n1)/2;
        int n3 = n2 + 1;
            
        divide(n1,n2);

        divide(n3, n4);

        }
        
        
    }
    
   
    
    public static void mergeSort()//nlog(n)
    {
        while ()
        {
        divide(0, list.length)
            
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
