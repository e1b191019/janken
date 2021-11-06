package oit.is.z0779.kaizi.janken.model;

import java.util.Random;

public class Janken{

  String[] hands = { "Gu", "Choki", "Pa" };
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
    if(yhand.equals("Gu")){
      if(hand.equals("Gu")){
        return draw;
      }else if(hand.equals("Choki")){
        return win;
      }else{
        return lose;
      }
    }else if(yhand.equals("Choki")){
      if(hand.equals("Gu")){
        return lose;
      }else if(hand.equals("Choki")){
        return draw;
      }else{
        return win;
      }
    }else{
      if(hand.equals("Gu")){
        return win;
      }else if(hand.equals("Choki")){
        return lose;
      }else{
        return draw;
      }
    }
  }

}
