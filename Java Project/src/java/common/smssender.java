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
        final String accountSid = ""; //Get your accoundSID from Twilio and Use It
        final String authToken = ""; //Get your authToken from Twilio and Use It
        Twilio.init(accountSid,authToken);
        
        try{
            Message message;
        message = Message.creator(
                new PhoneNumber(num),
                new PhoneNumber(""),msg) //Get your outgoing number from Twilio and Use It
                .create();
        System.out.println("Done");
        }
        catch(Exception e){
        }
    }
}