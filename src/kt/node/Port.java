package kt.node;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Port {
    private Node parentNode;

    private final String portId;

    private final Map<String, Service> children = new ConcurrentHashMap<>();

    public Port(String portId) {
        this.portId = portId;
    }

    public void addChilds(Class<? extends Service> serviceClass) {
        Service service = Service.createInstance(serviceClass);
        service.init(this);
        children.put(service.getId(), service);
    }

    public Service getByServiceId(String serviceId) {
        return children.get(serviceId);
    }

    public String getPortId() {
        return portId;
    }


    public Node getParentNode() {
        return parentNode;
    }

    protected void setParentNode(Node parentNode) {
        this.parentNode = parentNode;
    }
}
