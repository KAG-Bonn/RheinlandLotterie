import java.util.UUID;
import java.util.Random;

public class Lottoschein{
    private String id;
    private int datumTag;
    private int datumMonat;
    private int datumJahr;
    private int[][] reihen;
    

    public Lottoschein(int pAnzahlReihen, int pDatumTag, int pDatumMonat, int pDatumJahr){
        id = UUID.randomUUID().toString();
        datumTag = pDatumTag;
        datumMonat = pDatumMonat;
        datumJahr = pDatumJahr;
        reihen = new int[pAnzahlReihen][6];
        for(int i = 0; i < pAnzahlReihen; i++){
            fuelleReiheZufaellig(i);
        }
    }

    public void fuelleReiheZufaellig(int pReihe, int[] pZahlen){
        reihen[pReihe] = pZahlen;
    }
    
    public int[] gibDatum(){
        int[] datum = {datumTag, datumMonat, datumJahr};
        return datum;
    }
    
    public int gibAnzahlReihen(){
        return reihen.length;
    }
    
    public int[] gibReihe(int pReihe){
        return reihen[pReihe];
    }
    
    public String gibId(){
        return id;
    }
    
    public void gibReiheAus(int pReihe){
        System.out.print("[");
        for(int i = 0; i < reihen[pReihe].length; i++){
            System.out.print(reihen[pReihe][i] + " ");
        }
        System.out.println("]");
    }
    
    private void fuelleReiheZufaellig(int pReihe){
        Random rand = new Random();
        int i = 0;
        while(i < reihen[pReihe].length){
            int n = rand.nextInt(49)+1;
            if(!istEnthalten(n, reihen[pReihe])){
                reihen[pReihe][i] = n;
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
    
    public double ermittlePreis(){
        return 2.50*reihen.length;
    }
    public String toString(){
        String ret = "Schein (" + id + "):{\n";
        int anzahlReihen = gibAnzahlReihen();
        for(int i = 0; i < anzahlReihen; i++){
            ret += "\t[";
            for(int j = 0; j < 6; j++){
                ret += reihen[i][j] + " ";
            }
            ret += "]\n";
        }
        return ret+"}";
    }
    
}
