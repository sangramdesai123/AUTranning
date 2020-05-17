package day1;

import java.text.SimpleDateFormat;
import java.util.*;


public class Auction {
	
	public static void main(String[] args) {
		System.out.println(">>>>>>>>>>>>>>> Auction House <<<<<<<<<<<<<<");
		List<Item> itemList = new ArrayList<Item>();
		
		System.out.println("Users in the Auction");
		User admin = new User("admin");
		User user1 = new User("sangram");
		User user2 = new User("Ajay");
		User user3 = new User("Rupesh");
		System.out.println();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("<<<<<< Enter USer Name >>>>>>");
		String myusername=sc.next();
		
		
		if(myusername.equals("admin")) {
			for(int i=0;i<4;i++) {
				System.out.println("<<<<<< Add Items >>>>>>");
				System.out.println("Item No : ");
				int itemNo= sc.nextInt();
				System.out.println("Item Price : ");
				int itemPrice= sc.nextInt();
				System.out.println("Item Date : ");
				String itemDate= sc.next();
				admin.addItem(itemNo,itemPrice, itemDate,itemList);
				/*
				 * Some dummy items to add
				 * 1 5000 2020-06-20 
				 * 2 8000 2020-06-25 
				 * 3 6000 2020-06-12 
				 */
			}
			System.out.println();
		}
		
		System.out.println();
		admin.showBiddings();
		System.out.println();
		user1.showBiddings();
		user2.showBiddings();
		user3.showBiddings();
		
		System.out.println("<<<<<< Enter USer Name >>>>>>");
		myusername=sc.next();
		
		
		if(myusername.equals("sangram")) {
			for(int i=0;i<3;i++) {
				System.out.println("Bid Price for Item "+(i+1)+" :");
				int itemPrice= sc.nextInt();
				user1.bidForItem(i,itemPrice,itemList);
			}
		}
		System.out.println("<<<<<< Enter USer Name >>>>>>");
		myusername=sc.next();
		
		if(myusername.equals("Ajay")) {
			for(int i=0;i<3;i++) {
				System.out.println("Bid Price for Item "+(i+1)+" :");
				int itemPrice= sc.nextInt();
				user2.bidForItem(i,itemPrice,itemList);
			}
		}
		System.out.println("<<<<<< Enter USer Name >>>>>>");
		myusername=sc.next();
		
		if(myusername.equals("Rupesh")) {
			for(int i=0;i<3;i++) {
				System.out.println("Bid Price for Item "+(i+1)+" :");
				int itemPrice= sc.nextInt();
				user3.bidForItem(i,itemPrice,itemList);
			}
		}
		
		System.out.println("Bidding Done By All ");
		
		user1.showBiddings();
		user2.showBiddings();
		user3.showBiddings();
		
		System.out.println();
		user1.finalizeResults(itemList);
		System.out.println();
		admin.finalizeResults(itemList);
		
		user1.showBiddings();
		user2.showBiddings();
		user3.showBiddings();
		
	}

}


class Item {
	public int itemId;
	private int basePrice;
	private List<Bidding> bids=new ArrayList<Bidding>();
	public Date endDate;
	
	public Item(int itemId, int basePrice, String endDate) {
		this.itemId=itemId;
		this.setBasePrice(basePrice);
		try {
			this.endDate=new SimpleDateFormat("yyyy-MM-dd").parse(endDate);
			} 
		catch (Exception e) {
			e.printStackTrace();
			}
		  
	}

	public int getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(int basePrice) {
		this.basePrice = basePrice;
	}

	public List<Bidding> getBids() {
		return bids;
	}

	public void setBids(List<Bidding> bids) {
		this.bids = bids;
	}
}

class Bidding {
	public int price;
	public String userName;
	public int itemId;
	public boolean bidWon;
	
	public Bidding(int price, int itemId, String userName)
	{
		this.price=price;
		this.userName=userName;
		this.itemId=itemId;
		this.bidWon=false;
	}
}