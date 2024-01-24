import java.util.Locale;
import java.util.Scanner;

public class Imposto {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		double renda_salario,renda_servicos, 
			   renda_capital;
		
		double gastos_medicos,gastos_educacionais;
		
		double imposto_salario, imposto_servicos, 
			   imposto_capital, imposto_total;
		
		double deducoes_max, deducoes_gastos;
		
		//Entrada de dados
		System.out.print("Renda anual com salário: ");
		renda_salario = sc.nextDouble();
		
		System.out.print("Renda anual com prestação de serviço: ");
		renda_servicos = sc.nextDouble();
		
		System.out.print("Renda anual com ganho de capital: ");
		renda_capital = sc.nextDouble();
		
		System.out.print("Gastos médicos: ");
		gastos_medicos = sc.nextDouble();
		
		System.out.print("Gastos educacionais: ");
		gastos_educacionais = sc.nextDouble();
		
		System.out.println();
		System.out.println("RELATÓRIO DE IMPOSTO DE RENDA");
		System.out.println();
		
		//Cálculo de impostos sobre salário
		if ((renda_salario/12 >= 3000) && (renda_salario/12 < 5000)) {
			imposto_salario = renda_salario * 0.1;
		}else if (renda_salario/12 > 5000) {
			imposto_salario = renda_salario * 0.2;
		}else {
			imposto_salario = 0.0;
		}
		
		//cálculo de imposto sobre serviços
		if (renda_servicos > 0) {
			imposto_servicos = renda_servicos * 0.15;	
		}else imposto_servicos = 0.0;
		
		
		//cálculo de imposto sobre ganho de capital
		if (renda_capital > 0) {
			imposto_capital = renda_capital * 0.2;	
		}else imposto_capital = 0.0;
		
		System.out.println("CONSOLIDADO DE RENDA:");
		System.out.printf("Imposto sobre salário: %.2f%n",imposto_salario);
		System.out.printf("Imposto sobre serviços: %.2f%n",imposto_servicos);
		System.out.printf("Imposto sobre ganho de capital: %.2f%n",imposto_capital);
		
		System.out.println();
		System.out.println("DEDUÇÕES:");
		
		//cálculo de deduções
		imposto_total = imposto_salario + imposto_servicos + imposto_capital;
		deducoes_gastos = gastos_medicos + gastos_educacionais;
		if(deducoes_gastos > imposto_total * 0.3) {
			deducoes_max = imposto_total * 0.3;
		}else deducoes_max = deducoes_gastos;
		
		System.out.printf("Máximo dedutível: %.2f%n",deducoes_max);
		System.out.printf("Gastos dedutíveis: %.2f%n",deducoes_gastos);
		
		System.out.println();
		System.out.println("RESUMO:");
		System.out.printf("Imposto bruto total: %.2f%n",imposto_total);
		System.out.printf("Abatimento: %.2f%n",deducoes_max);
		System.out.printf("Imposto devido: %.2f%n",(imposto_total - deducoes_max));

	}

}
