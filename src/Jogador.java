public class Jogador {
    private String nome;
    private String simbolo;
    private boolean venceu;

    public Jogador(String nome, String simbolo) {
        this.nome = nome;
        this.simbolo = simbolo;
        this.venceu=false;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    public boolean isVenceu() {
        return venceu;
    }

    public void setVenceu(boolean venceu) {
        this.venceu = venceu;
    }
}
