public class ReturnObjectImpl implements ReturnObject {

    private ErrorMessage errorMessage;
    private Object object;

    public ReturnObjectImpl (ErrorMessage errorMessage) {
        errorMessage = errorMessage;
    }

    public ReturnObjectImpl (Object obj) {
        object = obj;
        errorMessage = ErrorMessage.NO_ERROR;
    }

    public boolean hasError() {
        return (errorMessage != ErrorMessage.NO_ERROR);
    }

    public ErrorMessage getError() {
        return hasError() ? errorMessage : ErrorMessage.NO_ERROR;
    }


    public Object getReturnValue() {
        return hasError() ? null : object;
    }

}