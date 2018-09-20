/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.rfdouro.prjJPA01.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author romulo.douro
 */
//@Controller
public class DefaultController {
 @RequestMapping(value = "*")
 @ResponseBody
 public String erro(){
  return "Página qualquer sem propósito";
 }
}
