package sorteador.sorte.Model;

public class M_sorte {

  private int[] resultado;

  private String dataFormatada;

  public M_sorte(int[] resultado, String dataFormatada) {
    this.resultado = resultado;
    this.dataFormatada = dataFormatada;
  }

  public String getDataFormatada() {
    return dataFormatada;
  }

  public int[] getResultado() {
    return resultado;
  }
}
