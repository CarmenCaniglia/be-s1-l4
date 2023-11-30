import Es1.Dipartimento;
import Es1.Dipendente;
import Es1.Livello;

public class Main {
    public static void main(String[] args) {
        //creo dipendente
        Dipendente dipendente1 = new Dipendente("1234", Dipartimento.PRODUZIONE);
        System.out.println("Primo dipendente: ");
        dipendente1.stampaDatiDipendente();

        //calcolo paga mensile
        double paga1 = Dipendente.calcolaPaga(dipendente1);
        System.out.println("Stipendio mensile: "+ paga1);

        //stipendio con straordinario
        double pagaStraordinario = Dipendente.calcolaPaga(dipendente1, 10);
        System.out.println("Stipendio mensile con ore extra: " + pagaStraordinario);

        //promozione
        System.out.println("----Promozione del dipendente:----");
        Livello nuovoLivello = dipendente1.promozione();
        System.out.println("Promosso a: "+nuovoLivello);
        dipendente1.stampaDatiDipendente();
        double pagaConStraordinario= Dipendente.calcolaPaga(dipendente1, 10);
        System.out.println("nuova paga" + pagaConStraordinario);


    }
}