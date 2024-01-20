import com.tfs.dxconfig.DXConfig;

public class MainTest {
    public static void main(String[] args) {
        DXConfig<MyConfig> configReader = new DXConfig<>(MyConfig.class, "./data/config.json");
        System.out.println(configReader.getValue("valA").getAsInt());
    }
}
