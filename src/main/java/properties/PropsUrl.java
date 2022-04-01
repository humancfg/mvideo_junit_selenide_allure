package properties;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "file:src/test/resources/url.properties"
})
public interface PropsUrl extends Config {
    @Key("base.url.mvideo")
    String baseUrlMVideo();

    @Key("cart.page.uri")
    String cartPageUri();
}
