package oit.is.z0779.kaizi.janken.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import oit.is.z0779.kaizi.janken.model.Janken;

@Controller
public class Lec02Controller{

  @PostMapping("/lec02")
  public String lec02(@RequestParam String name,ModelMap model){
    String na = "Hi " + name;
    model.addAttribute("n", na);
    return "lec02.html";
  }

  @GetMapping("gu")
  public String gu(ModelMap model){
    Janken janken = new Janken();
    String y = "あなたの手 Gu";
    String c = "相手の手 " + janken.getHand();
    String r = "結果 " + janken.Result("gu");
    model.addAttribute("you",y);
    model.addAttribute("cpu",c);
    model.addAttribute("result",r);
    return "lec02.html";
  }

  @GetMapping("ch")
  public String ch(ModelMap model){
    Janken janken = new Janken();
    String y = "あなたの手 Ch";
    String c = "相手の手 " + janken.getHand();
    String r = "結果 " + janken.Result("ch");
    model.addAttribute("you",y);
    model.addAttribute("cpu",c);
    model.addAttribute("result",r);
    return "lec02.html";
  }

  @GetMapping("pa")
  public String pa(ModelMap model){
    Janken janken = new Janken();
    String y = "あなたの手 Pa";
    String c = "相手の手 " + janken.getHand();
    String r = "結果 " + janken.Result("pa");
    model.addAttribute("you",y);
    model.addAttribute("cpu",c);
    model.addAttribute("result",r);
    return "lec02.html";
  }

}
