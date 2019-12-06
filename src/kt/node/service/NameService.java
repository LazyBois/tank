package kt.node.service;

import kt.node.Port;
import kt.node.ServiceInfo;
import kt.node.Service;

import java.util.HashSet;
import java.util.Set;

@ServiceInfo(id = "name")
public class NameService extends Service {
    private Set<String> names = new HashSet<>();

    /**
     * 初始化
     */
    @Override
    public void init(Port parentPort) {
        super.init(parentPort);

        names.add("wangtong");
    }
}
