import controllers.SupportController;
import controllers.SupportControllerImpl;
import dataBase.DataBase;
import exceptions.NoSuchRequestException;
import models.SupportRequest;
import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class TestSupportController {

    private static DataBase db  = DataBase.getInstance();
    private static SupportController controller = new SupportControllerImpl();
    private static SupportRequest request1, request2;

    @BeforeClass
    public static void initDB() {
        request1 = new SupportRequest("shalamay.vlad44@gmail.com", "question 1");
        request2 = new SupportRequest("maks@gmail.com", "question 2");

        db.supportRequests.add(request1);
        db.supportRequests.add(request2);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testShowAllRequests(){

        assertTrue(controller.showAllRequests().contains(request1));
        assertTrue(controller.showAllRequests().contains(request2));
        assertEquals(2, controller.showAllRequests().size());
        controller.showAllRequests().get(3);

    }


    @Test(expected = NoSuchRequestException.class)
    public void negativeTestReply() throws NoSuchRequestException{

        controller.reply(new SupportRequest("shalamay@gmail.com", "wtf?"), "answer");
    }

}
