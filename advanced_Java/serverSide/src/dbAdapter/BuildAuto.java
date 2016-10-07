package dbAdapter;

import Adapter.CreateAuto;
import Adapter.UpdateAuto;
import Adapter.proxyAutomobile;
import server.AutoServer;

public class BuildAuto extends DbProxyAutomotive implements UpdateAuto, CreateAuto, AutoServer{

}
