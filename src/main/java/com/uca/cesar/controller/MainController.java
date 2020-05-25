package com.uca.cesar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.uca.cesar.domain.Contribuyente;
import com.uca.cesar.domain.Importancia;
import com.uca.cesar.service.ContribuyenteService;
import com.uca.cesar.service.ImportanciaService;

@Controller
public class MainController {

	@Autowired
	ContribuyenteService contribuyenteService;

	@Autowired
	ImportanciaService importanciaService;

	@RequestMapping("/index")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView();
		List<Importancia> importancias = null;

		try {
			importancias = importanciaService.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}

		mav.addObject("contribuyente", new Contribuyente());
		mav.addObject("importancias", importancias);
		mav.setViewName("index");
		return mav;
	}

	@RequestMapping("/listado")
	public ModelAndView listado() {
		ModelAndView mav = new ModelAndView();
		List<Contribuyente> contribuyentes = null;

		try {
			contribuyentes = contribuyenteService.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}

		mav.addObject("contribuyentes", contribuyentes);
		mav.setViewName("listado");
		return mav;
	}

	@RequestMapping("/insertar")
	public ModelAndView insertar(@ModelAttribute Contribuyente contribuyente) {
		ModelAndView mav = new ModelAndView();

		try {
			contribuyenteService.save(contribuyente);
		} catch (Exception e) {
			e.printStackTrace();
		}

		mav.setViewName("exito");
		return mav;
	}
}