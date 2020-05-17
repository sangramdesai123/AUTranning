package day1;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class User {
	private String userName;
	private static int count=0;
	private List<Bidding> biddings=new ArrayList<Bidding>();
	
	
	public User(String userName)
	{
		count++;
		System.out.println(count+"  "+userName);
		this.userName=userName;
	}
	
	public void addItem(int itemId, int basePrice, String endDate, List<Item> itemList) {
		if(this.userName.equals("admin"))
		{
			for(Item item:itemList)
			{
				if(item.itemId==itemId)
				{
					System.out.println("Item ID "+itemId+" already exists!!");
					return;
				}
			}
			System.out.println("Adding new Item "+itemId);
			Item item = new Item(itemId,basePrice,endDate);
			itemList.add(item);
			return;
		}
		System.out.println("Only admin can add new items");
	}
	
	public void bidForItem(int itemId, int price, List<Item> itemList) {
		if(this.userName.equals("admin"))
		{
			System.out.println("Admin can't bid");
			return;
		}
		for(Bidding bid: this.biddings)
		{
			if(bid.itemId==itemId)
			{
				System.out.println(this.userName+" has already made a bidding for Item "+itemId);
				return;
			}
		}
		for(Item item: itemList)
		{
			if(item.itemId==itemId)
			{
				if(item.endDate.compareTo(new Date())<0)
				{
					System.out.println("End date crossed!!");
					return;
				}
				if(item.getBasePrice()>price)
				{
					System.out.println("Price less than base price!!");
					return;
				}
				Bidding newBid = new Bidding(price,itemId,this.userName);
				this.biddings.add(newBid);
				List<Bidding> bidslist = item.getBids();
				bidslist.add(newBid);
				item.setBids(bidslist);
			}
		}
	}
	
	public void showBiddings() {
		if(!this.userName.equals("admin"))
		{
			System.out.println("\n**** Biddings "+this.userName+" ****\n");
			if(this.biddings.isEmpty())
			{
				System.out.println("No biddings made");
				return;
			}
			for(Bidding bid : this.biddings)
			{
				if(bid.bidWon)
					System.out.println(bid.itemId+" "+bid.price+" Won bid");
				else
					System.out.println(bid.itemId+" "+bid.price);
			}
		}
		else
		{
			System.out.println("Admin has no biddings");
		}
	}
	
	public void finalizeResults(List<Item> itemList) {
		if(!this.userName.equals("admin"))
			System.out.println("Only admin can view results");
		else
		{
			for(Item item: itemList)
			{
				List<Bidding> biddingList=item.getBids();
				if(biddingList.isEmpty())
				{
					System.out.println("No biddings for item number "+item.itemId);
					System.out.println();
					continue;
				}
				Bidding currentBid=biddingList.get(0);
				for(Bidding bidding: biddingList)
				{
					if(bidding.bidWon)
					{
						currentBid=bidding;
						break;
					}
					if(bidding.price>currentBid.price)
						currentBid=bidding;
				}
				currentBid.bidWon=true;
			}
		}
	}
	
}
