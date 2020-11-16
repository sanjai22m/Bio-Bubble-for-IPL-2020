import java.util.*;
class Main {
  static String name;
  static String tname;
  static String type;
  static String country;
  static int op;
  static HashMap<String,String> csk=new HashMap<String,String>();
  static HashMap<String,String> mi=new HashMap<String,String>();
  static HashMap<String,String> srh=new HashMap<String,String>();
  static HashMap<String,String> rcb=new HashMap<String,String>();
  static HashMap<String,String> dc=new HashMap<String,String>();
  static HashMap<String,String> kxip=new HashMap<String,String>();
  static HashMap<String,String> rr=new HashMap<String,String>();
  static HashMap<String,String> kkr=new HashMap<String,String>();
  static HashMap<String,String> officials=new HashMap<String,String>();
  static HashMap<String,String> operators=new HashMap<String,String>();
  static HashMap<String,String> gstaff=new HashMap<String,String>();
  static HashMap<String,String> broadcasters=new HashMap<String,String>();
  static HashMap<String,String> personnels=new HashMap<String,String>();
  
  
  static void getdetails(){
    Scanner input=new Scanner(System.in);
    System.out.println("enter your name:");
    name=input.nextLine();
    System.out.println("enter your nationality:");
    country=input.nextLine();
  }

  static void covidtest(){
    Scanner input=new Scanner(System.in);
    System.out.println("coming from a previous bubble? [y/n]");
        char op1=input.next().charAt(0);
        if(op1=='y'){
          System.out.println("enter the result of covid test (+/-):");
          char op2=input.next().charAt(0);
          if(op2=='+'){
            quarantine(op);
          }
          else{
            bubble(op);
          }
        }
        else{
          quarantine(op);
        }
  }

  static void home(){
    Scanner input=new Scanner(System.in);
    System.out.println("press 'h' to return homescreen and 'e' to exit");
    char c=input.next().charAt(0);
    if(c=='h'){
      start();
    }
  }
  static void quarantine(int op){
    System.out.println("\nyou have been requested to undergo a quarantine period of 14 days and produce 3 negative covid results to join your bio-bubble\n\nIn the course of 14 days:");
    Scanner input=new Scanner(System.in);
    System.out.println("enter the result of 1st covid test (+/-):");
    char test1=input.next().charAt(0);
    if(test1=='+'){
      quarantine(op);
    }
    else{
      System.out.println("enter the result of 2nd covid test (+/-):");
      char test2=input.next().charAt(0);
      if(test2=='+'){
        quarantine(op);
      }
      else{
        System.out.println("enter the result of 3rd covid test (+/-):");
        char test3=input.next().charAt(0);
        if(test3=='+'){
          quarantine(op);
        }
        else{
          bubble(op);
        }   
      }
    }
  }

  static void quarantine(){
    
    System.out.println("\nyou have been requested to undergo a quarantine period of 14 days and produce 3 negative covid results to join your team's bio-bubble\n\nIn the course of 14 days:");
    Scanner input=new Scanner(System.in);
    System.out.println("enter the result of 1st covid test (+/-):");
    char test1=input.next().charAt(0);
    if(test1=='+'){
      quarantine();
    }
    else{
      System.out.println("enter the result of 2nd covid test (+/-):");
      char test2=input.next().charAt(0);
      if(test2=='+'){
        quarantine();
      }
      else{
        System.out.println("enter the result of 3rd covid test (+/-):");
        char test3=input.next().charAt(0);
        if(test3=='+'){
          quarantine();
        }
        else{
          bubble();
        }   
      }
    }
  }

  static void bubble(int op){
    System.out.println("you have been added to the bio-bubble");
  }

  static void view(HashMap<String,String> dic){
    Scanner input=new Scanner(System.in);
    System.out.println("press 'v' to view the other members in the bubble");
    char op4=input.next().charAt(0);
      if(op4=='v'){
        for(String i : dic.keySet()){
			    System.out.println("name: "+i+"     "+dic.get(i));
		    }
      }
  }

