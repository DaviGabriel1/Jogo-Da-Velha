import java.util.Scanner;

public class JogoDaVelha {
    private Scanner scan = new Scanner(System.in);
    private int turno;
    private Jogador jogador1;
    private Jogador jogador2;
    private boolean jogoTerminou;
    private boolean empate;
    private String tabuleiro[][] = {{".",".","."},{".",".","."},{".",".","."}};
    private int vez;

    public JogoDaVelha(){
        this.jogoTerminou=false;
        this.turno=9;
        this.empate=false;
        this.vez=0;
        menu();
    }

    private void menu() {
        System.out.println("-----JOGO DA VELHA-----\n");
        System.out.println("DIGITE O NOME DO JOGADOR 1: ");
        String nomeJogador1 = scan.nextLine();
        jogador1 = new Jogador(nomeJogador1,"X");
        System.out.println("DIGITE O NOME DO JOGADOR 2: ");
        String nomeJogador2 = scan.nextLine();
        jogador2 = new Jogador(nomeJogador2,"O");
        iniciarJogo();
    }

    private void iniciarJogo() {
        do{
            System.out.println("vez do "+jogador1.getNome());
            fazerJogada();
            vez++;
            mensagemFimDeJogo();
            if(jogoFinalizado()){
                break;
            }
            System.out.println("vez do "+jogador2.getNome());
            fazerJogada();
            turno--;
            mensagemFimDeJogo();
            vez++;
        }while(!jogoTerminou);
        boolean opcaoValida=false;
        int opcao;
        do{
        System.out.println("Deseja jogar novamente? [1]SIM [2]NÃO");
        opcao = scan.nextInt();
        if(opcao ==1 || opcao ==2){
            opcaoValida=true;
        }else {
            System.out.println("opcão invalida,tente novamente");
        }
        }while(!opcaoValida);
        switch (opcao){
            case 1:
                JogoDaVelha j = new JogoDaVelha();
            case 2:
                System.out.println("+desligando*");
                System.exit(0);
        }
    }

    private void mensagemFimDeJogo() {
        if(jogoFinalizado()){
            if (jogador1.isVenceu()){
                System.out.println("jogador "+jogador1.getNome()+" venceu!");
            }
            else if(jogador2.isVenceu()){
                System.out.println("jogador "+jogador2.getNome()+" venceu");
            }
            else{
                System.out.println("Fim de jogo, Empate!");
            }
        }
    }

    private void mostrarTabuleiro(){
        for(int i=0;i<=2;i++){
            for (int j=0;j<=2;j++){
                System.out.print(tabuleiro[i][j]);
            }
            System.out.println();
        }
    }
    private void fazerJogada(){
        boolean jogadaValida=false;
        do{
        System.out.println("Digite a linha da jogada: ");
        int linha = scan.nextInt();
        System.out.println("Digite a coluna da jogada: ");
        int coluna = scan.nextInt();
        if(tabuleiro[linha][coluna].equalsIgnoreCase(".") && linha<=2 && linha>=0 && coluna>=0 && coluna<=2) {
            if (vez % 2 == 0) {
                tabuleiro[linha][coluna] = jogador1.getSimbolo();
            } else {
                tabuleiro[linha][coluna] = jogador2.getSimbolo();
            }
            jogadaValida=true;
        }
        else{
            System.out.println("Jogada invalida, tente novamente");
        }}while(!jogadaValida);
        mostrarTabuleiro();

    }
    private boolean jogoFinalizado(){
        if(tabuleiro[0][0].equals(jogador1.getSimbolo()) && tabuleiro[0][1].equals(jogador1.getSimbolo()) && tabuleiro[0][2].equals(jogador1.getSimbolo()) || tabuleiro[0][0].equals(jogador1.getSimbolo()) && tabuleiro[1][1].equals(jogador1.getSimbolo()) && tabuleiro[2][2].equals(jogador1.getSimbolo()) || tabuleiro[1][0].equals(jogador1.getSimbolo()) && tabuleiro[1][1].equals(jogador1.getSimbolo()) && tabuleiro[1][2].equals(jogador1.getSimbolo()) || tabuleiro[2][0].equals(jogador1.getSimbolo()) && tabuleiro[2][1].equals(jogador1.getSimbolo()) && tabuleiro[2][2].equals(jogador1.getSimbolo()) || tabuleiro[0][2].equals(jogador1.getSimbolo()) && tabuleiro[1][1].equals(jogador1.getSimbolo()) && tabuleiro[2][0].equals(jogador1.getSimbolo())){
            this.jogoTerminou=true;
            jogador1.setVenceu(true);
            return true;
        }
        else if(tabuleiro[0][0].equals(jogador2.getSimbolo()) && tabuleiro[0][1].equals(jogador2.getSimbolo()) && tabuleiro[0][2].equals(jogador2.getSimbolo()) || tabuleiro[0][0].equals(jogador2.getSimbolo()) && tabuleiro[1][1].equals(jogador2.getSimbolo()) && tabuleiro[2][2].equals(jogador2.getSimbolo()) || tabuleiro[1][0].equals(jogador2.getSimbolo()) && tabuleiro[1][1].equals(jogador2.getSimbolo()) && tabuleiro[1][2].equals(jogador2.getSimbolo()) || tabuleiro[2][0].equals(jogador2.getSimbolo()) && tabuleiro[2][1].equals(jogador2.getSimbolo()) && tabuleiro[2][2].equals(jogador2.getSimbolo()) || tabuleiro[0][2].equals(jogador2.getSimbolo()) && tabuleiro[1][1].equals(jogador2.getSimbolo()) && tabuleiro[2][0].equals(jogador2.getSimbolo())){
            this.jogoTerminou=true;
            jogador2.setVenceu(true);
            return true;
        }
        else if(turno ==0){
            this.jogoTerminou=true;
            this.empate = true;
            return true;
        }
        else{
            return false;
        }
    }
}