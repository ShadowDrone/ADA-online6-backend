package ar.com.ada.mvc.mvcdemo.controllers;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ar.com.ada.mvc.mvcdemo.models.UserInfo;


@Controller //A difernecia de Rest API, aca son Controllers y no RestController
@RequestMapping("/hora")
public class HoraController {
    
    @GetMapping("/ver-hora-actual")
    //El metodo devuelve un String, porque devuelve la vista a procesar.
    public String getHoraActual(Model model) {
        UserInfo userInfo = new UserInfo();
        userInfo.nombre = "Analia";
        userInfo.apellido = "Juarez";

        model.addAttribute("usuario", userInfo);
        model.addAttribute("hora", "La hora actual en este momento es: "+ (new Date()).toString());
        return "hora-actual";//vista
    }
    
}
