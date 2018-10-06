public class TgAppMsg extends AppMsg {
    
    public TgAppMsg(Mediator m, String otherChatId, String thisChatId) {
       
        if (thisChatId.substring(0, 2) != "TG") {
            System.out.println("This chat id is not valid. Setting it as null.");
            thisChatId = null;
        }

        if (otherChatId.substring(0, 2) != "WP") {
            System.out.println("Other chat id is not valid. Setting it as null.");
            otherChatId = null;
        }

        super(m, otherChatId, thisChatId);
    }

    @Override
    public void receiveMsg(String msg) {
        System.out.println("Telegram <" + thisPlatformChatId + ">: " + msg);
    }
}