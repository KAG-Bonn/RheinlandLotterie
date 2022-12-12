import java.util.Random;

public class Hauptprogramm{
    public static void main(String[] args){
        RheinlandLotto v = new RheinlandLotto();
        v.fuegeZiehungHinzu(new Ziehung(14,11,2022));

        for(int i = 0; i < 5000; i++){
            Ziehung z = v.gibAktuelleZiehung();
            if(z == null) break;
            int[] datum = z.gibDatum();
            Random rand = new Random();
            v.fuegeLottoscheinHinzu(new Lottoschein(rand.nextInt(10),datum[0],datum[1],datum[2]));
        }
        v.fuegeZiehungHinzu(new Ziehung(21,11,2022));
        for(int i = 0; i < 5000; i++){
            Ziehung z = v.gibAktuelleZiehung();
            if(z == null) break;
            int[] datum = z.gibDatum();
            Random rand = new Random();
            v.fuegeLottoscheinHinzu(new Lottoschein(rand.nextInt(10),datum[0],datum[1],datum[2]));
        }
        v.fuegeZiehungHinzu(new Ziehung(28,11,2022));
        for(int i = 0; i < 5000; i++){
            Ziehung z = v.gibAktuelleZiehung();
            if(z == null) break;
            int[] datum = z.gibDatum();
            Random rand = new Random();
            v.fuegeLottoscheinHinzu(new Lottoschein(rand.nextInt(10),datum[0],datum[1],datum[2]));
        }
        v.fuegeZiehungHinzu(new Ziehung(5,12,2022));
        for(int i = 0; i < 5000; i++){
            Ziehung z = v.gibAktuelleZiehung();
            if(z == null) break;
            int[] datum = z.gibDatum();
            Random rand = new Random();
            v.fuegeLottoscheinHinzu(new Lottoschein(rand.nextInt(10),datum[0],datum[1],datum[2]));
        }
        
        v.wasTueIch();
        v.wasTueIch2();
    }
}
