package Estruturas;
import java.util.Scanner;

class filaComArray {
	
	private static int head;
	private static int tail;
	private static int[] fila;
	
	public static void main(String[] args) {
		Scanner leitura = new Scanner(System.in);
		
		int tamanho = Integer.parseInt(leitura.nextLine());
		iniciaFila(tamanho);
		
		String operacoes = leitura.nextLine();
		while(!(operacoes.equals("end"))){
			if(operacoes.equals("element")) {
				System.out.println(peek());
			} else if(operacoes.equals("print")) {
				System.out.println(print());
			} else if(operacoes.equals("remove")) {
				remove();
			} else {
				String[] entrada = operacoes.split(" ");
				adiciona(Integer.parseInt(entrada[1]));
			}
			operacoes = leitura.nextLine();
		}
	}
	
	public static void iniciaFila(int tamanho) {
		head = -1;
		tail = -1;
		fila = new int[tamanho];
	}
	
	public static boolean isEmpty() {
		if(head == -1 && tail ==-1) {
			return true;
		}
		return false;
	}
	public static boolean isFull() {
		if(((tail+1) % fila.length) == head){
			return true;
		}
		return false;
	}
	
	public static void adiciona(int element) {
			if(isEmpty()) {
				head++;
				tail++;
				fila[tail] = element;
			} else {
				if(isFull()) {
					System.out.println("full");		
				}else {
					tail = (tail+1) % fila.length;
					fila[tail] = element;
				}
			}	
	}
	
	public static int peek() {
		return fila[head];
	}
	
	public static void remove() {
		if(isEmpty()) {
			System.out.println("empty");
		} else {
			if(head == tail) {
				head = -1;
				tail = -1;
			} else {
				head = (head+1) % fila.length;
			}
		}
	}
	
	public static String print() {
		if(isEmpty()) {
			return "empty";
		}
		String saida = "";
		int i = head;
		while(i != tail) {
			saida += fila[i] + " ";
			i = (i+1) % fila.length;
		}
		saida += fila[i];
		return saida.trim();
	}
}