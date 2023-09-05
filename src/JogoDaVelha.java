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
    private Bot robo;
    private boolean modoBot;
    private boolean modo2Players;

    public JogoDaVelha(){
        this.jogoTerminou=false;
        this.turno=9;
        this.empate=false;
        this.vez=0;
        this.modoBot=false;
        this.modo2Players=false;
        menu();
    }

    private void menu() {
        System.out.println("-----JOGO DA VELHA-----\n");
        System.out.println("MODO DE JOGO: [1]BOT [2]PLAYER");
        int opcao = scan.nextInt();
        scan.nextLine();
        if(opcao == 1){
            robo = new Bot();
            modoBot=true;
        }
        else if(opcao == 2){
            modo2Players=true;
        }
        //todo controle de entrada
        System.out.println("DIGITE O NOME DO JOGADOR 1: ");
        String nomeJogador1 = scan.nextLine();
        jogador1 = new Jogador(nomeJogador1,"X");
        if(modo2Players) {
            System.out.println("DIGITE O NOME DO JOGADOR 2: ");
            String nomeJogador2 = scan.nextLine();
            jogador2 = new Jogador(nomeJogador2, "O");
        }
        iniciarJogo();
    }

    private void iniciarJogo() {
        do{
            System.out.println("vez do "+jogador1.getNome());
            fazerJogada();
            if(modo2Players) {
                vez++;
            }
            mensagemFimDeJogo();
            if(jogoFinalizado()){
                break;
            }
            if(modo2Players) {
                System.out.println("vez do " + jogador2.getNome());
                fazerJogada();
            }
            else if (modoBot) {
                System.out.println("vez do "+ robo.getNome());
                fazerJogadaBot();
            }
            turno--;
            mensagemFimDeJogo();
            if(modo2Players) {
                vez++;
            }
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
            else if(robo.isVenceu()){
                System.out.println("Bot venceu!");
            }
            else{
                System.out.println("Fim de jogo, Empate!");
            }
        }
    }

    private void mostrarTabuleiro(){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(tabuleiro[i][j]);
                if (j < 2) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
            if (i < 2) {
                System.out.println("---------");
            }
        }
    }
    private void fazerJogada(){
        boolean jogadaValida=false;
        boolean coordenadasValida=false;
        int linha;
        int coluna;
        do{
            do {
                System.out.println("Digite a linha da jogada: ");
                linha = scan.nextInt();
                System.out.println("Digite a coluna da jogada: ");
                coluna = scan.nextInt();
                if(linha<3 && coluna <3 && coluna>=0 && linha>=0){
                    coordenadasValida=true;
                }
                else{
                    System.out.println("coordenada invalida, tente novamente");
                }
            }while(!coordenadasValida);
            if(tabuleiro[linha][coluna].equalsIgnoreCase(".")) {
                if (vez % 2 == 0 ) {
                    tabuleiro[linha][coluna] = jogador1.getSimbolo();
                } else if(modo2Players){
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
        if(tabuleiro[0][0].equals(jogador1.getSimbolo()) && tabuleiro[0][1].equals(jogador1.getSimbolo()) && tabuleiro[0][2].equals(jogador1.getSimbolo()) ||
                tabuleiro[0][0].equals(jogador1.getSimbolo()) && tabuleiro[1][1].equals(jogador1.getSimbolo()) && tabuleiro[2][2].equals(jogador1.getSimbolo()) ||
                tabuleiro[1][0].equals(jogador1.getSimbolo()) && tabuleiro[1][1].equals(jogador1.getSimbolo()) && tabuleiro[1][2].equals(jogador1.getSimbolo()) ||
                tabuleiro[2][0].equals(jogador1.getSimbolo()) && tabuleiro[2][1].equals(jogador1.getSimbolo()) && tabuleiro[2][2].equals(jogador1.getSimbolo()) ||
                tabuleiro[0][2].equals(jogador1.getSimbolo()) && tabuleiro[1][1].equals(jogador1.getSimbolo()) && tabuleiro[2][0].equals(jogador1.getSimbolo())){
            this.jogoTerminou=true;
            jogador1.setVenceu(true);
            return true;
        }if(modo2Players){
            if(tabuleiro[0][0].equals(jogador2.getSimbolo()) && tabuleiro[0][1].equals(jogador2.getSimbolo()) && tabuleiro[0][2].equals(jogador2.getSimbolo()) ||
                    tabuleiro[0][0].equals(jogador2.getSimbolo()) && tabuleiro[1][1].equals(jogador2.getSimbolo()) && tabuleiro[2][2].equals(jogador2.getSimbolo()) ||
                    tabuleiro[1][0].equals(jogador2.getSimbolo()) && tabuleiro[1][1].equals(jogador2.getSimbolo()) && tabuleiro[1][2].equals(jogador2.getSimbolo()) ||
                    tabuleiro[2][0].equals(jogador2.getSimbolo()) && tabuleiro[2][1].equals(jogador2.getSimbolo()) && tabuleiro[2][2].equals(jogador2.getSimbolo()) ||
                    tabuleiro[0][2].equals(jogador2.getSimbolo()) && tabuleiro[1][1].equals(jogador2.getSimbolo()) && tabuleiro[2][0].equals(jogador2.getSimbolo())){
                this.jogoTerminou=true;
                jogador2.setVenceu(true);
                return true;
            }}
        else{
            if(tabuleiro[0][0].equals(robo.getSimbolo()) && tabuleiro[0][1].equals(robo.getSimbolo()) && tabuleiro[0][2].equals(robo.getSimbolo()) ||
                    tabuleiro[0][0].equals(robo.getSimbolo()) && tabuleiro[1][1].equals(robo.getSimbolo()) && tabuleiro[2][2].equals(robo.getSimbolo()) ||
                    tabuleiro[1][0].equals(robo.getSimbolo()) && tabuleiro[1][1].equals(robo.getSimbolo()) && tabuleiro[1][2].equals(robo.getSimbolo()) ||
                    tabuleiro[2][0].equals(robo.getSimbolo()) && tabuleiro[2][1].equals(robo.getSimbolo()) && tabuleiro[2][2].equals(robo.getSimbolo()) ||
                    tabuleiro[0][2].equals(robo.getSimbolo()) && tabuleiro[1][1].equals(robo.getSimbolo()) && tabuleiro[2][0].equals(robo.getSimbolo())){
                robo.setVenceu(true);
                return true;
            }}
        if(turno ==0){
            this.jogoTerminou=true;
            this.empate = true;
            return true;
        }
        else{
            return false;
        }
    }
    private void fazerJogadaBot(){
        int linha;
        int coluna;
        boolean jogadaValida=false;
        int i=0;
        do {
            linha = robo.gerarJogada();
            coluna = robo.gerarJogada();
            if(i==0){
                if (!tabuleiro[0][0].equals(".") && !tabuleiro[0][1].equals(".") ){
                    linha=0;
                    coluna=2;
                }
                else if(tabuleiro[0][0].equals(jogador1.getSimbolo()) && tabuleiro[1][0].equals(jogador1.getSimbolo()) && !tabuleiro[2][0].equals(jogador1.getSimbolo())){
                    linha=2;
                    coluna=0;
                }
                else if(tabuleiro[1][0].equals(jogador1.getSimbolo()) && tabuleiro[1][1].equals(jogador1.getSimbolo()) && !tabuleiro[1][2].equals(jogador1.getSimbolo())){
                    linha=1;
                    coluna=2;
                }
                else if(tabuleiro[0][0].equals(jogador1.getSimbolo()) && tabuleiro[1][1].equals(jogador1.getSimbolo()) && !tabuleiro[2][2].equals(jogador1.getSimbolo())){
                    linha=2;
                    coluna=2;
                }
                else if(tabuleiro[2][0].equals(jogador1.getSimbolo()) && tabuleiro[2][1].equals(jogador1.getSimbolo()) && !tabuleiro[2][2].equals(jogador1.getSimbolo())){
                    linha=2;
                    coluna=2;
                }
                else if( tabuleiro[0][2].equals(jogador1.getSimbolo()) && tabuleiro[1][1].equals(jogador1.getSimbolo()) && !tabuleiro[2][0].equals(jogador1.getSimbolo())){
                    linha=2;
                    coluna=0;
                }
                i++;
            }else {
                linha = robo.gerarJogada();
                coluna = robo.gerarJogada();
            }
            if (tabuleiro[linha][coluna].equalsIgnoreCase(".")) {
                tabuleiro[linha][coluna] = robo.getSimbolo();
                jogadaValida=true;
            }
        }while(!jogadaValida);
        mostrarTabuleiro();
    }




}
