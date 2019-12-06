package kt.node;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * 1.每一个node都是一个完全独立的进程
 * 2.考虑到node之间一旦建立连接就开始通信，这个时候service可能还没准备好，所以node得等自己身上所有的service都准备好以后才可以启动
 */
public class Node {

    private final String id;
    private final String addrIp;
    private final int addrPort;

    private final ConcurrentMap<String, Port> children = new ConcurrentHashMap<String, Port>();

    public Node(String id, String addrIp, int addrPort) {
        this.id = id;
        this.addrIp = addrIp;
        this.addrPort = addrPort;
    }

    public void addPort(Port port) {
        port.setParentNode(this);
        children.put(port.getPortId(), port);
    }

    public Port getByPortId(String portId) {
        return children.get(portId);
    }

}
