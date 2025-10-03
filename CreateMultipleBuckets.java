import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import com.google.cloud.storage.BucketInfo;
import java.util.UUID;

public class CreateMultipleBuckets {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: java CreateMultipleBuckets <project-prefix>");
            return;
        }
        String prefix = args[0].toLowerCase();

        Storage storage = StorageOptions.getDefaultInstance().getService();

        for (int i = 1; i <= 50; i++) {
            String bucketName = String.format("%s-%02d-%s", prefix, i, UUID.randomUUID().toString().replaceAll("-", ""));
            try {
                storage.create(BucketInfo.of(bucketName));
                System.out.println("Created bucket: " + bucketName);
            } catch (Exception e) {
                System.err.println("Failed to create bucket " + bucketName + ": " + e.getMessage());
            }
        }
    }
}