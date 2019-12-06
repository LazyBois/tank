package kt.node;

public abstract class Service {

    private Port parentPort;

    public Service() {
    }

    /**
     * 初始化时不得依赖其他模块
     */
    public void init(Port parentPort) {
        this.parentPort = parentPort;
    }

    public String getId() {
        ServiceInfo info = this.getClass().getAnnotation(ServiceInfo.class);
        return info.id();
    }

    public static Service createInstance(Class<? extends Service> serviceClass) {
        Service result = null;
        try {
            result = serviceClass.getDeclaredConstructor().newInstance();
        } catch (Exception e) {

        }

        return result;
    }
}
