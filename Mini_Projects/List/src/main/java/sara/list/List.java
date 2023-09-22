/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package sara.list;

/**
 *
 * @author saraqin
 */
public class List {

    static int[] list = {4,5,15,8,2,23,56,12,3,6,78,20,6};
    
    public static void main(String[] args) {
        System.out.println("Hello World!");
             
        int n =3;//random number;
        mergeSort(0,12);
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
    
    public static void mergeSort(int start, int end)
    {
        if (start != end)
        {
            int n2 = start+(end - start)/2;
            int n3 = n2 + 1;
            
            mergeSort(start,n2);
            mergeSort(n3, end);
        
            int startLeft = start;
            int startRight = n3;
            
            int [] newList = new int[end-start+1];
            int n = 0;
            
            // Comparison
            while ((startLeft < n2+1) && (startRight < end+1))
            {
                if (list[startLeft] < list[startRight])
                {
                    newList[n] = list[startLeft];
                    startLeft++;
                }      
                else
                {
                    newList[n] = list[startRight];               
                    startRight++;
                }
                n++;
            }
        
            // Move remaining values into list
            while (n<end-start+1)
            {
                if (startLeft<n2+1)
                {
                    newList[n]=list[startLeft];
                    startLeft++;
                    n++;
                }
                if (startRight<end+1)
                {
                    newList[n]=list[startRight];
                    startRight++;
                    n++;
                }
            }
            
            // Print newList
            for (int m=0;m<end-start+1;m++)
            {
                System.out.print(newList[m]+" ");
            }
            System.out.print("\n"); 
            
            // Replace the original part with newList
            int m = 0;
            while (start < end+1)
            {
                list[start] = newList[m];
                m++;
                start++;
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
