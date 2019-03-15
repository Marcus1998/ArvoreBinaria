public class TesteArvoreBinaria {  
   
  
  
    public void inserir(No node, int valor) {  
       
    	if (valor < node.valor) {  
            if (node.esquerda != null) {  
                inserir(node.esquerda, valor);  
            } else {  
                System.out.println("  Inserindo " + valor + " a esquerda de " + node.valor);  
                No novo = new No(valor);
                node.esquerda = novo;
                novo.pai = node; 
            }  
        } else{ 
        	if (valor > node.valor) {  
	            if (node.direita != null) {  
	                inserir(node.direita, valor);  
	            } else {  
	                System.out.println("  Inserindo " + valor + " a direita de " + node.valor);  
	                No novo = new No(valor);
	                node.direita = novo;
	                novo.pai = node;
	            }  
        	}
       }
    }  

    public void Remover(No Node,int elemento)
    {
        if (Node == null)
        System.out.println("Elemento não encontrado !");
     else if (elemento == (Node).valor)
        removerNo(Node);
     else if (elemento < (Node).valor)
     Remover((Node).esquerda,elemento);
     else 
        Remover(((Node).direita),elemento);
    }
    
    public No removeMinimo(No node) {  
        if (node == null) {  
            System.out.println("  ERRO ");  
        } else if (node.esquerda != null) {  
            node.esquerda = removeMinimo(node.esquerda);  
            return node;  
        } else {  
            return node.direita;  
        }  
        return null;  
    }  
  
    public No encontraMinimo(No node) {  
        if (node != null) {  
            while (node.esquerda != null) {  
                node = node.esquerda;  
            }  
        }  
        return node;  
    }
    
    public No encontraMaximo(No node) {  
        if (node != null) {  
            while (node.direita != null) {  
                node = node.direita;  
            }  
        }  
        return node;  
    }
    //Metodo para percorrer  em pos-ordem usando Recursao
    public void posOrdem (No node){
        if (node != null){
           System.out.print("("); 
           posOrdem(node.esquerda);
           posOrdem(node.direita);
           System.out.print(node.valor+")");
        }
    }
    
   // Metodo para percorrer  em pre-ordem usando Recursao
    public void preOrdem (No node){
        if (node != null){
           System.out.print("("+node.valor); 
           preOrdem(node.esquerda);
           preOrdem(node.direita);
           System.out.print(")");
        }
    }
    
    // Metodo para percorrer  em ordem simetrica usando Recursao
    public void simOrdem (No node){
        if (node != null){
           System.out.print("("); 
           simOrdem(node.esquerda);
           System.out.print(node.valor);
           simOrdem(node.direita);
           System.out.print(")");
        }
    }
    
    
    public No menor ( No node) {
        No aux = node;
     if (aux.esquerda == null)
     {
        node = (node).direita;
        return aux;
     }else
        return menor(((node).esquerda));
    }
    
    public void removerNo(No node) {
        No filho;
        No pai = node.pai;
        if (node.esquerda == null && node.direita == null) {
        	
            // Não tem ambos os filhos 
        	if(pai.direita == node){
        		pai.direita = null;
        	}else{
        		pai.esquerda = null;
        	}
        } else{ 
        	if (node.esquerda == null) {
	            // Não tem filho a esquerda 
	        	filho = node.direita;
	        	pai.esquerda = filho;
	        	filho.pai = pai;
	        	node.pai = null;
        	} else{
	        	if (node.direita == null) {
		            // Não tem filho a direita 
		        	filho = node.esquerda;
		        	pai.direita = filho;
		        	filho.pai = pai;
		        	node.pai = null;
	        	} else { // Tem ambos os filhos 
		           if(pai.direita == node){
		        		filho = node.esquerda;
			            No filhoD = node.direita;
			            filho.esquerda = filhoD;
			            node = filho;
			            pai.direita = node;
		           }else{
		        	   if(pai.esquerda == node){
		        		   filho = node.esquerda;
				            No filhoD = node.direita;
				            filho.esquerda = filhoD;
				            node = filho;
				            pai.esquerda = node;
		        	   }
		           }
		        }
	        }
        }
    }
}