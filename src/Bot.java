import java.util.Random;
import java.util.Scanner;
public class Bot {
    private String simbolo;
    private String nome;
    private boolean venceu;
    private Random r = new Random();
    public Bot() {
        this.simbolo = "O";
        this.nome = "Bot";
        this.venceu=false;
    }
    public int gerarJogada(){
        return r.nextInt(3);
    }

    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isVenceu() {
        return venceu;
    }

    public void setVenceu(boolean venceu) {
        this.venceu = venceu;
    }
}
