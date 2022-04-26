package xbuhari.pw.PHReplacer.plugin;

import java.util.HashMap;
import java.util.List;

public class PHRText {

    private final String id;
    private final String placeholder;
    private final HashMap<String, String> replaces;
    private final Boolean req_player;

    public PHRText(String id, String ph, HashMap<String, String> _rep, Boolean _req) {
        this.id = id;
        this.placeholder = ph;
        this.replaces = (HashMap<String, String>) _rep.clone();
        this.req_player = _req;
    }

    public HashMap<String, String> getReplaces() {
        return replaces;
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
