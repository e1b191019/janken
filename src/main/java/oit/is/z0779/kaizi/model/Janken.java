package oit.is.z0779.kaizi.janken.model;

import java.util.Random;

public class Janken{

  String[] hands = { "Gu", "Ch", "Pa" };
  String hand;
  String draw = "Draw";
  String win = "You Win!";
  String lose = "You Lose";

  public Janken(){
    Random r = new Random();
    this.hand = hands[r.nextInt(3)];
  }

  public String getHand(){
    return hand;
  }

  public String Result(String yhand){
    if(yhand.equals("gu")){
      if(hand.equals("Gu")){
        return draw;
      }else if(hand.equals("Ch")){
        return win;
      }else{
        return lose;
      }
    }else if(yhand.equals("ch")){
      if(hand.equals("Gu")){
        return lose;
      }else if(hand.equals("Ch")){
        return draw;
      }else{
        return win;
      }
    }else{
      if(hand.equals("Gu")){
        return win;
      }else if(hand.equals("Ch")){
        return lose;
      }else{
        return draw;
      }
    }
  }

}
