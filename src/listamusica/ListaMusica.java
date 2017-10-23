package listamusica;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ListaMusica {

    private static Musica inicio;
    private static Musica termino;

    public static void main(String[] args) {
        Musica novo;
        Musica atual;
        int opcao;
        do {
            System.out.println("");
            System.out.println("Informe o opção que deseja realizar: ");
            System.out.println("1 - Incluir um objeto no início na lista");
            System.out.println("2 - Incluir um objeto no final da lista");
            System.out.println("3 - Incluir um objeto em um ponto qualquer entre o primeiro e o último.");
            System.out.println("4 - Verificar se um objeto específico está na lista");
            System.out.println("5 - Remover um objeto específico da lista");
            System.out.println("6 - Remover o primeiro objeto da lista");
            System.out.println("7 - Remover o último objeto da lista");
            System.out.println("8 - Mostrar todos os objetos da lista na ordem do primeiro para o último");
            System.out.println("9 - Mostrar todos os objetos da lista na ordem do último para o primeiro");
            System.out.println("10 - Sair");
            System.out.println("");

            opcao = pedeOpcao();

            switch (opcao) {
                case 1:
                    novo = pedeMusica();
                    if (inicio == null) {
                        inicio = novo;
                        termino = novo;
                        inicio.setProximo(novo);
                        termino.setAnterior(inicio);
                        inicio.setAnterior(null);
                        termino.setProximo(null);
                    } else {
                        inicio.setAnterior(novo);
                        novo.setProximo(inicio);
                        novo.setAnterior(null);
                        inicio = novo;

                    }
                    break;
                case 2:
                    if (inicio == null) {
                        System.out.println("Lista vazia");
                    } else {
                        novo = pedeMusica();
                        termino.setProximo(novo);
                        novo.setAnterior(termino);
                        termino = novo;
                        termino.setProximo(null);
                    }
                    break;
                case 3:
                    if (inicio == null) {
                        System.out.println("Lista vazia");
                    } else {
                        if (inicio == termino) {
                            Musica m = new Musica();
                            m = pedeMusica();
                            inicio.setProximo(m);
                            m.setAnterior(inicio);
                            m.setProximo(null);
                            termino = m;
                        } else {
                            Musica m = new Musica();
                            m = pedeMusica();
                            m.setAnterior(inicio);
                            m.setProximo(inicio.getProximo());
                            inicio.setProximo(m);
                        }
                    }
                    break;
                case 4:
                    if (inicio == null) {
                        System.out.println("Lista vazia");
                    } else {
                        Musica busca = pedeMusica();
                        atual = inicio;
                        boolean achei = false;
                        while (atual != null) {
                            if (atual.getTitulo().equals(busca.getTitulo())) {
                                achei = true;
                                break;
                            }
                            atual = atual.getProximo();
                        }
                        if (achei) {
                            System.out.println("música encontrada na lista");
                        } else {
                            System.out.println("música não encontrada na lista");
                        }
                    }
                    break;

                case 5:
                    if (inicio == null) {
                        System.out.println("Lista vazia");
                    } else {
                        if (inicio == termino) {
                            inicio = null;
                            termino = null;
                        } else {
                            atual = inicio;
                            Musica m = new Musica();
                            m = pedeMusica();
                            Musica aux;
                            while (atual != null){
                                if (m.getTitulo().equals(atual.getTitulo())){
                                    aux = atual.getAnterior();
                                    aux.setProximo(atual.getProximo());
                                    atual.setAnterior(atual.getAnterior());
                                    break;
                                   
                                }
                               atual = atual.getProximo();
                            }
                        }
                    }
                    break;
                case 6:
                    if (inicio == null) {
                        System.out.println("Lista vazia");
                    } else {

                        if (inicio == termino) {
                            inicio = null;
                            termino = null;
                        } else {
                            inicio = inicio.getProximo();
                            inicio.setAnterior(null);
                        }
                    }

                    break;
                case 7:
                    if (inicio == null) {
                        System.out.println("Lista vazia");
                    } else {

                        if (inicio == termino) {
                            inicio = null;
                            termino = null;
                        } else {
                            termino = termino.getAnterior();
                            termino.setProximo(null);

                        }
                        break;

                    }
                case 8:
                    if (inicio == null) {
                        System.out.println("Lista vazia");
                    } else {
                        atual = inicio;
                        while (atual != null) {
                            System.out.println(atual.getTitulo());
                            atual = atual.getProximo();

                        }
                    }
                    break;
                case 9:
                    if (inicio == null) {
                        System.out.println("Lista vazia");
                    } else {
                        atual = termino;
                        while (atual != null) {
                            System.out.println(atual.getTitulo());
                            atual = atual.getAnterior();
                        }
                    }
                    break;

            }

        } while (opcao != 10);

    }

    private static int pedeOpcao() {
        Scanner leia = new Scanner(System.in);
        int opcao = 0;
        try {
            opcao = leia.nextInt();
            if (opcao < 1 || opcao > 10) {
                System.out.println("Opção inválida.");
            }

        } catch (InputMismatchException e) {
            System.out.println("Opção inválida.");
        }
        return opcao;
    }

    private static Musica pedeMusica() {
        Scanner leia = new Scanner(System.in);
        Musica musica = new Musica();
        musica.setProximo(inicio);
        do {
            System.out.println("Informe o nome da música: ");
            musica.setTitulo(leia.nextLine());
            if (musica.getTitulo().equals("")) {
                System.out.println("Nome inválido.");
            }
        } while (musica.getTitulo().equals(""));

        return musica;
    }

}
