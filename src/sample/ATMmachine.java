package sample;



import java.util.HashMap;





public class ATMmachine {
     private int i=0;

    public int getI() {
        return i;
    }

    String[] arr1 = new String[5];



   public void setData(String type) {


       int count=4;
       while (count>0){
           arr1[count]=arr1[count-1];
           count--;
       }

       arr1[0]=type;

    }



public String showPrevNext(int index){

      if(index<0||index>4){

          String z="you didn't do an operation yet !";
          return z;

      }
        return arr1[index];
}

    HashMap userInformation;
    private int balance ;



    public int getBalance()
    {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public ATMmachine() {







        userInformation= new HashMap();
        userInformation.put("554466778899112233","5444");


    }

	public  void deposit(int depositNumber) {


balance=balance+depositNumber;



        setData(" You Deposit money :" + depositNumber);



	}

	 public void withdraw(int withdrawNumber) {


         int x = withdrawNumber;
         if (balance >= withdrawNumber) {
             balance = balance - withdrawNumber;

             setData(" You withdraw money :" + withdrawNumber);
         }
     }


	 public void balanceInquiry(){

         setData(" you asked about your balance which is : "+ getBalance());




	 }
	 public void exit(){

        System.exit(0);
     }



    public boolean validate(String cardnumber,String Password) {
        boolean result;

        String checkCard= (String) userInformation.get(cardnumber);
        if(checkCard !=null) {
            result= checkCard.equals(Password);

        } else {result=false;

        } return result;

    }



}

