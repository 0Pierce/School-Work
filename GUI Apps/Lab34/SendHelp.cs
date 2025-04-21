using System;
using System.Collections.Generic;
using System.Linq;
using System.Security.Policy;
using System.Text;
using System.Threading.Tasks;

namespace Lab34
{

    public class Publisher //publisher
    {
        public delegate void PublishMessageDel(string msg); //delegate

        public PublishMessageDel publishmsg = null; // create obj from dlegate data type

        public void PublishMessage(string msg)
        { publishmsg.Invoke(msg); }

    }

    public class SendViaEmail
    {
        public string EmailAddr { set; get; } //property
        public SendViaEmail() { } //constructor 1
        public SendViaEmail(string emailAddr) { EmailAddr = emailAddr; } //constructor 2

        //create Method match publisher delegate
        public void sendEMail(string msg)
        { Console.WriteLine("We send this message (" + msg + ") to you via your email " + EmailAddr); }

        //create a method to join publisher delegate 
        public void Sub(Publisher pub)
        { pub.publishmsg += sendEMail; }
        //create a method to disjoin publisher delegate 
        public void UnSub(Publisher pub)
        { pub.publishmsg -= sendEMail; }

    }

    //Subscriber2 
    public class SendViaPhone
    {
        public string PhoneNumber { set; get; } 
        public SendViaPhone() { } 
        public SendViaPhone(string phoneNumber) { PhoneNumber = PhoneNumber; } 

        
        public void sendText(string msg)
        { Console.WriteLine("We send this message (" + msg + ") to you via your email " + PhoneNumber); }

        
        public void Sub(Publisher pub)
        { pub.publishmsg += sendText; }
        
        public void UnSub(Publisher pub)
        { pub.publishmsg -= sendText; }

    }
}
