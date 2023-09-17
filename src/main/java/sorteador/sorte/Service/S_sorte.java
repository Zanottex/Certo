package sorteador.sorte.Service;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import sorteador.sorte.Model.M_sorte;

public class S_sorte {

  public static M_sorte Sortear(
    int qtdNum,
    int numMin,
    int numMax,
    boolean repetir,
    boolean ordena
  ) {
    int[] resultado = new int[qtdNum];
    boolean repetiu = false;
    int result;
    for (int i = 0; i < qtdNum; i++) {
      result =
        (int) Math.floor(Math.random() * ((numMax + 1) - numMin) + numMin);
      if (!repetir) {
        do {
          result =
            (int) Math.floor(Math.random() * ((numMax + 1) - numMin) + numMin);
          int streamFilhoDaPuta = result;
          repetiu =
            Arrays.stream(resultado).anyMatch(x -> x == streamFilhoDaPuta); //Selo Prof de Aprovação
        } while (repetiu);
      }
      resultado[i] = result;
    }
    if (ordena) {
      Arrays.sort(resultado);
    }

    Date data = new Date();

    SimpleDateFormat formato = new SimpleDateFormat(
      "dd 'de' MMM 'de' yyyy, HH:mm",
      new Locale("pt", "BR")
    );

    String dataFormatada = formato.format(data);
    M_sorte m_sorte = new M_sorte(resultado, dataFormatada);

    return m_sorte;
  }
}
