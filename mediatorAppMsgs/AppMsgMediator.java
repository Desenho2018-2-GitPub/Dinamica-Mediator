public class AppMsgMediator implements Mediator {
 
    protected ArrayList<AppMsg> destinations;
 
    public AppMsgMediator() {
        destinations = new ArrayList<AppMsg>();
    }
 
    public void addAppMsg(AppMsg appMsg) {
        destinations.add(appMsg);
    }
 
    @Override
    public void send(String msg, AppMsg appMsg) {
        for (AppMsg destinationAppMsg : destinations) {
            String formattedMsg = setPrefix(destinationAppMsg, msg);
            appMsg.receiveMsg(formattedMsg); 
        }
    }
 
    private String setPrefix(AppMsg appMsg, String msg) {
        if (appMsg instanceof WppAppMsg) {
            return "(Message for WhatsApp) " + msg;
        } else if (appMsg instanceof TgAppMsg) {
            return "(Message for Telegram) " + msg;
        }
    }
}