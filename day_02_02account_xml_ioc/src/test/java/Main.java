import com.yoyling.service.AccountService;
import com.yoyling.service.impl.AccountServiceImpl;

public class Main {
    public static void main(String[] args) {
        AccountService service = new AccountServiceImpl();
        service.findAllAccount();
    }
}
