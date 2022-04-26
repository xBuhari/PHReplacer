package xbuhari.pw.PHReplacer.spigot;

import java.util.HashMap;
import java.util.Map;

public class Utils {

    public static String replaced(String str, HashMap<String, String> replacer) {
        String _last = str;
        System.out.println(str + " " + replacer);
        for (Map.Entry<String, String> _key : replacer.entrySet()) {
            String _1 = _key.getKey();
            String _2 = _key.getValue();
            if (_1.startsWith("$all$")) {
                _last = _2;
                continue;
            }
            if (_1.startsWith("$regex$_")) {
                _last = _last.replaceAll(_1.replace("$regex$_", ""), _2);
                continue;
            }
            _last = _last.replace(_1, _2);
        }
        return _last;
    }

}
