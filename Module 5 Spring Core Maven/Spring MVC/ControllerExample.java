import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ControllerEx {

    @RequestMapping("/home")
    @ResponseBody
    public String home() {

        // creating model object
        ModelEx model = new ModelEx("Vineela");

        // normally this goes to view, but here we return as string
        return "User: " + model.getUser() + 
               " | Message: " + model.getMessage();
    }

    @RequestMapping("/details")
    @ResponseBody
    public String details() {

        ModelEx model = new ModelEx("Student");

        return "Details Page -> " + model.getMessage();
    }
}