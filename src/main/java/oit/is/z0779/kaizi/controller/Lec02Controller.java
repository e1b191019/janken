package oit.is.z0779.kaizi.janken.controller;

import java.security.Principal;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import oit.is.z0779.kaizi.janken.model.Janken;
import oit.is.z0779.kaizi.janken.model.Entry;
import oit.is.z0779.kaizi.janken.model.User;
import oit.is.z0779.kaizi.janken.model.UserMapper;
import oit.is.z0779.kaizi.janken.model.Match;
import oit.is.z0779.kaizi.janken.model.MatchMapper;

@Controller
@RequestMapping("/lec02")
public class Lec02Controller{

  @Autowired
  UserMapper userMapper;
  @Autowired
  MatchMapper matchMapper;
  @Autowired
  private Entry entry;

  @GetMapping("step1")
  public String lec02(ModelMap model, Principal prin){
    String loginUser = prin.getName();
    this.entry.addUser(loginUser);
    String na = "Hi " + loginUser;
    model.addAttribute("login_user", na);
    model.addAttribute("entry", this.entry);
    return "lec02.html";
  }

  @GetMapping("step2")
  @Transactional
  public String step2(ModelMap model,Principal prin) {
    String loginUser = prin.getName();
    String login_user = "Hi "+loginUser;
    model.addAttribute("login_user",login_user );
    ArrayList<User> users = userMapper.selectAllUser();
    ArrayList<Match> matches = matchMapper.selectAllMatch();
    model.addAttribute("users", users);
    model.addAttribute("matches",matches);
    return "lec02.html";
  }

  @GetMapping("match")
  public String match(@RequestParam Integer id,ModelMap model){
    User myname = userMapper.selectById(id);
    User yourname = userMapper.selectById(id);
    model.addAttribute("myname",myname);
    model.addAttribute("yourname",yourname);
    return "match.html";
  }

  @GetMapping("match1")
  public String match1(@RequestParam String te,ModelMap model){
    Janken janken = new Janken();

    String y = "あなたの手 " + te;
    String c = "相手の手 " + janken.getHand();
    String r = "結果 " + janken.Result(te);

    model.addAttribute("y",y);
    model.addAttribute("c",c);
    model.addAttribute("r",r);

    Match match = new Match();
    match.setUser1(2);
    match.setUser2(1);
    match.setUser1Hand(te);
    match.setUser2Hand(janken.getHand());
    matchMapper.insertMatch(match);

    return "match.html";
  }

  @GetMapping("Gu")
  public String gu(ModelMap model){
    Janken janken = new Janken();
    String y = "あなたの手 Gu";
    String c = "相手の手 " + janken.getHand();
    String r = "結果 " + janken.Result("Gu");
    model.addAttribute("you",y);
    model.addAttribute("cpu",c);
    model.addAttribute("result",r);
    return "lec02.html";
  }

  @GetMapping("Choki")
  public String ch(ModelMap model){
    Janken janken = new Janken();
    String y = "あなたの手 Choki";
    String c = "相手の手 " + janken.getHand();
    String r = "結果 " + janken.Result("Ch");
    model.addAttribute("you",y);
    model.addAttribute("cpu",c);
    model.addAttribute("result",r);
    return "lec02.html";
  }

  @GetMapping("Pa")
  public String pa(ModelMap model){
    Janken janken = new Janken();
    String y = "あなたの手 Pa";
    String c = "相手の手 " + janken.getHand();
    String r = "結果 " + janken.Result("Pa");
    model.addAttribute("you",y);
    model.addAttribute("cpu",c);
    model.addAttribute("result",r);
    return "lec02.html";
  }

}
