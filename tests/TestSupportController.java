import controllers.SupportController;
import controllers.SupportControllerImpl;
import dataBase.DataBase;
import models.SupportRequest;
import static org.junit.Assert.*;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class TestSupportController {



    @Test(expected = IndexOutOfBoundsException.class)
    public void testShowAllRequests(){
        SupportController controller = new SupportControllerImpl();
        DataBase mock  = DataBase.getInstance();

        SupportRequest request1 = new SupportRequest("vlad@gmail.com", "question 1");
        SupportRequest request2 = new SupportRequest("maks@gmail.com", "question 2");

        mock.supportRequests.add(request1);
        mock.supportRequests.add(request2);

        assertEquals(request1, controller.showAllRequests().get(0));
        assertEquals(request2, controller.showAllRequests().get(1));
        assertEquals(2, controller.showAllRequests().size());
        controller.showAllRequests().get(3);

    }

}
