package Es1;

public class Dipendente {
    //ATTRIBUTI
    public double stipendioBase = 1000;
    private String matricola;
    private double stipendio;
    private double importoOrarioStraordinario;
    private Livello livello;
    private Dipartimento dipartimento;

    //COSTRUTTORI
    public Dipendente(String matricola, Dipartimento dipartimento) {
        this.matricola = matricola;
        this.dipartimento = dipartimento;
        this.stipendio = stipendioBase;
        this.importoOrarioStraordinario  = 30;
        this.livello = Livello.OPERAIO;
    }

    public Dipendente(double stipendioBase, String matricola, double stipendio, double importoOrarioStraordinario, Livello livello, Dipartimento dipartimento) {
        this.stipendioBase = stipendioBase;
        this.matricola = matricola;
        this.stipendio = stipendioBase;
        this.importoOrarioStraordinario = importoOrarioStraordinario;
        this.livello = livello;
        this.dipartimento = dipartimento;
    }

    //METODI GETTER

    public double getStipendioBase() {
        return stipendioBase;
    }

    public String getMatricola() {
        return matricola;
    }

    public double getStipendio() {
        return stipendio;
    }

    public double getImportoOrarioStraordinario() {
        return importoOrarioStraordinario;
    }

    public Livello getLivello() {
        return livello;
    }

    public Dipartimento getDipartimento() {
        return dipartimento;
    }

    //METODI SETTER

    public void setImportoOrarioStraordinario(double importoOrarioStraordinario) {
        this.importoOrarioStraordinario = importoOrarioStraordinario;
    }

    public void setDipartimento(Dipartimento dipartimento) {
        this.dipartimento = dipartimento;
    }

    //ALTRI METODI

   public void stampaDatiDipendente(){
       System.out.println("----DATI DIPENDENTE----");
       System.out.println("Matricola: " + matricola);
       System.out.println("Livello: " + livello);
       System.out.println("Stipendio: "+ stipendio);
       System.out.println("Importo orario straordinario: "+importoOrarioStraordinario);
       System.out.println("Dipartimento: "+dipartimento);
   }

    public Livello promozione(){
        switch (this.livello){
            case OPERAIO -> {
                this.livello = Livello.IMPIEGATO;
                this.stipendio = stipendioBase * 1.2;
                break;
            }
            case IMPIEGATO -> {
                this.livello = Livello.QUADRO;
                this.stipendio= stipendioBase * 1.5;
                break;
            }
            case QUADRO -> {
                this.livello = Livello.DIRIGENTE;
                this.stipendio = stipendioBase * 2;
                break;
            }
            case DIRIGENTE -> {
                System.out.println("Errore: il dipendente è già a livello DIRIGENTE.");
                break;
            }
        }
        return this.livello;
    }
    public static double calcolaPaga(Dipendente dipendente){
        return dipendente.getStipendio();
    } //calcolo solo lo stipendio mensile

    public static double calcolaPaga(Dipendente dipendente, int oreStraordinario){
        double pagaStraordinario = oreStraordinario * dipendente.getImportoOrarioStraordinario();
        return dipendente.getStipendio() + pagaStraordinario;
    } //moltiplico le ore straordinario per l'importo orario dello straordinario (getImportoOrarioStraordinario()), e sommo il valore a quello dello stipendio mensile

}
