package entity;

import java.util.Random;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class Trade {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  public int tradeId;

  public int securityId;
  public int quantity;
  public float price;
  public int buyerClearingMemberId;
  public int sellerClearingMemberId;
  public float transactionAmount;
  
  private static Random rand = new Random(System.currentTimeMillis());

  // Default constructor generate random Trade
  public Trade(){
    // Random rand = new Random();
    this.securityId = 1 + rand.nextInt(15);
    this.quantity = 1 + rand.nextInt(10000);
    this.price = 150000*rand.nextFloat();
    this.buyerClearingMemberId = 1+ rand.nextInt(15);
    int sCMid;
    do {
      sCMid = 1 + rand.nextInt(15);
    } while (sCMid == this.buyerClearingMemberId);
    this.sellerClearingMemberId = sCMid;
    this.transactionAmount = this.quantity*this.price;    
  }


  public Trade(int secId,int qty,float pc,int bCMid,int sCMid){
    this.securityId = secId;
    this.quantity = qty;
    this.price = pc;
    this.buyerClearingMemberId = bCMid;
    this.sellerClearingMemberId = sCMid;
    this.transactionAmount = qty*price;
  }
  
}