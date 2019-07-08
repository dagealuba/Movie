package Entity;

public class Invition {
    private String inviter;

    private String invitee;

    private String spaceid;

    private Integer status;//default = 0 未读 ， 1 同意 ， -1 拒绝

    public String getInviter() {
        return inviter;
    }

    public void setInviter(String inviter) {
        this.inviter = inviter == null ? null : inviter.trim();
    }

    public String getInvitee() {
        return invitee;
    }

    public void setInvitee(String invitee) {
        this.invitee = invitee == null ? null : invitee.trim();
    }

    public String getSpaceid() {
        return spaceid;
    }

    public void setSpaceid(String spaceid) {
        this.spaceid = spaceid == null ? null : spaceid.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}