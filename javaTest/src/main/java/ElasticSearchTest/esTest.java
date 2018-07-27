package ElasticSearchTest;


import io.searchbox.client.JestClient;
import io.searchbox.client.JestClientFactory;
import io.searchbox.client.config.HttpClientConfig;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import org.elasticsearch.common.xcontent.XContentBuilder;

import java.io.IOException;

import static org.elasticsearch.common.xcontent.XContentFactory.jsonBuilder;


public class esTest {
    public static void main(String[] args) throws IOException {

        XContentBuilder builder = jsonBuilder()
                .startObject()
                    .field("food", "Roti Prata")
                    .array("tags", new String [] {"curry","cherry"})
                    .startObject("favorite")
                        .field("location", "Tiong Bahru")
                        .field("price", 2.00)
                        .array("addr", new String [] {"south","north"})
                        .endObject()
                .endObject();

        System.out.println(builder.string());


        JestClientFactory factory = new JestClientFactory();
        factory.setHttpClientConfig(new HttpClientConfig
                .Builder("http://localhost:9200")
                .multiThreaded(true)
                .build());

        JestClient client = factory.getObject();


        String query = jsonStringThatMagicallyAppears;

        Search search = new Search.Builder(query)
                .addIndex("library")
                .build();
        SearchResult result = client.execute(search);


    }

}
