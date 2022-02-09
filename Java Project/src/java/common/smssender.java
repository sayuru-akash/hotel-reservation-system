/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class smssender{    
    public static void deliver(String num, String msg){
        final String accountSid = "AC44f2d2763a3ba6446f5ad42debf55570";
        final String authToken = "c39ac6b7ca1368db2727f0535dae3592";
        Twilio.init(accountSid,authToken);
        
        try{
            Message message;
        message = Message.creator(
                new PhoneNumber(num),
                new PhoneNumber("+16065540872"),msg)
                .create();
        System.out.println("Done");
        }
        catch(Exception e){
        }
    }
}

//whatsapp:+14155238886 wa-sms sender
//+16065540872 sms sender