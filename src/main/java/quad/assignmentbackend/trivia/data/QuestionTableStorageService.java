package quad.assignmentbackend.trivia.data;

import com.azure.data.tables.models.TableServiceException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.azure.data.tables.TableClient;
import com.azure.data.tables.TableClientBuilder;
import com.azure.data.tables.models.TableEntity;

@Service
public class QuestionTableStorageService {

    private final TableClient tableClient;

    public QuestionTableStorageService(@Value("${azure.table.storage.connection_string}") String connectionString) {
        this.tableClient = new TableClientBuilder()
                .connectionString(connectionString)
                .tableName("questions")
                .buildClient();
    }

    public void insertEntity(String questionId, String answerId) {
        TableEntity tableEntity = new TableEntity(questionId, answerId);
        tableClient.createEntity(tableEntity);
    }

    public Boolean entityExists(String questionId, String answerId) {
        try {
            tableClient.getEntity(questionId, answerId);
            return true;
        } catch (TableServiceException e) {
            if (e.getResponse().getStatusCode() == 404) {
                return false;
            }
            throw e;
        }
    }
}