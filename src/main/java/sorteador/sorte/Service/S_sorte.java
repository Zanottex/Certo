package sorteador.sorte.Service;

import sorteador.sorte.Model.M_sorte;

import java.util.Arrays;

public class S_sorte {

    public static M_sorte Sortear(int qtdNum,
                                  int numMin,
                                  int numMax,
                                  boolean repetir,
                                  boolean ordena) {
        int[] resultado = new int[qtdNum];
        boolean repetiu = false;
        int result;
        for (int i = 0; i < qtdNum; i++) {
            result = (int) Math.floor(Math.random() * ((numMax+1) - numMin) + numMin);
            if (!repetir) {
                do {
                    result = (int) Math.floor(Math.random() * ((numMax+1) - numMin) + numMin);
                    int streamFilhoDaPuta = result;
                    repetiu = Arrays.stream(resultado).anyMatch(x -> x == streamFilhoDaPuta);//Selo Prof de Aprovação
                } while (repetiu);
            }
            resultado[i] = result;
            if (ordena) {
                Arrays.sort(resultado);
            }
        }
        M_sorte m_sorte = new M_sorte(resultado);

        return m_sorte;
    }
}
