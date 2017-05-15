package hello;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class NotificationsController {

    private final Map<String, Object> requests = new HashMap<>();

    @RequestMapping(value = "/notifications", method = RequestMethod.GET, produces = "application/json")
    public Map<String, Object> getNotifications() {
        return requests;
    }

    @RequestMapping(value = "/notifications/{id}", method = RequestMethod.GET, consumes = "application/json", produces = "application/text")
    public Object getNotification(@PathVariable String id) {
        return requests.get(id);
    }

    @RequestMapping(value = "/notifications", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void clearNotifications() {
        requests.clear();
    }

    @RequestMapping(value = "/notifications", method = RequestMethod.POST, consumes = "application/json", produces = "application/text")
    public String addNotification(@RequestBody Object body) {
        final String notificationAsString = body.toString();
        final int pspReferenceIndex = notificationAsString.indexOf("pspReference=");
        final int pspReferenceValueIndex = pspReferenceIndex + "pspReference=".length();
        final String pspReferenceValue = notificationAsString.substring(pspReferenceValueIndex, pspReferenceValueIndex + 16);

        System.out.println(pspReferenceValue);
        requests.put(pspReferenceValue, body);

        return "[accepted]";
    }
}