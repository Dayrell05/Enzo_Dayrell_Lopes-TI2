package Primeira_atividade;
import java.util.*;



class SomarDoisNumeros {

	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		int num1, num2, soma = 0;
		System.out.println("escreva dois numeros que serão somados");
		num1 = sc.nextInt();
		num2 = sc.nextInt();
		soma = num1 + num2;
		System.out.print(soma);

	}

}
