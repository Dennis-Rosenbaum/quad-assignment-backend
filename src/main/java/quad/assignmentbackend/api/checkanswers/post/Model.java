package quad.assignmentbackend.api.checkanswers.post;

public class Model {

    private final Boolean result;

    public Model(Boolean result)
    {
        this.result =  result;
    }

    public Boolean getResult() {
        return result;
    }
}
