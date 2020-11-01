package commons.generators;

import java.util.Random;

public class Generators {
	public static String generateSelectPayment() {
		String tiposPagamento = "dinheiro/boleto bancario/cheque/cartao de credito/cartao de debito";
		String[]forma = tiposPagamento.split("/");
		
		Random random = new Random();
		int intervalo = random.nextInt(forma.length);
		return forma[intervalo];
		
		}
	
	public static String generateSelectEmail() {
		String idEmail = "cleberluiz/patriciathomaz/joaosilva/josebarros";
		String[]name = idEmail.split("/");
		
		String idDominio = "hotmail.com/gmail.com/outlook.com/uol.com.br";
		String[]provedor = idDominio.split("/");
		
		
		Random random = new Random();
		int intervalo = random.nextInt(name.length);
		int intervalo2 = random.nextInt(provedor.length);

		String juntando = name[intervalo]+ provedor[intervalo2];

		
		return juntando;
		
	}
	
		
		
	

}
