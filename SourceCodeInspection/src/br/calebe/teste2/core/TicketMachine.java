package br.calebe.teste2.core;

import br.calebe.teste2.exception.PapelMoedaInvalidaException;
import br.calebe.teste2.exception.SaldoInsuficienteException;
import java.util.Iterator;


public class TicketMachine {

    protected int valor;
    protected int saldo;
    protected int[] papelMoeda = {2, 5, 10, 20, 50, 100};

    public TicketMachine(int valor) {
        this.valor = valor;
        this.saldo = 0;
    }

    public void inserir(int quantia) throws PapelMoedaInvalidaException {
        boolean achou = false;
        for (int i = 0; i < papelMoeda.length && !achou; i++) {
            // Ajustado de papelMoeda[1] para papelMoeda[i]
            if (papelMoeda[i] == quantia) {
                achou = true;
            }
        }
        if (!achou) {
            throw new PapelMoedaInvalidaException();
        }
        this.saldo += quantia;
    }

    public int getSaldo() {
        return saldo;
    }
    // Objeto troco não instanciado
    public Iterator<PapelMoeda> getTroco() {
        Troco troco = new Troco(this.saldo - this.valor); 
        return troco.getIterator();
    }

    public String imprimir() throws SaldoInsuficienteException {
        if (saldo < valor) {
            throw new SaldoInsuficienteException();
        }
        // O saldo não estava sendo subtraído
        saldo = saldo - valor;
        String result = "*****************\n";
        result += "*** R$ " + saldo + ",00 ****\n";
        result += "*****************\n";
        return result;
    }
}
