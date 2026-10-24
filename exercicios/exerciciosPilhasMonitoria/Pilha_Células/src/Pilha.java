import java.util.NoSuchElementException;

public class Pilha<E> {

	private Celula<E> topo;
	private Celula<E> fundo;

	public Pilha() {

		Celula<E> sentinela = new Celula<E>();
		fundo = sentinela;
		topo = sentinela;

	}

	public boolean vazia() {
		return fundo == topo;
	}

	public void empilhar(E item) {

		topo = new Celula<E>(item, topo);
	}

	public E desempilhar() {

		E desempilhado = consultarTopo();
		topo = topo.getProximo();
		return desempilhado;
	}

	public E consultarTopo() {

		if (vazia()) {
			throw new NoSuchElementException("Nao há nenhum item na pilha!");
		}

		return topo.getItem();
	}

	/**	(non-Javadoc)
 * Retorna representação textual da pilha encadeada
 * @see java.lang.Object#toString()
 */
	@Override
	public String toString(){
	    Celula<E> c = topo;
		String resposta = "";
		while(c != fundo){
		    if(c == topo){
				resposta += String.format("[");
			}

			resposta += String.format(" %s ", c.getItem());
			

            if(c.getProximo() == fundo){
			    resposta += String.format("]");
			}else{
			    resposta += String.format(",");
			}
			c = c.getProximo();
			tamanho();
		}
		
		return resposta;
	}
	public int tamanho(){
	    Celula<E> c = topo;
		int tamanho = 0;
		while(c != fundo){
		    c = c.getProximo();
			tamanho++;
		}
		return tamanho;
	}

	public boolean contem(E item){
	    Celula<E> c = topo;
		boolean contem = false;
		while(c != fundo){
		    c = c.getProximo();
		    if(c.getItem().equals(item)){
				contem = true;
			}
		}
		return contem;
	}

	public int posicao(E item){
        Celula<E> c = topo;
        int indicie = 0;
        while(c != fundo){
            if(c.getItem().equals(item)){
                return indicie;
            }
            c.getProximo();
            indicie++;
        }
        return -1;
	}

	public Celula<E> consultarFundo(){
	    Celula<E> c = topo;
		while(c.getProximo() != fundo){
		    c = c.getProximo();
		}
		return c;
	}

	public Integer maior(){
	    Celula<Integer> c = topo;
	    Celula<Integer> maior = c;
		while(c != fundo){
			if(c.getItem() > maior.getItem()){
			    maior = c;
			}
			c = c.getProximo();
		}
		return maior.getItem();
	}

	public Integer menor(){
	    Celula<Integer> c = topo;
	    Celula<Integer> menor = c;
		while(c != fundo){
			if(c.getItem() < menor.getItem()){
			    menor = c;
			}
			c = c.getProximo();
		}
		return menor.getItem();
	}

	public Integer soma(){
	    Celula<Integer> c = topo;
		Integer somaTotal = 0;
		while(c != fundo){
		    somaTotal += c.getItem();
		    c = c.getProximo();
		}
		return somaTotal;
	}

	public Double media(){
	    Celula<Integer> c = topo;
		int cout = 0;
		while(c != fundo){
		    c = c.getProximo();
			cout++;
		}

		return soma()/(double) cout;
	}

    public void inserir(E[] elementos){
        for(int i = 0; i < elementos.length; i++){
            Celula<E> aux = new Celula<>(elementos[i]);
            if(consultarTopo() == null){
    			 topo = aux;
            }else{
    			 aux.setProximo(topo);
                topo = aux;
            }
        }   
    }

    public void imprimir(){
        Celula<E> c = topo;
        while(c != fundo){
            IO.println(c.toString());
            c = c.getProximo();
        }
    }

    public void imprimirDoInicio(){
        imprimirInicioRec(topo);
    }
    
    public void imprimirInicioRec(Celula c){
        if(c == fundo){
            return;
        }
        imprimirInicioRec(c.getProximo());
        IO.println(c.getItem());
    }

    public Pilha<E> inverterPilha(Pilha<E> pilhaRecebida){
        Pilha<E> pilhaAuxiliar = new Pilha<>();
        while(!vazia()){
            pilhaAuxiliar.empilhar(pilhaRecebida.desempilhar());
        }
        return pilhaAuxiliar;
    }

    public Pilha<E> inverter(){
        Celula<E> c = topo;
        Pilha<E> pilhaAux = new Pilha<E>();
        while(c != fundo){
            pilhaAux.empilhar(c.getItem());
            c = c.getProximo();
        }
        return pilhaAux;
    }

    public void concatenar(Pilha<E> pilha){
        Celula<E> c = pilha.topo;
        Pilha<E> pilhaAux = new Pilha<>();
        
        while(c != fundo){
            pilhaAux.empilhar(pilha.desempilhar());
            c = c.getProximo();
        }

        while(!pilhaAux.vazia()){
            empilhar(pilhaAux.desempilhar());
        }
    }

    //Questao 8
    public int obterNumeros(){
        Celula<E> c = topo;
        int count = 0;
        while(c != fundo){
            count++;
            c = c.getProximo();
        }
        return count;
    }

    //Questão 9
    public void inverter2(){
        Pilha<E> pilhaAux = new Pilha<>();
        Celula<E> c = topo;
        while(c != fundo){
            pilhaAux.empilhar(desempilhar());
            c = c.getProximo();
        }
        while(!pilhaAux.vazia()){
            empilhar(pilhaAux.desempilhar());
        }
    }
}


