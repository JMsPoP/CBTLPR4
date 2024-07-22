/*
 * TRABALHO PRÁTICO 04: Construir a classe Data, conforme especificação
 *abaixo, este exercício comporá a avaliação final, portanto será obrigatória sua
 *elaboração para a prova final.
 * @author: João Marcos Teles Silva CB3026787
 * • O construtor Data() deverá permitir ao usuário digitar os valores de dia, mês e ano e com eles
inicializar os atributos da classe. Os valores digitados deverão ser consistidos e só aceitos se válidos,
caso contrário, redigitar;
• O construtor Data(int d, int m, int a) deverá receber os valores de dia, mês e ano e com eles inicializar
as propriedades da classe;
• Os métodos entraDia(int d), entraMes(int m) e entraAno(int a) devem receber um valor e atribuí-lo às
respectivas propriedades;

• Os métodos entraDia (),entraMes () e entraAno () devem permitir ao usuário digitar um valor e atribuí-
lo a respectiva propriedade. Os valores digitados devem sofrer consistência e só aceitos quando válidos,

caso contrário, solicitar ao usuário redigitar;
• Os métodos retDia(), retMes() e retAno() devem nos devolver as respectivas propriedades;
• O método mostra1() deve nos devolver a data no formato: dd/mm/aaaa;
• O método mostra2() deve nos devolver a data no formato: dd/mesPorExtenso/ano;
• O método bissexto() deve nos devolver um boolean informando se o ano é ou não bissexto;
• O método diasTranscorridos, deve retornar a quantidade de dias transcorridos no ano até a data
digitada.
• O método apresentaDataAtual() deve imprimir a data atual, utilizando as classes Date e DateFormat, o
DateFormat empregando o seguinte método: getDateInstance(DateFormat.FULL);
• Conveniente colocar tratamento de exceção para as possíveis inconsistências na entrada de dados.
Exercício 02
Agora, desenvolva um programa capaz de testar a classe e os métodos desenvolvidos no
exercício anterior.
 */

import java.util.Date;
import java.text.DateFormat;
import java.util.Scanner;

public class Data {
    private int dia;
    private int mes;
    private int ano;

    Scanner scanner = new Scanner(System.in);

    public Data() {
        entraDia();
        entraMes();
        entraAno();
    }

    public Data(int d, int m, int a) {
        entraDia(d);
        entraMes(m);
        entraAno(a);
    }

    public void entraDia() {
        while (true) {
            try {
                System.out.print("Digite o dia (entre 1 e 31): ");
                int d = scanner.nextInt();
                if (d < 1 || d > 31) {
                    throw new Exception("O dia deve estar entre 1 e 31");
                }
                this.dia = d;
                break;
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
    }

    public void entraDia(int d){
        this.dia = d;
    }

    public void entraMes() {
        while (true) {
            try {
                System.out.print("Digite o mês (entre 1 e 12): ");
                int m = scanner.nextInt();
                if (m < 1 || m > 12) {
                    throw new Exception("O mês deve estar entre 1 e 12");
                }
                this.mes = m;
                break;
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
    }

    public void entraMes(int m){
        this.mes = m;
    }


    public void entraAno() {
        while (true) {
            try {
                System.out.print("Digite o ano: ");
                int a = scanner.nextInt();
                if (a < 1) {
                    throw new Exception("O ano deve ser maior que 0");
                }
                this.ano = a;
                break;
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
    }

    public void entraAno(int a){
        this.ano = a;
    }

    public int retDia() {
        return this.dia;
    }

    public int retMes() {
        return this.mes;
    }

    public int retAno() {
        return this.ano;
    }

    public String mostra1() {
        return String.format("%02d/%02d/%04d", this.dia, this.mes, this.ano);
    }

    public String mostra2() {
        String[] meses = {"Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"};
        String[] dias = {"", "Primeiro", "Dois", "Três", "Quatro", "Cinco", "Seis", "Sete", "Oito", "Nove", "Dez", "Onze", "Doze", "Treze", "Quatorze", "Quinze", "Dezesseis", "Dezessete", "Dezoito", "Dezenove", "Vinte", "Vinte e um", "Vinte e dois", "Vinte e três", "Vinte e quatro", "Vinte e cinco", "Vinte e seis", "Vinte e sete", "Vinte e oito", "Vinte e nove", "Trinta", "Trinta e um"};
        String mesPorExtenso = meses[mes - 1];
        String diaPorExtenso = dias[dia];
        return String.format("%s de %s de %04d", diaPorExtenso, mesPorExtenso, ano);
    }

    public boolean bissexto() {
        return (this.ano % 4 == 0 && this.ano % 100!= 0) || this.ano % 400 == 0;
    }

    public int diasTranscorridos() {
        int[] diasPorMes = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int dias = 0;
        for (int i = 0; i < this.mes - 1; i++) {
            dias += diasPorMes[i];
        }
        if (this.mes > 2 && bissexto()) {
            dias++;
        }
        dias += this.dia;
        return dias;
    }

    public void apresentaDataAtual() {
        Date data = new Date();
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.FULL);
        System.out.println("Data atual: " + dateFormat.format(data));
    }
}

class TestaData {
    public static void main(String[] args) {
        Data data1 = new Data();
        System.out.println("Data 1: " + data1.mostra1());
        System.out.println("Data 1: " + data1.mostra2());
        System.out.println("Ano bissexto? " + data1.bissexto());
        System.out.println("Dias transcorridos: " + data1.diasTranscorridos());
        System.out.println();

        Data data2 = new Data(31, 12, 0004);
        System.out.println("Data 2: " + data2.mostra1());
        System.out.println("Data 2: " + data2.mostra2());
        System.out.println("Ano bissexto? " + data2.bissexto());
        System.out.println("Dias transcorridos: " + data2.diasTranscorridos());
        System.out.println();

        data1.apresentaDataAtual();
        System.out.println();
    }
}