  static void bubble(){
    Scanner input=new Scanner(System.in);
    System.out.println("you have been added to the bio-bubble\ncontact your team manager to know the venue of the bubble and other information");
    if(tname.equals("csk")){
      csk.put(name,type+"    "+country);
      System.out.println("press 'v' to view the other team members in the bubble");
      char op3=input.next().charAt(0);
      if(op3=='v'){
        for(String i : csk.keySet()){
			    System.out.println("name: "+i+"     "+csk.get(i));
		    }
      }
    }
    else if(tname.equals("mi")){
      mi.put(name,type+"    "+country);
      System.out.println("press 'v' to view the other team members in the bubble");
      char op3=input.next().charAt(0);
      if(op3=='v'){
        for(String i : mi.keySet()){
			    System.out.println("name: "+i+"     "+mi.get(i));
		    }
      }
    }
    else if(tname.equals("srh")){
      srh.put(name,type+"    "+country);
      System.out.println("press 'v' to view the other team members in the bubble");
      char op3=input.next().charAt(0);
      if(op3=='v'){
        for(String i : srh.keySet()){
			    System.out.println("name: "+i+"     "+srh.get(i));
		    }
      }
    }
    else if(tname.equals("dc")){
      dc.put(name,type+"    "+country);
      System.out.println("press 'v' to view the other team members in the bubble");
      char op3=input.next().charAt(0);
      if(op3=='v'){
        for(String i : dc.keySet()){
			    System.out.println("name: "+i+"     "+dc.get(i));
		    }
      }
    }
    else if(tname.equals("kxip")){
      kxip.put(name,type+"    "+country);
      System.out.println("press 'v' to view the other team members in the bubble");
      char op3=input.next().charAt(0);
      if(op3=='v'){
        for(String i : kxip.keySet()){
			    System.out.println("name: "+i+"     "+kxip.get(i));
		    }
      }
    }
    else if(tname.equals("rr")){
      rr.put(name,type+"    "+country);
      System.out.println("press 'v' to view the other team members in the bubble");
      char op3=input.next().charAt(0);
      if(op3=='v'){
        for(String i : rr.keySet()){
			    System.out.println("name: "+i+"     "+rr.get(i));
		    }
      }
    }
    else if(tname.equals("rcb")){
      rcb.put(name,type+"    "+country);
      System.out.println("press 'v' to view the other team members in the bubble");
      char op3=input.next().charAt(0);
      if(op3=='v'){
        for(String i : rcb.keySet()){
			    System.out.println("name: "+i+"     "+rcb.get(i));
		    }
      }
    }
    else if(tname.equals("kkr")){
      kkr.put(name,type+"    "+country);
      System.out.println("press 'v' to view the other team members in the bubble");
      char op3=input.next().charAt(0);
      if(op3=='v'){
        for(String i : kkr.keySet()){
			    System.out.println("name: "+i+"     "+kkr.get(i));
		    }
      }
    }
    home();
  }
  static void start(){
    Scanner input=new Scanner(System.in);
    System.out.println("---------- BIO BUBBLE FOR IPL-2020 -----------\n");
    System.out.println("Who are you?\n");
    System.out.println("1) team member\n2) match official\n3) match operator\n4) ground staff\n5) broadcaster\n6) security personnel\n7) team owner/supporter\n8) board member/guest\n\nenter the number:");
    op=input.nextInt();
    input.nextLine();
    switch(op){
      case 1:
        getdetails();
        System.out.println("enter the type of your play:");
        type=input.nextLine();
        System.out.println("enter your team name:");
        tname=input.nextLine();
        System.out.println("coming from a previous bubble? [y/n]");
        char op1=input.next().charAt(0);
        if(op1=='y'){
          System.out.println("enter the result of covid test (+/-):");
          char op2=input.next().charAt(0);
          if(op2=='+'){
            quarantine();
          }
          else{
            bubble();
          }
        }
        else{
          quarantine();
        }
      
      case 2:
        getdetails();
        covidtest();
        System.out.println("contact match organisers for further information");
        officials.put(name,country);
        view(officials);
        home();
        break;

      case 3:
        getdetails();
        covidtest();
        System.out.println("contact match organisers for further information");
        operators.put(name,country);
        view(operators);
        home();
        break;

      case 4:
        getdetails();
        covidtest();
        System.out.println("contact match organisers for further information");
        gstaff.put(name,country);
        view(gstaff);
        home();
        break;

      case 5:
        getdetails();
        covidtest();
        System.out.println("contact match organisers for further information");
        broadcasters.put(name,country);
        view(broadcasters);
        home();
        break;

      case 6:
        getdetails();
        covidtest();
        System.out.println("contact match organisers for further information");
        personnels.put(name,country);
        view(personnels);
        home();
        break;

      case 7:
        getdetails();
        covidtest();
        System.out.println("you are requested to contact the match administrators regarding the seating allocations in the stadiums.");
        home();
        break;

      case 8:
        getdetails();
        covidtest();
        System.out.println("you are invited to join the guests panel at Dubai.");
        home();
        break;

      default:
        System.out.println("enter valid option");
        break;
    }
  }
  public static void main(String[] args){
    start();
  }
}