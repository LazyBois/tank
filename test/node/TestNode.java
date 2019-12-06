package node;

import kt.node.Node;
import kt.node.Port;
import kt.node.service.NameService;

public class TestNode {

    public static void main(String[] args) {
        String nameNodeId = "name";
        String nameNodeAddrIp = "127.0.0.1";
        int nameNodeAddrPort = 12001;

        Port namePort = new Port("");
        namePort.addChilds(NameService.class);
        // 考虑到node之间一旦建立连接就开始通信，这个时候service可能还没准备好，所以node得等自己身上所有的service都准备好以后才可以启动
        Node nameNode = new Node(nameNodeId, nameNodeAddrIp, nameNodeAddrPort);
        nameNode.addPort(namePort);
//        nameNode.addPort();
    }

    public static void initPort(){

    }
}
