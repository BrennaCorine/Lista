
package listamusica;

class Musica {
    
    private String titulo;
    private Musica proximo;
    private Musica anterior;

    public Musica getProximo() {
        return proximo;
    }

    public void setProximo(Musica proximo) {
        this.proximo = proximo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Musica getAnterior() {
        return anterior;
    }

    public void setAnterior(Musica anterior) {
        this.anterior = anterior;
    }
    
    
}
