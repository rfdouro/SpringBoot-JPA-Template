/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.rfdouro.prjJPA01.controllers;

import br.org.rfdouro.prjJPA01.modelo.Pessoa;
import br.org.rfdouro.prjJPA01.persistencia.PessoaRepositorio;
import com.google.gson.Gson;
import java.util.LinkedList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author romulo.douro
 */
@RestController
public class PessoaController {

 @Autowired
 PessoaRepositorio repositorio;

 /*
 @GetMapping(value = "/")
 public String index() {
  return "início";
 }
  */
 @RequestMapping(value = {"/pessoa/all"}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
 public String getAll() {
  Iterable l = repositorio.findAll();
  String ret = new Gson().toJson(l);
  return ret;
 }

 @RequestMapping(value = {"/pessoa/add/{nome}"}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
 public ResponseEntity<String> addPessoa(@PathVariable(value = "nome") String nome) {
  String msg = "true";
  HttpStatus httpStatus = HttpStatus.OK;
  try {
   repositorio.save(new Pessoa(nome));
  } catch (Exception ex) {
   msg = "false";
  }
  return new ResponseEntity<String>(msg, httpStatus);
 }

 @RequestMapping(value = {"/pessoa/get", "/pessoa/get/{id}"}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
 public String getPessoa(@PathVariable(value = "id", required = false) Long id) {
  if (id == null) {
   return getAll();
  }
  Pessoa p = null;
  try {
   p = repositorio.findById(id).get();
  } catch (Exception ex) {

  }
  return new Gson().toJson(p);
 }

 @RequestMapping(value = {"/pessoa/del/{id}"}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
 public String delPessoa(@PathVariable(value = "id", required = true) Long id) {
  String msg = "true";
  try {
   repositorio.deleteById(id);
  } catch (Exception ex) {
   msg = "false";
  }
  return new Gson().toJson(msg);
 }

 @RequestMapping(value = {"/pessoa/upd"}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
 public String updPessoa(@RequestParam(value = "nome", required = true) String nome, @RequestParam(value = "id", required = true) Long id) {
  String msg = "true";
  try {
   Pessoa p = repositorio.findById(id).get();
   p.setNome(nome);
   repositorio.save(p);
  } catch (Exception ex) {
   msg = "false";
  }
  return new Gson().toJson(msg);
 }

 /*
 
 @RequestMapping(value = {"/pessoa/init/{nome}"}, method = RequestMethod.GET)
 public String getInit(@PathVariable(value = "nome") String nome) {
  List l = new LinkedList<Pessoa>();
  l = repositorio.procuraPeloInicio(nome);
  String ret = (l != null) ? (new Gson().toJson(l)) : "";
  return ret;
 }
 
 @RequestMapping(value = {"/pessoa/exact/{nome}"}, method = RequestMethod.GET)
 public String getNome(@PathVariable(value = "nome") String nome) {
  List l = new LinkedList<Pessoa>();
  l = repositorio.findByNome(nome);
  String ret = (l != null) ? (new Gson().toJson(l)) : "";
  return ret;
 }

 @RequestMapping(value = {"/pessoa/add/{nome}"}, method = RequestMethod.GET)
 public String addPessoa(@PathVariable(value = "nome") String nome) {
  String msg = "Inserido";
  try {
   repositorio.save(new Pessoa(nome));
  } catch (Exception ex) {
   msg = ex.getMessage();
  }

  return msg;
 }
 
  */
}
