
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentgrades;


/**
 *
 * @author mehme_000
 */
public class SortAll {
    
    public static void bubbleSort(Comparable in[]){
        Comparable t = null;
        
        for(int i=0;i<in.length-1;i++){
            for(int j=i+1;j<in.length;j++){
                if(in[i]!=null && in[j]!=null){
                    if(in[i].compareTo(in[j]) > 0){
                        t = in[i];
                        in[i] = in[j];
                        in[j] = t;
                    }
                }
            }
        }    
    }
    
    public static void selectionSort(Comparable in[]){
        Comparable min = null;
        int m = 0;
        for(int i=0;i<in.length-1;i++){
            min = null;
            for(int j = i+1;j<in.length;j++){
                if(in[i]!=null && in[j]!=null && min==null && in[i].compareTo(in[j]) > 0){
                        min = in[j];
                        m = j;
                }
                else if(in[i]!=null && in[j]!=null && min!=null && min.compareTo(in[j]) > 0){
                        min = in[j];
                        m = j;
                }
        }
            if(min!=null){
                in[m] = in[i];
                in[i] = min;
            }
        }
    }
    
}
