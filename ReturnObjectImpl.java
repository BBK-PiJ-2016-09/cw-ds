public class ReturnObjectImpl implements ReturnObject {

    private ErrorMessage errorMessage;
    private Object object;

    public ReturnObjectImpl (ErrorMessage errorMessage) {
        this.errorMessage = errorMessage;
    }

    public ReturnObjectImpl (Object obj) {
        this.object = obj;
        this.errorMessage = ErrorMessage.NO_ERROR;
    }

    public boolean hasError() {
        return (this.errorMessage != ErrorMessage.NO_ERROR);
    }

    public ErrorMessage getError() {
        return hasError() ? this.errorMessage : ErrorMessage.NO_ERROR;
    }


    public Object getReturnValue() {
        return hasError() ? null : object;
    }

}