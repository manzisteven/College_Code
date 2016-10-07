package Adapter;

import Adapter.CreateAuto;
import Adapter.UpdateAuto;
import Adapter.proxyAutomobile;
import server.AutoServer;

public class BuildAuto extends proxyAutomobile implements UpdateAuto, CreateAuto, AutoServer{

}
