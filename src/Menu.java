import java.util.Scanner;


public class Menu {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		TesteArvoreBinaria abb = new TesteArvoreBinaria();
		int menu = 0;
		No raiz = null;
	
		do{
			System.out.println("1 = inserir um novo dado");
			System.out.println("2 = encontrar maior valor");
			System.out.println("3 = encontrar menor valor");
			System.out.println("4 = remover dado");
			System.out.println("5 = mostrar a arvore pelo percurso prefixo");
			System.out.println("6 = mostrar a arvore pelo percurso ordem simetrica");
			System.out.println("7 = mostrar a arvore pelo percurso sufixo");
			System.out.println("Digite a opção desejada: ");
			menu = teclado.nextInt();
			
			switch(menu){
				case 1:
					System.out.println("Digite um valor para ser inserido na arvore:");
					int v = teclado.nextInt();
					if(raiz == null){
					raiz = new No(v);
					}else{
						abb.inserir(raiz,v);
					}
					break;
				case 2:
					No maximo = abb.encontraMaximo(raiz);
					System.out.println(maximo.valor);
					break;
				case 3:
					No minimo = abb.encontraMinimo(raiz);
					System.out.println(minimo.valor);
					break;
				case 4:
					System.out.println("Digite um valor para ser excluido da arvore:");
					int e = teclado.nextInt();
					abb.Remover(raiz, e);
					break;
				case 5:
					abb.preOrdem(raiz);
					System.out.println(" ");
					break;
				case 6:
					abb.simOrdem(raiz);
					System.out.println(" ");
					break;
				case 7:
					abb.posOrdem(raiz);
					System.out.println(" ");
					break;
				default:
					System.out.println("valor invalido");
			}
		}while(menu!=0);
		teclado.close();
	}

}