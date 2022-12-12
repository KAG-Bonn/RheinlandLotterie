import java.util.Random;

public class Ziehung{
    private int tag;
    private int monat;
    private int jahr;
    private int[] ziehung;
    
    public Ziehung(int pTag, int pMonat, int pJahr){
        tag = pTag;
        monat = pMonat;
        jahr = pJahr;
        
        ziehung = new int[6];
        ziehe();
    }

    private void ziehe(){
        Random rand = new Random();
        int i = 0;
        while(i < ziehung.length){
            int n = rand.nextInt(49)+1;
            if(!istEnthalten(n, ziehung)){
                ziehung[i] = n;
                i++;
            }
        }
    }
    
    private boolean istEnthalten(int pN, int[] pA){
        for(int i = 0; i < pA.length; i++){
            if(pA[i] == pN) return true;
        }
        return false;
    }
    
    
    public int[] gibDatum(){
        int[] datum = {tag, monat, jahr};
        return datum;
    }
    
    public int[] gibZiehung(){
        return ziehung;
    }
    public String toString(){
        String ret = "Ziehung am " + tag + "." + monat + "." + jahr + ": "; 
        ret += "[";
        for(int i = 0; i < ziehung.length; i++){
            ret += ziehung[i] + " ";
        }
        return ret + "]";
    }
}
