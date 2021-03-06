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
import oit.is.z0779.kaizi.janken.model.MatchInfo;
import oit.is.z0779.kaizi.janken.model.MatchInfoMapper;

@Controller
@RequestMapping("/lec02")
public class Lec02Controller{

  @Autowired
  UserMapper userMapper;
  @Autowired
  MatchMapper matchMapper;
  @Autowired
  MatchInfoMapper matchinfoMapper;
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
    ArrayList<MatchInfo> matchinfos = matchinfoMapper.selectAllMatchInfoTrue();
    model.addAttribute("users", users);
    model.addAttribute("matches",matches);
    model.addAttribute("matchinfos",matchinfos);
    return "lec02.html";
  }

  @GetMapping("match")
  public String match(@RequestParam Integer id,ModelMap model,Principal prin){
    User my = userMapper.selectByName(prin.getName());
    User you = userMapper.selectById(id);
    model.addAttribute("my",my);
    model.addAttribute("you",you);
    return "match.html";
  }

  @GetMapping("match1")
  public String match1(@RequestParam String te,@RequestParam Integer my,@RequestParam Integer you,ModelMap model,Principal prin){
    String loginUser = prin.getName();
    String login_user = "Hi "+loginUser;
    model.addAttribute("login_user",login_user );

    Janken janken = new Janken();

    String y = "??????????????? " + te;
    String c = "???????????? " + janken.getHand();
    String r = "?????? " + janken.Result(te);

    model.addAttribute("y",y);
    model.addAttribute("c",c);
    model.addAttribute("r",r);

    model.addAttribute("my",my);
    model.addAttribute("you",you);

    Match match = new Match();
    match.setUser1(my);
    match.setUser2(you);
    match.setUser1Hand(te);
    match.setUser2Hand(janken.getHand());
    matchMapper.insertMatch(match);

    MatchInfo matchinfo = new MatchInfo();
    matchinfo.setUser1(my);
    matchinfo.setUser2(you);
    matchinfo.setUser1Hand(te);
    matchinfo.setIsActive(true);
    matchinfoMapper.insertMatchInfo(matchinfo);

    return "wait.html";
  }

  @GetMapping("Gu")
  public String gu(ModelMap model){
    Janken janken = new Janken();
    String y = "??????????????? Gu";
    String c = "???????????? " + janken.getHand();
    String r = "?????? " + janken.Result("Gu");
    model.addAttribute("you",y);
    model.addAttribute("cpu",c);
    model.addAttribute("result",r);
    return "lec02.html";
  }

  @GetMapping("Choki")
  public String ch(ModelMap model){
    Janken janken = new Janken();
    String y = "??????????????? Choki";
    String c = "???????????? " + janken.getHand();
    String r = "?????? " + janken.Result("Ch");
    model.addAttribute("you",y);
    model.addAttribute("cpu",c);
    model.addAttribute("result",r);
    return "lec02.html";
  }

  @GetMapping("Pa")
  public String pa(ModelMap model){
    Janken janken = new Janken();
    String y = "??????????????? Pa";
    String c = "???????????? " + janken.getHand();
    String r = "?????? " + janken.Result("Pa");
    model.addAttribute("you",y);
    model.addAttribute("cpu",c);
    model.addAttribute("result",r);
    return "lec02.html";
  }

}
