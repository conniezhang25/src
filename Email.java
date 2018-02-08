/*
Name:Connie Zhang
Period:2
Date:12/14/16
Lab:Email
*/
public class Email
{
   private String myUserName;
   private String myHostName;
   private String myExtension;
   public Email(String address)
   {
      myUserName = address.substring(0,address.indexOf('@'));
      myHostName = address.substring(address.indexOf('@')+1, address.indexOf('.'));
      myExtension = address.substring(address.indexOf('.'));
      
   }
   public String getUserName()
   {
      return myUserName;
   }
   public String getHostName()
   {
      return myHostName;
   }
   public String getExtension()
   {
      return myExtension;
   }
   public String toString()
   {
      return getUserName() + getHostName() + getExtension();
   }
   
   
}
