package Entity;

import converter.TimeSteamp;

import java.util.Date;

public class Message {
    private String messageid;

    private String senderid;

    private String receiverid;

    private String messagetext;

    private Date messagedate;

    public String getMessageid() {
        return messageid;
    }

    public void setMessageid(String messageid) {
        this.messageid = messageid == null ? null : messageid.trim();
    }

    public String getSenderid() {
        return senderid;
    }

    public void setSenderid(String senderid) {
        this.senderid = senderid == null ? null : senderid.trim();
    }

    public String getReceiverid() {
        return receiverid;
    }

    public void setReceiverid(String receiverid) {
        this.receiverid = receiverid == null ? null : receiverid.trim();
    }

    public String getMessagetext() {
        return messagetext;
    }

    public void setMessagetext(String messagetext) {
        this.messagetext = messagetext == null ? null : messagetext.trim();
    }

    public Date getMessagedate() {
        return messagedate;
    }

    public void setMessagedate(TimeSteamp messagedate) {
        this.messagedate = messagedate;
    }
}