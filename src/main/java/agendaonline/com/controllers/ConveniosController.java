package agendaonline.com.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import agendaonline.com.models.Convenio;
import agendaonline.com.repositories.ConvenioRepository;

@Controller
public class ConveniosController {

	@Autowired
	private ConvenioRepository cr;
	
	@RequestMapping("/convenios")
	public ModelAndView listaConvenios(){
		ModelAndView mv = new ModelAndView("convenio/listaConvenios");
		Iterable<Convenio> listaConvenios = cr.findAll();
		System.out.println(listaConvenios);
		mv.addObject("convenios", listaConvenios);
		return mv;
	}
	
//	@RequestMapping("/convenios")
//	public String listaConvenios(Model model){ //Model eu recebo de importação do Spring.
//		Iterable<Convenio> listaConvenios = cr.findAll();
//		System.out.println(listaConvenios);
//		model.addAttribute("convenios", listaConvenios);
//		return "convenio/listaConvenios";
//	}
	
	
	@RequestMapping(value="/convenios", method=RequestMethod.POST)
	public String cadastroConvenio(Convenio convenio, BindingResult result, RedirectAttributes attributes){
//		if(result.hasErrors()){
//			attributes.addFlashAttribute("mensagem", "Verifique os campos digitados!");
//			return listaConvenios();
//		}
		cr.save(convenio);
		return "redirect:/convenios";
	}
}
