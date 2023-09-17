package sorteador.sorte.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import sorteador.sorte.Model.M_sorte;
import sorteador.sorte.Service.S_sorte;

@Controller
public class C_sorte {

  @GetMapping("/")
  public String getIndex() {
    return "/Index";
  }

  @PostMapping("/")
  public String postIndex(
    @RequestParam("qtdNum") int qtdNum,
    @RequestParam("numMin") int numMin,
    @RequestParam("numMax") int numMax,
    @RequestParam("repetir") boolean repetir,
    @RequestParam("ordena") boolean ordena,
    Model model
  ) {
    M_sorte sorteio = S_sorte.Sortear(qtdNum, numMin, numMax, repetir, ordena);
    model.addAttribute("numMax", numMax);
    model.addAttribute("numMin", numMin);
    model.addAttribute("qtdNum", qtdNum);
    model.addAttribute("repetir", repetir);
    model.addAttribute("ordena", ordena);
    model.addAttribute("resultado", sorteio.getResultado());
    model.addAttribute("dataFormatada", sorteio.getDataFormatada());
    return "/Index";
  }
}
