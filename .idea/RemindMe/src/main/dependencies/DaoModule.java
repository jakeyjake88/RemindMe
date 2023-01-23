import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DaoModule {
    @Singleton
    @Provides
    public DynamoDBMapper provideDynamoDBMapper() {
        return new DynamoDBMapper(DynamoDBClientProvider.getDynamoDBClient(Regions.US_EAST_2));
    }
}
