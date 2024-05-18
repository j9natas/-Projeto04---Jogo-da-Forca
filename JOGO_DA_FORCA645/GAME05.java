package FORCA04;

import java.util.Scanner;


public class GAME05 {

	
	
	 private static final String[] PALAVRAS = {"java", "programacao", "computador", "desenvolvimento", "openai"};
	    private static final int MAX_TENTATIVAS = 6;

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        String palavraSecreta = selecionarPalavraSecreta();
	        char[] palavraEscondida = new char[palavraSecreta.length()];
	        boolean[] letrasUtilizadas = new boolean[26];
	        int tentativasRestantes = MAX_TENTATIVAS;

	        while (tentativasRestantes > 0 && !palavraRevelada(palavraEscondida)) {
	            exibirStatusJogo(palavraEscondida, tentativasRestantes);
	            char letra = obterPalpite(scanner, letrasUtilizadas);
	            if (!atualizarPalavraEscondida(palavraSecreta, palavraEscondida, letra)) {
	                tentativasRestantes--;
	            }
	        }

	        exibirResultadoFinal(palavraSecreta, palavraEscondida);
	    }

	    private static String selecionarPalavraSecreta() {
	        return PALAVRAS[(int) (Math.random() * PALAVRAS.length)];
	    }

	    private static boolean palavraRevelada(char[] palavraEscondida) {
	        for (char c : palavraEscondida) {
	            if (c == 0) {
	                return false;
	            }
	        }
	        return true;
	    }

	    private static void exibirStatusJogo(char[] palavraEscondida, int tentativasRestantes) {
	        System.out.println("Palavra: " + new String(palavraEscondida));
	        System.out.println("Tentativas restantes: " + tentativasRestantes);
	    }

	    private static char obterPalpite(Scanner scanner, boolean[] letrasUtilizadas) {
	        char letra;
	        while (true) {
	            System.out.print("Digite uma letra: ");
	            String input = scanner.next().toLowerCase();
	            if (input.length() != 1 || !Character.isLetter(input.charAt(0))) {
	                System.out.println("Por favor, insira apenas uma letra.");
	                continue;
	            }
	            letra = input.charAt(0);
	            if (letrasUtilizadas[letra - 'a']) {
	                System.out.println("Você já tentou essa letra. Tente outra.");
	            } else {
	                letrasUtilizadas[letra - 'a'] = true;
	                break;
	            }
	        }
	        return letra;
	    }

	    private static boolean atualizarPalavraEscondida(String palavraSecreta, char[] palavraEscondida, char letra) {
	        boolean acerto = false;
	        for (int i = 0; i < palavraSecreta.length(); i++) {
	            if (palavraSecreta.charAt(i) == letra) {
	                palavraEscondida[i] = letra;
	                acerto = true;
	            }
	        }
	        if (!acerto) {
	            System.out.println("Letra não encontrada na palavra secreta.");
	        }
	        return acerto;
	    }

	    private static void exibirResultadoFinal(String palavraSecreta, char[] palavraEscondida) {
	        if (palavraRevelada(palavraEscondida)) {
	            System.out.println("Parabéns! Você ganhou! A palavra secreta era: " + palavraSecreta);
	        } else {
	            System.out.println("Você perdeu! A palavra secreta era: " + palavraSecreta);
	        }
	    }
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

