package it.iisvittorioveneto.itt.takeauto;

public class Lista {
    private Nodo testa;

    public Lista(){
        this.testa=null;
    }

    public Lista(Nodo n){
        this.testa=n;

    }

    public void inNodoCoda(Nodo n){
        Nodo indice=this.testa;
        if(this.testa==null){
            this.testa=n;
        }else{
            while(indice.getSuccessivo()!=null){
                indice=indice.getSuccessivo();
            }
            indice.setSuccessivo(n);
        }
    }

    public void inNodoTesta(Nodo n){
        n.setSuccessivo(this.testa);
        this.testa=n;
    }


    public User getElemento(int pos) {
        Nodo indice = this.testa;
        for (int i = 1; i < pos; i++) {
            indice = indice.getSuccessivo();
        }
        return indice.getDato();
    }

    public void cancNodoCoda(){
        Nodo indice=this.testa;
        Nodo i2=this.testa;
        int i=1;
        while(indice.getSuccessivo()!=null){
            indice=indice.getSuccessivo();
            i++;
        }
        i--;
        for(int j=1;j<i;j++){
            i2=i2.getSuccessivo();
        }
        i2.setSuccessivo(null);
    }

    public void cancNodoTesta(){
        Nodo indice=this.testa;
        Nodo i2=this.testa;
        indice=indice.getSuccessivo();
        this.testa=indice;
        i2.setSuccessivo(null);
    }

    public void cancNodoPos(int pos){
        Nodo indice=this.testa;
        Nodo i2=this.testa;
        for(int i=1;i<pos;i++){
            indice=indice.getSuccessivo();
        }
        for(int i=1;i<pos-1;i++){
            i2=i2.getSuccessivo();
        }
        i2.setSuccessivo(indice.getSuccessivo());
        indice.setSuccessivo(null);
    }

    public void eliminaLista(){
        this.testa=null;
    }


    public int getNumElementi(){
        int i=1;
        Nodo indice=this.testa;
        if(this.testa==null){
            i=0;
        }else{
            while(indice.getSuccessivo()!=null){
                indice=indice.getSuccessivo();
                i++;
            }
        }
        return i;
    }
}
