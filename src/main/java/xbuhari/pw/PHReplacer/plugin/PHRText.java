package xbuhari.pw.PHReplacer.plugin;

public class PHRText {
    private final String id;
    private final String placeholder;
    private final String old_text;
    private final String new_text;
    private final Boolean req_player;

    public PHRText(String id, String ph, String _old, String _new, Boolean _req) {
        this.id = id;
        this.placeholder = ph;
        this.old_text = _old;
        this.new_text = _new;
        this.req_player = _req;
    }

    public String getNew_text() {
        return new_text;
    }

    public String getOld_text() {
        return old_text;
    }

    public Boolean getReq_player() {
        return req_player;
    }

    public String getPlaceholder() {
        return placeholder;
    }

    public String getId() {
        return id;
    }
}
