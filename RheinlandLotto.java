public class RheinlandLotto{
    private List<Lottoschein> lottoscheine;
    private Stack<Ziehung> ziehungen;
    
    
    public RheinlandLotto(){
        lottoscheine = new List<Lottoschein>();
        ziehungen = new Stack<Ziehung>();
    }

    public Ziehung gibAktuelleZiehung(){
        return !ziehungen.isEmpty() ? ziehungen.top() : null;
    }
    public void fuegeLottoscheinHinzu(Lottoschein pLottoschein){
        lottoscheine.append(pLottoschein);
    }
    
    public void fuegeZiehungHinzu(Ziehung pZiehung){
        ziehungen.push(pZiehung);
    }
    
    public void ermittleGewinner(){
        if(ziehungen.isEmpty()) return;
        Ziehung aktZiehung = ziehungen.top();
        int[] aktDatum = aktZiehung.gibDatum();
        System.out.println("Ziehung am " + aktDatum[0] + "." + aktDatum[1] + "." + aktDatum[2]+":");

        int[] zahlen = aktZiehung.gibZiehung();

        for(int i = 0; i < zahlen.length; i++){
            System.out.print(zahlen[i] + " ");
        }
        System.out.println();
        for(int i = 6; i > 3; i--){
            System.out.println("Preisklasse " + i + " richtige:");
            List<Lottoschein> gewinnerListe = gibNRichtige(i);
            gibGewinnerAus(gewinnerListe);
        }
    }
    
    public void wasTueIch(){
        if(ziehungen.isEmpty()){
            return;
        }
        else{
            Ziehung temp = ziehungen.top();
            ermittleGewinner();
            ziehungen.pop();
            wasTueIch();
            System.out.println();
            ziehungen.push(temp);
        }
    }
    
    public void wasTueIch2(){
        if(ziehungen.isEmpty()){
            return;
        }
        else{
            Ziehung temp = ziehungen.top();
            System.out.print(temp);
            ziehungen.pop();
            System.out.println();
            wasTueIch2();
            ziehungen.push(temp);
        }
    }
    
    private void gibGewinnerAus(List<Lottoschein> pLottoscheine){
        for(pLottoscheine.toFirst(); pLottoscheine.hasAccess(); pLottoscheine.next()){
            Lottoschein aktLottoschein = pLottoscheine.getContent();
            System.out.println(aktLottoschein);
        }
    }
    
    public List<Lottoschein> gibNRichtige(int pN){
        if(ziehungen.isEmpty()) return null;
        
        Ziehung aktZiehung = ziehungen.top();
        List<Lottoschein> ret = new List<Lottoschein>();
        for(lottoscheine.toFirst(); lottoscheine.hasAccess(); lottoscheine.next()){
            Lottoschein aktLottoschein = lottoscheine.getContent();
            int aktAnzahlReihen = aktLottoschein.gibAnzahlReihen();
            for(int i = 0; i < aktAnzahlReihen; i++){
                int[] datum1 = aktLottoschein.gibDatum();
                int[] datum2 = aktZiehung.gibDatum();
                if(datum1[0]==datum2[0] && datum1[1]==datum2[1] && datum1[2]==datum2[2]){
                    if(hatNRichtige(pN, aktLottoschein.gibReihe(i), aktZiehung.gibZiehung())){
                        ret.append(aktLottoschein);    
                        break;
                    }    
                }
            }
        }
        return ret;
    }
    
    private boolean hatNRichtige(int pN, int[] pA, int[] pB){
        int anzahl = 0;
        
        for(int i = 0; i < pA.length; i++){
            for(int j = 0; j < pB.length; j++){
                if(pA[i] == pB[j]){
                    anzahl++;
                }
            }
        }
        return (anzahl == pN);
    }
}
