import java.util.Scanner;

public class Biblioteca {
    public static String[] livros = new String[30];
    public static int totalLivros = 0;
    public static String reset = "\u001B[0m";
    public static String vermelho = "\u001B[31m";
    public static String verde = "\u001B[32m";
    public static String negrito = "\u001B[1m";
    public static String azul = "\u001B[34m";
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n----------------------\n1. Adicionar Livro" + "\n2. Listar Livros" + "\n3. Remover Livro" + "\n4. Sair\n-----------------------");
            System.out.print(negrito + "Escolha uma opção: " + reset);
            opcao = leitor.nextInt();
            leitor.nextLine();
        
            switch (opcao) {
                case 1:
                    adicionarLivro(leitor);
                    break;
                case 2 :
                    listaLivros();
                    break;
                case 3 :
                   removerLivro(leitor);
                    break;
                case 4 :
                    System.out.println(azul + negrito + "\nSaindo do sistema..." + reset);
                    break;
            
                default:
                    System.out.println(vermelho + negrito + "Opção inválida!" + reset);
                    break;
            } 
        } while (opcao != 4);
        leitor.close();
    }

    private static void adicionarLivro(Scanner leitor) {
        System.out.print(negrito + "\nDigite o nome do livro: " + reset);
        livros[totalLivros] = leitor.nextLine();
        totalLivros++;
        System.out.println(verde + negrito + "\nLivro adicionado com sucesso!\n" + reset);
    }
    private static void listaLivros(){
        if (totalLivros == 0) {
            System.out.println(vermelho + negrito + "\nNenhum livro cadastrado.\n" + reset);
            return;
        }
        System.out.println(azul + negrito +"\nLivros na Biblioteca:" + reset);
        for (int i = 0; i < totalLivros; i++) {
            System.out.println(azul + negrito +(i + 1) + ". " + livros[i] + reset);
        }
    }
    private static void removerLivro(Scanner leitor){
        System.out.println(negrito + "\nQual livro você quer remover? " + reset);
        String livroRemover = leitor.nextLine();
        int indiceRemover = -1;

        if (totalLivros == 0) {
            System.out.println(vermelho + negrito +"\nNenhum livro para remover.\n" + reset);
            return;
        }
        
        for (int i = 0; i < totalLivros; i++) {
            if (livros[i].equalsIgnoreCase(livroRemover)) { 
                indiceRemover = i;
                break;
            }
        }

        if (indiceRemover == -1) {
            System.out.println(vermelho + negrito + "\nLivro não encontrado!" + reset);
        } else {
            for (int i = indiceRemover; i < totalLivros - 1; i++) {
                livros[i] = livros[i + 1];
            }
            livros[totalLivros - 1] = null;
            totalLivros--;
            System.out.println(verde + negrito + "\nLivro removido com sucesso!" + reset);
        }

    }

}