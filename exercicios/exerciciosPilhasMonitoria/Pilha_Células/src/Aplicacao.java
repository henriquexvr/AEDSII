public class Aplicacao {

    public static void main(String[] args) {

        Pilha<Carta> minhaPilha = new Pilha<Carta>();

        Carta item;
        Carta desempilhado;

        // Empilhando cartas
        item = new Carta("COPAS", "AS");
        minhaPilha.empilhar(item);

        item = new Carta("ESPADAS", "DEZ");
        minhaPilha.empilhar(item);

        item = new Carta("OUROS", "NOVE");
        minhaPilha.empilhar(item);

        // Mostra a pilha antes de remover
        System.out.println("Pilha antes de desempilhar:");
        System.out.println(minhaPilha);

        // Remove o item do topo: OUROS, NOVE
        desempilhado = minhaPilha.desempilhar();

        System.out.println(
            "Item desempilhado: "
            + desempilhado.getNaipe()
            + ", "
            + desempilhado.getValor()
        );

        // Consulta o novo topo sem removê-lo: ESPADAS, DEZ
        item = minhaPilha.consultarTopo();

        System.out.println(
            "Item do topo: "
            + item.getNaipe()
            + ", "
            + item.getValor()
        );

        // Mostra a pilha final
        System.out.println("\nExercicio 01\nPilha após desempilhar:");
        System.out.println(minhaPilha.toString());
        System.out.println("Tamanho da pilha: ");
        System.out.println(minhaPilha.tamanho());
    }
}