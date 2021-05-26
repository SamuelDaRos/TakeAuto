package it.iisvittorioveneto.itt.takeauto;

public class Nodo {
    private User dato;
    private Nodo successivo;

    public Nodo(User dato, Nodo n){
        this.dato=dato;
        this.successivo=n;
    }

    public Nodo(User dato){
        this.dato=dato;
    }

    public void setSuccessivo(Nodo n){
        this.successivo=n;
    }

    public void setDato(User dato){
        this.dato=dato;
    }

    public User getDato() {
        return dato;
    }

    public Nodo getSuccessivo() {
        return successivo;
    }

    @Override
    public String toString() {
        return "Nodo{" + "dato=" + dato + ", successivo=" + successivo + '}';
    }


}